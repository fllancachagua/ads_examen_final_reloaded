package scholarship.student.application;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scholarship.common.application.Notification;
import scholarship.student.domain.entity.Student;
import scholarship.student.domain.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Transactional
	public Student getScholarshipAmount(long id) throws Exception {
		Notification notification = this.validation(id);
		if (notification.hasErrors()) {
			throw new IllegalArgumentException(notification.errorMessage());
		}
		Student student = this.studentRepository.findById(id);
		return student;
	}		
	
	private Notification validation(long studentId) {
		Notification notification = new Notification();
		if (studentId <= 0) {
			notification.addError("Customer id must be greater than zero.");
		}
		return notification;
	}	
}
