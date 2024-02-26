package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.crimeDetails;

@Repository
public interface CrimeRepository extends JpaRepository<crimeDetails, Long> {

//	crimeDetails findByAadharNumber(String aadhar);

	
	List<crimeDetails> findAllEagerBy();

	Optional<crimeDetails> findById(long id);

	void deleteById(long id);  

	crimeDetails findByAadhar(String aadhar);
	
	
	
//	@Query("SELECT u FROM crimeDetails u WHERE u.aadhar = :aadhar")
//	List<crimeDetails> findByUsername(@Param("aadhar") String aadhar);
	

//	@PostMapping("/parent")
//	public String createCriminalDetails(@RequestBody crimeDetails parent ) {
//
//		System.out.println("1");
//		
//		crimeDetailsRepository.save(parent);
//		
//		List<Crime> children = parent.getCrimeDetails3();
//		
//		System.out.println("Children : "+children);
//		
//		if (children != null) {
//			
//			System.out.println("2");
//			
//			for (Crime child : children) {
//				crimeDetailsRepo.saveAll(children);
//				child.setCriminalId11(parent); // Set the parent object in each child
//			}
//		}  
//
//		System.out.println("3");
//	//	crimeDetailsRepo.saveAll(children);
//
//		try {
//		System.out.println("4");
//			ser.saveUser(parent);
//			crimeDetailsRepo.saveAll(children);
////			return ResponseEntity.ok("Criminal Details submit successfully");
//			return "redirect:/user/index";
//		} catch (DuplicateAadharException e) {
////			System.out.println("5");
////			return ResponseEntity.badRequest().body(e.getMessage());
//			return "redirect:/user/index";
//		}
//
//	}
	

  
}
 