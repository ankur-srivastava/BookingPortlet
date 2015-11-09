<%@page import="com.services.service.BusRouteTimingsLocalServiceUtil"%>
<%@ include file="init.jsp" %>

<portlet:actionURL var="addTiming" name="addTiming" />
<portlet:actionURL var="removeTiming" name="removeTiming" />
<portlet:renderURL var="cancelURL" />
<% 
	List<BusRoute> busRouteList = null;
	try{
		busRouteList = BusRouteLocalServiceUtil.getBusRoutes(0, BusRouteLocalServiceUtil.getBusRoutesCount());
	}catch(Exception e){
		
	}
	
	List<BusRouteTimings> busRouteTimingsList = null;
	try{
		busRouteTimingsList = BusRouteTimingsLocalServiceUtil.getBusRouteTimingses(0, BusRouteTimingsLocalServiceUtil.getBusRouteTimingsesCount());
	}catch(Exception e){
		
	}

%>
<div align="center">
	<font size="3px"><a href="">Manage Timing and Availability</a></font>
</div>
<br />
<liferay-ui:header
      backURL="<%= cancelURL %>"
      title="back-to-main"
/>

<liferay-ui:success key="busroutetiming-added" message="busroutetiming-added"/>
<liferay-ui:success key="busroutetiming-deleted" message="busroutetiming-deleted"/>

<aui:form method="post" action="<%= addTiming %>">
	<strong><font size="3px"><liferay-ui:message key="add-timing" /></font></strong>
	<br /><br />
	
	<% 
		if(busRouteList != null && busRouteList.size() > 0){
	%>
		<aui:select name="brId" label="Select Route"  >
	<%		
			for(BusRoute br : busRouteList){
	%>
			
				<aui:option value="<%= br.getBrId() %>"><%= (br.getBrId()+" "+BookingHelper.getLocationName(br.getStartLocation())+" "+BookingHelper.getLocationName(br.getEndLocation()))  %></aui:option>
	<%			
			}
	%>
		</aui:select>
	<%
		}
	%>
	Select Date<br />
	<input type="text" id="selDate" name="<portlet:namespace/>selDate" value="${ travelDate }"/>
	<br /><br />
	<aui:input type="text" name="selTime" />
	<aui:input type="text" name="totalSeats" />
	<aui:input type="text" name="availableSeats" />
	<aui:input type="text" name="price" />
	<aui:button-row>
				<aui:button type="submit" value="Add Route"/>
	</aui:button-row>
</aui:form>

<aui:form method="post" action="<%= removeTiming %>">
	<br />
	<strong><font size="3px"><liferay-ui:message key="delete-timing" /></font></strong>
	<br /><br />
	<% 
		if(busRouteTimingsList != null && busRouteTimingsList.size() > 0){
	%>
		<aui:select name="deleteBRTId" label=""  >
	<%		
			for(BusRouteTimings brt : busRouteTimingsList){
	%>
			
				<aui:option value="<%= brt.getBrtId() %>"><%= (brt.getBrId()+" "+brt.getTravelDate()+" "+brt.getTravelTime())  %></aui:option>
	<%			
			}
	%>
		</aui:select>
	<%
		}
	%>
	<aui:button-row>
				<aui:button type="submit" value="Delete"/>
	</aui:button-row>
</aui:form>
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

