package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.model.Booking;

import java.io.IOException;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Price;
public class BookingJsonGenertor {

	@Test
	public void printMethod(){
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
		
		ObjectMapper Obj = new ObjectMapper();
		 
        try {
 
            // get Organisation object as a json string
            String jsonStr = Obj.writeValueAsString(newBook);
 
            // Displaying JSON String
            System.out.println(jsonStr);
        }
 
        catch (IOException e) {
            e.printStackTrace();
        }


	}

}
