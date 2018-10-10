package com.capgemini.customer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.customer.entity.Customer;
import com.capgemini.customer.exception.AuthenticationFailedException;
import com.capgemini.customer.exception.CustomerAlreadyRegisteredException;
import com.capgemini.customer.exception.CustomerNotFoundException;
import com.capgemini.customer.service.CustomerService;

@RestController
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CustomerService customerService;

	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws CustomerAlreadyRegisteredException {
		logger.info("Created");
		return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.CREATED);
	}

	@PostMapping("/auth")
	public ResponseEntity<Customer> authenticate(@RequestBody Customer customer) throws CustomerNotFoundException, AuthenticationFailedException {
		return new ResponseEntity<Customer>(customerService.authentication(customer), HttpStatus.FOUND);
	}

	@PutMapping("/customer")
	public ResponseEntity<Customer> editCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(customerService.editCustomer(customer), HttpStatus.OK);
	}

	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId) throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}

	@DeleteMapping("/v1/customer/{customerId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int customerId) throws CustomerNotFoundException {
		Customer customer = customerService.getCustomerById(customerId);
		customerService.deleteCustomer(customer);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/v1/customers")
	public @ResponseBody ResponseEntity<List<Customer>> getAllCustomer() {
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
	}

}
