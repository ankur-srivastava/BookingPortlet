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

package com.services.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.services.model.BusAvailability;

import java.util.List;

/**
 * The persistence utility for the bus availability service. This utility wraps {@link BusAvailabilityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusAvailabilityPersistence
 * @see BusAvailabilityPersistenceImpl
 * @generated
 */
public class BusAvailabilityUtil {
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
	public static void clearCache(BusAvailability busAvailability) {
		getPersistence().clearCache(busAvailability);
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
	public static List<BusAvailability> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BusAvailability> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BusAvailability> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BusAvailability update(BusAvailability busAvailability)
		throws SystemException {
		return getPersistence().update(busAvailability);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BusAvailability update(BusAvailability busAvailability,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(busAvailability, serviceContext);
	}

	/**
	* Returns all the bus availabilities where brtId = &#63;.
	*
	* @param brtId the brt ID
	* @return the matching bus availabilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusAvailability> findByBrtId(
		long brtId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBrtId(brtId);
	}

	/**
	* Returns a range of all the bus availabilities where brtId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusAvailabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param brtId the brt ID
	* @param start the lower bound of the range of bus availabilities
	* @param end the upper bound of the range of bus availabilities (not inclusive)
	* @return the range of matching bus availabilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusAvailability> findByBrtId(
		long brtId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBrtId(brtId, start, end);
	}

	/**
	* Returns an ordered range of all the bus availabilities where brtId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusAvailabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param brtId the brt ID
	* @param start the lower bound of the range of bus availabilities
	* @param end the upper bound of the range of bus availabilities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bus availabilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusAvailability> findByBrtId(
		long brtId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBrtId(brtId, start, end, orderByComparator);
	}

	/**
	* Returns the first bus availability in the ordered set where brtId = &#63;.
	*
	* @param brtId the brt ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus availability
	* @throws com.services.NoSuchBusAvailabilityException if a matching bus availability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusAvailability findByBrtId_First(
		long brtId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusAvailabilityException {
		return getPersistence().findByBrtId_First(brtId, orderByComparator);
	}

	/**
	* Returns the first bus availability in the ordered set where brtId = &#63;.
	*
	* @param brtId the brt ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus availability, or <code>null</code> if a matching bus availability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusAvailability fetchByBrtId_First(
		long brtId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBrtId_First(brtId, orderByComparator);
	}

	/**
	* Returns the last bus availability in the ordered set where brtId = &#63;.
	*
	* @param brtId the brt ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus availability
	* @throws com.services.NoSuchBusAvailabilityException if a matching bus availability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusAvailability findByBrtId_Last(
		long brtId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusAvailabilityException {
		return getPersistence().findByBrtId_Last(brtId, orderByComparator);
	}

	/**
	* Returns the last bus availability in the ordered set where brtId = &#63;.
	*
	* @param brtId the brt ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus availability, or <code>null</code> if a matching bus availability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusAvailability fetchByBrtId_Last(
		long brtId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBrtId_Last(brtId, orderByComparator);
	}

	/**
	* Returns the bus availabilities before and after the current bus availability in the ordered set where brtId = &#63;.
	*
	* @param baId the primary key of the current bus availability
	* @param brtId the brt ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bus availability
	* @throws com.services.NoSuchBusAvailabilityException if a bus availability with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusAvailability[] findByBrtId_PrevAndNext(
		long baId, long brtId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusAvailabilityException {
		return getPersistence()
				   .findByBrtId_PrevAndNext(baId, brtId, orderByComparator);
	}

	/**
	* Removes all the bus availabilities where brtId = &#63; from the database.
	*
	* @param brtId the brt ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBrtId(long brtId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBrtId(brtId);
	}

	/**
	* Returns the number of bus availabilities where brtId = &#63;.
	*
	* @param brtId the brt ID
	* @return the number of matching bus availabilities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBrtId(long brtId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBrtId(brtId);
	}

	/**
	* Returns all the bus availabilities where available = &#63;.
	*
	* @param available the available
	* @return the matching bus availabilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusAvailability> findByAvailable(
		long available)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAvailable(available);
	}

	/**
	* Returns a range of all the bus availabilities where available = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusAvailabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param available the available
	* @param start the lower bound of the range of bus availabilities
	* @param end the upper bound of the range of bus availabilities (not inclusive)
	* @return the range of matching bus availabilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusAvailability> findByAvailable(
		long available, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAvailable(available, start, end);
	}

	/**
	* Returns an ordered range of all the bus availabilities where available = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusAvailabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param available the available
	* @param start the lower bound of the range of bus availabilities
	* @param end the upper bound of the range of bus availabilities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bus availabilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusAvailability> findByAvailable(
		long available, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAvailable(available, start, end, orderByComparator);
	}

	/**
	* Returns the first bus availability in the ordered set where available = &#63;.
	*
	* @param available the available
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus availability
	* @throws com.services.NoSuchBusAvailabilityException if a matching bus availability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusAvailability findByAvailable_First(
		long available,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusAvailabilityException {
		return getPersistence()
				   .findByAvailable_First(available, orderByComparator);
	}

	/**
	* Returns the first bus availability in the ordered set where available = &#63;.
	*
	* @param available the available
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus availability, or <code>null</code> if a matching bus availability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusAvailability fetchByAvailable_First(
		long available,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAvailable_First(available, orderByComparator);
	}

	/**
	* Returns the last bus availability in the ordered set where available = &#63;.
	*
	* @param available the available
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus availability
	* @throws com.services.NoSuchBusAvailabilityException if a matching bus availability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusAvailability findByAvailable_Last(
		long available,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusAvailabilityException {
		return getPersistence()
				   .findByAvailable_Last(available, orderByComparator);
	}

	/**
	* Returns the last bus availability in the ordered set where available = &#63;.
	*
	* @param available the available
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus availability, or <code>null</code> if a matching bus availability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusAvailability fetchByAvailable_Last(
		long available,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAvailable_Last(available, orderByComparator);
	}

	/**
	* Returns the bus availabilities before and after the current bus availability in the ordered set where available = &#63;.
	*
	* @param baId the primary key of the current bus availability
	* @param available the available
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bus availability
	* @throws com.services.NoSuchBusAvailabilityException if a bus availability with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusAvailability[] findByAvailable_PrevAndNext(
		long baId, long available,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusAvailabilityException {
		return getPersistence()
				   .findByAvailable_PrevAndNext(baId, available,
			orderByComparator);
	}

	/**
	* Removes all the bus availabilities where available = &#63; from the database.
	*
	* @param available the available
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAvailable(long available)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAvailable(available);
	}

	/**
	* Returns the number of bus availabilities where available = &#63;.
	*
	* @param available the available
	* @return the number of matching bus availabilities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAvailable(long available)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAvailable(available);
	}

	/**
	* Caches the bus availability in the entity cache if it is enabled.
	*
	* @param busAvailability the bus availability
	*/
	public static void cacheResult(
		com.services.model.BusAvailability busAvailability) {
		getPersistence().cacheResult(busAvailability);
	}

	/**
	* Caches the bus availabilities in the entity cache if it is enabled.
	*
	* @param busAvailabilities the bus availabilities
	*/
	public static void cacheResult(
		java.util.List<com.services.model.BusAvailability> busAvailabilities) {
		getPersistence().cacheResult(busAvailabilities);
	}

	/**
	* Creates a new bus availability with the primary key. Does not add the bus availability to the database.
	*
	* @param baId the primary key for the new bus availability
	* @return the new bus availability
	*/
	public static com.services.model.BusAvailability create(long baId) {
		return getPersistence().create(baId);
	}

	/**
	* Removes the bus availability with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param baId the primary key of the bus availability
	* @return the bus availability that was removed
	* @throws com.services.NoSuchBusAvailabilityException if a bus availability with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusAvailability remove(long baId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusAvailabilityException {
		return getPersistence().remove(baId);
	}

	public static com.services.model.BusAvailability updateImpl(
		com.services.model.BusAvailability busAvailability)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(busAvailability);
	}

	/**
	* Returns the bus availability with the primary key or throws a {@link com.services.NoSuchBusAvailabilityException} if it could not be found.
	*
	* @param baId the primary key of the bus availability
	* @return the bus availability
	* @throws com.services.NoSuchBusAvailabilityException if a bus availability with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusAvailability findByPrimaryKey(long baId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusAvailabilityException {
		return getPersistence().findByPrimaryKey(baId);
	}

	/**
	* Returns the bus availability with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param baId the primary key of the bus availability
	* @return the bus availability, or <code>null</code> if a bus availability with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BusAvailability fetchByPrimaryKey(
		long baId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(baId);
	}

	/**
	* Returns all the bus availabilities.
	*
	* @return the bus availabilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusAvailability> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the bus availabilities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusAvailabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bus availabilities
	* @param end the upper bound of the range of bus availabilities (not inclusive)
	* @return the range of bus availabilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusAvailability> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the bus availabilities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusAvailabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bus availabilities
	* @param end the upper bound of the range of bus availabilities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bus availabilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BusAvailability> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the bus availabilities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bus availabilities.
	*
	* @return the number of bus availabilities
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BusAvailabilityPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BusAvailabilityPersistence)PortletBeanLocatorUtil.locate(com.services.service.ClpSerializer.getServletContextName(),
					BusAvailabilityPersistence.class.getName());

			ReferenceRegistry.registerReference(BusAvailabilityUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BusAvailabilityPersistence persistence) {
	}

	private static BusAvailabilityPersistence _persistence;
}