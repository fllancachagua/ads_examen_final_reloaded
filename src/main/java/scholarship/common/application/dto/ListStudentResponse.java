package scholarship.common.application.dto;

import java.math.BigDecimal;
import java.util.List;

public class ListStudentResponse<T> {
	private String studentType;
	private BigDecimal scholarshipAmount;
	private List<T> students;
	
	public ListStudentResponse(List<T> content,BigDecimal scholarshipAmount,String studentType) {
		this.studentType = studentType;
		this.students = content;
		this.scholarshipAmount = scholarshipAmount;
	}

	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}

	public BigDecimal getScholarshipAmount() {
		return scholarshipAmount;
	}

	public void setScholarshipAmount(BigDecimal scholarshipAmount) {
		this.scholarshipAmount = scholarshipAmount;
	}

	public List<T> getStudents() {
		return students;
	}

	public void setStudents(List<T> students) {
		this.students = students;
	}
	
	
}
