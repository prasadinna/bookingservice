package com.paypal.bfs.test.bookingserv.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.paypal.bfs.test.bookingserv.persistence.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.persistence.repository.BookingEntityRepository;

public class MockBookingEntityRepository implements BookingEntityRepository {
    public static int Id = 100;
	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteInBatch(Iterable<BookingEntity> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BookingEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookingEntity> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BookingEntity> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BookingEntity> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookingEntity> findAllById(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public BookingEntity getOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BookingEntity> List<S> saveAll(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BookingEntity> S saveAndFlush(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BookingEntity> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(BookingEntity arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends BookingEntity> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existsById(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<BookingEntity> findById(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BookingEntity> S save(S bookingEntity) {

		bookingEntity.setId(Id);
		return (S) bookingEntity;
	}

	@Override
	public <S extends BookingEntity> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends BookingEntity> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends BookingEntity> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BookingEntity> Optional<S> findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingEntity findByCheckinTimeNUserId(long checkin, long checkout, int userID) {
		// TODO Auto-generated method stub
		return null;
	}

}
