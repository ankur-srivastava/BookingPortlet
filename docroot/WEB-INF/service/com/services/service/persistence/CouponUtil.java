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

import com.services.model.Coupon;

import java.util.List;

/**
 * The persistence utility for the coupon service. This utility wraps {@link CouponPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see CouponPersistence
 * @see CouponPersistenceImpl
 * @generated
 */
public class CouponUtil {
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
	public static void clearCache(Coupon coupon) {
		getPersistence().clearCache(coupon);
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
	public static List<Coupon> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Coupon> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Coupon> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Coupon update(Coupon coupon) throws SystemException {
		return getPersistence().update(coupon);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Coupon update(Coupon coupon, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(coupon, serviceContext);
	}

	/**
	* Returns all the coupons where couponName = &#63;.
	*
	* @param couponName the coupon name
	* @return the matching coupons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Coupon> findByCouponName(
		java.lang.String couponName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCouponName(couponName);
	}

	/**
	* Returns a range of all the coupons where couponName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.CouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param couponName the coupon name
	* @param start the lower bound of the range of coupons
	* @param end the upper bound of the range of coupons (not inclusive)
	* @return the range of matching coupons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Coupon> findByCouponName(
		java.lang.String couponName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCouponName(couponName, start, end);
	}

	/**
	* Returns an ordered range of all the coupons where couponName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.CouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param couponName the coupon name
	* @param start the lower bound of the range of coupons
	* @param end the upper bound of the range of coupons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching coupons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Coupon> findByCouponName(
		java.lang.String couponName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCouponName(couponName, start, end, orderByComparator);
	}

	/**
	* Returns the first coupon in the ordered set where couponName = &#63;.
	*
	* @param couponName the coupon name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching coupon
	* @throws com.services.NoSuchCouponException if a matching coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Coupon findByCouponName_First(
		java.lang.String couponName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchCouponException {
		return getPersistence()
				   .findByCouponName_First(couponName, orderByComparator);
	}

	/**
	* Returns the first coupon in the ordered set where couponName = &#63;.
	*
	* @param couponName the coupon name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching coupon, or <code>null</code> if a matching coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Coupon fetchByCouponName_First(
		java.lang.String couponName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCouponName_First(couponName, orderByComparator);
	}

	/**
	* Returns the last coupon in the ordered set where couponName = &#63;.
	*
	* @param couponName the coupon name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching coupon
	* @throws com.services.NoSuchCouponException if a matching coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Coupon findByCouponName_Last(
		java.lang.String couponName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchCouponException {
		return getPersistence()
				   .findByCouponName_Last(couponName, orderByComparator);
	}

	/**
	* Returns the last coupon in the ordered set where couponName = &#63;.
	*
	* @param couponName the coupon name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching coupon, or <code>null</code> if a matching coupon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Coupon fetchByCouponName_Last(
		java.lang.String couponName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCouponName_Last(couponName, orderByComparator);
	}

	/**
	* Returns the coupons before and after the current coupon in the ordered set where couponName = &#63;.
	*
	* @param couponId the primary key of the current coupon
	* @param couponName the coupon name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next coupon
	* @throws com.services.NoSuchCouponException if a coupon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Coupon[] findByCouponName_PrevAndNext(
		long couponId, java.lang.String couponName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchCouponException {
		return getPersistence()
				   .findByCouponName_PrevAndNext(couponId, couponName,
			orderByComparator);
	}

	/**
	* Removes all the coupons where couponName = &#63; from the database.
	*
	* @param couponName the coupon name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCouponName(java.lang.String couponName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCouponName(couponName);
	}

	/**
	* Returns the number of coupons where couponName = &#63;.
	*
	* @param couponName the coupon name
	* @return the number of matching coupons
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCouponName(java.lang.String couponName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCouponName(couponName);
	}

	/**
	* Caches the coupon in the entity cache if it is enabled.
	*
	* @param coupon the coupon
	*/
	public static void cacheResult(com.services.model.Coupon coupon) {
		getPersistence().cacheResult(coupon);
	}

	/**
	* Caches the coupons in the entity cache if it is enabled.
	*
	* @param coupons the coupons
	*/
	public static void cacheResult(
		java.util.List<com.services.model.Coupon> coupons) {
		getPersistence().cacheResult(coupons);
	}

	/**
	* Creates a new coupon with the primary key. Does not add the coupon to the database.
	*
	* @param couponId the primary key for the new coupon
	* @return the new coupon
	*/
	public static com.services.model.Coupon create(long couponId) {
		return getPersistence().create(couponId);
	}

	/**
	* Removes the coupon with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param couponId the primary key of the coupon
	* @return the coupon that was removed
	* @throws com.services.NoSuchCouponException if a coupon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Coupon remove(long couponId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchCouponException {
		return getPersistence().remove(couponId);
	}

	public static com.services.model.Coupon updateImpl(
		com.services.model.Coupon coupon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(coupon);
	}

	/**
	* Returns the coupon with the primary key or throws a {@link com.services.NoSuchCouponException} if it could not be found.
	*
	* @param couponId the primary key of the coupon
	* @return the coupon
	* @throws com.services.NoSuchCouponException if a coupon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Coupon findByPrimaryKey(long couponId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchCouponException {
		return getPersistence().findByPrimaryKey(couponId);
	}

	/**
	* Returns the coupon with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param couponId the primary key of the coupon
	* @return the coupon, or <code>null</code> if a coupon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.Coupon fetchByPrimaryKey(long couponId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(couponId);
	}

	/**
	* Returns all the coupons.
	*
	* @return the coupons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Coupon> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the coupons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.CouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of coupons
	* @param end the upper bound of the range of coupons (not inclusive)
	* @return the range of coupons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Coupon> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the coupons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.CouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of coupons
	* @param end the upper bound of the range of coupons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of coupons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.Coupon> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the coupons from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of coupons.
	*
	* @return the number of coupons
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CouponPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CouponPersistence)PortletBeanLocatorUtil.locate(com.services.service.ClpSerializer.getServletContextName(),
					CouponPersistence.class.getName());

			ReferenceRegistry.registerReference(CouponUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CouponPersistence persistence) {
	}

	private static CouponPersistence _persistence;
}