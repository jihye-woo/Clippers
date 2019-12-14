package com.luv2code.springdemo.region;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.luv2code.springdemo.enumerations.DemographicGroup;
import com.luv2code.springdemo.mvc.SingletonThreshold;

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

	@OneToMany(fetch=FetchType.LAZY, mappedBy="precincts",
			cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<PrecinctElection> precinctElections;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "precincts", cascade=CascadeType.ALL)
	private Set<DemographicPopulation> demographicPopulation;
	
	boolean isBloc;
	
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

	public List<PrecinctElection> getPrecinctElections() {
		return precinctElections;
	}

	public void setPrecinctElections(List<PrecinctElection> precinctElections) {
		this.precinctElections = precinctElections;
	}

	public Set<DemographicPopulation> getDemographicPopulation() {
		return demographicPopulation;
	}

	public void setDemographicPopulation(Set<DemographicPopulation> demographicPopulation) {
		this.demographicPopulation = demographicPopulation;
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
