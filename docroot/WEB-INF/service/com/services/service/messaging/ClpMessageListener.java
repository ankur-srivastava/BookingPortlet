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

package com.services.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.services.service.AgencyLocalServiceUtil;
import com.services.service.BookingStatusLocalServiceUtil;
import com.services.service.BookingStatusServiceUtil;
import com.services.service.BusEmployeeLocalServiceUtil;
import com.services.service.BusLocalServiceUtil;
import com.services.service.BusReservationLocalServiceUtil;
import com.services.service.BusRouteLocalServiceUtil;
import com.services.service.BusRouteTimingsLocalServiceUtil;
import com.services.service.BusRouteTimingsServiceUtil;
import com.services.service.ClpSerializer;
import com.services.service.CouponLocalServiceUtil;
import com.services.service.LocationLocalServiceUtil;
import com.services.service.UserCouponLocalServiceUtil;

/**
 * @author Ankur Srivastava
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			AgencyLocalServiceUtil.clearService();

			BookingStatusLocalServiceUtil.clearService();

			BookingStatusServiceUtil.clearService();
			BusLocalServiceUtil.clearService();

			BusEmployeeLocalServiceUtil.clearService();

			BusReservationLocalServiceUtil.clearService();

			BusRouteLocalServiceUtil.clearService();

			BusRouteTimingsLocalServiceUtil.clearService();

			BusRouteTimingsServiceUtil.clearService();
			CouponLocalServiceUtil.clearService();

			LocationLocalServiceUtil.clearService();

			UserCouponLocalServiceUtil.clearService();
		}
	}
}