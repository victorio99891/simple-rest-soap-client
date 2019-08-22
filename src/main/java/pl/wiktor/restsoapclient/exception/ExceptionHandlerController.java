package pl.wiktor.restsoapclient.exception;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public @ResponseBody ResponseEntity<ExceptionInfo> productNotFound() {
		return new ResponseEntity<>(new ExceptionInfo("Product has been not found."), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ServiceConnectionException.class)
	public @ResponseBody ResponseEntity<ExceptionInfo> serviceUnavailable() {
		return new ResponseEntity<>(new ExceptionInfo("SOAP Service Connection is now unavailable."),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ArrayList<ExceptionInfo> errors = new ArrayList<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(new ExceptionInfo(error.getDefaultMessage()));
		}
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
