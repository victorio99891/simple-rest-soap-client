package pl.wiktor.restsoapclient.exception;

import lombok.Data;

@Data
public class ExceptionInfo {

	private String message;

	public ExceptionInfo(String message) {
		this.message = message;
	}

}
