package com.example.demo.controller;

import java.io.Console;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.UserDtls;
import com.example.demo.model.crimeDetails;
import com.example.demo.repository.CrimeRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CrimeService;
import com.example.demo.service.UserServiceImpl;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;
	
	@Autowired
	private CrimeRepository crimeDetailsRepo;
	
	
	@Autowired
	private CrimeService crimeDetails;
	
	@Autowired
	private UserServiceImpl UserServiceImpll;

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
	
	@GetMapping("/crimedetails")      
	public String crimedetails() {
		return "user/criminaldetails";
	}
	@GetMapping("/c")      
	public String c() {
		return "user/c";
	}
	@GetMapping("/crime")      
	public String crime() {
		return "user/crime";
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
	
	
	@GetMapping("/search")
	public String searchBar() {
		return "user/searchbar";
	}  
	
//	@PostMapping("/search")
//	public List<crimeDetails> getUserByUsername(String aadharNumber)
//	{
//		System.out.println("Adhar : "+aadharNumber);
//		
//		List<crimeDetails> a= crimeDetailsRepo.findByUsername(aadharNumber);
////		System.out.println(c.getAadhar()+a);
//	  List<crimeDetails> cr=crimeDetailsRepo.findByUsername(aadharNumber);
//	   System.out.println(".................."+aadharNumber);
//	  
//		System.out.println("Data : " + a);
//		
//		return a; 
//		 
//	}
	
	

//    @GetMapping("/getAadharData")
//    public crimeDetails getAadharData(@RequestParam String aadhar) {
//    	crimeDetails aadharData = UserServiceImpll.getAadharDataByAadharNumber(aadhar);
//        if (aadharData != null) {
//            return aadharData;
//        } else {
//            return aadharData;
//        }
//    }
	
	@PostMapping("/getAadharData")
	public String getAllData(crimeDetails c, @RequestParam String aadhar)
	{
		List<crimeDetails> a=crimeDetailsRepo.findAll();
		
		System.out.println("Data : "+a);
		
		System.out.println("Adhar no : " + aadhar);


		List<String> aadharNumbers = new ArrayList<>();

		for (crimeDetails crimeDetail : a) {
		    aadharNumbers.add(crimeDetail.getAadhar());
		}
		
		System.out.println("Adhar Card Number : "+aadharNumbers);
		
		if (aadharNumbers.contains(aadhar)) {
			
             return "user/showDataCriminal";
		}
		else    
		{
			
			return "user/c";
		}
		

		//return "user/c"; 
	}
	
	
	
}
