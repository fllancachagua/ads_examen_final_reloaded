package scholarship.student.infrastructure.hibernate.repository;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import scholarship.student.domain.entity.Student;
import scholarship.student.domain.repository.StudentRepository;

@Repository
public class StudentHibernateRepository implements StudentRepository {

	private Set<Student> students;
	
	public StudentHibernateRepository () {
		students= new HashSet<>();
		students.add(new Student(1L, "Felipe","Llancachagua",new BigDecimal(100)));
		students.add(new Student(2L, "Roberto","Palacios",new BigDecimal(200)));
		students.add(new Student(3L, "Juan","Perez",new BigDecimal(300)));
		students.add(new Student(4L, "Ernesto","Cardenas",new BigDecimal(400)));
		
	}
	
	@Override
	public Student findById(long id) {
		for(Student s :students) {
			if(s.getId()==id) {
				return s;
			}
		}
		return null;
	}

	@Override
	public List<Student> findAllPaginated(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student findByDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Student customer) {
		// TODO Auto-generated method stub
		
	}

}
