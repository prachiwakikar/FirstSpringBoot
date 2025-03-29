package com.soft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soft.modal.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer>{
	
	 boolean existsByEmail(String email);
	 boolean existsByPhoneno(long phoneno);

	 
}
