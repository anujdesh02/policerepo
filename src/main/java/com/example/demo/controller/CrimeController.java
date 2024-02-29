package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.expection.DuplicateAadharException;
import com.example.demo.model.Crime;
import com.example.demo.model.crimeDetails;
import com.example.demo.repository.CrimeDetailsRepo;
import com.example.demo.repository.CrimeRepository;
import com.example.demo.service.CrimeService;
import com.example.demo.service.UserService;

@SuppressWarnings("unused")
@Controller

public class CrimeController {

	@Autowired
	private CrimeService ser;

	@Autowired
	private CrimeDetailsRepo crimeDetailsRepo;

	@Autowired
	private CrimeRepository crimeDetailsRepository;
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/parent")
	public String saveParentWithChildren(@ModelAttribute crimeDetails parent,  HttpSession session) {

		boolean f =  userService.checkAadhar(parent.getAadhar());
		
		if(f) {
			
			session.setAttribute("msg", "Aadhar already exists");

		}
		else
		{
			crimeDetails savedParent = crimeDetailsRepository.save(parent);
			
			List<Crime> children = parent.getCrimeDetails3();
			
			System.out.println("Children  :  "+children);
			
			if (children != null) {
				for (Crime child : children) {
					child.setCriminalId11(savedParent); // Set the parent object in each child
				}
				
				
				if (!children.isEmpty()) {
		            crimeDetailsRepo.saveAll(children);
		        }
			}
			
			if (savedParent != null) {
				session.setAttribute("msg", "Criminal Register Sucessfully");
			}
			else
			{
				session.setAttribute("msg", "something wrong on server");
			}
			
		}
		
		
		
		
		
		
//		crimeDetails savedParent = crimeDetailsRepository.save(parent);
//
//		List<Crime> children = parent.getCrimeDetails3();
//		
//		System.out.println("Children  :  "+children);
//		
//		if (children != null) {
//			for (Crime child : children) {
//				child.setCriminalId11(savedParent); // Set the parent object in each child
//			}
//			
//			
//			if (!children.isEmpty()) {
//	            crimeDetailsRepo.saveAll(children);
//	        }
//		}
		return "redirect:user/demo";
	}
	
	
	
	
	@PostMapping("/parent1")
	public String saveParentWithChildren1(@ModelAttribute crimeDetails parent) {


		List<Crime> children = parent.getCrimeDetails3();
		
		
		if (children != null) {
			
			crimeDetails savedParent = crimeDetailsRepository.save(parent);

			
			for (Crime child : children) {
				child.setCriminalId11(savedParent); 			}
			
			
			if (!children.isEmpty()) {
//	            crimeDetailsRepo.saveAll(children);
	        }
		}
		return "redirect:user/index";
	}
	
	
	
	
	
	
	
	
	
	
//	@PostMapping("/adharCard")
//	public ResponseEntity<?> createUniqueAdhar(@RequestBody crimeDetails crimeDetails)
//	{
//	  try {
//		  
//		  ser.saveUser(crimeDetails);
//		  return ResponseEntity.ok("Criminal Created Successfully");
//		
//	} catch (DuplicateAadharException e) {
//		  return ResponseEntity.badRequest().body(e.getMessage());
//
//	}	
//	}
	
	


}
