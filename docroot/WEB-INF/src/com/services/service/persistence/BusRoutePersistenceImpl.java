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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.services.NoSuchBusRouteException;

import com.services.model.BusRoute;
import com.services.model.impl.BusRouteImpl;
import com.services.model.impl.BusRouteModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the bus route service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusRoutePersistence
 * @see BusRouteUtil
 * @generated
 */
public class BusRoutePersistenceImpl extends BasePersistenceImpl<BusRoute>
	implements BusRoutePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BusRouteUtil} to access the bus route persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BusRouteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteModelImpl.FINDER_CACHE_ENABLED, BusRouteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteModelImpl.FINDER_CACHE_ENABLED, BusRouteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BUSID = new FinderPath(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteModelImpl.FINDER_CACHE_ENABLED, BusRouteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBusId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSID = new FinderPath(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteModelImpl.FINDER_CACHE_ENABLED, BusRouteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBusId",
			new String[] { Long.class.getName() },
			BusRouteModelImpl.BUSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BUSID = new FinderPath(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBusId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the bus routes where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @return the matching bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRoute> findByBusId(long busId) throws SystemException {
		return findByBusId(busId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bus routes where busId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param busId the bus ID
	 * @param start the lower bound of the range of bus routes
	 * @param end the upper bound of the range of bus routes (not inclusive)
	 * @return the range of matching bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRoute> findByBusId(long busId, int start, int end)
		throws SystemException {
		return findByBusId(busId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bus routes where busId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param busId the bus ID
	 * @param start the lower bound of the range of bus routes
	 * @param end the upper bound of the range of bus routes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRoute> findByBusId(long busId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSID;
			finderArgs = new Object[] { busId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BUSID;
			finderArgs = new Object[] { busId, start, end, orderByComparator };
		}

		List<BusRoute> list = (List<BusRoute>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusRoute busRoute : list) {
				if ((busId != busRoute.getBusId())) {
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

			query.append(_SQL_SELECT_BUSROUTE_WHERE);

			query.append(_FINDER_COLUMN_BUSID_BUSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusRouteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(busId);

				if (!pagination) {
					list = (List<BusRoute>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusRoute>(list);
				}
				else {
					list = (List<BusRoute>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first bus route in the ordered set where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus route
	 * @throws com.services.NoSuchBusRouteException if a matching bus route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute findByBusId_First(long busId,
		OrderByComparator orderByComparator)
		throws NoSuchBusRouteException, SystemException {
		BusRoute busRoute = fetchByBusId_First(busId, orderByComparator);

		if (busRoute != null) {
			return busRoute;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("busId=");
		msg.append(busId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusRouteException(msg.toString());
	}

	/**
	 * Returns the first bus route in the ordered set where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus route, or <code>null</code> if a matching bus route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute fetchByBusId_First(long busId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BusRoute> list = findByBusId(busId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bus route in the ordered set where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus route
	 * @throws com.services.NoSuchBusRouteException if a matching bus route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute findByBusId_Last(long busId,
		OrderByComparator orderByComparator)
		throws NoSuchBusRouteException, SystemException {
		BusRoute busRoute = fetchByBusId_Last(busId, orderByComparator);

		if (busRoute != null) {
			return busRoute;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("busId=");
		msg.append(busId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusRouteException(msg.toString());
	}

	/**
	 * Returns the last bus route in the ordered set where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus route, or <code>null</code> if a matching bus route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute fetchByBusId_Last(long busId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBusId(busId);

		if (count == 0) {
			return null;
		}

		List<BusRoute> list = findByBusId(busId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bus routes before and after the current bus route in the ordered set where busId = &#63;.
	 *
	 * @param brId the primary key of the current bus route
	 * @param busId the bus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus route
	 * @throws com.services.NoSuchBusRouteException if a bus route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute[] findByBusId_PrevAndNext(long brId, long busId,
		OrderByComparator orderByComparator)
		throws NoSuchBusRouteException, SystemException {
		BusRoute busRoute = findByPrimaryKey(brId);

		Session session = null;

		try {
			session = openSession();

			BusRoute[] array = new BusRouteImpl[3];

			array[0] = getByBusId_PrevAndNext(session, busRoute, busId,
					orderByComparator, true);

			array[1] = busRoute;

			array[2] = getByBusId_PrevAndNext(session, busRoute, busId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BusRoute getByBusId_PrevAndNext(Session session,
		BusRoute busRoute, long busId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUSROUTE_WHERE);

		query.append(_FINDER_COLUMN_BUSID_BUSID_2);

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
			query.append(BusRouteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(busId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(busRoute);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BusRoute> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bus routes where busId = &#63; from the database.
	 *
	 * @param busId the bus ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBusId(long busId) throws SystemException {
		for (BusRoute busRoute : findByBusId(busId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(busRoute);
		}
	}

	/**
	 * Returns the number of bus routes where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @return the number of matching bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBusId(long busId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BUSID;

		Object[] finderArgs = new Object[] { busId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BUSROUTE_WHERE);

			query.append(_FINDER_COLUMN_BUSID_BUSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(busId);

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

	private static final String _FINDER_COLUMN_BUSID_BUSID_2 = "busRoute.busId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STARTLOCATION =
		new FinderPath(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteModelImpl.FINDER_CACHE_ENABLED, BusRouteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStartLocation",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STARTLOCATION =
		new FinderPath(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteModelImpl.FINDER_CACHE_ENABLED, BusRouteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStartLocation",
			new String[] { Long.class.getName() },
			BusRouteModelImpl.STARTLOCATION_COLUMN_BITMASK |
			BusRouteModelImpl.BUSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STARTLOCATION = new FinderPath(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStartLocation",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the bus routes where startLocation = &#63;.
	 *
	 * @param startLocation the start location
	 * @return the matching bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRoute> findByStartLocation(long startLocation)
		throws SystemException {
		return findByStartLocation(startLocation, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bus routes where startLocation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param startLocation the start location
	 * @param start the lower bound of the range of bus routes
	 * @param end the upper bound of the range of bus routes (not inclusive)
	 * @return the range of matching bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRoute> findByStartLocation(long startLocation, int start,
		int end) throws SystemException {
		return findByStartLocation(startLocation, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bus routes where startLocation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param startLocation the start location
	 * @param start the lower bound of the range of bus routes
	 * @param end the upper bound of the range of bus routes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRoute> findByStartLocation(long startLocation, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STARTLOCATION;
			finderArgs = new Object[] { startLocation };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STARTLOCATION;
			finderArgs = new Object[] {
					startLocation,
					
					start, end, orderByComparator
				};
		}

		List<BusRoute> list = (List<BusRoute>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusRoute busRoute : list) {
				if ((startLocation != busRoute.getStartLocation())) {
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

			query.append(_SQL_SELECT_BUSROUTE_WHERE);

			query.append(_FINDER_COLUMN_STARTLOCATION_STARTLOCATION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusRouteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(startLocation);

				if (!pagination) {
					list = (List<BusRoute>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusRoute>(list);
				}
				else {
					list = (List<BusRoute>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first bus route in the ordered set where startLocation = &#63;.
	 *
	 * @param startLocation the start location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus route
	 * @throws com.services.NoSuchBusRouteException if a matching bus route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute findByStartLocation_First(long startLocation,
		OrderByComparator orderByComparator)
		throws NoSuchBusRouteException, SystemException {
		BusRoute busRoute = fetchByStartLocation_First(startLocation,
				orderByComparator);

		if (busRoute != null) {
			return busRoute;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("startLocation=");
		msg.append(startLocation);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusRouteException(msg.toString());
	}

	/**
	 * Returns the first bus route in the ordered set where startLocation = &#63;.
	 *
	 * @param startLocation the start location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus route, or <code>null</code> if a matching bus route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute fetchByStartLocation_First(long startLocation,
		OrderByComparator orderByComparator) throws SystemException {
		List<BusRoute> list = findByStartLocation(startLocation, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bus route in the ordered set where startLocation = &#63;.
	 *
	 * @param startLocation the start location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus route
	 * @throws com.services.NoSuchBusRouteException if a matching bus route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute findByStartLocation_Last(long startLocation,
		OrderByComparator orderByComparator)
		throws NoSuchBusRouteException, SystemException {
		BusRoute busRoute = fetchByStartLocation_Last(startLocation,
				orderByComparator);

		if (busRoute != null) {
			return busRoute;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("startLocation=");
		msg.append(startLocation);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusRouteException(msg.toString());
	}

	/**
	 * Returns the last bus route in the ordered set where startLocation = &#63;.
	 *
	 * @param startLocation the start location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus route, or <code>null</code> if a matching bus route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute fetchByStartLocation_Last(long startLocation,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStartLocation(startLocation);

		if (count == 0) {
			return null;
		}

		List<BusRoute> list = findByStartLocation(startLocation, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bus routes before and after the current bus route in the ordered set where startLocation = &#63;.
	 *
	 * @param brId the primary key of the current bus route
	 * @param startLocation the start location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus route
	 * @throws com.services.NoSuchBusRouteException if a bus route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute[] findByStartLocation_PrevAndNext(long brId,
		long startLocation, OrderByComparator orderByComparator)
		throws NoSuchBusRouteException, SystemException {
		BusRoute busRoute = findByPrimaryKey(brId);

		Session session = null;

		try {
			session = openSession();

			BusRoute[] array = new BusRouteImpl[3];

			array[0] = getByStartLocation_PrevAndNext(session, busRoute,
					startLocation, orderByComparator, true);

			array[1] = busRoute;

			array[2] = getByStartLocation_PrevAndNext(session, busRoute,
					startLocation, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BusRoute getByStartLocation_PrevAndNext(Session session,
		BusRoute busRoute, long startLocation,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUSROUTE_WHERE);

		query.append(_FINDER_COLUMN_STARTLOCATION_STARTLOCATION_2);

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
			query.append(BusRouteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(startLocation);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(busRoute);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BusRoute> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bus routes where startLocation = &#63; from the database.
	 *
	 * @param startLocation the start location
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStartLocation(long startLocation)
		throws SystemException {
		for (BusRoute busRoute : findByStartLocation(startLocation,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(busRoute);
		}
	}

	/**
	 * Returns the number of bus routes where startLocation = &#63;.
	 *
	 * @param startLocation the start location
	 * @return the number of matching bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStartLocation(long startLocation)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STARTLOCATION;

		Object[] finderArgs = new Object[] { startLocation };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BUSROUTE_WHERE);

			query.append(_FINDER_COLUMN_STARTLOCATION_STARTLOCATION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(startLocation);

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

	private static final String _FINDER_COLUMN_STARTLOCATION_STARTLOCATION_2 = "busRoute.startLocation = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ENDLOCATION =
		new FinderPath(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteModelImpl.FINDER_CACHE_ENABLED, BusRouteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEndLocation",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENDLOCATION =
		new FinderPath(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteModelImpl.FINDER_CACHE_ENABLED, BusRouteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEndLocation",
			new String[] { Long.class.getName() },
			BusRouteModelImpl.ENDLOCATION_COLUMN_BITMASK |
			BusRouteModelImpl.BUSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ENDLOCATION = new FinderPath(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEndLocation",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the bus routes where endLocation = &#63;.
	 *
	 * @param endLocation the end location
	 * @return the matching bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRoute> findByEndLocation(long endLocation)
		throws SystemException {
		return findByEndLocation(endLocation, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bus routes where endLocation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param endLocation the end location
	 * @param start the lower bound of the range of bus routes
	 * @param end the upper bound of the range of bus routes (not inclusive)
	 * @return the range of matching bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRoute> findByEndLocation(long endLocation, int start, int end)
		throws SystemException {
		return findByEndLocation(endLocation, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bus routes where endLocation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param endLocation the end location
	 * @param start the lower bound of the range of bus routes
	 * @param end the upper bound of the range of bus routes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRoute> findByEndLocation(long endLocation, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENDLOCATION;
			finderArgs = new Object[] { endLocation };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ENDLOCATION;
			finderArgs = new Object[] { endLocation, start, end, orderByComparator };
		}

		List<BusRoute> list = (List<BusRoute>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusRoute busRoute : list) {
				if ((endLocation != busRoute.getEndLocation())) {
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

			query.append(_SQL_SELECT_BUSROUTE_WHERE);

			query.append(_FINDER_COLUMN_ENDLOCATION_ENDLOCATION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusRouteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(endLocation);

				if (!pagination) {
					list = (List<BusRoute>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusRoute>(list);
				}
				else {
					list = (List<BusRoute>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first bus route in the ordered set where endLocation = &#63;.
	 *
	 * @param endLocation the end location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus route
	 * @throws com.services.NoSuchBusRouteException if a matching bus route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute findByEndLocation_First(long endLocation,
		OrderByComparator orderByComparator)
		throws NoSuchBusRouteException, SystemException {
		BusRoute busRoute = fetchByEndLocation_First(endLocation,
				orderByComparator);

		if (busRoute != null) {
			return busRoute;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("endLocation=");
		msg.append(endLocation);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusRouteException(msg.toString());
	}

	/**
	 * Returns the first bus route in the ordered set where endLocation = &#63;.
	 *
	 * @param endLocation the end location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus route, or <code>null</code> if a matching bus route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute fetchByEndLocation_First(long endLocation,
		OrderByComparator orderByComparator) throws SystemException {
		List<BusRoute> list = findByEndLocation(endLocation, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bus route in the ordered set where endLocation = &#63;.
	 *
	 * @param endLocation the end location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus route
	 * @throws com.services.NoSuchBusRouteException if a matching bus route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute findByEndLocation_Last(long endLocation,
		OrderByComparator orderByComparator)
		throws NoSuchBusRouteException, SystemException {
		BusRoute busRoute = fetchByEndLocation_Last(endLocation,
				orderByComparator);

		if (busRoute != null) {
			return busRoute;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("endLocation=");
		msg.append(endLocation);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusRouteException(msg.toString());
	}

	/**
	 * Returns the last bus route in the ordered set where endLocation = &#63;.
	 *
	 * @param endLocation the end location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus route, or <code>null</code> if a matching bus route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute fetchByEndLocation_Last(long endLocation,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEndLocation(endLocation);

		if (count == 0) {
			return null;
		}

		List<BusRoute> list = findByEndLocation(endLocation, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bus routes before and after the current bus route in the ordered set where endLocation = &#63;.
	 *
	 * @param brId the primary key of the current bus route
	 * @param endLocation the end location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus route
	 * @throws com.services.NoSuchBusRouteException if a bus route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute[] findByEndLocation_PrevAndNext(long brId,
		long endLocation, OrderByComparator orderByComparator)
		throws NoSuchBusRouteException, SystemException {
		BusRoute busRoute = findByPrimaryKey(brId);

		Session session = null;

		try {
			session = openSession();

			BusRoute[] array = new BusRouteImpl[3];

			array[0] = getByEndLocation_PrevAndNext(session, busRoute,
					endLocation, orderByComparator, true);

			array[1] = busRoute;

			array[2] = getByEndLocation_PrevAndNext(session, busRoute,
					endLocation, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BusRoute getByEndLocation_PrevAndNext(Session session,
		BusRoute busRoute, long endLocation,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUSROUTE_WHERE);

		query.append(_FINDER_COLUMN_ENDLOCATION_ENDLOCATION_2);

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
			query.append(BusRouteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(endLocation);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(busRoute);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BusRoute> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bus routes where endLocation = &#63; from the database.
	 *
	 * @param endLocation the end location
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEndLocation(long endLocation) throws SystemException {
		for (BusRoute busRoute : findByEndLocation(endLocation,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(busRoute);
		}
	}

	/**
	 * Returns the number of bus routes where endLocation = &#63;.
	 *
	 * @param endLocation the end location
	 * @return the number of matching bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEndLocation(long endLocation) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ENDLOCATION;

		Object[] finderArgs = new Object[] { endLocation };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BUSROUTE_WHERE);

			query.append(_FINDER_COLUMN_ENDLOCATION_ENDLOCATION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(endLocation);

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

	private static final String _FINDER_COLUMN_ENDLOCATION_ENDLOCATION_2 = "busRoute.endLocation = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STARTANDENDLOCATION =
		new FinderPath(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteModelImpl.FINDER_CACHE_ENABLED, BusRouteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStartAndEndLocation",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STARTANDENDLOCATION =
		new FinderPath(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteModelImpl.FINDER_CACHE_ENABLED, BusRouteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStartAndEndLocation",
			new String[] { Long.class.getName(), Long.class.getName() },
			BusRouteModelImpl.STARTLOCATION_COLUMN_BITMASK |
			BusRouteModelImpl.ENDLOCATION_COLUMN_BITMASK |
			BusRouteModelImpl.BUSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STARTANDENDLOCATION = new FinderPath(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStartAndEndLocation",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the bus routes where startLocation = &#63; and endLocation = &#63;.
	 *
	 * @param startLocation the start location
	 * @param endLocation the end location
	 * @return the matching bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRoute> findByStartAndEndLocation(long startLocation,
		long endLocation) throws SystemException {
		return findByStartAndEndLocation(startLocation, endLocation,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bus routes where startLocation = &#63; and endLocation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param startLocation the start location
	 * @param endLocation the end location
	 * @param start the lower bound of the range of bus routes
	 * @param end the upper bound of the range of bus routes (not inclusive)
	 * @return the range of matching bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRoute> findByStartAndEndLocation(long startLocation,
		long endLocation, int start, int end) throws SystemException {
		return findByStartAndEndLocation(startLocation, endLocation, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the bus routes where startLocation = &#63; and endLocation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param startLocation the start location
	 * @param endLocation the end location
	 * @param start the lower bound of the range of bus routes
	 * @param end the upper bound of the range of bus routes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRoute> findByStartAndEndLocation(long startLocation,
		long endLocation, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STARTANDENDLOCATION;
			finderArgs = new Object[] { startLocation, endLocation };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STARTANDENDLOCATION;
			finderArgs = new Object[] {
					startLocation, endLocation,
					
					start, end, orderByComparator
				};
		}

		List<BusRoute> list = (List<BusRoute>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusRoute busRoute : list) {
				if ((startLocation != busRoute.getStartLocation()) ||
						(endLocation != busRoute.getEndLocation())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_BUSROUTE_WHERE);

			query.append(_FINDER_COLUMN_STARTANDENDLOCATION_STARTLOCATION_2);

			query.append(_FINDER_COLUMN_STARTANDENDLOCATION_ENDLOCATION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusRouteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(startLocation);

				qPos.add(endLocation);

				if (!pagination) {
					list = (List<BusRoute>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusRoute>(list);
				}
				else {
					list = (List<BusRoute>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first bus route in the ordered set where startLocation = &#63; and endLocation = &#63;.
	 *
	 * @param startLocation the start location
	 * @param endLocation the end location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus route
	 * @throws com.services.NoSuchBusRouteException if a matching bus route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute findByStartAndEndLocation_First(long startLocation,
		long endLocation, OrderByComparator orderByComparator)
		throws NoSuchBusRouteException, SystemException {
		BusRoute busRoute = fetchByStartAndEndLocation_First(startLocation,
				endLocation, orderByComparator);

		if (busRoute != null) {
			return busRoute;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("startLocation=");
		msg.append(startLocation);

		msg.append(", endLocation=");
		msg.append(endLocation);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusRouteException(msg.toString());
	}

	/**
	 * Returns the first bus route in the ordered set where startLocation = &#63; and endLocation = &#63;.
	 *
	 * @param startLocation the start location
	 * @param endLocation the end location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus route, or <code>null</code> if a matching bus route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute fetchByStartAndEndLocation_First(long startLocation,
		long endLocation, OrderByComparator orderByComparator)
		throws SystemException {
		List<BusRoute> list = findByStartAndEndLocation(startLocation,
				endLocation, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bus route in the ordered set where startLocation = &#63; and endLocation = &#63;.
	 *
	 * @param startLocation the start location
	 * @param endLocation the end location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus route
	 * @throws com.services.NoSuchBusRouteException if a matching bus route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute findByStartAndEndLocation_Last(long startLocation,
		long endLocation, OrderByComparator orderByComparator)
		throws NoSuchBusRouteException, SystemException {
		BusRoute busRoute = fetchByStartAndEndLocation_Last(startLocation,
				endLocation, orderByComparator);

		if (busRoute != null) {
			return busRoute;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("startLocation=");
		msg.append(startLocation);

		msg.append(", endLocation=");
		msg.append(endLocation);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusRouteException(msg.toString());
	}

	/**
	 * Returns the last bus route in the ordered set where startLocation = &#63; and endLocation = &#63;.
	 *
	 * @param startLocation the start location
	 * @param endLocation the end location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus route, or <code>null</code> if a matching bus route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute fetchByStartAndEndLocation_Last(long startLocation,
		long endLocation, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByStartAndEndLocation(startLocation, endLocation);

		if (count == 0) {
			return null;
		}

		List<BusRoute> list = findByStartAndEndLocation(startLocation,
				endLocation, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bus routes before and after the current bus route in the ordered set where startLocation = &#63; and endLocation = &#63;.
	 *
	 * @param brId the primary key of the current bus route
	 * @param startLocation the start location
	 * @param endLocation the end location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus route
	 * @throws com.services.NoSuchBusRouteException if a bus route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute[] findByStartAndEndLocation_PrevAndNext(long brId,
		long startLocation, long endLocation,
		OrderByComparator orderByComparator)
		throws NoSuchBusRouteException, SystemException {
		BusRoute busRoute = findByPrimaryKey(brId);

		Session session = null;

		try {
			session = openSession();

			BusRoute[] array = new BusRouteImpl[3];

			array[0] = getByStartAndEndLocation_PrevAndNext(session, busRoute,
					startLocation, endLocation, orderByComparator, true);

			array[1] = busRoute;

			array[2] = getByStartAndEndLocation_PrevAndNext(session, busRoute,
					startLocation, endLocation, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BusRoute getByStartAndEndLocation_PrevAndNext(Session session,
		BusRoute busRoute, long startLocation, long endLocation,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUSROUTE_WHERE);

		query.append(_FINDER_COLUMN_STARTANDENDLOCATION_STARTLOCATION_2);

		query.append(_FINDER_COLUMN_STARTANDENDLOCATION_ENDLOCATION_2);

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
			query.append(BusRouteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(startLocation);

		qPos.add(endLocation);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(busRoute);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BusRoute> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bus routes where startLocation = &#63; and endLocation = &#63; from the database.
	 *
	 * @param startLocation the start location
	 * @param endLocation the end location
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStartAndEndLocation(long startLocation, long endLocation)
		throws SystemException {
		for (BusRoute busRoute : findByStartAndEndLocation(startLocation,
				endLocation, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(busRoute);
		}
	}

	/**
	 * Returns the number of bus routes where startLocation = &#63; and endLocation = &#63;.
	 *
	 * @param startLocation the start location
	 * @param endLocation the end location
	 * @return the number of matching bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStartAndEndLocation(long startLocation, long endLocation)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STARTANDENDLOCATION;

		Object[] finderArgs = new Object[] { startLocation, endLocation };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BUSROUTE_WHERE);

			query.append(_FINDER_COLUMN_STARTANDENDLOCATION_STARTLOCATION_2);

			query.append(_FINDER_COLUMN_STARTANDENDLOCATION_ENDLOCATION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(startLocation);

				qPos.add(endLocation);

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

	private static final String _FINDER_COLUMN_STARTANDENDLOCATION_STARTLOCATION_2 =
		"busRoute.startLocation = ? AND ";
	private static final String _FINDER_COLUMN_STARTANDENDLOCATION_ENDLOCATION_2 =
		"busRoute.endLocation = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVE = new FinderPath(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteModelImpl.FINDER_CACHE_ENABLED, BusRouteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActive",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE =
		new FinderPath(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteModelImpl.FINDER_CACHE_ENABLED, BusRouteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActive",
			new String[] { Boolean.class.getName() },
			BusRouteModelImpl.ACTIVE_COLUMN_BITMASK |
			BusRouteModelImpl.BUSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActive",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the bus routes where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRoute> findByActive(boolean active)
		throws SystemException {
		return findByActive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bus routes where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of bus routes
	 * @param end the upper bound of the range of bus routes (not inclusive)
	 * @return the range of matching bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRoute> findByActive(boolean active, int start, int end)
		throws SystemException {
		return findByActive(active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bus routes where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of bus routes
	 * @param end the upper bound of the range of bus routes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRoute> findByActive(boolean active, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE;
			finderArgs = new Object[] { active };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVE;
			finderArgs = new Object[] { active, start, end, orderByComparator };
		}

		List<BusRoute> list = (List<BusRoute>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusRoute busRoute : list) {
				if ((active != busRoute.getActive())) {
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

			query.append(_SQL_SELECT_BUSROUTE_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusRouteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				if (!pagination) {
					list = (List<BusRoute>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusRoute>(list);
				}
				else {
					list = (List<BusRoute>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first bus route in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus route
	 * @throws com.services.NoSuchBusRouteException if a matching bus route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute findByActive_First(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchBusRouteException, SystemException {
		BusRoute busRoute = fetchByActive_First(active, orderByComparator);

		if (busRoute != null) {
			return busRoute;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusRouteException(msg.toString());
	}

	/**
	 * Returns the first bus route in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus route, or <code>null</code> if a matching bus route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute fetchByActive_First(boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		List<BusRoute> list = findByActive(active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bus route in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus route
	 * @throws com.services.NoSuchBusRouteException if a matching bus route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute findByActive_Last(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchBusRouteException, SystemException {
		BusRoute busRoute = fetchByActive_Last(active, orderByComparator);

		if (busRoute != null) {
			return busRoute;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusRouteException(msg.toString());
	}

	/**
	 * Returns the last bus route in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus route, or <code>null</code> if a matching bus route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute fetchByActive_Last(boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByActive(active);

		if (count == 0) {
			return null;
		}

		List<BusRoute> list = findByActive(active, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bus routes before and after the current bus route in the ordered set where active = &#63;.
	 *
	 * @param brId the primary key of the current bus route
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus route
	 * @throws com.services.NoSuchBusRouteException if a bus route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute[] findByActive_PrevAndNext(long brId, boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchBusRouteException, SystemException {
		BusRoute busRoute = findByPrimaryKey(brId);

		Session session = null;

		try {
			session = openSession();

			BusRoute[] array = new BusRouteImpl[3];

			array[0] = getByActive_PrevAndNext(session, busRoute, active,
					orderByComparator, true);

			array[1] = busRoute;

			array[2] = getByActive_PrevAndNext(session, busRoute, active,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BusRoute getByActive_PrevAndNext(Session session,
		BusRoute busRoute, boolean active, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUSROUTE_WHERE);

		query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

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
			query.append(BusRouteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(busRoute);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BusRoute> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bus routes where active = &#63; from the database.
	 *
	 * @param active the active
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByActive(boolean active) throws SystemException {
		for (BusRoute busRoute : findByActive(active, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(busRoute);
		}
	}

	/**
	 * Returns the number of bus routes where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByActive(boolean active) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTIVE;

		Object[] finderArgs = new Object[] { active };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BUSROUTE_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

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

	private static final String _FINDER_COLUMN_ACTIVE_ACTIVE_2 = "busRoute.active = ?";

	public BusRoutePersistenceImpl() {
		setModelClass(BusRoute.class);
	}

	/**
	 * Caches the bus route in the entity cache if it is enabled.
	 *
	 * @param busRoute the bus route
	 */
	@Override
	public void cacheResult(BusRoute busRoute) {
		EntityCacheUtil.putResult(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteImpl.class, busRoute.getPrimaryKey(), busRoute);

		busRoute.resetOriginalValues();
	}

	/**
	 * Caches the bus routes in the entity cache if it is enabled.
	 *
	 * @param busRoutes the bus routes
	 */
	@Override
	public void cacheResult(List<BusRoute> busRoutes) {
		for (BusRoute busRoute : busRoutes) {
			if (EntityCacheUtil.getResult(
						BusRouteModelImpl.ENTITY_CACHE_ENABLED,
						BusRouteImpl.class, busRoute.getPrimaryKey()) == null) {
				cacheResult(busRoute);
			}
			else {
				busRoute.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bus routes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BusRouteImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BusRouteImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bus route.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BusRoute busRoute) {
		EntityCacheUtil.removeResult(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteImpl.class, busRoute.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BusRoute> busRoutes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BusRoute busRoute : busRoutes) {
			EntityCacheUtil.removeResult(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
				BusRouteImpl.class, busRoute.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bus route with the primary key. Does not add the bus route to the database.
	 *
	 * @param brId the primary key for the new bus route
	 * @return the new bus route
	 */
	@Override
	public BusRoute create(long brId) {
		BusRoute busRoute = new BusRouteImpl();

		busRoute.setNew(true);
		busRoute.setPrimaryKey(brId);

		return busRoute;
	}

	/**
	 * Removes the bus route with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param brId the primary key of the bus route
	 * @return the bus route that was removed
	 * @throws com.services.NoSuchBusRouteException if a bus route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute remove(long brId)
		throws NoSuchBusRouteException, SystemException {
		return remove((Serializable)brId);
	}

	/**
	 * Removes the bus route with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bus route
	 * @return the bus route that was removed
	 * @throws com.services.NoSuchBusRouteException if a bus route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute remove(Serializable primaryKey)
		throws NoSuchBusRouteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BusRoute busRoute = (BusRoute)session.get(BusRouteImpl.class,
					primaryKey);

			if (busRoute == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBusRouteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(busRoute);
		}
		catch (NoSuchBusRouteException nsee) {
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
	protected BusRoute removeImpl(BusRoute busRoute) throws SystemException {
		busRoute = toUnwrappedModel(busRoute);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(busRoute)) {
				busRoute = (BusRoute)session.get(BusRouteImpl.class,
						busRoute.getPrimaryKeyObj());
			}

			if (busRoute != null) {
				session.delete(busRoute);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (busRoute != null) {
			clearCache(busRoute);
		}

		return busRoute;
	}

	@Override
	public BusRoute updateImpl(com.services.model.BusRoute busRoute)
		throws SystemException {
		busRoute = toUnwrappedModel(busRoute);

		boolean isNew = busRoute.isNew();

		BusRouteModelImpl busRouteModelImpl = (BusRouteModelImpl)busRoute;

		Session session = null;

		try {
			session = openSession();

			if (busRoute.isNew()) {
				session.save(busRoute);

				busRoute.setNew(false);
			}
			else {
				session.merge(busRoute);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BusRouteModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((busRouteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						busRouteModelImpl.getOriginalBusId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BUSID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSID,
					args);

				args = new Object[] { busRouteModelImpl.getBusId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BUSID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSID,
					args);
			}

			if ((busRouteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STARTLOCATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						busRouteModelImpl.getOriginalStartLocation()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STARTLOCATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STARTLOCATION,
					args);

				args = new Object[] { busRouteModelImpl.getStartLocation() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STARTLOCATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STARTLOCATION,
					args);
			}

			if ((busRouteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENDLOCATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						busRouteModelImpl.getOriginalEndLocation()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENDLOCATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENDLOCATION,
					args);

				args = new Object[] { busRouteModelImpl.getEndLocation() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENDLOCATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENDLOCATION,
					args);
			}

			if ((busRouteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STARTANDENDLOCATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						busRouteModelImpl.getOriginalStartLocation(),
						busRouteModelImpl.getOriginalEndLocation()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STARTANDENDLOCATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STARTANDENDLOCATION,
					args);

				args = new Object[] {
						busRouteModelImpl.getStartLocation(),
						busRouteModelImpl.getEndLocation()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STARTANDENDLOCATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STARTANDENDLOCATION,
					args);
			}

			if ((busRouteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						busRouteModelImpl.getOriginalActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);

				args = new Object[] { busRouteModelImpl.getActive() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);
			}
		}

		EntityCacheUtil.putResult(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteImpl.class, busRoute.getPrimaryKey(), busRoute);

		return busRoute;
	}

	protected BusRoute toUnwrappedModel(BusRoute busRoute) {
		if (busRoute instanceof BusRouteImpl) {
			return busRoute;
		}

		BusRouteImpl busRouteImpl = new BusRouteImpl();

		busRouteImpl.setNew(busRoute.isNew());
		busRouteImpl.setPrimaryKey(busRoute.getPrimaryKey());

		busRouteImpl.setBrId(busRoute.getBrId());
		busRouteImpl.setBusId(busRoute.getBusId());
		busRouteImpl.setStartLocation(busRoute.getStartLocation());
		busRouteImpl.setEndLocation(busRoute.getEndLocation());
		busRouteImpl.setMidLocation1(busRoute.getMidLocation1());
		busRouteImpl.setMidLocation2(busRoute.getMidLocation2());
		busRouteImpl.setActive(busRoute.isActive());
		busRouteImpl.setCreateDate(busRoute.getCreateDate());
		busRouteImpl.setModifiedDate(busRoute.getModifiedDate());

		return busRouteImpl;
	}

	/**
	 * Returns the bus route with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bus route
	 * @return the bus route
	 * @throws com.services.NoSuchBusRouteException if a bus route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBusRouteException, SystemException {
		BusRoute busRoute = fetchByPrimaryKey(primaryKey);

		if (busRoute == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBusRouteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return busRoute;
	}

	/**
	 * Returns the bus route with the primary key or throws a {@link com.services.NoSuchBusRouteException} if it could not be found.
	 *
	 * @param brId the primary key of the bus route
	 * @return the bus route
	 * @throws com.services.NoSuchBusRouteException if a bus route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute findByPrimaryKey(long brId)
		throws NoSuchBusRouteException, SystemException {
		return findByPrimaryKey((Serializable)brId);
	}

	/**
	 * Returns the bus route with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bus route
	 * @return the bus route, or <code>null</code> if a bus route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BusRoute busRoute = (BusRoute)EntityCacheUtil.getResult(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
				BusRouteImpl.class, primaryKey);

		if (busRoute == _nullBusRoute) {
			return null;
		}

		if (busRoute == null) {
			Session session = null;

			try {
				session = openSession();

				busRoute = (BusRoute)session.get(BusRouteImpl.class, primaryKey);

				if (busRoute != null) {
					cacheResult(busRoute);
				}
				else {
					EntityCacheUtil.putResult(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
						BusRouteImpl.class, primaryKey, _nullBusRoute);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BusRouteModelImpl.ENTITY_CACHE_ENABLED,
					BusRouteImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return busRoute;
	}

	/**
	 * Returns the bus route with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param brId the primary key of the bus route
	 * @return the bus route, or <code>null</code> if a bus route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRoute fetchByPrimaryKey(long brId) throws SystemException {
		return fetchByPrimaryKey((Serializable)brId);
	}

	/**
	 * Returns all the bus routes.
	 *
	 * @return the bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRoute> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<BusRoute> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bus routes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bus routes
	 * @param end the upper bound of the range of bus routes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bus routes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRoute> findAll(int start, int end,
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

		List<BusRoute> list = (List<BusRoute>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BUSROUTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BUSROUTE;

				if (pagination) {
					sql = sql.concat(BusRouteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BusRoute>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusRoute>(list);
				}
				else {
					list = (List<BusRoute>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the bus routes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BusRoute busRoute : findAll()) {
			remove(busRoute);
		}
	}

	/**
	 * Returns the number of bus routes.
	 *
	 * @return the number of bus routes
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

				Query q = session.createQuery(_SQL_COUNT_BUSROUTE);

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
	 * Initializes the bus route persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.services.model.BusRoute")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BusRoute>> listenersList = new ArrayList<ModelListener<BusRoute>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BusRoute>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BusRouteImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BUSROUTE = "SELECT busRoute FROM BusRoute busRoute";
	private static final String _SQL_SELECT_BUSROUTE_WHERE = "SELECT busRoute FROM BusRoute busRoute WHERE ";
	private static final String _SQL_COUNT_BUSROUTE = "SELECT COUNT(busRoute) FROM BusRoute busRoute";
	private static final String _SQL_COUNT_BUSROUTE_WHERE = "SELECT COUNT(busRoute) FROM BusRoute busRoute WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "busRoute.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BusRoute exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BusRoute exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BusRoutePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static BusRoute _nullBusRoute = new BusRouteImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BusRoute> toCacheModel() {
				return _nullBusRouteCacheModel;
			}
		};

	private static CacheModel<BusRoute> _nullBusRouteCacheModel = new CacheModel<BusRoute>() {
			@Override
			public BusRoute toEntityModel() {
				return _nullBusRoute;
			}
		};
}