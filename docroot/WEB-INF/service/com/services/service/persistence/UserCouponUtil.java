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

import com.services.model.UserCoupon;

import java.util.List;

/**
 * The persistence utility for the user coupon service. This utility wraps {@link UserCouponPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see UserCouponPersistence
 * @see UserCouponPersistenceImpl
 * @generated
 */
public class UserCouponUtil {
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
	public static void clearCache(UserCoupon userCoupon) {
		getPersistence().clearCache(userCoupon);
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
	public static List<UserCoupon> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserCoupon> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserCoupon> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UserCoupon update(UserCoupon userCoupon)
		throws SystemException {
		return getPersistence().update(userCoupon);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UserCoupon update(UserCoupon userCoupon,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userCoupon, serviceContext);
	}

	/**
	* Returns all the user coupons where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.UserCoupon> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the user coupons where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.UserCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user coupons
	* @param end the upper bound of the range of user coupons (not inclusive)
	* @return the range of matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.UserCoupon> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the user coupons where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.UserCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user coupons
	* @param end the upper bound of the range of user coupons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.UserCoupon> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first user coupon in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user coupon
	* @throws com.services.NoSuchUserCouponException if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first user coupon in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user coupon, or <code>null</code> if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last user coupon in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user coupon
	* @throws com.services.NoSuchUserCouponException if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last user coupon in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user coupon, or <code>null</code> if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the user coupons before and after the current user coupon in the ordered set where userId = &#63;.
	*
	* @param ucId the primary key of the current user coupon
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user coupon
	* @throws com.services.NoSuchUserCouponException if a user coupon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon[] findByUserId_PrevAndNext(
		long ucId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException {
		return getPersistence()
				   .findByUserId_PrevAndNext(ucId, userId, orderByComparator);
	}

	/**
	* Removes all the user coupons where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of user coupons where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns all the user coupons where userId = &#63; and couponId = &#63;.
	*
	* @param userId the user ID
	* @param couponId the coupon ID
	* @return the matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.UserCoupon> findByUserCouponId(
		long userId, long couponId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserCouponId(userId, couponId);
	}

	/**
	* Returns a range of all the user coupons where userId = &#63; and couponId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.UserCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param couponId the coupon ID
	* @param start the lower bound of the range of user coupons
	* @param end the upper bound of the range of user coupons (not inclusive)
	* @return the range of matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.UserCoupon> findByUserCouponId(
		long userId, long couponId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserCouponId(userId, couponId, start, end);
	}

	/**
	* Returns an ordered range of all the user coupons where userId = &#63; and couponId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.UserCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param couponId the coupon ID
	* @param start the lower bound of the range of user coupons
	* @param end the upper bound of the range of user coupons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.UserCoupon> findByUserCouponId(
		long userId, long couponId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserCouponId(userId, couponId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first user coupon in the ordered set where userId = &#63; and couponId = &#63;.
	*
	* @param userId the user ID
	* @param couponId the coupon ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user coupon
	* @throws com.services.NoSuchUserCouponException if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon findByUserCouponId_First(
		long userId, long couponId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException {
		return getPersistence()
				   .findByUserCouponId_First(userId, couponId, orderByComparator);
	}

	/**
	* Returns the first user coupon in the ordered set where userId = &#63; and couponId = &#63;.
	*
	* @param userId the user ID
	* @param couponId the coupon ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user coupon, or <code>null</code> if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon fetchByUserCouponId_First(
		long userId, long couponId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserCouponId_First(userId, couponId,
			orderByComparator);
	}

	/**
	* Returns the last user coupon in the ordered set where userId = &#63; and couponId = &#63;.
	*
	* @param userId the user ID
	* @param couponId the coupon ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user coupon
	* @throws com.services.NoSuchUserCouponException if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon findByUserCouponId_Last(
		long userId, long couponId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException {
		return getPersistence()
				   .findByUserCouponId_Last(userId, couponId, orderByComparator);
	}

	/**
	* Returns the last user coupon in the ordered set where userId = &#63; and couponId = &#63;.
	*
	* @param userId the user ID
	* @param couponId the coupon ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user coupon, or <code>null</code> if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon fetchByUserCouponId_Last(
		long userId, long couponId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserCouponId_Last(userId, couponId, orderByComparator);
	}

	/**
	* Returns the user coupons before and after the current user coupon in the ordered set where userId = &#63; and couponId = &#63;.
	*
	* @param ucId the primary key of the current user coupon
	* @param userId the user ID
	* @param couponId the coupon ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user coupon
	* @throws com.services.NoSuchUserCouponException if a user coupon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon[] findByUserCouponId_PrevAndNext(
		long ucId, long userId, long couponId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException {
		return getPersistence()
				   .findByUserCouponId_PrevAndNext(ucId, userId, couponId,
			orderByComparator);
	}

	/**
	* Removes all the user coupons where userId = &#63; and couponId = &#63; from the database.
	*
	* @param userId the user ID
	* @param couponId the coupon ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserCouponId(long userId, long couponId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserCouponId(userId, couponId);
	}

	/**
	* Returns the number of user coupons where userId = &#63; and couponId = &#63;.
	*
	* @param userId the user ID
	* @param couponId the coupon ID
	* @return the number of matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserCouponId(long userId, long couponId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserCouponId(userId, couponId);
	}

	/**
	* Returns all the user coupons where couponId = &#63;.
	*
	* @param couponId the coupon ID
	* @return the matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.UserCoupon> findByCouponId(
		long couponId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCouponId(couponId);
	}

	/**
	* Returns a range of all the user coupons where couponId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.UserCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param couponId the coupon ID
	* @param start the lower bound of the range of user coupons
	* @param end the upper bound of the range of user coupons (not inclusive)
	* @return the range of matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.UserCoupon> findByCouponId(
		long couponId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCouponId(couponId, start, end);
	}

	/**
	* Returns an ordered range of all the user coupons where couponId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.UserCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param couponId the coupon ID
	* @param start the lower bound of the range of user coupons
	* @param end the upper bound of the range of user coupons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.UserCoupon> findByCouponId(
		long couponId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCouponId(couponId, start, end, orderByComparator);
	}

	/**
	* Returns the first user coupon in the ordered set where couponId = &#63;.
	*
	* @param couponId the coupon ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user coupon
	* @throws com.services.NoSuchUserCouponException if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon findByCouponId_First(
		long couponId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException {
		return getPersistence().findByCouponId_First(couponId, orderByComparator);
	}

	/**
	* Returns the first user coupon in the ordered set where couponId = &#63;.
	*
	* @param couponId the coupon ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user coupon, or <code>null</code> if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon fetchByCouponId_First(
		long couponId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCouponId_First(couponId, orderByComparator);
	}

	/**
	* Returns the last user coupon in the ordered set where couponId = &#63;.
	*
	* @param couponId the coupon ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user coupon
	* @throws com.services.NoSuchUserCouponException if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon findByCouponId_Last(
		long couponId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException {
		return getPersistence().findByCouponId_Last(couponId, orderByComparator);
	}

	/**
	* Returns the last user coupon in the ordered set where couponId = &#63;.
	*
	* @param couponId the coupon ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user coupon, or <code>null</code> if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon fetchByCouponId_Last(
		long couponId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCouponId_Last(couponId, orderByComparator);
	}

	/**
	* Returns the user coupons before and after the current user coupon in the ordered set where couponId = &#63;.
	*
	* @param ucId the primary key of the current user coupon
	* @param couponId the coupon ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user coupon
	* @throws com.services.NoSuchUserCouponException if a user coupon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon[] findByCouponId_PrevAndNext(
		long ucId, long couponId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException {
		return getPersistence()
				   .findByCouponId_PrevAndNext(ucId, couponId, orderByComparator);
	}

	/**
	* Removes all the user coupons where couponId = &#63; from the database.
	*
	* @param couponId the coupon ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCouponId(long couponId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCouponId(couponId);
	}

	/**
	* Returns the number of user coupons where couponId = &#63;.
	*
	* @param couponId the coupon ID
	* @return the number of matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCouponId(long couponId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCouponId(couponId);
	}

	/**
	* Returns all the user coupons where claimed = &#63;.
	*
	* @param claimed the claimed
	* @return the matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.UserCoupon> findByClaimedCoupons(
		boolean claimed)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByClaimedCoupons(claimed);
	}

	/**
	* Returns a range of all the user coupons where claimed = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.UserCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param claimed the claimed
	* @param start the lower bound of the range of user coupons
	* @param end the upper bound of the range of user coupons (not inclusive)
	* @return the range of matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.UserCoupon> findByClaimedCoupons(
		boolean claimed, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByClaimedCoupons(claimed, start, end);
	}

	/**
	* Returns an ordered range of all the user coupons where claimed = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.UserCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param claimed the claimed
	* @param start the lower bound of the range of user coupons
	* @param end the upper bound of the range of user coupons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.UserCoupon> findByClaimedCoupons(
		boolean claimed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByClaimedCoupons(claimed, start, end, orderByComparator);
	}

	/**
	* Returns the first user coupon in the ordered set where claimed = &#63;.
	*
	* @param claimed the claimed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user coupon
	* @throws com.services.NoSuchUserCouponException if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon findByClaimedCoupons_First(
		boolean claimed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException {
		return getPersistence()
				   .findByClaimedCoupons_First(claimed, orderByComparator);
	}

	/**
	* Returns the first user coupon in the ordered set where claimed = &#63;.
	*
	* @param claimed the claimed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user coupon, or <code>null</code> if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon fetchByClaimedCoupons_First(
		boolean claimed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByClaimedCoupons_First(claimed, orderByComparator);
	}

	/**
	* Returns the last user coupon in the ordered set where claimed = &#63;.
	*
	* @param claimed the claimed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user coupon
	* @throws com.services.NoSuchUserCouponException if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon findByClaimedCoupons_Last(
		boolean claimed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException {
		return getPersistence()
				   .findByClaimedCoupons_Last(claimed, orderByComparator);
	}

	/**
	* Returns the last user coupon in the ordered set where claimed = &#63;.
	*
	* @param claimed the claimed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user coupon, or <code>null</code> if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon fetchByClaimedCoupons_Last(
		boolean claimed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByClaimedCoupons_Last(claimed, orderByComparator);
	}

	/**
	* Returns the user coupons before and after the current user coupon in the ordered set where claimed = &#63;.
	*
	* @param ucId the primary key of the current user coupon
	* @param claimed the claimed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user coupon
	* @throws com.services.NoSuchUserCouponException if a user coupon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon[] findByClaimedCoupons_PrevAndNext(
		long ucId, boolean claimed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException {
		return getPersistence()
				   .findByClaimedCoupons_PrevAndNext(ucId, claimed,
			orderByComparator);
	}

	/**
	* Removes all the user coupons where claimed = &#63; from the database.
	*
	* @param claimed the claimed
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByClaimedCoupons(boolean claimed)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByClaimedCoupons(claimed);
	}

	/**
	* Returns the number of user coupons where claimed = &#63;.
	*
	* @param claimed the claimed
	* @return the number of matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public static int countByClaimedCoupons(boolean claimed)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByClaimedCoupons(claimed);
	}

	/**
	* Caches the user coupon in the entity cache if it is enabled.
	*
	* @param userCoupon the user coupon
	*/
	public static void cacheResult(com.services.model.UserCoupon userCoupon) {
		getPersistence().cacheResult(userCoupon);
	}

	/**
	* Caches the user coupons in the entity cache if it is enabled.
	*
	* @param userCoupons the user coupons
	*/
	public static void cacheResult(
		java.util.List<com.services.model.UserCoupon> userCoupons) {
		getPersistence().cacheResult(userCoupons);
	}

	/**
	* Creates a new user coupon with the primary key. Does not add the user coupon to the database.
	*
	* @param ucId the primary key for the new user coupon
	* @return the new user coupon
	*/
	public static com.services.model.UserCoupon create(long ucId) {
		return getPersistence().create(ucId);
	}

	/**
	* Removes the user coupon with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ucId the primary key of the user coupon
	* @return the user coupon that was removed
	* @throws com.services.NoSuchUserCouponException if a user coupon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon remove(long ucId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException {
		return getPersistence().remove(ucId);
	}

	public static com.services.model.UserCoupon updateImpl(
		com.services.model.UserCoupon userCoupon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userCoupon);
	}

	/**
	* Returns the user coupon with the primary key or throws a {@link com.services.NoSuchUserCouponException} if it could not be found.
	*
	* @param ucId the primary key of the user coupon
	* @return the user coupon
	* @throws com.services.NoSuchUserCouponException if a user coupon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon findByPrimaryKey(long ucId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException {
		return getPersistence().findByPrimaryKey(ucId);
	}

	/**
	* Returns the user coupon with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ucId the primary key of the user coupon
	* @return the user coupon, or <code>null</code> if a user coupon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon fetchByPrimaryKey(long ucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ucId);
	}

	/**
	* Returns all the user coupons.
	*
	* @return the user coupons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.UserCoupon> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user coupons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.UserCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user coupons
	* @param end the upper bound of the range of user coupons (not inclusive)
	* @return the range of user coupons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.UserCoupon> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user coupons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.UserCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user coupons
	* @param end the upper bound of the range of user coupons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user coupons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.UserCoupon> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user coupons from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user coupons.
	*
	* @return the number of user coupons
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserCouponPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserCouponPersistence)PortletBeanLocatorUtil.locate(com.services.service.ClpSerializer.getServletContextName(),
					UserCouponPersistence.class.getName());

			ReferenceRegistry.registerReference(UserCouponUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UserCouponPersistence persistence) {
	}

	private static UserCouponPersistence _persistence;
}