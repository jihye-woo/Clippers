package com.luv2code.springdemo.summary;

import java.util.HashMap;

import javax.json.JsonObject;

import com.luv2code.springdemo.enumerations.DemographicGroup;
import com.luv2code.springdemo.enumerations.ElectionTerm;
import com.luv2code.springdemo.mvc.ElectionData;

public class Summary {

	private JsonObject boundary;
	private HashMap<ElectionTerm, ElectionData> electionResults;
	private HashMap<DemographicGroup, Long> population;
	
	public JsonObject getBoundary() {
		return boundary;
	}
	public void setBoundary(JsonObject boundary) {
		this.boundary = boundary;
	}
	public HashMap<ElectionTerm, ElectionData> getElectionResults() {
		return electionResults;
	}
	public void setElectionResults(HashMap<ElectionTerm, ElectionData> electionResults) {
		this.electionResults = electionResults;
	}
	public HashMap<DemographicGroup, Long> getPopulation() {
		return population;
	}
	public void setPopulation(HashMap<DemographicGroup, Long> population) {
		this.population = population;
	}
	
}
