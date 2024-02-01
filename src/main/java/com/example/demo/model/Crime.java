package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Crime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "criminalId")
	private crimeDetails criminalId11;
	
	@Column
	private String crimeType;
	private String section;
//	private String currentDate;
	private String lastUpdate;
	private String crimeStatus;
	private String forwardTo;
	private String conclusion;
	private String addedBy;
	public Crime(long id, crimeDetails criminalId11, String crimeType, String section, String lastUpdate,
			String crimeStatus, String forwardTo, String conclusion, String addedBy) {
		super();
		this.id = id;
		this.criminalId11 = criminalId11;
		this.crimeType = crimeType;
		this.section = section;
		this.lastUpdate = lastUpdate;
		this.crimeStatus = crimeStatus;
		this.forwardTo = forwardTo;
		this.conclusion = conclusion;
		this.addedBy = addedBy;
	}
	public Crime() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public crimeDetails getCriminalId11() {
		return criminalId11;
	}
	public void setCriminalId11(crimeDetails criminalId11) {
		this.criminalId11 = criminalId11;
	}
	public String getCrimeType() {
		return crimeType;
	}
	public void setCrimeType(String crimeType) {
		this.crimeType = crimeType;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getCrimeStatus() {
		return crimeStatus;
	}
	public void setCrimeStatus(String crimeStatus) {
		this.crimeStatus = crimeStatus;
	}
	public String getForwardTo() {
		return forwardTo;
	}
	public void setForwardTo(String forwardTo) {
		this.forwardTo = forwardTo;
	}
	public String getConclusion() {
		return conclusion;
	}
	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
	public String getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}
	
}
