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

import com.services.model.BusReservation;

/**
 * The persistence interface for the bus reservation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusReservationPersistenceImpl
 * @see BusReservationUtil
 * @generated
 */
public interface BusReservationPersistence extends BasePersistence<BusReservation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BusReservationUtil} to access the bus reservation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the bus reservations where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching bus reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusReservation> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bus reservations where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusReservationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of bus reservations
	* @param end the upper bound of the range of bus reservations (not inclusive)
	* @return the range of matching bus reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusReservation> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bus reservations where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusReservationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of bus reservations
	* @param end the upper bound of the range of bus reservations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bus reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusReservation> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bus reservation in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus reservation
	* @throws com.services.NoSuchBusReservationException if a matching bus reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusReservation findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusReservationException;

	/**
	* Returns the first bus reservation in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus reservation, or <code>null</code> if a matching bus reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusReservation fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bus reservation in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus reservation
	* @throws com.services.NoSuchBusReservationException if a matching bus reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusReservation findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusReservationException;

	/**
	* Returns the last bus reservation in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus reservation, or <code>null</code> if a matching bus reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusReservation fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bus reservations before and after the current bus reservation in the ordered set where userId = &#63;.
	*
	* @param brId the primary key of the current bus reservation
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bus reservation
	* @throws com.services.NoSuchBusReservationException if a bus reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusReservation[] findByUserId_PrevAndNext(
		long brId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusReservationException;

	/**
	* Removes all the bus reservations where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bus reservations where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching bus reservations
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bus reservations where baId = &#63;.
	*
	* @param baId the ba ID
	* @return the matching bus reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusReservation> findByBaId(
		long baId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bus reservations where baId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusReservationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param baId the ba ID
	* @param start the lower bound of the range of bus reservations
	* @param end the upper bound of the range of bus reservations (not inclusive)
	* @return the range of matching bus reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusReservation> findByBaId(
		long baId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bus reservations where baId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusReservationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param baId the ba ID
	* @param start the lower bound of the range of bus reservations
	* @param end the upper bound of the range of bus reservations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bus reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusReservation> findByBaId(
		long baId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bus reservation in the ordered set where baId = &#63;.
	*
	* @param baId the ba ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus reservation
	* @throws com.services.NoSuchBusReservationException if a matching bus reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusReservation findByBaId_First(long baId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusReservationException;

	/**
	* Returns the first bus reservation in the ordered set where baId = &#63;.
	*
	* @param baId the ba ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus reservation, or <code>null</code> if a matching bus reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusReservation fetchByBaId_First(long baId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bus reservation in the ordered set where baId = &#63;.
	*
	* @param baId the ba ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus reservation
	* @throws com.services.NoSuchBusReservationException if a matching bus reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusReservation findByBaId_Last(long baId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusReservationException;

	/**
	* Returns the last bus reservation in the ordered set where baId = &#63;.
	*
	* @param baId the ba ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus reservation, or <code>null</code> if a matching bus reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusReservation fetchByBaId_Last(long baId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bus reservations before and after the current bus reservation in the ordered set where baId = &#63;.
	*
	* @param brId the primary key of the current bus reservation
	* @param baId the ba ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bus reservation
	* @throws com.services.NoSuchBusReservationException if a bus reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusReservation[] findByBaId_PrevAndNext(
		long brId, long baId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusReservationException;

	/**
	* Removes all the bus reservations where baId = &#63; from the database.
	*
	* @param baId the ba ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBaId(long baId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bus reservations where baId = &#63;.
	*
	* @param baId the ba ID
	* @return the number of matching bus reservations
	* @throws SystemException if a system exception occurred
	*/
	public int countByBaId(long baId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bus reservation in the entity cache if it is enabled.
	*
	* @param busReservation the bus reservation
	*/
	public void cacheResult(com.services.model.BusReservation busReservation);

	/**
	* Caches the bus reservations in the entity cache if it is enabled.
	*
	* @param busReservations the bus reservations
	*/
	public void cacheResult(
		java.util.List<com.services.model.BusReservation> busReservations);

	/**
	* Creates a new bus reservation with the primary key. Does not add the bus reservation to the database.
	*
	* @param brId the primary key for the new bus reservation
	* @return the new bus reservation
	*/
	public com.services.model.BusReservation create(long brId);

	/**
	* Removes the bus reservation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param brId the primary key of the bus reservation
	* @return the bus reservation that was removed
	* @throws com.services.NoSuchBusReservationException if a bus reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusReservation remove(long brId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusReservationException;

	public com.services.model.BusReservation updateImpl(
		com.services.model.BusReservation busReservation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bus reservation with the primary key or throws a {@link com.services.NoSuchBusReservationException} if it could not be found.
	*
	* @param brId the primary key of the bus reservation
	* @return the bus reservation
	* @throws com.services.NoSuchBusReservationException if a bus reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusReservation findByPrimaryKey(long brId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusReservationException;

	/**
	* Returns the bus reservation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param brId the primary key of the bus reservation
	* @return the bus reservation, or <code>null</code> if a bus reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusReservation fetchByPrimaryKey(long brId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bus reservations.
	*
	* @return the bus reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusReservation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bus reservations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusReservationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bus reservations
	* @param end the upper bound of the range of bus reservations (not inclusive)
	* @return the range of bus reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusReservation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bus reservations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusReservationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bus reservations
	* @param end the upper bound of the range of bus reservations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bus reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusReservation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bus reservations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bus reservations.
	*
	* @return the number of bus reservations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}