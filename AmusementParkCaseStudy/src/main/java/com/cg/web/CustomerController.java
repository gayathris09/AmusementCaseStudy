package com.cg.web;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.Exception.CustomerException;
import com.cg.mts.Repository.CustomerRepository;
import com.cg.mts.Service.CustomerService;
import com.cg.mts.entities.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerService customerService;
	
	static Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@GetMapping("/all")
	public List<Customer> getCustomer()
	{
		return customerRepository.findAll();
	}
	
	@PostMapping("/add")
	public Customer insertCustomer(@RequestBody Customer customer)
	{
		return customerRepository.save(customer);
	}
	
	@PutMapping("/update/{id}")
	public void updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) throws CustomerException
	{
		customerService.updateCustomer(id, customer);
	}
	
	 @DeleteMapping("/delete/{id}")
		public String deleteCab(@PathVariable int id)
		{
			return customerService.deleteCustomer(id);
		}
	
}
