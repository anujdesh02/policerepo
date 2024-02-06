package com.example.demo.model;


public class crimeDetailsBuilder {
	
	private String name;
	private String aadhar;
	private String pan; 
    private String email;
    private String mobile;  
	private String status;

	
	
	public crimeDetailsBuilder withName(String name) {
		this.name = name;
		return this;
	}
	public crimeDetailsBuilder withAadhar(String aadhar) {
		this.aadhar = aadhar;
		return this;
	}
	public crimeDetailsBuilder withPan(String pan) {
		this.pan = pan;
		return this;
	}
	public crimeDetailsBuilder withEmail(String email) {
		this.email = email;
		return this;
	}
	public crimeDetailsBuilder withMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	public crimeDetailsBuilder withStatus(String status) {
		this.status = status;
		return this;
	}
	
	
	public crimeDetailsBuilder(String name, String aadhar, String pan, String email, String mobile, String status) {
		super();
		this.name = name;
		this.aadhar = aadhar;
		this.pan = pan;
		this.email = email;
		this.mobile = mobile;
		this.status = status;
	}

	public crimeDetailsBuilder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public crimeDetails build() {
		crimeDetails article = new crimeDetails();
		article.setName(this.name);
		article.setEmail(this.email);
		article.setAadhar(this.aadhar);
		article.setPan(this.pan);
		article.setMobile(this.mobile);
		article.setStatus(this.status);
		
		return article;
	
	}
}
