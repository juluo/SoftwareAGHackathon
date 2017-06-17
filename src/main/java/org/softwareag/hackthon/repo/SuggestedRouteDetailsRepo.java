package org.softwareag.hackthon.repo;

import java.util.List;

import org.softwareag.hackthon.entity.SuggestedRouteDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestedRouteDetailsRepo extends JpaRepository<SuggestedRouteDetails, Long>{
	
	SuggestedRouteDetails findById(long id); 
	
	List<SuggestedRouteDetails> findByInActive(boolean flag);
	
	
	

}
