package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Crime;
import com.example.demo.model.UserDtls;
import com.example.demo.model.crimeDetails;
import com.example.demo.repository.CrimeDetailsRepo;
import com.example.demo.repository.CrimeRepository;
import com.example.demo.repository.UserRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private CrimeDetailsRepo crimeRepo;
	
	@Autowired
	private CrimeRepository crimeRepo2;  

	@Override
	public UserDtls createUser(UserDtls user, String url) {

		user.setPassword(passwordEncode.encode(user.getPassword()));
		user.setRole("ROLE_USER");

		user.setEnabled(false);
		RandomString rn = new RandomString();
		user.setVerificationCode(rn.make(64));

		UserDtls us = userRepo.save(user);

		sendVerificationMail(user, url);

		return us;
	}

	@Override
	public boolean checkEmail(String email) {

		return userRepo.existsByEmail(email);
	}

	
	@Override
	public boolean checkAadhar(String aadhar) {
		return crimeRepo2.existsByAadhar(aadhar);
	}
	
	public void sendVerificationMail(UserDtls user, String url) {

		String from = "anujd4510@gmail.com";
		String to = user.getEmail();
		String subject = "Account Verification";
		String content = "Hello [[name]],<br>" + "Please click the link below to verify your registration :<br>"
				+ "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>" + "Thank You,<br>" + "Anuj";
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);

			helper.setFrom(from, "Anuj");
			helper.setTo(to);
			helper.setSubject(subject);

			content = content.replace("[[name]]", user.getFullName());

			String siteUrl = url + "/verify?code=" + user.getVerificationCode();

			content = content.replace("[[URL]]", siteUrl);

			helper.setText(content, true);

			mailSender.send(message);

		} catch (Exception e) {

		}
	}

	@Override
	public boolean verifyAccount(String code) {
		UserDtls user = userRepo.findByVerificationCode(code);
		if (user != null) {
			user.setEnabled(true);
			user.setAccountNonLocked(true);
			user.setVerificationCode(null);
			userRepo.save(user);
			return true;
		}
		return false;
	}

	@Override
	public List<Crime> findAllArticles() {
		return (List<Crime>) crimeRepo.findAllEagerBy();
	}

	@Override
	public List<crimeDetails> findAllCrime(){
		return (List<crimeDetails>) crimeRepo2.findAllEagerBy();
	}

	@Override
	public Crime findArticleById(Long id) {
		
		Optional<Crime> opt = crimeRepo.findById(id);
		return opt.get();
		
	}

	@Override
	public Crime saveArticle(Crime newArticle) {
		// TODO Auto-generated method stub
		return crimeRepo.save(newArticle);
	}

	@Override
	public void deleteArticleById(Long id) {
		crimeRepo.deleteById(id);
		
	}

	@Override
	public crimeDetails saveArticle1(crimeDetails newArticle) {
		
		return crimeRepo2.save(newArticle);
	}

	@Override
	public crimeDetails findArticleById1(long id) {
		
		Optional<crimeDetails> opt = crimeRepo2.findById(id);
		return opt.get();
	}

	@Override
	public void deleteArticleById1(long id) {
		crimeRepo2.deleteById(id);
		
	}

	@Override
	public void saveUser(crimeDetails parent) {
		
		crimeRepo2.save(parent);
		
	}

	

//	@Override
//	public crimeDetails getAadharDataByAadharNumber(String aadhar) {
//      return crimeRepo2.findByAadharNumber(aadhar);
//  }
	
	
	
}
