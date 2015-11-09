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
 * Provides a wrapper for {@link BookingStatusLocalService}.
 *
 * @author Ankur Srivastava
 * @see BookingStatusLocalService
 * @generated
 */
public class BookingStatusLocalServiceWrapper
	implements BookingStatusLocalService,
		ServiceWrapper<BookingStatusLocalService> {
	public BookingStatusLocalServiceWrapper(
		BookingStatusLocalService bookingStatusLocalService) {
		_bookingStatusLocalService = bookingStatusLocalService;
	}

	/**
	* Adds the booking status to the database. Also notifies the appropriate model listeners.
	*
	* @param bookingStatus the booking status
	* @return the booking status that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.BookingStatus addBookingStatus(
		com.services.model.BookingStatus bookingStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingStatusLocalService.addBookingStatus(bookingStatus);
	}

	/**
	* Creates a new booking status with the primary key. Does not add the booking status to the database.
	*
	* @param bsId the primary key for the new booking status
	* @return the new booking status
	*/
	@Override
	public com.services.model.BookingStatus createBookingStatus(long bsId) {
		return _bookingStatusLocalService.createBookingStatus(bsId);
	}

	/**
	* Deletes the booking status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bsId the primary key of the booking status
	* @return the booking status that was removed
	* @throws PortalException if a booking status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.BookingStatus deleteBookingStatus(long bsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookingStatusLocalService.deleteBookingStatus(bsId);
	}

	/**
	* Deletes the booking status from the database. Also notifies the appropriate model listeners.
	*
	* @param bookingStatus the booking status
	* @return the booking status that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.BookingStatus deleteBookingStatus(
		com.services.model.BookingStatus bookingStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingStatusLocalService.deleteBookingStatus(bookingStatus);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bookingStatusLocalService.dynamicQuery();
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
		return _bookingStatusLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingStatusLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingStatusLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _bookingStatusLocalService.dynamicQueryCount(dynamicQuery);
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
		return _bookingStatusLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.services.model.BookingStatus fetchBookingStatus(long bsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingStatusLocalService.fetchBookingStatus(bsId);
	}

	/**
	* Returns the booking status with the primary key.
	*
	* @param bsId the primary key of the booking status
	* @return the booking status
	* @throws PortalException if a booking status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.BookingStatus getBookingStatus(long bsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookingStatusLocalService.getBookingStatus(bsId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookingStatusLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.services.model.BookingStatus> getBookingStatuses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingStatusLocalService.getBookingStatuses(start, end);
	}

	/**
	* Returns the number of booking statuses.
	*
	* @return the number of booking statuses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBookingStatusesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingStatusLocalService.getBookingStatusesCount();
	}

	/**
	* Updates the booking status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bookingStatus the booking status
	* @return the booking status that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.BookingStatus updateBookingStatus(
		com.services.model.BookingStatus bookingStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingStatusLocalService.updateBookingStatus(bookingStatus);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _bookingStatusLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_bookingStatusLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _bookingStatusLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public boolean updateBooking(com.services.model.BookingStatus bookingStatus) {
		return _bookingStatusLocalService.updateBooking(bookingStatus);
	}

	@Override
	public boolean bookTicket(long brtId, long userId) {
		return _bookingStatusLocalService.bookTicket(brtId, userId);
	}

	@Override
	public java.util.List<com.services.model.BookingStatus> getBookingHistory(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingStatusLocalService.getBookingHistory(userId);
	}

	@Override
	public java.util.List<com.services.model.BookingStatus> getByUserAndTripStatus(
		long userId, java.lang.String tripStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingStatusLocalService.getByUserAndTripStatus(userId,
			tripStatus);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BookingStatusLocalService getWrappedBookingStatusLocalService() {
		return _bookingStatusLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBookingStatusLocalService(
		BookingStatusLocalService bookingStatusLocalService) {
		_bookingStatusLocalService = bookingStatusLocalService;
	}

	@Override
	public BookingStatusLocalService getWrappedService() {
		return _bookingStatusLocalService;
	}

	@Override
	public void setWrappedService(
		BookingStatusLocalService bookingStatusLocalService) {
		_bookingStatusLocalService = bookingStatusLocalService;
	}

	private BookingStatusLocalService _bookingStatusLocalService;
}