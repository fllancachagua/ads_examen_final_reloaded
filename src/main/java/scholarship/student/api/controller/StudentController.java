package scholarship.student.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import scholarship.common.api.controller.ResponseHandler;
import scholarship.common.application.dto.ListGeneralResponse;
import scholarship.common.application.dto.ScholarshipAmountResponse;
import scholarship.student.application.StudentService;
import scholarship.student.application.dto.StudentDto;
import scholarship.student.application.dto.mapper.StudentToStudentDtoMapper;

@RestController
@RequestMapping("api/students/")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@Autowired
	ResponseHandler responseHandler;
	
	@Autowired
	StudentToStudentDtoMapper studentDtoMapper;
	
	@RequestMapping(method = RequestMethod.GET, path ="/scholarship/{student_type}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get scholarschip amount", httpMethod = "GET", response = ScholarshipAmountResponse.class)
	public ResponseEntity<Object> getScholarshipAmount(@PathVariable( "student_type") String  student_type) throws Exception {
		try {
			ScholarshipAmountResponse scholarshipAmountResponse = studentService.getScholarshipAmount(student_type);
			if (scholarshipAmountResponse == null) {
				return this.responseHandler.getNotFoundObjectResponse("Student not found");
			}
			return this.responseHandler.getOkObjectResponse(scholarshipAmountResponse);
		} catch (IllegalArgumentException ex) {
			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
		} catch (Throwable ex) {
			return this.responseHandler.getAppExceptionResponse(ex);
		}
	}	
	
	@RequestMapping(method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "list students", httpMethod = "GET", response = StudentDto.class , responseContainer = "List")
	public ResponseEntity<Object> listStudents(@RequestParam(value = "student_type", defaultValue = "all")String  student_type) throws Exception {
		try {
			ListGeneralResponse  studentsDto = studentService.findStudents(student_type);
			if (studentsDto == null) {
				return this.responseHandler.getNotFoundObjectResponse("Data not found");
			}
			return this.responseHandler.getOkObjectResponse(studentsDto);
		} catch (IllegalArgumentException ex) {
			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
		} catch (Throwable ex) {
			return this.responseHandler.getAppExceptionResponse(ex);
		}
	}		
}
