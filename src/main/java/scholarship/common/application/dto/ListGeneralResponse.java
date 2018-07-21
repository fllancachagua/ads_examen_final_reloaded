package scholarship.common.application.dto;

import java.util.ArrayList;
import java.util.List;

import scholarship.student.application.dto.StudentDto;

public class ListGeneralResponse {

	private List<ListStudentResponse<StudentDto>> listStudents;

	public ListGeneralResponse() {
		listStudents = new ArrayList<ListStudentResponse<StudentDto>>();
	}	
	public ListGeneralResponse(List<ListStudentResponse<StudentDto>> listStudents) {
		this.listStudents = listStudents;
	}

	public List<ListStudentResponse<StudentDto>> getListStudents() {
		return listStudents;
	}

	public void setListStudents(List<ListStudentResponse<StudentDto>> listStudents) {
		this.listStudents = listStudents;
	}
	
	
	
}
