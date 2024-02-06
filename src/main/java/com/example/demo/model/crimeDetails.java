package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "criminal_data")
public class crimeDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String aadhar;
	private String pan; 
    private String email;
    private String mobile;
	private String status;
	
	
//    @OneToMany(mappedBy = "criminalId11", cascade = CascadeType.ALL)
	
//	  @OneToMany(mappedBy = "criminalId", fetch = FetchType.LAZY,
//	            cascade = CascadeType.ALL)
//	private List<Crime> crimeDetails3 =new ArrayList<>();
	
	@OneToMany(mappedBy = "criminalId",
            cascade = CascadeType.ALL)
private List<Crime> crimeDetails3 =new ArrayList<>();
	
	public List<Crime> getCrimeDetails3() {
		return crimeDetails3;
	}
	public void setCrimeDetails3(List<Crime> crimeDetails3) {
		this.crimeDetails3 = crimeDetails3;
	}
	
	public crimeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public crimeDetails(long id, String name, String aadhar, String pan, String email, String mobile, String status) {
		super();
		this.id = id;
		this.name = name;
		this.aadhar = aadhar;
		this.pan = pan;
		this.email = email;
		this.mobile = mobile;
		this.status = status;
	}
	@Override
	public String toString() {
		return "crimeDetails [id=" + id + ", name=" + name + ", aadhar=" + aadhar + ", pan=" + pan + ", email=" + email
				+ ", mobile=" + mobile + ", status=" + status + ", crimeDetails3=" + crimeDetails3 + "]";
	}
	public void add(String aadhar2) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
