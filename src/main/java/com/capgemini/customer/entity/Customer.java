package com.capgemini.customer.entity;

import org.springframework.data.annotation.Id;

public class Customer {
	
	
	@Id
	private int customerId;
	private String customerFirstName;
	private String customerLastName;
	private String customerEmail;
	private String customerAddress;
	private String customerPassword;
	private Address address;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int customerId, String customerFirstName, String customerLastName, String customerEmail,
			String customerAddress, String customerPassword, Address address) {
		super();
		this.customerId = customerId;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.customerPassword = customerPassword;
		this.address = address;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerFirstName() {
		return customerFirstName;
	}
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	public String getCustomerLastName() {
		return customerLastName;
	}
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerFirstName=" + customerFirstName + ", customerLastName="
				+ customerLastName + ", customerEmail=" + customerEmail + ", customerAddress=" + customerAddress
				+ ", customerPassword=" + customerPassword + ", address=" + address + "]";
	}
	
}