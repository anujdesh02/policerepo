package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public crimeDetails save(crimeDetails c)
	{
		for(Crime crimeDetails : c.getCrimeDetails3())
		{
			crimeDetails.setCriminalId11(c);
		}
		return crepo.save(c);
	}
	public void saveCrimeDetails(Crime crime)
	{
		crimeDetails.save(crime);
	}
}
