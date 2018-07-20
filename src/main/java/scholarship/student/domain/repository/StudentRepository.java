package scholarship.student.domain.repository;

import java.util.List;

import scholarship.student.domain.entity.Student;

public interface StudentRepository {
	Student findById(long id);
	List<Student> findByStudentType(String studentType);
}

