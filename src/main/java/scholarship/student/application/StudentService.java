package scholarship.student.application;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scholarship.common.application.Notification;
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
	public ListStudentResponse<StudentDto> findStudents(String studentType) throws Exception {
		Notification notification = this.validationList(studentType);
		if (notification.hasErrors()) {
			throw new IllegalArgumentException(notification.errorMessage());
		}
		List<Student> students = this.studentRepository.findByStudentType(studentType);
		if (students == null || students.size() == 0) {
			return null;
		}
		BigDecimal scholarshipAmount = this.getScholarshipAmount(studentType).getAmount();
		ListStudentResponse<StudentDto> response = new ListStudentResponse<StudentDto>(
				studentDtoMapper.mapper(students),scholarshipAmount,studentType);

		return response;
	}

	private Notification validation(String studentType) {
		Notification notification = new Notification();
		if (!studentType.equals(StudentType.MASTER_STUDENT.toString())
				&& !studentType.equals(StudentType.UNDERGRADUATED_STUDENT.toString())
				&& !studentType.equals(StudentType.PHD_STUDENT.toString())) {
			notification.addError("Student type invalid!.");
		}
		return notification;
	}
	
	private Notification validationList(String studentType) {
		Notification notification = new Notification();
		if (!studentType.equals(StudentType.MASTER_STUDENT.toString())
				&& !studentType.equals(StudentType.UNDERGRADUATED_STUDENT.toString())
				&& !studentType.equals(StudentType.PHD_STUDENT.toString())
				&& !studentType.equals(StudentType.ALL_STUDENT.toString())) {
			notification.addError("Student type invalid!. Permitted values: phd/undergraduated/master");
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
