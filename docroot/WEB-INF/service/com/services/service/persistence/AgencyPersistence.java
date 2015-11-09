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

import com.services.model.Agency;

/**
 * The persistence interface for the agency service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see AgencyPersistenceImpl
 * @see AgencyUtil
 * @generated
 */
public interface AgencyPersistence extends BasePersistence<Agency> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AgencyUtil} to access the agency persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the agencies where owner = &#63;.
	*
	* @param owner the owner
	* @return the matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.Agency> findByOwner(
		java.lang.String owner)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the agencies where owner = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param owner the owner
	* @param start the lower bound of the range of agencies
	* @param end the upper bound of the range of agencies (not inclusive)
	* @return the range of matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.Agency> findByOwner(
		java.lang.String owner, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the agencies where owner = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param owner the owner
	* @param start the lower bound of the range of agencies
	* @param end the upper bound of the range of agencies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.Agency> findByOwner(
		java.lang.String owner, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first agency in the ordered set where owner = &#63;.
	*
	* @param owner the owner
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching agency
	* @throws com.services.NoSuchAgencyException if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.Agency findByOwner_First(java.lang.String owner,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAgencyException;

	/**
	* Returns the first agency in the ordered set where owner = &#63;.
	*
	* @param owner the owner
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.Agency fetchByOwner_First(
		java.lang.String owner,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last agency in the ordered set where owner = &#63;.
	*
	* @param owner the owner
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching agency
	* @throws com.services.NoSuchAgencyException if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.Agency findByOwner_Last(java.lang.String owner,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAgencyException;

	/**
	* Returns the last agency in the ordered set where owner = &#63;.
	*
	* @param owner the owner
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.Agency fetchByOwner_Last(java.lang.String owner,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the agencies before and after the current agency in the ordered set where owner = &#63;.
	*
	* @param agencyId the primary key of the current agency
	* @param owner the owner
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next agency
	* @throws com.services.NoSuchAgencyException if a agency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.Agency[] findByOwner_PrevAndNext(long agencyId,
		java.lang.String owner,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAgencyException;

	/**
	* Removes all the agencies where owner = &#63; from the database.
	*
	* @param owner the owner
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOwner(java.lang.String owner)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of agencies where owner = &#63;.
	*
	* @param owner the owner
	* @return the number of matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public int countByOwner(java.lang.String owner)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the agencies where active = &#63;.
	*
	* @param active the active
	* @return the matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.Agency> findByActive(
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the agencies where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of agencies
	* @param end the upper bound of the range of agencies (not inclusive)
	* @return the range of matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.Agency> findByActive(
		boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the agencies where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of agencies
	* @param end the upper bound of the range of agencies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.Agency> findByActive(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first agency in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching agency
	* @throws com.services.NoSuchAgencyException if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.Agency findByActive_First(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAgencyException;

	/**
	* Returns the first agency in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.Agency fetchByActive_First(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last agency in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching agency
	* @throws com.services.NoSuchAgencyException if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.Agency findByActive_Last(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAgencyException;

	/**
	* Returns the last agency in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching agency, or <code>null</code> if a matching agency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.Agency fetchByActive_Last(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the agencies before and after the current agency in the ordered set where active = &#63;.
	*
	* @param agencyId the primary key of the current agency
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next agency
	* @throws com.services.NoSuchAgencyException if a agency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.Agency[] findByActive_PrevAndNext(long agencyId,
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAgencyException;

	/**
	* Removes all the agencies where active = &#63; from the database.
	*
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public void removeByActive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of agencies where active = &#63;.
	*
	* @param active the active
	* @return the number of matching agencies
	* @throws SystemException if a system exception occurred
	*/
	public int countByActive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the agency in the entity cache if it is enabled.
	*
	* @param agency the agency
	*/
	public void cacheResult(com.services.model.Agency agency);

	/**
	* Caches the agencies in the entity cache if it is enabled.
	*
	* @param agencies the agencies
	*/
	public void cacheResult(java.util.List<com.services.model.Agency> agencies);

	/**
	* Creates a new agency with the primary key. Does not add the agency to the database.
	*
	* @param agencyId the primary key for the new agency
	* @return the new agency
	*/
	public com.services.model.Agency create(long agencyId);

	/**
	* Removes the agency with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param agencyId the primary key of the agency
	* @return the agency that was removed
	* @throws com.services.NoSuchAgencyException if a agency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.Agency remove(long agencyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAgencyException;

	public com.services.model.Agency updateImpl(
		com.services.model.Agency agency)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the agency with the primary key or throws a {@link com.services.NoSuchAgencyException} if it could not be found.
	*
	* @param agencyId the primary key of the agency
	* @return the agency
	* @throws com.services.NoSuchAgencyException if a agency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.Agency findByPrimaryKey(long agencyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAgencyException;

	/**
	* Returns the agency with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param agencyId the primary key of the agency
	* @return the agency, or <code>null</code> if a agency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.Agency fetchByPrimaryKey(long agencyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the agencies.
	*
	* @return the agencies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.Agency> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the agencies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of agencies
	* @param end the upper bound of the range of agencies (not inclusive)
	* @return the range of agencies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.Agency> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the agencies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of agencies
	* @param end the upper bound of the range of agencies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of agencies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.Agency> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the agencies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of agencies.
	*
	* @return the number of agencies
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}