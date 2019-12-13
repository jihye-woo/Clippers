package com.luv2code.springdemo.mvc;

import java.util.HashSet;
import java.util.Set;

import com.luv2code.springdemo.region.Cluster;
import com.luv2code.springdemo.region.Edge;

public class SetOperation {

	public SetOperation() {
		
	}
	
	public Set<Cluster> getDifference(Set<Cluster> c1s, Set<Cluster> c2s){
		return new HashSet<Cluster>();
	}
	public static Set<Edge> getAllEdges(Set<Cluster> clusters){
		return new HashSet<Edge>();
	}
	
	public static Set<Edge> getMaxMatching(Set<Edge> clusters){
		return new HashSet<Edge>();
	}
	
	public Cluster getMinPopCluster(Set<Cluster> clusters) {
		return new Cluster();
	}
	
	public static Set<Cluster> joinCandiatePairs(Set<Edge> edges){
		return new HashSet<Cluster>();
	}
}
