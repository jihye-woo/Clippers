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
var electionTerms = [];
var phase1_selectedDemo = [];
var phase0_stateData = phase0_select_state();
var phase1_stateData = phase1_select_state();
var phaseStatus = select_phase();

function checked_electionTerm() {

    var selectedValues = document.getElementsByClassName("phase0_electionTerm");
    var selectedList = [];
    var index;

    for (index = 0; index < selectedValues.length; index++) {
        if (selectedValues[index].type == 'checkbox' &&
            selectedValues[index].checked == true) {
            selectedList.push(selectedValues[index].id);
        }
    }
    electionTerms = selectedList;
}

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
        "phase0_population_min": document.getElementById("phase0_population_min").value,
        "phase0_population_max": document.getElementById("phase0_population_max").value,
        "phase0_vote_min": document.getElementById("phase0_vote_min").value,
        "phase0_vote_max": document.getElementById("phase0_vote_max").value,
        "electionTerms": electionTerms
    }

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/spring-mvc-demo/controller/phase0_data",
        data: JSON.stringify(phase0_data),
        async: false,
        dataType: 'json',
        success: function (data) {
            console.log(data);
        }
    });
}

var btn_phase1 = document.getElementById("phase1_start_button");
btn_phase1.onclick = function (props) {

    var phase1_data = {
        "stateName": phase1_stateData,
        "demographicGroup": phase1_selectedDemo,
        "numOfDistrict_min": document.getElementById("phase1_district_min").value,
        "numOfDistrict_max": document.getElementById("phase1_district_max").value,
        "majMinDistricts": document.getElementById("phase1_population_val").value,
        "iterationRate": document.getElementById("iterationRate").value
    }

    if (phaseStatus == "Phase1") {
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

function phase0_select_state() {
    var phase0_stateName = document.getElementById("dropdown_state").value;
    console.log(phase0_stateName);
    return phase0_stateName;
}

function phase1_select_state() {
    var phase1_stateName = document.getElementById("dropdown_state_phase1").value;
    console.log(phase1_stateName);
    return phase1_stateName;
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

function select_phase() {
    var phase = document.getElementsByName('phase');
    var i;
    for (i = 0; i < phase.length; i++) {
        if (phase[i].checked) {
            phaseStatus = phase[i].value;
        }
    }
}

function change(){
    console.log(document.getElementById("dropdown_state").value);
}
