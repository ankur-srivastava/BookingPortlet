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
 * Provides a wrapper for {@link BusRouteTimingsLocalService}.
 *
 * @author Ankur Srivastava
 * @see BusRouteTimingsLocalService
 * @generated
 */
public class BusRouteTimingsLocalServiceWrapper
	implements BusRouteTimingsLocalService,
		ServiceWrapper<BusRouteTimingsLocalService> {
	public BusRouteTimingsLocalServiceWrapper(
		BusRouteTimingsLocalService busRouteTimingsLocalService) {
		_busRouteTimingsLocalService = busRouteTimingsLocalService;
	}

	/**
	* Adds the bus route timings to the database. Also notifies the appropriate model listeners.
	*
	* @param busRouteTimings the bus route timings
	* @return the bus route timings that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.BusRouteTimings addBusRouteTimings(
		com.services.model.BusRouteTimings busRouteTimings)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _busRouteTimingsLocalService.addBusRouteTimings(busRouteTimings);
	}

	/**
	* Creates a new bus route timings with the primary key. Does not add the bus route timings to the database.
	*
	* @param brtId the primary key for the new bus route timings
	* @return the new bus route timings
	*/
	@Override
	public com.services.model.BusRouteTimings createBusRouteTimings(long brtId) {
		return _busRouteTimingsLocalService.createBusRouteTimings(brtId);
	}

	/**
	* Deletes the bus route timings with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param brtId the primary key of the bus route timings
	* @return the bus route timings that was removed
	* @throws PortalException if a bus route timings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.BusRouteTimings deleteBusRouteTimings(long brtId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _busRouteTimingsLocalService.deleteBusRouteTimings(brtId);
	}

	/**
	* Deletes the bus route timings from the database. Also notifies the appropriate model listeners.
	*
	* @param busRouteTimings the bus route timings
	* @return the bus route timings that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.BusRouteTimings deleteBusRouteTimings(
		com.services.model.BusRouteTimings busRouteTimings)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _busRouteTimingsLocalService.deleteBusRouteTimings(busRouteTimings);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _busRouteTimingsLocalService.dynamicQuery();
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
		return _busRouteTimingsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteTimingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _busRouteTimingsLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteTimingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _busRouteTimingsLocalService.dynamicQuery(dynamicQuery, start,
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
		return _busRouteTimingsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _busRouteTimingsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.services.model.BusRouteTimings fetchBusRouteTimings(long brtId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _busRouteTimingsLocalService.fetchBusRouteTimings(brtId);
	}

	/**
	* Returns the bus route timings with the primary key.
	*
	* @param brtId the primary key of the bus route timings
	* @return the bus route timings
	* @throws PortalException if a bus route timings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.BusRouteTimings getBusRouteTimings(long brtId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _busRouteTimingsLocalService.getBusRouteTimings(brtId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _busRouteTimingsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the bus route timingses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteTimingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bus route timingses
	* @param end the upper bound of the range of bus route timingses (not inclusive)
	* @return the range of bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.services.model.BusRouteTimings> getBusRouteTimingses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _busRouteTimingsLocalService.getBusRouteTimingses(start, end);
	}

	/**
	* Returns the number of bus route timingses.
	*
	* @return the number of bus route timingses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBusRouteTimingsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _busRouteTimingsLocalService.getBusRouteTimingsesCount();
	}

	/**
	* Updates the bus route timings in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param busRouteTimings the bus route timings
	* @return the bus route timings that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.BusRouteTimings updateBusRouteTimings(
		com.services.model.BusRouteTimings busRouteTimings)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _busRouteTimingsLocalService.updateBusRouteTimings(busRouteTimings);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _busRouteTimingsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_busRouteTimingsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _busRouteTimingsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.services.model.BusRouteTimings> getAvailableBusBasedOnRouteAndDate(
		long brId, java.lang.String date) {
		return _busRouteTimingsLocalService.getAvailableBusBasedOnRouteAndDate(brId,
			date);
	}

	@Override
	public java.util.List<com.services.model.BusRouteTimings> getBusBasedOnRouteAndDate(
		java.lang.String date, java.lang.String fromLocation,
		java.lang.String toLocation) {
		return _busRouteTimingsLocalService.getBusBasedOnRouteAndDate(date,
			fromLocation, toLocation);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BusRouteTimingsLocalService getWrappedBusRouteTimingsLocalService() {
		return _busRouteTimingsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBusRouteTimingsLocalService(
		BusRouteTimingsLocalService busRouteTimingsLocalService) {
		_busRouteTimingsLocalService = busRouteTimingsLocalService;
	}

	@Override
	public BusRouteTimingsLocalService getWrappedService() {
		return _busRouteTimingsLocalService;
	}

	@Override
	public void setWrappedService(
		BusRouteTimingsLocalService busRouteTimingsLocalService) {
		_busRouteTimingsLocalService = busRouteTimingsLocalService;
	}

	private BusRouteTimingsLocalService _busRouteTimingsLocalService;
}