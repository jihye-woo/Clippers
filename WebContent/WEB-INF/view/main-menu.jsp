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
            <a href="#" id="phase0" onclick="openNav()">Phase0</a> <a href="#" id="phase1" onclick="openNav2()">Phase1,2 </a>
        </div>

        <div id="mySidepanel" class="sidepanel" style="margin-top: 1rem; margin-left: 1rem;">

            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">X</a>

            <div class="container">
                <h1 id=sidebar_header style="margin-bottom: 2rem;">Phase 0</h1>

                
                
                  <script>
                  var phase0_selected_state;
                    function phase0_select_state(){
                    	phase0_selected_state = document.getElementById("dropdown_state").value;
                    }
                    
                    </script>
                <div class="card text-center">
                    <h5 class="card-header">Select State</h5>
                    <div class="card-body">
                        <select id="dropdown_state" onchange="change()">
                            <option value="New York">New York</option>
                            <option value="Maryland">Maryland</option>
                            <option value="Wisconsin">Wisconsin</option>
                        </select>
                    </div>
                    
                  

                    <!--
                    <script>
                        function phase0_select_state() {
                            var x = document.getElementById("dropdown_state").value;
                            console.log(x);
                            return x;
                        }

                    </script>
-->
                    <!--
                    <h5 class="card-header">State</h5>
                    <div class="card-body">
                        <button class="dropdown-btn">Select State
                            <i class="fa fa-caret-down"></i>
                        </button>
                        <div class="dropdown-container">
                            <label><input type="radio" name="ship" id="NY" checked="zoomin_newyork()" /> New York</label>
                            <label><input type="radio" name="ship" id="ML" checked="zoomin_newyork()" /> Maryland</label>
                            <label><input type="radio" name="ship" id="WC" checked="zoomin_wisconsin()" /> Wisconsin</label>

                        </div>
-->

                    <!--                </div>-->

                    <h5 class="card-header">Parameters</h5>
                    <div class="card-body">
                        <div class="row">
                            <div class="col">
                                <header class="card-header">
                                    <h6 class="title">Election Term</h6>
                                </header>
                                <form>
                                    <br> <input class="phase0_electionTerm" type="checkbox" name="16_congressional" id="16_congressional" onclick="checked_electionTerm()">2016 Congressional<br>
                                    <input class="phase0_electionTerm" type="checkbox" name="18_congressional" id="18_congressional" onclick="checked_electionTerm()">2018 Congressional<br>
                                    <input class="phase0_electionTerm" type="checkbox" name="18_presidential" id="18_presidential" onclick="checked_electionTerm()">2016 Presidential<br>
                                    <br>
                                </form>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col">
                            <header class="card-header">
                                <h6 class="title">Population Percentage</h6>
                            </header>


                            <form method="post">
                                <div data-role="rangeslider" data-mini="true">
                                    <input type="range" name="phase0_population_val" id="phase0_population_min" value="20" min="0" max="100">
                                    <input type="range" name="phase0_population_val" id="phase0_population_max" value="80" min="0" max="100">
                                </div>
                            </form>



                            <header class="card-header">
                                <h6 class="title">Bloc Voting Percentage</h6>
                            </header>
                            <form method="post">
                                <div data-role="rangeslider" data-mini="true">
                                    <input type="range" name="phase0_vote_min" id="phase0_vote_min" value="20" min="0" max="100"> <input type="range" name="phase0_vote_max" id="phase0_vote_max" value="80" min="0" max="100">
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
                    <select id="dropdown_state_phase1">
                        <option value="New York">New York</option>
                        <option value="Maryland">Maryland</option>
                        <option value="Wisconsin">Wisconsin</option>
                    </select>
                    <button type="button" onclick="phase1_select_state()">Selected</button>

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
                            <input type="range" name="phase1_district_min" id="phase1_district_min" value="200" min="0" max="1000">
                            <input type="range" name="phase1_district_max" id="phase1_district_max" value="800" min="0" max="1000">
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
                    <form>
                        <input type="radio" name="phase" value="Phase1" /> Phase 1 <input type="radio" name="phase" value="Phase2" checked /> Phase 2 <input type="button" onclick="select_phase()" value="Selected">
                    </form>
                </div>
            </div>
        </div>

        <div class="container">
            <button type="button" id="phase1_start_button" class="btn btn-primary btn-lg btn-block">Start/Continue</button>
            <button type="button" id="phase1_pause_button" class="btn btn-primary btn-lg btn-block">Pause</button>
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
