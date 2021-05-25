package com.cg.mts.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.mts.Exception.AdminException;
import com.cg.mts.Repository.AdminRepository;
import com.cg.mts.entities.Admin;

@Service
public class AdminService {

	@Autowired
	AdminRepository repository;
	public Admin  insertAdmin(Admin Admin) throws AdminException
	{
		Optional<Admin> findById = repository.findById(Admin.getAdminId());
		if(!findById.isPresent()) {
			return repository.save(Admin);
		}
		else
			throw new AdminException("Admin already present");
	}
	
	public List<Admin> getAllAdmin() throws AdminException
	{
		if(repository.findAll().size()==0)
			throw new AdminException(" list is blank");
		else
			return repository.findAll();
	}
	public String deleteAdmin(@PathVariable int id)
	{
		Admin act=repository.findById(id).orElse(null);
	    repository.delete(act);
	    return "admin deleted";
		
	}
	public void updateAdmin(int id, Admin admin) throws AdminException
	{
		Admin cust = repository.findById(id)
				.orElseThrow(() -> new AdminException("Admin with id "+ id +"not found"));
		cust.setAdminId(admin.getAdminId());
		cust.setUserId(admin.getUserId());
		cust.setUsername(admin.getUsername());
		cust.setPassword(admin.getPassword());
		cust.setMobileNumber(admin.getMobileNumber());
		cust.setEmail(admin.getEmail());
		cust.setAddress(cust.getAddress());
		repository.save(cust);
		return;
	}
}
