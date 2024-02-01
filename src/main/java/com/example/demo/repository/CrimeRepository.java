package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.crimeDetails;

@Repository
public interface CrimeRepository extends JpaRepository<crimeDetails, Integer> {

}
