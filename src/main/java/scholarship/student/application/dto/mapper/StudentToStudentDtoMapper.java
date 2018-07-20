package scholarship.student.application.dto.mapper;

import scholarship.student.application.dto.StudentDto;
import scholarship.student.domain.entity.Student;

public class StudentToStudentDtoMapper {

	public StudentDto mapper(Student student) {
		StudentDto dto = new StudentDto(student.getId(), student.getFirstName(), student.getLastName(), student.getScholarshipAmount());
		return dto;
	}	
}
