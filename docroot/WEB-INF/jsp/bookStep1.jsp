<%@page import="com.ui.helper.BookingConstants"%>
<%@ include file="init.jsp" %>

<c:if test="<%= !themeDisplay.isSignedIn() %>">
	<script>
		window.location.replace("/c/portal/login");
	</script>
</c:if>

<% 
	List<BusRouteTimings> brtList = null;
	if(request.getAttribute("busRouteTimingsList") != null){
		brtList = (List<BusRouteTimings>)request.getAttribute("busRouteTimingsList");
	}
%>

<liferay-ui:error key="from-location-required" message="from-location-required"/>
<liferay-ui:error key="to-location-required" message="to-location-required"/>
<liferay-ui:error key="date-required" message="date-required"/>

<portlet:actionURL name="bookStep2" var="bookStep2" />
<portlet:renderURL var="cancelURL" />
<c:if test="${ !searchPerformed }">
	<div class="welcomeText">Welcome <%= themeDisplay.getUser().getFullName() %></div>
	<br />
</c:if>
<div id="searchToggler">
	<c:if test="${ searchPerformed }">
		<h4 class="header toggler-header-collapsed"><span></span></h4>
		<br /><br />
		<div class="content toggler-content-collapsed">
	</c:if>
	
	<aui:form method="post" action="<%= bookStep2 %>">
		<div class="bookingForm">
				<c:if test="${not empty locationList}">
						<b><font size="3px">From</font></b>
						<br />
						<aui:select name="fromLocation" label="">
							<aui:option value="0">Select</aui:option>
							<c:forEach items="${locationList}" var="startingLocation">
								<c:choose>
									<c:when test="${ startingLocation.locationId == selFromLocation }">
										<aui:option value="${startingLocation.locationId}" selected="true">${startingLocation.locationName}</aui:option>										
									</c:when>
									<c:otherwise>
										<aui:option value="${startingLocation.locationId}">${startingLocation.locationName}</aui:option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</aui:select>
				</c:if>
				<c:if test="${not empty locationList}">
						<b><font size="3px">To</font></b>
						<br />
						<aui:select name="toLocation" label="" >
						<aui:option value="0">Select</aui:option>
						
						<c:forEach items="${locationList}" var="startingLocation">
								<c:choose>
									<c:when test="${ startingLocation.locationId == selToLocation }">
										<aui:option value="${startingLocation.locationId}" selected="true">${startingLocation.locationName}</aui:option>										
									</c:when>
									<c:otherwise>
										<aui:option value="${startingLocation.locationId}">${startingLocation.locationName}</aui:option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</aui:select>
				</c:if>
				<b><font size="3px">Commute Date</font></b>
				<br />
				<input type="text" id="selDate" name="<portlet:namespace/>selDate" value="${ travelDate }"/>
		</div>
		<div align="center">
			<aui:button-row>
				<aui:button type="submit" value="Show schedules and availability" />
			</aui:button-row>
		</div>		
	</aui:form>
	<c:if test="${ searchPerformed }">
		</div>
	</c:if>
	
</div>
<br />

<c:if test="${ searchPerformed }">
	<c:choose>
		<c:when test="<%= (brtList != null && brtList.size() > 0) %>">
			<div align="center"><b><font size="5px">We found the following Buses for you !</font></b></div>
			
				<liferay-ui:search-container emptyResultsMessage="" delta="10">
				<liferay-ui:search-container-results>
					<% 
						//List<AdListing> adList = (List<AdListing>)request.getAttribute("adList");
						List<BusRouteTimings> brList = (List<BusRouteTimings>)request.getAttribute("busRouteTimingsList");
						//results = AdListingLocalServiceUtil.getAdListings(searchContainer.getStart(), searchContainer.getEnd());
						//total = AdListingLocalServiceUtil.getAdListingsCount();
						if(brList != null){
							results = ListUtil.subList(brList, searchContainer.getStart(), searchContainer.getEnd());
							total = brList.size();
						}else{
							results = Collections.EMPTY_LIST;
							total = 0;
						}
						pageContext.setAttribute("results", results);
						pageContext.setAttribute("total", total);
					%>
				</liferay-ui:search-container-results>
				<liferay-ui:search-container-row className="com.services.model.BusRouteTimings" keyProperty="brId" modelVar="brObject" bold="true">
					<liferay-ui:search-container-column-text>
							<div class='container2'>
								 <div style='margin-left:60px;'>
										<strong>									
											<%= brObject.getTravelTime() %>
											<% 
												if(brObject.getAvailable() > 0){
											%>
											
											<portlet:renderURL var="bookingURL">
												<portlet:param name="pageAction" value="<%= BookingConstants.BOOKING_STEP2_SCREEN %>" />
												<portlet:param name="brtId" value="<%= String.valueOf(brObject.getBrtId()) %>" />
											</portlet:renderURL>
											&nbsp;&nbsp;&nbsp;&nbsp;Price <%= brObject.getPrice() %>Rs &nbsp;&nbsp;&nbsp;&nbsp;<%= brObject.getAvailable() %> seats available&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%= bookingURL %>">Book</a>
											<!-- Show offers button -->
											<% 
												if(BookingHelper.showOffer(brObject)){
											%>
											<br />
											Special Offer - Get 20% off on your next booking. Use coupon <strong><font color="green">JPB20 *</font></strong>
											<%		
												}
											%>
											<!-- Ends -->
											<%		
												}else{
											%>
												&nbsp;&nbsp;&nbsp;&nbsp;No seats are available 
											<%		
												}
											%>
										</strong>
								</div>
							</div>		 
					</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</c:when>
		<c:otherwise>
			<div align="center"><b><font size="5px">We are sorry. No buses are available for the Route you selected.</font></b></div>
		</c:otherwise>
	</c:choose>
</c:if>
<br /><br />
*Coupons won't apply in case of cancellations.

<script type="text/javascript">
		var Y = YUI();
		YUI().use(
				'aui-toggler',
				function(Y) {
					new Y.TogglerDelegate(
						{
						animated: true,
						closeAllOnExpand: true,
						container: '#searchToggler',
						content: '.content',
					   	expanded: false,
					    header: '.header',
				      	transition: {
					  	duration: 0.2,
					  	easing: 'cubic-bezier(0, 0.1, 0, 1)'
						}
					}
				);
			  }
			);

</script>

<script>
	$(function() {
		$( "#selDate" ).datepicker({
			 showOn: "button",
			 buttonImage: "<%=request.getContextPath() %>/images/date.png",
			 buttonImageOnly: true,
			 buttonText: "Select date",
			 changeMonth: true,
			 changeYear: true
		});
	});
</script>
<style>
	.toggler-header-collapsed:before {
       content: url("<%=request.getContextPath() %>/images/show.png");
       float: right;
	   position: relative;
	   right: 50%;
	   text-align: left;
	}
	.toggler-header-expanded:before {
       content: url("<%=request.getContextPath() %>/images/hide.png");
       float: right;
	   position: relative;
	   right: 50%;
	   text-align: left; 
	}
	 
	.toggleClass{
	       display: none;
	}
	.bookingForm{
		text-align:center;
		color:#CD5C5C;
		font-family:"Comic Sans MS", cursive, sans-serif;
	}
	.welcomeText{
		text-align:center;
		color:#CD5C5C;
		font-size:25px;
		font-family:"Comic Sans MS", cursive, sans-serif;
	}
</style>