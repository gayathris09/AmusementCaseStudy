package com.cg.mts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mts.entities.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Integer>{

}
