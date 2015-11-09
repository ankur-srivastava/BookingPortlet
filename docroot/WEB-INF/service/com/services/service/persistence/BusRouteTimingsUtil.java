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

import com.services.model.BusRouteTimings;

import java.util.List;

/**
 * The persistence utility for the bus route timings service. This utility wraps {@link BusRouteTimingsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusRouteTimingsPersistence
 * @see BusRouteTimingsPersistenceImpl
 * @generated
 */
public class BusRouteTimingsUtil {
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
	public static void clearCache(BusRouteTimings busRouteTimings) {
		getPersistence().clearCache(busRouteTimings);
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
	public static List<BusRouteTimings> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BusRouteTimings> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BusRouteTimings> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BusRouteTimings update(BusRouteTimings busRouteTimings)
		throws SystemException {
		return getPersistence().update(busRouteTimings);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BusRouteTimings update(BusRouteTimings busRouteTimings,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(busRouteTimings, serviceContext);
	}

	/**
	* Returns all the bus route timingses where brId = &#63;.
	*
	* @param brId the br ID
	* @return the matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusRouteTimings> findByBrId(
		long brId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBrId(brId);
	}

	/**
	* Returns a range of all the bus route timingses where brId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteTimingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param brId the br ID
	* @param start the lower bound of the range of bus route timingses
	* @param end the upper bound of the range of bus route timingses (not inclusive)
	* @return the range of matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusRouteTimings> findByBrId(
		long brId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBrId(brId, start, end);
	}

	/**
	* Returns an ordered range of all the bus route timingses where brId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteTimingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param brId the br ID
	* @param start the lower bound of the range of bus route timingses
	* @param end the upper bound of the range of bus route timingses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusRouteTimings> findByBrId(
		long brId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBrId(brId, start, end, orderByComparator);
	}

	/**
	* Returns the first bus route timings in the ordered set where brId = &#63;.
	*
	* @param brId the br ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route timings
	* @throws com.services.NoSuchBusRouteTimingsException if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings findByBrId_First(
		long brId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException {
		return getPersistence().findByBrId_First(brId, orderByComparator);
	}

	/**
	* Returns the first bus route timings in the ordered set where brId = &#63;.
	*
	* @param brId the br ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings fetchByBrId_First(
		long brId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBrId_First(brId, orderByComparator);
	}

	/**
	* Returns the last bus route timings in the ordered set where brId = &#63;.
	*
	* @param brId the br ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route timings
	* @throws com.services.NoSuchBusRouteTimingsException if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings findByBrId_Last(
		long brId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException {
		return getPersistence().findByBrId_Last(brId, orderByComparator);
	}

	/**
	* Returns the last bus route timings in the ordered set where brId = &#63;.
	*
	* @param brId the br ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings fetchByBrId_Last(
		long brId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBrId_Last(brId, orderByComparator);
	}

	/**
	* Returns the bus route timingses before and after the current bus route timings in the ordered set where brId = &#63;.
	*
	* @param brtId the primary key of the current bus route timings
	* @param brId the br ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bus route timings
	* @throws com.services.NoSuchBusRouteTimingsException if a bus route timings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings[] findByBrId_PrevAndNext(
		long brtId, long brId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException {
		return getPersistence()
				   .findByBrId_PrevAndNext(brtId, brId, orderByComparator);
	}

	/**
	* Removes all the bus route timingses where brId = &#63; from the database.
	*
	* @param brId the br ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBrId(long brId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBrId(brId);
	}

	/**
	* Returns the number of bus route timingses where brId = &#63;.
	*
	* @param brId the br ID
	* @return the number of matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBrId(long brId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBrId(brId);
	}

	/**
	* Returns all the bus route timingses where active = &#63;.
	*
	* @param active the active
	* @return the matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusRouteTimings> findByActive(
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByActive(active);
	}

	/**
	* Returns a range of all the bus route timingses where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteTimingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of bus route timingses
	* @param end the upper bound of the range of bus route timingses (not inclusive)
	* @return the range of matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusRouteTimings> findByActive(
		boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByActive(active, start, end);
	}

	/**
	* Returns an ordered range of all the bus route timingses where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteTimingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of bus route timingses
	* @param end the upper bound of the range of bus route timingses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusRouteTimings> findByActive(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActive(active, start, end, orderByComparator);
	}

	/**
	* Returns the first bus route timings in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route timings
	* @throws com.services.NoSuchBusRouteTimingsException if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings findByActive_First(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException {
		return getPersistence().findByActive_First(active, orderByComparator);
	}

	/**
	* Returns the first bus route timings in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings fetchByActive_First(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByActive_First(active, orderByComparator);
	}

	/**
	* Returns the last bus route timings in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route timings
	* @throws com.services.NoSuchBusRouteTimingsException if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings findByActive_Last(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException {
		return getPersistence().findByActive_Last(active, orderByComparator);
	}

	/**
	* Returns the last bus route timings in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings fetchByActive_Last(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByActive_Last(active, orderByComparator);
	}

	/**
	* Returns the bus route timingses before and after the current bus route timings in the ordered set where active = &#63;.
	*
	* @param brtId the primary key of the current bus route timings
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bus route timings
	* @throws com.services.NoSuchBusRouteTimingsException if a bus route timings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings[] findByActive_PrevAndNext(
		long brtId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException {
		return getPersistence()
				   .findByActive_PrevAndNext(brtId, active, orderByComparator);
	}

	/**
	* Removes all the bus route timingses where active = &#63; from the database.
	*
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByActive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByActive(active);
	}

	/**
	* Returns the number of bus route timingses where active = &#63;.
	*
	* @param active the active
	* @return the number of matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByActive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByActive(active);
	}

	/**
	* Returns all the bus route timingses where travelDate = &#63;.
	*
	* @param travelDate the travel date
	* @return the matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusRouteTimings> findByTravelDate(
		java.lang.String travelDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTravelDate(travelDate);
	}

	/**
	* Returns a range of all the bus route timingses where travelDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteTimingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param travelDate the travel date
	* @param start the lower bound of the range of bus route timingses
	* @param end the upper bound of the range of bus route timingses (not inclusive)
	* @return the range of matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusRouteTimings> findByTravelDate(
		java.lang.String travelDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTravelDate(travelDate, start, end);
	}

	/**
	* Returns an ordered range of all the bus route timingses where travelDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteTimingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param travelDate the travel date
	* @param start the lower bound of the range of bus route timingses
	* @param end the upper bound of the range of bus route timingses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusRouteTimings> findByTravelDate(
		java.lang.String travelDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTravelDate(travelDate, start, end, orderByComparator);
	}

	/**
	* Returns the first bus route timings in the ordered set where travelDate = &#63;.
	*
	* @param travelDate the travel date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route timings
	* @throws com.services.NoSuchBusRouteTimingsException if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings findByTravelDate_First(
		java.lang.String travelDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException {
		return getPersistence()
				   .findByTravelDate_First(travelDate, orderByComparator);
	}

	/**
	* Returns the first bus route timings in the ordered set where travelDate = &#63;.
	*
	* @param travelDate the travel date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings fetchByTravelDate_First(
		java.lang.String travelDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTravelDate_First(travelDate, orderByComparator);
	}

	/**
	* Returns the last bus route timings in the ordered set where travelDate = &#63;.
	*
	* @param travelDate the travel date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route timings
	* @throws com.services.NoSuchBusRouteTimingsException if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings findByTravelDate_Last(
		java.lang.String travelDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException {
		return getPersistence()
				   .findByTravelDate_Last(travelDate, orderByComparator);
	}

	/**
	* Returns the last bus route timings in the ordered set where travelDate = &#63;.
	*
	* @param travelDate the travel date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings fetchByTravelDate_Last(
		java.lang.String travelDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTravelDate_Last(travelDate, orderByComparator);
	}

	/**
	* Returns the bus route timingses before and after the current bus route timings in the ordered set where travelDate = &#63;.
	*
	* @param brtId the primary key of the current bus route timings
	* @param travelDate the travel date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bus route timings
	* @throws com.services.NoSuchBusRouteTimingsException if a bus route timings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings[] findByTravelDate_PrevAndNext(
		long brtId, java.lang.String travelDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException {
		return getPersistence()
				   .findByTravelDate_PrevAndNext(brtId, travelDate,
			orderByComparator);
	}

	/**
	* Removes all the bus route timingses where travelDate = &#63; from the database.
	*
	* @param travelDate the travel date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTravelDate(java.lang.String travelDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTravelDate(travelDate);
	}

	/**
	* Returns the number of bus route timingses where travelDate = &#63;.
	*
	* @param travelDate the travel date
	* @return the number of matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTravelDate(java.lang.String travelDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTravelDate(travelDate);
	}

	/**
	* Returns all the bus route timingses where brId = &#63; and travelDate = &#63;.
	*
	* @param brId the br ID
	* @param travelDate the travel date
	* @return the matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusRouteTimings> findByBrIdAndTravelDate(
		long brId, java.lang.String travelDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBrIdAndTravelDate(brId, travelDate);
	}

	/**
	* Returns a range of all the bus route timingses where brId = &#63; and travelDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteTimingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param brId the br ID
	* @param travelDate the travel date
	* @param start the lower bound of the range of bus route timingses
	* @param end the upper bound of the range of bus route timingses (not inclusive)
	* @return the range of matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusRouteTimings> findByBrIdAndTravelDate(
		long brId, java.lang.String travelDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBrIdAndTravelDate(brId, travelDate, start, end);
	}

	/**
	* Returns an ordered range of all the bus route timingses where brId = &#63; and travelDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteTimingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param brId the br ID
	* @param travelDate the travel date
	* @param start the lower bound of the range of bus route timingses
	* @param end the upper bound of the range of bus route timingses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusRouteTimings> findByBrIdAndTravelDate(
		long brId, java.lang.String travelDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBrIdAndTravelDate(brId, travelDate, start, end,
			orderByComparator);
	}

	/**
	* Returns the first bus route timings in the ordered set where brId = &#63; and travelDate = &#63;.
	*
	* @param brId the br ID
	* @param travelDate the travel date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route timings
	* @throws com.services.NoSuchBusRouteTimingsException if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings findByBrIdAndTravelDate_First(
		long brId, java.lang.String travelDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException {
		return getPersistence()
				   .findByBrIdAndTravelDate_First(brId, travelDate,
			orderByComparator);
	}

	/**
	* Returns the first bus route timings in the ordered set where brId = &#63; and travelDate = &#63;.
	*
	* @param brId the br ID
	* @param travelDate the travel date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings fetchByBrIdAndTravelDate_First(
		long brId, java.lang.String travelDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBrIdAndTravelDate_First(brId, travelDate,
			orderByComparator);
	}

	/**
	* Returns the last bus route timings in the ordered set where brId = &#63; and travelDate = &#63;.
	*
	* @param brId the br ID
	* @param travelDate the travel date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route timings
	* @throws com.services.NoSuchBusRouteTimingsException if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings findByBrIdAndTravelDate_Last(
		long brId, java.lang.String travelDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException {
		return getPersistence()
				   .findByBrIdAndTravelDate_Last(brId, travelDate,
			orderByComparator);
	}

	/**
	* Returns the last bus route timings in the ordered set where brId = &#63; and travelDate = &#63;.
	*
	* @param brId the br ID
	* @param travelDate the travel date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings fetchByBrIdAndTravelDate_Last(
		long brId, java.lang.String travelDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBrIdAndTravelDate_Last(brId, travelDate,
			orderByComparator);
	}

	/**
	* Returns the bus route timingses before and after the current bus route timings in the ordered set where brId = &#63; and travelDate = &#63;.
	*
	* @param brtId the primary key of the current bus route timings
	* @param brId the br ID
	* @param travelDate the travel date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bus route timings
	* @throws com.services.NoSuchBusRouteTimingsException if a bus route timings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings[] findByBrIdAndTravelDate_PrevAndNext(
		long brtId, long brId, java.lang.String travelDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException {
		return getPersistence()
				   .findByBrIdAndTravelDate_PrevAndNext(brtId, brId,
			travelDate, orderByComparator);
	}

	/**
	* Removes all the bus route timingses where brId = &#63; and travelDate = &#63; from the database.
	*
	* @param brId the br ID
	* @param travelDate the travel date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBrIdAndTravelDate(long brId,
		java.lang.String travelDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBrIdAndTravelDate(brId, travelDate);
	}

	/**
	* Returns the number of bus route timingses where brId = &#63; and travelDate = &#63;.
	*
	* @param brId the br ID
	* @param travelDate the travel date
	* @return the number of matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBrIdAndTravelDate(long brId,
		java.lang.String travelDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBrIdAndTravelDate(brId, travelDate);
	}

	/**
	* Caches the bus route timings in the entity cache if it is enabled.
	*
	* @param busRouteTimings the bus route timings
	*/
	public static void cacheResult(
		com.services.model.BusRouteTimings busRouteTimings) {
		getPersistence().cacheResult(busRouteTimings);
	}

	/**
	* Caches the bus route timingses in the entity cache if it is enabled.
	*
	* @param busRouteTimingses the bus route timingses
	*/
	public static void cacheResult(
		java.util.List<com.services.model.BusRouteTimings> busRouteTimingses) {
		getPersistence().cacheResult(busRouteTimingses);
	}

	/**
	* Creates a new bus route timings with the primary key. Does not add the bus route timings to the database.
	*
	* @param brtId the primary key for the new bus route timings
	* @return the new bus route timings
	*/
	public static com.services.model.BusRouteTimings create(long brtId) {
		return getPersistence().create(brtId);
	}

	/**
	* Removes the bus route timings with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param brtId the primary key of the bus route timings
	* @return the bus route timings that was removed
	* @throws com.services.NoSuchBusRouteTimingsException if a bus route timings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings remove(long brtId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException {
		return getPersistence().remove(brtId);
	}

	public static com.services.model.BusRouteTimings updateImpl(
		com.services.model.BusRouteTimings busRouteTimings)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(busRouteTimings);
	}

	/**
	* Returns the bus route timings with the primary key or throws a {@link com.services.NoSuchBusRouteTimingsException} if it could not be found.
	*
	* @param brtId the primary key of the bus route timings
	* @return the bus route timings
	* @throws com.services.NoSuchBusRouteTimingsException if a bus route timings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings findByPrimaryKey(
		long brtId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException {
		return getPersistence().findByPrimaryKey(brtId);
	}

	/**
	* Returns the bus route timings with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param brtId the primary key of the bus route timings
	* @return the bus route timings, or <code>null</code> if a bus route timings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusRouteTimings fetchByPrimaryKey(
		long brtId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(brtId);
	}

	/**
	* Returns all the bus route timingses.
	*
	* @return the bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusRouteTimings> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the bus route timingses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteTimingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bus route timingses
	* @param end the upper bound of the range of bus route timingses (not inclusive)
	* @return the range of bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusRouteTimings> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the bus route timingses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteTimingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bus route timingses
	* @param end the upper bound of the range of bus route timingses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusRouteTimings> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the bus route timingses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bus route timingses.
	*
	* @return the number of bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BusRouteTimingsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BusRouteTimingsPersistence)PortletBeanLocatorUtil.locate(com.services.service.ClpSerializer.getServletContextName(),
					BusRouteTimingsPersistence.class.getName());

			ReferenceRegistry.registerReference(BusRouteTimingsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BusRouteTimingsPersistence persistence) {
	}

	private static BusRouteTimingsPersistence _persistence;
}