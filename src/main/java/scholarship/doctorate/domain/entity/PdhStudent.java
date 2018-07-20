package scholarship.doctorate.domain.entity;

import java.math.BigDecimal;

import scholarship.student.domain.entity.Student;

public class PdhStudent extends Student {

	public BigDecimal calculateScholarship() {
		return new BigDecimal(20000.00);
	}
}
