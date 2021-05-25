package com.cg.mts.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.mts.Exception.CustomerException;
import com.cg.mts.Repository.CustomerRepository;
import com.cg.mts.entities.Customer;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository repository;
	public Customer addCustomer(Customer customer) throws CustomerException
	{
		Optional<Customer> findById = repository.findById(customer.getCustomerId());
		if(!findById.isPresent()) {
			return repository.save(customer);
		}
		else
			throw new CustomerException("Customer already present");
	}
	


public List<Customer> getAllActivity() throws CustomerException
{
	if(repository.findAll().size()==0)
		throw new CustomerException(" list is blank");
	else
		return repository.findAll(); 

}


}