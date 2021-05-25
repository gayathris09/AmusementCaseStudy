package com.cg.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.Exception.CustomerException;
import com.cg.mts.Repository.CustomerRepository;

import com.cg.mts.entities.Activity;
import com.cg.mts.entities.Customer;
import com.cg.mts.entities.TicketBooking;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/all")
	public List<Customer> getCustomer()
	{
		return customerRepository.findAll();
	}
	
	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		return customerRepository.save(customer);
	}

	@PutMapping("/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		Optional<Customer> opt = customerRepository.findById(customer.getCustomerId());
		try {
			if (opt.isPresent()) {
				return new ResponseEntity<Customer>(customerRepository.save(customer), HttpStatus.OK);
			} else
				
				throw new CustomerException("Product cannot be updated\nProduct not present");
		} catch (CustomerException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
