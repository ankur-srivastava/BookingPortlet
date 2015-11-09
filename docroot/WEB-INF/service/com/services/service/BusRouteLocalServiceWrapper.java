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
 * Provides a wrapper for {@link BusRouteLocalService}.
 *
 * @author Ankur Srivastava
 * @see BusRouteLocalService
 * @generated
 */
public class BusRouteLocalServiceWrapper implements BusRouteLocalService,
	ServiceWrapper<BusRouteLocalService> {
	public BusRouteLocalServiceWrapper(
		BusRouteLocalService busRouteLocalService) {
		_busRouteLocalService = busRouteLocalService;
	}

	/**
	* Adds the bus route to the database. Also notifies the appropriate model listeners.
	*
	* @param busRoute the bus route
	* @return the bus route that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.BusRoute addBusRoute(
		com.services.model.BusRoute busRoute)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _busRouteLocalService.addBusRoute(busRoute);
	}

	/**
	* Creates a new bus route with the primary key. Does not add the bus route to the database.
	*
	* @param brId the primary key for the new bus route
	* @return the new bus route
	*/
	@Override
	public com.services.model.BusRoute createBusRoute(long brId) {
		return _busRouteLocalService.createBusRoute(brId);
	}

	/**
	* Deletes the bus route with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param brId the primary key of the bus route
	* @return the bus route that was removed
	* @throws PortalException if a bus route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.BusRoute deleteBusRoute(long brId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _busRouteLocalService.deleteBusRoute(brId);
	}

	/**
	* Deletes the bus route from the database. Also notifies the appropriate model listeners.
	*
	* @param busRoute the bus route
	* @return the bus route that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.BusRoute deleteBusRoute(
		com.services.model.BusRoute busRoute)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _busRouteLocalService.deleteBusRoute(busRoute);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _busRouteLocalService.dynamicQuery();
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
		return _busRouteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _busRouteLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _busRouteLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _busRouteLocalService.dynamicQueryCount(dynamicQuery);
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
		return _busRouteLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.services.model.BusRoute fetchBusRoute(long brId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _busRouteLocalService.fetchBusRoute(brId);
	}

	/**
	* Returns the bus route with the primary key.
	*
	* @param brId the primary key of the bus route
	* @return the bus route
	* @throws PortalException if a bus route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.BusRoute getBusRoute(long brId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _busRouteLocalService.getBusRoute(brId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _busRouteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the bus routes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bus routes
	* @param end the upper bound of the range of bus routes (not inclusive)
	* @return the range of bus routes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.services.model.BusRoute> getBusRoutes(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _busRouteLocalService.getBusRoutes(start, end);
	}

	/**
	* Returns the number of bus routes.
	*
	* @return the number of bus routes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBusRoutesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _busRouteLocalService.getBusRoutesCount();
	}

	/**
	* Updates the bus route in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param busRoute the bus route
	* @return the bus route that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.BusRoute updateBusRoute(
		com.services.model.BusRoute busRoute)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _busRouteLocalService.updateBusRoute(busRoute);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _busRouteLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_busRouteLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _busRouteLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.services.model.BusRoute> getBusRoutesByStartAndEndLocation(
		long startLoc, long endLoc) {
		return _busRouteLocalService.getBusRoutesByStartAndEndLocation(startLoc,
			endLoc);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BusRouteLocalService getWrappedBusRouteLocalService() {
		return _busRouteLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBusRouteLocalService(
		BusRouteLocalService busRouteLocalService) {
		_busRouteLocalService = busRouteLocalService;
	}

	@Override
	public BusRouteLocalService getWrappedService() {
		return _busRouteLocalService;
	}

	@Override
	public void setWrappedService(BusRouteLocalService busRouteLocalService) {
		_busRouteLocalService = busRouteLocalService;
	}

	private BusRouteLocalService _busRouteLocalService;
}