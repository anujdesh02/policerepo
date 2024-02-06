package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Crime;

@Repository
public interface CrimeDetailsRepo extends JpaRepository<Crime, Long> {
	
	List<Crime> findAllEagerBy();
	
//	@EntityGraph
	Optional<Crime> findById(Long id);
	

}
