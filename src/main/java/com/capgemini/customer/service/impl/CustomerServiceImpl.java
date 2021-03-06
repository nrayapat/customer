package com.capgemini.customer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.customer.entity.Customer;
import com.capgemini.customer.exception.AuthenticationFailedException;
import com.capgemini.customer.exception.CustomerAlreadyRegisteredException;
import com.capgemini.customer.exception.CustomerNotFoundException;
import com.capgemini.customer.repository.CustomerRepository;
import com.capgemini.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerAlreadyRegisteredException {
		Optional<Customer> customerFromDb = customerRepository.findById(customer.getCustomerId());
		if (!customerFromDb.isPresent()) {
			return customerRepository.save(customer);
		}
		throw new CustomerAlreadyRegisteredException(
				"Registration failed!! Customer Already registered with id" + customer.getCustomerId());
	}

	@Override
	public Customer authentication(Customer customer) throws CustomerNotFoundException, AuthenticationFailedException {
		Optional<Customer> customerFromDb = customerRepository.findById(customer.getCustomerId());
		if (customerFromDb.isPresent()) {
			if (customerFromDb.get().getCustomerPassword().equals(customer.getCustomerPassword())) {
				return customerFromDb.get();
			}
			throw new AuthenticationFailedException("Username password doesnot match");
		}
		throw new CustomerNotFoundException(
				"Auht failed!! Customer not found in database with id" + customer.getCustomerId());
	}

	@Override
	public Customer getCustomerById(int customerId) throws CustomerNotFoundException {
		Optional<Customer> customerFromDb = customerRepository.findById(customerId);
		if (customerFromDb.isPresent()) {
			return customerFromDb.get();
		}
		throw new CustomerNotFoundException("Search failed!! Customer not found with id " + customerId);
	}

	@Override
	public Customer getCustomerByEmail(String customerEmail) throws CustomerNotFoundException {
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public void deleteCustomer(Customer customer) throws CustomerNotFoundException {
		Optional<Customer> cuOptional = customerRepository.findById(customer.getCustomerId());
		if (cuOptional.isPresent()) {
			customerRepository.delete(customer);
			return;
		}
		throw new CustomerNotFoundException("Delete failed!! Customer not found with id " + customer.getCustomerId());
	}

	@Override
	public Customer editCustomer(Customer customer) throws CustomerNotFoundException {
		Optional<Customer> customerFromDb = customerRepository.findById(customer.getCustomerId());
		if (customerFromDb.isPresent()) {
			return customerRepository.save(customer);
		}
		throw new CustomerNotFoundException("Edit failed!! No customer found with id" + customer.getCustomerId());

	}

}