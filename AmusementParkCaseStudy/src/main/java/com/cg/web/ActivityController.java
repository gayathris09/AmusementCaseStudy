package com.cg.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.cg.mts.Exception.ActivityException;
import com.cg.mts.Service.ActivityService;
import com.cg.mts.entities.Activity;

@RestController
@RequestMapping("/activity")
public class ActivityController {

	@Autowired
	ActivityService service;
	
	@GetMapping("/all")
	public List<Activity> getAllCustomer() throws ActivityException{
		return service.getAllActivity();
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Activity saveCustomer(@RequestBody Activity Activity) throws ActivityException{
		return service.insertActivity(Activity);
	}
	
	@PutMapping("/updateCab")
	public Activity updateCab(@RequestBody Activity activity)
	{
		return service.updateCab(activity);
	}
	
	@DeleteMapping("/deleteCab/{id}")
	public String deleteCab(@PathVariable int id)
	{
		return service.deleteCab(id);
	}
}
