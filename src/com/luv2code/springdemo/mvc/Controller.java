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

import com.luv2code.springdemo.summary.ClusterSummary;

@RestController
@RequestMapping("/controller")
public class Controller {
	static public JSONParser jsonParser = new JSONParser();
	
	public Controller() {
		
	}
	
	@RequestMapping(value = "/phase0_data", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> runPhase0(@RequestBody String phase0_data){
		JSONObject jsonObject;
		try {
			jsonObject = (JSONObject) jsonParser.parse(phase0_data);
			System.out.println(jsonObject);
			String stateName = (String) jsonObject.get("stateName");
			Float phase0_population_min = Float.valueOf((String) jsonObject.get("phase0_population_min"));
			Float phase0_population_max =  Float.valueOf((String) jsonObject.get("phase0_population_max"));
			Float phase0_vote_min = Float.valueOf((String)jsonObject.get("phase0_vote_min"));
			Float phase0_vote_max = Float.valueOf((String)jsonObject.get("phase0_vote_max"));
			
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(phase0_data, HttpStatus.OK);
	}
	
	
//	@RequestMapping(value = "/getThersholds", method = RequestMethod.POST, produces = "application/json")
//	public ResponseEntity<String> getThersholds(@RequestBody String ThersholdVars_and_Demographics){
////		float demographicMinPercentage, float demographicMaxPercentage, 
////		float votingMinPercentage, float votingMaxPercentage, List<DemographicGroup> demographicGroups
//		System.out.println(ThersholdVars_and_Demographics);
//		try {
//			JSONObject jsonObject = (JSONObject) jsonParser.parse(ThersholdVars_and_Demographics);
//			System.out.println(jsonObject);
//			System.out.println(jsonObject.get("phase0_population_min"));
//			System.out.println(jsonObject.get("phase0_population_max"));
//			System.out.println(jsonObject.get("phase0_vote_min"));
//			System.out.println(jsonObject.get("phase0_vote_max"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println("error");
//			e.printStackTrace();
//		}
//		
//		return new ResponseEntity<>(ThersholdVars_and_Demographics, HttpStatus.CREATED);
//		
//	}
	
	@RequestMapping(value = "/getSlider", method = RequestMethod.POST, produces = "application/json")
	public void setVariables(@RequestBody List<Integer> userVariables){
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
