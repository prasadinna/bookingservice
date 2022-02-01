package com.paypal.bfs.test.bookingserv.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.bookingserv.persistence.entity.AddressEntity;
@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
   public AddressEntity findByLine1(String line1);
}
