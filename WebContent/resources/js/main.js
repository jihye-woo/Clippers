var ny = document.getElementById("NY");
var ml = document.getElementById("ML");
var wc = document.getElementById("WC");
var StateNameML = statesData.features[0].properties.name; // maryland:
// geojson._layers[57].feature.properties.name
var densityML = statesData.features[0].properties.density;
var StateNameNY = statesData.features[1].properties.name;
var densityNY = statesData.features[1].properties.density;
var StateNameWC = statesData.features[2].properties.name;
var densityWC = statesData.features[2].properties.density;
var electionTerm = "";
var phase1_selectedDemo = [];
var phase0_stateData = "Michigan";
var phase1_stateData = "Michigan";
var phaseStatus = select_phase();
var isPause = false;

// dropdown script
// var phase0_selected_state;
  function phase0_select_state(){
	  phase0_stateData = document.getElementById("phase0_dropdown_state").value;
	  console.log(phase0_stateData);
  	}
  
// var phase1_selected_state;
	function phase1_select_state(){
		phase1_stateData = document.getElementById("phase1_dropdown_state").value;
		console.log(phase1_stateData);
	}

    function election_term(){
        election_term_data = document.getElementById("election_term").value;
        console.log(election_term_data);
     }
     
     function map_level(){
        map_level_data = document.getElementById("map_level").value;
        if(map_level_data = "State"){
        	test_precinct.forEach(function (precinct) {
//        		console.log(precinct);
        		L.geoJson(JSON.parse(precinct), {
        			precinct_style: style,
        			onEachFeature: onEachFeature
        		}).addTo(map);
        	});
        	
        } else if(map_level_data ="Precinct"){
        	
        	
        } else{ // map_level_data ="district"
        	
        }
        
        console.log(map_level_data);
     }
     
     function select_district_toShow() {
          var select = document.getElementsByName('select');
          var i;
          for (i = 0; i < select.length; i++) {
            if (select[i].checked) {
            selectStatus = select[i].value;
            console.log(selectStatus);
            }
          }
        }
	
	
//function checked_electionTerm() {
//    var selectedValues = document.getElementsByClassName("phase0_electionTerm");
//    var selectedList = [];
//    var index;
//
//    for (index = 0; index < selectedValues.length; index++) {
//        if (selectedValues[index].type == 'checkbox' &&
//            selectedValues[index].checked == true) {
//            selectedList.push(selectedValues[index].id);
//        }
//    }
//    electionTerm = selectedList;
//}

function phase1_checked_demographic(){

    var e = document.getElementsByClassName("phase1_ethinic");
    var phase1_selectedEthinic = [];
    var index;
   
    for(index=0; index<e.length; index++)       
    {
        if(e[index].type=='checkbox' && e[index].checked==true){         
            phase1_selectedEthinic.push(e[index].id);
         }
    }
    phase1_selectedDemo = phase1_selectedEthinic;
}


var btn_phase0 = document.getElementById("phase0_button");
btn_phase0.onclick = function (props) {

    var phase0_data = {
        "stateName": phase0_stateData,
        "phase0_population_max": document.getElementById("phase0_population_val").value,
        "phase0_vote_max": document.getElementById("phase0_vote_val").value,
        "electionTerm": electionTerm
        
    }

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/spring-mvc-demo/controller/phase0_data",
        data: JSON.stringify(phase0_data),
        dataType: 'json',
        success: function (data) {
            console.log(data);
            console.log(data['stateName']);
        }
    });
}

var phase1_btn_pause = document.getElementById("phase1_pause_button");
phase1_btn_pause.onclick = function (props){
    if(isPause == false){
        isPause = true;
    } else{
        isPause = true;
    }
}

var phase1_btn_start = document.getElementById("phase1_start_button");
phase1_btn_start.onclick = function (props) {
// updatePhase1Button(btn_phase1);
    var phase1_data = {
        "stateName": phase1_stateData,
        "demographicGroup": phase1_selectedDemo,
        "phase1_district_min": document.getElementById("phase1_district_min").value,
        "phase1_district_max": document.getElementById("phase1_district_max").value,
        "phase1_population_val": document.getElementById("phase1_population_val").value,
        "iterationRate": document.getElementById("iterationRate").value
    }

    if (phaseStatus == "Phase1") {
    	console.log(phase1_data);
    	
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/spring-mvc-demo/controller/phase1_data",
            data: JSON.stringify(phase1_data),
            async: false,
            dataType: 'json',
            success: function (data) {
                console.log(data);
            }
        });
    } else { // phaseStatus == phase2
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/spring-mvc-demo/controller/phase2_data",
            data: JSON.stringify(phase1_data),
            async: false,
            dataType: 'json',
            success: function (data) {
                console.log(data);
            }
        });
    }
}

function openNav() {
    document.getElementById("mySidepanel").style.width = "400px";
}

function closeNav() {
    document.getElementById("mySidepanel").style.width = "0";
}

function openNav2() {
    document.getElementById("mySidepanel2").style.width = "400px";
}

function closeNav2() {
    document.getElementById("mySidepanel2").style.width = "0";
}

function openSettings() {
   document.getElementById("mySettings").style.width = "400px";
}

function closeSettings() {
   document.getElementById("mySettings").style.width = "0";
}

function select_phase() {
	  var phase = document.getElementsByName('phase');
	  var i;
	  for (i = 0; i < phase.length; i++) {
	    if (phase[i].checked) {
	     console.log(phase[i].value);
         phaseStatus = phase[i].value;
	    }
	  }
	}

