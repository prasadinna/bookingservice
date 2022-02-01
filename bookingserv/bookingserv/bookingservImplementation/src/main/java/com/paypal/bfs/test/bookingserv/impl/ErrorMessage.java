package com.paypal.bfs.test.bookingserv.impl;

public class ErrorMessage {
  public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErroCode() {
		return erroCode;
	}
	public void setErroCode(String erroCode) {
		this.erroCode = erroCode;
	}
protected String errorMessage;
  protected String erroCode;
public ErrorMessage(String errorMessage, String erroCode) {
	super();
	this.errorMessage = errorMessage;
	this.erroCode = erroCode;
}
}
