package com.tobstech.medicaldiagnosisapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tobstech.medicaldiagnosisapp.user.User;

//user repository class
public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query("SELECT u FROM userTable u WHERE u.username=?1 and u.password=?2")
	List<User> findByUsernameAndPassword(String username, String password);
	
}
