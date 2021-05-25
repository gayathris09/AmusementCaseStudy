package com.cg.mts.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.mts.Exception.ActivityException;
import com.cg.mts.Repository.ActivityRepository;
import com.cg.mts.entities.Activity;

@Service
public class ActivityService {
	
	@Autowired
	ActivityRepository repository;
	public Activity insertActivity(Activity Activity) throws ActivityException
	{
		Optional<Activity> findById = repository.findById(Activity.getActivityId());
		if(!findById.isPresent()) {
			return repository.save(Activity);
		}
		else
			throw new ActivityException("Activity already present");
	}
	
	public Activity updateCab(Activity activity)
	{
		Activity act=repository.findById(activity.getActivityId()).orElse(null);
		act.setActivityId(activity.getActivityId());
		act.setCharges(activity.getCharges());
		act.setDescription(activity.getDescription());
		return repository.save(act);
	}
	
	public String deleteCab(@PathVariable int id)
	{
		Activity act=repository.findById(id).orElse(null);
	    repository.delete(act);
	    return "activity deleted";
		
	}

	public List<Activity> getAllActivity() throws ActivityException
	{
		if(repository.findAll().size()==0)
			throw new ActivityException(" list is blank");
		else
			return repository.findAll();
	}
}
