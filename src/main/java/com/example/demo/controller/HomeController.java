package com.example.demo.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.UserDtls;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;


@Controller
//@RestController
public class HomeController {
	
	
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@ModelAttribute
	private void userDetails(Model m, Principal p) {

		if (p != null) {
			String email = p.getName();
			UserDtls user = userRepo.findByEmail(email);
			m.addAttribute("user", user);
		}
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}


	@PostMapping("/createUser")
	public String createuser(@ModelAttribute UserDtls user, HttpSession session,HttpServletRequest request) {

		// System.out.println(user);
		String url =request.getRequestURL().toString();
		//http://localhost:8080/createUser
		url=url.replace(request.getServletPath(), "");
		
		boolean f = userService.checkEmail(user.getEmail());

		if (f) {
			session.setAttribute("msg", "Email Id alreday exists");
		}

		else {
			UserDtls userDtls = userService.createUser(user,url);
			if (userDtls != null) {
				session.setAttribute("msg", "Register Sucessfully");
			} else {
				session.setAttribute("msg", "Something wrong on server");
			}
		}
		return "redirect:/register";
	}
	@GetMapping("/verify")
	public String verifyAccount(@Param("code")String code) {
		
		if(userService.verifyAccount(code))
		{
			return "verify_success";
		}
		
		return "verify_failed";
	}
	
	
	@GetMapping("/loadForgotPassword")
	public String loadForgotPassword() {
		return "forgot_password";
	}

	@GetMapping("/loadResetPassword/{id}")
	public String loadResetPassword(@PathVariable int id, Model m) {
//		System.out.println(id);
		m.addAttribute("id", id);
		return "reset_password";
	}

	@PostMapping("/forgotPassword")
	public String forgotPassword(@RequestParam String email, @RequestParam String mobileNum, HttpSession session) {

		UserDtls user = userRepo.findByEmailAndMobileNumber(email, mobileNum);

		if (user != null) {
			return "redirect:/loadResetPassword/" + user.getId();
		} else {
			session.setAttribute("msg", "Invalid Email Mobile Number");
			return "forgot_password";
		}

	}

	@PostMapping("/changePassword")
	public String resetPassword(@RequestParam String psw, @RequestParam Integer id,HttpSession session) {

		UserDtls user = userRepo.findById(id).get();
		String encryptPsw = passwordEncoder.encode(psw);
		user.setPassword(encryptPsw);
		UserDtls updateUser = userRepo.save(user);
		
		if(updateUser!=null)
		{
			session.setAttribute("msg", "Password Change Successfully");
		}
		
		return "redirect:/loadForgotPassword";  
	}
  
	
	

	@RequestMapping(value = "/index1", method = RequestMethod.GET)
	public String index1() {
		System.out.println("Index");
		return "index";
	}
	
//	@GetMapping("/policeform1")
//	public String  policeForm() {
//		return "policeform1";
//	} 
	
	@GetMapping("/displaydata")
	public String  displayData() {
		return "displaydata";
	}
}
   