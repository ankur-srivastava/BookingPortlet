<%@ include file="init.jsp"%>

<%
	BusRouteTimings brtTempObject = null;
	BusRoute brTempObject = null;
	long availableSeats = 0;
	Location startLocation = null;
	Location endLocation = null;
	if(request.getAttribute("brtObject") != null){
		brtTempObject=(BusRouteTimings)request.getAttribute("brtObject");
	}
	if(brtTempObject != null){
		availableSeats = brtTempObject.getAvailable();
	}
	if(request.getAttribute("brObject") != null){
		brTempObject=(BusRoute)request.getAttribute("brObject");
		try{
			startLocation = LocationLocalServiceUtil.getLocation(brTempObject.getStartLocation());
			System.out.println("Start Lat "+startLocation.getLatitude()+" and Long "+startLocation.getLongitude());
		}catch(Exception e){
			
		}
		try{
			endLocation = LocationLocalServiceUtil.getLocation(brTempObject.getEndLocation());
		}catch(Exception e){
			
		}
	}
%>

<portlet:renderURL var="paymentScreen">
	<portlet:param name="pageAction" value="<%= BookingConstants.BOOKING_STEP3_SCREEN %>" />
	<portlet:param name="brtId" value="<%= String.valueOf(brtTempObject.getBrtId()) %>" />
</portlet:renderURL>

<style>
	#loc_map_div {
		height: 200px;
		width:300px;
		margin-left: auto;
  		margin-right: auto;
	}
	
	#map_canvas {
		width: 100%;
		height: 100%;
		margin-left: auto;
  		margin-right: auto;
	}
</style>
<script>
	jQuery(function($) {
		// Asynchronously Load the map API 
		var script = document.createElement('script');
		script.src = "http://maps.googleapis.com/maps/api/js?sensor=false&callback=initialize";
		document.body.appendChild(script);
	});

	function initialize() {
		var map;
		var directionsDisplay;
		var directionsService = new google.maps.DirectionsService();
		var bounds = new google.maps.LatLngBounds();
		
		//var start = new google.maps.LatLng(28.494146, 77.080909);
		//var end = new google.maps.LatLng(28.716166, 77.124067);
		var lat1 = '<%= Double.parseDouble(startLocation.getLatitude()) %>';
		var long1 = '<%= Double.parseDouble(startLocation.getLongitude()) %>';
		var lat2 = '<%= Double.parseDouble(endLocation.getLatitude()) %>';
		var long2 = '<%= Double.parseDouble(endLocation.getLongitude()) %>';
		
		var start = new google.maps.LatLng(lat1, long1);
		var end = new google.maps.LatLng(lat2, long2);
		
		var mapOptions = {
			mapTypeId : 'roadmap'
		};

		// Display a map on the page
		map = new google.maps.Map(document.getElementById("map_canvas"),
				mapOptions);
		map.setTilt(45);

		// Multiple Markers
		var markers = [ [ 'A', lat1, long1 ],
				[ 'C', lat2, long2 ] ];

		// Info Window Content
		var infoWindowContent = [
				[ '<div class="info_content">'
						+ '<h3>Aricent</h3>'
						+ '<p>Company in Gurgaon</p>'
						+ '</div>' ],
				[ '<div class="info_content">'
						+ '<h3>Rohini</h3>'
						+ '<p>Home</p>'
						+ '</div>' ] ];

		// Display multiple markers on a map
		var infoWindow = new google.maps.InfoWindow(), marker, i;

		// Loop through our array of markers & place each one on the map  
		for (i = 0; i < markers.length; i++) {
			var position = new google.maps.LatLng(markers[i][1], markers[i][2]);
			bounds.extend(position);
			marker = new google.maps.Marker({
				position : position,
				map : map,
				title : markers[i][0]
			});

			// Allow each marker to have an info window    
			google.maps.event.addListener(marker, 'click',
					(function(marker, i) {
						return function() {
							infoWindow.setContent(infoWindowContent[i][0]);
							infoWindow.open(map, marker);
						}
					})(marker, i));

			// Automatically center the map fitting all markers on the screen
			map.fitBounds(bounds);
		}

		// Override our map zoom level once our fitBounds function runs (Make sure it only runs once)
		var boundsListener = google.maps.event.addListener((map),
				'bounds_changed', function(event) {
					this.setZoom(10);
					google.maps.event.removeListener(boundsListener);
				});
		directionsDisplay = new google.maps.DirectionsRenderer();

		directionsDisplay.setMap(map);

		var request = {
		    origin: start,
		    destination: end,
		    travelMode: google.maps.DirectionsTravelMode.DRIVING
		};
		directionsService.route(request, function (response, status) {
		    if (status == google.maps.DirectionsStatus.OK) {
		        directionsDisplay.setDirections(response);
		    }
		});	

	}
</script>
<aui:form method="post" action="<%= paymentScreen %>">
	
	<div align="center">
		<strong><font size="5px">Verify Details</font></strong>
	</div>
	<!--  
	<div class="printLink">
			<strong><a href="#">Print</a></strong>
	</div>
	-->
	<div class="bookingDetails">
		<div class="printTicket">
			${user.fullName} traveling on ${brtObject.travelDate} at ${brtObject.travelTime}
		</div>
		<br />
		<!--  
		<div class="printTicket">
			<strong>Email</strong>&nbsp;&nbsp; ${ user.emailAddress }
		</div>
		-->
		<!--  
		<br />
		<div class="printTicket">
			<strong>Commute</strong>&nbsp;&nbsp;${brtObject.travelDate}
		</div>
		<br />
		<div class="printTicket">
			<strong>Time of Commute</strong>&nbsp;&nbsp;${brtObject.travelTime}
		</div>
		<br />
		-->
		<div class="printTicket">
			<%=(brTempObject != null ? BookingHelper.getLocationName(brTempObject.getStartLocation())  : "" )%>
			to
			<%=(brTempObject != null ? BookingHelper.getLocationName(brTempObject.getEndLocation()) : "" )%>
			<br />
			<c:if test="${brObject.midLocation1 != 0}">
				<strong>Note:</strong> This bus will also stop at <%=(brTempObject != null ? BookingHelper.getLocationName(brTempObject.getMidLocation1()) : "" )%>
			</c:if>
			<c:if test="${brObject.midLocation2 != 0}">
				and <%=(brTempObject != null ? BookingHelper.getLocationName(brTempObject.getMidLocation2()) : "" )%>
			</c:if>
		</div>
		<br />
		<!--  
		<div>
			<strong>${brtObject.available} </strong> seats are available
		</div> 
		<br />
		-->
		<div>
			<strong>Select Quantity</strong>
			<aui:select name="quantity" label="" inlineField="true"
				inlineLabel="true">
				<%
					for(int i=1;i<=availableSeats;i++){
				%>
		
				<aui:option value="<%=i%>"><%=i%></aui:option>
				<%
					}
				%>
			</aui:select>
		</div>
		<div align="center">
			<aui:button-row>
				<aui:button type="submit" value="Next" />
			</aui:button-row>
		</div>
			<div id="loc_map_div">
				<div id="map_canvas" class="mapping"></div>
			</div>
	</div>
	<aui:input type="hidden" name="brtId" value="<%= brtTempObject.getPrimaryKey() %>" inlineField="true" inlineLabel="true"/>
</aui:form>

<script>
	$(".printLink, .commonPrint").click(function(){
	    // Print
	    window.print();                  
	    event.preventDefault ? event.preventDefault() : event.returnValue = false;
	});
</script>
<!-- CSS styling for printing -->
 <style type="text/css" media="print">
	body {
		visibility:hidden;
	}
  
 	.printTicket {
 		visibility:visible;
		background-image: none;
		background-color: #FFFFFF;
		float: none;
		margin: 0px;
		padding: 0%;
		width: auto;
		position: relative;
		top: -190px;
	}
 
	.headers {
		visibility:hidden;
	}
</style>
<style>
	.bookingDetails{
		/*
		position:relative;
		float:left;
		*/
		text-align: center;
		margin:10px;
		padding:10px;
		border: 0px dotted #CD5C5C;
	}
	.showMap{
		/*
		position:relative;
		float:left;
		*/
		text-align: center;
		margin:10px;
		padding:10px;
		width: 500px;
		height:300px;
	}	
	.printLink{
		text-align:center;
		margin:10px;
		padding:5px;
	}
	.printLink a{
		color:#CD5C5C;
		font-family:"Comic Sans MS", cursive, sans-serif;
	}
	.printTicket{
		text-align:center;
	}
		.aui select {
		width:50px;
	}
	
	aui .control-group {
	    margin-bottom: 0;
	}
	
	.aui input[type="text"]{
		width: 100px;
		margin-bottom: 0;
	}
</style>