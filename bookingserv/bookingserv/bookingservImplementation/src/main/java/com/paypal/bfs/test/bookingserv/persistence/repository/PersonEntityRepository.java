package com.paypal.bfs.test.bookingserv.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.bookingserv.persistence.entity.PersonEntity;
@Repository
public interface PersonEntityRepository extends JpaRepository<PersonEntity, Integer> {
  public PersonEntity findByContact(int contact);
}
