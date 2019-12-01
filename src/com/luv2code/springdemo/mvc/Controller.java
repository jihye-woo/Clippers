package com.luv2code.springdemo.mvc;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
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
import com.luv2code.springdemo.enumerations.ElectionTerm;
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
			String stateName = (String) jsonObject.get("stateName");
			Float phase0_population_min = Float.valueOf((String) jsonObject.get("phase0_population_min"));
			Float phase0_population_max =  Float.valueOf((String) jsonObject.get("phase0_population_max"));
			Float phase0_vote_min = Float.valueOf((String)jsonObject.get("phase0_vote_min"));
			Float phase0_vote_max = Float.valueOf((String)jsonObject.get("phase0_vote_max"));
			
			JSONArray electionTerms_arr = (JSONArray) jsonObject.get("electionTerms");
			
			ArrayList<ElectionTerm> electionTerms = new ArrayList<ElectionTerm>();     
			JSONArray jsonArray = (JSONArray) electionTerms_arr; 
			if (jsonArray != null) { 
			   int len = jsonArray.size();
			   for (int i=0;i<len;i++){ 
				   electionTerms.add( selectedTerm(jsonArray.get(i).toString()) );
			   } 
			}
			
			SingletonThreshold.saveThreshold(phase0_population_min, phase0_population_max,
					phase0_vote_min, phase0_vote_max, electionTerms);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(phase0_data, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/phase1_data", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> runPhase1(@RequestBody String phase1_data){
		
		return new ResponseEntity<>(phase1_data, HttpStatus.CREATED);
	}
	@RequestMapping(value = "/phase2_data", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> runPhase2(@RequestBody String phase2_data){
		
		return new ResponseEntity<>(phase2_data, HttpStatus.CREATED);
	}
	
//	@RequestMapping(value = "/phase2_data", method = RequestMethod.POST, produces = "application/json")
//	public ModelAndView runPhase2(@RequestBody String phase2_data){
//		return new ModelAndView();
//	}	
	
	public ElectionTerm selectedTerm(String term) {
		if(term == "16_congressional") {
			return ElectionTerm.Presidential2016;
		}
		else if(term == "18_congressional") {
			return ElectionTerm.Congressional2016;
 		}
		return ElectionTerm.Congressional2018;
	}
	
	@RequestMapping(value = "/hover_state", method = RequestMethod.POST)
	public ResponseEntity<String> hover_state(@RequestBody String stateName) {
		return new ResponseEntity<>(stateName, HttpStatus.CREATED);
	}
	
}

