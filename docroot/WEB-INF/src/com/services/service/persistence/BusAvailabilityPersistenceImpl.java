/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.services.NoSuchBusAvailabilityException;

import com.services.model.BusAvailability;
import com.services.model.impl.BusAvailabilityImpl;
import com.services.model.impl.BusAvailabilityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the bus availability service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusAvailabilityPersistence
 * @see BusAvailabilityUtil
 * @generated
 */
public class BusAvailabilityPersistenceImpl extends BasePersistenceImpl<BusAvailability>
	implements BusAvailabilityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BusAvailabilityUtil} to access the bus availability persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BusAvailabilityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BusAvailabilityModelImpl.ENTITY_CACHE_ENABLED,
			BusAvailabilityModelImpl.FINDER_CACHE_ENABLED,
			BusAvailabilityImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BusAvailabilityModelImpl.ENTITY_CACHE_ENABLED,
			BusAvailabilityModelImpl.FINDER_CACHE_ENABLED,
			BusAvailabilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BusAvailabilityModelImpl.ENTITY_CACHE_ENABLED,
			BusAvailabilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BRTID = new FinderPath(BusAvailabilityModelImpl.ENTITY_CACHE_ENABLED,
			BusAvailabilityModelImpl.FINDER_CACHE_ENABLED,
			BusAvailabilityImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByBrtId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRTID = new FinderPath(BusAvailabilityModelImpl.ENTITY_CACHE_ENABLED,
			BusAvailabilityModelImpl.FINDER_CACHE_ENABLED,
			BusAvailabilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBrtId",
			new String[] { Long.class.getName() },
			BusAvailabilityModelImpl.BRTID_COLUMN_BITMASK |
			BusAvailabilityModelImpl.AVAILABLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BRTID = new FinderPath(BusAvailabilityModelImpl.ENTITY_CACHE_ENABLED,
			BusAvailabilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBrtId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the bus availabilities where brtId = &#63;.
	 *
	 * @param brtId the brt ID
	 * @return the matching bus availabilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusAvailability> findByBrtId(long brtId)
		throws SystemException {
		return findByBrtId(brtId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bus availabilities where brtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusAvailabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param brtId the brt ID
	 * @param start the lower bound of the range of bus availabilities
	 * @param end the upper bound of the range of bus availabilities (not inclusive)
	 * @return the range of matching bus availabilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusAvailability> findByBrtId(long brtId, int start, int end)
		throws SystemException {
		return findByBrtId(brtId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bus availabilities where brtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusAvailabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param brtId the brt ID
	 * @param start the lower bound of the range of bus availabilities
	 * @param end the upper bound of the range of bus availabilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bus availabilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusAvailability> findByBrtId(long brtId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRTID;
			finderArgs = new Object[] { brtId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BRTID;
			finderArgs = new Object[] { brtId, start, end, orderByComparator };
		}

		List<BusAvailability> list = (List<BusAvailability>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusAvailability busAvailability : list) {
				if ((brtId != busAvailability.getBrtId())) {
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

			query.append(_SQL_SELECT_BUSAVAILABILITY_WHERE);

			query.append(_FINDER_COLUMN_BRTID_BRTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusAvailabilityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(brtId);

				if (!pagination) {
					list = (List<BusAvailability>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusAvailability>(list);
				}
				else {
					list = (List<BusAvailability>)QueryUtil.list(q,
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
	 * Returns the first bus availability in the ordered set where brtId = &#63;.
	 *
	 * @param brtId the brt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus availability
	 * @throws com.services.NoSuchBusAvailabilityException if a matching bus availability could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusAvailability findByBrtId_First(long brtId,
		OrderByComparator orderByComparator)
		throws NoSuchBusAvailabilityException, SystemException {
		BusAvailability busAvailability = fetchByBrtId_First(brtId,
				orderByComparator);

		if (busAvailability != null) {
			return busAvailability;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("brtId=");
		msg.append(brtId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusAvailabilityException(msg.toString());
	}

	/**
	 * Returns the first bus availability in the ordered set where brtId = &#63;.
	 *
	 * @param brtId the brt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus availability, or <code>null</code> if a matching bus availability could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusAvailability fetchByBrtId_First(long brtId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BusAvailability> list = findByBrtId(brtId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bus availability in the ordered set where brtId = &#63;.
	 *
	 * @param brtId the brt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus availability
	 * @throws com.services.NoSuchBusAvailabilityException if a matching bus availability could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusAvailability findByBrtId_Last(long brtId,
		OrderByComparator orderByComparator)
		throws NoSuchBusAvailabilityException, SystemException {
		BusAvailability busAvailability = fetchByBrtId_Last(brtId,
				orderByComparator);

		if (busAvailability != null) {
			return busAvailability;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("brtId=");
		msg.append(brtId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusAvailabilityException(msg.toString());
	}

	/**
	 * Returns the last bus availability in the ordered set where brtId = &#63;.
	 *
	 * @param brtId the brt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus availability, or <code>null</code> if a matching bus availability could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusAvailability fetchByBrtId_Last(long brtId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBrtId(brtId);

		if (count == 0) {
			return null;
		}

		List<BusAvailability> list = findByBrtId(brtId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bus availabilities before and after the current bus availability in the ordered set where brtId = &#63;.
	 *
	 * @param baId the primary key of the current bus availability
	 * @param brtId the brt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus availability
	 * @throws com.services.NoSuchBusAvailabilityException if a bus availability with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusAvailability[] findByBrtId_PrevAndNext(long baId, long brtId,
		OrderByComparator orderByComparator)
		throws NoSuchBusAvailabilityException, SystemException {
		BusAvailability busAvailability = findByPrimaryKey(baId);

		Session session = null;

		try {
			session = openSession();

			BusAvailability[] array = new BusAvailabilityImpl[3];

			array[0] = getByBrtId_PrevAndNext(session, busAvailability, brtId,
					orderByComparator, true);

			array[1] = busAvailability;

			array[2] = getByBrtId_PrevAndNext(session, busAvailability, brtId,
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

	protected BusAvailability getByBrtId_PrevAndNext(Session session,
		BusAvailability busAvailability, long brtId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUSAVAILABILITY_WHERE);

		query.append(_FINDER_COLUMN_BRTID_BRTID_2);

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
			query.append(BusAvailabilityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(brtId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(busAvailability);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BusAvailability> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bus availabilities where brtId = &#63; from the database.
	 *
	 * @param brtId the brt ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBrtId(long brtId) throws SystemException {
		for (BusAvailability busAvailability : findByBrtId(brtId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(busAvailability);
		}
	}

	/**
	 * Returns the number of bus availabilities where brtId = &#63;.
	 *
	 * @param brtId the brt ID
	 * @return the number of matching bus availabilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBrtId(long brtId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BRTID;

		Object[] finderArgs = new Object[] { brtId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BUSAVAILABILITY_WHERE);

			query.append(_FINDER_COLUMN_BRTID_BRTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(brtId);

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

	private static final String _FINDER_COLUMN_BRTID_BRTID_2 = "busAvailability.brtId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AVAILABLE =
		new FinderPath(BusAvailabilityModelImpl.ENTITY_CACHE_ENABLED,
			BusAvailabilityModelImpl.FINDER_CACHE_ENABLED,
			BusAvailabilityImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAvailable",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVAILABLE =
		new FinderPath(BusAvailabilityModelImpl.ENTITY_CACHE_ENABLED,
			BusAvailabilityModelImpl.FINDER_CACHE_ENABLED,
			BusAvailabilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAvailable",
			new String[] { Long.class.getName() },
			BusAvailabilityModelImpl.AVAILABLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AVAILABLE = new FinderPath(BusAvailabilityModelImpl.ENTITY_CACHE_ENABLED,
			BusAvailabilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAvailable",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the bus availabilities where available = &#63;.
	 *
	 * @param available the available
	 * @return the matching bus availabilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusAvailability> findByAvailable(long available)
		throws SystemException {
		return findByAvailable(available, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the bus availabilities where available = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusAvailabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param available the available
	 * @param start the lower bound of the range of bus availabilities
	 * @param end the upper bound of the range of bus availabilities (not inclusive)
	 * @return the range of matching bus availabilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusAvailability> findByAvailable(long available, int start,
		int end) throws SystemException {
		return findByAvailable(available, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bus availabilities where available = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusAvailabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param available the available
	 * @param start the lower bound of the range of bus availabilities
	 * @param end the upper bound of the range of bus availabilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bus availabilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusAvailability> findByAvailable(long available, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVAILABLE;
			finderArgs = new Object[] { available };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AVAILABLE;
			finderArgs = new Object[] { available, start, end, orderByComparator };
		}

		List<BusAvailability> list = (List<BusAvailability>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusAvailability busAvailability : list) {
				if ((available != busAvailability.getAvailable())) {
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

			query.append(_SQL_SELECT_BUSAVAILABILITY_WHERE);

			query.append(_FINDER_COLUMN_AVAILABLE_AVAILABLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusAvailabilityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(available);

				if (!pagination) {
					list = (List<BusAvailability>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusAvailability>(list);
				}
				else {
					list = (List<BusAvailability>)QueryUtil.list(q,
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
	 * Returns the first bus availability in the ordered set where available = &#63;.
	 *
	 * @param available the available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus availability
	 * @throws com.services.NoSuchBusAvailabilityException if a matching bus availability could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusAvailability findByAvailable_First(long available,
		OrderByComparator orderByComparator)
		throws NoSuchBusAvailabilityException, SystemException {
		BusAvailability busAvailability = fetchByAvailable_First(available,
				orderByComparator);

		if (busAvailability != null) {
			return busAvailability;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("available=");
		msg.append(available);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusAvailabilityException(msg.toString());
	}

	/**
	 * Returns the first bus availability in the ordered set where available = &#63;.
	 *
	 * @param available the available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus availability, or <code>null</code> if a matching bus availability could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusAvailability fetchByAvailable_First(long available,
		OrderByComparator orderByComparator) throws SystemException {
		List<BusAvailability> list = findByAvailable(available, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bus availability in the ordered set where available = &#63;.
	 *
	 * @param available the available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus availability
	 * @throws com.services.NoSuchBusAvailabilityException if a matching bus availability could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusAvailability findByAvailable_Last(long available,
		OrderByComparator orderByComparator)
		throws NoSuchBusAvailabilityException, SystemException {
		BusAvailability busAvailability = fetchByAvailable_Last(available,
				orderByComparator);

		if (busAvailability != null) {
			return busAvailability;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("available=");
		msg.append(available);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusAvailabilityException(msg.toString());
	}

	/**
	 * Returns the last bus availability in the ordered set where available = &#63;.
	 *
	 * @param available the available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus availability, or <code>null</code> if a matching bus availability could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusAvailability fetchByAvailable_Last(long available,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAvailable(available);

		if (count == 0) {
			return null;
		}

		List<BusAvailability> list = findByAvailable(available, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bus availabilities before and after the current bus availability in the ordered set where available = &#63;.
	 *
	 * @param baId the primary key of the current bus availability
	 * @param available the available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus availability
	 * @throws com.services.NoSuchBusAvailabilityException if a bus availability with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusAvailability[] findByAvailable_PrevAndNext(long baId,
		long available, OrderByComparator orderByComparator)
		throws NoSuchBusAvailabilityException, SystemException {
		BusAvailability busAvailability = findByPrimaryKey(baId);

		Session session = null;

		try {
			session = openSession();

			BusAvailability[] array = new BusAvailabilityImpl[3];

			array[0] = getByAvailable_PrevAndNext(session, busAvailability,
					available, orderByComparator, true);

			array[1] = busAvailability;

			array[2] = getByAvailable_PrevAndNext(session, busAvailability,
					available, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BusAvailability getByAvailable_PrevAndNext(Session session,
		BusAvailability busAvailability, long available,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUSAVAILABILITY_WHERE);

		query.append(_FINDER_COLUMN_AVAILABLE_AVAILABLE_2);

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
			query.append(BusAvailabilityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(available);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(busAvailability);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BusAvailability> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bus availabilities where available = &#63; from the database.
	 *
	 * @param available the available
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAvailable(long available) throws SystemException {
		for (BusAvailability busAvailability : findByAvailable(available,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(busAvailability);
		}
	}

	/**
	 * Returns the number of bus availabilities where available = &#63;.
	 *
	 * @param available the available
	 * @return the number of matching bus availabilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAvailable(long available) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AVAILABLE;

		Object[] finderArgs = new Object[] { available };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BUSAVAILABILITY_WHERE);

			query.append(_FINDER_COLUMN_AVAILABLE_AVAILABLE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(available);

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

	private static final String _FINDER_COLUMN_AVAILABLE_AVAILABLE_2 = "busAvailability.available = ?";

	public BusAvailabilityPersistenceImpl() {
		setModelClass(BusAvailability.class);
	}

	/**
	 * Caches the bus availability in the entity cache if it is enabled.
	 *
	 * @param busAvailability the bus availability
	 */
	@Override
	public void cacheResult(BusAvailability busAvailability) {
		EntityCacheUtil.putResult(BusAvailabilityModelImpl.ENTITY_CACHE_ENABLED,
			BusAvailabilityImpl.class, busAvailability.getPrimaryKey(),
			busAvailability);

		busAvailability.resetOriginalValues();
	}

	/**
	 * Caches the bus availabilities in the entity cache if it is enabled.
	 *
	 * @param busAvailabilities the bus availabilities
	 */
	@Override
	public void cacheResult(List<BusAvailability> busAvailabilities) {
		for (BusAvailability busAvailability : busAvailabilities) {
			if (EntityCacheUtil.getResult(
						BusAvailabilityModelImpl.ENTITY_CACHE_ENABLED,
						BusAvailabilityImpl.class,
						busAvailability.getPrimaryKey()) == null) {
				cacheResult(busAvailability);
			}
			else {
				busAvailability.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bus availabilities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BusAvailabilityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BusAvailabilityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bus availability.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BusAvailability busAvailability) {
		EntityCacheUtil.removeResult(BusAvailabilityModelImpl.ENTITY_CACHE_ENABLED,
			BusAvailabilityImpl.class, busAvailability.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BusAvailability> busAvailabilities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BusAvailability busAvailability : busAvailabilities) {
			EntityCacheUtil.removeResult(BusAvailabilityModelImpl.ENTITY_CACHE_ENABLED,
				BusAvailabilityImpl.class, busAvailability.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bus availability with the primary key. Does not add the bus availability to the database.
	 *
	 * @param baId the primary key for the new bus availability
	 * @return the new bus availability
	 */
	@Override
	public BusAvailability create(long baId) {
		BusAvailability busAvailability = new BusAvailabilityImpl();

		busAvailability.setNew(true);
		busAvailability.setPrimaryKey(baId);

		return busAvailability;
	}

	/**
	 * Removes the bus availability with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param baId the primary key of the bus availability
	 * @return the bus availability that was removed
	 * @throws com.services.NoSuchBusAvailabilityException if a bus availability with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusAvailability remove(long baId)
		throws NoSuchBusAvailabilityException, SystemException {
		return remove((Serializable)baId);
	}

	/**
	 * Removes the bus availability with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bus availability
	 * @return the bus availability that was removed
	 * @throws com.services.NoSuchBusAvailabilityException if a bus availability with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusAvailability remove(Serializable primaryKey)
		throws NoSuchBusAvailabilityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BusAvailability busAvailability = (BusAvailability)session.get(BusAvailabilityImpl.class,
					primaryKey);

			if (busAvailability == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBusAvailabilityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(busAvailability);
		}
		catch (NoSuchBusAvailabilityException nsee) {
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
	protected BusAvailability removeImpl(BusAvailability busAvailability)
		throws SystemException {
		busAvailability = toUnwrappedModel(busAvailability);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(busAvailability)) {
				busAvailability = (BusAvailability)session.get(BusAvailabilityImpl.class,
						busAvailability.getPrimaryKeyObj());
			}

			if (busAvailability != null) {
				session.delete(busAvailability);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (busAvailability != null) {
			clearCache(busAvailability);
		}

		return busAvailability;
	}

	@Override
	public BusAvailability updateImpl(
		com.services.model.BusAvailability busAvailability)
		throws SystemException {
		busAvailability = toUnwrappedModel(busAvailability);

		boolean isNew = busAvailability.isNew();

		BusAvailabilityModelImpl busAvailabilityModelImpl = (BusAvailabilityModelImpl)busAvailability;

		Session session = null;

		try {
			session = openSession();

			if (busAvailability.isNew()) {
				session.save(busAvailability);

				busAvailability.setNew(false);
			}
			else {
				session.merge(busAvailability);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BusAvailabilityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((busAvailabilityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						busAvailabilityModelImpl.getOriginalBrtId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BRTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRTID,
					args);

				args = new Object[] { busAvailabilityModelImpl.getBrtId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BRTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRTID,
					args);
			}

			if ((busAvailabilityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVAILABLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						busAvailabilityModelImpl.getOriginalAvailable()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AVAILABLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVAILABLE,
					args);

				args = new Object[] { busAvailabilityModelImpl.getAvailable() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AVAILABLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVAILABLE,
					args);
			}
		}

		EntityCacheUtil.putResult(BusAvailabilityModelImpl.ENTITY_CACHE_ENABLED,
			BusAvailabilityImpl.class, busAvailability.getPrimaryKey(),
			busAvailability);

		return busAvailability;
	}

	protected BusAvailability toUnwrappedModel(BusAvailability busAvailability) {
		if (busAvailability instanceof BusAvailabilityImpl) {
			return busAvailability;
		}

		BusAvailabilityImpl busAvailabilityImpl = new BusAvailabilityImpl();

		busAvailabilityImpl.setNew(busAvailability.isNew());
		busAvailabilityImpl.setPrimaryKey(busAvailability.getPrimaryKey());

		busAvailabilityImpl.setBaId(busAvailability.getBaId());
		busAvailabilityImpl.setBrtId(busAvailability.getBrtId());
		busAvailabilityImpl.setTotal(busAvailability.getTotal());
		busAvailabilityImpl.setAvailable(busAvailability.getAvailable());
		busAvailabilityImpl.setPrice(busAvailability.getPrice());
		busAvailabilityImpl.setCreateDate(busAvailability.getCreateDate());

		return busAvailabilityImpl;
	}

	/**
	 * Returns the bus availability with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bus availability
	 * @return the bus availability
	 * @throws com.services.NoSuchBusAvailabilityException if a bus availability with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusAvailability findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBusAvailabilityException, SystemException {
		BusAvailability busAvailability = fetchByPrimaryKey(primaryKey);

		if (busAvailability == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBusAvailabilityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return busAvailability;
	}

	/**
	 * Returns the bus availability with the primary key or throws a {@link com.services.NoSuchBusAvailabilityException} if it could not be found.
	 *
	 * @param baId the primary key of the bus availability
	 * @return the bus availability
	 * @throws com.services.NoSuchBusAvailabilityException if a bus availability with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusAvailability findByPrimaryKey(long baId)
		throws NoSuchBusAvailabilityException, SystemException {
		return findByPrimaryKey((Serializable)baId);
	}

	/**
	 * Returns the bus availability with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bus availability
	 * @return the bus availability, or <code>null</code> if a bus availability with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusAvailability fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BusAvailability busAvailability = (BusAvailability)EntityCacheUtil.getResult(BusAvailabilityModelImpl.ENTITY_CACHE_ENABLED,
				BusAvailabilityImpl.class, primaryKey);

		if (busAvailability == _nullBusAvailability) {
			return null;
		}

		if (busAvailability == null) {
			Session session = null;

			try {
				session = openSession();

				busAvailability = (BusAvailability)session.get(BusAvailabilityImpl.class,
						primaryKey);

				if (busAvailability != null) {
					cacheResult(busAvailability);
				}
				else {
					EntityCacheUtil.putResult(BusAvailabilityModelImpl.ENTITY_CACHE_ENABLED,
						BusAvailabilityImpl.class, primaryKey,
						_nullBusAvailability);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BusAvailabilityModelImpl.ENTITY_CACHE_ENABLED,
					BusAvailabilityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return busAvailability;
	}

	/**
	 * Returns the bus availability with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param baId the primary key of the bus availability
	 * @return the bus availability, or <code>null</code> if a bus availability with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusAvailability fetchByPrimaryKey(long baId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)baId);
	}

	/**
	 * Returns all the bus availabilities.
	 *
	 * @return the bus availabilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusAvailability> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bus availabilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusAvailabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bus availabilities
	 * @param end the upper bound of the range of bus availabilities (not inclusive)
	 * @return the range of bus availabilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusAvailability> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bus availabilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusAvailabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bus availabilities
	 * @param end the upper bound of the range of bus availabilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bus availabilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusAvailability> findAll(int start, int end,
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

		List<BusAvailability> list = (List<BusAvailability>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BUSAVAILABILITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BUSAVAILABILITY;

				if (pagination) {
					sql = sql.concat(BusAvailabilityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BusAvailability>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusAvailability>(list);
				}
				else {
					list = (List<BusAvailability>)QueryUtil.list(q,
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
	 * Removes all the bus availabilities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BusAvailability busAvailability : findAll()) {
			remove(busAvailability);
		}
	}

	/**
	 * Returns the number of bus availabilities.
	 *
	 * @return the number of bus availabilities
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

				Query q = session.createQuery(_SQL_COUNT_BUSAVAILABILITY);

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

	/**
	 * Initializes the bus availability persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.services.model.BusAvailability")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BusAvailability>> listenersList = new ArrayList<ModelListener<BusAvailability>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BusAvailability>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BusAvailabilityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BUSAVAILABILITY = "SELECT busAvailability FROM BusAvailability busAvailability";
	private static final String _SQL_SELECT_BUSAVAILABILITY_WHERE = "SELECT busAvailability FROM BusAvailability busAvailability WHERE ";
	private static final String _SQL_COUNT_BUSAVAILABILITY = "SELECT COUNT(busAvailability) FROM BusAvailability busAvailability";
	private static final String _SQL_COUNT_BUSAVAILABILITY_WHERE = "SELECT COUNT(busAvailability) FROM BusAvailability busAvailability WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "busAvailability.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BusAvailability exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BusAvailability exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BusAvailabilityPersistenceImpl.class);
	private static BusAvailability _nullBusAvailability = new BusAvailabilityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BusAvailability> toCacheModel() {
				return _nullBusAvailabilityCacheModel;
			}
		};

	private static CacheModel<BusAvailability> _nullBusAvailabilityCacheModel = new CacheModel<BusAvailability>() {
			@Override
			public BusAvailability toEntityModel() {
				return _nullBusAvailability;
			}
		};
}