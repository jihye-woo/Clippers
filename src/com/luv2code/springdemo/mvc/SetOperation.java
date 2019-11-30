package com.luv2code.springdemo.mvc;

import java.util.ArrayList;
import java.util.List;

import com.luv2code.springdemo.region.Cluster;
import com.luv2code.springdemo.region.Edge;

public class SetOperation {

	public SetOperation() {
		
	}
	
	public List<Cluster> getDifference(List<Cluster> c1s, List<Cluster> c2s){
		return new ArrayList<Cluster>();
	}
	public List<Edge> getAllEdges(List<Cluster> clusters){
		return new ArrayList<Edge>();
	}
	
	public List<Edge> getMaxMatching(List<Cluster> clusters){
		return new ArrayList<Edge>();
	}
	
	public Cluster getMinPopCluster(List<Cluster> clusters) {
		return new Cluster();
	}
	
	public List<Cluster> joinCandiatePairs(List<Edge> edges){
		return new ArrayList<Cluster>();
	}
}
