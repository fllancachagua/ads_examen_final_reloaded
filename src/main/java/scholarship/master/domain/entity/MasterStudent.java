package scholarship.master.domain.entity;

import org.springframework.stereotype.Component;

import scholarship.student.domain.entity.Student;

@Component
public class MasterStudent extends Student {
	public MasterStudent() {
		super();
	}	
	
	public MasterStudent(Long id, String firstName, String lastName) {
		super(id,firstName,lastName);
	}	

}
