package com.paypal.bfs.test.bookingserv.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.domain.BookingRequestDTO;
import com.paypal.bfs.test.bookingserv.persistence.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.persistence.service.BookingService;
import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Price;

public class BookingServiceTest {
	
  @Test
  public void verifyCreateBookingEntity() {
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
		
		MockBookingEntityRepository mockRepo = new MockBookingEntityRepository();
		MockUserService userService = new MockUserService(bookingDTO.getRequestor());
		
		BookingService bookingService = new BookingService();
		bookingService.setBookingRepo(mockRepo);
		bookingService.setUserService(userService);
		
		BookingEntity output = bookingService.createBooking(bookingDTO);
		assertTrue(output.getId() == MockBookingEntityRepository.Id);
		assertTrue(output.getRequestor().getId() == MockUserService.Id && 
				output.getRequestor().getAddress().getId() == MockUserService.Id);
		
  }
}
