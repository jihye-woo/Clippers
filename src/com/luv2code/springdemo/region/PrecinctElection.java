package com.luv2code.springdemo.region;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PrecinctElection")
public class PrecinctElection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eid")
	private int electionId;
	
	@Column(name = "etype")
	private String electionType;
	
	@Column(name = "eyear")
	private int electionYear;
	
	@Column(name = "totalvotes")
	private int totalVotes;
	
	@Column(name = "winparty")
	private String winParty;
	
	@Column(name = "winvotes")
	private int winVotes;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="pid")
	private Precincts precinct;
	
	@Column(name="pid", updatable=false,insertable=false)
	private int pid;

	public int getElectionId() {
		return electionId;
	}

	public void setElectionId(int electionId) {
		this.electionId = electionId;
	}

	public String getElectionType() {
		return electionType;
	}

	public void setElectionType(String electionType) {
		this.electionType = electionType;
	}

	public int getElectionYear() {
		return electionYear;
	}

	public void setElectionYear(int electionYear) {
		this.electionYear = electionYear;
	}

	public String getWinParty() {
		return winParty;
	}

	public void setWinParty(String winParty) {
		this.winParty = winParty;
	}

	public int getTotalVotes() {
		return totalVotes;
	}

	public void setTotalVotes(int totalVotes) {
		this.totalVotes = totalVotes;
	}

	public int getWinVotes() {
		return winVotes;
	}

	public void setWinVotes(int winVotes) {
		this.winVotes = winVotes;
	}

	public Precincts getPrecinct() {
		return precinct;
	}

	public void setPrecinct(Precincts precinct) {
		this.precinct = precinct;
	}
	
}
