package com.cg.mts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Activity;
@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer>{

}
