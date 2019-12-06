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
	static public Set<ElectionTerm> electionTerms;
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
	
	public static void saveThreshold(float popMin, float popMax, float votingMin, float votingMax, Set<ElectionTerm> terms) {
		blocPopulationMinPercentage = popMin;
		blocPopulationMaxPercentage = popMax;
		blocVotingMinPercentage = votingMin;
		blocVotingMaxPercentage = votingMax;
		electionTerms = terms;
	}
	
	static public Set<DemographicGroup> getTargetPopulation() {
		return demoGroup;
	}
	
	static public float getDemographicMin() {
		return blocPopulationMinPercentage;
	}
	static public void setDemographicMin(float minDemo) {
		blocPopulationMinPercentage = minDemo;
	}
	
	static public float getDemographicMax() {
		return blocPopulationMaxPercentage;
	}
	
	static public void setDemographicMax(float maxDemo) {
		blocPopulationMinPercentage = maxDemo;
	}
	
	static public float getVotingMin() {
		return blocVotingMinPercentage;
	}
	
	static public void setVotingMin(float minVote) {
		blocVotingMinPercentage = minVote;
	}
	
	static public float getVotingMax() {
		return blocVotingMaxPercentage;
	}
	
	static public void setVotingMax(float maxVote) {
		blocVotingMaxPercentage = maxVote;
	}
	
	static public Set<ElectionTerm> getElecitonTerms() {
		return electionTerms;
	}
 }
