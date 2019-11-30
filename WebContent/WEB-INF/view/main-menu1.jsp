<!DOCTYPE html>
<html>

	<head>
	
		<title>map page</title>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1" minimum-scale=1, maximum-scale=2, user-scalable="no">
		
		 <!-- css  -->
	    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/resources/css/theme.css" rel="stylesheet">
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		
		  <!-- map -->
	    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.5.1/dist/leaflet.css" integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ==" crossorigin="" />
	    <script src="https://unpkg.com/leaflet@1.5.1/dist/leaflet.js" integrity="sha512-GffPMF3RvMeYyc1LWMHtK8EbPv0iNZ8/oTtHPx9/cc2ILxQ+u905qIwdpULaqDkyBKgOaB57QTMg7ztg8Jm2Og==" crossorigin=""></script>
		
		<!-- script -->
	   <link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
	   <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	   <script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
	   <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/us-states.js"></script>
	   <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

	</head>
	<body>
		<!-- Fixed navbar -->
    <header>
        <div class="container">
            <nav class="site-header sticky-top py- rounded">
                <div class="container d-flex flex-column flex-md-row justify-content-between">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#" style="font-size: 3rem;">Clippers</a>
                    </div>

                    <div class="nav nav-masthead justify-content">
                        <a class="nav-link active" href="practice3main.html" style="font-size: 1.5rem;">Home</a>
                        <a class="nav-link" href="mypage.html" style="font-size: 1.5rem;">My Page</a>
                    </div>
               
                    <form class="navbar-form navbar-right">
                        <a class="btn btn-primary btn-lg" href="login.html" role="button" style="padding: .9rem .5rem; color: #fff;">Sign in</a>
                        <a class="btn btn-primary btn-lg" href="register.html" role="button" style="padding: .9rem  .5rem; color: #fff; margin-left: .5rem;">Register</a>
                    </form>
                </div>
            </nav>
        </div>
    </header>
   
    <article>
        <!--silder section-->
        <div class="row" style="padding:15px;">
      
            <!--map section-->
            <div class="col-sm-8">
                <div id='map'></div>
            </div>
         
            <!-- user control page -->
            <div class="col-sm-4" style="background-color: #eee;">
            <!-- Graph content -->
            <p id="myModal0"></p>

                <div id="mySidenav" class="sidenav">
                    <a href="#" id="phase0" onclick="openNav()">Phase0</a>
                    <a href="#" id="phase1" onclick="openNav2()">Phase1,2 </a>
                </div>

                <div id="mySidepanel" class="sidepanel" style="margin-top: 1rem; margin-left: 1rem; ">
                    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">�</a>
                    <div class="container">
                        <h1 id=sidebar_header style="margin-bottom: 2rem;"> Phase 0 </h1>

                        <div class="card text-center">
                            <h5 class="card-header">State</h5>
                            <div class="card-body">
                                <div class="dropdown">
                                    <p>Select the State</p>
                              <p>
                                 <label><input type="radio" name="ship" id="NY" checked /> New York</label>
                                 <label><input type="radio" name="ship" id="ML" /> Maryland</label>
                                 <label><input type="radio" name="ship" id="WC" /> Wisconsin</label>
                              </p>                           
                                </div>
                            </div>

                            <h5 class="card-header">Parameters</h5>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col">
                              <header class="card-header">
                                 <h6 class="title"> Ethinic Group </h6>
                              </header>
                              <form>
                                 <br>
                                 <input type="checkbox" name="ethinic" id="White">White<br>
                                 <input type="checkbox" name="ethinic" id="Latino">Hispanic, Latino American<br>
                                 <input type="checkbox" name="ethinic" id="Black" checked>Black, African American<br>
                                 <input type="checkbox" name="ethinic" id="Asian">Asian<br><br>                                 
                              </form>
                              </div> 
                                </div>
                            </div>
                     
                            <div class="row">
                                <div class="col">
                           <header class="card-header">
                              <h6 class="title"> Population </h6>
                           </header>
                                       <!--  <div data-role="rangeslider" data-mini="true">
                                            <input type="range" min="1" max="100" value="10" class="myslider" id="voteSliderRange">
                                 
                              </div> -->
                           <form method="post">
                              <div data-role="rangeslider" data-mini="true">
                                 <input type="range" name="price1-min" id="population-min" value="0" min="0" max="0">
                                 <input type="range" name="price1-max" id="population-max" value="80" min="0" max="100">
                              </div>
                           </form>   
                           
                                        
                           <header class="card-header">
                              <h6 class="title"> Vote </h6>
                           </header>
                           <form method="post">
                              <div data-role="rangeslider" data-mini="true">
                                 <input type="range" name="price1-min" id="vote-min" value="20" min="0" max="100">
                                 <input type="range" name="price1-max" id="vote-max" value="80" min="0" max="100">
                              </div>
                           </form>                                 
<!--                                         <div class="rangeslider" data-mini="true">
                                            <input type="range" min="1" max="100" value="10" class="myslider" id="voteSliderRange">
                                 <input type="range" min="1" max="100" value="50" class="myslider" id="voteSliderRange">
                              </div>
                                            <script>
                                                var voteSliderRange = document.getElementById("voteSliderRange");
                                                var voteOutput = document.getElementById("voteSlider");
                                                voteOutput.innerHTML = voteSliderRange.value;

                                                voteSliderRange.oninput = function() {
                                                    voteOutput.innerHTML = this.value;
                                                }

                                            </script> -->                                                         
                                </div>
                            </div>   
                  </div>   
                    </div>
                    
                    <div class="container">
                        <button type="button" id="myBtn" class="btn btn-primary btn-lg btn-block" >Run Phase0</button>
                    </div>
            </div>


                <div id="mySidepanel2" class="sidepanel">
                    <a href="javascript:void(0)" class="closebtn" onclick="closeNav2()">�</a>
                    <div class="container">

                        <h1 id=sidebar_header style="margin-bottom: 2rem;"> Phase 1 & 2</h1>
                        <div class="card text-center">
                            <h5 class="card-header">State</h5>
                            <div class="card-body">
                                <!-- <div class="dropdown"> -->
                                    <p>Select the State</p>
                              <p>
                                 <label><input type="radio" name="ship" id="NewY" /> New York</label>
                                 <label><input type="radio" name="ship" id="MarryL" checked/> Maryland</label>
                                 <label><input type="radio" name="ship" id="WisC" /> Wisconsin</label>
                              </p>                           
                                <!-- </div> -->
                            </div>
                              <header class="card-header">
                                 <h6 class="title"> Ethinic Group </h6>
                              </header>
                              <form>
                                 <br>
                                 <input type="checkbox" name="ethinic" id="White">White<br>
                                 <input type="checkbox" name="ethinic" id="Latino">Hispanic, Latino American<br>
                                 <input type="checkbox" name="ethinic" id="Black" checked>Black, African American<br>
                                 <input type="checkbox" name="ethinic" id="Asian">Asian<br><br>                                 
                              </form>                     

                            <h5 class="card-header">Parameters</h5>
                            <div class="card-body">
                        <header class="card-header">
                           <h6 class="title"> Desired number of congressional district </h6>
                        </header>
                           <form method="post" action="/action_page_post.php">
                              <div data-role="rangeslider" data-mini="true">
                                 <input type="range" name="price1-min" id="district-min" value="200" min="0" max="1000">
                                 <input type="range" name="price1-max" id="district-max" value="800" min="0" max="1000">
                              </div>
                           </form>                     

                        <header class="card-header">
                           <h6 class="title"> Majority-Minority </h6>
                        </header>
                           <form method="post" action="/action_page_post.php">
                              <div data-role="rangeslider" data-mini="true">
                                 <input type="range" name="price1-min" id="popul-min" value="20" min="0" max="100">
                                 <!-- <input type="range" name="price1-max" id="popul-max" value="800" min="0" max="1000"> -->
                              </div>
                           </form>   
                           
                        <header class="card-header">
                           <h6 class="title"> Iteration Rate</h6>
                        </header>
                        <input type="number" class="form-control" id="iterationRate" placeholder="0" align="center">
                        
                        <header class="card-header">
                           <p> Select Phase<p>
                        </header>
                           <p>
                              <label><input type="radio" name="ship" id="phase1" checked /> Phase 1</label>
                              <label><input type="radio" name="ship" id="phase2" /> Phase 2</label>
                           </p>                           
                     </div>
                  </div>                       
               </div>

                    <div class="container">
                        <button type="button" class="btn btn-primary btn-lg btn-block">Start/Continue</button>
                  <button type="button" id="myBtn0" class="btn btn-primary btn-lg btn-block">Pause</button>
               </div>
            </div>
         </div>      
      </div>   
    </article>
   
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script> -->
   <script>
        var map = L.map('map').setView([43, -83], 4.5);

        L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
            maxZoom: 18,
            attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
                '<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
                'Imagery � <a href="https://www.mapbox.com/">Mapbox</a>',
            id: 'mapbox.light'
        }).addTo(map);

        // control that shows state info on hover
        var info = L.control();

        info.onAdd = function(map) {
            this._div = L.DomUtil.create('div', 'info');
            this.update();
            return this._div;
        };   

        info.update = function(props) {
            <!-- console.log(statesData.features[0]["id"]); -->
            this._div.innerHTML = '<h4>US Population Density</h4>' + (props ?
                '<table><tr><th>' + '<b>Name</b>' + '</th><th>' + '<b>Density</b>' + '</th></tr><tr><td>' + props.name + '</td><td>' + props.density + '</td></tr><tr><td>' + props.name + '</td><td>' + props.density + '</td></tr></table>' :
                'Hover over a state');   
        };
      
      var ny = document.getElementById("NY");
      var ml = document.getElementById("ML");
      var wc = document.getElementById("WC");
      var StateNameML = statesData.features[0].properties.name; //maryland: geojson._layers[57].feature.properties.name
      var denML = statesData.features[0].properties.density;
      var StateNameNY = statesData.features[1].properties.name;
      var denNY = statesData.features[1].properties.density;
      var StateNameWC = statesData.features[2].properties.name;
      var denWC = statesData.features[2].properties.density;
      
      var btn = document.getElementById("myBtn");
      
      btn.onclick = function(props) {
          
        var developerData = {};
		developerData["stateName"] = props.name;

	
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8080/spring-rest-demo/api/getState",
			data : JSON.stringify(developerData),
			dataType : 'json',				

			success : function(data) {
				console.log(data);
			}
		});
          
          
          
          
         //modal.style.display = "block";
         if(ml.checked == true){
         document.getElementById("myModal0").innerHTML = '<h4>US Population Density</h4>' + (props ?
                '<table><tr><th>' + '<b>name</b>' + '</th><th>' + '<b>population</b>' + '</th></tr><tr><td>' + StateNameML + '</td><td>' + denML + '</td></tr><tr><td>' + StateNameML + '</td><td>' + denML + '</td></tr><tr><td>' + StateNameML + '</td><td>' + denML + '</td></tr></table>' :
                'Hover over a state');            
         }
         
         else if(ny.checked == true){
         document.getElementById("myModal0").innerHTML = '<h4>US Population Density</h4>' + (props ?
                '<table><tr><th>' + '<b>name</b>' + '</th><th>' + '<b>population</b>' + '</th></tr><tr><td>' + StateNameNY + '</td><td>' + denNY + '</td></tr><tr><td>' + StateNameNY + '</td><td>' + denNY + '</td></tr><tr><td>' + StateNameNY + '</td><td>' + denNY + '</td></tr></table>' :
                'Hover over a state');            
         }
         
         else if(wc.checked == true){
         document.getElementById("myModal0").innerHTML = '<h4>US Population Density</h4>' + (props ?
                '<table><tr><th>' + '<b>name</b>' + '</th><th>' + '<b>population</b>' + '</th></tr><tr><td>' + StateNameWC + '</td><td>' + denWC + '</td></tr><tr><td>' + StateNameWC + '</td><td>' + denWC + '</td></tr><tr><td>' + StateNameWC + '</td><td>' + denWC + '</td></tr></table>' :
                'Hover over a state');            
         }
         
         else{
         document.getElementById("myModal0").innerHTML = " ";
         }
      }

        info.addTo(map);

        // get color depending on population density value
        function getColor(d) {
            return d > 1000 ? '#800026' :
                d > 500 ? '#44f2ef' :
                d > 200 ? '#a278eb' :
                d > 100 ? '#3071b8' :
                //d > 500 ? '#BD0026' :
                //d > 200 ? '#E31A1C' :
                //d > 100 ? '#FC4E2A' :
                d > 50 ? '#FD8D3C' :
                d > 20 ? '#FEB24C' :
                d > 10 ? '#FED976' :
                '#FFEDA0';
        }

        function style(feature) {
            return {
                weight: 2,
                opacity: 1,
                color: 'white',
                dashArray: '3',
                fillOpacity: 0.7,
                fillColor: getColor(feature.properties.density)
            };
        }

        function highlightFeature(e) {
            var layer = e.target;

            layer.setStyle({
                weight: 5,
                color: '#666',
                dashArray: '',
                fillOpacity: 0.7
            });

            if (!L.Browser.ie && !L.Browser.opera && !L.Browser.edge) {
                layer.bringToFront();
            }

            info.update(layer.feature.properties);
        }

        var geojson;

        function resetHighlight(e) {
            geojson.resetStyle(e.target);
            info.update();
        }

        function zoomToFeature(e) {
            map.fitBounds(e.target.getBounds());
            //            console.log(e.target);
        }

        function clickStates(target_state) {
            map.fitBounds(target_state.getBounds());
        }

        function zoomin_newyork() {
            clickStates(geojson._layers[53]);
        }

        function zoomin_maryland() {
            clickStates(geojson._layers[51]);
        }

        function zoomin_wisconsin() {
            clickStates(geojson._layers[54]);
        }

        function onEachFeature(feature, layer) {
            layer.on({
                mouseover: highlightFeature,
                mouseout: resetHighlight,
                click: zoomToFeature
            });
        }


        geojson = L.geoJson(statesData, {
            style: style,
            onEachFeature: onEachFeature
        }).addTo(map);

        map.attributionControl.addAttribution('Population data &copy; <a href="http://census.gov/">US Census Bureau</a>');

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
   </script>
	</body>

</html>