package com.example.demo.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Crime;
import com.example.demo.model.CrimeBuilder;
import com.example.demo.model.UserDtls;
import com.example.demo.model.crimeDetails;
import com.example.demo.model.crimeDetailsBuilder;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService service;

//	@GetMapping("/")
//	public String home() {
//		return "admin/adminHome";  
//	}  
	@Autowired
	private UserRepository repository;

	@GetMapping("/")
	public String home() {
		return "admin/index";
	}

	@GetMapping("/admin")
	public String user() {
		return "admin/userprofile";
	}

	@GetMapping("/index")
	public String index() {
		return "admin/index";
	}

	@GetMapping("/about")
	public String About() {
		System.out.println("Admin Page");
		return "admin/about";
	}  
	
	@ModelAttribute
	private void userDetails(Model m, Principal p) {
		String email = p.getName();
		UserDtls user = repository.findByEmail(email);

		m.addAttribute("user", user);

	}  

	@RequestMapping("/article-list")
	public String articleList(Model model) {
		List<Crime> articles = service.findAllArticles();
		model.addAttribute("articles", articles);
		return "admin/articleList";
	}

	@RequestMapping("/criminal-list")
	public String CriminalList(Model model) {
		List<crimeDetails> articles = service.findAllCrime();
		model.addAttribute("articles", articles);
		return "admin/criminalData";
	}

	@RequestMapping("/edit")
	public String editArticle(@RequestParam("id") Long id, Model model) {
		Crime article = service.findArticleById(id);

		model.addAttribute("article", article);

		return "admin/editArticle";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editArticlePost(@ModelAttribute("article") Crime article, HttpServletRequest request) {
		Crime newArticle = new CrimeBuilder().withTitle(article.getCrimeType()).withConclusion(article.getConclusion())
				.withUpdate(article.getLastUpdate()).withForward(article.getForwardTo())
				.withSection(article.getSection()).withStatus(article.getCrimeStatus())
				.withAddedBy(article.getAddedBy()).build();
		newArticle.setId(article.getId());
		service.saveArticle(newArticle);
		return "redirect:article-list";
	}

	@RequestMapping("/delete")
	public String deleteArticle(@RequestParam("id") Long id) {
		service.deleteArticleById(id);
		return "redirect:article-list";
	}

	@RequestMapping("/edit1")
	public String editCrimeDetails(@RequestParam("id") long id, Model model) {
		crimeDetails article = service.findArticleById1(id);

		model.addAttribute("article", article);

		return "admin/editCrimeDetails";  
	}

	@RequestMapping(value = "/edit1", method = RequestMethod.POST)
	public String editCrimeDetails(@ModelAttribute("article") crimeDetails article, HttpServletRequest request) {
		crimeDetails newArticle = new crimeDetailsBuilder().withName(article.getName()).withAadhar(article.getAadhar())
				.withPan(article.getPan()).withEmail(article.getEmail()).withMobile(article.getMobile())
				.withStatus(article.getStatus()).build();
		newArticle.setId(article.getId());
		service.saveArticle1(newArticle);
		return "redirect:criminal-list";
	}

	@RequestMapping("/delete1")
	public String deleteCrimeDetails(@RequestParam("id") long id) {
		service.deleteArticleById1(id);
		return "redirect:criminal-list";
	}

}
