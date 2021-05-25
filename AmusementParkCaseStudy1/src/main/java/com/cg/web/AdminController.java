package com.cg.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.Repository.AdminRepository;
import com.cg.mts.entities.Admin;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminRepository adminRepository;
	
	@GetMapping("/all")
	public List<Admin> getCustomer()
	{
		return adminRepository.findAll();
	}
	
	@PostMapping("/add")
	public Admin addCustomer(@RequestBody Admin admin)
	{
		return adminRepository.save(admin);
	}
}