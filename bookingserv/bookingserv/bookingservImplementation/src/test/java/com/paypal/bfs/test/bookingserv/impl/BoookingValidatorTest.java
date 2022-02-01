package com.paypal.bfs.test.bookingserv.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.domain.BookingRequestDTO;
import com.paypal.bfs.test.bookingserv.domain.BoookingValidator;
import com.paypal.bfs.test.bookingserv.domain.ValidateExceptionMessage;
import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Price;
public class BoookingValidatorTest {
	@Test
	public void testcheckinTimeValidation() {
		Address address = new Address();
		address.setLine1("my line 1");
		address.setLine2("my line 2");
		address.setState("Karnataka");
		address.setZipCode("560098");
		address.setCity("Bangalore");
		
		Booking newBook = new Booking();
		newBook.setAddess(address);
		newBook.setBirthDate(new Date());
		newBook.setCheckinDatetime(System.currentTimeMillis());
		newBook.setCheckoutDatetime(System.currentTimeMillis()-100000);
		newBook.setContactNumber(910816362);
		newBook.setFirstName("Prasad");
		newBook.setLastName("Shetty");
		Price deposit = new Price();
		deposit.setAmount(10.0);
		deposit.setCurrency("INR");
		newBook.setDeposit(deposit);
		Price total = new Price();
		total.setAmount(100.0);
		total.setCurrency("INR");
		newBook.setTotalprice(total);
		
		BookingTobookingRequestConverter convertor = new BookingTobookingRequestConverter();
		BookingRequestDTO bookingDTO = convertor.bookingToDTO(newBook);
		BoookingValidator validator = new BoookingValidator();
		List<ValidateExceptionMessage> output = validator.validate(bookingDTO);
		assertTrue(output != null && output.size() > 0);
		assertTrue(output.get(0).getCode() == -10);
	}
	
	@Test
	public void testNoValidation() {
		Address address = new Address();
		address.setLine1("my line 1");
		address.setLine2("my line 2");
		address.setState("Karnataka");
		address.setZipCode("560098");
		address.setCity("Bangalore");
		
		Booking newBook = new Booking();
		newBook.setAddess(address);
		newBook.setBirthDate(new Date());
		newBook.setCheckinDatetime(System.currentTimeMillis()-100000);
		newBook.setCheckoutDatetime(System.currentTimeMillis());
		newBook.setContactNumber(910816362);
		newBook.setFirstName("Prasad");
		newBook.setLastName("Shetty");
		Price deposit = new Price();
		deposit.setAmount(10.0);
		deposit.setCurrency("INR");
		newBook.setDeposit(deposit);
		Price total = new Price();
		total.setAmount(100.0);
		total.setCurrency("INR");
		newBook.setTotalprice(total);
		
		BookingTobookingRequestConverter convertor = new BookingTobookingRequestConverter();
		BookingRequestDTO bookingDTO = convertor.bookingToDTO(newBook);
		BoookingValidator validator = new BoookingValidator();
		List<ValidateExceptionMessage> output = validator.validate(bookingDTO);
		assertTrue(output != null && output.size() == 0);

	}
}
