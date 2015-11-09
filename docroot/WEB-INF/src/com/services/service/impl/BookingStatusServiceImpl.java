/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.services.service.impl;

import java.util.Date;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.services.model.BookingStatus;
import com.services.model.impl.BookingStatusImpl;
import com.services.service.base.BookingStatusServiceBaseImpl;
import com.ui.helper.BookingConstants;

/**
 * The implementation of the booking status remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.services.service.BookingStatusService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Ankur Srivastava
 * @see com.services.service.base.BookingStatusServiceBaseImpl
 * @see com.services.service.BookingStatusServiceUtil
 */
public class BookingStatusServiceImpl extends BookingStatusServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.services.service.BookingStatusServiceUtil} to access the booking status remote service.
	 */
	
Log _log = LogFactoryUtil.getLog(BookingStatusServiceImpl.class.getName());
	
	private boolean updateBooking(BookingStatus  bookingStatus){
		boolean updateSuccess = false;
		if(bookingStatus.getBsId() == 0){
			BookingStatus  bookingStatusTemp = null;
			try {
				bookingStatusTemp = bookingStatusPersistence.create(counterLocalService.increment(BookingStatus.class.getName()));
			} catch (SystemException e) {
				_log.debug(e.getMessage());
			}
			if(bookingStatusTemp != null){
				bookingStatus.setBsId(bookingStatusTemp.getPrimaryKey());
			}
			if(bookingStatus.getBsId() != 0){
				try {
					bookingStatusPersistence.update(bookingStatus);
					updateSuccess = true;
					_log.debug("Booking status updated");
				} catch (SystemException e) {
					_log.debug(e.getMessage());
				}
			}
		}
		return updateSuccess;
	}
	
	public boolean bookTicket(long brtId, long userId, long bsId){
		
		BookingStatus bookingStatus = new BookingStatusImpl();
		
		bookingStatus.setBrtId(brtId);
		bookingStatus.setCreateDate(new Date());
		bookingStatus.setBsId(bsId);
		bookingStatus.setUserId(userId);
		bookingStatus.setStatus(BookingConstants.BOOKING_COMPLETED);
		
		return updateBooking(bookingStatus);
	}
}