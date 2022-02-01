package com.paypal.bfs.test.bookingserv.impl;

import org.springframework.stereotype.Component;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.domain.AddressDTO;
import com.paypal.bfs.test.bookingserv.domain.BookingRequestDTO;
import com.paypal.bfs.test.bookingserv.domain.PersonDTO;
import com.paypal.bfs.test.bookingserv.persistence.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Price;

@Component
public class BookingTobookingRequestConverter {

	BookingRequestDTO bookingToDTO(Booking input) {
		
		
		
		AddressDTO address = new AddressDTO();
		address.setCity(input.getAddess().getCity());
		address.setLine1(input.getAddess().getLine1());
		address.setLine2(input.getAddess().getLine2());
		address.setState(input.getAddess().getState());
		address.setZipcode(input.getAddess().getZipCode());
		
		PersonDTO person = new PersonDTO();
		person.setAddress(address);
		person.setBirthdate(input.getBirthDate());
		person.setContact(input.getContactNumber());
		person.setFirstName(input.getFirstName());
		person.setLastName(input.getLastName());
		
		BookingRequestDTO bookRequest = new BookingRequestDTO();
		bookRequest.setCheckinDatetime(input.getCheckinDatetime());
		bookRequest.setCheckoutDatetime(input.getCheckoutDatetime());
		bookRequest.setDepositAmount(input.getDeposit().getAmount());
		bookRequest.setDepositCurrency(input.getDeposit().getCurrency());
		
		bookRequest.setRequestor(person);
		
		return bookRequest;
		
	}
	
	Booking entityToBooking(BookingEntity input) {
		
		
		
		Booking booking = new Booking();
		booking.setId(input.getId());
		booking.setCheckinDatetime(input.getCheckinDatetime());
		booking.setCheckoutDatetime(input.getCheckoutDatetime());
		booking.setFirstName(input.getRequestor().getFirstName());
		booking.setLastName(input.getRequestor().getLastName());
		Price deposit = new Price();
		deposit.setAmount(input.getDepositAmount());
		deposit.setCurrency(input.getDepositCurrency());
		booking.setDeposit(deposit);
		Price total = new Price();
		total.setAmount(input.getTotalAmount());
		total.setCurrency(input.getTotalCurrency());
		booking.setTotalprice(total);
		
		Address address = new Address();
		address.setLine1(input.getRequestor().getAddress().getLine1());
		address.setLine2(input.getRequestor().getAddress().getLine2());
		address.setState(input.getRequestor().getAddress().getState());
		address.setZipCode(input.getRequestor().getAddress().getZipcode());
		address.setCity(input.getRequestor().getAddress().getCity());
		booking.setAddess(address);
		return booking;
		
	}
	
}
