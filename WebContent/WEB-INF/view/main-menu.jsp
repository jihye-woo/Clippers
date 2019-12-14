<!DOCTYPE html>
<html lang="en">

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
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/test_precinct.js"></script>
</head>
<body>
    <!-- <article> -->
    <!--silder section-->
    <!-- <div class="row" style="padding:15px;"> -->

    <!--map section-->
    <div class="col-sm-12">
        <div id='map'></div>
    </div>

    <!-- user control page -->
    <div class="col-sm-0" style="background-color: #eee;">
        <!-- Table content -->
        <p id="dataTable"></p>

        <div id="mySidenav" class="sidenav">
            <a href="#" id="phase0" onclick="openNav()">Phase0</a> 
            <a href="#" id="phase1" onclick="openNav2()">Phase1,2 </a>
            <a href="#" id="settings" onclick="openSettings()">Settings </a>
        </div>

        <div id="mySidepanel" class="sidepanel" style="margin-top: 1rem; margin-left: 1rem;">

            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">X</a>

            <div class="container">
                <h1 id=sidebar_header style="margin-bottom: 2rem;">Phase 0</h1>

                <div class="card text-center">
                    <h5 class="card-header">Select State</h5>
                    <div class="card-body">
                        <select id="phase0_dropdown_state" onchange="phase0_select_state()" style="color: black">
                            <option value="Michigan">Michigan</option>
                            <option value="Maryland">Maryland</option>
                            <option value="Wisconsin">Wisconsin</option>
                        </select>
                    </div>


                    <div class="row">
                        <div class="col">
                            <header class="card-header">
                                <h6 class="title">Population Percentage</h6>
                            </header>


                            <form method="post">
                                <div data-role="rangeslider" data-mini="true">
                                    <input type="range" name="phase0_population_val" id="phase0_population_val" value="80" min="0" max="100">
                                </div>
                            </form>



                            <header class="card-header">
                                <h6 class="title">Bloc Voting Percentage</h6>
                            </header>
                            <form method="post">
                                <div data-role="rangeslider" data-mini="true">
                                    <input type="range" name="phase0_population_val" id="phase0_population_val" value="80" min="0" max="100">
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>


            <div class="container">
                <button type="button" id="phase0_button" class="btn btn-primary btn-lg btn-block">Run Phase0</button>
            </div>
        </div>
    </div>


    <div id="mySidepanel2" class="sidepanel">

        <a href="javascript:void(0)" class="closebtn" onclick="closeNav2()">X</a>

        <div class="container">

            <h1 id=sidebar_header style="margin-bottom: 2rem;">Phase 1 & 2</h1>
            <div class="card text-center">
                <h5 class="card-header">Select State</h5>
                <div class="card-body">
                    <div class="card-body">
                        <select id="phase1_dropdown_state" onchange="phase1_select_state()">
                            <option value="Michigan">Michigan</option>
                            <option value="Maryland">Maryland</option>
                            <option value="Wisconsin">Wisconsin</option>
                        </select>
                    </div>

                </div>
                <header class="card-header">
                    <h6 class="title"> Demographic Group </h6>
                </header>
                <form>
                    <br>
                    <input class="phase1_ethinic" type="checkbox" name="phase1_White" id="phase1_White" onclick="phase1_checked_demographic()">White<br>
                    <input class="phase1_ethinic" type="checkbox" name="phase1_Latino" id="phase1_Latino" onclick="phase1_checked_demographic()">Hispanic, Latino American<br>
                    <input class="phase1_ethinic" type="checkbox" name="phase1_Black" id="phase1_Black" onclick="phase1_checked_demographic()">Black, African American<br>
                    <input class="phase1_ethinic" type="checkbox" name="phase1_Asian" id="phase1_Asian" onclick="phase1_checked_demographic()">Asian<br><br>
                </form>

                <h5 class="card-header">Parameters</h5>
                <div class="card-body">
                    <header class="card-header">
                        <h6 class="title">Desired number of congressional district</h6>
                    </header>
                    <form method="post">
                        <div data-role="rangeslider" data-mini="true">
                            <input type="range" name="phase1_district_val" id="phase1_district_val" value="800" min="0" max="1000">
                        </div>
                    </form>

                    <header class="card-header">
                        <h6 class="title">Majority-Minority Districts</h6>
                    </header>
                    <form method="post">
                        <div data-role="rangeslider" data-mini="true">
                            <input type="range" name="phase1_population_val" id="phase1_population_val" value="20" min="0" max="100">
                        </div>
                    </form>

                    <header class="card-header">
                        <h6 class="title">Iteration Rate</h6>
                    </header>
                    <input type="number" name="quantity" id="iterationRate" min="1" max="100">

           
                    <header class="card-header">
                        <p>Select Phase
                            <p>
                    </header>

                    <!--
                    <div class="btn-group btn-group-toggle" data-toggle="buttons"  onchange="select_phase()">
                        <label class="btn btn-secondary active">
                            <input type="radio" name="options" value= "Phase1" id="option1" autocomplete="off" checked> Phase 1
                        </label>
                        <label class="btn btn-secondary">
                            <input type="radio" name="options" value= "Phase2" id="option2" autocomplete="off"> Phase 2
                        </label>
                    </div>
-->
                    <form>
                        <input type="radio" name="phase" value="Phase1" checked/> Phase 1 <input type="radio" name="phase" value="Phase2" /> Phase 2 <input type="button" onclick="select_phase()" value="Selected">
                    </form>
                </div>
            </div>
        </div>

        <div class="container" id="phase1btn">
            <button type="button" id="phase1_start_button" value = "Start" class="btn btn-primary btn-lg btn-block">Start</button>
            <button type="button" id="phase1_pause_button" value = "Pause" class="btn btn-primary btn-lg btn-block">Pause</button>
            <button type="button" id="phase1_stop_button" value = "Stop" class="btn btn-primary btn-lg btn-block">Stop</button>
        </div>
    </div>
    </div>
       <div id="mySettings" class="sidepanel">

      <a href="javascript:void(0)" class="closebtn"
         onclick="closeSettings()">X</a>

      <div class="container">

         <h1 id=sidebar_header style="margin-bottom: 2rem;">Settings</h1>
         <div class="card text-center">
            <div class="row">
               <div class="col">
               <h5 class="card-header">Select election term</h5>
               <div class="card-body">
                     <select id="election_term" onchange="election_term()" style="color: black">
                     <option value="2016_congressional">2016 Congressional</option>
                     <option value="2018_congressional">2018 Congressional</option>
                     <option value="2018_presidential">2016 Presidential</option>
                  </select>
               </div>
               </div>

            </div>
            <h5 class="card-header">Map level</h5>
            <div class="card-body">
               <select id="map_level" onchange="map_level()" style="color: black">
                  <option value="State">State</option>
                  <option value="Precinct">Precinct</option>
                  <option value="District">District</option>
               </select>
            </div>
            <header class="card-header">
               <p>Display Original and Generated<p>
            </header>
            <form>
               <input type="radio" name="select" value="original_district" > Original district <br>
               <input type="radio" name="select" value="generated_district" > Generated district<br>
               <input type="button" onclick="select_district_toShow()" value="Display">
            </form>
         </div>
      </div>
   </div>
    
    <script>
        /* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
        var dropdown = document.getElementsByClassName("dropdown-btn");
        var i;

        for (i = 0; i < dropdown.length; i++) {
            dropdown[i].addEventListener("click", function() {
                this.classList.toggle("active");
                var dropdownContent = this.nextElementSibling;
                if (dropdownContent.style.display === "block") {
                    dropdownContent.style.display = "none";
                } else {
                    dropdownContent.style.display = "block";
                }
            });
        }

    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/map.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</body>

</html>
