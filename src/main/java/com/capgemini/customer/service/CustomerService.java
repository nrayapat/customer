package com.capgemini.customer.service;

import java.util.List;

import com.capgemini.customer.entity.Customer;
import com.capgemini.customer.exception.AuthenticationFailedException;
import com.capgemini.customer.exception.CustomerAlreadyRegisteredException;
import com.capgemini.customer.exception.CustomerNotFoundException;

public interface CustomerService {
	
	
	public Customer addCustomer(Customer customer) throws CustomerAlreadyRegisteredException;

	public Customer authentication(Customer customer) throws CustomerNotFoundException, AuthenticationFailedException;

	public Customer getCustomerById(int customerId) throws CustomerNotFoundException;

	public Customer getCustomerByEmail(String customerEmail) throws CustomerNotFoundException;

	public List<Customer> getAllCustomers();

	public void deleteCustomer(Customer customer) throws CustomerNotFoundException;

	public Customer editCustomer(Customer customer) throws CustomerNotFoundException;

}
