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

import com.services.model.Bus;

import java.util.List;

/**
 * The persistence utility for the bus service. This utility wraps {@link BusPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusPersistence
 * @see BusPersistenceImpl
 * @generated
 */
public class BusUtil {
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
	public static void clearCache(Bus bus) {
		getPersistence().clearCache(bus);
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
	public static List<Bus> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Bus> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Bus> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Bus update(Bus bus) throws SystemException {
		return getPersistence().update(bus);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Bus update(Bus bus, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(bus, serviceContext);
	}

	/**
	* Returns all the buses where active = &#63;.
	*
	* @param active the active
	* @return the matching buses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Bus> findByActive(
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByActive(active);
	}

	/**
	* Returns a range of all the buses where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of buses
	* @param end the upper bound of the range of buses (not inclusive)
	* @return the range of matching buses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Bus> findByActive(
		boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByActive(active, start, end);
	}

	/**
	* Returns an ordered range of all the buses where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of buses
	* @param end the upper bound of the range of buses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching buses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Bus> findByActive(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActive(active, start, end, orderByComparator);
	}

	/**
	* Returns the first bus in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus
	* @throws com.services.NoSuchBusException if a matching bus could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Bus findByActive_First(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusException {
		return getPersistence().findByActive_First(active, orderByComparator);
	}

	/**
	* Returns the first bus in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus, or <code>null</code> if a matching bus could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Bus fetchByActive_First(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByActive_First(active, orderByComparator);
	}

	/**
	* Returns the last bus in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus
	* @throws com.services.NoSuchBusException if a matching bus could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Bus findByActive_Last(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusException {
		return getPersistence().findByActive_Last(active, orderByComparator);
	}

	/**
	* Returns the last bus in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus, or <code>null</code> if a matching bus could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Bus fetchByActive_Last(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByActive_Last(active, orderByComparator);
	}

	/**
	* Returns the buses before and after the current bus in the ordered set where active = &#63;.
	*
	* @param busId the primary key of the current bus
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bus
	* @throws com.services.NoSuchBusException if a bus with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Bus[] findByActive_PrevAndNext(
		long busId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusException {
		return getPersistence()
				   .findByActive_PrevAndNext(busId, active, orderByComparator);
	}

	/**
	* Removes all the buses where active = &#63; from the database.
	*
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByActive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByActive(active);
	}

	/**
	* Returns the number of buses where active = &#63;.
	*
	* @param active the active
	* @return the number of matching buses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByActive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByActive(active);
	}

	/**
	* Caches the bus in the entity cache if it is enabled.
	*
	* @param bus the bus
	*/
	public static void cacheResult(com.services.model.Bus bus) {
		getPersistence().cacheResult(bus);
	}

	/**
	* Caches the buses in the entity cache if it is enabled.
	*
	* @param buses the buses
	*/
	public static void cacheResult(java.util.List<com.services.model.Bus> buses) {
		getPersistence().cacheResult(buses);
	}

	/**
	* Creates a new bus with the primary key. Does not add the bus to the database.
	*
	* @param busId the primary key for the new bus
	* @return the new bus
	*/
	public static com.services.model.Bus create(long busId) {
		return getPersistence().create(busId);
	}

	/**
	* Removes the bus with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param busId the primary key of the bus
	* @return the bus that was removed
	* @throws com.services.NoSuchBusException if a bus with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Bus remove(long busId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusException {
		return getPersistence().remove(busId);
	}

	public static com.services.model.Bus updateImpl(com.services.model.Bus bus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(bus);
	}

	/**
	* Returns the bus with the primary key or throws a {@link com.services.NoSuchBusException} if it could not be found.
	*
	* @param busId the primary key of the bus
	* @return the bus
	* @throws com.services.NoSuchBusException if a bus with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Bus findByPrimaryKey(long busId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusException {
		return getPersistence().findByPrimaryKey(busId);
	}

	/**
	* Returns the bus with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param busId the primary key of the bus
	* @return the bus, or <code>null</code> if a bus with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Bus fetchByPrimaryKey(long busId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(busId);
	}

	/**
	* Returns all the buses.
	*
	* @return the buses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Bus> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the buses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of buses
	* @param end the upper bound of the range of buses (not inclusive)
	* @return the range of buses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Bus> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the buses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of buses
	* @param end the upper bound of the range of buses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of buses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Bus> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the buses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of buses.
	*
	* @return the number of buses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BusPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BusPersistence)PortletBeanLocatorUtil.locate(com.services.service.ClpSerializer.getServletContextName(),
					BusPersistence.class.getName());

			ReferenceRegistry.registerReference(BusUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BusPersistence persistence) {
	}

	private static BusPersistence _persistence;
}