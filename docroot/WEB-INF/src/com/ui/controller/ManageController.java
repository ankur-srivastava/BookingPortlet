/**
 * 
 */
package com.ui.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.lia.ui.helper.LIAUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.services.model.BusRoute;
import com.services.model.BusRouteTimings;
import com.services.model.Coupon;
import com.services.model.Location;
import com.services.service.BusRouteLocalServiceUtil;
import com.services.service.BusRouteTimingsLocalServiceUtil;
import com.services.service.CouponLocalServiceUtil;
import com.services.service.LocationLocalServiceUtil;
import com.ui.helper.BookingHelper;

/**
 * @author ankursrivastava
 *
 */
public class ManageController extends MVCPortlet{
	
	public static Log _log = LogFactoryUtil.getLog(ManageController.class);
	
	List<Location> locationList;
	
	public void init(){
		BookingHelper.MANAGE_VIEW_JSP = getInitParameter("manageview-jsp");
		BookingHelper.MANAGE_LOCATIONS_VIEW_JSP = getInitParameter("manageLocations-jsp");
		BookingHelper.MANAGE_BUS_VIEW_JSP = getInitParameter("manageBus-jsp");
		BookingHelper.MANAGE_ROUTE_VIEW_JSP = getInitParameter("manageRoute-jsp");
		BookingHelper.MANAGE_TIMINGS_VIEW_JSP = getInitParameter("manageTimings-jsp");
		BookingHelper.MANAGE_COUPONS_VIEW_JSP = getInitParameter("manageCoupons-jsp");
		BookingHelper.MANAGE_USER_COUPONS_VIEW_JSP = getInitParameter("manageUserCoupons-jsp");
		locationList = BookingHelper.getLocations();
	}
	
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException{
		String jspPath = BookingHelper.getManageJSPPath(BookingHelper.MANAGE_VIEW_JSP, request);
		_log.debug("jspPath "+jspPath);
		BookingHelper.setupManagePage(request, jspPath);
		request.setAttribute("locationList", locationList);
		LIAUtil.redirect(jspPath, getPortletContext(), request, response);
	}
	
	public void addLocation(ActionRequest request, ActionResponse response) throws IOException{
		_log.debug("In addLocation");
		String locationName = ParamUtil.getString(request, "locationName");
		String locationCityName = ParamUtil.getString(request, "locationCityName");
		String locationZip = ParamUtil.getString(request, "locationZip");
		String latitude = ParamUtil.getString(request, "latitude");
		String longitude = ParamUtil.getString(request, "longitude");
		
		Location location = null;
		_log.debug("locationName "+locationName);
		if(locationName != null && !locationName.equals("")){
			_log.debug("Going to add location");
			location = LocationLocalServiceUtil.addNewLocation(locationName, locationCityName, locationZip, latitude, longitude);
			if(location != null){
				_log.debug("Added");
				SessionMessages.add(request, "location-added");
			}
		}
		response.setRenderParameter("pageAction", "MANAGE_LOCATIONS_VIEW_JSP");
	}
	
	public void addRoute(ActionRequest request, ActionResponse response) throws IOException{
		_log.debug("In addRoute");

		String selStartLocation = ParamUtil.getString(request, "selStartLocation");
		String selEndLocation = ParamUtil.getString(request, "selEndLocation");
		String selMidLocation1 = ParamUtil.getString(request, "selMidLocation1");
		String selMidLocation2 = ParamUtil.getString(request, "selMidLocation2");
		
		_log.debug("selStartLocation "+selStartLocation);
		if(selStartLocation != null && !selStartLocation.equals("")){
			_log.debug("Going to add Route");
			
			BusRoute busRoute = null;
			try {
				busRoute = BusRouteLocalServiceUtil.createBusRoute(CounterLocalServiceUtil.increment(BusRoute.class.getName()));
			} catch (SystemException e) {
				
			}
			if(busRoute != null){
				busRoute.setStartLocation(Long.parseLong(selStartLocation));
				busRoute.setEndLocation(Long.parseLong(selEndLocation));
				busRoute.setMidLocation1(Long.parseLong(selMidLocation1));
				busRoute.setMidLocation2(Long.parseLong(selMidLocation2));
				busRoute.setCreateDate(new Date());
				try {
					busRoute = BusRouteLocalServiceUtil.updateBusRoute(busRoute);
					SessionMessages.add(request, "busroute-added");
				} catch (SystemException e) {
					
				}
			}
		}
		response.setRenderParameter("pageAction", "MANAGE_ROUTE_VIEW_JSP");
	}
	
	public void addTiming(ActionRequest request, ActionResponse response) throws IOException{
		_log.debug("In addRoute");

		String brId = ParamUtil.getString(request, "brId");
		long brIdNum = 0;
		if(brId != null && Validator.isNumber(brId)){
			brIdNum = Long.parseLong(brId);
		}
		String selDate = ParamUtil.getString(request, "selDate");
		String selTime = ParamUtil.getString(request, "selTime");
		String totalSeats = ParamUtil.getString(request, "totalSeats");
		String availableSeats = ParamUtil.getString(request, "availableSeats");
		String price = ParamUtil.getString(request, "price");
		
		_log.debug("selDate "+selDate);
		if(selDate != null && !selDate.equals("")){
			_log.debug("Going to add Timing");
			BusRouteTimings busRouteTiming = null;
			try {
				busRouteTiming = BusRouteTimingsLocalServiceUtil.createBusRouteTimings(CounterLocalServiceUtil.increment(BusRouteTimings.class.getName()));
			} catch (SystemException e) {
				
			}
			if(busRouteTiming != null){
				busRouteTiming.setBrId(brIdNum);
				busRouteTiming.setTravelDate(selDate);
				busRouteTiming.setTravelTime(selTime);
				busRouteTiming.setTotal(Long.parseLong(totalSeats));
				busRouteTiming.setAvailable(Long.parseLong(availableSeats));
				busRouteTiming.setPrice(Long.parseLong(price));
				busRouteTiming.setCreateDate(new Date());
				try {
					busRouteTiming = BusRouteTimingsLocalServiceUtil.updateBusRouteTimings(busRouteTiming);
					SessionMessages.add(request, "busroutetiming-added");
				} catch (SystemException e) {
					
				}
			}
		}
		response.setRenderParameter("pageAction", "MANAGE_TIMINGS_VIEW_JSP");
	}
	
	public void removeLocation(ActionRequest request, ActionResponse response) throws IOException{
		_log.debug("In removeLocation");
		String selLocation = ParamUtil.getString(request, "selLocation");
		_log.debug("selLocation "+selLocation);
		if(Validator.isNumber(selLocation) && !selLocation.equals("")){
			long selLocationId = Long.parseLong(selLocation);
			if(selLocationId != 0){
				try {
					LocationLocalServiceUtil.deleteLocation(selLocationId);
					SessionMessages.add(request, "location-deleted");
				} catch (Exception e) {
					
				} 
			}
		}else{
			SessionErrors.add(request, "location-required");
		}
		response.setRenderParameter("pageAction", "MANAGE_LOCATIONS_VIEW_JSP");
	}
	
	public void removeRoute(ActionRequest request, ActionResponse response) throws IOException{
		_log.debug("In removeRoute");
		String deleteBRId = ParamUtil.getString(request, "deleteBRId");
		_log.debug("deleteBRId "+deleteBRId);
		if(Validator.isNumber(deleteBRId) && !deleteBRId.equals("")){
			long deleteBRIdNum = Long.parseLong(deleteBRId);
			if(deleteBRIdNum != 0){
				try {
					BusRouteLocalServiceUtil.deleteBusRoute(deleteBRIdNum);
					SessionMessages.add(request, "busroute-deleted");
				} catch (Exception e) {
					
				} 
			}
		}else{
			SessionErrors.add(request, "location-required");
		}
		response.setRenderParameter("pageAction", "MANAGE_ROUTE_VIEW_JSP");
	}
	
	public void removeTiming(ActionRequest request, ActionResponse response) throws IOException{
		_log.debug("In removeTiming");
		String deleteBRTId = ParamUtil.getString(request, "deleteBRTId");
		_log.debug("deleteBRTId "+deleteBRTId);
		if(Validator.isNumber(deleteBRTId)){
			long deleteBRTIdNum = Long.parseLong(deleteBRTId);
			if(deleteBRTIdNum != 0){
				try {
					BusRouteTimingsLocalServiceUtil.deleteBusRouteTimings(deleteBRTIdNum);
					SessionMessages.add(request, "busroutetiming-deleted");
				} catch (Exception e) {
					
				} 
			}
		}else{
			SessionErrors.add(request, "location-required");
		}
		response.setRenderParameter("pageAction", "MANAGE_TIMINGS_VIEW_JSP");
	}
	
	public void addCoupon(ActionRequest request, ActionResponse response) throws IOException{
		_log.debug("In addCoupon");
		String couponName = ParamUtil.getString(request, "couponName");
		String price = ParamUtil.getString(request, "price");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); 
		Date selDate = ParamUtil.getDate(request, "selDate", dateFormat);
		String couponType = ParamUtil.getString(request, "couponType");
		_log.debug("couponType "+couponType);
		boolean audience = false;
		long couponPrice = 0;
		
		if(couponType != null && !couponType.equals("")){
			audience = Boolean.parseBoolean(couponType);
		}
		if(price != null && Validator.isNumber(price)){
			couponPrice = Long.parseLong(price);
		}
		
		Coupon coupon = null;
		
		if(couponName != null && !couponName.equals("")){
			_log.debug("Going to add coupon");
			
			try {
				coupon = CouponLocalServiceUtil.createCoupon(CounterLocalServiceUtil.increment(Coupon.class.getName()));
			} catch (SystemException e) {
				
			}
			if(coupon != null){
				coupon.setCouponName(couponName);
				coupon.setPrice(couponPrice);
				coupon.setValidTill(selDate);
				coupon.setCreateDate(new Date());
				coupon.setAudience(audience);
				try {
					coupon = CouponLocalServiceUtil.updateCoupon(coupon);
					SessionMessages.add(request, "coupon-added");
				} catch (SystemException e) {
					
				}
			}
		}else{
			SessionErrors.add(request, "coupon-name-required");
		}
		response.setRenderParameter("pageAction", "MANAGE_COUPONS_VIEW_JSP");
	}
	
	public void removeCoupon(ActionRequest request, ActionResponse response) throws IOException{
		_log.debug("In removeCoupon");
		String couponId = ParamUtil.getString(request, "couponId");
		_log.debug("couponId "+couponId);
		if(Validator.isNumber(couponId)){
			long couponIdNum = Long.parseLong(couponId);
			if(couponIdNum != 0){
				try {
					CouponLocalServiceUtil.deleteCoupon(couponIdNum);
					SessionMessages.add(request, "coupon-deleted");
				} catch (Exception e) {
					
				} 
			}
		}else{
			SessionErrors.add(request, "coupon-required");
		}
		response.setRenderParameter("pageAction", "MANAGE_COUPONS_VIEW_JSP");
	}
}
