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
 * Provides a wrapper for {@link UserCouponLocalService}.
 *
 * @author Ankur Srivastava
 * @see UserCouponLocalService
 * @generated
 */
public class UserCouponLocalServiceWrapper implements UserCouponLocalService,
	ServiceWrapper<UserCouponLocalService> {
	public UserCouponLocalServiceWrapper(
		UserCouponLocalService userCouponLocalService) {
		_userCouponLocalService = userCouponLocalService;
	}

	/**
	* Adds the user coupon to the database. Also notifies the appropriate model listeners.
	*
	* @param userCoupon the user coupon
	* @return the user coupon that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.UserCoupon addUserCoupon(
		com.services.model.UserCoupon userCoupon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userCouponLocalService.addUserCoupon(userCoupon);
	}

	/**
	* Creates a new user coupon with the primary key. Does not add the user coupon to the database.
	*
	* @param ucId the primary key for the new user coupon
	* @return the new user coupon
	*/
	@Override
	public com.services.model.UserCoupon createUserCoupon(long ucId) {
		return _userCouponLocalService.createUserCoupon(ucId);
	}

	/**
	* Deletes the user coupon with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ucId the primary key of the user coupon
	* @return the user coupon that was removed
	* @throws PortalException if a user coupon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.UserCoupon deleteUserCoupon(long ucId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userCouponLocalService.deleteUserCoupon(ucId);
	}

	/**
	* Deletes the user coupon from the database. Also notifies the appropriate model listeners.
	*
	* @param userCoupon the user coupon
	* @return the user coupon that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.UserCoupon deleteUserCoupon(
		com.services.model.UserCoupon userCoupon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userCouponLocalService.deleteUserCoupon(userCoupon);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userCouponLocalService.dynamicQuery();
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
		return _userCouponLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.UserCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _userCouponLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.UserCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _userCouponLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _userCouponLocalService.dynamicQueryCount(dynamicQuery);
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
		return _userCouponLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.services.model.UserCoupon fetchUserCoupon(long ucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userCouponLocalService.fetchUserCoupon(ucId);
	}

	/**
	* Returns the user coupon with the primary key.
	*
	* @param ucId the primary key of the user coupon
	* @return the user coupon
	* @throws PortalException if a user coupon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.UserCoupon getUserCoupon(long ucId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userCouponLocalService.getUserCoupon(ucId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userCouponLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.services.model.UserCoupon> getUserCoupons(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userCouponLocalService.getUserCoupons(start, end);
	}

	/**
	* Returns the number of user coupons.
	*
	* @return the number of user coupons
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUserCouponsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userCouponLocalService.getUserCouponsCount();
	}

	/**
	* Updates the user coupon in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userCoupon the user coupon
	* @return the user coupon that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.UserCoupon updateUserCoupon(
		com.services.model.UserCoupon userCoupon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userCouponLocalService.updateUserCoupon(userCoupon);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _userCouponLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userCouponLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userCouponLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.services.model.UserCoupon getValidUserCoupon(long userId,
		long couponId) {
		return _userCouponLocalService.getValidUserCoupon(userId, couponId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UserCouponLocalService getWrappedUserCouponLocalService() {
		return _userCouponLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUserCouponLocalService(
		UserCouponLocalService userCouponLocalService) {
		_userCouponLocalService = userCouponLocalService;
	}

	@Override
	public UserCouponLocalService getWrappedService() {
		return _userCouponLocalService;
	}

	@Override
	public void setWrappedService(UserCouponLocalService userCouponLocalService) {
		_userCouponLocalService = userCouponLocalService;
	}

	private UserCouponLocalService _userCouponLocalService;
}