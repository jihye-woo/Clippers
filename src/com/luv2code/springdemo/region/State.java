package com.luv2code.springdemo.region;

import java.util.HashSet;
import java.util.Set;

import com.luv2code.springdemo.enumerations.ElectionTerm;
import com.luv2code.springdemo.mvc.SetOperation;
import com.luv2code.springdemo.mvc.SingletonThreshold;
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
	
	public StateSummary toSummary() {
		return new StateSummary();
	}
	
	public Set<Edge> getMmCandidateEdges(Set<Cluster> clusters){
		Set<Edge> candidateEdges = new HashSet<Edge>();
		Set<ElectionTerm> electionTerms = SingletonThreshold.getElectionTerms();
		Set<Edge> allEdges = SetOperation.getAllEdges(clusters);
		
		for(Edge edge : allEdges) {
			Cluster firstCluster = edge.getFirstRegion();
			Cluster secondCluster = edge.getSecondRegion();
		}
		return null;
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
	
	public void finalIteration() {
		return;
	}
	
	
	
	
	
	// getter setter
	
	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public float getMajMinPoint() {
		return majMinPoint;
	}

	public void setMajMinPoint(float majMinPoint) {
		this.majMinPoint = majMinPoint;
	}

	public Set<District> getOriginalDistricts() {
		return originalDistricts;
	}

	public void setOriginalDistricts(Set<District> originalDistricts) {
		this.originalDistricts = originalDistricts;
	}

	public Set<Cluster> getClusters() {
		return clusters;
	}

	public void setClusters(Set<Cluster> clusters) {
		this.clusters = clusters;
	}

	public Set<Precincts> getPrecincts() {
		return precincts;
	}

	public void setPrecincts(Set<Precincts> precincts) {
		this.precincts = precincts;
	}

	public int getNumberOfDistricts() {
		return numberOfDistricts;
	}

	public void setNumberOfDistricts(int numberOfDistricts) {
		this.numberOfDistricts = numberOfDistricts;
	}
	public Set<Edge> getNonMmCandidateEdges(){
		return null;
	}
	
	
}