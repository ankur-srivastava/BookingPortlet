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

import com.services.NoSuchBusEmployeeException;

import com.services.model.BusEmployee;
import com.services.model.impl.BusEmployeeImpl;
import com.services.model.impl.BusEmployeeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the bus employee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusEmployeePersistence
 * @see BusEmployeeUtil
 * @generated
 */
public class BusEmployeePersistenceImpl extends BasePersistenceImpl<BusEmployee>
	implements BusEmployeePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BusEmployeeUtil} to access the bus employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BusEmployeeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BusEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			BusEmployeeModelImpl.FINDER_CACHE_ENABLED, BusEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BusEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			BusEmployeeModelImpl.FINDER_CACHE_ENABLED, BusEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BusEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			BusEmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AGENCY = new FinderPath(BusEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			BusEmployeeModelImpl.FINDER_CACHE_ENABLED, BusEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAgency",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AGENCY =
		new FinderPath(BusEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			BusEmployeeModelImpl.FINDER_CACHE_ENABLED, BusEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAgency",
			new String[] { Long.class.getName() },
			BusEmployeeModelImpl.AGENCY_COLUMN_BITMASK |
			BusEmployeeModelImpl.BENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AGENCY = new FinderPath(BusEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			BusEmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAgency",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the bus employees where agency = &#63;.
	 *
	 * @param agency the agency
	 * @return the matching bus employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusEmployee> findByAgency(long agency)
		throws SystemException {
		return findByAgency(agency, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<BusEmployee> findByAgency(long agency, int start, int end)
		throws SystemException {
		return findByAgency(agency, start, end, null);
	}

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
	@Override
	public List<BusEmployee> findByAgency(long agency, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AGENCY;
			finderArgs = new Object[] { agency };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AGENCY;
			finderArgs = new Object[] { agency, start, end, orderByComparator };
		}

		List<BusEmployee> list = (List<BusEmployee>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusEmployee busEmployee : list) {
				if ((agency != busEmployee.getAgency())) {
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

			query.append(_SQL_SELECT_BUSEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_AGENCY_AGENCY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusEmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(agency);

				if (!pagination) {
					list = (List<BusEmployee>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusEmployee>(list);
				}
				else {
					list = (List<BusEmployee>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first bus employee in the ordered set where agency = &#63;.
	 *
	 * @param agency the agency
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus employee
	 * @throws com.services.NoSuchBusEmployeeException if a matching bus employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusEmployee findByAgency_First(long agency,
		OrderByComparator orderByComparator)
		throws NoSuchBusEmployeeException, SystemException {
		BusEmployee busEmployee = fetchByAgency_First(agency, orderByComparator);

		if (busEmployee != null) {
			return busEmployee;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("agency=");
		msg.append(agency);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusEmployeeException(msg.toString());
	}

	/**
	 * Returns the first bus employee in the ordered set where agency = &#63;.
	 *
	 * @param agency the agency
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus employee, or <code>null</code> if a matching bus employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusEmployee fetchByAgency_First(long agency,
		OrderByComparator orderByComparator) throws SystemException {
		List<BusEmployee> list = findByAgency(agency, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bus employee in the ordered set where agency = &#63;.
	 *
	 * @param agency the agency
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus employee
	 * @throws com.services.NoSuchBusEmployeeException if a matching bus employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusEmployee findByAgency_Last(long agency,
		OrderByComparator orderByComparator)
		throws NoSuchBusEmployeeException, SystemException {
		BusEmployee busEmployee = fetchByAgency_Last(agency, orderByComparator);

		if (busEmployee != null) {
			return busEmployee;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("agency=");
		msg.append(agency);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusEmployeeException(msg.toString());
	}

	/**
	 * Returns the last bus employee in the ordered set where agency = &#63;.
	 *
	 * @param agency the agency
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus employee, or <code>null</code> if a matching bus employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusEmployee fetchByAgency_Last(long agency,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAgency(agency);

		if (count == 0) {
			return null;
		}

		List<BusEmployee> list = findByAgency(agency, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public BusEmployee[] findByAgency_PrevAndNext(long beId, long agency,
		OrderByComparator orderByComparator)
		throws NoSuchBusEmployeeException, SystemException {
		BusEmployee busEmployee = findByPrimaryKey(beId);

		Session session = null;

		try {
			session = openSession();

			BusEmployee[] array = new BusEmployeeImpl[3];

			array[0] = getByAgency_PrevAndNext(session, busEmployee, agency,
					orderByComparator, true);

			array[1] = busEmployee;

			array[2] = getByAgency_PrevAndNext(session, busEmployee, agency,
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

	protected BusEmployee getByAgency_PrevAndNext(Session session,
		BusEmployee busEmployee, long agency,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUSEMPLOYEE_WHERE);

		query.append(_FINDER_COLUMN_AGENCY_AGENCY_2);

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
			query.append(BusEmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(agency);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(busEmployee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BusEmployee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bus employees where agency = &#63; from the database.
	 *
	 * @param agency the agency
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAgency(long agency) throws SystemException {
		for (BusEmployee busEmployee : findByAgency(agency, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(busEmployee);
		}
	}

	/**
	 * Returns the number of bus employees where agency = &#63;.
	 *
	 * @param agency the agency
	 * @return the number of matching bus employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAgency(long agency) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AGENCY;

		Object[] finderArgs = new Object[] { agency };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BUSEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_AGENCY_AGENCY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(agency);

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

	private static final String _FINDER_COLUMN_AGENCY_AGENCY_2 = "busEmployee.agency = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVE = new FinderPath(BusEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			BusEmployeeModelImpl.FINDER_CACHE_ENABLED, BusEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActive",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE =
		new FinderPath(BusEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			BusEmployeeModelImpl.FINDER_CACHE_ENABLED, BusEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActive",
			new String[] { Boolean.class.getName() },
			BusEmployeeModelImpl.ACTIVE_COLUMN_BITMASK |
			BusEmployeeModelImpl.BENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(BusEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			BusEmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActive",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the bus employees where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching bus employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusEmployee> findByActive(boolean active)
		throws SystemException {
		return findByActive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<BusEmployee> findByActive(boolean active, int start, int end)
		throws SystemException {
		return findByActive(active, start, end, null);
	}

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
	@Override
	public List<BusEmployee> findByActive(boolean active, int start, int end,
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

		List<BusEmployee> list = (List<BusEmployee>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusEmployee busEmployee : list) {
				if ((active != busEmployee.getActive())) {
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

			query.append(_SQL_SELECT_BUSEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusEmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				if (!pagination) {
					list = (List<BusEmployee>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusEmployee>(list);
				}
				else {
					list = (List<BusEmployee>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first bus employee in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus employee
	 * @throws com.services.NoSuchBusEmployeeException if a matching bus employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusEmployee findByActive_First(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchBusEmployeeException, SystemException {
		BusEmployee busEmployee = fetchByActive_First(active, orderByComparator);

		if (busEmployee != null) {
			return busEmployee;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusEmployeeException(msg.toString());
	}

	/**
	 * Returns the first bus employee in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus employee, or <code>null</code> if a matching bus employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusEmployee fetchByActive_First(boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		List<BusEmployee> list = findByActive(active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bus employee in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus employee
	 * @throws com.services.NoSuchBusEmployeeException if a matching bus employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusEmployee findByActive_Last(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchBusEmployeeException, SystemException {
		BusEmployee busEmployee = fetchByActive_Last(active, orderByComparator);

		if (busEmployee != null) {
			return busEmployee;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusEmployeeException(msg.toString());
	}

	/**
	 * Returns the last bus employee in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus employee, or <code>null</code> if a matching bus employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusEmployee fetchByActive_Last(boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByActive(active);

		if (count == 0) {
			return null;
		}

		List<BusEmployee> list = findByActive(active, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public BusEmployee[] findByActive_PrevAndNext(long beId, boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchBusEmployeeException, SystemException {
		BusEmployee busEmployee = findByPrimaryKey(beId);

		Session session = null;

		try {
			session = openSession();

			BusEmployee[] array = new BusEmployeeImpl[3];

			array[0] = getByActive_PrevAndNext(session, busEmployee, active,
					orderByComparator, true);

			array[1] = busEmployee;

			array[2] = getByActive_PrevAndNext(session, busEmployee, active,
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

	protected BusEmployee getByActive_PrevAndNext(Session session,
		BusEmployee busEmployee, boolean active,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUSEMPLOYEE_WHERE);

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
			query.append(BusEmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(busEmployee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BusEmployee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bus employees where active = &#63; from the database.
	 *
	 * @param active the active
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByActive(boolean active) throws SystemException {
		for (BusEmployee busEmployee : findByActive(active, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(busEmployee);
		}
	}

	/**
	 * Returns the number of bus employees where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching bus employees
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

			query.append(_SQL_COUNT_BUSEMPLOYEE_WHERE);

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

	private static final String _FINDER_COLUMN_ACTIVE_ACTIVE_2 = "busEmployee.active = ?";

	public BusEmployeePersistenceImpl() {
		setModelClass(BusEmployee.class);
	}

	/**
	 * Caches the bus employee in the entity cache if it is enabled.
	 *
	 * @param busEmployee the bus employee
	 */
	@Override
	public void cacheResult(BusEmployee busEmployee) {
		EntityCacheUtil.putResult(BusEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			BusEmployeeImpl.class, busEmployee.getPrimaryKey(), busEmployee);

		busEmployee.resetOriginalValues();
	}

	/**
	 * Caches the bus employees in the entity cache if it is enabled.
	 *
	 * @param busEmployees the bus employees
	 */
	@Override
	public void cacheResult(List<BusEmployee> busEmployees) {
		for (BusEmployee busEmployee : busEmployees) {
			if (EntityCacheUtil.getResult(
						BusEmployeeModelImpl.ENTITY_CACHE_ENABLED,
						BusEmployeeImpl.class, busEmployee.getPrimaryKey()) == null) {
				cacheResult(busEmployee);
			}
			else {
				busEmployee.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bus employees.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BusEmployeeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BusEmployeeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bus employee.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BusEmployee busEmployee) {
		EntityCacheUtil.removeResult(BusEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			BusEmployeeImpl.class, busEmployee.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BusEmployee> busEmployees) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BusEmployee busEmployee : busEmployees) {
			EntityCacheUtil.removeResult(BusEmployeeModelImpl.ENTITY_CACHE_ENABLED,
				BusEmployeeImpl.class, busEmployee.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bus employee with the primary key. Does not add the bus employee to the database.
	 *
	 * @param beId the primary key for the new bus employee
	 * @return the new bus employee
	 */
	@Override
	public BusEmployee create(long beId) {
		BusEmployee busEmployee = new BusEmployeeImpl();

		busEmployee.setNew(true);
		busEmployee.setPrimaryKey(beId);

		return busEmployee;
	}

	/**
	 * Removes the bus employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param beId the primary key of the bus employee
	 * @return the bus employee that was removed
	 * @throws com.services.NoSuchBusEmployeeException if a bus employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusEmployee remove(long beId)
		throws NoSuchBusEmployeeException, SystemException {
		return remove((Serializable)beId);
	}

	/**
	 * Removes the bus employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bus employee
	 * @return the bus employee that was removed
	 * @throws com.services.NoSuchBusEmployeeException if a bus employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusEmployee remove(Serializable primaryKey)
		throws NoSuchBusEmployeeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BusEmployee busEmployee = (BusEmployee)session.get(BusEmployeeImpl.class,
					primaryKey);

			if (busEmployee == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBusEmployeeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(busEmployee);
		}
		catch (NoSuchBusEmployeeException nsee) {
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
	protected BusEmployee removeImpl(BusEmployee busEmployee)
		throws SystemException {
		busEmployee = toUnwrappedModel(busEmployee);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(busEmployee)) {
				busEmployee = (BusEmployee)session.get(BusEmployeeImpl.class,
						busEmployee.getPrimaryKeyObj());
			}

			if (busEmployee != null) {
				session.delete(busEmployee);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (busEmployee != null) {
			clearCache(busEmployee);
		}

		return busEmployee;
	}

	@Override
	public BusEmployee updateImpl(com.services.model.BusEmployee busEmployee)
		throws SystemException {
		busEmployee = toUnwrappedModel(busEmployee);

		boolean isNew = busEmployee.isNew();

		BusEmployeeModelImpl busEmployeeModelImpl = (BusEmployeeModelImpl)busEmployee;

		Session session = null;

		try {
			session = openSession();

			if (busEmployee.isNew()) {
				session.save(busEmployee);

				busEmployee.setNew(false);
			}
			else {
				session.merge(busEmployee);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BusEmployeeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((busEmployeeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AGENCY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						busEmployeeModelImpl.getOriginalAgency()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AGENCY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AGENCY,
					args);

				args = new Object[] { busEmployeeModelImpl.getAgency() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AGENCY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AGENCY,
					args);
			}

			if ((busEmployeeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						busEmployeeModelImpl.getOriginalActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);

				args = new Object[] { busEmployeeModelImpl.getActive() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);
			}
		}

		EntityCacheUtil.putResult(BusEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			BusEmployeeImpl.class, busEmployee.getPrimaryKey(), busEmployee);

		return busEmployee;
	}

	protected BusEmployee toUnwrappedModel(BusEmployee busEmployee) {
		if (busEmployee instanceof BusEmployeeImpl) {
			return busEmployee;
		}

		BusEmployeeImpl busEmployeeImpl = new BusEmployeeImpl();

		busEmployeeImpl.setNew(busEmployee.isNew());
		busEmployeeImpl.setPrimaryKey(busEmployee.getPrimaryKey());

		busEmployeeImpl.setBeId(busEmployee.getBeId());
		busEmployeeImpl.setBeName(busEmployee.getBeName());
		busEmployeeImpl.setAgency(busEmployee.getAgency());
		busEmployeeImpl.setContactNumber(busEmployee.getContactNumber());
		busEmployeeImpl.setEmail(busEmployee.getEmail());
		busEmployeeImpl.setLicenseNumber(busEmployee.getLicenseNumber());
		busEmployeeImpl.setAlternateIdNumber(busEmployee.getAlternateIdNumber());
		busEmployeeImpl.setActive(busEmployee.isActive());
		busEmployeeImpl.setCreateDate(busEmployee.getCreateDate());
		busEmployeeImpl.setModifiedDate(busEmployee.getModifiedDate());

		return busEmployeeImpl;
	}

	/**
	 * Returns the bus employee with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bus employee
	 * @return the bus employee
	 * @throws com.services.NoSuchBusEmployeeException if a bus employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusEmployee findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBusEmployeeException, SystemException {
		BusEmployee busEmployee = fetchByPrimaryKey(primaryKey);

		if (busEmployee == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBusEmployeeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return busEmployee;
	}

	/**
	 * Returns the bus employee with the primary key or throws a {@link com.services.NoSuchBusEmployeeException} if it could not be found.
	 *
	 * @param beId the primary key of the bus employee
	 * @return the bus employee
	 * @throws com.services.NoSuchBusEmployeeException if a bus employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusEmployee findByPrimaryKey(long beId)
		throws NoSuchBusEmployeeException, SystemException {
		return findByPrimaryKey((Serializable)beId);
	}

	/**
	 * Returns the bus employee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bus employee
	 * @return the bus employee, or <code>null</code> if a bus employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusEmployee fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BusEmployee busEmployee = (BusEmployee)EntityCacheUtil.getResult(BusEmployeeModelImpl.ENTITY_CACHE_ENABLED,
				BusEmployeeImpl.class, primaryKey);

		if (busEmployee == _nullBusEmployee) {
			return null;
		}

		if (busEmployee == null) {
			Session session = null;

			try {
				session = openSession();

				busEmployee = (BusEmployee)session.get(BusEmployeeImpl.class,
						primaryKey);

				if (busEmployee != null) {
					cacheResult(busEmployee);
				}
				else {
					EntityCacheUtil.putResult(BusEmployeeModelImpl.ENTITY_CACHE_ENABLED,
						BusEmployeeImpl.class, primaryKey, _nullBusEmployee);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BusEmployeeModelImpl.ENTITY_CACHE_ENABLED,
					BusEmployeeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return busEmployee;
	}

	/**
	 * Returns the bus employee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param beId the primary key of the bus employee
	 * @return the bus employee, or <code>null</code> if a bus employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusEmployee fetchByPrimaryKey(long beId) throws SystemException {
		return fetchByPrimaryKey((Serializable)beId);
	}

	/**
	 * Returns all the bus employees.
	 *
	 * @return the bus employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusEmployee> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<BusEmployee> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<BusEmployee> findAll(int start, int end,
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

		List<BusEmployee> list = (List<BusEmployee>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BUSEMPLOYEE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BUSEMPLOYEE;

				if (pagination) {
					sql = sql.concat(BusEmployeeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BusEmployee>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusEmployee>(list);
				}
				else {
					list = (List<BusEmployee>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the bus employees from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BusEmployee busEmployee : findAll()) {
			remove(busEmployee);
		}
	}

	/**
	 * Returns the number of bus employees.
	 *
	 * @return the number of bus employees
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

				Query q = session.createQuery(_SQL_COUNT_BUSEMPLOYEE);

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
	 * Initializes the bus employee persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.services.model.BusEmployee")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BusEmployee>> listenersList = new ArrayList<ModelListener<BusEmployee>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BusEmployee>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BusEmployeeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BUSEMPLOYEE = "SELECT busEmployee FROM BusEmployee busEmployee";
	private static final String _SQL_SELECT_BUSEMPLOYEE_WHERE = "SELECT busEmployee FROM BusEmployee busEmployee WHERE ";
	private static final String _SQL_COUNT_BUSEMPLOYEE = "SELECT COUNT(busEmployee) FROM BusEmployee busEmployee";
	private static final String _SQL_COUNT_BUSEMPLOYEE_WHERE = "SELECT COUNT(busEmployee) FROM BusEmployee busEmployee WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "busEmployee.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BusEmployee exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BusEmployee exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BusEmployeePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static BusEmployee _nullBusEmployee = new BusEmployeeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BusEmployee> toCacheModel() {
				return _nullBusEmployeeCacheModel;
			}
		};

	private static CacheModel<BusEmployee> _nullBusEmployeeCacheModel = new CacheModel<BusEmployee>() {
			@Override
			public BusEmployee toEntityModel() {
				return _nullBusEmployee;
			}
		};
}