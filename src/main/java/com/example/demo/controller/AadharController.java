package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.crimeDetails;
import com.example.demo.service.AadharService;

@Controller
public class AadharController {
	
	 @Autowired
	    private AadharService aadharService;

	    @GetMapping("/aadharNumbers")
	    public List<String> getAadharNumbers(@RequestParam("partialAadhar") String partialAadhar) {
	        return aadharService.getMatchingAadharNumbers(partialAadhar);
	    }

	    @GetMapping("/aadharDetails")
	    public crimeDetails getAadharDetails(@RequestParam("aadharNumber") String aadharNumber) {
	        return aadharService.getAadharDetails(aadharNumber);
	    }

}
