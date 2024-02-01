package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Crime;
import com.example.demo.model.crimeDetails;
import com.example.demo.service.CrimeService;

@Controller

public class CrimeController {

	@Autowired
	private CrimeService ser;
	
	
	
	@PostMapping("/savecrime")
	public String save(@ModelAttribute crimeDetails c)
	{
		ser.save(c);
		return "index";
	}
	
	@PostMapping("/savecrimeDetails")
	public String saveCrimeDetails(@ModelAttribute Crime crime)
	{
		ser.saveCrimeDetails(crime);
		return "index";
	}

}
