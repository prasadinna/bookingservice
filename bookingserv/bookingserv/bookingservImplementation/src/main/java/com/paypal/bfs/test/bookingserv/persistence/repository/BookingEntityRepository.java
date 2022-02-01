package com.paypal.bfs.test.bookingserv.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.paypal.bfs.test.bookingserv.persistence.entity.BookingEntity;

public interface BookingEntityRepository extends JpaRepository<BookingEntity, Integer> {
	@Query("SELECT booking FROM BookingEntity booking WHERE booking.checkinDatetime = :checkin " +
			" and booking.checkoutDatetime = :checkout " +
			" and requestor.id = :userID")
	public BookingEntity findByCheckinTimeNUserId(long checkin, long checkout, int userID);
}
