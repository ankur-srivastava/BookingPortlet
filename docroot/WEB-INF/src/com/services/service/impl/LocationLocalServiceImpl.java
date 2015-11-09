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

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.services.model.Location;
import com.services.service.base.LocationLocalServiceBaseImpl;

/**
 * The implementation of the location local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.services.service.LocationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ankur Srivastava
 * @see com.services.service.base.LocationLocalServiceBaseImpl
 * @see com.services.service.LocationLocalServiceUtil
 */
public class LocationLocalServiceImpl extends LocationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.services.service.LocationLocalServiceUtil} to access the location local service.
	 */
	
	public Location addNewLocation(String name, String locationCityName, String locationZip, String lat, String longitude){
		Location location = null;
		try {
			location = locationPersistence.create(counterLocalService.increment(Location.class.getName()));
		} catch (SystemException e) {

		}
		if(location != null){
			location.setCreateDate(new Date());
			location.setLocationName(name);
			location.setLocationCityName(locationCityName);
			location.setLocationZip(locationZip);
			location.setLatitude(lat);
			location.setLongitude(longitude);
			
			try {
				location = locationPersistence.update(location);
			} catch (SystemException e) {

			}
		}
		return location;
	}
	
	
	public List<Location> getLocations() throws SystemException{
		return locationPersistence.findAll();
	}
}