package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

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

@SuppressWarnings("unused")
@Controller

public class CrimeController {

	@Autowired
	private CrimeService ser;

	@Autowired
	private CrimeDetailsRepo crimeDetailsRepo;

	@Autowired
	private CrimeRepository crimeDetailsRepository;

	@PostMapping("/parent")
	public String saveParentWithChildren(@ModelAttribute crimeDetails parent) {
		// Save the parent entity first to generate its ID
		crimeDetails savedParent = crimeDetailsRepository.save(parent);

		// Set the parent ID in each child entity
		List<Crime> children = parent.getCrimeDetails3();

		System.out.println("Children  :  " + children);

		if (children != null) {
			for (Crime child : children) {
				child.setCriminalId11(savedParent); // Set the parent object in each child
			}

			if (!children.isEmpty()) {
				crimeDetailsRepo.saveAll(children);
			}
		}
		return "redirect:user/demo";
	}

	@PostMapping("/adharCard")
	public ResponseEntity<?> createUniqueAdhar(@RequestBody crimeDetails crimeDetails) {
		try {

			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$" + crimeDetails.toString());

			ser.saveUser(crimeDetails);
			return ResponseEntity.ok("Criminal Created Successfully");

		} catch (DuplicateAadharException e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		}
	}

//	
//	@PostMapping("/parent1")
//	public String saveParentWithChildren1(@ModelAttribute crimeDetails parent) {
//		// Save the parent entity first to generate its ID
//		crimeDetails savedParent = crimeDetailsRepository.save(parent);
//		
//		// Set the parent ID in each child entity
//		List<Crime> children = parent.getCrimeDetails3();
//		
//		System.out.println("Children  :  "+children);
//		
//		if (children != null) {
//			for (Crime child : children) {
//				child.setCriminalId11(parent); // Set the parent object in each child
//			}  
//			
//			
//			if (!children.isEmpty()) {
//				crimeDetailsRepo.saveAll(children);
//			}
//		}
//		return "redirect:user/demo";
//	}
//	

//	@PostMapping("/parent")
//	public ResponseEntity<?> createCriminalDetails(@ModelAttribute crimeDetails parent) {
//
//		System.out.println("1");
//		
//		List<Crime> children = parent.getCrimeDetails3();
//		if (children != null) {
//			
//			System.out.println("2");
//			
//			for (Crime child : children) {
//				child.setCriminalId11(parent); // Set the parent object in each child
//			}
//		}
//
//		System.out.println("3");
//		crimeDetailsRepo.saveAll(children);
//
//		try {
//		System.out.println("4");
//			ser.saveUser(parent);
//			return ResponseEntity.ok("Criminal Details submit successfully");
//		} catch (DuplicateAadharException e) {
//			System.out.println("5");
//			return ResponseEntity.badRequest().body(e.getMessage());
//		}
//
//	}

//	@PostMapping("/checkAadhar")
//    public String checkAadhar(@RequestBody String aadhar) {
//        crimeDetails user = ser.findByAadhar(aadhar); // Assuming you have a method in your UserRepository to find by Aadhar
//        if (user != null) {
//            return "exists";
//        } else {
//            return "not_exists";
//        }
//    }

}
