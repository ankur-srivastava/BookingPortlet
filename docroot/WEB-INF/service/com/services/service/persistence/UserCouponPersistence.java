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

import com.services.model.UserCoupon;

/**
 * The persistence interface for the user coupon service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see UserCouponPersistenceImpl
 * @see UserCouponUtil
 * @generated
 */
public interface UserCouponPersistence extends BasePersistence<UserCoupon> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserCouponUtil} to access the user coupon persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the user coupons where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.UserCoupon> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.UserCoupon> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.UserCoupon> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user coupon in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user coupon
	* @throws com.services.NoSuchUserCouponException if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.UserCoupon findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException;

	/**
	* Returns the first user coupon in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user coupon, or <code>null</code> if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.UserCoupon fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user coupon in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user coupon
	* @throws com.services.NoSuchUserCouponException if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.UserCoupon findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException;

	/**
	* Returns the last user coupon in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user coupon, or <code>null</code> if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.UserCoupon fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.services.model.UserCoupon[] findByUserId_PrevAndNext(long ucId,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException;

	/**
	* Removes all the user coupons where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user coupons where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user coupons where userId = &#63; and couponId = &#63;.
	*
	* @param userId the user ID
	* @param couponId the coupon ID
	* @return the matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.UserCoupon> findByUserCouponId(
		long userId, long couponId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.UserCoupon> findByUserCouponId(
		long userId, long couponId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.UserCoupon> findByUserCouponId(
		long userId, long couponId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.services.model.UserCoupon findByUserCouponId_First(long userId,
		long couponId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException;

	/**
	* Returns the first user coupon in the ordered set where userId = &#63; and couponId = &#63;.
	*
	* @param userId the user ID
	* @param couponId the coupon ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user coupon, or <code>null</code> if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.UserCoupon fetchByUserCouponId_First(
		long userId, long couponId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.services.model.UserCoupon findByUserCouponId_Last(long userId,
		long couponId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException;

	/**
	* Returns the last user coupon in the ordered set where userId = &#63; and couponId = &#63;.
	*
	* @param userId the user ID
	* @param couponId the coupon ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user coupon, or <code>null</code> if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.UserCoupon fetchByUserCouponId_Last(long userId,
		long couponId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.services.model.UserCoupon[] findByUserCouponId_PrevAndNext(
		long ucId, long userId, long couponId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException;

	/**
	* Removes all the user coupons where userId = &#63; and couponId = &#63; from the database.
	*
	* @param userId the user ID
	* @param couponId the coupon ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserCouponId(long userId, long couponId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user coupons where userId = &#63; and couponId = &#63;.
	*
	* @param userId the user ID
	* @param couponId the coupon ID
	* @return the number of matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserCouponId(long userId, long couponId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user coupons where couponId = &#63;.
	*
	* @param couponId the coupon ID
	* @return the matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.UserCoupon> findByCouponId(
		long couponId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.UserCoupon> findByCouponId(
		long couponId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.UserCoupon> findByCouponId(
		long couponId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user coupon in the ordered set where couponId = &#63;.
	*
	* @param couponId the coupon ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user coupon
	* @throws com.services.NoSuchUserCouponException if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.UserCoupon findByCouponId_First(long couponId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException;

	/**
	* Returns the first user coupon in the ordered set where couponId = &#63;.
	*
	* @param couponId the coupon ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user coupon, or <code>null</code> if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.UserCoupon fetchByCouponId_First(long couponId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user coupon in the ordered set where couponId = &#63;.
	*
	* @param couponId the coupon ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user coupon
	* @throws com.services.NoSuchUserCouponException if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.UserCoupon findByCouponId_Last(long couponId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException;

	/**
	* Returns the last user coupon in the ordered set where couponId = &#63;.
	*
	* @param couponId the coupon ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user coupon, or <code>null</code> if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.UserCoupon fetchByCouponId_Last(long couponId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.services.model.UserCoupon[] findByCouponId_PrevAndNext(
		long ucId, long couponId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException;

	/**
	* Removes all the user coupons where couponId = &#63; from the database.
	*
	* @param couponId the coupon ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCouponId(long couponId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user coupons where couponId = &#63;.
	*
	* @param couponId the coupon ID
	* @return the number of matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public int countByCouponId(long couponId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user coupons where claimed = &#63;.
	*
	* @param claimed the claimed
	* @return the matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.UserCoupon> findByClaimedCoupons(
		boolean claimed)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.UserCoupon> findByClaimedCoupons(
		boolean claimed, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.UserCoupon> findByClaimedCoupons(
		boolean claimed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user coupon in the ordered set where claimed = &#63;.
	*
	* @param claimed the claimed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user coupon
	* @throws com.services.NoSuchUserCouponException if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.UserCoupon findByClaimedCoupons_First(
		boolean claimed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException;

	/**
	* Returns the first user coupon in the ordered set where claimed = &#63;.
	*
	* @param claimed the claimed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user coupon, or <code>null</code> if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.UserCoupon fetchByClaimedCoupons_First(
		boolean claimed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user coupon in the ordered set where claimed = &#63;.
	*
	* @param claimed the claimed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user coupon
	* @throws com.services.NoSuchUserCouponException if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.UserCoupon findByClaimedCoupons_Last(
		boolean claimed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException;

	/**
	* Returns the last user coupon in the ordered set where claimed = &#63;.
	*
	* @param claimed the claimed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user coupon, or <code>null</code> if a matching user coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.UserCoupon fetchByClaimedCoupons_Last(
		boolean claimed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.services.model.UserCoupon[] findByClaimedCoupons_PrevAndNext(
		long ucId, boolean claimed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException;

	/**
	* Removes all the user coupons where claimed = &#63; from the database.
	*
	* @param claimed the claimed
	* @throws SystemException if a system exception occurred
	*/
	public void removeByClaimedCoupons(boolean claimed)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user coupons where claimed = &#63;.
	*
	* @param claimed the claimed
	* @return the number of matching user coupons
	* @throws SystemException if a system exception occurred
	*/
	public int countByClaimedCoupons(boolean claimed)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the user coupon in the entity cache if it is enabled.
	*
	* @param userCoupon the user coupon
	*/
	public void cacheResult(com.services.model.UserCoupon userCoupon);

	/**
	* Caches the user coupons in the entity cache if it is enabled.
	*
	* @param userCoupons the user coupons
	*/
	public void cacheResult(
		java.util.List<com.services.model.UserCoupon> userCoupons);

	/**
	* Creates a new user coupon with the primary key. Does not add the user coupon to the database.
	*
	* @param ucId the primary key for the new user coupon
	* @return the new user coupon
	*/
	public com.services.model.UserCoupon create(long ucId);

	/**
	* Removes the user coupon with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ucId the primary key of the user coupon
	* @return the user coupon that was removed
	* @throws com.services.NoSuchUserCouponException if a user coupon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.UserCoupon remove(long ucId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException;

	public com.services.model.UserCoupon updateImpl(
		com.services.model.UserCoupon userCoupon)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user coupon with the primary key or throws a {@link com.services.NoSuchUserCouponException} if it could not be found.
	*
	* @param ucId the primary key of the user coupon
	* @return the user coupon
	* @throws com.services.NoSuchUserCouponException if a user coupon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.UserCoupon findByPrimaryKey(long ucId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchUserCouponException;

	/**
	* Returns the user coupon with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ucId the primary key of the user coupon
	* @return the user coupon, or <code>null</code> if a user coupon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.UserCoupon fetchByPrimaryKey(long ucId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user coupons.
	*
	* @return the user coupons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.UserCoupon> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.UserCoupon> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.UserCoupon> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user coupons from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user coupons.
	*
	* @return the number of user coupons
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}