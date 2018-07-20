package scholarship.student.domain.entity;

import java.math.BigDecimal;

public   class Student {
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	private String firstName;
	private String lastName;
	private BigDecimal scholarshipAmount;
	
	public Student() {
	}	

	public Student(Long id, String firstName, String lastName, BigDecimal scholarshipAmount) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.scholarshipAmount = scholarshipAmount;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public BigDecimal getScholarshipAmount() {
		return scholarshipAmount;
	}
	public void setScholarshipAmount(BigDecimal scholarshipAmount) {
		this.scholarshipAmount = scholarshipAmount;
	}
	
	
}
