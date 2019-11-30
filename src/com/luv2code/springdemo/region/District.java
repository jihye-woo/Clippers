package com.luv2code.springdemo.region;

import java.util.Set;

import com.luv2code.springdemo.enumerations.PoliticalParty;
import com.luv2code.springdemo.summary.DistrictSummary; 

public class District extends Region {
	private int districtId;
	private String representativeName;
	private PoliticalParty representativeParty;
	private Set<Precinct> precincts;
	
	public District() {
		super();
	}
	
	
	public DistrictSummary toSummary() {
		return new DistrictSummary();
	}
}
