        var map = L.map('map').setView([43, -83], 4.5);
        var precinct_data;

        L.tileLayer(
            'https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
                maxZoom: 18,
                attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
                    '<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
                    'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
                id: 'mapbox.light'
            }).addTo(map);

        // control that shows state info on hover
        var info = L.control();

        info.onAdd = function (map) {
            this._div = L.DomUtil.create('div', 'info');
            this.update();
            return this._div;
        };

        info.update = function (props) {

            this._div.innerHTML = '<h4>US Population Density</h4>' +
                (props ? '<table><tr><th>' + '<b>Name</b>' + '</th><th>' +
                    '<b>Density</b>' + '</th></tr><tr><td>' +
                    props.name + '</td><td>' + props.density +
                    '</td></tr><tr><td>' + props.name + '</td><td>' +
                    props.density + '</td></tr></table>' :
                    'Hover over a state');
        };

        info.addTo(map);

        // get color depending on population density value
        function getColor(d) {
            return d > 1000 ? '#800026' :
                /*   d > 500 ? '#44f2ef' :
                  d > 200 ? '#a278eb' :
                  d > 100 ? '#3071b8' : */
                d > 500 ? '#BD0026' : d > 200 ? '#E31A1C' : d > 100 ? '#FC4E2A' :
                d > 50 ? '#FD8D3C' : d > 20 ? '#FEB24C' :
                d > 10 ? '#FED976' : '#FFEDA0';
        }

        function getPrecinctColor(d) {
            return d > 500 ? '#AB08B7' :
                /*   d > 500 ? '#44f2ef' :
                  d > 200 ? '#a278eb' :
                  d > 100 ? '#3071b8' : */
                d > 200 ? '#5408B7' : d > 100 ? '#0814B7' : d > 50 ? '#086BB7' :
                d > 25 ? '#58A9E8' : d > 10 ? '#84BAE3' :
                d > 5 ? '#B3CFE5' : '#D8E5F0';
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

            var zoom_level = 4;
            // get zoom level

            var hover_endpoint = "hover_state";
            // setting default url endpoint
            if (zoom_level == 5) {
                hover_endpoint = "hover_precinct";
            } else if (zoom_level == 6) {
                hover_endpoint = "hover_district";
            }

            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/spring-mvc-demo/controller/" + hover_endpoint,
                data: e.target.feature.properties.name,
                async: false,
                dataType: 'text',
                success: function (data) {
                    console.log(data);
                }
            });

        }

        var geojson;

        function resetHighlight(e) {
            geojson.resetStyle(e.target);
            info.update();
        }

        function precinct_style(feature) {
            return {
                weight: 2,
                opacity: 1,
                color: '#086BB7',
                dashArray: '3',
                fillOpacity: 0.7,
                fillColor: '#58A9E8'
            };
        }

        function zoomToFeature(e) {
            map.fitBounds(e.target.getBounds());
            console.log("zoom");

//            var zoom_endpoint = "select_state";
            var zoom_endpoint = "zoom_precinct";
//            var zoom_endpoint = "select_district";

            var zoom_level = map.getZoom();
            // get zoom level

            $.ajax({
                type: "POST",
                //                contentType: "application/json",
                url: "/spring-mvc-demo/controller/" + zoom_endpoint,
                data: e.target.feature.properties.name,
                dataType: 'json',
                success: function (data) {
                    precinct_data = data;
                    var startTime = new Date().getTime();
                    precinct_data['precincts'].forEach(function (precinct) {
                        L.geoJson(JSON.parse(precinct), {
                            precinct_style: style,
                            onEachFeature: onEachFeature
                        }).addTo(map);
                    });
                    var endTime = new Date().getTime();

                    console.log(endTime - startTime);
                }
            });
        }

        function clickStates(target_state) {
            map.fitBounds(target_state.getBounds());
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
        
        

        map.attributionControl
            .addAttribution('Population data &copy; <a href="http://census.gov/">US Census Bureau</a>');
