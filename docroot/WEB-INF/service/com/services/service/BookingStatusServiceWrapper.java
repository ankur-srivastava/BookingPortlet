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

package com.services.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BookingStatusService}.
 *
 * @author Ankur Srivastava
 * @see BookingStatusService
 * @generated
 */
public class BookingStatusServiceWrapper implements BookingStatusService,
	ServiceWrapper<BookingStatusService> {
	public BookingStatusServiceWrapper(
		BookingStatusService bookingStatusService) {
		_bookingStatusService = bookingStatusService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _bookingStatusService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_bookingStatusService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _bookingStatusService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public boolean bookTicket(long brtId, long userId, long bsId) {
		return _bookingStatusService.bookTicket(brtId, userId, bsId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BookingStatusService getWrappedBookingStatusService() {
		return _bookingStatusService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBookingStatusService(
		BookingStatusService bookingStatusService) {
		_bookingStatusService = bookingStatusService;
	}

	@Override
	public BookingStatusService getWrappedService() {
		return _bookingStatusService;
	}

	@Override
	public void setWrappedService(BookingStatusService bookingStatusService) {
		_bookingStatusService = bookingStatusService;
	}

	private BookingStatusService _bookingStatusService;
}