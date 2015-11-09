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

package com.services.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.services.model.BusRoute;

import com.services.service.BusRouteLocalService;
import com.services.service.persistence.AgencyPersistence;
import com.services.service.persistence.BookingStatusPersistence;
import com.services.service.persistence.BusEmployeePersistence;
import com.services.service.persistence.BusPersistence;
import com.services.service.persistence.BusReservationPersistence;
import com.services.service.persistence.BusRoutePersistence;
import com.services.service.persistence.BusRouteTimingsPersistence;
import com.services.service.persistence.CouponPersistence;
import com.services.service.persistence.LocationPersistence;
import com.services.service.persistence.UserCouponPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the bus route local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.services.service.impl.BusRouteLocalServiceImpl}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see com.services.service.impl.BusRouteLocalServiceImpl
 * @see com.services.service.BusRouteLocalServiceUtil
 * @generated
 */
public abstract class BusRouteLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements BusRouteLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.services.service.BusRouteLocalServiceUtil} to access the bus route local service.
	 */

	/**
	 * Adds the bus route to the database. Also notifies the appropriate model listeners.
	 *
	 * @param busRoute the bus route
	 * @return the bus route that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public BusRoute addBusRoute(BusRoute busRoute) throws SystemException {
		busRoute.setNew(true);

		return busRoutePersistence.update(busRoute);
	}

	/**
	 * Creates a new bus route with the primary key. Does not add the bus route to the database.
	 *
	 * @param brId the primary key for the new bus route
	 * @return the new bus route
	 */
	@Override
	public BusRoute createBusRoute(long brId) {
		return busRoutePersistence.create(brId);
	}

	/**
	 * Deletes the bus route with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param brId the primary key of the bus route
	 * @return the bus route that was removed
	 * @throws PortalException if a bus route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public BusRoute deleteBusRoute(long brId)
		throws PortalException, SystemException {
		return busRoutePersistence.remove(brId);
	}

	/**
	 * Deletes the bus route from the database. Also notifies the appropriate model listeners.
	 *
	 * @param busRoute the bus route
	 * @return the bus route that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public BusRoute deleteBusRoute(BusRoute busRoute) throws SystemException {
		return busRoutePersistence.remove(busRoute);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(BusRoute.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return busRoutePersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return busRoutePersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return busRoutePersistence.findWithDynamicQuery(dynamicQuery, start,
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return busRoutePersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return busRoutePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public BusRoute fetchBusRoute(long brId) throws SystemException {
		return busRoutePersistence.fetchByPrimaryKey(brId);
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
	public BusRoute getBusRoute(long brId)
		throws PortalException, SystemException {
		return busRoutePersistence.findByPrimaryKey(brId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return busRoutePersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<BusRoute> getBusRoutes(int start, int end)
		throws SystemException {
		return busRoutePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of bus routes.
	 *
	 * @return the number of bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getBusRoutesCount() throws SystemException {
		return busRoutePersistence.countAll();
	}

	/**
	 * Updates the bus route in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param busRoute the bus route
	 * @return the bus route that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public BusRoute updateBusRoute(BusRoute busRoute) throws SystemException {
		return busRoutePersistence.update(busRoute);
	}

	/**
	 * Returns the agency local service.
	 *
	 * @return the agency local service
	 */
	public com.services.service.AgencyLocalService getAgencyLocalService() {
		return agencyLocalService;
	}

	/**
	 * Sets the agency local service.
	 *
	 * @param agencyLocalService the agency local service
	 */
	public void setAgencyLocalService(
		com.services.service.AgencyLocalService agencyLocalService) {
		this.agencyLocalService = agencyLocalService;
	}

	/**
	 * Returns the agency persistence.
	 *
	 * @return the agency persistence
	 */
	public AgencyPersistence getAgencyPersistence() {
		return agencyPersistence;
	}

	/**
	 * Sets the agency persistence.
	 *
	 * @param agencyPersistence the agency persistence
	 */
	public void setAgencyPersistence(AgencyPersistence agencyPersistence) {
		this.agencyPersistence = agencyPersistence;
	}

	/**
	 * Returns the booking status local service.
	 *
	 * @return the booking status local service
	 */
	public com.services.service.BookingStatusLocalService getBookingStatusLocalService() {
		return bookingStatusLocalService;
	}

	/**
	 * Sets the booking status local service.
	 *
	 * @param bookingStatusLocalService the booking status local service
	 */
	public void setBookingStatusLocalService(
		com.services.service.BookingStatusLocalService bookingStatusLocalService) {
		this.bookingStatusLocalService = bookingStatusLocalService;
	}

	/**
	 * Returns the booking status remote service.
	 *
	 * @return the booking status remote service
	 */
	public com.services.service.BookingStatusService getBookingStatusService() {
		return bookingStatusService;
	}

	/**
	 * Sets the booking status remote service.
	 *
	 * @param bookingStatusService the booking status remote service
	 */
	public void setBookingStatusService(
		com.services.service.BookingStatusService bookingStatusService) {
		this.bookingStatusService = bookingStatusService;
	}

	/**
	 * Returns the booking status persistence.
	 *
	 * @return the booking status persistence
	 */
	public BookingStatusPersistence getBookingStatusPersistence() {
		return bookingStatusPersistence;
	}

	/**
	 * Sets the booking status persistence.
	 *
	 * @param bookingStatusPersistence the booking status persistence
	 */
	public void setBookingStatusPersistence(
		BookingStatusPersistence bookingStatusPersistence) {
		this.bookingStatusPersistence = bookingStatusPersistence;
	}

	/**
	 * Returns the bus local service.
	 *
	 * @return the bus local service
	 */
	public com.services.service.BusLocalService getBusLocalService() {
		return busLocalService;
	}

	/**
	 * Sets the bus local service.
	 *
	 * @param busLocalService the bus local service
	 */
	public void setBusLocalService(
		com.services.service.BusLocalService busLocalService) {
		this.busLocalService = busLocalService;
	}

	/**
	 * Returns the bus persistence.
	 *
	 * @return the bus persistence
	 */
	public BusPersistence getBusPersistence() {
		return busPersistence;
	}

	/**
	 * Sets the bus persistence.
	 *
	 * @param busPersistence the bus persistence
	 */
	public void setBusPersistence(BusPersistence busPersistence) {
		this.busPersistence = busPersistence;
	}

	/**
	 * Returns the bus employee local service.
	 *
	 * @return the bus employee local service
	 */
	public com.services.service.BusEmployeeLocalService getBusEmployeeLocalService() {
		return busEmployeeLocalService;
	}

	/**
	 * Sets the bus employee local service.
	 *
	 * @param busEmployeeLocalService the bus employee local service
	 */
	public void setBusEmployeeLocalService(
		com.services.service.BusEmployeeLocalService busEmployeeLocalService) {
		this.busEmployeeLocalService = busEmployeeLocalService;
	}

	/**
	 * Returns the bus employee persistence.
	 *
	 * @return the bus employee persistence
	 */
	public BusEmployeePersistence getBusEmployeePersistence() {
		return busEmployeePersistence;
	}

	/**
	 * Sets the bus employee persistence.
	 *
	 * @param busEmployeePersistence the bus employee persistence
	 */
	public void setBusEmployeePersistence(
		BusEmployeePersistence busEmployeePersistence) {
		this.busEmployeePersistence = busEmployeePersistence;
	}

	/**
	 * Returns the bus reservation local service.
	 *
	 * @return the bus reservation local service
	 */
	public com.services.service.BusReservationLocalService getBusReservationLocalService() {
		return busReservationLocalService;
	}

	/**
	 * Sets the bus reservation local service.
	 *
	 * @param busReservationLocalService the bus reservation local service
	 */
	public void setBusReservationLocalService(
		com.services.service.BusReservationLocalService busReservationLocalService) {
		this.busReservationLocalService = busReservationLocalService;
	}

	/**
	 * Returns the bus reservation persistence.
	 *
	 * @return the bus reservation persistence
	 */
	public BusReservationPersistence getBusReservationPersistence() {
		return busReservationPersistence;
	}

	/**
	 * Sets the bus reservation persistence.
	 *
	 * @param busReservationPersistence the bus reservation persistence
	 */
	public void setBusReservationPersistence(
		BusReservationPersistence busReservationPersistence) {
		this.busReservationPersistence = busReservationPersistence;
	}

	/**
	 * Returns the bus route local service.
	 *
	 * @return the bus route local service
	 */
	public com.services.service.BusRouteLocalService getBusRouteLocalService() {
		return busRouteLocalService;
	}

	/**
	 * Sets the bus route local service.
	 *
	 * @param busRouteLocalService the bus route local service
	 */
	public void setBusRouteLocalService(
		com.services.service.BusRouteLocalService busRouteLocalService) {
		this.busRouteLocalService = busRouteLocalService;
	}

	/**
	 * Returns the bus route persistence.
	 *
	 * @return the bus route persistence
	 */
	public BusRoutePersistence getBusRoutePersistence() {
		return busRoutePersistence;
	}

	/**
	 * Sets the bus route persistence.
	 *
	 * @param busRoutePersistence the bus route persistence
	 */
	public void setBusRoutePersistence(BusRoutePersistence busRoutePersistence) {
		this.busRoutePersistence = busRoutePersistence;
	}

	/**
	 * Returns the bus route timings local service.
	 *
	 * @return the bus route timings local service
	 */
	public com.services.service.BusRouteTimingsLocalService getBusRouteTimingsLocalService() {
		return busRouteTimingsLocalService;
	}

	/**
	 * Sets the bus route timings local service.
	 *
	 * @param busRouteTimingsLocalService the bus route timings local service
	 */
	public void setBusRouteTimingsLocalService(
		com.services.service.BusRouteTimingsLocalService busRouteTimingsLocalService) {
		this.busRouteTimingsLocalService = busRouteTimingsLocalService;
	}

	/**
	 * Returns the bus route timings remote service.
	 *
	 * @return the bus route timings remote service
	 */
	public com.services.service.BusRouteTimingsService getBusRouteTimingsService() {
		return busRouteTimingsService;
	}

	/**
	 * Sets the bus route timings remote service.
	 *
	 * @param busRouteTimingsService the bus route timings remote service
	 */
	public void setBusRouteTimingsService(
		com.services.service.BusRouteTimingsService busRouteTimingsService) {
		this.busRouteTimingsService = busRouteTimingsService;
	}

	/**
	 * Returns the bus route timings persistence.
	 *
	 * @return the bus route timings persistence
	 */
	public BusRouteTimingsPersistence getBusRouteTimingsPersistence() {
		return busRouteTimingsPersistence;
	}

	/**
	 * Sets the bus route timings persistence.
	 *
	 * @param busRouteTimingsPersistence the bus route timings persistence
	 */
	public void setBusRouteTimingsPersistence(
		BusRouteTimingsPersistence busRouteTimingsPersistence) {
		this.busRouteTimingsPersistence = busRouteTimingsPersistence;
	}

	/**
	 * Returns the coupon local service.
	 *
	 * @return the coupon local service
	 */
	public com.services.service.CouponLocalService getCouponLocalService() {
		return couponLocalService;
	}

	/**
	 * Sets the coupon local service.
	 *
	 * @param couponLocalService the coupon local service
	 */
	public void setCouponLocalService(
		com.services.service.CouponLocalService couponLocalService) {
		this.couponLocalService = couponLocalService;
	}

	/**
	 * Returns the coupon persistence.
	 *
	 * @return the coupon persistence
	 */
	public CouponPersistence getCouponPersistence() {
		return couponPersistence;
	}

	/**
	 * Sets the coupon persistence.
	 *
	 * @param couponPersistence the coupon persistence
	 */
	public void setCouponPersistence(CouponPersistence couponPersistence) {
		this.couponPersistence = couponPersistence;
	}

	/**
	 * Returns the location local service.
	 *
	 * @return the location local service
	 */
	public com.services.service.LocationLocalService getLocationLocalService() {
		return locationLocalService;
	}

	/**
	 * Sets the location local service.
	 *
	 * @param locationLocalService the location local service
	 */
	public void setLocationLocalService(
		com.services.service.LocationLocalService locationLocalService) {
		this.locationLocalService = locationLocalService;
	}

	/**
	 * Returns the location persistence.
	 *
	 * @return the location persistence
	 */
	public LocationPersistence getLocationPersistence() {
		return locationPersistence;
	}

	/**
	 * Sets the location persistence.
	 *
	 * @param locationPersistence the location persistence
	 */
	public void setLocationPersistence(LocationPersistence locationPersistence) {
		this.locationPersistence = locationPersistence;
	}

	/**
	 * Returns the user coupon local service.
	 *
	 * @return the user coupon local service
	 */
	public com.services.service.UserCouponLocalService getUserCouponLocalService() {
		return userCouponLocalService;
	}

	/**
	 * Sets the user coupon local service.
	 *
	 * @param userCouponLocalService the user coupon local service
	 */
	public void setUserCouponLocalService(
		com.services.service.UserCouponLocalService userCouponLocalService) {
		this.userCouponLocalService = userCouponLocalService;
	}

	/**
	 * Returns the user coupon persistence.
	 *
	 * @return the user coupon persistence
	 */
	public UserCouponPersistence getUserCouponPersistence() {
		return userCouponPersistence;
	}

	/**
	 * Sets the user coupon persistence.
	 *
	 * @param userCouponPersistence the user coupon persistence
	 */
	public void setUserCouponPersistence(
		UserCouponPersistence userCouponPersistence) {
		this.userCouponPersistence = userCouponPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.services.model.BusRoute",
			busRouteLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.services.model.BusRoute");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return BusRoute.class;
	}

	protected String getModelClassName() {
		return BusRoute.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = busRoutePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.services.service.AgencyLocalService.class)
	protected com.services.service.AgencyLocalService agencyLocalService;
	@BeanReference(type = AgencyPersistence.class)
	protected AgencyPersistence agencyPersistence;
	@BeanReference(type = com.services.service.BookingStatusLocalService.class)
	protected com.services.service.BookingStatusLocalService bookingStatusLocalService;
	@BeanReference(type = com.services.service.BookingStatusService.class)
	protected com.services.service.BookingStatusService bookingStatusService;
	@BeanReference(type = BookingStatusPersistence.class)
	protected BookingStatusPersistence bookingStatusPersistence;
	@BeanReference(type = com.services.service.BusLocalService.class)
	protected com.services.service.BusLocalService busLocalService;
	@BeanReference(type = BusPersistence.class)
	protected BusPersistence busPersistence;
	@BeanReference(type = com.services.service.BusEmployeeLocalService.class)
	protected com.services.service.BusEmployeeLocalService busEmployeeLocalService;
	@BeanReference(type = BusEmployeePersistence.class)
	protected BusEmployeePersistence busEmployeePersistence;
	@BeanReference(type = com.services.service.BusReservationLocalService.class)
	protected com.services.service.BusReservationLocalService busReservationLocalService;
	@BeanReference(type = BusReservationPersistence.class)
	protected BusReservationPersistence busReservationPersistence;
	@BeanReference(type = com.services.service.BusRouteLocalService.class)
	protected com.services.service.BusRouteLocalService busRouteLocalService;
	@BeanReference(type = BusRoutePersistence.class)
	protected BusRoutePersistence busRoutePersistence;
	@BeanReference(type = com.services.service.BusRouteTimingsLocalService.class)
	protected com.services.service.BusRouteTimingsLocalService busRouteTimingsLocalService;
	@BeanReference(type = com.services.service.BusRouteTimingsService.class)
	protected com.services.service.BusRouteTimingsService busRouteTimingsService;
	@BeanReference(type = BusRouteTimingsPersistence.class)
	protected BusRouteTimingsPersistence busRouteTimingsPersistence;
	@BeanReference(type = com.services.service.CouponLocalService.class)
	protected com.services.service.CouponLocalService couponLocalService;
	@BeanReference(type = CouponPersistence.class)
	protected CouponPersistence couponPersistence;
	@BeanReference(type = com.services.service.LocationLocalService.class)
	protected com.services.service.LocationLocalService locationLocalService;
	@BeanReference(type = LocationPersistence.class)
	protected LocationPersistence locationPersistence;
	@BeanReference(type = com.services.service.UserCouponLocalService.class)
	protected com.services.service.UserCouponLocalService userCouponLocalService;
	@BeanReference(type = UserCouponPersistence.class)
	protected UserCouponPersistence userCouponPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private BusRouteLocalServiceClpInvoker _clpInvoker = new BusRouteLocalServiceClpInvoker();
}