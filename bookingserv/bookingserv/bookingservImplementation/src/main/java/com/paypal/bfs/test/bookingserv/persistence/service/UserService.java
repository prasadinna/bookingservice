package com.paypal.bfs.test.bookingserv.persistence.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.paypal.bfs.test.bookingserv.domain.PersonDTO;
import com.paypal.bfs.test.bookingserv.persistence.entity.AddressEntity;
import com.paypal.bfs.test.bookingserv.persistence.entity.PersonEntity;
import com.paypal.bfs.test.bookingserv.persistence.repository.PersonEntityRepository;

@Service
public class UserService {

	@Autowired
	PersonEntityRepository userRepo;
	
	@Autowired
	AddressService addrService;
	
	
    public PersonEntity getUserFromDTO(PersonDTO person) {
    	
    	PersonEntity userEntity = userRepo.findByContact(person.getContact());
    	AddressEntity addrEntity = addrService.getAddress(person.getAddress());
    	if(userEntity != null) {
    		return userEntity;
    	}else {
    		userEntity = new PersonEntity();
    		userEntity.setAddress(addrEntity);
    		userEntity.setContact(person.getContact());
    		userEntity.setFirstName(person.getFirstName());
    		userEntity.setLastName(person.getLastName());
    		Date sqlDate = new Date(person.getBirthdate().getTime());
    		userEntity.setBirthdate(sqlDate);
    	}
    	return userEntity;
    }
}
