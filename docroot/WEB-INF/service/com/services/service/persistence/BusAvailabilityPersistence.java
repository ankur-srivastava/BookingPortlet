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

import com.liferay.portal.service.persistence.BasePersistence;

import com.services.model.BusAvailability;

/**
 * The persistence interface for the bus availability service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusAvailabilityPersistenceImpl
 * @see BusAvailabilityUtil
 * @generated
 */
public interface BusAvailabilityPersistence extends BasePersistence<BusAvailability> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BusAvailabilityUtil} to access the bus availability persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the bus availabilities where brtId = &#63;.
	*
	* @param brtId the brt ID
	* @return the matching bus availabilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusAvailability> findByBrtId(
		long brtId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.BusAvailability> findByBrtId(
		long brtId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.BusAvailability> findByBrtId(
		long brtId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bus availability in the ordered set where brtId = &#63;.
	*
	* @param brtId the brt ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus availability
	* @throws com.services.NoSuchBusAvailabilityException if a matching bus availability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusAvailability findByBrtId_First(long brtId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusAvailabilityException;

	/**
	* Returns the first bus availability in the ordered set where brtId = &#63;.
	*
	* @param brtId the brt ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus availability, or <code>null</code> if a matching bus availability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusAvailability fetchByBrtId_First(long brtId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bus availability in the ordered set where brtId = &#63;.
	*
	* @param brtId the brt ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus availability
	* @throws com.services.NoSuchBusAvailabilityException if a matching bus availability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusAvailability findByBrtId_Last(long brtId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusAvailabilityException;

	/**
	* Returns the last bus availability in the ordered set where brtId = &#63;.
	*
	* @param brtId the brt ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus availability, or <code>null</code> if a matching bus availability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusAvailability fetchByBrtId_Last(long brtId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.services.model.BusAvailability[] findByBrtId_PrevAndNext(
		long baId, long brtId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusAvailabilityException;

	/**
	* Removes all the bus availabilities where brtId = &#63; from the database.
	*
	* @param brtId the brt ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBrtId(long brtId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bus availabilities where brtId = &#63;.
	*
	* @param brtId the brt ID
	* @return the number of matching bus availabilities
	* @throws SystemException if a system exception occurred
	*/
	public int countByBrtId(long brtId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bus availabilities where available = &#63;.
	*
	* @param available the available
	* @return the matching bus availabilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusAvailability> findByAvailable(
		long available)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.BusAvailability> findByAvailable(
		long available, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.BusAvailability> findByAvailable(
		long available, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bus availability in the ordered set where available = &#63;.
	*
	* @param available the available
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus availability
	* @throws com.services.NoSuchBusAvailabilityException if a matching bus availability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusAvailability findByAvailable_First(
		long available,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusAvailabilityException;

	/**
	* Returns the first bus availability in the ordered set where available = &#63;.
	*
	* @param available the available
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus availability, or <code>null</code> if a matching bus availability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusAvailability fetchByAvailable_First(
		long available,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bus availability in the ordered set where available = &#63;.
	*
	* @param available the available
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus availability
	* @throws com.services.NoSuchBusAvailabilityException if a matching bus availability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusAvailability findByAvailable_Last(
		long available,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusAvailabilityException;

	/**
	* Returns the last bus availability in the ordered set where available = &#63;.
	*
	* @param available the available
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus availability, or <code>null</code> if a matching bus availability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusAvailability fetchByAvailable_Last(
		long available,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.services.model.BusAvailability[] findByAvailable_PrevAndNext(
		long baId, long available,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusAvailabilityException;

	/**
	* Removes all the bus availabilities where available = &#63; from the database.
	*
	* @param available the available
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAvailable(long available)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bus availabilities where available = &#63;.
	*
	* @param available the available
	* @return the number of matching bus availabilities
	* @throws SystemException if a system exception occurred
	*/
	public int countByAvailable(long available)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bus availability in the entity cache if it is enabled.
	*
	* @param busAvailability the bus availability
	*/
	public void cacheResult(com.services.model.BusAvailability busAvailability);

	/**
	* Caches the bus availabilities in the entity cache if it is enabled.
	*
	* @param busAvailabilities the bus availabilities
	*/
	public void cacheResult(
		java.util.List<com.services.model.BusAvailability> busAvailabilities);

	/**
	* Creates a new bus availability with the primary key. Does not add the bus availability to the database.
	*
	* @param baId the primary key for the new bus availability
	* @return the new bus availability
	*/
	public com.services.model.BusAvailability create(long baId);

	/**
	* Removes the bus availability with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param baId the primary key of the bus availability
	* @return the bus availability that was removed
	* @throws com.services.NoSuchBusAvailabilityException if a bus availability with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusAvailability remove(long baId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusAvailabilityException;

	public com.services.model.BusAvailability updateImpl(
		com.services.model.BusAvailability busAvailability)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bus availability with the primary key or throws a {@link com.services.NoSuchBusAvailabilityException} if it could not be found.
	*
	* @param baId the primary key of the bus availability
	* @return the bus availability
	* @throws com.services.NoSuchBusAvailabilityException if a bus availability with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusAvailability findByPrimaryKey(long baId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusAvailabilityException;

	/**
	* Returns the bus availability with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param baId the primary key of the bus availability
	* @return the bus availability, or <code>null</code> if a bus availability with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusAvailability fetchByPrimaryKey(long baId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bus availabilities.
	*
	* @return the bus availabilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusAvailability> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.BusAvailability> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.BusAvailability> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bus availabilities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bus availabilities.
	*
	* @return the number of bus availabilities
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}