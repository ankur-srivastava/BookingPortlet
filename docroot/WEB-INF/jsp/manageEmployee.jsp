<%@ include file="init.jsp" %>

<portlet:actionURL var="addEmployee" name="addPeople" />
<portlet:actionURL var="removeEmployee" name="removePeople" />
<portlet:renderURL var="cancelURL" />

<div align="center">
	<font size="3px"><a href="">Manage Employees</a></font>
</div>
<br />
<liferay-ui:header
      backURL="<%= cancelURL %>"
      title="back-to-main"
/>

<liferay-ui:success key="employee-added" message="location-added"/>
<liferay-ui:success key="employee-deleted" message="location-deleted"/>
<liferay-ui:error key="location-required" message="location-required" />

<aui:form method="post" action="<%= addEmployee %>">
	<strong><font size="3px"><liferay-ui:message key="add-employee" /></font></strong>
	<br /><br />
	<aui:input type="text" name="personName" required="true"/>
	
	<c:if test="${not empty agencyList}">
			<font size="3px">Choose an Agency</font>
			<aui:select name="agency" label=""  >
				<aui:option value="0">Select</aui:option>
				<c:forEach items="${agencyList}" var="agency">
					<aui:option value="${agency.agencyId}">${agency.agencyName}</aui:option>
				</c:forEach>
			</aui:select>
	</c:if>
	
	<aui:input type="text" name="contactNumber"  />
	<aui:input type="text" name="email" />
	<aui:input type="text" name="license" />
	
	<aui:button-row>
				<aui:button type="submit" value="Add"/>
	</aui:button-row>
</aui:form>

<aui:form method="post" action="<%= removeEmployee %>">
	<br /><br />
	<strong><font size="3px"><liferay-ui:message key="delete-employee" /></font></strong>
	<br /><br />
	
	<c:if test="${not empty employeeList}">
			<font size="3px">Choose an Employee</font>
			<aui:select name="employeeId" label="" inlineField="true" inlineLabel="true">
				<aui:option value="0">Select</aui:option>
				<c:forEach items="${employeeList}" var="location">
					<aui:option value="${employee.beId}">${employee.beName}</aui:option>
				</c:forEach>
			</aui:select>
	</c:if>
	<aui:button-row>
				<aui:button type="submit" value="Delete"/>
	</aui:button-row>
</aui:form>

