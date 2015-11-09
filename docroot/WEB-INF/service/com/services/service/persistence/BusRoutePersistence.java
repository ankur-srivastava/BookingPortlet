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

import com.services.model.BusRoute;

/**
 * The persistence interface for the bus route service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusRoutePersistenceImpl
 * @see BusRouteUtil
 * @generated
 */
public interface BusRoutePersistence extends BasePersistence<BusRoute> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BusRouteUtil} to access the bus route persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the bus routes where busId = &#63;.
	*
	* @param busId the bus ID
	* @return the matching bus routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRoute> findByBusId(long busId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bus routes where busId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param busId the bus ID
	* @param start the lower bound of the range of bus routes
	* @param end the upper bound of the range of bus routes (not inclusive)
	* @return the range of matching bus routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRoute> findByBusId(long busId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bus routes where busId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param busId the bus ID
	* @param start the lower bound of the range of bus routes
	* @param end the upper bound of the range of bus routes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bus routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRoute> findByBusId(long busId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bus route in the ordered set where busId = &#63;.
	*
	* @param busId the bus ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route
	* @throws com.services.NoSuchBusRouteException if a matching bus route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute findByBusId_First(long busId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteException;

	/**
	* Returns the first bus route in the ordered set where busId = &#63;.
	*
	* @param busId the bus ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route, or <code>null</code> if a matching bus route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute fetchByBusId_First(long busId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bus route in the ordered set where busId = &#63;.
	*
	* @param busId the bus ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route
	* @throws com.services.NoSuchBusRouteException if a matching bus route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute findByBusId_Last(long busId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteException;

	/**
	* Returns the last bus route in the ordered set where busId = &#63;.
	*
	* @param busId the bus ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route, or <code>null</code> if a matching bus route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute fetchByBusId_Last(long busId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bus routes before and after the current bus route in the ordered set where busId = &#63;.
	*
	* @param brId the primary key of the current bus route
	* @param busId the bus ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bus route
	* @throws com.services.NoSuchBusRouteException if a bus route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute[] findByBusId_PrevAndNext(long brId,
		long busId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteException;

	/**
	* Removes all the bus routes where busId = &#63; from the database.
	*
	* @param busId the bus ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBusId(long busId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bus routes where busId = &#63;.
	*
	* @param busId the bus ID
	* @return the number of matching bus routes
	* @throws SystemException if a system exception occurred
	*/
	public int countByBusId(long busId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bus routes where startLocation = &#63;.
	*
	* @param startLocation the start location
	* @return the matching bus routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRoute> findByStartLocation(
		long startLocation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bus routes where startLocation = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startLocation the start location
	* @param start the lower bound of the range of bus routes
	* @param end the upper bound of the range of bus routes (not inclusive)
	* @return the range of matching bus routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRoute> findByStartLocation(
		long startLocation, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bus routes where startLocation = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startLocation the start location
	* @param start the lower bound of the range of bus routes
	* @param end the upper bound of the range of bus routes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bus routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRoute> findByStartLocation(
		long startLocation, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bus route in the ordered set where startLocation = &#63;.
	*
	* @param startLocation the start location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route
	* @throws com.services.NoSuchBusRouteException if a matching bus route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute findByStartLocation_First(
		long startLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteException;

	/**
	* Returns the first bus route in the ordered set where startLocation = &#63;.
	*
	* @param startLocation the start location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route, or <code>null</code> if a matching bus route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute fetchByStartLocation_First(
		long startLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bus route in the ordered set where startLocation = &#63;.
	*
	* @param startLocation the start location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route
	* @throws com.services.NoSuchBusRouteException if a matching bus route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute findByStartLocation_Last(
		long startLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteException;

	/**
	* Returns the last bus route in the ordered set where startLocation = &#63;.
	*
	* @param startLocation the start location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route, or <code>null</code> if a matching bus route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute fetchByStartLocation_Last(
		long startLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bus routes before and after the current bus route in the ordered set where startLocation = &#63;.
	*
	* @param brId the primary key of the current bus route
	* @param startLocation the start location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bus route
	* @throws com.services.NoSuchBusRouteException if a bus route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute[] findByStartLocation_PrevAndNext(
		long brId, long startLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteException;

	/**
	* Removes all the bus routes where startLocation = &#63; from the database.
	*
	* @param startLocation the start location
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStartLocation(long startLocation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bus routes where startLocation = &#63;.
	*
	* @param startLocation the start location
	* @return the number of matching bus routes
	* @throws SystemException if a system exception occurred
	*/
	public int countByStartLocation(long startLocation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bus routes where endLocation = &#63;.
	*
	* @param endLocation the end location
	* @return the matching bus routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRoute> findByEndLocation(
		long endLocation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bus routes where endLocation = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param endLocation the end location
	* @param start the lower bound of the range of bus routes
	* @param end the upper bound of the range of bus routes (not inclusive)
	* @return the range of matching bus routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRoute> findByEndLocation(
		long endLocation, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bus routes where endLocation = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param endLocation the end location
	* @param start the lower bound of the range of bus routes
	* @param end the upper bound of the range of bus routes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bus routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRoute> findByEndLocation(
		long endLocation, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bus route in the ordered set where endLocation = &#63;.
	*
	* @param endLocation the end location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route
	* @throws com.services.NoSuchBusRouteException if a matching bus route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute findByEndLocation_First(
		long endLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteException;

	/**
	* Returns the first bus route in the ordered set where endLocation = &#63;.
	*
	* @param endLocation the end location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route, or <code>null</code> if a matching bus route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute fetchByEndLocation_First(
		long endLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bus route in the ordered set where endLocation = &#63;.
	*
	* @param endLocation the end location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route
	* @throws com.services.NoSuchBusRouteException if a matching bus route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute findByEndLocation_Last(
		long endLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteException;

	/**
	* Returns the last bus route in the ordered set where endLocation = &#63;.
	*
	* @param endLocation the end location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route, or <code>null</code> if a matching bus route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute fetchByEndLocation_Last(
		long endLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bus routes before and after the current bus route in the ordered set where endLocation = &#63;.
	*
	* @param brId the primary key of the current bus route
	* @param endLocation the end location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bus route
	* @throws com.services.NoSuchBusRouteException if a bus route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute[] findByEndLocation_PrevAndNext(
		long brId, long endLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteException;

	/**
	* Removes all the bus routes where endLocation = &#63; from the database.
	*
	* @param endLocation the end location
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEndLocation(long endLocation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bus routes where endLocation = &#63;.
	*
	* @param endLocation the end location
	* @return the number of matching bus routes
	* @throws SystemException if a system exception occurred
	*/
	public int countByEndLocation(long endLocation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bus routes where startLocation = &#63; and endLocation = &#63;.
	*
	* @param startLocation the start location
	* @param endLocation the end location
	* @return the matching bus routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRoute> findByStartAndEndLocation(
		long startLocation, long endLocation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bus routes where startLocation = &#63; and endLocation = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startLocation the start location
	* @param endLocation the end location
	* @param start the lower bound of the range of bus routes
	* @param end the upper bound of the range of bus routes (not inclusive)
	* @return the range of matching bus routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRoute> findByStartAndEndLocation(
		long startLocation, long endLocation, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bus routes where startLocation = &#63; and endLocation = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startLocation the start location
	* @param endLocation the end location
	* @param start the lower bound of the range of bus routes
	* @param end the upper bound of the range of bus routes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bus routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRoute> findByStartAndEndLocation(
		long startLocation, long endLocation, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bus route in the ordered set where startLocation = &#63; and endLocation = &#63;.
	*
	* @param startLocation the start location
	* @param endLocation the end location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route
	* @throws com.services.NoSuchBusRouteException if a matching bus route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute findByStartAndEndLocation_First(
		long startLocation, long endLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteException;

	/**
	* Returns the first bus route in the ordered set where startLocation = &#63; and endLocation = &#63;.
	*
	* @param startLocation the start location
	* @param endLocation the end location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route, or <code>null</code> if a matching bus route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute fetchByStartAndEndLocation_First(
		long startLocation, long endLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bus route in the ordered set where startLocation = &#63; and endLocation = &#63;.
	*
	* @param startLocation the start location
	* @param endLocation the end location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route
	* @throws com.services.NoSuchBusRouteException if a matching bus route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute findByStartAndEndLocation_Last(
		long startLocation, long endLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteException;

	/**
	* Returns the last bus route in the ordered set where startLocation = &#63; and endLocation = &#63;.
	*
	* @param startLocation the start location
	* @param endLocation the end location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route, or <code>null</code> if a matching bus route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute fetchByStartAndEndLocation_Last(
		long startLocation, long endLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bus routes before and after the current bus route in the ordered set where startLocation = &#63; and endLocation = &#63;.
	*
	* @param brId the primary key of the current bus route
	* @param startLocation the start location
	* @param endLocation the end location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bus route
	* @throws com.services.NoSuchBusRouteException if a bus route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute[] findByStartAndEndLocation_PrevAndNext(
		long brId, long startLocation, long endLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteException;

	/**
	* Removes all the bus routes where startLocation = &#63; and endLocation = &#63; from the database.
	*
	* @param startLocation the start location
	* @param endLocation the end location
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStartAndEndLocation(long startLocation, long endLocation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bus routes where startLocation = &#63; and endLocation = &#63;.
	*
	* @param startLocation the start location
	* @param endLocation the end location
	* @return the number of matching bus routes
	* @throws SystemException if a system exception occurred
	*/
	public int countByStartAndEndLocation(long startLocation, long endLocation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bus routes where active = &#63;.
	*
	* @param active the active
	* @return the matching bus routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRoute> findByActive(
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bus routes where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of bus routes
	* @param end the upper bound of the range of bus routes (not inclusive)
	* @return the range of matching bus routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRoute> findByActive(
		boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bus routes where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of bus routes
	* @param end the upper bound of the range of bus routes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bus routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRoute> findByActive(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bus route in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route
	* @throws com.services.NoSuchBusRouteException if a matching bus route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute findByActive_First(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteException;

	/**
	* Returns the first bus route in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus route, or <code>null</code> if a matching bus route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute fetchByActive_First(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bus route in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route
	* @throws com.services.NoSuchBusRouteException if a matching bus route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute findByActive_Last(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteException;

	/**
	* Returns the last bus route in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus route, or <code>null</code> if a matching bus route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute fetchByActive_Last(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bus routes before and after the current bus route in the ordered set where active = &#63;.
	*
	* @param brId the primary key of the current bus route
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bus route
	* @throws com.services.NoSuchBusRouteException if a bus route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute[] findByActive_PrevAndNext(long brId,
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteException;

	/**
	* Removes all the bus routes where active = &#63; from the database.
	*
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public void removeByActive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bus routes where active = &#63;.
	*
	* @param active the active
	* @return the number of matching bus routes
	* @throws SystemException if a system exception occurred
	*/
	public int countByActive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bus route in the entity cache if it is enabled.
	*
	* @param busRoute the bus route
	*/
	public void cacheResult(com.services.model.BusRoute busRoute);

	/**
	* Caches the bus routes in the entity cache if it is enabled.
	*
	* @param busRoutes the bus routes
	*/
	public void cacheResult(
		java.util.List<com.services.model.BusRoute> busRoutes);

	/**
	* Creates a new bus route with the primary key. Does not add the bus route to the database.
	*
	* @param brId the primary key for the new bus route
	* @return the new bus route
	*/
	public com.services.model.BusRoute create(long brId);

	/**
	* Removes the bus route with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param brId the primary key of the bus route
	* @return the bus route that was removed
	* @throws com.services.NoSuchBusRouteException if a bus route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute remove(long brId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteException;

	public com.services.model.BusRoute updateImpl(
		com.services.model.BusRoute busRoute)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bus route with the primary key or throws a {@link com.services.NoSuchBusRouteException} if it could not be found.
	*
	* @param brId the primary key of the bus route
	* @return the bus route
	* @throws com.services.NoSuchBusRouteException if a bus route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute findByPrimaryKey(long brId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusRouteException;

	/**
	* Returns the bus route with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param brId the primary key of the bus route
	* @return the bus route, or <code>null</code> if a bus route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusRoute fetchByPrimaryKey(long brId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bus routes.
	*
	* @return the bus routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRoute> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bus routes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bus routes
	* @param end the upper bound of the range of bus routes (not inclusive)
	* @return the range of bus routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRoute> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bus routes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bus routes
	* @param end the upper bound of the range of bus routes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bus routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusRoute> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bus routes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bus routes.
	*
	* @return the number of bus routes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}