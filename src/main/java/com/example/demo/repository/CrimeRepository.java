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
	
//	@Query("SELECT u FROM crimeDetails u WHERE u.aadhar = :aadhar")
//	List<crimeDetails> findByUsername(@Param("aadhar") String aadhar);
	


  
}
 