package com.luv2code.springdemo.region;

import com.luv2code.springdemo.summary.ClusterSummary;

public class Cluster extends Region{
	private int clusterId;
	
	public Cluster() {
		super();
	}
	

	public ClusterSummary toSummary() {
		return new ClusterSummary();
	}
}
