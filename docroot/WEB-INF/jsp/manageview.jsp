<%@ include file="init.jsp" %>

<portlet:renderURL var="manageLocationsURL">
	<portlet:param name="pageAction" value="MANAGE_LOCATIONS_VIEW_JSP" />
</portlet:renderURL>
<portlet:renderURL var="manageRouteURL">
	<portlet:param name="pageAction" value="MANAGE_ROUTE_VIEW_JSP" />
</portlet:renderURL>
<portlet:renderURL var="manageTimingsURL">
	<portlet:param name="pageAction" value="MANAGE_TIMINGS_VIEW_JSP" />
</portlet:renderURL>
<portlet:renderURL var="manageCoupons">
	<portlet:param name="pageAction" value="MANAGE_COUPONS_VIEW_JSP" />
</portlet:renderURL>
<portlet:renderURL var="manageUserCoupons">
	<portlet:param name="pageAction" value="MANAGE_USER_COUPONS_VIEW_JSP" />
</portlet:renderURL>

<c:if test="<%= themeDisplay.isSignedIn() && permissionChecker.isOmniadmin() ||  permissionChecker.isCompanyAdmin() %>">
	<div>
		<font size="5px">Admins can manage the data here</font>
	</div>
	<br />
	<div>
		<font size="3px"><a href="<%= manageLocationsURL %>">1. Manage Locations</a></font>
	</div>
	<br />
	<div>
		<font size="3px"><a href="<%= manageRouteURL %>">2. Manage Route</a></font>
	</div>
	<br />
	<div>
		<font size="3px"><a href="<%= manageTimingsURL %>">3. Manage Timings</a></font>
	</div>
	<br />
	<div>
		<font size="3px"><a href="<%= manageCoupons %>">4. Manage Coupons</a></font>
	</div>
	<br />
	<div>
		<font size="3px"><a href="<%= manageUserCoupons %>">5. Manage User specific Coupons</a></font>
	</div>
	<br />
	<div>
		<font size="3px"><a href="">6. Manage Bus</a></font>
	</div>
	<br />
	<div>
		<font size="3px"><a href="">7. Manage Agency</a></font>
	</div>
	<br />
	<div>
		<font size="3px"><a href="">8. Manage Employee</a></font>
	</div>
</c:if>