package scholarship.student.application.dto.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import scholarship.student.application.dto.StudentDto;
import scholarship.student.domain.entity.Student;

@Component
public class StudentToStudentDtoMapper {

	public StudentDto mapper(Student student) {
		StudentDto dto = new StudentDto(student.getId(), student.getFirstName(), student.getLastName());
		return dto;
	}

	public List<StudentDto> mapper(List<Student> students) {
		List<StudentDto> lstStudent = new ArrayList<>();
		for (Student student : students) {
			lstStudent.add(mapper(student));
		}
		return lstStudent;
	}
}
