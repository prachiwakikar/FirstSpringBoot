package com.soft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.modal.UserModel;
import com.soft.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepos;

    @Override
    public UserModel saveUserService(UserModel usermodel) {
        // Check if email or phone number already exists in the database
        boolean emailExists = userRepos.existsByEmail(usermodel.getEmail());
        boolean phoneExists = userRepos.existsByPhoneno(usermodel.getPhoneno());

        if (emailExists || phoneExists) {
            throw new RuntimeException("Email or Phone number already exists. Please use a different one.");
        }

        // Save user if validation passes
        return userRepos.save(usermodel);
    }

    @Override
    public List<UserModel> getUserService() {
        return userRepos.findAll();
    }
    
    @Override
    public Optional<UserModel> getUserbyId(int id) { 
        return userRepos.findById(id);
    }
    
    @Override
    public void deleteUserById(int id){
	 userRepos.deleteById(id);
    	
    }
    
    @Override
    public UserModel updateUserById(int id, UserModel usermodel) {
        Optional<UserModel> existingUser = userRepos.findById(id);// id match karun user entity find krte
        
        if (existingUser.isPresent()) {
            UserModel userToUpdate = existingUser.get();  // its a copy after that it will check
            
            userToUpdate.setName(usermodel.getName());
            userToUpdate.setEmail(usermodel.getEmail());
            userToUpdate.setAddress(usermodel.getAddress());
            userToUpdate.setPhoneno(usermodel.getPhoneno());
            userToUpdate.setPass(usermodel.getPass());

            return userRepos.save(userToUpdate); //change kelela data save kela
        } else {
            throw new RuntimeException("User not found with ID: " + id);
        }
    }

    
    
}
