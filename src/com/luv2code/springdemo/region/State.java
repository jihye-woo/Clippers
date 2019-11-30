package com.luv2code.springdemo.region;

import java.util.List;

import com.luv2code.springdemo.summary.StateSummary; 

public class State extends Region {
	private int stateId;
	private String stateName;
	private float majMinPoint;
	private List<District> originalDistricts;
	private List<Cluster> clusters;
	private List<Precinct> precincts;
	private int numberOfDistricts;
	
	public State(String stateName) {
		super();
		this.stateName = stateName;
	}
	
	public void saveCluster(List<Cluster> clusters) {
		return;
	}
	
	public List<Cluster> initClusters(){
		return null;
	}
	
	public void saveRedistrictedDistrict(List<Cluster> clusters) {
		return;
	}
	
	public StateSummary toSummary() {
		return new StateSummary();
	}
	
	public List<Edge> getMmCandidateEdges(){
		return null;
	}
	
	public List<Edge> getNonMmCandidateEdges(){
		return null;
	}
	
	public void finalIteration() {
		return;
	}
}