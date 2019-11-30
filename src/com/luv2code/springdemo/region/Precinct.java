package com.luv2code.springdemo.region;

import java.util.List;

import com.luv2code.springdemo.enumerations.DemographicGroup;
import com.luv2code.springdemo.mvc.SingletonThreshold;

public class Precinct extends Region{
	int precinctId;
	boolean isBloc;
	List<Edge> edges;
	
	
	public boolean precinctIsBloc() {
		List<DemographicGroup> targetDemographicGroup = SingletonThreshold.getTargetPopulation();
		float demographicMinPerc = SingletonThreshold.getDemographicMin();
		float demographicMaxPerc = SingletonThreshold.getDemographicMax();
		
		long totalPopulation = getTotalPopulation();
		
		long demographicPopulation = 0;
		for(DemographicGroup demo : targetDemographicGroup) {
			demographicPopulation += getDemographicPopulation(demo);
		}
		
		long percentage = demographicPopulation / totalPopulation;
		
		
		// 1. demographic
		if(percentage < demographicMinPerc || percentage > demographicMaxPerc) {
			return false;
		}
		
		// 2. voting number
//		ElectionData data = new ElectionData();
		
		
		return true;
	}
	
	
}
	