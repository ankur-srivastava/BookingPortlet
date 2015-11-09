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

package com.services.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CouponLocalService}.
 *
 * @author Ankur Srivastava
 * @see CouponLocalService
 * @generated
 */
public class CouponLocalServiceWrapper implements CouponLocalService,
	ServiceWrapper<CouponLocalService> {
	public CouponLocalServiceWrapper(CouponLocalService couponLocalService) {
		_couponLocalService = couponLocalService;
	}

	/**
	* Adds the coupon to the database. Also notifies the appropriate model listeners.
	*
	* @param coupon the coupon
	* @return the coupon that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.Coupon addCoupon(com.services.model.Coupon coupon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _couponLocalService.addCoupon(coupon);
	}

	/**
	* Creates a new coupon with the primary key. Does not add the coupon to the database.
	*
	* @param couponId the primary key for the new coupon
	* @return the new coupon
	*/
	@Override
	public com.services.model.Coupon createCoupon(long couponId) {
		return _couponLocalService.createCoupon(couponId);
	}

	/**
	* Deletes the coupon with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param couponId the primary key of the coupon
	* @return the coupon that was removed
	* @throws PortalException if a coupon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.Coupon deleteCoupon(long couponId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _couponLocalService.deleteCoupon(couponId);
	}

	/**
	* Deletes the coupon from the database. Also notifies the appropriate model listeners.
	*
	* @param coupon the coupon
	* @return the coupon that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.Coupon deleteCoupon(
		com.services.model.Coupon coupon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _couponLocalService.deleteCoupon(coupon);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _couponLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _couponLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.CouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _couponLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.CouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _couponLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _couponLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _couponLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.services.model.Coupon fetchCoupon(long couponId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _couponLocalService.fetchCoupon(couponId);
	}

	/**
	* Returns the coupon with the primary key.
	*
	* @param couponId the primary key of the coupon
	* @return the coupon
	* @throws PortalException if a coupon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.Coupon getCoupon(long couponId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _couponLocalService.getCoupon(couponId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _couponLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.services.model.Coupon> getCoupons(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _couponLocalService.getCoupons(start, end);
	}

	/**
	* Returns the number of coupons.
	*
	* @return the number of coupons
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCouponsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _couponLocalService.getCouponsCount();
	}

	/**
	* Updates the coupon in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param coupon the coupon
	* @return the coupon that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.Coupon updateCoupon(
		com.services.model.Coupon coupon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _couponLocalService.updateCoupon(coupon);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _couponLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_couponLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _couponLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.services.model.Coupon getCouponByName(java.lang.String name) {
		return _couponLocalService.getCouponByName(name);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CouponLocalService getWrappedCouponLocalService() {
		return _couponLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCouponLocalService(
		CouponLocalService couponLocalService) {
		_couponLocalService = couponLocalService;
	}

	@Override
	public CouponLocalService getWrappedService() {
		return _couponLocalService;
	}

	@Override
	public void setWrappedService(CouponLocalService couponLocalService) {
		_couponLocalService = couponLocalService;
	}

	private CouponLocalService _couponLocalService;
}