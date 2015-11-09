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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.services.NoSuchLocationException;

import com.services.model.Location;
import com.services.model.impl.LocationImpl;
import com.services.model.impl.LocationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the location service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see LocationPersistence
 * @see LocationUtil
 * @generated
 */
public class LocationPersistenceImpl extends BasePersistenceImpl<Location>
	implements LocationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LocationUtil} to access the location persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LocationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationModelImpl.FINDER_CACHE_ENABLED, LocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationModelImpl.FINDER_CACHE_ENABLED, LocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCATIONNAME =
		new FinderPath(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationModelImpl.FINDER_CACHE_ENABLED, LocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLocationName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONNAME =
		new FinderPath(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationModelImpl.FINDER_CACHE_ENABLED, LocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLocationName",
			new String[] { String.class.getName() },
			LocationModelImpl.LOCATIONNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOCATIONNAME = new FinderPath(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLocationName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the locations where locationName = &#63;.
	 *
	 * @param locationName the location name
	 * @return the matching locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Location> findByLocationName(String locationName)
		throws SystemException {
		return findByLocationName(locationName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the locations where locationName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param locationName the location name
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @return the range of matching locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Location> findByLocationName(String locationName, int start,
		int end) throws SystemException {
		return findByLocationName(locationName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the locations where locationName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param locationName the location name
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Location> findByLocationName(String locationName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONNAME;
			finderArgs = new Object[] { locationName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCATIONNAME;
			finderArgs = new Object[] {
					locationName,
					
					start, end, orderByComparator
				};
		}

		List<Location> list = (List<Location>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Location location : list) {
				if (!Validator.equals(locationName, location.getLocationName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LOCATION_WHERE);

			boolean bindLocationName = false;

			if (locationName == null) {
				query.append(_FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_1);
			}
			else if (locationName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_3);
			}
			else {
				bindLocationName = true;

				query.append(_FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LocationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLocationName) {
					qPos.add(locationName);
				}

				if (!pagination) {
					list = (List<Location>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Location>(list);
				}
				else {
					list = (List<Location>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first location in the ordered set where locationName = &#63;.
	 *
	 * @param locationName the location name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching location
	 * @throws com.services.NoSuchLocationException if a matching location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location findByLocationName_First(String locationName,
		OrderByComparator orderByComparator)
		throws NoSuchLocationException, SystemException {
		Location location = fetchByLocationName_First(locationName,
				orderByComparator);

		if (location != null) {
			return location;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("locationName=");
		msg.append(locationName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLocationException(msg.toString());
	}

	/**
	 * Returns the first location in the ordered set where locationName = &#63;.
	 *
	 * @param locationName the location name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching location, or <code>null</code> if a matching location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location fetchByLocationName_First(String locationName,
		OrderByComparator orderByComparator) throws SystemException {
		List<Location> list = findByLocationName(locationName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last location in the ordered set where locationName = &#63;.
	 *
	 * @param locationName the location name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching location
	 * @throws com.services.NoSuchLocationException if a matching location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location findByLocationName_Last(String locationName,
		OrderByComparator orderByComparator)
		throws NoSuchLocationException, SystemException {
		Location location = fetchByLocationName_Last(locationName,
				orderByComparator);

		if (location != null) {
			return location;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("locationName=");
		msg.append(locationName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLocationException(msg.toString());
	}

	/**
	 * Returns the last location in the ordered set where locationName = &#63;.
	 *
	 * @param locationName the location name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching location, or <code>null</code> if a matching location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location fetchByLocationName_Last(String locationName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLocationName(locationName);

		if (count == 0) {
			return null;
		}

		List<Location> list = findByLocationName(locationName, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the locations before and after the current location in the ordered set where locationName = &#63;.
	 *
	 * @param locationId the primary key of the current location
	 * @param locationName the location name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next location
	 * @throws com.services.NoSuchLocationException if a location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location[] findByLocationName_PrevAndNext(long locationId,
		String locationName, OrderByComparator orderByComparator)
		throws NoSuchLocationException, SystemException {
		Location location = findByPrimaryKey(locationId);

		Session session = null;

		try {
			session = openSession();

			Location[] array = new LocationImpl[3];

			array[0] = getByLocationName_PrevAndNext(session, location,
					locationName, orderByComparator, true);

			array[1] = location;

			array[2] = getByLocationName_PrevAndNext(session, location,
					locationName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Location getByLocationName_PrevAndNext(Session session,
		Location location, String locationName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOCATION_WHERE);

		boolean bindLocationName = false;

		if (locationName == null) {
			query.append(_FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_1);
		}
		else if (locationName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_3);
		}
		else {
			bindLocationName = true;

			query.append(_FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LocationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLocationName) {
			qPos.add(locationName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(location);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Location> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the locations where locationName = &#63; from the database.
	 *
	 * @param locationName the location name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLocationName(String locationName)
		throws SystemException {
		for (Location location : findByLocationName(locationName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(location);
		}
	}

	/**
	 * Returns the number of locations where locationName = &#63;.
	 *
	 * @param locationName the location name
	 * @return the number of matching locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLocationName(String locationName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LOCATIONNAME;

		Object[] finderArgs = new Object[] { locationName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOCATION_WHERE);

			boolean bindLocationName = false;

			if (locationName == null) {
				query.append(_FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_1);
			}
			else if (locationName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_3);
			}
			else {
				bindLocationName = true;

				query.append(_FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLocationName) {
					qPos.add(locationName);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_1 = "location.locationName IS NULL";
	private static final String _FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_2 = "location.locationName = ?";
	private static final String _FINDER_COLUMN_LOCATIONNAME_LOCATIONNAME_3 = "(location.locationName IS NULL OR location.locationName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCATIONCITYNAME =
		new FinderPath(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationModelImpl.FINDER_CACHE_ENABLED, LocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLocationCityName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONCITYNAME =
		new FinderPath(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationModelImpl.FINDER_CACHE_ENABLED, LocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByLocationCityName", new String[] { String.class.getName() },
			LocationModelImpl.LOCATIONCITYNAME_COLUMN_BITMASK |
			LocationModelImpl.LOCATIONNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOCATIONCITYNAME = new FinderPath(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLocationCityName", new String[] { String.class.getName() });

	/**
	 * Returns all the locations where locationCityName = &#63;.
	 *
	 * @param locationCityName the location city name
	 * @return the matching locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Location> findByLocationCityName(String locationCityName)
		throws SystemException {
		return findByLocationCityName(locationCityName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the locations where locationCityName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param locationCityName the location city name
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @return the range of matching locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Location> findByLocationCityName(String locationCityName,
		int start, int end) throws SystemException {
		return findByLocationCityName(locationCityName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the locations where locationCityName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param locationCityName the location city name
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Location> findByLocationCityName(String locationCityName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONCITYNAME;
			finderArgs = new Object[] { locationCityName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCATIONCITYNAME;
			finderArgs = new Object[] {
					locationCityName,
					
					start, end, orderByComparator
				};
		}

		List<Location> list = (List<Location>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Location location : list) {
				if (!Validator.equals(locationCityName,
							location.getLocationCityName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LOCATION_WHERE);

			boolean bindLocationCityName = false;

			if (locationCityName == null) {
				query.append(_FINDER_COLUMN_LOCATIONCITYNAME_LOCATIONCITYNAME_1);
			}
			else if (locationCityName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LOCATIONCITYNAME_LOCATIONCITYNAME_3);
			}
			else {
				bindLocationCityName = true;

				query.append(_FINDER_COLUMN_LOCATIONCITYNAME_LOCATIONCITYNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LocationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLocationCityName) {
					qPos.add(locationCityName);
				}

				if (!pagination) {
					list = (List<Location>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Location>(list);
				}
				else {
					list = (List<Location>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first location in the ordered set where locationCityName = &#63;.
	 *
	 * @param locationCityName the location city name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching location
	 * @throws com.services.NoSuchLocationException if a matching location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location findByLocationCityName_First(String locationCityName,
		OrderByComparator orderByComparator)
		throws NoSuchLocationException, SystemException {
		Location location = fetchByLocationCityName_First(locationCityName,
				orderByComparator);

		if (location != null) {
			return location;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("locationCityName=");
		msg.append(locationCityName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLocationException(msg.toString());
	}

	/**
	 * Returns the first location in the ordered set where locationCityName = &#63;.
	 *
	 * @param locationCityName the location city name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching location, or <code>null</code> if a matching location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location fetchByLocationCityName_First(String locationCityName,
		OrderByComparator orderByComparator) throws SystemException {
		List<Location> list = findByLocationCityName(locationCityName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last location in the ordered set where locationCityName = &#63;.
	 *
	 * @param locationCityName the location city name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching location
	 * @throws com.services.NoSuchLocationException if a matching location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location findByLocationCityName_Last(String locationCityName,
		OrderByComparator orderByComparator)
		throws NoSuchLocationException, SystemException {
		Location location = fetchByLocationCityName_Last(locationCityName,
				orderByComparator);

		if (location != null) {
			return location;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("locationCityName=");
		msg.append(locationCityName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLocationException(msg.toString());
	}

	/**
	 * Returns the last location in the ordered set where locationCityName = &#63;.
	 *
	 * @param locationCityName the location city name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching location, or <code>null</code> if a matching location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location fetchByLocationCityName_Last(String locationCityName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLocationCityName(locationCityName);

		if (count == 0) {
			return null;
		}

		List<Location> list = findByLocationCityName(locationCityName,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the locations before and after the current location in the ordered set where locationCityName = &#63;.
	 *
	 * @param locationId the primary key of the current location
	 * @param locationCityName the location city name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next location
	 * @throws com.services.NoSuchLocationException if a location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location[] findByLocationCityName_PrevAndNext(long locationId,
		String locationCityName, OrderByComparator orderByComparator)
		throws NoSuchLocationException, SystemException {
		Location location = findByPrimaryKey(locationId);

		Session session = null;

		try {
			session = openSession();

			Location[] array = new LocationImpl[3];

			array[0] = getByLocationCityName_PrevAndNext(session, location,
					locationCityName, orderByComparator, true);

			array[1] = location;

			array[2] = getByLocationCityName_PrevAndNext(session, location,
					locationCityName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Location getByLocationCityName_PrevAndNext(Session session,
		Location location, String locationCityName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOCATION_WHERE);

		boolean bindLocationCityName = false;

		if (locationCityName == null) {
			query.append(_FINDER_COLUMN_LOCATIONCITYNAME_LOCATIONCITYNAME_1);
		}
		else if (locationCityName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LOCATIONCITYNAME_LOCATIONCITYNAME_3);
		}
		else {
			bindLocationCityName = true;

			query.append(_FINDER_COLUMN_LOCATIONCITYNAME_LOCATIONCITYNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LocationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLocationCityName) {
			qPos.add(locationCityName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(location);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Location> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the locations where locationCityName = &#63; from the database.
	 *
	 * @param locationCityName the location city name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLocationCityName(String locationCityName)
		throws SystemException {
		for (Location location : findByLocationCityName(locationCityName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(location);
		}
	}

	/**
	 * Returns the number of locations where locationCityName = &#63;.
	 *
	 * @param locationCityName the location city name
	 * @return the number of matching locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLocationCityName(String locationCityName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LOCATIONCITYNAME;

		Object[] finderArgs = new Object[] { locationCityName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOCATION_WHERE);

			boolean bindLocationCityName = false;

			if (locationCityName == null) {
				query.append(_FINDER_COLUMN_LOCATIONCITYNAME_LOCATIONCITYNAME_1);
			}
			else if (locationCityName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LOCATIONCITYNAME_LOCATIONCITYNAME_3);
			}
			else {
				bindLocationCityName = true;

				query.append(_FINDER_COLUMN_LOCATIONCITYNAME_LOCATIONCITYNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLocationCityName) {
					qPos.add(locationCityName);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LOCATIONCITYNAME_LOCATIONCITYNAME_1 =
		"location.locationCityName IS NULL";
	private static final String _FINDER_COLUMN_LOCATIONCITYNAME_LOCATIONCITYNAME_2 =
		"location.locationCityName = ?";
	private static final String _FINDER_COLUMN_LOCATIONCITYNAME_LOCATIONCITYNAME_3 =
		"(location.locationCityName IS NULL OR location.locationCityName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCATIONZIP =
		new FinderPath(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationModelImpl.FINDER_CACHE_ENABLED, LocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLocationZip",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONZIP =
		new FinderPath(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationModelImpl.FINDER_CACHE_ENABLED, LocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLocationZip",
			new String[] { String.class.getName() },
			LocationModelImpl.LOCATIONZIP_COLUMN_BITMASK |
			LocationModelImpl.LOCATIONNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOCATIONZIP = new FinderPath(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLocationZip",
			new String[] { String.class.getName() });

	/**
	 * Returns all the locations where locationZip = &#63;.
	 *
	 * @param locationZip the location zip
	 * @return the matching locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Location> findByLocationZip(String locationZip)
		throws SystemException {
		return findByLocationZip(locationZip, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the locations where locationZip = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param locationZip the location zip
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @return the range of matching locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Location> findByLocationZip(String locationZip, int start,
		int end) throws SystemException {
		return findByLocationZip(locationZip, start, end, null);
	}

	/**
	 * Returns an ordered range of all the locations where locationZip = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param locationZip the location zip
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Location> findByLocationZip(String locationZip, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONZIP;
			finderArgs = new Object[] { locationZip };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCATIONZIP;
			finderArgs = new Object[] { locationZip, start, end, orderByComparator };
		}

		List<Location> list = (List<Location>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Location location : list) {
				if (!Validator.equals(locationZip, location.getLocationZip())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LOCATION_WHERE);

			boolean bindLocationZip = false;

			if (locationZip == null) {
				query.append(_FINDER_COLUMN_LOCATIONZIP_LOCATIONZIP_1);
			}
			else if (locationZip.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LOCATIONZIP_LOCATIONZIP_3);
			}
			else {
				bindLocationZip = true;

				query.append(_FINDER_COLUMN_LOCATIONZIP_LOCATIONZIP_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LocationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLocationZip) {
					qPos.add(locationZip);
				}

				if (!pagination) {
					list = (List<Location>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Location>(list);
				}
				else {
					list = (List<Location>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first location in the ordered set where locationZip = &#63;.
	 *
	 * @param locationZip the location zip
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching location
	 * @throws com.services.NoSuchLocationException if a matching location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location findByLocationZip_First(String locationZip,
		OrderByComparator orderByComparator)
		throws NoSuchLocationException, SystemException {
		Location location = fetchByLocationZip_First(locationZip,
				orderByComparator);

		if (location != null) {
			return location;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("locationZip=");
		msg.append(locationZip);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLocationException(msg.toString());
	}

	/**
	 * Returns the first location in the ordered set where locationZip = &#63;.
	 *
	 * @param locationZip the location zip
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching location, or <code>null</code> if a matching location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location fetchByLocationZip_First(String locationZip,
		OrderByComparator orderByComparator) throws SystemException {
		List<Location> list = findByLocationZip(locationZip, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last location in the ordered set where locationZip = &#63;.
	 *
	 * @param locationZip the location zip
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching location
	 * @throws com.services.NoSuchLocationException if a matching location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location findByLocationZip_Last(String locationZip,
		OrderByComparator orderByComparator)
		throws NoSuchLocationException, SystemException {
		Location location = fetchByLocationZip_Last(locationZip,
				orderByComparator);

		if (location != null) {
			return location;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("locationZip=");
		msg.append(locationZip);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLocationException(msg.toString());
	}

	/**
	 * Returns the last location in the ordered set where locationZip = &#63;.
	 *
	 * @param locationZip the location zip
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching location, or <code>null</code> if a matching location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location fetchByLocationZip_Last(String locationZip,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLocationZip(locationZip);

		if (count == 0) {
			return null;
		}

		List<Location> list = findByLocationZip(locationZip, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the locations before and after the current location in the ordered set where locationZip = &#63;.
	 *
	 * @param locationId the primary key of the current location
	 * @param locationZip the location zip
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next location
	 * @throws com.services.NoSuchLocationException if a location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location[] findByLocationZip_PrevAndNext(long locationId,
		String locationZip, OrderByComparator orderByComparator)
		throws NoSuchLocationException, SystemException {
		Location location = findByPrimaryKey(locationId);

		Session session = null;

		try {
			session = openSession();

			Location[] array = new LocationImpl[3];

			array[0] = getByLocationZip_PrevAndNext(session, location,
					locationZip, orderByComparator, true);

			array[1] = location;

			array[2] = getByLocationZip_PrevAndNext(session, location,
					locationZip, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Location getByLocationZip_PrevAndNext(Session session,
		Location location, String locationZip,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOCATION_WHERE);

		boolean bindLocationZip = false;

		if (locationZip == null) {
			query.append(_FINDER_COLUMN_LOCATIONZIP_LOCATIONZIP_1);
		}
		else if (locationZip.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LOCATIONZIP_LOCATIONZIP_3);
		}
		else {
			bindLocationZip = true;

			query.append(_FINDER_COLUMN_LOCATIONZIP_LOCATIONZIP_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LocationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLocationZip) {
			qPos.add(locationZip);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(location);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Location> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the locations where locationZip = &#63; from the database.
	 *
	 * @param locationZip the location zip
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLocationZip(String locationZip)
		throws SystemException {
		for (Location location : findByLocationZip(locationZip,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(location);
		}
	}

	/**
	 * Returns the number of locations where locationZip = &#63;.
	 *
	 * @param locationZip the location zip
	 * @return the number of matching locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLocationZip(String locationZip) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LOCATIONZIP;

		Object[] finderArgs = new Object[] { locationZip };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOCATION_WHERE);

			boolean bindLocationZip = false;

			if (locationZip == null) {
				query.append(_FINDER_COLUMN_LOCATIONZIP_LOCATIONZIP_1);
			}
			else if (locationZip.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LOCATIONZIP_LOCATIONZIP_3);
			}
			else {
				bindLocationZip = true;

				query.append(_FINDER_COLUMN_LOCATIONZIP_LOCATIONZIP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLocationZip) {
					qPos.add(locationZip);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LOCATIONZIP_LOCATIONZIP_1 = "location.locationZip IS NULL";
	private static final String _FINDER_COLUMN_LOCATIONZIP_LOCATIONZIP_2 = "location.locationZip = ?";
	private static final String _FINDER_COLUMN_LOCATIONZIP_LOCATIONZIP_3 = "(location.locationZip IS NULL OR location.locationZip = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVELOCATIONS =
		new FinderPath(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationModelImpl.FINDER_CACHE_ENABLED, LocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActiveLocations",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVELOCATIONS =
		new FinderPath(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationModelImpl.FINDER_CACHE_ENABLED, LocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActiveLocations",
			new String[] { Boolean.class.getName() },
			LocationModelImpl.ACTIVE_COLUMN_BITMASK |
			LocationModelImpl.LOCATIONNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVELOCATIONS = new FinderPath(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByActiveLocations", new String[] { Boolean.class.getName() });

	/**
	 * Returns all the locations where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Location> findByActiveLocations(boolean active)
		throws SystemException {
		return findByActiveLocations(active, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the locations where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @return the range of matching locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Location> findByActiveLocations(boolean active, int start,
		int end) throws SystemException {
		return findByActiveLocations(active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the locations where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Location> findByActiveLocations(boolean active, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVELOCATIONS;
			finderArgs = new Object[] { active };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVELOCATIONS;
			finderArgs = new Object[] { active, start, end, orderByComparator };
		}

		List<Location> list = (List<Location>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Location location : list) {
				if ((active != location.getActive())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LOCATION_WHERE);

			query.append(_FINDER_COLUMN_ACTIVELOCATIONS_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LocationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				if (!pagination) {
					list = (List<Location>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Location>(list);
				}
				else {
					list = (List<Location>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first location in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching location
	 * @throws com.services.NoSuchLocationException if a matching location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location findByActiveLocations_First(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchLocationException, SystemException {
		Location location = fetchByActiveLocations_First(active,
				orderByComparator);

		if (location != null) {
			return location;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLocationException(msg.toString());
	}

	/**
	 * Returns the first location in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching location, or <code>null</code> if a matching location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location fetchByActiveLocations_First(boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		List<Location> list = findByActiveLocations(active, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last location in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching location
	 * @throws com.services.NoSuchLocationException if a matching location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location findByActiveLocations_Last(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchLocationException, SystemException {
		Location location = fetchByActiveLocations_Last(active,
				orderByComparator);

		if (location != null) {
			return location;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLocationException(msg.toString());
	}

	/**
	 * Returns the last location in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching location, or <code>null</code> if a matching location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location fetchByActiveLocations_Last(boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByActiveLocations(active);

		if (count == 0) {
			return null;
		}

		List<Location> list = findByActiveLocations(active, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the locations before and after the current location in the ordered set where active = &#63;.
	 *
	 * @param locationId the primary key of the current location
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next location
	 * @throws com.services.NoSuchLocationException if a location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location[] findByActiveLocations_PrevAndNext(long locationId,
		boolean active, OrderByComparator orderByComparator)
		throws NoSuchLocationException, SystemException {
		Location location = findByPrimaryKey(locationId);

		Session session = null;

		try {
			session = openSession();

			Location[] array = new LocationImpl[3];

			array[0] = getByActiveLocations_PrevAndNext(session, location,
					active, orderByComparator, true);

			array[1] = location;

			array[2] = getByActiveLocations_PrevAndNext(session, location,
					active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Location getByActiveLocations_PrevAndNext(Session session,
		Location location, boolean active, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOCATION_WHERE);

		query.append(_FINDER_COLUMN_ACTIVELOCATIONS_ACTIVE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LocationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(location);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Location> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the locations where active = &#63; from the database.
	 *
	 * @param active the active
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByActiveLocations(boolean active)
		throws SystemException {
		for (Location location : findByActiveLocations(active,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(location);
		}
	}

	/**
	 * Returns the number of locations where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByActiveLocations(boolean active) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTIVELOCATIONS;

		Object[] finderArgs = new Object[] { active };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOCATION_WHERE);

			query.append(_FINDER_COLUMN_ACTIVELOCATIONS_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ACTIVELOCATIONS_ACTIVE_2 = "location.active = ?";

	public LocationPersistenceImpl() {
		setModelClass(Location.class);
	}

	/**
	 * Caches the location in the entity cache if it is enabled.
	 *
	 * @param location the location
	 */
	@Override
	public void cacheResult(Location location) {
		EntityCacheUtil.putResult(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationImpl.class, location.getPrimaryKey(), location);

		location.resetOriginalValues();
	}

	/**
	 * Caches the locations in the entity cache if it is enabled.
	 *
	 * @param locations the locations
	 */
	@Override
	public void cacheResult(List<Location> locations) {
		for (Location location : locations) {
			if (EntityCacheUtil.getResult(
						LocationModelImpl.ENTITY_CACHE_ENABLED,
						LocationImpl.class, location.getPrimaryKey()) == null) {
				cacheResult(location);
			}
			else {
				location.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all locations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LocationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LocationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the location.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Location location) {
		EntityCacheUtil.removeResult(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationImpl.class, location.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Location> locations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Location location : locations) {
			EntityCacheUtil.removeResult(LocationModelImpl.ENTITY_CACHE_ENABLED,
				LocationImpl.class, location.getPrimaryKey());
		}
	}

	/**
	 * Creates a new location with the primary key. Does not add the location to the database.
	 *
	 * @param locationId the primary key for the new location
	 * @return the new location
	 */
	@Override
	public Location create(long locationId) {
		Location location = new LocationImpl();

		location.setNew(true);
		location.setPrimaryKey(locationId);

		return location;
	}

	/**
	 * Removes the location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param locationId the primary key of the location
	 * @return the location that was removed
	 * @throws com.services.NoSuchLocationException if a location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location remove(long locationId)
		throws NoSuchLocationException, SystemException {
		return remove((Serializable)locationId);
	}

	/**
	 * Removes the location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the location
	 * @return the location that was removed
	 * @throws com.services.NoSuchLocationException if a location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location remove(Serializable primaryKey)
		throws NoSuchLocationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Location location = (Location)session.get(LocationImpl.class,
					primaryKey);

			if (location == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLocationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(location);
		}
		catch (NoSuchLocationException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Location removeImpl(Location location) throws SystemException {
		location = toUnwrappedModel(location);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(location)) {
				location = (Location)session.get(LocationImpl.class,
						location.getPrimaryKeyObj());
			}

			if (location != null) {
				session.delete(location);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (location != null) {
			clearCache(location);
		}

		return location;
	}

	@Override
	public Location updateImpl(com.services.model.Location location)
		throws SystemException {
		location = toUnwrappedModel(location);

		boolean isNew = location.isNew();

		LocationModelImpl locationModelImpl = (LocationModelImpl)location;

		Session session = null;

		try {
			session = openSession();

			if (location.isNew()) {
				session.save(location);

				location.setNew(false);
			}
			else {
				session.merge(location);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LocationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((locationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						locationModelImpl.getOriginalLocationName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCATIONNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONNAME,
					args);

				args = new Object[] { locationModelImpl.getLocationName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCATIONNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONNAME,
					args);
			}

			if ((locationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONCITYNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						locationModelImpl.getOriginalLocationCityName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCATIONCITYNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONCITYNAME,
					args);

				args = new Object[] { locationModelImpl.getLocationCityName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCATIONCITYNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONCITYNAME,
					args);
			}

			if ((locationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONZIP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						locationModelImpl.getOriginalLocationZip()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCATIONZIP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONZIP,
					args);

				args = new Object[] { locationModelImpl.getLocationZip() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCATIONZIP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONZIP,
					args);
			}

			if ((locationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVELOCATIONS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						locationModelImpl.getOriginalActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVELOCATIONS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVELOCATIONS,
					args);

				args = new Object[] { locationModelImpl.getActive() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVELOCATIONS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVELOCATIONS,
					args);
			}
		}

		EntityCacheUtil.putResult(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationImpl.class, location.getPrimaryKey(), location);

		return location;
	}

	protected Location toUnwrappedModel(Location location) {
		if (location instanceof LocationImpl) {
			return location;
		}

		LocationImpl locationImpl = new LocationImpl();

		locationImpl.setNew(location.isNew());
		locationImpl.setPrimaryKey(location.getPrimaryKey());

		locationImpl.setLocationId(location.getLocationId());
		locationImpl.setLocationName(location.getLocationName());
		locationImpl.setStreetAddress1(location.getStreetAddress1());
		locationImpl.setStreetAddress2(location.getStreetAddress2());
		locationImpl.setLocationZip(location.getLocationZip());
		locationImpl.setLocationCityName(location.getLocationCityName());
		locationImpl.setLocationStateName(location.getLocationStateName());
		locationImpl.setLatitude(location.getLatitude());
		locationImpl.setLongitude(location.getLongitude());
		locationImpl.setComments(location.getComments());
		locationImpl.setActive(location.isActive());
		locationImpl.setCreateDate(location.getCreateDate());
		locationImpl.setModifiedDate(location.getModifiedDate());

		return locationImpl;
	}

	/**
	 * Returns the location with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the location
	 * @return the location
	 * @throws com.services.NoSuchLocationException if a location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLocationException, SystemException {
		Location location = fetchByPrimaryKey(primaryKey);

		if (location == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLocationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return location;
	}

	/**
	 * Returns the location with the primary key or throws a {@link com.services.NoSuchLocationException} if it could not be found.
	 *
	 * @param locationId the primary key of the location
	 * @return the location
	 * @throws com.services.NoSuchLocationException if a location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location findByPrimaryKey(long locationId)
		throws NoSuchLocationException, SystemException {
		return findByPrimaryKey((Serializable)locationId);
	}

	/**
	 * Returns the location with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the location
	 * @return the location, or <code>null</code> if a location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Location location = (Location)EntityCacheUtil.getResult(LocationModelImpl.ENTITY_CACHE_ENABLED,
				LocationImpl.class, primaryKey);

		if (location == _nullLocation) {
			return null;
		}

		if (location == null) {
			Session session = null;

			try {
				session = openSession();

				location = (Location)session.get(LocationImpl.class, primaryKey);

				if (location != null) {
					cacheResult(location);
				}
				else {
					EntityCacheUtil.putResult(LocationModelImpl.ENTITY_CACHE_ENABLED,
						LocationImpl.class, primaryKey, _nullLocation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LocationModelImpl.ENTITY_CACHE_ENABLED,
					LocationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return location;
	}

	/**
	 * Returns the location with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param locationId the primary key of the location
	 * @return the location, or <code>null</code> if a location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location fetchByPrimaryKey(long locationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)locationId);
	}

	/**
	 * Returns all the locations.
	 *
	 * @return the locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Location> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @return the range of locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Location> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Location> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Location> list = (List<Location>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LOCATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOCATION;

				if (pagination) {
					sql = sql.concat(LocationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Location>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Location>(list);
				}
				else {
					list = (List<Location>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the locations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Location location : findAll()) {
			remove(location);
		}
	}

	/**
	 * Returns the number of locations.
	 *
	 * @return the number of locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOCATION);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the location persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.services.model.Location")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Location>> listenersList = new ArrayList<ModelListener<Location>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Location>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(LocationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LOCATION = "SELECT location FROM Location location";
	private static final String _SQL_SELECT_LOCATION_WHERE = "SELECT location FROM Location location WHERE ";
	private static final String _SQL_COUNT_LOCATION = "SELECT COUNT(location) FROM Location location";
	private static final String _SQL_COUNT_LOCATION_WHERE = "SELECT COUNT(location) FROM Location location WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "location.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Location exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Location exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LocationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static Location _nullLocation = new LocationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Location> toCacheModel() {
				return _nullLocationCacheModel;
			}
		};

	private static CacheModel<Location> _nullLocationCacheModel = new CacheModel<Location>() {
			@Override
			public Location toEntityModel() {
				return _nullLocation;
			}
		};
}