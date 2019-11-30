      var ny = document.getElementById("NY");
      var ml = document.getElementById("ML");
      var wc = document.getElementById("WC");
      var StateNameML = statesData.features[0].properties.name; //maryland: geojson._layers[57].feature.properties.name
      var densityML = statesData.features[0].properties.density;
      var StateNameNY = statesData.features[1].properties.name;
      var densityNY = statesData.features[1].properties.density;
      var StateNameWC = statesData.features[2].properties.name;
      var densityWC = statesData.features[2].properties.density;
      
      var btn_phase0 = document.getElementById("phase0_button");
      
      btn_phase0.onclick = function(props) {
    	  
    	  var stateData = getSelectedState(props);
    	  var phase0_data = {
    			  "stateName" : stateData, 
    			  "phase0_population_min" : document.getElementById("phase0_population_min").value,
        		  "phase0_population_max" : document.getElementById("phase0_population_max").value,
        		  "phase0_vote_min" : document.getElementById("phase0_vote_min").value,
        		  "phase0_vote_max" : document.getElementById("phase0_vote_max").value	}
    	  
			$.ajax({
	 			type : "POST",
	 			contentType : "application/json",
	 			url : "/spring-mvc-demo/controller/phase0_data",
	 			data : JSON.stringify(phase0_data),
	 			async: false,
	 			dataType : 'json',		
	 			success : function(data) {
	 				console.log(data);
	 			}
	 		});
			
      }
      
      function getSelectedState(props){
    	  var data = StateNameWC;
    	  if(ml.checked == true){
    	         document.getElementById("dataTable").innerHTML = '<h4>US Population Density</h4>' + (props ?
    	                '<table><tr><th>' + '<b>name</b>' + '</th><th>' + '<b>population</b>' + '</th></tr><tr><td>' + StateNameML + '</td><td>' + densityML + '</td></tr><tr><td>' + StateNameML + '</td><td>' + densityML + '</td></tr><tr><td>' + StateNameML + '</td><td>' + densityML + '</td></tr></table>' :
    	                'Hover over a state');         
    	                onclick="zoomin_maryland()"; 
    	                data = StateNameML;
    	         }
    	         
    	         else if(ny.checked == true){
    	         document.getElementById("dataTable").innerHTML = '<h4>US Population Density</h4>' + (props ?
    	                '<table><tr><th>' + '<b>name</b>' + '</th><th>' + '<b>population</b>' + '</th></tr><tr><td>' + StateNameNY + '</td><td>' + densityNY + '</td></tr><tr><td>' + StateNameNY + '</td><td>' + densityNY + '</td></tr><tr><td>' + StateNameNY + '</td><td>' + densityNY + '</td></tr></table>' :
    	                'Hover over a state');      
    	         		data = StateNameNY;
    	         }
    	         
    	         else if(wc.checked == true){
    	         document.getElementById("dataTable").innerHTML = '<h4>US Population Density</h4>' + (props ?
    	                '<table><tr><th>' + '<b>name</b>' + '</th><th>' + '<b>population</b>' + '</th></tr><tr><td>' + StateNameWC + '</td><td>' + densityWC + '</td></tr><tr><td>' + StateNameWC + '</td><td>' + densityWC + '</td></tr><tr><td>' + StateNameWC + '</td><td>' + densityWC + '</td></tr></table>' :
    	                'Hover over a state');
    	         		data = StateNameWC;
    	         }
    	         
    	         else{
    	         document.getElementById("dataTable").innerHTML = " ";
    	         }
    	  return data;

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