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
 * Provides the local service utility for BookingStatus. This utility wraps
 * {@link com.services.service.impl.BookingStatusLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ankur Srivastava
 * @see BookingStatusLocalService
 * @see com.services.service.base.BookingStatusLocalServiceBaseImpl
 * @see com.services.service.impl.BookingStatusLocalServiceImpl
 * @generated
 */
public class BookingStatusLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.services.service.impl.BookingStatusLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the booking status to the database. Also notifies the appropriate model listeners.
	*
	* @param bookingStatus the booking status
	* @return the booking status that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus addBookingStatus(
		com.services.model.BookingStatus bookingStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBookingStatus(bookingStatus);
	}

	/**
	* Creates a new booking status with the primary key. Does not add the booking status to the database.
	*
	* @param bsId the primary key for the new booking status
	* @return the new booking status
	*/
	public static com.services.model.BookingStatus createBookingStatus(
		long bsId) {
		return getService().createBookingStatus(bsId);
	}

	/**
	* Deletes the booking status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bsId the primary key of the booking status
	* @return the booking status that was removed
	* @throws PortalException if a booking status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus deleteBookingStatus(
		long bsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBookingStatus(bsId);
	}

	/**
	* Deletes the booking status from the database. Also notifies the appropriate model listeners.
	*
	* @param bookingStatus the booking status
	* @return the booking status that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus deleteBookingStatus(
		com.services.model.BookingStatus bookingStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBookingStatus(bookingStatus);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.services.model.BookingStatus fetchBookingStatus(long bsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBookingStatus(bsId);
	}

	/**
	* Returns the booking status with the primary key.
	*
	* @param bsId the primary key of the booking status
	* @return the booking status
	* @throws PortalException if a booking status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus getBookingStatus(long bsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBookingStatus(bsId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.services.model.BookingStatus> getBookingStatuses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBookingStatuses(start, end);
	}

	/**
	* Returns the number of booking statuses.
	*
	* @return the number of booking statuses
	* @throws SystemException if a system exception occurred
	*/
	public static int getBookingStatusesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBookingStatusesCount();
	}

	/**
	* Updates the booking status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bookingStatus the booking status
	* @return the booking status that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.BookingStatus updateBookingStatus(
		com.services.model.BookingStatus bookingStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBookingStatus(bookingStatus);
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

	public static boolean updateBooking(
		com.services.model.BookingStatus bookingStatus) {
		return getService().updateBooking(bookingStatus);
	}

	public static boolean bookTicket(long brtId, long userId) {
		return getService().bookTicket(brtId, userId);
	}

	public static java.util.List<com.services.model.BookingStatus> getBookingHistory(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBookingHistory(userId);
	}

	public static java.util.List<com.services.model.BookingStatus> getByUserAndTripStatus(
		long userId, java.lang.String tripStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByUserAndTripStatus(userId, tripStatus);
	}

	public static void clearService() {
		_service = null;
	}

	public static BookingStatusLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BookingStatusLocalService.class.getName());

			if (invokableLocalService instanceof BookingStatusLocalService) {
				_service = (BookingStatusLocalService)invokableLocalService;
			}
			else {
				_service = new BookingStatusLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BookingStatusLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BookingStatusLocalService service) {
	}

	private static BookingStatusLocalService _service;
}