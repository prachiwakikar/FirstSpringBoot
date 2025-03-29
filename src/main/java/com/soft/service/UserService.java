package com.soft.service;

import java.util.List;
import java.util.Optional;

import com.soft.modal.UserModel;

public interface UserService {

	public UserModel saveUserService(UserModel usermodel);
	public List<UserModel> getUserService();
	public Optional<UserModel> getUserbyId(int id);
	UserModel updateUserById(int id, UserModel usermodel); 
	public void deleteUserById(int id);
	
	 
	
}
