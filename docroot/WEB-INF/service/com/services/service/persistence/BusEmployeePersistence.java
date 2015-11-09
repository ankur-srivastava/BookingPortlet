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

import com.services.model.BusEmployee;

/**
 * The persistence interface for the bus employee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusEmployeePersistenceImpl
 * @see BusEmployeeUtil
 * @generated
 */
public interface BusEmployeePersistence extends BasePersistence<BusEmployee> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BusEmployeeUtil} to access the bus employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the bus employees where agency = &#63;.
	*
	* @param agency the agency
	* @return the matching bus employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusEmployee> findByAgency(
		long agency) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bus employees where agency = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusEmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param agency the agency
	* @param start the lower bound of the range of bus employees
	* @param end the upper bound of the range of bus employees (not inclusive)
	* @return the range of matching bus employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusEmployee> findByAgency(
		long agency, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bus employees where agency = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusEmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param agency the agency
	* @param start the lower bound of the range of bus employees
	* @param end the upper bound of the range of bus employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bus employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusEmployee> findByAgency(
		long agency, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bus employee in the ordered set where agency = &#63;.
	*
	* @param agency the agency
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus employee
	* @throws com.services.NoSuchBusEmployeeException if a matching bus employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusEmployee findByAgency_First(long agency,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusEmployeeException;

	/**
	* Returns the first bus employee in the ordered set where agency = &#63;.
	*
	* @param agency the agency
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus employee, or <code>null</code> if a matching bus employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusEmployee fetchByAgency_First(long agency,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bus employee in the ordered set where agency = &#63;.
	*
	* @param agency the agency
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus employee
	* @throws com.services.NoSuchBusEmployeeException if a matching bus employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusEmployee findByAgency_Last(long agency,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusEmployeeException;

	/**
	* Returns the last bus employee in the ordered set where agency = &#63;.
	*
	* @param agency the agency
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus employee, or <code>null</code> if a matching bus employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusEmployee fetchByAgency_Last(long agency,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bus employees before and after the current bus employee in the ordered set where agency = &#63;.
	*
	* @param beId the primary key of the current bus employee
	* @param agency the agency
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bus employee
	* @throws com.services.NoSuchBusEmployeeException if a bus employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusEmployee[] findByAgency_PrevAndNext(
		long beId, long agency,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusEmployeeException;

	/**
	* Removes all the bus employees where agency = &#63; from the database.
	*
	* @param agency the agency
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAgency(long agency)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bus employees where agency = &#63;.
	*
	* @param agency the agency
	* @return the number of matching bus employees
	* @throws SystemException if a system exception occurred
	*/
	public int countByAgency(long agency)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bus employees where active = &#63;.
	*
	* @param active the active
	* @return the matching bus employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusEmployee> findByActive(
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bus employees where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusEmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of bus employees
	* @param end the upper bound of the range of bus employees (not inclusive)
	* @return the range of matching bus employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusEmployee> findByActive(
		boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bus employees where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusEmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of bus employees
	* @param end the upper bound of the range of bus employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bus employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusEmployee> findByActive(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bus employee in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus employee
	* @throws com.services.NoSuchBusEmployeeException if a matching bus employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusEmployee findByActive_First(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusEmployeeException;

	/**
	* Returns the first bus employee in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bus employee, or <code>null</code> if a matching bus employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusEmployee fetchByActive_First(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bus employee in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus employee
	* @throws com.services.NoSuchBusEmployeeException if a matching bus employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusEmployee findByActive_Last(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusEmployeeException;

	/**
	* Returns the last bus employee in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bus employee, or <code>null</code> if a matching bus employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusEmployee fetchByActive_Last(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bus employees before and after the current bus employee in the ordered set where active = &#63;.
	*
	* @param beId the primary key of the current bus employee
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bus employee
	* @throws com.services.NoSuchBusEmployeeException if a bus employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusEmployee[] findByActive_PrevAndNext(
		long beId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusEmployeeException;

	/**
	* Removes all the bus employees where active = &#63; from the database.
	*
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public void removeByActive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bus employees where active = &#63;.
	*
	* @param active the active
	* @return the number of matching bus employees
	* @throws SystemException if a system exception occurred
	*/
	public int countByActive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bus employee in the entity cache if it is enabled.
	*
	* @param busEmployee the bus employee
	*/
	public void cacheResult(com.services.model.BusEmployee busEmployee);

	/**
	* Caches the bus employees in the entity cache if it is enabled.
	*
	* @param busEmployees the bus employees
	*/
	public void cacheResult(
		java.util.List<com.services.model.BusEmployee> busEmployees);

	/**
	* Creates a new bus employee with the primary key. Does not add the bus employee to the database.
	*
	* @param beId the primary key for the new bus employee
	* @return the new bus employee
	*/
	public com.services.model.BusEmployee create(long beId);

	/**
	* Removes the bus employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param beId the primary key of the bus employee
	* @return the bus employee that was removed
	* @throws com.services.NoSuchBusEmployeeException if a bus employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusEmployee remove(long beId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusEmployeeException;

	public com.services.model.BusEmployee updateImpl(
		com.services.model.BusEmployee busEmployee)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bus employee with the primary key or throws a {@link com.services.NoSuchBusEmployeeException} if it could not be found.
	*
	* @param beId the primary key of the bus employee
	* @return the bus employee
	* @throws com.services.NoSuchBusEmployeeException if a bus employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusEmployee findByPrimaryKey(long beId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchBusEmployeeException;

	/**
	* Returns the bus employee with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param beId the primary key of the bus employee
	* @return the bus employee, or <code>null</code> if a bus employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.BusEmployee fetchByPrimaryKey(long beId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bus employees.
	*
	* @return the bus employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusEmployee> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bus employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusEmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bus employees
	* @param end the upper bound of the range of bus employees (not inclusive)
	* @return the range of bus employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusEmployee> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bus employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusEmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bus employees
	* @param end the upper bound of the range of bus employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bus employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.BusEmployee> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bus employees from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bus employees.
	*
	* @return the number of bus employees
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}