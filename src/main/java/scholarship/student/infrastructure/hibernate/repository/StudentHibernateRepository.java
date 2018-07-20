package scholarship.student.infrastructure.hibernate.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import scholarship.common.application.enumeration.StudentType;
import scholarship.doctorate.domain.entity.PhdStudent;
import scholarship.master.domain.entity.MasterStudent;
import scholarship.student.domain.entity.Student;
import scholarship.student.domain.repository.StudentRepository;
import scholarship.undergraduate.domain.entity.UndergraduatedStudent;

@Repository
public class StudentHibernateRepository implements StudentRepository {
	
	private List<Student> phdStudents;
	private List<Student> masterStudents;
	private List<Student> undergraduatedStudents;
	private List<Student> allStudents;

	public StudentHibernateRepository () {
		phdStudents= new ArrayList<>();
		phdStudents.add(new PhdStudent(1L, "Felipe","Llancachagua"));
		phdStudents.add(new PhdStudent(2L, "Julio","Stalin"));
		phdStudents.add(new PhdStudent(3L, "German","Goering"));

		masterStudents= new ArrayList<>();
		masterStudents.add(new MasterStudent(4L, "Alfonso","Higuairan"));
		masterStudents.add(new MasterStudent(5L, "Luca","Modric"));
		masterStudents.add(new MasterStudent(6L, "Antony","Griezman"));

		undergraduatedStudents= new ArrayList<>();
		undergraduatedStudents.add(new UndergraduatedStudent(6L, "Irvin","Berlin"));
		undergraduatedStudents.add(new UndergraduatedStudent(7L, "Joe","Maggio"));
		undergraduatedStudents.add(new UndergraduatedStudent(8L, "Maria","Miranda"));		
		undergraduatedStudents.add(new UndergraduatedStudent(9L, "Jose","Grau"));		
	}
	
	@Override
	public Student findById(long id) {
		return null;
	}
	
	
	@Override
	public List<Student> findByStudentType(String studentType) {
		if (studentType.equals(StudentType.UNDERGRADUATED_STUDENT.toString())) return undergraduatedStudents;
		if (studentType.equals(StudentType.MASTER_STUDENT.toString())) return masterStudents;
		if (studentType.equals(StudentType.PHD_STUDENT.toString())) return phdStudents;
		if (studentType.equals(StudentType.ALL_STUDENT.toString())) {joinListStudents();return allStudents;}
		return null;
	}
	
	public void joinListStudents() {
		allStudents = new ArrayList<>();
		allStudents.addAll(phdStudents);
		allStudents.addAll(masterStudents);
		allStudents.addAll(undergraduatedStudents);
	}
	

	



}
