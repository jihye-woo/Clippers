package com.luv2code.springdemo.mvc;
import java.util.HashSet;
import java.util.Set;

import javax.json.JsonObject;

import com.luv2code.springdemo.region.Cluster;
import com.luv2code.springdemo.region.Precincts;
import com.luv2code.springdemo.region.Region;


public class Algorithm {

	float ofWeight[];
	
	public void mergeBoundary(Region r1, Region r2) {
		
	}
	
	
	private JsonObject calculateBoundarySum(JsonObject a, JsonObject b) {
		return a;
	}
	
	private JsonObject calculateBoundaryDifference(JsonObject a, JsonObject b) {
		return a;
	}
	
	public void splitBoundary(Region r1, Region r2) {
	}
	

	
//	public boolean groupIsBloc(Precinct p, DemographicGroup demo) {
//		return true;
//	}
	
	private void joinCandidatePairs(Cluster c1, Cluster c2) {
		
	}
	
	public float joinabilityFunction(Cluster c1, Cluster c2) {
		return 1;
	}
	
	public float calculateOF(Set<Cluster> clusters) {
		return 1;
	}
	
	private float compactnessFunction(Set<Cluster> clusters) {
		return 1;
	}
	
	private float politicalFairnessFunction(Set<Cluster> clusters) {
		return 1;
	}
	
	private float populationEqualityFunction(Set<Cluster> clusters) {
		return 1;
	}
	
	public Set<Precincts> getRandomNeihboringPrecincts(Cluster c1, Cluster c2) {
		return new HashSet<Precincts>();
	}
	
}
