<%@ include file="init.jsp"%>

<portlet:actionURL name="applyCoupon" var="applyCoupon" />
<portlet:actionURL name="paymentProcess" var="paymentProcess" />

<%
	Booking bookingObject = null;
	if(request.getAttribute("bookingObject") != null){
		bookingObject = (Booking)request.getAttribute("bookingObject");
	}
%>
		<div class="paymentBlock">
			<strong>Payment</strong>
			<br /><br />
			<div>
				<strong>Quantity</strong>&nbsp;&nbsp;&nbsp;&nbsp; ${bookingObject.quantity}
			</div>
			<br />
			<div>
				<strong>Base</strong>&nbsp;&nbsp;&nbsp;&nbsp; ${bookingObject.basePrice} INR
			</div>
			<br />
			<div>
				<strong>Taxes</strong>&nbsp;&nbsp;&nbsp;&nbsp; ${bookingObject.taxPrice} INR
			</div>
			<br />
			<aui:form method="post"  action="<%= applyCoupon %>">
				<div>
					<strong>Coupon</strong>&nbsp;&nbsp;
					<aui:input type="text" name="couponName" label="" inlineField="true" inlineLabel="true" />
					<aui:button type="submit" value="Apply" />
					<br />
					<c:if test="${ couponMessage ne null }">
							<strong><font color="green">${ couponMessage }</font></strong>&nbsp;&nbsp;${ bookingObject.couponAmount } INR
							<br />
					</c:if>
					<aui:input type="hidden" name="brtId" value="${bookingObject.brtId}" inlineField="true" inlineLabel="true"/>
				</div>
			</aui:form>
			
			<br />
			<div>
				<strong>Total</strong>&nbsp;&nbsp;&nbsp;&nbsp; ${bookingObject.totalPrice} INR
			</div>
			<div class="payments">
				<strong>By clicking on Pay Now you agree to our <a href="terms.html">Terms of Service</a></strong>
				<br /><br />
				<aui:form method="POST" action="<%= paymentProcess %>">
					<aui:input type="hidden" name="brtId" value="<%= bookingObject.getBrtId() %>" inlineField="true" inlineLabel="true"/>
					<aui:input type="hidden" name="userId" value="<%= themeDisplay.getUserId() %>" inlineField="true" inlineLabel="true"/>
					<aui:button type="submit" value="Pay Now" />
				</aui:form>
				<br /><br />
			</div>
		</div>
		<style>
			.paymentBlock{
				text-align:center;
			}			
			.payments{
				margin-top:20px;
			}
		</style>