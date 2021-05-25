package com.cg.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.Exception.AdminException;
import com.cg.mts.Repository.AdminRepository;
import com.cg.mts.Service.AdminService;
import com.cg.mts.entities.Admin;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminRepository adminRepository;
	@Autowired
	AdminService service;
	
	@GetMapping("/all")
	public List<Admin> getCustomer()
	{
		return adminRepository.findAll();
	}
	
	@PostMapping("/add")
	public Admin insertAdmin(@RequestBody Admin admin)
	{
		return adminRepository.save(admin);
	}
	@DeleteMapping("/deleteAdmin/{id}")
	public String deleteAdmin(@PathVariable int id)
	{
		return service.deleteAdmin(id);
	}
	
	@PutMapping("/update/{id}")
	public void updateAdmin(@PathVariable Integer id, @RequestBody Admin admin) throws AdminException
	{
		service.updateAdmin(id, admin);
	}
}
