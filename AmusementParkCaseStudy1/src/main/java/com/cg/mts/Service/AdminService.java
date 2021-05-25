package com.cg.mts.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.mts.Exception.AdminException;
import com.cg.mts.Repository.AdminRepository;
import com.cg.mts.entities.Admin;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository repository;
	public Admin  addAdmin(Admin Admin) throws AdminException
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

}