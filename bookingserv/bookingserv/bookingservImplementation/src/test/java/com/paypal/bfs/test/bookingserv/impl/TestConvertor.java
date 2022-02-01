package com.paypal.bfs.test.bookingserv.impl;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.domain.AddressDTO;
import com.paypal.bfs.test.bookingserv.domain.BookingRequestDTO;
import com.paypal.bfs.test.bookingserv.domain.PersonDTO;
import com.paypal.bfs.test.bookingserv.persistence.entity.AddressEntity;
import com.paypal.bfs.test.bookingserv.persistence.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.persistence.entity.PersonEntity;
import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Price;

public class TestConvertor {

	@Test
	public void testBooking2BookingDTO() {
		Address address = new Address();
		address.setLine1("my line 1");
		address.setLine2("my line 2");
		address.setState("Karnataka");
		address.setZipCode("560098");
		address.setCity("Bangalore");
		
		Booking newBook = new Booking();
		newBook.setAddess(address);
		newBook.setBirthDate(new Date());
		newBook.setCheckinDatetime(System.currentTimeMillis()-10000);
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
		PersonDTO personDTO = bookingDTO.getRequestor();
		AddressDTO addrDTO = personDTO.getAddress();
		assertTrue(bookingDTO != null && personDTO != null && addrDTO != null);
	}
	
	@Test
	public void testBookingEntity2Booking() {
		   BookingEntity newEnt = new BookingEntity();
		   AddressEntity addr = new AddressEntity();
		   addr.setCity("Bangalore");
		   addr.setLine1("line1");
		   addr.setLine1("line2");
		   addr.setState("Karnataka");
		   addr.setZipcode("570090");
		   PersonEntity person = new PersonEntity();
		   person.setAddress(addr);
		   person.setContact(10);
		   person.setFirstName("Prasad");
		   person.setLastName("Shetty");
		   Date bday = new Date(System.currentTimeMillis());
		   person.setBirthdate(new java.sql.Date(System.currentTimeMillis()));
		   
		   newEnt.setRequestor(person);
		   newEnt.setCheckinDatetime(System.currentTimeMillis());
		   newEnt.setCheckoutDatetime(System.currentTimeMillis());
		   newEnt.setDepositAmount(1000);
		   newEnt.setDepositCurrency("INR");
		   newEnt.setTotalAmount(1200);
		   newEnt.setTotalCurrency("INR");
		   
		   BookingTobookingRequestConverter convertor = new BookingTobookingRequestConverter();
		   Booking booking = convertor.entityToBooking(newEnt);
		   assertTrue(booking != null && booking.getAddess() != null);
	}
}
