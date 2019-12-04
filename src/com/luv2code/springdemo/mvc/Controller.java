package com.luv2code.springdemo.mvc;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.dao.PrecinctDAO;
import com.luv2code.springdemo.enumerations.ElectionTerm;
import com.luv2code.springdemo.region.Cluster;
import com.luv2code.springdemo.region.Precincts;
import com.luv2code.springdemo.region.State;

@RestController
@RequestMapping("/controller")
public class Controller {
	static public JSONParser jsonParser = new JSONParser();

	@Autowired
	private PrecinctDAO precinctDAO;

	public Controller() {

	}

	@RequestMapping(value = "/phase0_data", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> runPhase0(@RequestBody String phase0_data){
		JSONObject jsonObject;
		JSONObject returnData = new JSONObject();
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
			
			// get Precincts(stateName : String))
			ArrayList<Precincts> precicnts = new ArrayList<Precincts>();
//			ArrayList<PrecinctSummary> precicnts_summary = new ArrayList<PrecinctSummary>();
			JSONArray precinctIds = new JSONArray();
			
			SingletonThreshold.saveThreshold(phase0_population_min, phase0_population_max,
					phase0_vote_min, phase0_vote_max, electionTerms);
			
//			for(Precincts p :precicnts) {
//				boolean isBloc = p.precinctIsBloc();
//				if(isBloc) {
//					PrecinctSummary p_summary = (PrecinctSummary) p.toSummary();
//					int id = p_summary.getPrecinctId();
////					precicnts_summary.add(p_summary);
//					precinctIds.add(id);
//				}
//			}
			
//			returnData.put("precinct_id", precinctIds);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		return new ResponseEntity<>(returnData.toString(), HttpStatus.OK);
		return new ResponseEntity<>(phase0_data, HttpStatus.OK);
		
	}

	@RequestMapping(value = "/phase1_data", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> runPhase1(@RequestBody String phase1_data) {

		// 1. getting the data to run the phase 1 algorithm

		JSONObject jsonObject = new JSONObject();
//		JSONArray demographicGroup = new JSONArray();
		ObjectMapper mapper = new ObjectMapper();
		boolean isResumed = true;
		List<Cluster> clusters = new ArrayList<Cluster>();
		State selectedState = null;
		// 나중에 client side에서 받아와야함

		try {
			jsonObject = (JSONObject) jsonParser.parse(phase1_data);
			String stateName = (String) jsonObject.get("stateName");
			String demo_jsonString = (String) jsonObject.get("demographicGroup");
			ArrayList<String> demographicGroup = (ArrayList<String>) mapper.readValue(demo_jsonString, Map.class);

			Float numOfDistrict_min = Float.valueOf((String) jsonObject.get("phase0_population_max"));
			Float numOfDistrict_max = Float.valueOf((String) jsonObject.get("phase0_vote_min"));
			Float majMinDistricts = Float.valueOf((String) jsonObject.get("phase0_vote_max"));
			Float iterationRate = Float.valueOf((String) jsonObject.get("phase0_vote_max"));

			// 2.
			if (isResumed || selectedState == null) {
				selectedState = new State(stateName);
			} else {
				clusters = selectedState.initClusters();
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<>(phase1_data, HttpStatus.CREATED);
	}

//	@RequestMapping(value = "/phase2_data", method = RequestMethod.POST, produces = "application/json")
//	public ResponseEntity<String> runPhase2(@RequestBody String phase2_data){
//		
//		return new ResponseEntity<>(phase2_data, HttpStatus.CREATED);
//	}

//	@RequestMapping(value = "/phase2_data", method = RequestMethod.POST, produces = "application/json")
//	public ModelAndView runPhase2(@RequestBody String phase2_data){
//		return new ModelAndView();
//	}	

	public ElectionTerm selectedTerm(String term) {
		if (term == "16_congressional") {
			return ElectionTerm.Presidential2016;
		} else if (term == "18_congressional") {
			return ElectionTerm.Congressional2016;
		}
		return ElectionTerm.Congressional2018;
	}

	@RequestMapping(value = "/hover_state", method = RequestMethod.POST)
	public ResponseEntity<String> hover_state(@RequestBody String stateName) {
		return new ResponseEntity<>("state hover hello", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/hover_precinct", method = RequestMethod.POST)
	public ResponseEntity<String> hover_precinct(@RequestBody String precinctName) {
		return new ResponseEntity<>("precinct hover hello", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/hover_district", method = RequestMethod.POST)
	public ResponseEntity<String> hover_district(@RequestBody String districtName) {
		return new ResponseEntity<>("district hover hello", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/zoom_state", method = RequestMethod.POST)
	public ResponseEntity<String> zoom_state(@RequestBody String stateName) {
		return new ResponseEntity<>("state zoom hello", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/zoom_precinct", method = RequestMethod.POST)
	public ResponseEntity<String> zoom_precinct(@RequestBody String precinctName) throws IOException {
//		return new ResponseEntity<>("precinct zoom hello", HttpStatus.CREATED);
		List<String> precinct_boundary = precinctDAO.getPrecincts();

		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
//		
//		Path file = Paths.get("precinct_data.txt");
//		Files.write(file, precinct_boundary, StandardCharsets.UTF_8);
		
		for(String precinct_geojson : precinct_boundary) {
			array.add(precinct_geojson);
//			System.out.println(precinct_geojson);
		}
		object.put("precincts", array);

		String returnData = object.toJSONString(); 
		return new ResponseEntity<>(returnData, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/zoom_district", method = RequestMethod.POST)
	public ResponseEntity<String> zoom_district(@RequestBody String districtName) {
		return new ResponseEntity<>("district zoom hello", HttpStatus.CREATED);
	}

}
