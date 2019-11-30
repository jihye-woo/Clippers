package com.luv2code.springdemo.region;

import java.util.HashMap;

import javax.json.JsonObject;

import com.luv2code.springdemo.enumerations.DemographicGroup;
import com.luv2code.springdemo.enumerations.ElectionTerm;
import com.luv2code.springdemo.mvc.ElectionData;
import com.luv2code.springdemo.summary.Summary;


public class Region {
	HashMap<ElectionTerm, ElectionData> electionResults;
	HashMap<DemographicGroup, Long> population;
	JsonObject boundary;
	public Region() {
		
	}
	
	public long getTotalPopulation() {
		return 1;
	}
	
	public long getDemographicPopulation(DemographicGroup demoGroup) {
		return 1;
		
	}
	
	public ElectionData getElectionDataForType(ElectionTerm electionType) {
		return new ElectionData();
	}
	
	public void splitBoundary(Region r) {
		
	}
	
	public Summary toSummary() {
		return new Summary();
	}

}
