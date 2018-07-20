package scholarship.student.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import scholarship.common.api.controller.ResponseHandler;
import scholarship.student.application.StudentService;
import scholarship.student.application.dto.StudentDto;
import scholarship.student.application.dto.mapper.StudentToStudentDtoMapper;
import scholarship.student.domain.entity.Student;

@RestController
@RequestMapping("api/students/")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@Autowired
	ResponseHandler responseHandler;
	
	@Autowired
	StudentToStudentDtoMapper studentDtoMapper;
	
	@RequestMapping(method = RequestMethod.GET, path = "{student_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get scholarschip amount", httpMethod = "GET", response = StudentDto.class)
	public ResponseEntity<Object> getScholarshipAmount(@PathVariable("student_id") Long id) throws Exception {
		try {
			Student student = studentService.getScholarshipAmount(id);
			if (student == null) {
				return this.responseHandler.getNotFoundObjectResponse("Student not found");
			}
			return this.responseHandler.getOkObjectResponse(studentDtoMapper.mapper(student));
		} catch (IllegalArgumentException ex) {
			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
		} catch (Throwable ex) {
			return this.responseHandler.getAppExceptionResponse(ex);
		}
	}	
}
