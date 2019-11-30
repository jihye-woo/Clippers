package com.luv2code.springdemo.mvc;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.luv2code.springdemo.enumerations.DemographicGroup;
import com.luv2code.springdemo.summary.ClusterSummary;
import com.luv2code.springdemo.summary.PrecinctSummary;

@RestController
@RequestMapping("/api")
public class Controller {
	static public JSONParser jsonParser = new JSONParser();
	
	public Controller() {
		
	}
	
	@RequestMapping(value = "/getState", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> postEmployeeData(@RequestBody String selectedStateName) throws ParseException {
		JSONObject jsonObject = (JSONObject) jsonParser.parse(selectedStateName);
		System.out.println(selectedStateName);
		System.out.println(jsonObject.get("stateName"));
		String stateName = (String) jsonObject.get("stateName");
		return new ResponseEntity<>(stateName, HttpStatus.OK);
	}
	
	
	@RequestMapping("/runPhase0")
	public ResponseEntity<List<PrecinctSummary>> runPhase0(String stateName, float demographicMinPercentage, float demographicMaxPercentage, 
			float votingMinPercentage, float votingMaxPercentage, List<DemographicGroup> demographicGroups){
		
		List<PrecinctSummary> precincts = new ArrayList<PrecinctSummary>();
		PrecinctSummary pre1 = new PrecinctSummary();
		pre1.setPrecinctId(1);
		PrecinctSummary pre2 = new PrecinctSummary();
		pre1.setPrecinctId(2);
		
		return new ResponseEntity<>(precincts, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/getSlider", method = RequestMethod.POST, produces = "application/json")
	public void setVariables(@RequestBody List<Float> userVariables){
		SingletonThreshold.setVotingMin(userVariables.get(0));
		SingletonThreshold.setVotingMax(userVariables.get(1));
		SingletonThreshold.setDemographicMin(userVariables.get(2));
		SingletonThreshold.setDemographicMax(userVariables.get(3));
		System.out.println(userVariables.get(0));
		
	}
	
	public ResponseEntity<List<ClusterSummary>> runPhase1(String stateName, boolean isPerIteration, boolean isResumed){
		List<ClusterSummary> clusters = new ArrayList<ClusterSummary>();
		return new ResponseEntity<>(clusters, HttpStatus.CREATED);
	}
	
	public ModelAndView runPhase2(String stateName){
		return new ModelAndView();
	}	
}
