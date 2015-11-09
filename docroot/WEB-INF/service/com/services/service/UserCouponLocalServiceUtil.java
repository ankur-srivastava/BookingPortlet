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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for UserCoupon. This utility wraps
 * {@link com.services.service.impl.UserCouponLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ankur Srivastava
 * @see UserCouponLocalService
 * @see com.services.service.base.UserCouponLocalServiceBaseImpl
 * @see com.services.service.impl.UserCouponLocalServiceImpl
 * @generated
 */
public class UserCouponLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.services.service.impl.UserCouponLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user coupon to the database. Also notifies the appropriate model listeners.
	*
	* @param userCoupon the user coupon
	* @return the user coupon that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon addUserCoupon(
		com.services.model.UserCoupon userCoupon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserCoupon(userCoupon);
	}

	/**
	* Creates a new user coupon with the primary key. Does not add the user coupon to the database.
	*
	* @param ucId the primary key for the new user coupon
	* @return the new user coupon
	*/
	public static com.services.model.UserCoupon createUserCoupon(long ucId) {
		return getService().createUserCoupon(ucId);
	}

	/**
	* Deletes the user coupon with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ucId the primary key of the user coupon
	* @return the user coupon that was removed
	* @throws PortalException if a user coupon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon deleteUserCoupon(long ucId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserCoupon(ucId);
	}

	/**
	* Deletes the user coupon from the database. Also notifies the appropriate model listeners.
	*
	* @param userCoupon the user coupon
	* @return the user coupon that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon deleteUserCoupon(
		com.services.model.UserCoupon userCoupon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserCoupon(userCoupon);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.services.model.UserCoupon fetchUserCoupon(long ucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUserCoupon(ucId);
	}

	/**
	* Returns the user coupon with the primary key.
	*
	* @param ucId the primary key of the user coupon
	* @return the user coupon
	* @throws PortalException if a user coupon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon getUserCoupon(long ucId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserCoupon(ucId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.services.model.UserCoupon> getUserCoupons(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserCoupons(start, end);
	}

	/**
	* Returns the number of user coupons.
	*
	* @return the number of user coupons
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserCouponsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserCouponsCount();
	}

	/**
	* Updates the user coupon in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userCoupon the user coupon
	* @return the user coupon that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.UserCoupon updateUserCoupon(
		com.services.model.UserCoupon userCoupon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserCoupon(userCoupon);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.services.model.UserCoupon getValidUserCoupon(
		long userId, long couponId) {
		return getService().getValidUserCoupon(userId, couponId);
	}

	public static void clearService() {
		_service = null;
	}

	public static UserCouponLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UserCouponLocalService.class.getName());

			if (invokableLocalService instanceof UserCouponLocalService) {
				_service = (UserCouponLocalService)invokableLocalService;
			}
			else {
				_service = new UserCouponLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UserCouponLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(UserCouponLocalService service) {
	}

	private static UserCouponLocalService _service;
}