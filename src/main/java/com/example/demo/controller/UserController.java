package com.example.demo.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.UserDtls;
import com.example.demo.repository.UserRepository;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	@ModelAttribute
	private void userDetails(Model m, Principal p) {
		String email = p.getName();
		UserDtls user = userRepo.findByEmail(email);

		m.addAttribute("user", user);

	}  

	@GetMapping("/")
	public String home() {
		return "user/index";
	}
	@GetMapping("/user")
	public String user() {
		return "user/userprofile";
	}
	@GetMapping("/index")
	public String index() {
		return "user/index";
	}
	@GetMapping("/changPass")
	public String loadChnagePassword() {
		return "user/change_password";
	}
	
	@PostMapping("/updatePassword")
	public String changePassword(Principal p,@RequestParam("oldPass")
	String oldPass,@RequestParam("newPass")String newPass,HttpSession session) {
		
		String email = p.getName();
		
		UserDtls loginUser = userRepo.findByEmail(email);
		
		boolean f = passwordEncode.matches(oldPass, loginUser.getPassword());
		
		if(f) {
			
			loginUser.setPassword(passwordEncode.encode(newPass));
			UserDtls updatePasswordUser = userRepo.save(loginUser);
			if(updatePasswordUser!=null)
			{
				session.setAttribute("msg", "Password Change Success");
			}
			else
			{
				session.setAttribute("msg", "Something Went Wrong On Server");
			}
		}
		else 
		{
			session.setAttribute("msg", "Old Password Incorrect");
		}
		
		return "redirect:/user/changPass";
	}
}
