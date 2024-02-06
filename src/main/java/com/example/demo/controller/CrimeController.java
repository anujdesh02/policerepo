package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Crime;
import com.example.demo.model.crimeDetails;
import com.example.demo.repository.CrimeDetailsRepo;
import com.example.demo.repository.CrimeRepository;
import com.example.demo.service.CrimeService;

@Controller

public class CrimeController {

	@Autowired
	private CrimeService ser;
	
	
	
	
	
	@PostMapping("/savecrime")
	public String save(@ModelAttribute crimeDetails c)
	{
		ser.save(c);
		return "user/crime";
	}
	
	@PostMapping("/savecrimeDetails")
	public String saveCrimeDetails(@ModelAttribute Crime crime)
	{
		ser.saveCrimeDetails(crime);
		return "index";
	}
	
	

}
