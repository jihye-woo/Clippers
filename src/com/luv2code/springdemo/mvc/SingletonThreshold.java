package com.luv2code.springdemo.mvc;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.luv2code.springdemo.enumerations.DemographicGroup;
import com.luv2code.springdemo.enumerations.ElectionTerm;

public class SingletonThreshold {
	private static SingletonThreshold singleton = null;
	static public float blocPopulationMinPercentage;
	static public float blocPopulationMaxPercentage;
	static public float blocVotingMinPercentage;
	static public float blocVotingMaxPercentage;
	static public Set<DemographicGroup> demoGroup;
	static public ElectionTerm electionTerm;
	static public HashMap<String, Integer> districtNumberGoals;
	static public float joinabilityPercentage;
	
	private SingletonThreshold() {
		blocPopulationMinPercentage = 50;
		blocPopulationMaxPercentage = 50;
		blocVotingMinPercentage = 50;
		blocVotingMaxPercentage = 50;
		
		Set<DemographicGroup> demoGroup = new HashSet();
	}
	
	public static SingletonThreshold getSingletonThreshold() {
		if(singleton == null) {
			singleton = new SingletonThreshold();
		}
		return singleton;
	}
	
	public void saveThreshold(float popMin, float popMax, float votingMin, float votingMax, ElectionTerm term) {
		blocPopulationMinPercentage = popMin;
		blocPopulationMaxPercentage = popMax;
		blocVotingMinPercentage = votingMin;
		blocVotingMaxPercentage = votingMax;
		electionTerm = term;
	}
	
	public Set<DemographicGroup> getTargetPopulation() {
		return demoGroup;
	}
	
	public float getDemographicMin() {
		return blocPopulationMinPercentage;
	}
	public void setDemographicMin(float minDemo) {
		blocPopulationMinPercentage = minDemo;
	}
	
	public float getDemographicMax() {
		return blocPopulationMaxPercentage;
	}
	
	public void setDemographicMax(float maxDemo) {
		blocPopulationMinPercentage = maxDemo;
	}
	
	public float getVotingMin() {
		return blocVotingMinPercentage;
	}
	
	public void setVotingMin(float minVote) {
		blocVotingMinPercentage = minVote;
	}
	
	public float getVotingMax() {
		return blocVotingMaxPercentage;
	}
	
	public void setVotingMax(float maxVote) {
		blocVotingMaxPercentage = maxVote;
	}
	
	public ElectionTerm getElectionTerm() {
		return electionTerm;
	}
	
 }
