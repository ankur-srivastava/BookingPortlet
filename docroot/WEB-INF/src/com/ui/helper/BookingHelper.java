/**
 * 
 */
package com.ui.helper;

import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.services.model.BusRoute;
import com.services.model.BusRouteTimings;
import com.services.model.Coupon;
import com.services.model.Location;
import com.services.service.BusRouteLocalServiceUtil;
import com.services.service.BusRouteTimingsLocalServiceUtil;
import com.services.service.CouponLocalServiceUtil;
import com.services.service.LocationLocalServiceUtil;
import com.ui.model.Booking;

/**
 * @author ankursrivastava
 *
 */
public class BookingHelper {
	
	public static String VIEW_JSP;
	public static String BOOKING_STEP1_JSP;
	public static String BOOKING_STEP2_JSP;
	public static String BOOKING_STEP3_JSP;
	public static String BOOKING_STEP4_JSP;
	
	public static String MANAGE_VIEW_JSP;
	public static String MANAGE_LOCATIONS_VIEW_JSP;
	public static String MANAGE_BUS_VIEW_JSP;
	public static String MANAGE_ROUTE_VIEW_JSP;
	public static String MANAGE_TIMINGS_VIEW_JSP;
	public static String MANAGE_COUPONS_VIEW_JSP;
	public static String MANAGE_USER_COUPONS_VIEW_JSP;
	
	public static Log _log = LogFactoryUtil.getLog(BookingHelper.class);
	
	public static String getLocationName(long locationId){
		Location location = null;
		String locationName = "";
		if(locationId != 0){
			try {
				location = LocationLocalServiceUtil.fetchLocation(locationId);
			} catch (SystemException e) {
				
			}
		}
		if(location != null){
			locationName = location.getLocationName();
		}else{
			locationName = "Metro";
		}
		return locationName;
	}
	
	public static String getJSPPath(String jspPath, PortletRequest request){
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		String pageAction = "";
		if(request.getAttribute("jspPath") != null){
			jspPath = (String) request.getAttribute("jspPath");
		}else if(request.getParameter("pageAction") != null){
			pageAction = request.getParameter("pageAction");
			if(pageAction.equals(BookingConstants.BOOKING_STEP2_SCREEN)){
				jspPath = BOOKING_STEP2_JSP;
			} else if(pageAction.equals(BookingConstants.BOOKING_STEP3_SCREEN)){
				jspPath = BOOKING_STEP3_JSP;
			} else if(pageAction.equals(BookingConstants.BOOKING_STEP4_SCREEN)){
				jspPath = BOOKING_STEP4_JSP;
			}
		}else{
			jspPath = getJspPathBasedOnURL(themeDisplay);	
		}
		return jspPath;
	}
	
	public static String getManageJSPPath(String jspPath, PortletRequest request){
		//ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		String pageAction = "";
		if(request.getAttribute("jspPath") != null){
			jspPath = (String) request.getAttribute("jspPath");
		}else if(request.getParameter("pageAction") != null){
			pageAction = request.getParameter("pageAction");
			if(pageAction.equals("MANAGE_LOCATIONS_VIEW_JSP")){
				jspPath = MANAGE_LOCATIONS_VIEW_JSP;
			}else if(pageAction.equals("MANAGE_ROUTE_VIEW_JSP")){
				jspPath = MANAGE_ROUTE_VIEW_JSP;
			}else if(pageAction.equals("MANAGE_TIMINGS_VIEW_JSP")){
				jspPath = MANAGE_TIMINGS_VIEW_JSP;
			}else if(pageAction.equals("MANAGE_COUPONS_VIEW_JSP")){
				jspPath = MANAGE_COUPONS_VIEW_JSP;
			}else if(pageAction.equals("MANAGE_USER_COUPONS_VIEW_JSP")){
				jspPath = MANAGE_USER_COUPONS_VIEW_JSP;
			}
		}else{
			//jspPath = getManageJspPathBasedOnURL(themeDisplay);	
		}
		return jspPath;
	}
	
	public static String getManageJspPathBasedOnURL(ThemeDisplay themeDisplay){
		String jspPath = "";
		String currentURL=themeDisplay.getURLCurrent();
		if(currentURL.contains(BookingConstants.BOOKING_MANAGE_ADMIN_SCREEN)){
			jspPath = BookingHelper.BOOKING_STEP1_JSP;
		}else if(currentURL.contains(BookingConstants.BOOKING_STEP2_SCREEN)){
			jspPath = BookingHelper.BOOKING_STEP2_JSP;
		}else{
			jspPath = BookingHelper.VIEW_JSP;
		}
		
		return jspPath;
	}
	
	public static String getJspPathBasedOnURL(ThemeDisplay themeDisplay){
		String jspPath = "";
		String currentURL=themeDisplay.getURLCurrent();
		if(currentURL.contains(BookingConstants.BOOKING_STEP1_SCREEN)){
			jspPath = BookingHelper.BOOKING_STEP1_JSP;
		}else if(currentURL.contains(BookingConstants.BOOKING_STEP2_SCREEN)){
			jspPath = BookingHelper.BOOKING_STEP2_JSP;
		}else{
			jspPath = BookingHelper.VIEW_JSP;
		}
		
		return jspPath;
	}
	
	public static void setupPage(RenderRequest request, String jspPath){
		if(jspPath.equals(BookingHelper.BOOKING_STEP2_JSP)){
			String brtId = "";
			long brtIdNum = 0;
			
			if(request.getParameter("brtId") != null){
				brtId = request.getParameter("brtId");
				_log.info("brtId is "+brtId);
				if(Validator.isNumber(brtId)){
					brtIdNum = Long.parseLong(brtId);
					if(brtIdNum != 0){
						BusRouteTimings brtObject = null;
						BusRoute brObject = null;
						try {
							brtObject = BusRouteTimingsLocalServiceUtil.fetchBusRouteTimings(brtIdNum);
							_log.info("Got brtObject");
						} catch (SystemException e) {
						}
						if(brtObject != null){
							try {
								brObject = BusRouteLocalServiceUtil.fetchBusRoute(brtObject.getBrId());
							} catch (SystemException e) {
							}
						}
						request.setAttribute("brtObject", brtObject);
						request.setAttribute("brObject", brObject);
					}
				}
			}
		} else if(jspPath.equals(BookingHelper.BOOKING_STEP3_JSP)){
			
			String brtId = "";

			long brtIdNum = 0;
			long basePrice = BookingConstants.BASE_PRICE;
			long taxAmount = 0;
			long totalAmount = 0;
			long couponAmount = 0;
			
			int quantity = 1;
			
			_log.info("Checking brtId");
			
			Booking booking = new Booking();
			
			if(request.getAttribute("couponAmount") != null){
				couponAmount = (Long)request.getAttribute("couponAmount"); 
			}
			
			if(request.getParameter("brtId") != null){
				if(request.getParameter("quantity") != null){
					quantity = Integer.parseInt(request.getParameter("quantity"));
				}
				brtId = request.getParameter("brtId");
				_log.info("brtId is "+brtId);
				if(Validator.isNumber(brtId)){
					brtIdNum = Long.parseLong(brtId);
					booking.setBrtId(brtIdNum);
					if(brtIdNum != 0){
						BusRouteTimings brtObject = null;
						try {
							brtObject = BusRouteTimingsLocalServiceUtil.fetchBusRouteTimings(brtIdNum);
						} catch (SystemException e) {
							_log.debug("Following error occured while fetching brtObject "+e.getMessage());
						}
						if(brtObject != null){
							basePrice = quantity*(brtObject.getPrice());
							taxAmount = (basePrice*BookingConstants.SERVICE_TAX_PERCENT)/100;
							if(couponAmount != 0){
								totalAmount = (basePrice-couponAmount)+taxAmount;
							}else{
								totalAmount = basePrice+taxAmount;
							}
						}
						
						booking.setQuantity(quantity);
						booking.setBasePrice(basePrice);
						booking.setTotalPrice(totalAmount);
						booking.setTaxPrice(taxAmount);
						booking.setCouponAmount(couponAmount);
					}
				}
			}
			request.setAttribute("bookingObject", booking);
		}
	}
	
	public static void setupManagePage(RenderRequest request, String jspPath){
		if(jspPath.equals(BookingHelper.MANAGE_COUPONS_VIEW_JSP)){
			_log.info("Trying to get coupons list");
			List<Coupon> couponsList = null;
			try {
				couponsList = CouponLocalServiceUtil.getCoupons(0, CouponLocalServiceUtil.getCouponsCount());
			} catch (SystemException e) {
				
			}
			request.setAttribute("couponsList", couponsList);
		}
	}
	
	public static List<Location> getLocations(){
		List<Location> locationList = null;
		try {
			//locationList = LocationLocalServiceUtil.getLocations(0, LocationLocalServiceUtil.getLocationsCount());
			locationList = LocationLocalServiceUtil.getLocations();
			_log.info("Locations count "+locationList.size());
		} catch (SystemException e) {
			_log.debug("Error while getting locations");
		}
		return locationList;
	}
	
	public static boolean showOffer(BusRouteTimings brtObject){
		boolean result = false;
		long available = brtObject.getAvailable();
		long total = brtObject.getTotal();
		long offercriteria = (total / 2);
		_log.info("available "+available+" total "+total+" offercriteria "+offercriteria);
		if(available <= offercriteria){
			result = true;
		}
		return result;
	}
}
