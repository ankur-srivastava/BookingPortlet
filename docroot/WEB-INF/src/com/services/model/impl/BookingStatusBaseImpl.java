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

package com.services.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.services.model.BookingStatus;

import com.services.service.BookingStatusLocalServiceUtil;

/**
 * The extended model base implementation for the BookingStatus service. Represents a row in the &quot;JPB_BookingStatus&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BookingStatusImpl}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see BookingStatusImpl
 * @see com.services.model.BookingStatus
 * @generated
 */
public abstract class BookingStatusBaseImpl extends BookingStatusModelImpl
	implements BookingStatus {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a booking status model instance should use the {@link BookingStatus} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BookingStatusLocalServiceUtil.addBookingStatus(this);
		}
		else {
			BookingStatusLocalServiceUtil.updateBookingStatus(this);
		}
	}
}