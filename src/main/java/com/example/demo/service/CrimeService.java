package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.expection.DuplicateAadharException;
import com.example.demo.model.Crime;
import com.example.demo.model.crimeDetails;
import com.example.demo.repository.CrimeDetailsRepo;
import com.example.demo.repository.CrimeRepository;

@Service
public class CrimeService {

	@Autowired
	private CrimeRepository crepo;

	@Autowired
	private CrimeDetailsRepo crimeDetails;

//	public void save(crimeDetails c)
//	{
//		for(Crime crimeDetails : c.getCrimeDetails3())
//		{
//			crimeDetails.setCriminalId11(c);
//		}
//		crepo.save(c);
//	}
//	public crimeDetails save(crimeDetails c)
//	{
//		for(Crime crimeDetails : c.getCrimeDetails3())
//		{
//			crimeDetails.setCriminalId11(c);
//		}
//		return crepo.save(c);
//	}
//	public void saveCrimeDetails(Crime crime)
//	{
//		crimeDetails.save(crime);
//	}

//	public List<crimeDetails> getAadharDataByAadharNumber(String aadhar) {
//        return crepo.findByAadharNumber(aadhar);
//    }
	
	  
	 @Autowired
	    private CrimeRepository crimeDetailsRepository;

	    @Autowired
	    private CrimeDetailsRepo crimeDetailsRepo;

	    @Autowired
	    private UserService userService; 
	
//	    public void saveParentWithChildren(crimeDetails parent) {
//	        // Save the parent entity first to generate its ID
//	        crimeDetailsRepository.save(parent);
//
//	        // Set the parent ID in each child entity and save children
//	        List<Crime> children = parent.getCrimeDetails3();
//	        if (children != null) {
//	            for (Crime child : children) {
//	                child.setCriminalId11(parent); // Set the parent object in each child
//	            }
//	            crimeDetailsRepo.saveAll(children);
//	        }
//
//	        // Save user
//	        try {
//	            userService.saveUser(parent);
//	        } catch (DuplicateAadharException e) {
//	            // Handle exception or log
//	        }
//	    }
	
	    public void saveParentWithChildren(crimeDetails parent) {
	    	crepo.save(parent);
	    }     
	    
	
	
	
	    
	  
//
	public void saveParentWithChildren1(Crime parent) {

		crimeDetails.save(parent);
	}
//
	public crimeDetails findByAadhar(String aadhar) {

		return crepo.findByAadhar(aadhar); 
	}
	  
	


	public crimeDetails saveUser(crimeDetails user) {
		
//		for(Crime crime : user.getCrimeDetails3())
//		{
//			crime.setCriminalId11(user);
//		}

		if (crepo.findByAadhar(user.getAadhar()) != null) {
			throw new DuplicateAadharException("Criminal already exists");
		}
		return crepo.save(user);
	  
	}






	
}
