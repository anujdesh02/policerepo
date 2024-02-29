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

	
	
	public boolean existsByAadhar(String aadhar);

	
//	crimeDetails findByAadharNumber(String aadhar);

	
	
	
	List<crimeDetails> findAllEagerBy();

	Optional<crimeDetails> findById(long id);

	void deleteById(long id);  

	crimeDetails findByAadhar(String aadhar);


	
	
	 @Query("SELECT a.aadhar FROM crimeDetails a WHERE a.aadhar LIKE %:partialAadhar%")
	    List<String> findMatchingAadharNumbers(@Param("partialAadhar") String partialAadhar);

	    @Query("SELECT a FROM crimeDetails a WHERE a.aadhar = :aadhar")
	    crimeDetails findAadharDetails(@Param("aadhar") String aadhar);

		

	
	

  
}
 