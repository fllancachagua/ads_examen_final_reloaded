package scholarship.common.application.dto;

import java.math.BigDecimal;

public class ScholarshipAmountResponse {
	private String studentType;
	private BigDecimal amount;

	public ScholarshipAmountResponse() {
	}

	public ScholarshipAmountResponse(String studentType, BigDecimal amount) {
		this.studentType = studentType;
		this.amount = amount;
	}

	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
