package com.luv2code.springdemo.region;

import java.util.ArrayList;
import java.util.List;

import com.luv2code.springdemo.enumerations.DemographicGroup;
import com.luv2code.springdemo.enumerations.ElectionTerm;
import com.luv2code.springdemo.mvc.ElectionData;
import com.luv2code.springdemo.mvc.SingletonThreshold;

public class Precinct extends Region{
	int precinctId;
	boolean isBloc;
	List<Edge> edges;
	
	
	public Precinct(int precinctId, boolean isBloc, List<Edge> edges) {
		super();
		this.precinctId = precinctId;
		this.isBloc = isBloc;
		this.edges = edges;
	}

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
		
		// (1) get election_data ( can be more than one )
		// (2) get total_vote and winning_votes of election_data (loop?)
		ElectionData data = new ElectionData();
		List<ElectionTerm> targetTerms = SingletonThreshold.getElecitonTerms();
		List<ElectionData> targetData = new ArrayList<ElectionData>();
		for(ElectionTerm term : targetTerms) {
			ElectionData electionData = getElectionDataForType(term);
			targetData.add(electionData);
		}
		
		long totalVotes = 0;
		long winningVotes = 0;
		for(ElectionData electionData : targetData) {
			totalVotes += electionData.getTotalVotes();
			winningVotes += electionData.getWinningVotes();
		}
		
		float winningVotePercentage = winningVotes / totalVotes;
		if((SingletonThreshold.blocVotingMinPercentage > winningVotePercentage) 
		|| (SingletonThreshold.blocVotingMaxPercentage < winningVotePercentage)){
			return false;
		}
		return true;
	}
	
}
	