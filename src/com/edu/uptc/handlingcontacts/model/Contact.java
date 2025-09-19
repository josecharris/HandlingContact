package com.edu.uptc.handlingcontacts.model;

import java.io.Serializable;

public class Contact implements Serializable{
	private static final long serialVersionUID = 1L;
	private String code;
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private String ipAddress;
	
	public Contact() {}
	
	public Contact(String code, String name, String phoneNumber, String email) {
		super();
		this.code = code;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}



	public Contact(String code, String name, String phoneNumber, String email, String address, String ipAddress) {
		this.code = code;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.ipAddress = ipAddress;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
}
