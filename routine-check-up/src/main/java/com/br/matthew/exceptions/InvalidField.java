package com.br.matthew.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidField extends RuntimeException {

	public InvalidField(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;

}
