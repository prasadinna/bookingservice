package com.paypal.bfs.test.bookingserv.persistence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKING")
public class BookingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@Column(name = "checkin_datetime")
	private long checkinDatetime;
	  
	  @Column(name = "checkout_datetime")
	  private long checkoutDatetime;
	  
	  @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	  @JoinColumn(name = "person_id")
	  private PersonEntity  requestor;
	  

	  
	  @Column(name = "total_amount")
	  private double totalAmount;
	  
	  @Column(name = "total_currency")
	  private String totalCurrency;
	  
	  @Column(name = "deposit_amount")
	  private double depositAmount;
	  
	  @Column(name = "deposit_currency")
	  private String depositCurrency;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


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

	public PersonEntity getRequestor() {
		return requestor;
	}

	public void setRequestor(PersonEntity requestor) {
		this.requestor = requestor;
	}

	@Override
	public String toString() {
		return "BookingEntity [id=" + id + "]";
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
}
