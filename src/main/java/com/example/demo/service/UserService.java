package com.example.demo.service;


import java.util.List;

import com.example.demo.model.Crime;
import com.example.demo.model.UserDtls;
import com.example.demo.model.crimeDetails;


public interface UserService {
	
	public UserDtls createUser(UserDtls user,String url);

	public boolean checkEmail(String email);
	
	public boolean verifyAccount(String code);
	
	List <Crime> findAllArticles();
	
	List<crimeDetails> findAllCrime();

	Crime findArticleById(Long id);

	Crime saveArticle(Crime newArticle);

	void deleteArticleById(Long id);

	crimeDetails saveArticle1(crimeDetails newArticle);
	
	crimeDetails findArticleById1(long id);

	void deleteArticleById1(long id);
	
//	public crimeDetails getAadharDataByAadharNumber(String aadhar);
	
	
}
