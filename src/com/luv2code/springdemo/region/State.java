package com.luv2code.springdemo.region;

import java.util.Set;

import com.luv2code.springdemo.summary.StateSummary; 

public class State extends Region {
	private int stateId;
	private String stateName;
	private float majMinPoint;
	private Set<District> originalDistricts;
	private Set<Cluster> clusters;
	private Set<Precincts> precincts;
	private int numberOfDistricts;
	
	public State(String stateName) {
		super();
		this.stateName = stateName;
	}
	
	public void saveCluster(Set<Cluster> clusters) {
		return;
	}
	
	public Set<Cluster> initClusters(){
		return clusters;
	}
	
	public void saveRedistrictedDistrict(Set<Cluster> clusters) {
		return;
	}
	
	public StateSummary toSummary() {
		return new StateSummary();
	}
	
	public Set<Edge> getMmCandidateEdges(){
		return null;
	}
	
	public Set<Edge> getNonMmCandidateEdges(){
		return null;
	}
	
	public void finalIteration() {
		return;
	}
}