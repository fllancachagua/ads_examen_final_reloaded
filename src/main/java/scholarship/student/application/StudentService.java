package scholarship.student.application;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scholarship.common.application.Notification;
import scholarship.common.application.dto.ListGeneralResponse;
import scholarship.common.application.dto.ListStudentResponse;
import scholarship.common.application.dto.ScholarshipAmountResponse;
import scholarship.common.application.enumeration.StudentType;
import scholarship.student.application.dto.StudentDto;
import scholarship.student.application.dto.mapper.StudentToStudentDtoMapper;
import scholarship.student.domain.entity.Student;
import scholarship.student.domain.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	StudentToStudentDtoMapper studentDtoMapper;

	@Transactional
	public ScholarshipAmountResponse getScholarshipAmount(String studentType) throws Exception {
		Notification notification = this.validation(studentType);
		if (notification.hasErrors()) {
			throw new IllegalArgumentException(notification.errorMessage());
		}

		BigDecimal amount = this.calculateScholarshipAmount(studentType);
		return new ScholarshipAmountResponse(studentType, amount);
	}

	@Transactional
	public ListGeneralResponse findStudents(String studentType) throws Exception {
		ListGeneralResponse response = new ListGeneralResponse();
		Notification notification = this.validation(studentType);
		if (notification.hasErrors()) {
			throw new IllegalArgumentException(notification.errorMessage());
		}
		if (!studentType.equals(StudentType.ALL_STUDENT.toString())){
			List<Student> students = this.studentRepository.findByStudentType(studentType);
			if (students == null || students.size() == 0) {return null;}
			BigDecimal scholarshipAmount = this.getScholarshipAmount(studentType).getAmount();
			//ListStudentResponse<StudentDto> response = new ListStudentResponse<StudentDto>(studentDtoMapper.mapper(students),scholarshipAmount,studentType);
			response.getListStudents().add(new ListStudentResponse<StudentDto>(studentDtoMapper.mapper(students),scholarshipAmount,studentType));
		}else {
			List<Student> studentsPhd = this.studentRepository.findByStudentType(StudentType.PHD_STUDENT.toString());
			if (studentsPhd == null || studentsPhd.size() == 0) {return null;}
			BigDecimal scholarshipAmountPhd = this.getScholarshipAmount(StudentType.PHD_STUDENT.toString()).getAmount();
			ListStudentResponse<StudentDto> responsePhd = new ListStudentResponse<StudentDto>(studentDtoMapper.mapper(studentsPhd),scholarshipAmountPhd,StudentType.PHD_STUDENT.toString());

			List<Student> studentsMaster = this.studentRepository.findByStudentType(StudentType.MASTER_STUDENT.toString());
			if (studentsMaster == null || studentsMaster.size() == 0) {return null;}
			BigDecimal scholarshipAmountMaster = this.getScholarshipAmount(StudentType.MASTER_STUDENT.toString()).getAmount();
			ListStudentResponse<StudentDto> responseMaster = new ListStudentResponse<StudentDto>(studentDtoMapper.mapper(studentsMaster),scholarshipAmountMaster,StudentType.MASTER_STUDENT.toString());

			List<Student> studentsUndergraduated = this.studentRepository.findByStudentType(StudentType.UNDERGRADUATED_STUDENT.toString());
			if (studentsUndergraduated == null || studentsUndergraduated.size() == 0) {return null;}
			BigDecimal scholarshipAmountUndergraduated = this.getScholarshipAmount(StudentType.UNDERGRADUATED_STUDENT.toString()).getAmount();
			ListStudentResponse<StudentDto> responseUndergraduated = new ListStudentResponse<StudentDto>(studentDtoMapper.mapper(studentsUndergraduated),scholarshipAmountUndergraduated,StudentType.UNDERGRADUATED_STUDENT.toString());
			
			response.getListStudents().add(responsePhd);
			response.getListStudents().add(responseMaster);
			response.getListStudents().add(responseUndergraduated);
		}

		return response;
	}
//
//	private Notification validation(String studentType) {
//		Notification notification = new Notification();
//		if (!studentType.equals(StudentType.MASTER_STUDENT.toString())
//				&& !studentType.equals(StudentType.UNDERGRADUATED_STUDENT.toString())
//				&& !studentType.equals(StudentType.PHD_STUDENT.toString())) {
//			notification.addError("Student type invalid!. Permitted values: phd/undergraduated/master");
//		}
//		return notification;
//	}
	
	private Notification validation(String studentType) {
		Notification notification = new Notification();
		if (	   !studentType.equals(StudentType.MASTER_STUDENT.toString())
				&& !studentType.equals(StudentType.UNDERGRADUATED_STUDENT.toString())
				&& !studentType.equals(StudentType.PHD_STUDENT.toString())
				&& !studentType.equals(StudentType.ALL_STUDENT.toString())
		  ) {
			notification.addError("Student type invalid!. Permitted values: all/phd/undergraduated/master");
		}
		return notification;
	}	

	private BigDecimal calculateScholarshipAmount(String studentType) {
		if (studentType.equals(StudentType.UNDERGRADUATED_STUDENT.toString())) return new BigDecimal(10000.00);
		if (studentType.equals(StudentType.MASTER_STUDENT.toString()))  return new BigDecimal(20000.00);
		if (studentType.equals(StudentType.PHD_STUDENT.toString())) return new BigDecimal(30000.00);
		return new BigDecimal(0.0);
	}

}
