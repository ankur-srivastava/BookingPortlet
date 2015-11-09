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

import com.liferay.portal.service.persistence.BasePersistence;

import com.services.model.BusRouteTimings;

/**
 * The persistence interface for the bus route timings service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusRouteTimingsPersistenceImpl
 * @see BusRouteTimingsUtil
 * @generated
 */
public interface BusRouteTimingsPersistence extends BasePersistence<BusRouteTimings> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BusRouteTimingsUtil} to access the bus route timings persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the bus route timingses where brId = &#63;.
	*
	* @param brId the br ID
	* @return the matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRouteTimings> findByBrId(
		long brId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.BusRouteTimings> findByBrId(
		long brId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.BusRouteTimings> findByBrId(
		long brId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bus route timings in the ordered set where brId = &#63;.
	*
	* @param brId the br ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route timings
	* @throws com.services.NoSuchBusRouteTimingsException if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRouteTimings findByBrId_First(long brId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException;

	/**
	* Returns the first bus route timings in the ordered set where brId = &#63;.
	*
	* @param brId the br ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRouteTimings fetchByBrId_First(long brId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bus route timings in the ordered set where brId = &#63;.
	*
	* @param brId the br ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route timings
	* @throws com.services.NoSuchBusRouteTimingsException if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRouteTimings findByBrId_Last(long brId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException;

	/**
	* Returns the last bus route timings in the ordered set where brId = &#63;.
	*
	* @param brId the br ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRouteTimings fetchByBrId_Last(long brId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.services.model.BusRouteTimings[] findByBrId_PrevAndNext(
		long brtId, long brId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException;

	/**
	* Removes all the bus route timingses where brId = &#63; from the database.
	*
	* @param brId the br ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBrId(long brId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bus route timingses where brId = &#63;.
	*
	* @param brId the br ID
	* @return the number of matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public int countByBrId(long brId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bus route timingses where active = &#63;.
	*
	* @param active the active
	* @return the matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRouteTimings> findByActive(
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.BusRouteTimings> findByActive(
		boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.BusRouteTimings> findByActive(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bus route timings in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route timings
	* @throws com.services.NoSuchBusRouteTimingsException if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRouteTimings findByActive_First(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException;

	/**
	* Returns the first bus route timings in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRouteTimings fetchByActive_First(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bus route timings in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route timings
	* @throws com.services.NoSuchBusRouteTimingsException if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRouteTimings findByActive_Last(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException;

	/**
	* Returns the last bus route timings in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRouteTimings fetchByActive_Last(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.services.model.BusRouteTimings[] findByActive_PrevAndNext(
		long brtId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException;

	/**
	* Removes all the bus route timingses where active = &#63; from the database.
	*
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public void removeByActive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bus route timingses where active = &#63;.
	*
	* @param active the active
	* @return the number of matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public int countByActive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bus route timingses where travelDate = &#63;.
	*
	* @param travelDate the travel date
	* @return the matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRouteTimings> findByTravelDate(
		java.lang.String travelDate)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.BusRouteTimings> findByTravelDate(
		java.lang.String travelDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.BusRouteTimings> findByTravelDate(
		java.lang.String travelDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bus route timings in the ordered set where travelDate = &#63;.
	*
	* @param travelDate the travel date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route timings
	* @throws com.services.NoSuchBusRouteTimingsException if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRouteTimings findByTravelDate_First(
		java.lang.String travelDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException;

	/**
	* Returns the first bus route timings in the ordered set where travelDate = &#63;.
	*
	* @param travelDate the travel date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRouteTimings fetchByTravelDate_First(
		java.lang.String travelDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bus route timings in the ordered set where travelDate = &#63;.
	*
	* @param travelDate the travel date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route timings
	* @throws com.services.NoSuchBusRouteTimingsException if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRouteTimings findByTravelDate_Last(
		java.lang.String travelDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException;

	/**
	* Returns the last bus route timings in the ordered set where travelDate = &#63;.
	*
	* @param travelDate the travel date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRouteTimings fetchByTravelDate_Last(
		java.lang.String travelDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.services.model.BusRouteTimings[] findByTravelDate_PrevAndNext(
		long brtId, java.lang.String travelDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException;

	/**
	* Removes all the bus route timingses where travelDate = &#63; from the database.
	*
	* @param travelDate the travel date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTravelDate(java.lang.String travelDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bus route timingses where travelDate = &#63;.
	*
	* @param travelDate the travel date
	* @return the number of matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public int countByTravelDate(java.lang.String travelDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bus route timingses where brId = &#63; and travelDate = &#63;.
	*
	* @param brId the br ID
	* @param travelDate the travel date
	* @return the matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRouteTimings> findByBrIdAndTravelDate(
		long brId, java.lang.String travelDate)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.BusRouteTimings> findByBrIdAndTravelDate(
		long brId, java.lang.String travelDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.BusRouteTimings> findByBrIdAndTravelDate(
		long brId, java.lang.String travelDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.services.model.BusRouteTimings findByBrIdAndTravelDate_First(
		long brId, java.lang.String travelDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException;

	/**
	* Returns the first bus route timings in the ordered set where brId = &#63; and travelDate = &#63;.
	*
	* @param brId the br ID
	* @param travelDate the travel date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRouteTimings fetchByBrIdAndTravelDate_First(
		long brId, java.lang.String travelDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.services.model.BusRouteTimings findByBrIdAndTravelDate_Last(
		long brId, java.lang.String travelDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException;

	/**
	* Returns the last bus route timings in the ordered set where brId = &#63; and travelDate = &#63;.
	*
	* @param brId the br ID
	* @param travelDate the travel date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRouteTimings fetchByBrIdAndTravelDate_Last(
		long brId, java.lang.String travelDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.services.model.BusRouteTimings[] findByBrIdAndTravelDate_PrevAndNext(
		long brtId, long brId, java.lang.String travelDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException;

	/**
	* Removes all the bus route timingses where brId = &#63; and travelDate = &#63; from the database.
	*
	* @param brId the br ID
	* @param travelDate the travel date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBrIdAndTravelDate(long brId, java.lang.String travelDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bus route timingses where brId = &#63; and travelDate = &#63;.
	*
	* @param brId the br ID
	* @param travelDate the travel date
	* @return the number of matching bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public int countByBrIdAndTravelDate(long brId, java.lang.String travelDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bus route timings in the entity cache if it is enabled.
	*
	* @param busRouteTimings the bus route timings
	*/
	public void cacheResult(com.services.model.BusRouteTimings busRouteTimings);

	/**
	* Caches the bus route timingses in the entity cache if it is enabled.
	*
	* @param busRouteTimingses the bus route timingses
	*/
	public void cacheResult(
		java.util.List<com.services.model.BusRouteTimings> busRouteTimingses);

	/**
	* Creates a new bus route timings with the primary key. Does not add the bus route timings to the database.
	*
	* @param brtId the primary key for the new bus route timings
	* @return the new bus route timings
	*/
	public com.services.model.BusRouteTimings create(long brtId);

	/**
	* Removes the bus route timings with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param brtId the primary key of the bus route timings
	* @return the bus route timings that was removed
	* @throws com.services.NoSuchBusRouteTimingsException if a bus route timings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRouteTimings remove(long brtId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException;

	public com.services.model.BusRouteTimings updateImpl(
		com.services.model.BusRouteTimings busRouteTimings)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bus route timings with the primary key or throws a {@link com.services.NoSuchBusRouteTimingsException} if it could not be found.
	*
	* @param brtId the primary key of the bus route timings
	* @return the bus route timings
	* @throws com.services.NoSuchBusRouteTimingsException if a bus route timings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRouteTimings findByPrimaryKey(long brtId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteTimingsException;

	/**
	* Returns the bus route timings with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param brtId the primary key of the bus route timings
	* @return the bus route timings, or <code>null</code> if a bus route timings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRouteTimings fetchByPrimaryKey(long brtId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bus route timingses.
	*
	* @return the bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRouteTimings> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.BusRouteTimings> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.BusRouteTimings> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bus route timingses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bus route timingses.
	*
	* @return the number of bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}