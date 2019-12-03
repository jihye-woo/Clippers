package com.luv2code.springdemo.mvc;

import java.util.HashMap;

import com.luv2code.springdemo.enumerations.ElectionTerm;
import com.luv2code.springdemo.enumerations.PoliticalParty;

public class ElectionData {
	ElectionTerm term;
	HashMap<PoliticalParty, Long> votes;
	PoliticalParty winningParty;
	
	public PoliticalParty getWinningParty() {
		long min = -1;
		PoliticalParty minParty = null;
		for(PoliticalParty party : votes.keySet()) {
			if(min == -1) {
				min = votes.get(party);
				minParty = party;
			}
			else {
				long another_min = votes.get(party);
				minParty = another_min < min ? party : minParty;
				min = votes.get(party);
			}
		}
		return minParty;
	}
	
	public Long getTotalVotes() {
		long totalVotes = 0;
		for(Long vote : votes.values()) {
			totalVotes += vote;
		}
		return totalVotes;
	}
	
	public Long getWinningVotes() {
		return votes.get(winningParty);
	}
}
