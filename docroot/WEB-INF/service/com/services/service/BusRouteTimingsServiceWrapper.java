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
 * Provides a wrapper for {@link BusRouteTimingsService}.
 *
 * @author Ankur Srivastava
 * @see BusRouteTimingsService
 * @generated
 */
public class BusRouteTimingsServiceWrapper implements BusRouteTimingsService,
	ServiceWrapper<BusRouteTimingsService> {
	public BusRouteTimingsServiceWrapper(
		BusRouteTimingsService busRouteTimingsService) {
		_busRouteTimingsService = busRouteTimingsService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _busRouteTimingsService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_busRouteTimingsService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _busRouteTimingsService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.services.model.BusRouteTimings> getAvailableBusBasedOnRouteAndDate(
		long brId, java.lang.String date) {
		return _busRouteTimingsService.getAvailableBusBasedOnRouteAndDate(brId,
			date);
	}

	@Override
	public java.util.List<com.services.model.BusRouteTimings> getBusBasedOnRouteAndDate(
		java.lang.String date, java.lang.String fromLocation,
		java.lang.String toLocation) {
		return _busRouteTimingsService.getBusBasedOnRouteAndDate(date,
			fromLocation, toLocation);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BusRouteTimingsService getWrappedBusRouteTimingsService() {
		return _busRouteTimingsService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBusRouteTimingsService(
		BusRouteTimingsService busRouteTimingsService) {
		_busRouteTimingsService = busRouteTimingsService;
	}

	@Override
	public BusRouteTimingsService getWrappedService() {
		return _busRouteTimingsService;
	}

	@Override
	public void setWrappedService(BusRouteTimingsService busRouteTimingsService) {
		_busRouteTimingsService = busRouteTimingsService;
	}

	private BusRouteTimingsService _busRouteTimingsService;
}