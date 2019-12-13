package com.luv2code.springdemo.region;

import java.util.HashSet;
import java.util.Set;

import com.luv2code.springdemo.enumerations.ElectionTerm;
import com.luv2code.springdemo.mvc.ElectionData;
import com.luv2code.springdemo.summary.ClusterSummary;

public class Cluster extends Region{
	private int clusterId;
	private Set<ElectionData> electiondata; 
	
	public Cluster() {
		super();
	}
	

	public ClusterSummary toSummary() {
		return new ClusterSummary();
	}
	
	public Set<ElectionData> getElectionData(ElectionTerm term) {
		return new HashSet<ElectionData>();
	}
}
