package com.luv2code.springdemo.enumerations;

public enum ElectionTerm {
	
	Presidential2016("Presidential2016"),
	Congressional2016("Congressional2016"),
	Congressional2018("Congressional2018");
	
    private String electionType;
    private String electionYear;
    
    ElectionTerm(String electionTerm) {
        this.electionType = electionTerm.substring(electionTerm.length()-4);
        this.electionYear = electionTerm.substring(electionTerm.length()-4, electionTerm.length());
    }

	public String getElectionType() {
		return electionType;
	}

	public String getElectionYear() {
		return electionYear;
	}
    
}
