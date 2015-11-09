<%@ include file="init.jsp" %>

<portlet:actionURL var="addRoute" name="addRoute" />
<portlet:actionURL var="removeRoute" name="removeRoute" />
<portlet:renderURL var="cancelURL" />
<% 
	List<BusRoute> busRouteList = null;
	try{
		busRouteList = BusRouteLocalServiceUtil.getBusRoutes(0, BusRouteLocalServiceUtil.getBusRoutesCount());
	}catch(Exception e){
		
	}

%>
<div align="center">
	<font size="3px"><a href="">Manage Routes</a></font>
</div>
<br />
<liferay-ui:header
      backURL="<%= cancelURL %>"
      title="back-to-main"
/>

<liferay-ui:success key="busroute-added" message="busroute-added"/>
<liferay-ui:success key="busroute-deleted" message="busroute-deleted"/>
<liferay-ui:error key="location-required" message="location-required" />

<aui:form method="post" action="<%= addRoute %>">
	<strong><font size="3px"><liferay-ui:message key="add-route" /></font></strong>
	<br /><br />
	<c:if test="${not empty locationList}">
			<font size="3px">Choose a Start Location</font>
			<aui:select name="selStartLocation" label=""  >
				<aui:option value="0">Select</aui:option>
				<c:forEach items="${locationList}" var="location">
					<aui:option value="${location.locationId}">${location.locationName}</aui:option>
				</c:forEach>
			</aui:select>
	</c:if>
	<c:if test="${not empty locationList}">
			<font size="3px">Choose an End Location</font>
			<aui:select name="selEndLocation" label=""  >
				<aui:option value="0">Select</aui:option>
				<c:forEach items="${locationList}" var="location">
					<aui:option value="${location.locationId}">${location.locationName}</aui:option>
				</c:forEach>
			</aui:select>
	</c:if>
	<c:if test="${not empty locationList}">
			<font size="3px">Choose the first Mid Location</font>
			<aui:select name="selMidLocation1" label=""  >
				<aui:option value="0">Select</aui:option>
				<c:forEach items="${locationList}" var="location">
					<aui:option value="${location.locationId}">${location.locationName}</aui:option>
				</c:forEach>
			</aui:select>
	</c:if>
	<c:if test="${not empty locationList}">
			<font size="3px">Choose the second Mid Location</font>
			<aui:select name="selMidLocation2" label=""  >
				<aui:option value="0">Select</aui:option>
				<c:forEach items="${locationList}" var="location">
					<aui:option value="${location.locationId}">${location.locationName}</aui:option>
				</c:forEach>
			</aui:select>
	</c:if>
	
	<aui:button-row>
				<aui:button type="submit" value="Add Route"/>
	</aui:button-row>
</aui:form>

<aui:form method="post" action="<%= removeRoute %>">
	<br />
	<strong><font size="3px"><liferay-ui:message key="delete-route" /></font></strong>
	<br /><br />
	<% 
		if(busRouteList != null && busRouteList.size() > 0){
	%>
		<aui:select name="deleteBRId" label=""  >
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
	<aui:button-row>
				<aui:button type="submit" value="Delete"/>
	</aui:button-row>
</aui:form>

