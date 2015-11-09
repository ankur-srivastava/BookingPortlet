/**
 * 
 */
package com.ui.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.lia.ui.helper.LIAUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.services.model.BusRoute;
import com.services.model.BusRouteTimings;
import com.services.model.Coupon;
import com.services.model.Location;
import com.services.model.UserCoupon;
import com.services.service.BusRouteLocalServiceUtil;
import com.services.service.BusRouteTimingsLocalServiceUtil;
import com.services.service.CouponLocalServiceUtil;
import com.services.service.UserCouponLocalServiceUtil;
import com.ui.helper.BookingConstants;
import com.ui.helper.BookingHelper;
import com.ui.helper.BookingStatusHelper;
import com.ui.model.BookingHistory;

/**
 * @author ankursrivastava
 *
 */
public class MainController extends MVCPortlet{
	
	public static Log _log = LogFactoryUtil.getLog(MainController.class);
	
	List<Location> locationList;
	BookingStatusHelper bookingStatusHelper; 
	
	public void init(){
		BookingHelper.VIEW_JSP = getInitParameter("view-jsp");
		BookingHelper.BOOKING_STEP1_JSP = getInitParameter("bookStep1-jsp");
		BookingHelper.BOOKING_STEP2_JSP = getInitParameter("bookStep2-jsp");
		BookingHelper.BOOKING_STEP3_JSP = getInitParameter("bookStep3-jsp");
		BookingHelper.BOOKING_STEP4_JSP = getInitParameter("success-jsp");
		
		locationList = BookingHelper.getLocations();
		bookingStatusHelper = new BookingStatusHelper();
	}
	
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException{
		String jspPath = BookingHelper.getJSPPath(BookingHelper.VIEW_JSP, request);
		_log.info("jspPath "+jspPath);
		BookingHelper.setupPage(request, jspPath);
		request.setAttribute("locationList", locationList);
		LIAUtil.redirect(jspPath, getPortletContext(), request, response);
	}
	
	public void bookStep2(ActionRequest request, ActionResponse response) throws IOException{
		String fromLocation = "";
		String toLocation = "";
		String travelDate = ParamUtil.getString(request, "selDate");
		
		fromLocation = ParamUtil.getString(request, "fromLocation");
		toLocation = ParamUtil.getString(request, "toLocation");
		
		_log.info("travelDate "+travelDate);
		_log.info("fromLocation "+fromLocation);
		_log.info("toLocation "+toLocation);
		
		if(fromLocation.equals("") || fromLocation.equals("0")){
			SessionErrors.add(request, "from-location-required");
		}
		if(toLocation.equals("") || toLocation.equals("0")){
			SessionErrors.add(request, "to-location-required");
		}
		if(travelDate.equals("")){
			SessionErrors.add(request, "date-required");
		}
		
		request.setAttribute("selFromLocation", fromLocation);
		request.setAttribute("selToLocation", toLocation);
		request.setAttribute("travelDate", travelDate);
		
		if(SessionErrors.isEmpty(request)){
			List<BusRouteTimings> busRouteTimingsList = null;
			//Moved the code to Impl class
			busRouteTimingsList = BusRouteTimingsLocalServiceUtil.getBusBasedOnRouteAndDate(travelDate, fromLocation, toLocation);
			request.setAttribute("busRouteTimingsList", busRouteTimingsList);
		}
		request.setAttribute("searchPerformed", true);
	}
	
	public void applyCoupon(ActionRequest request, ActionResponse response){
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY); 
		String couponName = ParamUtil.getString(request, "couponName");
		String couponMessage = "";
		String brtId = ParamUtil.getString(request, "brtId");
		_log.info("couponName "+couponName+" brtId "+brtId);
		if(couponName != null && !couponName.equals("")){
			boolean couponValid = false;
			long couponAmount = 0;
			/*Check if coupon code exists in DB and if */
			Date todaysDate = new Date();
			Coupon coupon = CouponLocalServiceUtil.getCouponByName(couponName);
			if(coupon != null && (coupon.getValidTill().compareTo(todaysDate) >= 0)){
				_log.info("Got coupon "+coupon.getCouponName());
				if(coupon.getAudience()){
					couponMessage = "Coupon amount";
					couponValid = true;
					couponAmount = coupon.getPrice();
				}else{
					UserCoupon userCoupon = UserCouponLocalServiceUtil.getValidUserCoupon(themeDisplay.getUserId(), coupon.getCouponId());
					if(userCoupon != null && !userCoupon.isClaimed()){
						couponMessage = "Coupon amount";
						couponValid = true;
						couponAmount = coupon.getPrice();
					}else{
						couponMessage = "Coupon is not valid";
					}
				}
			}else{
				couponMessage = "Coupon is not valid";
			}
			request.setAttribute("couponValid", couponValid);
			request.setAttribute("couponAmount", couponAmount);
		}else{
			couponMessage = "Please enter a valid coupon";
		}
		
		request.setAttribute("couponMessage", couponMessage);
		
		response.setRenderParameter("brtId", brtId);
		response.setRenderParameter("pageAction", BookingConstants.BOOKING_STEP3_SCREEN);
	}
	
	public void paymentProcess(ActionRequest request, ActionResponse response){
		long brtId = ParamUtil.getLong(request, "brtId");
		long userId = ParamUtil.getLong(request, "userId");
		
		BookingHistory bookingHistory = new BookingHistory();
		bookingHistory.setBrtId(brtId);
		bookingHistory.setUserId(userId);
		bookingHistory.setPaymentStatus(BookingConstants.BOOKING_COMPLETED);
		
		boolean bookingStatus = bookingStatusHelper.updateBooking(bookingHistory);
		_log.info("Booking was done successfully ? "+bookingStatus);
		response.setRenderParameter("pageAction", BookingConstants.BOOKING_STEP4_SCREEN);
	}
}
