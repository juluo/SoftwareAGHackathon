package org.softwareag.hackthon.repo;

import org.softwareag.hackthon.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepo extends JpaRepository<UserInfo, Long>{
	
	UserInfo findById(int id);

}
