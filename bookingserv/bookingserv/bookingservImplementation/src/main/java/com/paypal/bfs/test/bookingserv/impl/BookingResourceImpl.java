package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.domain.BookingRequestDTO;
import com.paypal.bfs.test.bookingserv.domain.ValidateExceptionMessage;
import com.paypal.bfs.test.bookingserv.domain.Validator;
import com.paypal.bfs.test.bookingserv.persistence.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.persistence.service.BookingService;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingResourceImpl implements BookingResource {
	
	@Autowired
	BookingService bookService;
	
	@Autowired
	BookingTobookingRequestConverter convertor;
	
	@Autowired
	Validator<BookingRequestDTO> validator;
	
	
	
    @Override
    public ResponseEntity<Booking> create(Booking booking) {
    	//throw bad input here
    	BookingRequestDTO bookRequestDTO = convertor.bookingToDTO(booking);
    	List<ValidateExceptionMessage> validations = validator.validate(bookRequestDTO);
    	BookingEntity ret = null;
    	if(isSuccessValidation(validations)) {
    		ret = bookService.createBooking(bookRequestDTO);
    		Booking returnVal = convertor.entityToBooking(ret);
    	    return ResponseEntity.ok(returnVal);
    	}else {
    		throw new ValidationException(validations);
    	}
    	
    }
    
    @Override
	public ResponseEntity<List<Booking>> getAllBooking(){
        List<BookingEntity> bookingEntityList = bookService.getAllBookings();
        List<Booking> output = new ArrayList<>();
        bookingEntityList.forEach(item ->{
        	output.add(convertor.entityToBooking(item));
        });
    	return ResponseEntity.ok(output);
    	
    	
    }
    
    protected boolean isSuccessValidation(List<ValidateExceptionMessage> validations ) {
    	return validations == null || validations.size() < 1;
    }
}
