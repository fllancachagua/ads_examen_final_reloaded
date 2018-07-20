package scholarship.student.application.dto;

import java.math.BigDecimal;

public class StudentDto {
	private Long id;
	private String firstName;
	private String lastName;
	private BigDecimal scholarshipAmount;
	
	public StudentDto(Long id, String firstName, String lastName, BigDecimal scholarshipAmount) {
		super();
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
