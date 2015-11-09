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

import com.services.NoSuchBusRouteTimingsException;

import com.services.model.BusRouteTimings;
import com.services.model.impl.BusRouteTimingsImpl;
import com.services.model.impl.BusRouteTimingsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the bus route timings service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusRouteTimingsPersistence
 * @see BusRouteTimingsUtil
 * @generated
 */
public class BusRouteTimingsPersistenceImpl extends BasePersistenceImpl<BusRouteTimings>
	implements BusRouteTimingsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BusRouteTimingsUtil} to access the bus route timings persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BusRouteTimingsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteTimingsModelImpl.FINDER_CACHE_ENABLED,
			BusRouteTimingsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteTimingsModelImpl.FINDER_CACHE_ENABLED,
			BusRouteTimingsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteTimingsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BRID = new FinderPath(BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteTimingsModelImpl.FINDER_CACHE_ENABLED,
			BusRouteTimingsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByBrId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRID = new FinderPath(BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteTimingsModelImpl.FINDER_CACHE_ENABLED,
			BusRouteTimingsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBrId",
			new String[] { Long.class.getName() },
			BusRouteTimingsModelImpl.BRID_COLUMN_BITMASK |
			BusRouteTimingsModelImpl.TRAVELDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BRID = new FinderPath(BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteTimingsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBrId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the bus route timingses where brId = &#63;.
	 *
	 * @param brId the br ID
	 * @return the matching bus route timingses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRouteTimings> findByBrId(long brId)
		throws SystemException {
		return findByBrId(brId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bus route timingses where brId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteTimingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param brId the br ID
	 * @param start the lower bound of the range of bus route timingses
	 * @param end the upper bound of the range of bus route timingses (not inclusive)
	 * @return the range of matching bus route timingses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRouteTimings> findByBrId(long brId, int start, int end)
		throws SystemException {
		return findByBrId(brId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bus route timingses where brId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteTimingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param brId the br ID
	 * @param start the lower bound of the range of bus route timingses
	 * @param end the upper bound of the range of bus route timingses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bus route timingses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRouteTimings> findByBrId(long brId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRID;
			finderArgs = new Object[] { brId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BRID;
			finderArgs = new Object[] { brId, start, end, orderByComparator };
		}

		List<BusRouteTimings> list = (List<BusRouteTimings>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusRouteTimings busRouteTimings : list) {
				if ((brId != busRouteTimings.getBrId())) {
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

			query.append(_SQL_SELECT_BUSROUTETIMINGS_WHERE);

			query.append(_FINDER_COLUMN_BRID_BRID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusRouteTimingsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(brId);

				if (!pagination) {
					list = (List<BusRouteTimings>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusRouteTimings>(list);
				}
				else {
					list = (List<BusRouteTimings>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first bus route timings in the ordered set where brId = &#63;.
	 *
	 * @param brId the br ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus route timings
	 * @throws com.services.NoSuchBusRouteTimingsException if a matching bus route timings could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings findByBrId_First(long brId,
		OrderByComparator orderByComparator)
		throws NoSuchBusRouteTimingsException, SystemException {
		BusRouteTimings busRouteTimings = fetchByBrId_First(brId,
				orderByComparator);

		if (busRouteTimings != null) {
			return busRouteTimings;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("brId=");
		msg.append(brId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusRouteTimingsException(msg.toString());
	}

	/**
	 * Returns the first bus route timings in the ordered set where brId = &#63;.
	 *
	 * @param brId the br ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings fetchByBrId_First(long brId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BusRouteTimings> list = findByBrId(brId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bus route timings in the ordered set where brId = &#63;.
	 *
	 * @param brId the br ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus route timings
	 * @throws com.services.NoSuchBusRouteTimingsException if a matching bus route timings could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings findByBrId_Last(long brId,
		OrderByComparator orderByComparator)
		throws NoSuchBusRouteTimingsException, SystemException {
		BusRouteTimings busRouteTimings = fetchByBrId_Last(brId,
				orderByComparator);

		if (busRouteTimings != null) {
			return busRouteTimings;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("brId=");
		msg.append(brId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusRouteTimingsException(msg.toString());
	}

	/**
	 * Returns the last bus route timings in the ordered set where brId = &#63;.
	 *
	 * @param brId the br ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings fetchByBrId_Last(long brId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBrId(brId);

		if (count == 0) {
			return null;
		}

		List<BusRouteTimings> list = findByBrId(brId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bus route timingses before and after the current bus route timings in the ordered set where brId = &#63;.
	 *
	 * @param brtId the primary key of the current bus route timings
	 * @param brId the br ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus route timings
	 * @throws com.services.NoSuchBusRouteTimingsException if a bus route timings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings[] findByBrId_PrevAndNext(long brtId, long brId,
		OrderByComparator orderByComparator)
		throws NoSuchBusRouteTimingsException, SystemException {
		BusRouteTimings busRouteTimings = findByPrimaryKey(brtId);

		Session session = null;

		try {
			session = openSession();

			BusRouteTimings[] array = new BusRouteTimingsImpl[3];

			array[0] = getByBrId_PrevAndNext(session, busRouteTimings, brId,
					orderByComparator, true);

			array[1] = busRouteTimings;

			array[2] = getByBrId_PrevAndNext(session, busRouteTimings, brId,
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

	protected BusRouteTimings getByBrId_PrevAndNext(Session session,
		BusRouteTimings busRouteTimings, long brId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUSROUTETIMINGS_WHERE);

		query.append(_FINDER_COLUMN_BRID_BRID_2);

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
			query.append(BusRouteTimingsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(brId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(busRouteTimings);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BusRouteTimings> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bus route timingses where brId = &#63; from the database.
	 *
	 * @param brId the br ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBrId(long brId) throws SystemException {
		for (BusRouteTimings busRouteTimings : findByBrId(brId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(busRouteTimings);
		}
	}

	/**
	 * Returns the number of bus route timingses where brId = &#63;.
	 *
	 * @param brId the br ID
	 * @return the number of matching bus route timingses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBrId(long brId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BRID;

		Object[] finderArgs = new Object[] { brId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BUSROUTETIMINGS_WHERE);

			query.append(_FINDER_COLUMN_BRID_BRID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(brId);

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

	private static final String _FINDER_COLUMN_BRID_BRID_2 = "busRouteTimings.brId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVE = new FinderPath(BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteTimingsModelImpl.FINDER_CACHE_ENABLED,
			BusRouteTimingsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByActive",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE =
		new FinderPath(BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteTimingsModelImpl.FINDER_CACHE_ENABLED,
			BusRouteTimingsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActive",
			new String[] { Boolean.class.getName() },
			BusRouteTimingsModelImpl.ACTIVE_COLUMN_BITMASK |
			BusRouteTimingsModelImpl.TRAVELDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteTimingsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActive",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the bus route timingses where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching bus route timingses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRouteTimings> findByActive(boolean active)
		throws SystemException {
		return findByActive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bus route timingses where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteTimingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of bus route timingses
	 * @param end the upper bound of the range of bus route timingses (not inclusive)
	 * @return the range of matching bus route timingses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRouteTimings> findByActive(boolean active, int start, int end)
		throws SystemException {
		return findByActive(active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bus route timingses where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteTimingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of bus route timingses
	 * @param end the upper bound of the range of bus route timingses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bus route timingses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRouteTimings> findByActive(boolean active, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<BusRouteTimings> list = (List<BusRouteTimings>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusRouteTimings busRouteTimings : list) {
				if ((active != busRouteTimings.getActive())) {
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

			query.append(_SQL_SELECT_BUSROUTETIMINGS_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusRouteTimingsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				if (!pagination) {
					list = (List<BusRouteTimings>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusRouteTimings>(list);
				}
				else {
					list = (List<BusRouteTimings>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first bus route timings in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus route timings
	 * @throws com.services.NoSuchBusRouteTimingsException if a matching bus route timings could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings findByActive_First(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchBusRouteTimingsException, SystemException {
		BusRouteTimings busRouteTimings = fetchByActive_First(active,
				orderByComparator);

		if (busRouteTimings != null) {
			return busRouteTimings;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusRouteTimingsException(msg.toString());
	}

	/**
	 * Returns the first bus route timings in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings fetchByActive_First(boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		List<BusRouteTimings> list = findByActive(active, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bus route timings in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus route timings
	 * @throws com.services.NoSuchBusRouteTimingsException if a matching bus route timings could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings findByActive_Last(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchBusRouteTimingsException, SystemException {
		BusRouteTimings busRouteTimings = fetchByActive_Last(active,
				orderByComparator);

		if (busRouteTimings != null) {
			return busRouteTimings;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusRouteTimingsException(msg.toString());
	}

	/**
	 * Returns the last bus route timings in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings fetchByActive_Last(boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByActive(active);

		if (count == 0) {
			return null;
		}

		List<BusRouteTimings> list = findByActive(active, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bus route timingses before and after the current bus route timings in the ordered set where active = &#63;.
	 *
	 * @param brtId the primary key of the current bus route timings
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus route timings
	 * @throws com.services.NoSuchBusRouteTimingsException if a bus route timings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings[] findByActive_PrevAndNext(long brtId,
		boolean active, OrderByComparator orderByComparator)
		throws NoSuchBusRouteTimingsException, SystemException {
		BusRouteTimings busRouteTimings = findByPrimaryKey(brtId);

		Session session = null;

		try {
			session = openSession();

			BusRouteTimings[] array = new BusRouteTimingsImpl[3];

			array[0] = getByActive_PrevAndNext(session, busRouteTimings,
					active, orderByComparator, true);

			array[1] = busRouteTimings;

			array[2] = getByActive_PrevAndNext(session, busRouteTimings,
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

	protected BusRouteTimings getByActive_PrevAndNext(Session session,
		BusRouteTimings busRouteTimings, boolean active,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUSROUTETIMINGS_WHERE);

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
			query.append(BusRouteTimingsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(busRouteTimings);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BusRouteTimings> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bus route timingses where active = &#63; from the database.
	 *
	 * @param active the active
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByActive(boolean active) throws SystemException {
		for (BusRouteTimings busRouteTimings : findByActive(active,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(busRouteTimings);
		}
	}

	/**
	 * Returns the number of bus route timingses where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching bus route timingses
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

			query.append(_SQL_COUNT_BUSROUTETIMINGS_WHERE);

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

	private static final String _FINDER_COLUMN_ACTIVE_ACTIVE_2 = "busRouteTimings.active = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRAVELDATE =
		new FinderPath(BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteTimingsModelImpl.FINDER_CACHE_ENABLED,
			BusRouteTimingsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTravelDate",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRAVELDATE =
		new FinderPath(BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteTimingsModelImpl.FINDER_CACHE_ENABLED,
			BusRouteTimingsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTravelDate",
			new String[] { String.class.getName() },
			BusRouteTimingsModelImpl.TRAVELDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRAVELDATE = new FinderPath(BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteTimingsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTravelDate",
			new String[] { String.class.getName() });

	/**
	 * Returns all the bus route timingses where travelDate = &#63;.
	 *
	 * @param travelDate the travel date
	 * @return the matching bus route timingses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRouteTimings> findByTravelDate(String travelDate)
		throws SystemException {
		return findByTravelDate(travelDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bus route timingses where travelDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteTimingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param travelDate the travel date
	 * @param start the lower bound of the range of bus route timingses
	 * @param end the upper bound of the range of bus route timingses (not inclusive)
	 * @return the range of matching bus route timingses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRouteTimings> findByTravelDate(String travelDate, int start,
		int end) throws SystemException {
		return findByTravelDate(travelDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bus route timingses where travelDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteTimingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param travelDate the travel date
	 * @param start the lower bound of the range of bus route timingses
	 * @param end the upper bound of the range of bus route timingses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bus route timingses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRouteTimings> findByTravelDate(String travelDate, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRAVELDATE;
			finderArgs = new Object[] { travelDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TRAVELDATE;
			finderArgs = new Object[] { travelDate, start, end, orderByComparator };
		}

		List<BusRouteTimings> list = (List<BusRouteTimings>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusRouteTimings busRouteTimings : list) {
				if (!Validator.equals(travelDate,
							busRouteTimings.getTravelDate())) {
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

			query.append(_SQL_SELECT_BUSROUTETIMINGS_WHERE);

			boolean bindTravelDate = false;

			if (travelDate == null) {
				query.append(_FINDER_COLUMN_TRAVELDATE_TRAVELDATE_1);
			}
			else if (travelDate.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TRAVELDATE_TRAVELDATE_3);
			}
			else {
				bindTravelDate = true;

				query.append(_FINDER_COLUMN_TRAVELDATE_TRAVELDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusRouteTimingsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTravelDate) {
					qPos.add(travelDate);
				}

				if (!pagination) {
					list = (List<BusRouteTimings>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusRouteTimings>(list);
				}
				else {
					list = (List<BusRouteTimings>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first bus route timings in the ordered set where travelDate = &#63;.
	 *
	 * @param travelDate the travel date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus route timings
	 * @throws com.services.NoSuchBusRouteTimingsException if a matching bus route timings could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings findByTravelDate_First(String travelDate,
		OrderByComparator orderByComparator)
		throws NoSuchBusRouteTimingsException, SystemException {
		BusRouteTimings busRouteTimings = fetchByTravelDate_First(travelDate,
				orderByComparator);

		if (busRouteTimings != null) {
			return busRouteTimings;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("travelDate=");
		msg.append(travelDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusRouteTimingsException(msg.toString());
	}

	/**
	 * Returns the first bus route timings in the ordered set where travelDate = &#63;.
	 *
	 * @param travelDate the travel date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings fetchByTravelDate_First(String travelDate,
		OrderByComparator orderByComparator) throws SystemException {
		List<BusRouteTimings> list = findByTravelDate(travelDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bus route timings in the ordered set where travelDate = &#63;.
	 *
	 * @param travelDate the travel date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus route timings
	 * @throws com.services.NoSuchBusRouteTimingsException if a matching bus route timings could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings findByTravelDate_Last(String travelDate,
		OrderByComparator orderByComparator)
		throws NoSuchBusRouteTimingsException, SystemException {
		BusRouteTimings busRouteTimings = fetchByTravelDate_Last(travelDate,
				orderByComparator);

		if (busRouteTimings != null) {
			return busRouteTimings;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("travelDate=");
		msg.append(travelDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusRouteTimingsException(msg.toString());
	}

	/**
	 * Returns the last bus route timings in the ordered set where travelDate = &#63;.
	 *
	 * @param travelDate the travel date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings fetchByTravelDate_Last(String travelDate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTravelDate(travelDate);

		if (count == 0) {
			return null;
		}

		List<BusRouteTimings> list = findByTravelDate(travelDate, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bus route timingses before and after the current bus route timings in the ordered set where travelDate = &#63;.
	 *
	 * @param brtId the primary key of the current bus route timings
	 * @param travelDate the travel date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus route timings
	 * @throws com.services.NoSuchBusRouteTimingsException if a bus route timings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings[] findByTravelDate_PrevAndNext(long brtId,
		String travelDate, OrderByComparator orderByComparator)
		throws NoSuchBusRouteTimingsException, SystemException {
		BusRouteTimings busRouteTimings = findByPrimaryKey(brtId);

		Session session = null;

		try {
			session = openSession();

			BusRouteTimings[] array = new BusRouteTimingsImpl[3];

			array[0] = getByTravelDate_PrevAndNext(session, busRouteTimings,
					travelDate, orderByComparator, true);

			array[1] = busRouteTimings;

			array[2] = getByTravelDate_PrevAndNext(session, busRouteTimings,
					travelDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BusRouteTimings getByTravelDate_PrevAndNext(Session session,
		BusRouteTimings busRouteTimings, String travelDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUSROUTETIMINGS_WHERE);

		boolean bindTravelDate = false;

		if (travelDate == null) {
			query.append(_FINDER_COLUMN_TRAVELDATE_TRAVELDATE_1);
		}
		else if (travelDate.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TRAVELDATE_TRAVELDATE_3);
		}
		else {
			bindTravelDate = true;

			query.append(_FINDER_COLUMN_TRAVELDATE_TRAVELDATE_2);
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
			query.append(BusRouteTimingsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTravelDate) {
			qPos.add(travelDate);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(busRouteTimings);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BusRouteTimings> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bus route timingses where travelDate = &#63; from the database.
	 *
	 * @param travelDate the travel date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTravelDate(String travelDate) throws SystemException {
		for (BusRouteTimings busRouteTimings : findByTravelDate(travelDate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(busRouteTimings);
		}
	}

	/**
	 * Returns the number of bus route timingses where travelDate = &#63;.
	 *
	 * @param travelDate the travel date
	 * @return the number of matching bus route timingses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTravelDate(String travelDate) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TRAVELDATE;

		Object[] finderArgs = new Object[] { travelDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BUSROUTETIMINGS_WHERE);

			boolean bindTravelDate = false;

			if (travelDate == null) {
				query.append(_FINDER_COLUMN_TRAVELDATE_TRAVELDATE_1);
			}
			else if (travelDate.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TRAVELDATE_TRAVELDATE_3);
			}
			else {
				bindTravelDate = true;

				query.append(_FINDER_COLUMN_TRAVELDATE_TRAVELDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTravelDate) {
					qPos.add(travelDate);
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

	private static final String _FINDER_COLUMN_TRAVELDATE_TRAVELDATE_1 = "busRouteTimings.travelDate IS NULL";
	private static final String _FINDER_COLUMN_TRAVELDATE_TRAVELDATE_2 = "busRouteTimings.travelDate = ?";
	private static final String _FINDER_COLUMN_TRAVELDATE_TRAVELDATE_3 = "(busRouteTimings.travelDate IS NULL OR busRouteTimings.travelDate = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BRIDANDTRAVELDATE =
		new FinderPath(BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteTimingsModelImpl.FINDER_CACHE_ENABLED,
			BusRouteTimingsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByBrIdAndTravelDate",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRIDANDTRAVELDATE =
		new FinderPath(BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteTimingsModelImpl.FINDER_CACHE_ENABLED,
			BusRouteTimingsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByBrIdAndTravelDate",
			new String[] { Long.class.getName(), String.class.getName() },
			BusRouteTimingsModelImpl.BRID_COLUMN_BITMASK |
			BusRouteTimingsModelImpl.TRAVELDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BRIDANDTRAVELDATE = new FinderPath(BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteTimingsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBrIdAndTravelDate",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the bus route timingses where brId = &#63; and travelDate = &#63;.
	 *
	 * @param brId the br ID
	 * @param travelDate the travel date
	 * @return the matching bus route timingses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRouteTimings> findByBrIdAndTravelDate(long brId,
		String travelDate) throws SystemException {
		return findByBrIdAndTravelDate(brId, travelDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bus route timingses where brId = &#63; and travelDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteTimingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param brId the br ID
	 * @param travelDate the travel date
	 * @param start the lower bound of the range of bus route timingses
	 * @param end the upper bound of the range of bus route timingses (not inclusive)
	 * @return the range of matching bus route timingses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRouteTimings> findByBrIdAndTravelDate(long brId,
		String travelDate, int start, int end) throws SystemException {
		return findByBrIdAndTravelDate(brId, travelDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bus route timingses where brId = &#63; and travelDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteTimingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param brId the br ID
	 * @param travelDate the travel date
	 * @param start the lower bound of the range of bus route timingses
	 * @param end the upper bound of the range of bus route timingses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bus route timingses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRouteTimings> findByBrIdAndTravelDate(long brId,
		String travelDate, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRIDANDTRAVELDATE;
			finderArgs = new Object[] { brId, travelDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BRIDANDTRAVELDATE;
			finderArgs = new Object[] {
					brId, travelDate,
					
					start, end, orderByComparator
				};
		}

		List<BusRouteTimings> list = (List<BusRouteTimings>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusRouteTimings busRouteTimings : list) {
				if ((brId != busRouteTimings.getBrId()) ||
						!Validator.equals(travelDate,
							busRouteTimings.getTravelDate())) {
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

			query.append(_SQL_SELECT_BUSROUTETIMINGS_WHERE);

			query.append(_FINDER_COLUMN_BRIDANDTRAVELDATE_BRID_2);

			boolean bindTravelDate = false;

			if (travelDate == null) {
				query.append(_FINDER_COLUMN_BRIDANDTRAVELDATE_TRAVELDATE_1);
			}
			else if (travelDate.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BRIDANDTRAVELDATE_TRAVELDATE_3);
			}
			else {
				bindTravelDate = true;

				query.append(_FINDER_COLUMN_BRIDANDTRAVELDATE_TRAVELDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusRouteTimingsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(brId);

				if (bindTravelDate) {
					qPos.add(travelDate);
				}

				if (!pagination) {
					list = (List<BusRouteTimings>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusRouteTimings>(list);
				}
				else {
					list = (List<BusRouteTimings>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first bus route timings in the ordered set where brId = &#63; and travelDate = &#63;.
	 *
	 * @param brId the br ID
	 * @param travelDate the travel date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus route timings
	 * @throws com.services.NoSuchBusRouteTimingsException if a matching bus route timings could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings findByBrIdAndTravelDate_First(long brId,
		String travelDate, OrderByComparator orderByComparator)
		throws NoSuchBusRouteTimingsException, SystemException {
		BusRouteTimings busRouteTimings = fetchByBrIdAndTravelDate_First(brId,
				travelDate, orderByComparator);

		if (busRouteTimings != null) {
			return busRouteTimings;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("brId=");
		msg.append(brId);

		msg.append(", travelDate=");
		msg.append(travelDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusRouteTimingsException(msg.toString());
	}

	/**
	 * Returns the first bus route timings in the ordered set where brId = &#63; and travelDate = &#63;.
	 *
	 * @param brId the br ID
	 * @param travelDate the travel date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings fetchByBrIdAndTravelDate_First(long brId,
		String travelDate, OrderByComparator orderByComparator)
		throws SystemException {
		List<BusRouteTimings> list = findByBrIdAndTravelDate(brId, travelDate,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bus route timings in the ordered set where brId = &#63; and travelDate = &#63;.
	 *
	 * @param brId the br ID
	 * @param travelDate the travel date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus route timings
	 * @throws com.services.NoSuchBusRouteTimingsException if a matching bus route timings could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings findByBrIdAndTravelDate_Last(long brId,
		String travelDate, OrderByComparator orderByComparator)
		throws NoSuchBusRouteTimingsException, SystemException {
		BusRouteTimings busRouteTimings = fetchByBrIdAndTravelDate_Last(brId,
				travelDate, orderByComparator);

		if (busRouteTimings != null) {
			return busRouteTimings;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("brId=");
		msg.append(brId);

		msg.append(", travelDate=");
		msg.append(travelDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusRouteTimingsException(msg.toString());
	}

	/**
	 * Returns the last bus route timings in the ordered set where brId = &#63; and travelDate = &#63;.
	 *
	 * @param brId the br ID
	 * @param travelDate the travel date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus route timings, or <code>null</code> if a matching bus route timings could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings fetchByBrIdAndTravelDate_Last(long brId,
		String travelDate, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByBrIdAndTravelDate(brId, travelDate);

		if (count == 0) {
			return null;
		}

		List<BusRouteTimings> list = findByBrIdAndTravelDate(brId, travelDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bus route timingses before and after the current bus route timings in the ordered set where brId = &#63; and travelDate = &#63;.
	 *
	 * @param brtId the primary key of the current bus route timings
	 * @param brId the br ID
	 * @param travelDate the travel date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus route timings
	 * @throws com.services.NoSuchBusRouteTimingsException if a bus route timings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings[] findByBrIdAndTravelDate_PrevAndNext(long brtId,
		long brId, String travelDate, OrderByComparator orderByComparator)
		throws NoSuchBusRouteTimingsException, SystemException {
		BusRouteTimings busRouteTimings = findByPrimaryKey(brtId);

		Session session = null;

		try {
			session = openSession();

			BusRouteTimings[] array = new BusRouteTimingsImpl[3];

			array[0] = getByBrIdAndTravelDate_PrevAndNext(session,
					busRouteTimings, brId, travelDate, orderByComparator, true);

			array[1] = busRouteTimings;

			array[2] = getByBrIdAndTravelDate_PrevAndNext(session,
					busRouteTimings, brId, travelDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BusRouteTimings getByBrIdAndTravelDate_PrevAndNext(
		Session session, BusRouteTimings busRouteTimings, long brId,
		String travelDate, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUSROUTETIMINGS_WHERE);

		query.append(_FINDER_COLUMN_BRIDANDTRAVELDATE_BRID_2);

		boolean bindTravelDate = false;

		if (travelDate == null) {
			query.append(_FINDER_COLUMN_BRIDANDTRAVELDATE_TRAVELDATE_1);
		}
		else if (travelDate.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BRIDANDTRAVELDATE_TRAVELDATE_3);
		}
		else {
			bindTravelDate = true;

			query.append(_FINDER_COLUMN_BRIDANDTRAVELDATE_TRAVELDATE_2);
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
			query.append(BusRouteTimingsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(brId);

		if (bindTravelDate) {
			qPos.add(travelDate);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(busRouteTimings);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BusRouteTimings> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bus route timingses where brId = &#63; and travelDate = &#63; from the database.
	 *
	 * @param brId the br ID
	 * @param travelDate the travel date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBrIdAndTravelDate(long brId, String travelDate)
		throws SystemException {
		for (BusRouteTimings busRouteTimings : findByBrIdAndTravelDate(brId,
				travelDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(busRouteTimings);
		}
	}

	/**
	 * Returns the number of bus route timingses where brId = &#63; and travelDate = &#63;.
	 *
	 * @param brId the br ID
	 * @param travelDate the travel date
	 * @return the number of matching bus route timingses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBrIdAndTravelDate(long brId, String travelDate)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BRIDANDTRAVELDATE;

		Object[] finderArgs = new Object[] { brId, travelDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BUSROUTETIMINGS_WHERE);

			query.append(_FINDER_COLUMN_BRIDANDTRAVELDATE_BRID_2);

			boolean bindTravelDate = false;

			if (travelDate == null) {
				query.append(_FINDER_COLUMN_BRIDANDTRAVELDATE_TRAVELDATE_1);
			}
			else if (travelDate.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BRIDANDTRAVELDATE_TRAVELDATE_3);
			}
			else {
				bindTravelDate = true;

				query.append(_FINDER_COLUMN_BRIDANDTRAVELDATE_TRAVELDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(brId);

				if (bindTravelDate) {
					qPos.add(travelDate);
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

	private static final String _FINDER_COLUMN_BRIDANDTRAVELDATE_BRID_2 = "busRouteTimings.brId = ? AND ";
	private static final String _FINDER_COLUMN_BRIDANDTRAVELDATE_TRAVELDATE_1 = "busRouteTimings.travelDate IS NULL";
	private static final String _FINDER_COLUMN_BRIDANDTRAVELDATE_TRAVELDATE_2 = "busRouteTimings.travelDate = ?";
	private static final String _FINDER_COLUMN_BRIDANDTRAVELDATE_TRAVELDATE_3 = "(busRouteTimings.travelDate IS NULL OR busRouteTimings.travelDate = '')";

	public BusRouteTimingsPersistenceImpl() {
		setModelClass(BusRouteTimings.class);
	}

	/**
	 * Caches the bus route timings in the entity cache if it is enabled.
	 *
	 * @param busRouteTimings the bus route timings
	 */
	@Override
	public void cacheResult(BusRouteTimings busRouteTimings) {
		EntityCacheUtil.putResult(BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteTimingsImpl.class, busRouteTimings.getPrimaryKey(),
			busRouteTimings);

		busRouteTimings.resetOriginalValues();
	}

	/**
	 * Caches the bus route timingses in the entity cache if it is enabled.
	 *
	 * @param busRouteTimingses the bus route timingses
	 */
	@Override
	public void cacheResult(List<BusRouteTimings> busRouteTimingses) {
		for (BusRouteTimings busRouteTimings : busRouteTimingses) {
			if (EntityCacheUtil.getResult(
						BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
						BusRouteTimingsImpl.class,
						busRouteTimings.getPrimaryKey()) == null) {
				cacheResult(busRouteTimings);
			}
			else {
				busRouteTimings.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bus route timingses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BusRouteTimingsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BusRouteTimingsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bus route timings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BusRouteTimings busRouteTimings) {
		EntityCacheUtil.removeResult(BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteTimingsImpl.class, busRouteTimings.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BusRouteTimings> busRouteTimingses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BusRouteTimings busRouteTimings : busRouteTimingses) {
			EntityCacheUtil.removeResult(BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
				BusRouteTimingsImpl.class, busRouteTimings.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bus route timings with the primary key. Does not add the bus route timings to the database.
	 *
	 * @param brtId the primary key for the new bus route timings
	 * @return the new bus route timings
	 */
	@Override
	public BusRouteTimings create(long brtId) {
		BusRouteTimings busRouteTimings = new BusRouteTimingsImpl();

		busRouteTimings.setNew(true);
		busRouteTimings.setPrimaryKey(brtId);

		return busRouteTimings;
	}

	/**
	 * Removes the bus route timings with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param brtId the primary key of the bus route timings
	 * @return the bus route timings that was removed
	 * @throws com.services.NoSuchBusRouteTimingsException if a bus route timings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings remove(long brtId)
		throws NoSuchBusRouteTimingsException, SystemException {
		return remove((Serializable)brtId);
	}

	/**
	 * Removes the bus route timings with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bus route timings
	 * @return the bus route timings that was removed
	 * @throws com.services.NoSuchBusRouteTimingsException if a bus route timings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings remove(Serializable primaryKey)
		throws NoSuchBusRouteTimingsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BusRouteTimings busRouteTimings = (BusRouteTimings)session.get(BusRouteTimingsImpl.class,
					primaryKey);

			if (busRouteTimings == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBusRouteTimingsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(busRouteTimings);
		}
		catch (NoSuchBusRouteTimingsException nsee) {
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
	protected BusRouteTimings removeImpl(BusRouteTimings busRouteTimings)
		throws SystemException {
		busRouteTimings = toUnwrappedModel(busRouteTimings);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(busRouteTimings)) {
				busRouteTimings = (BusRouteTimings)session.get(BusRouteTimingsImpl.class,
						busRouteTimings.getPrimaryKeyObj());
			}

			if (busRouteTimings != null) {
				session.delete(busRouteTimings);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (busRouteTimings != null) {
			clearCache(busRouteTimings);
		}

		return busRouteTimings;
	}

	@Override
	public BusRouteTimings updateImpl(
		com.services.model.BusRouteTimings busRouteTimings)
		throws SystemException {
		busRouteTimings = toUnwrappedModel(busRouteTimings);

		boolean isNew = busRouteTimings.isNew();

		BusRouteTimingsModelImpl busRouteTimingsModelImpl = (BusRouteTimingsModelImpl)busRouteTimings;

		Session session = null;

		try {
			session = openSession();

			if (busRouteTimings.isNew()) {
				session.save(busRouteTimings);

				busRouteTimings.setNew(false);
			}
			else {
				session.merge(busRouteTimings);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BusRouteTimingsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((busRouteTimingsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						busRouteTimingsModelImpl.getOriginalBrId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BRID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRID,
					args);

				args = new Object[] { busRouteTimingsModelImpl.getBrId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BRID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRID,
					args);
			}

			if ((busRouteTimingsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						busRouteTimingsModelImpl.getOriginalActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);

				args = new Object[] { busRouteTimingsModelImpl.getActive() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);
			}

			if ((busRouteTimingsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRAVELDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						busRouteTimingsModelImpl.getOriginalTravelDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRAVELDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRAVELDATE,
					args);

				args = new Object[] { busRouteTimingsModelImpl.getTravelDate() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRAVELDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRAVELDATE,
					args);
			}

			if ((busRouteTimingsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRIDANDTRAVELDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						busRouteTimingsModelImpl.getOriginalBrId(),
						busRouteTimingsModelImpl.getOriginalTravelDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BRIDANDTRAVELDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRIDANDTRAVELDATE,
					args);

				args = new Object[] {
						busRouteTimingsModelImpl.getBrId(),
						busRouteTimingsModelImpl.getTravelDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BRIDANDTRAVELDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRIDANDTRAVELDATE,
					args);
			}
		}

		EntityCacheUtil.putResult(BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
			BusRouteTimingsImpl.class, busRouteTimings.getPrimaryKey(),
			busRouteTimings);

		return busRouteTimings;
	}

	protected BusRouteTimings toUnwrappedModel(BusRouteTimings busRouteTimings) {
		if (busRouteTimings instanceof BusRouteTimingsImpl) {
			return busRouteTimings;
		}

		BusRouteTimingsImpl busRouteTimingsImpl = new BusRouteTimingsImpl();

		busRouteTimingsImpl.setNew(busRouteTimings.isNew());
		busRouteTimingsImpl.setPrimaryKey(busRouteTimings.getPrimaryKey());

		busRouteTimingsImpl.setBrtId(busRouteTimings.getBrtId());
		busRouteTimingsImpl.setBrId(busRouteTimings.getBrId());
		busRouteTimingsImpl.setBusDetails(busRouteTimings.getBusDetails());
		busRouteTimingsImpl.setTravelDate(busRouteTimings.getTravelDate());
		busRouteTimingsImpl.setTravelTime(busRouteTimings.getTravelTime());
		busRouteTimingsImpl.setTotal(busRouteTimings.getTotal());
		busRouteTimingsImpl.setAvailable(busRouteTimings.getAvailable());
		busRouteTimingsImpl.setPrice(busRouteTimings.getPrice());
		busRouteTimingsImpl.setActive(busRouteTimings.isActive());
		busRouteTimingsImpl.setCompleted(busRouteTimings.getCompleted());
		busRouteTimingsImpl.setCreateDate(busRouteTimings.getCreateDate());

		return busRouteTimingsImpl;
	}

	/**
	 * Returns the bus route timings with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bus route timings
	 * @return the bus route timings
	 * @throws com.services.NoSuchBusRouteTimingsException if a bus route timings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBusRouteTimingsException, SystemException {
		BusRouteTimings busRouteTimings = fetchByPrimaryKey(primaryKey);

		if (busRouteTimings == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBusRouteTimingsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return busRouteTimings;
	}

	/**
	 * Returns the bus route timings with the primary key or throws a {@link com.services.NoSuchBusRouteTimingsException} if it could not be found.
	 *
	 * @param brtId the primary key of the bus route timings
	 * @return the bus route timings
	 * @throws com.services.NoSuchBusRouteTimingsException if a bus route timings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings findByPrimaryKey(long brtId)
		throws NoSuchBusRouteTimingsException, SystemException {
		return findByPrimaryKey((Serializable)brtId);
	}

	/**
	 * Returns the bus route timings with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bus route timings
	 * @return the bus route timings, or <code>null</code> if a bus route timings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BusRouteTimings busRouteTimings = (BusRouteTimings)EntityCacheUtil.getResult(BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
				BusRouteTimingsImpl.class, primaryKey);

		if (busRouteTimings == _nullBusRouteTimings) {
			return null;
		}

		if (busRouteTimings == null) {
			Session session = null;

			try {
				session = openSession();

				busRouteTimings = (BusRouteTimings)session.get(BusRouteTimingsImpl.class,
						primaryKey);

				if (busRouteTimings != null) {
					cacheResult(busRouteTimings);
				}
				else {
					EntityCacheUtil.putResult(BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
						BusRouteTimingsImpl.class, primaryKey,
						_nullBusRouteTimings);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BusRouteTimingsModelImpl.ENTITY_CACHE_ENABLED,
					BusRouteTimingsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return busRouteTimings;
	}

	/**
	 * Returns the bus route timings with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param brtId the primary key of the bus route timings
	 * @return the bus route timings, or <code>null</code> if a bus route timings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusRouteTimings fetchByPrimaryKey(long brtId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)brtId);
	}

	/**
	 * Returns all the bus route timingses.
	 *
	 * @return the bus route timingses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRouteTimings> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<BusRouteTimings> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bus route timingses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusRouteTimingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bus route timingses
	 * @param end the upper bound of the range of bus route timingses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bus route timingses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusRouteTimings> findAll(int start, int end,
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

		List<BusRouteTimings> list = (List<BusRouteTimings>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BUSROUTETIMINGS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BUSROUTETIMINGS;

				if (pagination) {
					sql = sql.concat(BusRouteTimingsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BusRouteTimings>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusRouteTimings>(list);
				}
				else {
					list = (List<BusRouteTimings>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the bus route timingses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BusRouteTimings busRouteTimings : findAll()) {
			remove(busRouteTimings);
		}
	}

	/**
	 * Returns the number of bus route timingses.
	 *
	 * @return the number of bus route timingses
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

				Query q = session.createQuery(_SQL_COUNT_BUSROUTETIMINGS);

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
	 * Initializes the bus route timings persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.services.model.BusRouteTimings")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BusRouteTimings>> listenersList = new ArrayList<ModelListener<BusRouteTimings>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BusRouteTimings>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BusRouteTimingsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BUSROUTETIMINGS = "SELECT busRouteTimings FROM BusRouteTimings busRouteTimings";
	private static final String _SQL_SELECT_BUSROUTETIMINGS_WHERE = "SELECT busRouteTimings FROM BusRouteTimings busRouteTimings WHERE ";
	private static final String _SQL_COUNT_BUSROUTETIMINGS = "SELECT COUNT(busRouteTimings) FROM BusRouteTimings busRouteTimings";
	private static final String _SQL_COUNT_BUSROUTETIMINGS_WHERE = "SELECT COUNT(busRouteTimings) FROM BusRouteTimings busRouteTimings WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "busRouteTimings.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BusRouteTimings exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BusRouteTimings exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BusRouteTimingsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static BusRouteTimings _nullBusRouteTimings = new BusRouteTimingsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BusRouteTimings> toCacheModel() {
				return _nullBusRouteTimingsCacheModel;
			}
		};

	private static CacheModel<BusRouteTimings> _nullBusRouteTimingsCacheModel = new CacheModel<BusRouteTimings>() {
			@Override
			public BusRouteTimings toEntityModel() {
				return _nullBusRouteTimings;
			}
		};
}