package com.paypal.bfs.test.bookingserv.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class BoookingValidator implements Validator<BookingRequestDTO>{

	@Override
	public List<ValidateExceptionMessage> validate(BookingRequestDTO input) {
		List<ValidateExceptionMessage> errors = new ArrayList<ValidateExceptionMessage>();
		List<ValidateExceptionMessage> addressValidation = validateAddress(input.getRequestor().getAddress());
		if(addressValidation != null) {
			errors.addAll(addressValidation);
		}
		
		List<ValidateExceptionMessage> personValidation = validatePerson(input.getRequestor());
		if(personValidation != null) {
			errors.addAll(personValidation);
		}
		
		List<ValidateExceptionMessage> bookingValidation = validateBooking(input);
		if(bookingValidation != null) {
			errors.addAll(bookingValidation);
		}

		return errors;
	}
	
	private List<ValidateExceptionMessage> validatePerson(PersonDTO person){
		return null;
	}
	
	private List<ValidateExceptionMessage> validateAddress(AddressDTO address){
		return null;
	}
	
	private List<ValidateExceptionMessage> validateBooking(BookingRequestDTO booking){
		List<ValidateExceptionMessage> personValidations = new ArrayList<>();
		if(booking.getCheckinDatetime() > booking.getCheckoutDatetime()) {
			ValidateExceptionMessage checkinException = new ValidateExceptionMessage (){

				@Override
				public int getCode() {
					return -10;
				}

				@Override
				public String getMessage() {
					return "Checkin time cannot be greater than checkout Time";
				}
				
				@Override
				public String toString() {
					return "code:-10::message:Checkin time cannot be greater than checkout Time";
				}
				
			};
			personValidations.add(checkinException);
		}
		return personValidations;
	}

}
