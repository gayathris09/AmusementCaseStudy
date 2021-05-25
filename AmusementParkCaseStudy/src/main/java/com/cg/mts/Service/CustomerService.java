package com.cg.mts.Service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cg.mts.Exception.CustomerException;
import com.cg.mts.Repository.CustomerRepository;
import com.cg.mts.entities.Activity;
import com.cg.mts.entities.Customer;


@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository repository;
	
	static Logger logger = LoggerFactory.getLogger(CustomerService.class);
	
	public Customer insertCustomer(Customer customer) throws CustomerException
	{
		Optional<Customer> findById = repository.findById(customer.getCustomerId());
		if(!findById.isPresent()) {
			return repository.save(customer);
		}
		else
			throw new CustomerException("Customer already present");
	}
	
	public void updateCustomer(int id, Customer customer) throws CustomerException
	{
		Customer cust = repository.findById(id)
				.orElseThrow(() -> new CustomerException("Employee with id "+ id +"not found"));
		cust.setCustomerId(customer.getCustomerId());
		cust.setUserId(customer.getUserId());
		cust.setUsername(customer.getUsername());
		cust.setPassword(customer.getPassword());
		cust.setMobileNumber(customer.getMobileNumber());
		cust.setEmail(customer.getEmail());
		cust.setAddress(cust.getAddress());
		repository.save(cust);
		return;
	}
	
	
	public List<Customer> viewCustomers() throws CustomerException
	{
		if(repository.findAll().size()==0)
			throw new CustomerException(" list is blank");
		else
			return repository.findAll(); 

	}
 public String deleteCustomer(@PathVariable int id)
	{
		Customer cust = repository.findById(id).orElse(null);
	    repository.delete(cust);
	    return "Customer deleted";
		
	}
}
