package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.crimeDetails;
import com.example.demo.service.CrimeService;

@Controller

public class CriminalController {

	@Autowired
	private CrimeService service;
	
	
	@PostMapping("/child")   
	public String submitForm(@ModelAttribute crimeDetails user, Model model) {

		crimeDetails userData = service.findByAadhar(user.getAadhar());
		if (userData != null) {
			model.addAttribute("user", userData);
			System.out.println("Gotya");
//			return "redirect:user/showData";
			
			return "user/showData";
			
		} else {  
			System.out.println("Taklya");

//			return "redirect:user/showData";
			return "user/demo";

		}
	}    
	
	
	
	
	
}
