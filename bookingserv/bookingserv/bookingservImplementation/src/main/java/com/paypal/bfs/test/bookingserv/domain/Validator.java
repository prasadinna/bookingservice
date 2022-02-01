package com.paypal.bfs.test.bookingserv.domain;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface Validator<T> {
   public List<ValidateExceptionMessage> validate(T input);
}
