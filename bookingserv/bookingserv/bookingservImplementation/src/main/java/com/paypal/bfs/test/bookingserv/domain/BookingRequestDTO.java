package com.paypal.bfs.test.bookingserv.domain;


public class BookingRequestDTO {



	public long getCheckinDatetime() {
		return checkinDatetime;
	}

	public void setCheckinDatetime(long checkinDatetime) {
		this.checkinDatetime = checkinDatetime;
	}

	public long getCheckoutDatetime() {
		return checkoutDatetime;
	}

	public void setCheckoutDatetime(long checkoutDatetime) {
		this.checkoutDatetime = checkoutDatetime;
	}

	public PersonDTO getRequestor() {
		return requestor;
	}

	public void setRequestor(PersonDTO requestor) {
		this.requestor = requestor;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTotalCurrency() {
		return totalCurrency;
	}

	public void setTotalCurrency(String totalCurrency) {
		this.totalCurrency = totalCurrency;
	}

	public double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public String getDepositCurrency() {
		return depositCurrency;
	}

	public void setDepositCurrency(String depositCurrency) {
		this.depositCurrency = depositCurrency;
	}


	private long checkinDatetime;
	  private long checkoutDatetime;

	  private PersonDTO  requestor;
	  

	  private double totalAmount;

	  private String totalCurrency;
	  

	  private double depositAmount;
	  
	  private String depositCurrency;
	  


}
