package scholarship.student.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import scholarship.student.domain.entity.Student;

public interface StudentRepository {
	Student findById(long id);
	List<Student> findAllPaginated(int pageNumber, int pageSize);
	long countAll();
	Student findByDni(String dni);
	void save(Student customer);
}

