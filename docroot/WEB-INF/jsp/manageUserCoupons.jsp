<%@ include file="init.jsp" %>

<portlet:actionURL var="addLocation" name="addLocation" />
<portlet:actionURL var="removeLocation" name="removeLocation" />
<portlet:renderURL var="cancelURL" />

<div align="center">
	<font size="3px"><a href="">Manage Locations</a></font>
</div>
<br />
<liferay-ui:header
      backURL="<%= cancelURL %>"
      title="back-to-main"
/>

<liferay-ui:success key="location-added" message="location-added"/>
<liferay-ui:success key="location-deleted" message="location-deleted"/>
<liferay-ui:error key="location-required" message="location-required" />

<aui:form method="post" action="<%= addLocation %>">
	<strong><font size="3px"><liferay-ui:message key="add-location" /></font></strong>
	<br /><br />
	<aui:input type="text" name="locationName" required="true"/>
	<aui:input type="text" name="locationCityName"  />
	<aui:input type="text" name="locationZip" />
	<aui:input type="text" name="latitude" />
	<aui:input type="text" name="longitude" />
	<aui:button-row>
				<aui:button type="submit" value="Add"/>
	</aui:button-row>
</aui:form>

<aui:form method="post" action="<%= removeLocation %>">
	<br /><br />
	<strong><font size="3px"><liferay-ui:message key="delete-location" /></font></strong>
	<br /><br />
	
	<c:if test="${not empty locationList}">
			<font size="3px">Choose a location</font>
			<aui:select name="selLocation" label="" inlineField="true" inlineLabel="true">
				<aui:option value="0">Select</aui:option>
				<c:forEach items="${locationList}" var="location">
					<aui:option value="${location.locationId}">${location.locationName}</aui:option>
				</c:forEach>
			</aui:select>
	</c:if>
	<aui:button-row>
				<aui:button type="submit" value="Delete"/>
	</aui:button-row>
</aui:form>

