package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.domain.PersonDTO;
import com.paypal.bfs.test.bookingserv.persistence.entity.AddressEntity;
import com.paypal.bfs.test.bookingserv.persistence.entity.PersonEntity;
import com.paypal.bfs.test.bookingserv.persistence.service.UserService;

public class MockUserService extends UserService {
	 public static int Id = 200;
	public PersonDTO input;
	
	public MockUserService(PersonDTO person) {
		input = person;
	}
	
	@Override
	public PersonEntity getUserFromDTO(PersonDTO person) {
		assert(person == input);
		
		PersonEntity pe = new PersonEntity();
		pe.setId(Id);
		AddressEntity addEntity = new AddressEntity();
		addEntity.setId(Id);
		pe.setAddress(addEntity);
		return pe;
		
	}
}
