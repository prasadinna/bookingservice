package com.paypal.bfs.test.bookingserv.persistence.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.domain.BookingRequestDTO;
import com.paypal.bfs.test.bookingserv.domain.PersonDTO;
import com.paypal.bfs.test.bookingserv.persistence.entity.AddressEntity;
import com.paypal.bfs.test.bookingserv.persistence.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.persistence.entity.PersonEntity;
import com.paypal.bfs.test.bookingserv.persistence.repository.BookingEntityRepository;

@Service
public class BookingService {
	@Autowired
	private BookingEntityRepository bookingRepo;
	
	@Autowired
	private UserService userService;
	


public BookingEntity createBooking() {
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
	   person.setBirthdate(bday);
	   
	   newEnt.setRequestor(person);
	   newEnt.setCheckinDatetime(System.currentTimeMillis());
	   newEnt.setCheckoutDatetime(System.currentTimeMillis());
	   newEnt.setDepositAmount(1000);
	   newEnt.setDepositCurrency("INR");
	   newEnt.setTotalAmount(1200);
	   newEnt.setTotalCurrency("INR");
	   
	   newEnt = bookingRepo.save(newEnt);
	   return newEnt;
   }
   
   public BookingEntity createBooking(BookingRequestDTO bookingRequest) {
	   
        PersonDTO personDTO = bookingRequest.getRequestor();
        PersonEntity requestor = userService.getUserFromDTO(personDTO);
        if(requestor.getId() > 0) {
        	BookingEntity existingBooking = bookingRepo.findByCheckinTimeNUserId(bookingRequest.getCheckinDatetime(),
        			bookingRequest.getCheckoutDatetime(), requestor.getId());
        	if(existingBooking != null) {
        		return existingBooking;
        	}
        	
        }
        
       BookingEntity newBooking = new BookingEntity();
	   
       newBooking.setRequestor(requestor);
       newBooking.setCheckinDatetime(bookingRequest.getCheckinDatetime());
       newBooking.setCheckoutDatetime(bookingRequest.getCheckoutDatetime());
       
       newBooking.setDepositAmount(bookingRequest.getDepositAmount());
       newBooking.setDepositCurrency(bookingRequest.getDepositCurrency());
       
       newBooking.setTotalAmount(bookingRequest.getTotalAmount());
       newBooking.setTotalCurrency(bookingRequest.getTotalCurrency());
       
       newBooking = bookingRepo.save(newBooking);
	   return newBooking;
   }
   
   public List<BookingEntity> getAllBookings() {
	   List<BookingEntity> bookingList = bookingRepo.findAll();
	   return bookingList;
   }
   public BookingEntityRepository getBookingRepo() {
		return bookingRepo;
	}

	public void setBookingRepo(BookingEntityRepository bookingRepo) {
		this.bookingRepo = bookingRepo;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
