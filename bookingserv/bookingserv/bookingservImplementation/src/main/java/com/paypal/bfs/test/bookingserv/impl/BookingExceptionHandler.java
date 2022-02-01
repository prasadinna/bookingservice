package com.paypal.bfs.test.bookingserv.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class BookingExceptionHandler {

	
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public @ResponseBody ErrorMessage handleValidationFailure (
    		ValidationException e)
    {

        return new ErrorMessage(
           "Validation Failure",
           getValidationMsg(e));
    }
	
    private String getValidationMsg(ValidationException e) {
    	return e.toString();
    }
    
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public @ResponseBody ErrorMessage handleUncaughtException (HttpServletRequest request,
        Exception e)
    {
        return new ErrorMessage("Internal error", "Please try again");
    }
}
