package org.softwareag.hackthon.repo;

import org.softwareag.hackthon.service.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepo extends JpaRepository<Trip, Long>{
	
	

}
