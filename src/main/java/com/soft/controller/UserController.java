package com.soft.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soft.modal.UserModel;
import com.soft.service.UserService;

@RestController
@RequestMapping("/Usercontroller")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/msg")
	public String showMsg() {
		
		return " I am a java developer";
		
	}
	
	@PostMapping("/saveuser")
	public UserModel createUser(@RequestBody UserModel usermodel) {
		
		UserModel savedUserModel = userservice.saveUserService(usermodel);
		
		return savedUserModel;
		
	}
	
	@GetMapping("/allusers")
	public List<UserModel>getallUsers(){
		return userservice.getUserService();
		
		}
	
	
	 @GetMapping("/find/{id}")
	    public Optional<UserModel> findUserById(@PathVariable int id) {
	        return userservice.getUserbyId(id);
	    }
	 @DeleteMapping("/delete/{id}")
	 public String deleteUser(@PathVariable int id) {
	     userservice.deleteUserById(id);
	     return "User with ID " + id + " deleted successfully.";
	 }
	 @PutMapping("/update/{id}")
	 public UserModel updateUserById(@PathVariable int id,@RequestBody UserModel usermodel) {
		 return userservice.updateUserById(id, usermodel);
	 }

}
