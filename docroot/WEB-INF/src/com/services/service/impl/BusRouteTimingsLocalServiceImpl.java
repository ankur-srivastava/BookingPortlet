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

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.services.model.BusRoute;
import com.services.model.BusRouteTimings;
import com.services.model.impl.BusRouteTimingsImpl;
import com.services.service.BusRouteLocalServiceUtil;
import com.services.service.base.BusRouteTimingsLocalServiceBaseImpl;

/**
 * The implementation of the bus route timings local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.services.service.BusRouteTimingsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ankur Srivastava
 * @see com.services.service.base.BusRouteTimingsLocalServiceBaseImpl
 * @see com.services.service.BusRouteTimingsLocalServiceUtil
 */
public class BusRouteTimingsLocalServiceImpl
	extends BusRouteTimingsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.services.service.BusRouteTimingsLocalServiceUtil} to access the bus route timings local service.
	 */
	
	static Log _log = LogFactoryUtil.getLog(BusRouteTimingsLocalServiceImpl.class);
	
	public List<BusRouteTimings> getAvailableBusBasedOnRouteAndDate(long brId, String date){
		List<BusRouteTimings> busRouteTimingsList = null;
		try {
			busRouteTimingsList = busRouteTimingsPersistence.findByBrIdAndTravelDate(brId, date);
		} catch (SystemException e) {
			_log.debug("Error occured while getting Bus Route Timings "+e.getMessage());
		}
		return busRouteTimingsList;
	}
	
	public List<BusRouteTimings> getBusBasedOnRouteAndDate(String date, String fromLocation, String toLocation){
		List<BusRoute> busRouteList = null;
		List<BusRouteTimings> busRouteTimingsList = null;
		
		busRouteList = BusRouteLocalServiceUtil.getBusRoutesByStartAndEndLocation(Long.parseLong(fromLocation), Long.parseLong(toLocation));
		
		if(busRouteList != null && busRouteList.size() > 0){
			_log.info("Got busRouteList "+busRouteList.size());
			for(BusRoute busRoute : busRouteList){
				List<BusRouteTimings> busRouteTimingsTempList = getAvailableBusBasedOnRouteAndDate(busRoute.getBrId(), date);
				if(busRouteTimingsTempList != null && busRouteTimingsTempList.size() > 0){
					if(busRouteTimingsList == null){
						busRouteTimingsList = new ArrayList<BusRouteTimings>();
					}
					if(busRouteTimingsList != null){
						busRouteTimingsList.addAll(busRouteTimingsTempList);
					}
				}
			}
			if(busRouteTimingsList != null && busRouteTimingsList.size() > 0){
				_log.info("busRouteTimingsList size "+busRouteTimingsList.size());
			}
		
		}else{
			_log.info("Return Sample Data ");
			
			busRouteTimingsList = new ArrayList<BusRouteTimings>();
			
			BusRouteTimings busRouteTimings = new BusRouteTimingsImpl();
			busRouteTimings.setPrice(100);
			busRouteTimings.setAvailable(20);
			busRouteTimings.setTravelDate(date);
			busRouteTimings.setTravelTime("10");
			
			BusRouteTimings busRouteTimingsSecond = new BusRouteTimingsImpl();
			busRouteTimingsSecond.setPrice(100);
			busRouteTimingsSecond.setAvailable(20);
			busRouteTimingsSecond.setTravelDate(date);
			busRouteTimingsSecond.setTravelTime("10");
			
			busRouteTimingsList.add(busRouteTimings);
			busRouteTimingsList.add(busRouteTimingsSecond);
		}
		
		return busRouteTimingsList;
	}
}