package com.luv2code.springdemo.summary;

public class PrecinctSummary extends Summary{
	private int precinctId;
	private boolean isBloc;
	
	public PrecinctSummary(){
		super();
	}

	public int getPrecinctId() {
		return precinctId;
	}

	public void setPrecinctId(int precinctId) {
		this.precinctId = precinctId;
	}
}
