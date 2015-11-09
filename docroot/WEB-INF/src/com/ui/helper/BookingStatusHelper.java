/**
 * 
 */
package com.ui.helper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.services.model.BookingStatus;
import com.services.model.impl.BookingStatusImpl;
import com.services.service.BookingStatusLocalServiceUtil;
import com.ui.model.BookingHistory;

/**
 * @author SRIVASTAVAA
 *
 */
public class BookingStatusHelper {
	
	Log _log = LogFactoryUtil.getLog(BookingStatusHelper.class.getName());
	
	public boolean updateBooking(BookingHistory bookingHistoryObject){
		BookingStatus bookingStatus = new BookingStatusImpl();
		
		bookingStatus.setBrtId(bookingHistoryObject.getBrtId());
		bookingStatus.setCreateDate(new Date());
		bookingStatus.setBsId(bookingHistoryObject.getBsId());
		bookingStatus.setUserId(bookingHistoryObject.getUserId());
		bookingStatus.setStatus(BookingConstants.BOOKING_COMPLETED);
		
		boolean status = BookingStatusLocalServiceUtil.updateBooking(bookingStatus);
		
		return status;
	}
	
	public List<BookingHistory> getTripHistory(long userId){
		List<BookingHistory> tripHistoryList = null;
		List<BookingStatus> bookingStatusList = null;
		
		try {
			bookingStatusList = BookingStatusLocalServiceUtil.getByUserAndTripStatus(userId, BookingConstants.TRIP_COMPLETED);
		} catch (SystemException e) {
			_log.debug(e.getMessage());
		}
		
		if(bookingStatusList != null && bookingStatusList.size() > 0){
			tripHistoryList = new ArrayList<BookingHistory>();
			for(BookingStatus bStatus : bookingStatusList){
				BookingHistory tempBookingHistory = new BookingHistory();
				tempBookingHistory.setBrtId(bStatus.getBrtId());
				tempBookingHistory.setBsId(bStatus.getBsId());
				tempBookingHistory.setCreateDate(bStatus.getCreateDate());
				tempBookingHistory.setPaymentStatus(bStatus.getStatus());
				tempBookingHistory.setRoute("Rohini to Ggn");
				tempBookingHistory.setUserId(userId);
				tripHistoryList.add(tempBookingHistory);
			}
		}
		
		return tripHistoryList;
	}
}
