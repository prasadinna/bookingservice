package com.paypal.bfs.test.bookingserv.domain;

import java.util.Date;

public class PersonDTO {

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public AddressDTO getAddress() {
		return address;
	}


	public void setAddress(AddressDTO address) {
		this.address = address;
	}


	public Integer getContact() {
		return contact;
	}


	public void setContact(Integer contact) {
		this.contact = contact;
	}


	public Date getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	private String  firstName;
	  

	  private String lastName;
	  

	  private AddressDTO address;

	  private Integer contact;
	  

	  private Date birthdate;
}
