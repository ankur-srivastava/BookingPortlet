<%@ include file="init.jsp" %>

<portlet:actionURL var="addCoupon" name="addCoupon" />
<portlet:actionURL var="removeCoupon" name="removeCoupon" />
<portlet:renderURL var="cancelURL" />

<div align="center">
	<font size="3px"><a href="">Manage Coupons</a></font>
</div>
<br />
<liferay-ui:header
      backURL="<%= cancelURL %>"
      title="back-to-main"
/>

<liferay-ui:success key="coupon-added" message="coupon-added"/>
<liferay-ui:success key="coupon-deleted" message="coupon-deleted"/>
<liferay-ui:error key="coupon-name-required" message="coupon-name-required" />

<aui:form method="post" action="<%= addCoupon %>">
	<strong><font size="3px"><liferay-ui:message key="add-coupon" /></font></strong>
	<br /><br />
	<aui:input type="text" name="couponName" required="true"/>
	<aui:input type="text" name="price"  />
	Valid Till<br />
	<input type="text" id="selDate" name="<portlet:namespace/>selDate" />
	<br /><br />
	<aui:select name="couponType" label="Select Coupon Type"  >
		<aui:option value="true">Applicable to all</aui:option>
		<aui:option value="false">Applicable to specific users</aui:option>
	</aui:select>
	<aui:button-row>
				<aui:button type="submit" value="Add Coupon"/>
	</aui:button-row>
</aui:form>

<aui:form method="post" action="<%= removeCoupon %>">
	<br /><br />
	<strong><font size="3px"><liferay-ui:message key="delete-coupon" /></font></strong>
	<br /><br />
	
	<c:if test="${not empty couponsList}">
			<font size="3px">Choose a Coupon</font>
			<aui:select name="couponId" label="" inlineField="true" inlineLabel="true">
				<aui:option value="0">Select</aui:option>
				<c:forEach items="${couponsList}" var="coupon">
					<aui:option value="${coupon.couponId}">${coupon.couponName}</aui:option>
				</c:forEach>
			</aui:select>
	</c:if>
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
