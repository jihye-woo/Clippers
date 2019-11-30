package com.luv2code.springdemo.summary;

import java.util.List;

public class StateSummary extends Summary{
	private int StateId;
	private String stateName;
	private List<DistrictSummary> originalDistricts;
	private int numberOfDistricts;
	
	public StateSummary() {
		super();
	}

 }
