package com.luv2code.springdemo.mvc;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.luv2code.springdemo.dao.PartyVotesDAO;
import com.luv2code.springdemo.dao.PrecinctDAO;
import com.luv2code.springdemo.dao.PrecinctElectionDAO;
import com.luv2code.springdemo.dao.StateDAO;
import com.luv2code.springdemo.enumerations.DemographicGroup;
import com.luv2code.springdemo.enumerations.ElectionTerm;
import com.luv2code.springdemo.region.Cluster;
import com.luv2code.springdemo.region.DemographicPopulation;
import com.luv2code.springdemo.region.Edge;
import com.luv2code.springdemo.region.PartyVotes;
import com.luv2code.springdemo.region.PrecinctElection;
import com.luv2code.springdemo.region.Precincts;
import com.luv2code.springdemo.region.States;

@RestController
@RequestMapping("/controller")
public class Controller {
	static public JSONParser jsonParser = new JSONParser();

	@Autowired
	private PrecinctDAO precinctDAO;
	
	@Autowired
	private PrecinctElectionDAO precinctElectionDAO;

	@Autowired
	private PartyVotesDAO partyVotesDAO;
	
	@Autowired
	private StateDAO stateDAO;
	
	public Controller() {

	}

	@RequestMapping(value = "/phase0_data", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> runPhase0(@RequestBody String phase0_data) {
		JSONObject jsonObject;
		JSONObject returnData = new JSONObject();
		try {
			jsonObject = (JSONObject) jsonParser.parse(phase0_data);
			String stateName = (String) jsonObject.get("stateName");
			System.out.println(stateName);
			Float phase0_population_min = Float.valueOf((String) jsonObject.get("phase0_population_min"));
			Float phase0_population_max = Float.valueOf((String) jsonObject.get("phase0_population_max"));
			Float phase0_vote_min = Float.valueOf((String) jsonObject.get("phase0_vote_min"));
			Float phase0_vote_max = Float.valueOf((String) jsonObject.get("phase0_vote_max"));
			ElectionTerm electionTerm = selectedTerm((String) jsonObject.get("electionTerm"));

//			Set<ElectionTerm> electionTerms = new HashSet<ElectionTerm>();
//			JSONArray jsonArray = (JSONArray) electionTerms_arr;
//			if (jsonArray != null) {
//				int len = jsonArray.size();
//				for (int i = 0; i < len; i++) {
//					electionTerms.add(selectedTerm(jsonArray.get(i).toString()));
//				}
//			}

			// get Precincts(stateName : String))
			List<Precincts> precincts = precinctDAO.getPrecincts();
			JSONArray precinctIds = new JSONArray();

			SingletonThreshold.saveThreshold(phase0_population_min, phase0_population_max, phase0_vote_min,
					phase0_vote_max, electionTerm);

			for(Precincts p : precincts) {
				if(precinctIsBloc(p)) {
					return new ResponseEntity<>("State contains bloc precinct!", HttpStatus.OK);
				}
			}
			return new ResponseEntity<>("State does contains bloc precinct!", HttpStatus.OK);

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
		boolean isPerIteration = false;
		Set<Cluster> clusters = new HashSet<Cluster>();
		States selectedState = null;

		try {
			jsonObject = (JSONObject) jsonParser.parse(phase1_data);
			String stateName = (String) jsonObject.get("stateName");

			JSONArray demo_jsonArray = (JSONArray) jsonObject.get("demographicGroup");

			Set<DemographicGroup> demographics = new HashSet<DemographicGroup>();
			if (demo_jsonArray != null) {
				int len = demo_jsonArray.size();
				for (int i = 0; i < len; i++) {
					demographics.add(selectedDemo(demo_jsonArray.get(i).toString()));
				}
			}

			Float numDistricts = Float.valueOf((String) jsonObject.get("phase1_district_val"));
			Float majMinDistricts = Float.valueOf((String) jsonObject.get("phase1_population_val"));
			Float iterationRate = Float.valueOf((String) jsonObject.get("iterationRate"));

			// 2. get into the algorithm
			
			selectedState = stateDAO.getSingleState(stateName);
			
			clusters = selectedState.initClusters();
			
//			
			while(clusters.size() >= numDistricts) {
				Set<Edge> candidatePairs = selectedState.getMmCandidateEdges(clusters);
//				Set<Edge> maxAvailablePairs = SetOperation.getMaxMatching(candidatePairs);
//				Set<Cluster> leftOverClusters;
//				if(clusters.size()-maxAvailablePairs.size() > numDistricts) {
//					leftOverClusters = SetOperation.joinCandiatePairs(maxAvailablePairs);
//				} else {
//					selectedState.finalIteration();
//				}
//				
//				if(isPerIteration) {
//					break;
//				}
//				
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(phase1_data, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/phase2_data", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> runPhase2(@RequestBody String phase2_data) {

		return new ResponseEntity<>(phase2_data, HttpStatus.CREATED);
	}

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

	public DemographicGroup selectedDemo(String demo) {
		if (demo == "White") {
			return DemographicGroup.White;
		} else if (demo == "Hispanic") {
			return DemographicGroup.Hispanic;
		} else if(demo=="AfricanAmerican") {
			return DemographicGroup.AfricanAmerican;
		} else if(demo=="Asian") {
			return DemographicGroup.Asian;
		} 
		else return DemographicGroup.NativeAmerican;
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
		List<String> precinct_boundary = precinctDAO.getPrecinctsBoundaries();

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

	public boolean precinctIsBloc(Precincts precinct) {
		
		SingletonThreshold singletonThreshold = SingletonThreshold.getSingletonThreshold();
		Set<DemographicGroup> targetDemographicGroup = singletonThreshold.getTargetPopulation();
		float demographicMinPerc = singletonThreshold.getDemographicMin();
		float demographicMaxPerc = singletonThreshold.getDemographicMax();
		long totalPopulation = precinct.getPopulation();
		
		for(DemographicPopulation dg : precinct.getDemographicPopulation()) {
		
			long demographicPopulation = dg.getPopulation();
		
			if ((demographicPopulation / totalPopulation < demographicMinPerc) ||
					(demographicPopulation / totalPopulation > demographicMaxPerc))
				return false;
		}
		
		ElectionTerm electionTerm = singletonThreshold.getElectionTerm();
		
		PrecinctElection pe = precinctElectionDAO.getPrecinctElections(precinct.getPrecinctId(), electionTerm);
		
		List<PartyVotes> partyVotes = partyVotesDAO.getPartyVotesGivenElection(pe.getElectionId());
		
		int totalVotes = 0;
		
		for (PartyVotes pv : partyVotes) {
			totalVotes += pv.getVotes();
		}
		
		int winningVotes = pe.getWinVotes();
		
		float votingMinPerc = singletonThreshold.getVotingMin();
		float votingMaxPerc = singletonThreshold.getVotingMax();
		
		if ((winningVotes / totalVotes <  votingMinPerc) || (winningVotes / totalVotes > votingMaxPerc)) {
			return false;
		}
		return true;	
	}
}
