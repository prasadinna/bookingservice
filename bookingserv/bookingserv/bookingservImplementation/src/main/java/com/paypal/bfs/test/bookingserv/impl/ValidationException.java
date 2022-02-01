package com.paypal.bfs.test.bookingserv.impl;

import java.util.List;

import com.paypal.bfs.test.bookingserv.domain.ValidateExceptionMessage;

public class ValidationException extends IllegalArgumentException {

	List<ValidateExceptionMessage> validations;

	public ValidationException(List<ValidateExceptionMessage> validations) {
		super();
		this.validations = validations;
	}

	@Override
	public String toString() {
		return "ValidationException [validations=" + validations + "]";
	}
	
	
}
