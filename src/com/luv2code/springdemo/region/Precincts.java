package com.luv2code.springdemo.region;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Precincts")
public class Precincts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid")
	private int precinctId;

	@Column(name = "pname")
	private String pname;

	@Column(name = "geojson")
	private String geoJson;

	@Column(name = "totalpopulation")
	private int population;

//	boolean isBloc;
//	List<Edge> edges;
	
	public int getPrecinctId() {
		return precinctId;
	}

	public void setPrecinctId(int precinctId) {
		this.precinctId = precinctId;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getGeoJson() {
		return geoJson;
	}

	public void setGeoJson(String geoJson) {
		this.geoJson = geoJson;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Precinct [precinctId=" + precinctId + ", pname=" + pname + ", geoJson=" + geoJson + ", population="
				+ population + "]";
	}

// public boolean precinctIsBloc() {
// List<DemographicGroup> targetDemographicGroup = SingletonThreshold.getTargetPopulation();
// float demographicMinPerc = SingletonThreshold.getDemographicMin();
// float demographicMaxPerc = SingletonThreshold.getDemographicMax();
// 
// long totalPopulation = getTotalPopulation();
// 
// long demographicPopulation = 0;
// for(DemographicGroup demo : targetDemographicGroup) {
// demographicPopulation += getDemographicPopulation(demo);
// }
// 
// long percentage = demographicPopulation / totalPopulation;
// 
// 
// // 1. demographic
// if(percentage < demographicMinPerc || percentage > demographicMaxPerc) {
// return false;
// }
// 
// // 2. voting number
//// ElectionData data = new ElectionData();
// 
// 
// return true;
// }

}
