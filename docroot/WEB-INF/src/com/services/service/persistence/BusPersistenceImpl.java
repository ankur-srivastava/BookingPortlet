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

import com.services.NoSuchBusException;

import com.services.model.Bus;
import com.services.model.impl.BusImpl;
import com.services.model.impl.BusModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the bus service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusPersistence
 * @see BusUtil
 * @generated
 */
public class BusPersistenceImpl extends BasePersistenceImpl<Bus>
	implements BusPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BusUtil} to access the bus persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BusImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BusModelImpl.ENTITY_CACHE_ENABLED,
			BusModelImpl.FINDER_CACHE_ENABLED, BusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BusModelImpl.ENTITY_CACHE_ENABLED,
			BusModelImpl.FINDER_CACHE_ENABLED, BusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BusModelImpl.ENTITY_CACHE_ENABLED,
			BusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVE = new FinderPath(BusModelImpl.ENTITY_CACHE_ENABLED,
			BusModelImpl.FINDER_CACHE_ENABLED, BusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActive",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE =
		new FinderPath(BusModelImpl.ENTITY_CACHE_ENABLED,
			BusModelImpl.FINDER_CACHE_ENABLED, BusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActive",
			new String[] { Boolean.class.getName() },
			BusModelImpl.ACTIVE_COLUMN_BITMASK |
			BusModelImpl.BUSNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(BusModelImpl.ENTITY_CACHE_ENABLED,
			BusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActive",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the buses where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching buses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Bus> findByActive(boolean active) throws SystemException {
		return findByActive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the buses where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of buses
	 * @param end the upper bound of the range of buses (not inclusive)
	 * @return the range of matching buses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Bus> findByActive(boolean active, int start, int end)
		throws SystemException {
		return findByActive(active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the buses where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of buses
	 * @param end the upper bound of the range of buses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching buses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Bus> findByActive(boolean active, int start, int end,
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

		List<Bus> list = (List<Bus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Bus bus : list) {
				if ((active != bus.getActive())) {
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

			query.append(_SQL_SELECT_BUS_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				if (!pagination) {
					list = (List<Bus>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Bus>(list);
				}
				else {
					list = (List<Bus>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first bus in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus
	 * @throws com.services.NoSuchBusException if a matching bus could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bus findByActive_First(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchBusException, SystemException {
		Bus bus = fetchByActive_First(active, orderByComparator);

		if (bus != null) {
			return bus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusException(msg.toString());
	}

	/**
	 * Returns the first bus in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus, or <code>null</code> if a matching bus could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bus fetchByActive_First(boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		List<Bus> list = findByActive(active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bus in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus
	 * @throws com.services.NoSuchBusException if a matching bus could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bus findByActive_Last(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchBusException, SystemException {
		Bus bus = fetchByActive_Last(active, orderByComparator);

		if (bus != null) {
			return bus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusException(msg.toString());
	}

	/**
	 * Returns the last bus in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus, or <code>null</code> if a matching bus could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bus fetchByActive_Last(boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByActive(active);

		if (count == 0) {
			return null;
		}

		List<Bus> list = findByActive(active, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the buses before and after the current bus in the ordered set where active = &#63;.
	 *
	 * @param busId the primary key of the current bus
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus
	 * @throws com.services.NoSuchBusException if a bus with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bus[] findByActive_PrevAndNext(long busId, boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchBusException, SystemException {
		Bus bus = findByPrimaryKey(busId);

		Session session = null;

		try {
			session = openSession();

			Bus[] array = new BusImpl[3];

			array[0] = getByActive_PrevAndNext(session, bus, active,
					orderByComparator, true);

			array[1] = bus;

			array[2] = getByActive_PrevAndNext(session, bus, active,
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

	protected Bus getByActive_PrevAndNext(Session session, Bus bus,
		boolean active, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUS_WHERE);

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
			query.append(BusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Bus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the buses where active = &#63; from the database.
	 *
	 * @param active the active
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByActive(boolean active) throws SystemException {
		for (Bus bus : findByActive(active, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(bus);
		}
	}

	/**
	 * Returns the number of buses where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching buses
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

			query.append(_SQL_COUNT_BUS_WHERE);

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

	private static final String _FINDER_COLUMN_ACTIVE_ACTIVE_2 = "bus.active = ?";

	public BusPersistenceImpl() {
		setModelClass(Bus.class);
	}

	/**
	 * Caches the bus in the entity cache if it is enabled.
	 *
	 * @param bus the bus
	 */
	@Override
	public void cacheResult(Bus bus) {
		EntityCacheUtil.putResult(BusModelImpl.ENTITY_CACHE_ENABLED,
			BusImpl.class, bus.getPrimaryKey(), bus);

		bus.resetOriginalValues();
	}

	/**
	 * Caches the buses in the entity cache if it is enabled.
	 *
	 * @param buses the buses
	 */
	@Override
	public void cacheResult(List<Bus> buses) {
		for (Bus bus : buses) {
			if (EntityCacheUtil.getResult(BusModelImpl.ENTITY_CACHE_ENABLED,
						BusImpl.class, bus.getPrimaryKey()) == null) {
				cacheResult(bus);
			}
			else {
				bus.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all buses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BusImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BusImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bus.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Bus bus) {
		EntityCacheUtil.removeResult(BusModelImpl.ENTITY_CACHE_ENABLED,
			BusImpl.class, bus.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Bus> buses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Bus bus : buses) {
			EntityCacheUtil.removeResult(BusModelImpl.ENTITY_CACHE_ENABLED,
				BusImpl.class, bus.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bus with the primary key. Does not add the bus to the database.
	 *
	 * @param busId the primary key for the new bus
	 * @return the new bus
	 */
	@Override
	public Bus create(long busId) {
		Bus bus = new BusImpl();

		bus.setNew(true);
		bus.setPrimaryKey(busId);

		return bus;
	}

	/**
	 * Removes the bus with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param busId the primary key of the bus
	 * @return the bus that was removed
	 * @throws com.services.NoSuchBusException if a bus with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bus remove(long busId) throws NoSuchBusException, SystemException {
		return remove((Serializable)busId);
	}

	/**
	 * Removes the bus with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bus
	 * @return the bus that was removed
	 * @throws com.services.NoSuchBusException if a bus with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bus remove(Serializable primaryKey)
		throws NoSuchBusException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Bus bus = (Bus)session.get(BusImpl.class, primaryKey);

			if (bus == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bus);
		}
		catch (NoSuchBusException nsee) {
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
	protected Bus removeImpl(Bus bus) throws SystemException {
		bus = toUnwrappedModel(bus);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bus)) {
				bus = (Bus)session.get(BusImpl.class, bus.getPrimaryKeyObj());
			}

			if (bus != null) {
				session.delete(bus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bus != null) {
			clearCache(bus);
		}

		return bus;
	}

	@Override
	public Bus updateImpl(com.services.model.Bus bus) throws SystemException {
		bus = toUnwrappedModel(bus);

		boolean isNew = bus.isNew();

		BusModelImpl busModelImpl = (BusModelImpl)bus;

		Session session = null;

		try {
			session = openSession();

			if (bus.isNew()) {
				session.save(bus);

				bus.setNew(false);
			}
			else {
				session.merge(bus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BusModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((busModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { busModelImpl.getOriginalActive() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);

				args = new Object[] { busModelImpl.getActive() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);
			}
		}

		EntityCacheUtil.putResult(BusModelImpl.ENTITY_CACHE_ENABLED,
			BusImpl.class, bus.getPrimaryKey(), bus);

		return bus;
	}

	protected Bus toUnwrappedModel(Bus bus) {
		if (bus instanceof BusImpl) {
			return bus;
		}

		BusImpl busImpl = new BusImpl();

		busImpl.setNew(bus.isNew());
		busImpl.setPrimaryKey(bus.getPrimaryKey());

		busImpl.setBusId(bus.getBusId());
		busImpl.setBusName(bus.getBusName());
		busImpl.setAgency(bus.getAgency());
		busImpl.setDriver(bus.getDriver());
		busImpl.setConductor(bus.getConductor());
		busImpl.setHelper(bus.getHelper());
		busImpl.setPlateNumber(bus.getPlateNumber());
		busImpl.setColor(bus.getColor());
		busImpl.setMake(bus.getMake());
		busImpl.setModel(bus.getModel());
		busImpl.setYear(bus.getYear());
		busImpl.setActive(bus.isActive());
		busImpl.setCreateDate(bus.getCreateDate());
		busImpl.setModifiedDate(bus.getModifiedDate());

		return busImpl;
	}

	/**
	 * Returns the bus with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bus
	 * @return the bus
	 * @throws com.services.NoSuchBusException if a bus with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBusException, SystemException {
		Bus bus = fetchByPrimaryKey(primaryKey);

		if (bus == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bus;
	}

	/**
	 * Returns the bus with the primary key or throws a {@link com.services.NoSuchBusException} if it could not be found.
	 *
	 * @param busId the primary key of the bus
	 * @return the bus
	 * @throws com.services.NoSuchBusException if a bus with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bus findByPrimaryKey(long busId)
		throws NoSuchBusException, SystemException {
		return findByPrimaryKey((Serializable)busId);
	}

	/**
	 * Returns the bus with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bus
	 * @return the bus, or <code>null</code> if a bus with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bus fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Bus bus = (Bus)EntityCacheUtil.getResult(BusModelImpl.ENTITY_CACHE_ENABLED,
				BusImpl.class, primaryKey);

		if (bus == _nullBus) {
			return null;
		}

		if (bus == null) {
			Session session = null;

			try {
				session = openSession();

				bus = (Bus)session.get(BusImpl.class, primaryKey);

				if (bus != null) {
					cacheResult(bus);
				}
				else {
					EntityCacheUtil.putResult(BusModelImpl.ENTITY_CACHE_ENABLED,
						BusImpl.class, primaryKey, _nullBus);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BusModelImpl.ENTITY_CACHE_ENABLED,
					BusImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bus;
	}

	/**
	 * Returns the bus with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param busId the primary key of the bus
	 * @return the bus, or <code>null</code> if a bus with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bus fetchByPrimaryKey(long busId) throws SystemException {
		return fetchByPrimaryKey((Serializable)busId);
	}

	/**
	 * Returns all the buses.
	 *
	 * @return the buses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Bus> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the buses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of buses
	 * @param end the upper bound of the range of buses (not inclusive)
	 * @return the range of buses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Bus> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the buses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of buses
	 * @param end the upper bound of the range of buses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of buses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Bus> findAll(int start, int end,
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

		List<Bus> list = (List<Bus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BUS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BUS;

				if (pagination) {
					sql = sql.concat(BusModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Bus>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Bus>(list);
				}
				else {
					list = (List<Bus>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Removes all the buses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Bus bus : findAll()) {
			remove(bus);
		}
	}

	/**
	 * Returns the number of buses.
	 *
	 * @return the number of buses
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

				Query q = session.createQuery(_SQL_COUNT_BUS);

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
	 * Initializes the bus persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.services.model.Bus")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Bus>> listenersList = new ArrayList<ModelListener<Bus>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Bus>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BusImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BUS = "SELECT bus FROM Bus bus";
	private static final String _SQL_SELECT_BUS_WHERE = "SELECT bus FROM Bus bus WHERE ";
	private static final String _SQL_COUNT_BUS = "SELECT COUNT(bus) FROM Bus bus";
	private static final String _SQL_COUNT_BUS_WHERE = "SELECT COUNT(bus) FROM Bus bus WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bus.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Bus exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Bus exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BusPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static Bus _nullBus = new BusImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Bus> toCacheModel() {
				return _nullBusCacheModel;
			}
		};

	private static CacheModel<Bus> _nullBusCacheModel = new CacheModel<Bus>() {
			@Override
			public Bus toEntityModel() {
				return _nullBus;
			}
		};
}