package com.paypal.bfs.test.bookingserv.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.bfs.test.bookingserv.domain.AddressDTO;
import com.paypal.bfs.test.bookingserv.persistence.entity.AddressEntity;
import com.paypal.bfs.test.bookingserv.persistence.repository.AddressRepository;

@Service
public class AddressService {
  @Autowired
  AddressRepository addrRepo;
  
   public AddressEntity getAddress(AddressDTO addr) {
	   AddressEntity addrEntity = addrRepo.findByLine1(addr.getLine1());
	   if(addrEntity!= null) {
		   return addrEntity;
	   }else {
		   addrEntity = new AddressEntity();
		   addrEntity.setLine1(addr.getLine1());
		   addrEntity.setLine2(addr.getLine2());
		   addrEntity.setState(addr.getState());
		   addrEntity.setZipcode(addr.getZipcode());
		   return addrEntity;
	   }
   }
}
