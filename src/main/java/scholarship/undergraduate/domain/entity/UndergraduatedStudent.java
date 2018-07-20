package scholarship.undergraduate.domain.entity;

import org.springframework.stereotype.Component;

import scholarship.student.domain.entity.Student;

@Component
public class UndergraduatedStudent extends Student {
	public UndergraduatedStudent() {
		super();
	}

	public UndergraduatedStudent(Long id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}

}
