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
      //var subbtn = document.getElementById("submitBtn");
      
      btn_phase0.onclick = function(props) {
<<<<<<< HEAD
         
         var developerData = getSelectedState(props);
         $.ajax({
             type : "POST",
             contentType : "application/json",
             url : "/spring-mvc-demo/api/getState",
             data : JSON.stringify(developerData),
             dataType : 'json',      
             success : function(data) {
                console.log(data);
             }
          });
         
      }
      
      function getSelectedState(props){
         var data = {"stateName" : StateNameWC};
         if(ml.checked == true){
                document.getElementById("dataTable").innerHTML = '<h4>US Population Density</h4>' + (props ?
                       '<table><tr><th>' + '<b>name</b>' + '</th><th>' + '<b>population</b>' + '</th></tr><tr><td>' + StateNameML + '</td><td>' + densityML + '</td></tr><tr><td>' + StateNameML + '</td><td>' + densityML + '</td></tr><tr><td>' + StateNameML + '</td><td>' + densityML + '</td></tr></table>' :
                       'Hover over a state');         
                       onclick="zoomin_maryland()"; 
                       data["stateName"] = StateNameML;
                }
                
                else if(ny.checked == true){
                document.getElementById("dataTable").innerHTML = '<h4>US Population Density</h4>' + (props ?
                       '<table><tr><th>' + '<b>name</b>' + '</th><th>' + '<b>population</b>' + '</th></tr><tr><td>' + StateNameNY + '</td><td>' + densityNY + '</td></tr><tr><td>' + StateNameNY + '</td><td>' + densityNY + '</td></tr><tr><td>' + StateNameNY + '</td><td>' + densityNY + '</td></tr></table>' :
                       'Hover over a state');      
                      data["stateName"] = StateNameML;
                }
                
                else if(wc.checked == true){
                document.getElementById("dataTable").innerHTML = '<h4>US Population Density</h4>' + (props ?
                       '<table><tr><th>' + '<b>name</b>' + '</th><th>' + '<b>population</b>' + '</th></tr><tr><td>' + StateNameWC + '</td><td>' + densityWC + '</td></tr><tr><td>' + StateNameWC + '</td><td>' + densityWC + '</td></tr><tr><td>' + StateNameWC + '</td><td>' + densityWC + '</td></tr></table>' :
                       'Hover over a state');
                      data["stateName"] = StateNameWC;
                }
                
                else{
                document.getElementById("dataTable").innerHTML = " ";
                }
         return data;
=======
    	  
    	  var developerData = getSelectedState(props);
			$.ajax({
	 			type : "POST",
	 			contentType : "application/json",
	 			url : "/spring-mvc-demo/api/getState",
	 			data : JSON.stringify(developerData),
	 			dataType : 'json',		
	 			success : function(data) {
	 				console.log(data);
	 			}
	 		});
    	  
      }
      
      function getSelectedState(props){
    	  var data = {"stateName" : StateNameWC};
    	  if(ml.checked == true){
    	         document.getElementById("dataTable").innerHTML = '<h4>US Population Density</h4>' + (props ?
    	                '<table><tr><th>' + '<b>name</b>' + '</th><th>' + '<b>population</b>' + '</th></tr><tr><td>' + StateNameML + '</td><td>' + densityML + '</td></tr><tr><td>' + StateNameML + '</td><td>' + densityML + '</td></tr><tr><td>' + StateNameML + '</td><td>' + densityML + '</td></tr></table>' :
    	                'Hover over a state');         
    	                onclick="zoomin_maryland()"; 
    	                data["stateName"] = StateNameML;
    	         }
    	         
    	         else if(ny.checked == true){
    	         document.getElementById("dataTable").innerHTML = '<h4>US Population Density</h4>' + (props ?
    	                '<table><tr><th>' + '<b>name</b>' + '</th><th>' + '<b>population</b>' + '</th></tr><tr><td>' + StateNameNY + '</td><td>' + densityNY + '</td></tr><tr><td>' + StateNameNY + '</td><td>' + densityNY + '</td></tr><tr><td>' + StateNameNY + '</td><td>' + densityNY + '</td></tr></table>' :
    	                'Hover over a state');      
    	         		data["stateName"] = StateNameNY;
    	         }
    	         
    	         else if(wc.checked == true){
    	         document.getElementById("dataTable").innerHTML = '<h4>US Population Density</h4>' + (props ?
    	                '<table><tr><th>' + '<b>name</b>' + '</th><th>' + '<b>population</b>' + '</th></tr><tr><td>' + StateNameWC + '</td><td>' + densityWC + '</td></tr><tr><td>' + StateNameWC + '</td><td>' + densityWC + '</td></tr><tr><td>' + StateNameWC + '</td><td>' + densityWC + '</td></tr></table>' :
    	                'Hover over a state');
    	         		data["stateName"] = StateNameWC;
    	         }
    	         
    	         else{
    	         document.getElementById("dataTable").innerHTML = " ";
    	         }
    	  return data;
>>>>>>> 7c1d0495c15d06124204a7b4fe467b99be581f8d
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