package scholarship.common.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import scholarship.common.application.dto.ErrorDto;
import scholarship.common.application.dto.ResponseDto;
import scholarship.common.application.dto.ResponseErrorDto;
import scholarship.common.application.dto.ResponseOkCommandDto;



@Component()
public class ResponseHandler {

	private Logger logger = LoggerFactory.getLogger(ResponseHandler.class);

	public ResponseEntity<Object> getOkCommandResponse(String message) {
		ResponseDto responseDto = new ResponseDto();
		ResponseOkCommandDto responseOkCommandDto = new ResponseOkCommandDto();
		responseOkCommandDto.setHttpStatus(HttpStatus.OK.value());
		responseOkCommandDto.setMessage(message);
		responseDto.setResponse(responseOkCommandDto);
		return new ResponseEntity<Object>(responseDto.getResponse(), HttpStatus.OK);
	}

	public ResponseEntity<Object> getOkObjectResponse(Object message) {
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	public ResponseEntity<Object> getAppCustomErrorResponse(String errorMessages) {
		logger.debug(errorMessages);

		ResponseDto responseDto = new ResponseDto();
		String[] errors = errorMessages.split(",");
		List<ErrorDto> errorsDto = new ArrayList<ErrorDto>();
		for (String error : errors) {
			errorsDto.add(new ErrorDto(error));
		}
		ResponseErrorDto responseErrorDto = new ResponseErrorDto(errorsDto);
		responseErrorDto.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		responseDto.setResponse(responseErrorDto);
		return new ResponseEntity<Object>(responseDto.getResponse(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Object> getAppExceptionResponse(Throwable e) {
		logger.error(e.getMessage(), e);

		ResponseDto responseDto = new ResponseDto();
		List<ErrorDto> errorsDto = new ArrayList<ErrorDto>();
		errorsDto.add(new ErrorDto("Server error"));
		ResponseErrorDto responseErrorDto = new ResponseErrorDto(errorsDto);
		responseErrorDto.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		responseDto.setResponse(responseErrorDto);
		return new ResponseEntity<Object>(responseDto.getResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<Object> getNotFoundObjectResponse(String message) {
		ResponseDto responseDto = new ResponseDto();
		List<ErrorDto> errorsDto = new ArrayList<ErrorDto>();
		errorsDto.add(new ErrorDto(message));
		ResponseErrorDto responseErrorDto = new ResponseErrorDto(errorsDto);
		responseErrorDto.setHttpStatus(HttpStatus.NOT_FOUND.value());
		responseDto.setResponse(responseErrorDto);
		return new ResponseEntity<Object>(responseDto.getResponse(), HttpStatus.NOT_FOUND);
	}

}
