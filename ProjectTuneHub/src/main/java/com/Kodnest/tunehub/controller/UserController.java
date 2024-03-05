package com.Kodnest.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

import com.Kodnest.tunehub.entity.User;
import com.Kodnest.tunehub.serviceimpl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute User user) {
		

		// email taken from registration form
		String email=user.getEmail();
		//checking email from database as entered in registration form is present in DB or Not
		boolean status=userServiceImpl.emailExists(email);
		if(status==false) {
			
			userServiceImpl.addUser(user);
			System.out.println("user added :(👌👌👌 ");
			
		}
		else {
			System.out.println("user already exits 😤😤");
		}
	
		
		return "home";
		
		
	}
	
	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email,
			@RequestParam("password") String password, HttpSession session) {
		if (userServiceImpl.validateUser(email,password)==true){
			String role=userServiceImpl.getRole(email);
			
			session.setAttribute(email, email);
			if(role.equals("admin")) {
				return "adminhome";
			}
			else {
				return "customerhome";
			}
		}
		else {
			return "login";
		}
	
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}

	

}





































//System.out.println(user.getUsername()+" "+user.getEmail()+" "+
//user.getPassword()+" "+user.getGender()+" "+user.getRole()+" "
//+user.getAddress());
//








//
//@RequestParam("username") String username,
//@RequestParam("email") String email, 
//@RequestParam("password") String password,
//@RequestParam("gender") String gender,
//@RequestParam("role") String role,
//@RequestParam("address") String address