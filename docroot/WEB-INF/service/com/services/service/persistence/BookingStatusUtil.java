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

import com.services.model.BookingStatus;

import java.util.List;

/**
 * The persistence utility for the booking status service. This utility wraps {@link BookingStatusPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see BookingStatusPersistence
 * @see BookingStatusPersistenceImpl
 * @generated
 */
public class BookingStatusUtil {
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
	public static void clearCache(BookingStatus bookingStatus) {
		getPersistence().clearCache(bookingStatus);
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
	public static List<BookingStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BookingStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BookingStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BookingStatus update(BookingStatus bookingStatus)
		throws SystemException {
		return getPersistence().update(bookingStatus);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BookingStatus update(BookingStatus bookingStatus,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(bookingStatus, serviceContext);
	}

	/**
	* Returns all the booking statuses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BookingStatus> findBybyUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyUserId(userId);
	}

	/**
	* Returns a range of all the booking statuses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of booking statuses
	* @param end the upper bound of the range of booking statuses (not inclusive)
	* @return the range of matching booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BookingStatus> findBybyUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the booking statuses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of booking statuses
	* @param end the upper bound of the range of booking statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BookingStatus> findBybyUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first booking status in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking status
	* @throws com.services.NoSuchBookingStatusException if a matching booking status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus findBybyUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBookingStatusException {
		return getPersistence().findBybyUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first booking status in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking status, or <code>null</code> if a matching booking status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus fetchBybyUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last booking status in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking status
	* @throws com.services.NoSuchBookingStatusException if a matching booking status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus findBybyUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBookingStatusException {
		return getPersistence().findBybyUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last booking status in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking status, or <code>null</code> if a matching booking status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus fetchBybyUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the booking statuses before and after the current booking status in the ordered set where userId = &#63;.
	*
	* @param bsId the primary key of the current booking status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next booking status
	* @throws com.services.NoSuchBookingStatusException if a booking status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus[] findBybyUserId_PrevAndNext(
		long bsId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBookingStatusException {
		return getPersistence()
				   .findBybyUserId_PrevAndNext(bsId, userId, orderByComparator);
	}

	/**
	* Removes all the booking statuses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybyUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybyUserId(userId);
	}

	/**
	* Returns the number of booking statuses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyUserId(userId);
	}

	/**
	* Returns all the booking statuses where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @return the matching booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BookingStatus> findBybyUserAndStatus(
		long userId, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyUserAndStatus(userId, status);
	}

	/**
	* Returns a range of all the booking statuses where userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param status the status
	* @param start the lower bound of the range of booking statuses
	* @param end the upper bound of the range of booking statuses (not inclusive)
	* @return the range of matching booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BookingStatus> findBybyUserAndStatus(
		long userId, java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyUserAndStatus(userId, status, start, end);
	}

	/**
	* Returns an ordered range of all the booking statuses where userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param status the status
	* @param start the lower bound of the range of booking statuses
	* @param end the upper bound of the range of booking statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BookingStatus> findBybyUserAndStatus(
		long userId, java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyUserAndStatus(userId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first booking status in the ordered set where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking status
	* @throws com.services.NoSuchBookingStatusException if a matching booking status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus findBybyUserAndStatus_First(
		long userId, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBookingStatusException {
		return getPersistence()
				   .findBybyUserAndStatus_First(userId, status,
			orderByComparator);
	}

	/**
	* Returns the first booking status in the ordered set where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking status, or <code>null</code> if a matching booking status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus fetchBybyUserAndStatus_First(
		long userId, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyUserAndStatus_First(userId, status,
			orderByComparator);
	}

	/**
	* Returns the last booking status in the ordered set where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking status
	* @throws com.services.NoSuchBookingStatusException if a matching booking status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus findBybyUserAndStatus_Last(
		long userId, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBookingStatusException {
		return getPersistence()
				   .findBybyUserAndStatus_Last(userId, status, orderByComparator);
	}

	/**
	* Returns the last booking status in the ordered set where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking status, or <code>null</code> if a matching booking status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus fetchBybyUserAndStatus_Last(
		long userId, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyUserAndStatus_Last(userId, status,
			orderByComparator);
	}

	/**
	* Returns the booking statuses before and after the current booking status in the ordered set where userId = &#63; and status = &#63;.
	*
	* @param bsId the primary key of the current booking status
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next booking status
	* @throws com.services.NoSuchBookingStatusException if a booking status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus[] findBybyUserAndStatus_PrevAndNext(
		long bsId, long userId, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBookingStatusException {
		return getPersistence()
				   .findBybyUserAndStatus_PrevAndNext(bsId, userId, status,
			orderByComparator);
	}

	/**
	* Removes all the booking statuses where userId = &#63; and status = &#63; from the database.
	*
	* @param userId the user ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybyUserAndStatus(long userId,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybyUserAndStatus(userId, status);
	}

	/**
	* Returns the number of booking statuses where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @return the number of matching booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyUserAndStatus(long userId,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyUserAndStatus(userId, status);
	}

	/**
	* Returns all the booking statuses where brtId = &#63;.
	*
	* @param brtId the brt ID
	* @return the matching booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BookingStatus> findBybyBrtId(
		long brtId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyBrtId(brtId);
	}

	/**
	* Returns a range of all the booking statuses where brtId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param brtId the brt ID
	* @param start the lower bound of the range of booking statuses
	* @param end the upper bound of the range of booking statuses (not inclusive)
	* @return the range of matching booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BookingStatus> findBybyBrtId(
		long brtId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyBrtId(brtId, start, end);
	}

	/**
	* Returns an ordered range of all the booking statuses where brtId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param brtId the brt ID
	* @param start the lower bound of the range of booking statuses
	* @param end the upper bound of the range of booking statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BookingStatus> findBybyBrtId(
		long brtId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyBrtId(brtId, start, end, orderByComparator);
	}

	/**
	* Returns the first booking status in the ordered set where brtId = &#63;.
	*
	* @param brtId the brt ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking status
	* @throws com.services.NoSuchBookingStatusException if a matching booking status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus findBybyBrtId_First(
		long brtId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBookingStatusException {
		return getPersistence().findBybyBrtId_First(brtId, orderByComparator);
	}

	/**
	* Returns the first booking status in the ordered set where brtId = &#63;.
	*
	* @param brtId the brt ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking status, or <code>null</code> if a matching booking status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus fetchBybyBrtId_First(
		long brtId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyBrtId_First(brtId, orderByComparator);
	}

	/**
	* Returns the last booking status in the ordered set where brtId = &#63;.
	*
	* @param brtId the brt ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking status
	* @throws com.services.NoSuchBookingStatusException if a matching booking status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus findBybyBrtId_Last(
		long brtId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBookingStatusException {
		return getPersistence().findBybyBrtId_Last(brtId, orderByComparator);
	}

	/**
	* Returns the last booking status in the ordered set where brtId = &#63;.
	*
	* @param brtId the brt ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking status, or <code>null</code> if a matching booking status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus fetchBybyBrtId_Last(
		long brtId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyBrtId_Last(brtId, orderByComparator);
	}

	/**
	* Returns the booking statuses before and after the current booking status in the ordered set where brtId = &#63;.
	*
	* @param bsId the primary key of the current booking status
	* @param brtId the brt ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next booking status
	* @throws com.services.NoSuchBookingStatusException if a booking status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus[] findBybyBrtId_PrevAndNext(
		long bsId, long brtId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBookingStatusException {
		return getPersistence()
				   .findBybyBrtId_PrevAndNext(bsId, brtId, orderByComparator);
	}

	/**
	* Removes all the booking statuses where brtId = &#63; from the database.
	*
	* @param brtId the brt ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybyBrtId(long brtId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybyBrtId(brtId);
	}

	/**
	* Returns the number of booking statuses where brtId = &#63;.
	*
	* @param brtId the brt ID
	* @return the number of matching booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyBrtId(long brtId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyBrtId(brtId);
	}

	/**
	* Returns all the booking statuses where tripStatus = &#63;.
	*
	* @param tripStatus the trip status
	* @return the matching booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BookingStatus> findBybyTripStatus(
		java.lang.String tripStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyTripStatus(tripStatus);
	}

	/**
	* Returns a range of all the booking statuses where tripStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tripStatus the trip status
	* @param start the lower bound of the range of booking statuses
	* @param end the upper bound of the range of booking statuses (not inclusive)
	* @return the range of matching booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BookingStatus> findBybyTripStatus(
		java.lang.String tripStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyTripStatus(tripStatus, start, end);
	}

	/**
	* Returns an ordered range of all the booking statuses where tripStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tripStatus the trip status
	* @param start the lower bound of the range of booking statuses
	* @param end the upper bound of the range of booking statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BookingStatus> findBybyTripStatus(
		java.lang.String tripStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyTripStatus(tripStatus, start, end, orderByComparator);
	}

	/**
	* Returns the first booking status in the ordered set where tripStatus = &#63;.
	*
	* @param tripStatus the trip status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking status
	* @throws com.services.NoSuchBookingStatusException if a matching booking status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus findBybyTripStatus_First(
		java.lang.String tripStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBookingStatusException {
		return getPersistence()
				   .findBybyTripStatus_First(tripStatus, orderByComparator);
	}

	/**
	* Returns the first booking status in the ordered set where tripStatus = &#63;.
	*
	* @param tripStatus the trip status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking status, or <code>null</code> if a matching booking status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus fetchBybyTripStatus_First(
		java.lang.String tripStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyTripStatus_First(tripStatus, orderByComparator);
	}

	/**
	* Returns the last booking status in the ordered set where tripStatus = &#63;.
	*
	* @param tripStatus the trip status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking status
	* @throws com.services.NoSuchBookingStatusException if a matching booking status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus findBybyTripStatus_Last(
		java.lang.String tripStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBookingStatusException {
		return getPersistence()
				   .findBybyTripStatus_Last(tripStatus, orderByComparator);
	}

	/**
	* Returns the last booking status in the ordered set where tripStatus = &#63;.
	*
	* @param tripStatus the trip status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking status, or <code>null</code> if a matching booking status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus fetchBybyTripStatus_Last(
		java.lang.String tripStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyTripStatus_Last(tripStatus, orderByComparator);
	}

	/**
	* Returns the booking statuses before and after the current booking status in the ordered set where tripStatus = &#63;.
	*
	* @param bsId the primary key of the current booking status
	* @param tripStatus the trip status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next booking status
	* @throws com.services.NoSuchBookingStatusException if a booking status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus[] findBybyTripStatus_PrevAndNext(
		long bsId, java.lang.String tripStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBookingStatusException {
		return getPersistence()
				   .findBybyTripStatus_PrevAndNext(bsId, tripStatus,
			orderByComparator);
	}

	/**
	* Removes all the booking statuses where tripStatus = &#63; from the database.
	*
	* @param tripStatus the trip status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybyTripStatus(java.lang.String tripStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybyTripStatus(tripStatus);
	}

	/**
	* Returns the number of booking statuses where tripStatus = &#63;.
	*
	* @param tripStatus the trip status
	* @return the number of matching booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyTripStatus(java.lang.String tripStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyTripStatus(tripStatus);
	}

	/**
	* Returns all the booking statuses where userId = &#63; and tripStatus = &#63;.
	*
	* @param userId the user ID
	* @param tripStatus the trip status
	* @return the matching booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BookingStatus> findBybyUserAndTripStatus(
		long userId, java.lang.String tripStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyUserAndTripStatus(userId, tripStatus);
	}

	/**
	* Returns a range of all the booking statuses where userId = &#63; and tripStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param tripStatus the trip status
	* @param start the lower bound of the range of booking statuses
	* @param end the upper bound of the range of booking statuses (not inclusive)
	* @return the range of matching booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BookingStatus> findBybyUserAndTripStatus(
		long userId, java.lang.String tripStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyUserAndTripStatus(userId, tripStatus, start, end);
	}

	/**
	* Returns an ordered range of all the booking statuses where userId = &#63; and tripStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param tripStatus the trip status
	* @param start the lower bound of the range of booking statuses
	* @param end the upper bound of the range of booking statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BookingStatus> findBybyUserAndTripStatus(
		long userId, java.lang.String tripStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyUserAndTripStatus(userId, tripStatus, start, end,
			orderByComparator);
	}

	/**
	* Returns the first booking status in the ordered set where userId = &#63; and tripStatus = &#63;.
	*
	* @param userId the user ID
	* @param tripStatus the trip status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking status
	* @throws com.services.NoSuchBookingStatusException if a matching booking status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus findBybyUserAndTripStatus_First(
		long userId, java.lang.String tripStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBookingStatusException {
		return getPersistence()
				   .findBybyUserAndTripStatus_First(userId, tripStatus,
			orderByComparator);
	}

	/**
	* Returns the first booking status in the ordered set where userId = &#63; and tripStatus = &#63;.
	*
	* @param userId the user ID
	* @param tripStatus the trip status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking status, or <code>null</code> if a matching booking status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus fetchBybyUserAndTripStatus_First(
		long userId, java.lang.String tripStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyUserAndTripStatus_First(userId, tripStatus,
			orderByComparator);
	}

	/**
	* Returns the last booking status in the ordered set where userId = &#63; and tripStatus = &#63;.
	*
	* @param userId the user ID
	* @param tripStatus the trip status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking status
	* @throws com.services.NoSuchBookingStatusException if a matching booking status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus findBybyUserAndTripStatus_Last(
		long userId, java.lang.String tripStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBookingStatusException {
		return getPersistence()
				   .findBybyUserAndTripStatus_Last(userId, tripStatus,
			orderByComparator);
	}

	/**
	* Returns the last booking status in the ordered set where userId = &#63; and tripStatus = &#63;.
	*
	* @param userId the user ID
	* @param tripStatus the trip status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking status, or <code>null</code> if a matching booking status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus fetchBybyUserAndTripStatus_Last(
		long userId, java.lang.String tripStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyUserAndTripStatus_Last(userId, tripStatus,
			orderByComparator);
	}

	/**
	* Returns the booking statuses before and after the current booking status in the ordered set where userId = &#63; and tripStatus = &#63;.
	*
	* @param bsId the primary key of the current booking status
	* @param userId the user ID
	* @param tripStatus the trip status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next booking status
	* @throws com.services.NoSuchBookingStatusException if a booking status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus[] findBybyUserAndTripStatus_PrevAndNext(
		long bsId, long userId, java.lang.String tripStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBookingStatusException {
		return getPersistence()
				   .findBybyUserAndTripStatus_PrevAndNext(bsId, userId,
			tripStatus, orderByComparator);
	}

	/**
	* Removes all the booking statuses where userId = &#63; and tripStatus = &#63; from the database.
	*
	* @param userId the user ID
	* @param tripStatus the trip status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybyUserAndTripStatus(long userId,
		java.lang.String tripStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybyUserAndTripStatus(userId, tripStatus);
	}

	/**
	* Returns the number of booking statuses where userId = &#63; and tripStatus = &#63;.
	*
	* @param userId the user ID
	* @param tripStatus the trip status
	* @return the number of matching booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyUserAndTripStatus(long userId,
		java.lang.String tripStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyUserAndTripStatus(userId, tripStatus);
	}

	/**
	* Caches the booking status in the entity cache if it is enabled.
	*
	* @param bookingStatus the booking status
	*/
	public static void cacheResult(
		com.services.model.BookingStatus bookingStatus) {
		getPersistence().cacheResult(bookingStatus);
	}

	/**
	* Caches the booking statuses in the entity cache if it is enabled.
	*
	* @param bookingStatuses the booking statuses
	*/
	public static void cacheResult(
		java.util.List<com.services.model.BookingStatus> bookingStatuses) {
		getPersistence().cacheResult(bookingStatuses);
	}

	/**
	* Creates a new booking status with the primary key. Does not add the booking status to the database.
	*
	* @param bsId the primary key for the new booking status
	* @return the new booking status
	*/
	public static com.services.model.BookingStatus create(long bsId) {
		return getPersistence().create(bsId);
	}

	/**
	* Removes the booking status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bsId the primary key of the booking status
	* @return the booking status that was removed
	* @throws com.services.NoSuchBookingStatusException if a booking status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus remove(long bsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBookingStatusException {
		return getPersistence().remove(bsId);
	}

	public static com.services.model.BookingStatus updateImpl(
		com.services.model.BookingStatus bookingStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(bookingStatus);
	}

	/**
	* Returns the booking status with the primary key or throws a {@link com.services.NoSuchBookingStatusException} if it could not be found.
	*
	* @param bsId the primary key of the booking status
	* @return the booking status
	* @throws com.services.NoSuchBookingStatusException if a booking status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus findByPrimaryKey(long bsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBookingStatusException {
		return getPersistence().findByPrimaryKey(bsId);
	}

	/**
	* Returns the booking status with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bsId the primary key of the booking status
	* @return the booking status, or <code>null</code> if a booking status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus fetchByPrimaryKey(long bsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(bsId);
	}

	/**
	* Returns all the booking statuses.
	*
	* @return the booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BookingStatus> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the booking statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of booking statuses
	* @param end the upper bound of the range of booking statuses (not inclusive)
	* @return the range of booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BookingStatus> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the booking statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of booking statuses
	* @param end the upper bound of the range of booking statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.BookingStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the booking statuses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of booking statuses.
	*
	* @return the number of booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BookingStatusPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BookingStatusPersistence)PortletBeanLocatorUtil.locate(com.services.service.ClpSerializer.getServletContextName(),
					BookingStatusPersistence.class.getName());

			ReferenceRegistry.registerReference(BookingStatusUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BookingStatusPersistence persistence) {
	}

	private static BookingStatusPersistence _persistence;
}