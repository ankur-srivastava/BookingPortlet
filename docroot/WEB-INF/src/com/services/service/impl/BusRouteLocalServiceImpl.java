/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.services.model.BusRoute;
import com.services.service.base.BusRouteLocalServiceBaseImpl;

/**
 * The implementation of the bus route local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.services.service.BusRouteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ankur Srivastava
 * @see com.services.service.base.BusRouteLocalServiceBaseImpl
 * @see com.services.service.BusRouteLocalServiceUtil
 */
public class BusRouteLocalServiceImpl extends BusRouteLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.services.service.BusRouteLocalServiceUtil} to access the bus route local service.
	 */
	
	public List<BusRoute> getBusRoutesByStartAndEndLocation(long startLoc, long endLoc){
		List<BusRoute> busRoutes = null;
		try {
			busRoutes = busRoutePersistence.findByStartAndEndLocation(startLoc, endLoc);
		} catch (SystemException e) {
			
		}
		return busRoutes;
	}
}