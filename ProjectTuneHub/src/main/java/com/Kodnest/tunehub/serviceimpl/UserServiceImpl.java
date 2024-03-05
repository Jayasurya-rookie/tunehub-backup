package com.Kodnest.tunehub.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import org.springframework.web.bind.annotation.ModelAttribute;

import com.Kodnest.tunehub.entity.User;
import com.Kodnest.tunehub.repository.UserRepository;

@Service
public class UserServiceImpl {
	
	@Autowired
	UserRepository userRepository;
	public String addUser( User user) {
		userRepository.save(user);
		
		
		return "user data added succesfully";
		
	}
	
	//logic to check the duplicate entries 
	public boolean emailExists(String email) {	
		if(userRepository.findByEmail(email)!= null) {
			System.out.println("present");
			return true;
			
		}
		else {
			System.out.println("absent");
			return false;
		}
	}

	public boolean validateUser(String email, String password) {
		User user= userRepository.findByEmail(email);
		String dbps=user.getPassword();	
		if(password.equals(dbps)) {
			return true;
		}
		else {
			return false;
		}
	
		
	
	}

	public String getRole(String email) {
		User user = userRepository.findByEmail(email);
		
		return user.getRole();
	}
	

	public User getUser(String email) {
		return userRepository.findByEmail(email);
		
	}
	public void updateUser(User user) {
		userRepository.save(user);
		
	}

}
