package com.example.demo.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class CrimeBuilder {

	private String crimeType;
	private String section;
	private String lastUpdate;
	private String crimeStatus;
	private String forwardTo;
	private String conclusion;
	private String addedBy;
	
	
	public CrimeBuilder withTitle(String crimeType) {
		this.crimeType = crimeType;
		return this;
	}
	public CrimeBuilder withSection(String section) {
		this.section = section;
		return this;
	}
	public CrimeBuilder withUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
		return this;
	}
	public CrimeBuilder withStatus(String crimeStatus) {
		this.crimeStatus = crimeStatus;
		return this;
	}
	public CrimeBuilder withForward(String forwardTo) {
		this.forwardTo = forwardTo;
		return this;
	}
	public CrimeBuilder withConclusion(String conclusion) {
		this.conclusion = conclusion;
		return this;
	}
	public CrimeBuilder withAddedBy(String addedBy) {
		this.addedBy = addedBy;
		return this;
	}
	
	
	
	public CrimeBuilder(String crimeType, String section, String lastUpdate, String crimeStatus, String forwardTo,
			String conclusion, String addedBy) {
		super();
		this.crimeType = crimeType;
		this.section = section;
		this.lastUpdate = lastUpdate;
		this.crimeStatus = crimeStatus;
		this.forwardTo = forwardTo;
		this.conclusion = conclusion;
		this.addedBy = addedBy;
	}
	public CrimeBuilder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Crime build() {
		Crime article = new Crime();
		article.setCrimeType(this.crimeType);
		article.setConclusion(this.conclusion);
		article.setSection(this.section);
		article.setCrimeStatus(this.crimeStatus);
		article.setForwardTo(this.forwardTo);
		article.setAddedBy(this.addedBy);
		article.setCrimeStatus(this.crimeStatus);
		
		return article;
	
	}
	
}
