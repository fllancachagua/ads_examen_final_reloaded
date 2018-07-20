package scholarship.doctorate.domain.entity;

import org.springframework.stereotype.Component;

import scholarship.student.domain.entity.Student;

@Component
public class PhdStudent extends Student {

	public PhdStudent() {
		super();
	}	
	
	public PhdStudent(Long id, String firstName, String lastName) {
		super(id,firstName,lastName);
	}	
}
