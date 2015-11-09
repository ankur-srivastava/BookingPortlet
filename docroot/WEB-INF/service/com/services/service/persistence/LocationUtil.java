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

package com.services.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.services.model.Location;

import java.util.List;

/**
 * The persistence utility for the location service. This utility wraps {@link LocationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see LocationPersistence
 * @see LocationPersistenceImpl
 * @generated
 */
public class LocationUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Location location) {
		getPersistence().clearCache(location);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Location> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Location> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Location> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Location update(Location location) throws SystemException {
		return getPersistence().update(location);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Location update(Location location,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(location, serviceContext);
	}

	/**
	* Returns all the locations where locationName = &#63;.
	*
	* @param locationName the location name
	* @return the matching locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Location> findByLocationName(
		java.lang.String locationName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLocationName(locationName);
	}

	/**
	* Returns a range of all the locations where locationName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param locationName the location name
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @return the range of matching locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Location> findByLocationName(
		java.lang.String locationName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLocationName(locationName, start, end);
	}

	/**
	* Returns an ordered range of all the locations where locationName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param locationName the location name
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Location> findByLocationName(
		java.lang.String locationName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLocationName(locationName, start, end,
			orderByComparator);
	}

	/**
	* Returns the first location in the ordered set where locationName = &#63;.
	*
	* @param locationName the location name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location
	* @throws com.services.NoSuchLocationException if a matching location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location findByLocationName_First(
		java.lang.String locationName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchLocationException {
		return getPersistence()
				   .findByLocationName_First(locationName, orderByComparator);
	}

	/**
	* Returns the first location in the ordered set where locationName = &#63;.
	*
	* @param locationName the location name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location, or <code>null</code> if a matching location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location fetchByLocationName_First(
		java.lang.String locationName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLocationName_First(locationName, orderByComparator);
	}

	/**
	* Returns the last location in the ordered set where locationName = &#63;.
	*
	* @param locationName the location name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location
	* @throws com.services.NoSuchLocationException if a matching location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location findByLocationName_Last(
		java.lang.String locationName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchLocationException {
		return getPersistence()
				   .findByLocationName_Last(locationName, orderByComparator);
	}

	/**
	* Returns the last location in the ordered set where locationName = &#63;.
	*
	* @param locationName the location name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location, or <code>null</code> if a matching location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location fetchByLocationName_Last(
		java.lang.String locationName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLocationName_Last(locationName, orderByComparator);
	}

	/**
	* Returns the locations before and after the current location in the ordered set where locationName = &#63;.
	*
	* @param locationId the primary key of the current location
	* @param locationName the location name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next location
	* @throws com.services.NoSuchLocationException if a location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location[] findByLocationName_PrevAndNext(
		long locationId, java.lang.String locationName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchLocationException {
		return getPersistence()
				   .findByLocationName_PrevAndNext(locationId, locationName,
			orderByComparator);
	}

	/**
	* Removes all the locations where locationName = &#63; from the database.
	*
	* @param locationName the location name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLocationName(java.lang.String locationName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLocationName(locationName);
	}

	/**
	* Returns the number of locations where locationName = &#63;.
	*
	* @param locationName the location name
	* @return the number of matching locations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLocationName(java.lang.String locationName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLocationName(locationName);
	}

	/**
	* Returns all the locations where locationCityName = &#63;.
	*
	* @param locationCityName the location city name
	* @return the matching locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Location> findByLocationCityName(
		java.lang.String locationCityName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLocationCityName(locationCityName);
	}

	/**
	* Returns a range of all the locations where locationCityName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param locationCityName the location city name
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @return the range of matching locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Location> findByLocationCityName(
		java.lang.String locationCityName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLocationCityName(locationCityName, start, end);
	}

	/**
	* Returns an ordered range of all the locations where locationCityName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param locationCityName the location city name
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Location> findByLocationCityName(
		java.lang.String locationCityName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLocationCityName(locationCityName, start, end,
			orderByComparator);
	}

	/**
	* Returns the first location in the ordered set where locationCityName = &#63;.
	*
	* @param locationCityName the location city name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location
	* @throws com.services.NoSuchLocationException if a matching location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location findByLocationCityName_First(
		java.lang.String locationCityName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchLocationException {
		return getPersistence()
				   .findByLocationCityName_First(locationCityName,
			orderByComparator);
	}

	/**
	* Returns the first location in the ordered set where locationCityName = &#63;.
	*
	* @param locationCityName the location city name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location, or <code>null</code> if a matching location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location fetchByLocationCityName_First(
		java.lang.String locationCityName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLocationCityName_First(locationCityName,
			orderByComparator);
	}

	/**
	* Returns the last location in the ordered set where locationCityName = &#63;.
	*
	* @param locationCityName the location city name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location
	* @throws com.services.NoSuchLocationException if a matching location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location findByLocationCityName_Last(
		java.lang.String locationCityName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchLocationException {
		return getPersistence()
				   .findByLocationCityName_Last(locationCityName,
			orderByComparator);
	}

	/**
	* Returns the last location in the ordered set where locationCityName = &#63;.
	*
	* @param locationCityName the location city name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location, or <code>null</code> if a matching location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location fetchByLocationCityName_Last(
		java.lang.String locationCityName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLocationCityName_Last(locationCityName,
			orderByComparator);
	}

	/**
	* Returns the locations before and after the current location in the ordered set where locationCityName = &#63;.
	*
	* @param locationId the primary key of the current location
	* @param locationCityName the location city name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next location
	* @throws com.services.NoSuchLocationException if a location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location[] findByLocationCityName_PrevAndNext(
		long locationId, java.lang.String locationCityName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchLocationException {
		return getPersistence()
				   .findByLocationCityName_PrevAndNext(locationId,
			locationCityName, orderByComparator);
	}

	/**
	* Removes all the locations where locationCityName = &#63; from the database.
	*
	* @param locationCityName the location city name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLocationCityName(
		java.lang.String locationCityName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLocationCityName(locationCityName);
	}

	/**
	* Returns the number of locations where locationCityName = &#63;.
	*
	* @param locationCityName the location city name
	* @return the number of matching locations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLocationCityName(java.lang.String locationCityName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLocationCityName(locationCityName);
	}

	/**
	* Returns all the locations where locationZip = &#63;.
	*
	* @param locationZip the location zip
	* @return the matching locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Location> findByLocationZip(
		java.lang.String locationZip)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLocationZip(locationZip);
	}

	/**
	* Returns a range of all the locations where locationZip = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param locationZip the location zip
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @return the range of matching locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Location> findByLocationZip(
		java.lang.String locationZip, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLocationZip(locationZip, start, end);
	}

	/**
	* Returns an ordered range of all the locations where locationZip = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param locationZip the location zip
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Location> findByLocationZip(
		java.lang.String locationZip, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLocationZip(locationZip, start, end, orderByComparator);
	}

	/**
	* Returns the first location in the ordered set where locationZip = &#63;.
	*
	* @param locationZip the location zip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location
	* @throws com.services.NoSuchLocationException if a matching location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location findByLocationZip_First(
		java.lang.String locationZip,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchLocationException {
		return getPersistence()
				   .findByLocationZip_First(locationZip, orderByComparator);
	}

	/**
	* Returns the first location in the ordered set where locationZip = &#63;.
	*
	* @param locationZip the location zip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location, or <code>null</code> if a matching location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location fetchByLocationZip_First(
		java.lang.String locationZip,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLocationZip_First(locationZip, orderByComparator);
	}

	/**
	* Returns the last location in the ordered set where locationZip = &#63;.
	*
	* @param locationZip the location zip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location
	* @throws com.services.NoSuchLocationException if a matching location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location findByLocationZip_Last(
		java.lang.String locationZip,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchLocationException {
		return getPersistence()
				   .findByLocationZip_Last(locationZip, orderByComparator);
	}

	/**
	* Returns the last location in the ordered set where locationZip = &#63;.
	*
	* @param locationZip the location zip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location, or <code>null</code> if a matching location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location fetchByLocationZip_Last(
		java.lang.String locationZip,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLocationZip_Last(locationZip, orderByComparator);
	}

	/**
	* Returns the locations before and after the current location in the ordered set where locationZip = &#63;.
	*
	* @param locationId the primary key of the current location
	* @param locationZip the location zip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next location
	* @throws com.services.NoSuchLocationException if a location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location[] findByLocationZip_PrevAndNext(
		long locationId, java.lang.String locationZip,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchLocationException {
		return getPersistence()
				   .findByLocationZip_PrevAndNext(locationId, locationZip,
			orderByComparator);
	}

	/**
	* Removes all the locations where locationZip = &#63; from the database.
	*
	* @param locationZip the location zip
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLocationZip(java.lang.String locationZip)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLocationZip(locationZip);
	}

	/**
	* Returns the number of locations where locationZip = &#63;.
	*
	* @param locationZip the location zip
	* @return the number of matching locations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLocationZip(java.lang.String locationZip)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLocationZip(locationZip);
	}

	/**
	* Returns all the locations where active = &#63;.
	*
	* @param active the active
	* @return the matching locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Location> findByActiveLocations(
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByActiveLocations(active);
	}

	/**
	* Returns a range of all the locations where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @return the range of matching locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Location> findByActiveLocations(
		boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByActiveLocations(active, start, end);
	}

	/**
	* Returns an ordered range of all the locations where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Location> findByActiveLocations(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActiveLocations(active, start, end, orderByComparator);
	}

	/**
	* Returns the first location in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location
	* @throws com.services.NoSuchLocationException if a matching location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location findByActiveLocations_First(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchLocationException {
		return getPersistence()
				   .findByActiveLocations_First(active, orderByComparator);
	}

	/**
	* Returns the first location in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location, or <code>null</code> if a matching location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location fetchByActiveLocations_First(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByActiveLocations_First(active, orderByComparator);
	}

	/**
	* Returns the last location in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location
	* @throws com.services.NoSuchLocationException if a matching location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location findByActiveLocations_Last(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchLocationException {
		return getPersistence()
				   .findByActiveLocations_Last(active, orderByComparator);
	}

	/**
	* Returns the last location in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location, or <code>null</code> if a matching location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location fetchByActiveLocations_Last(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByActiveLocations_Last(active, orderByComparator);
	}

	/**
	* Returns the locations before and after the current location in the ordered set where active = &#63;.
	*
	* @param locationId the primary key of the current location
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next location
	* @throws com.services.NoSuchLocationException if a location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location[] findByActiveLocations_PrevAndNext(
		long locationId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchLocationException {
		return getPersistence()
				   .findByActiveLocations_PrevAndNext(locationId, active,
			orderByComparator);
	}

	/**
	* Removes all the locations where active = &#63; from the database.
	*
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByActiveLocations(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByActiveLocations(active);
	}

	/**
	* Returns the number of locations where active = &#63;.
	*
	* @param active the active
	* @return the number of matching locations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByActiveLocations(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByActiveLocations(active);
	}

	/**
	* Caches the location in the entity cache if it is enabled.
	*
	* @param location the location
	*/
	public static void cacheResult(com.services.model.Location location) {
		getPersistence().cacheResult(location);
	}

	/**
	* Caches the locations in the entity cache if it is enabled.
	*
	* @param locations the locations
	*/
	public static void cacheResult(
		java.util.List<com.services.model.Location> locations) {
		getPersistence().cacheResult(locations);
	}

	/**
	* Creates a new location with the primary key. Does not add the location to the database.
	*
	* @param locationId the primary key for the new location
	* @return the new location
	*/
	public static com.services.model.Location create(long locationId) {
		return getPersistence().create(locationId);
	}

	/**
	* Removes the location with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param locationId the primary key of the location
	* @return the location that was removed
	* @throws com.services.NoSuchLocationException if a location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location remove(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchLocationException {
		return getPersistence().remove(locationId);
	}

	public static com.services.model.Location updateImpl(
		com.services.model.Location location)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(location);
	}

	/**
	* Returns the location with the primary key or throws a {@link com.services.NoSuchLocationException} if it could not be found.
	*
	* @param locationId the primary key of the location
	* @return the location
	* @throws com.services.NoSuchLocationException if a location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location findByPrimaryKey(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchLocationException {
		return getPersistence().findByPrimaryKey(locationId);
	}

	/**
	* Returns the location with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param locationId the primary key of the location
	* @return the location, or <code>null</code> if a location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Location fetchByPrimaryKey(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(locationId);
	}

	/**
	* Returns all the locations.
	*
	* @return the locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Location> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @return the range of locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Location> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Location> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the locations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of locations.
	*
	* @return the number of locations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LocationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LocationPersistence)PortletBeanLocatorUtil.locate(com.services.service.ClpSerializer.getServletContextName(),
					LocationPersistence.class.getName());

			ReferenceRegistry.registerReference(LocationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LocationPersistence persistence) {
	}

	private static LocationPersistence _persistence;
}