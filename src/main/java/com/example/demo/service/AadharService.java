package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.crimeDetails;
import com.example.demo.repository.CrimeRepository;

@Service
public class AadharService {
	
	
	@Autowired
	private CrimeRepository crimeRepo;
	
	 public List<String> getMatchingAadharNumbers(String partialAadhar) {
	        return crimeRepo.findMatchingAadharNumbers(partialAadhar);
	    }

	    public crimeDetails getAadharDetails(String aadharNumber) {
	        return crimeRepo.findAadharDetails(aadharNumber);
	    }

}
