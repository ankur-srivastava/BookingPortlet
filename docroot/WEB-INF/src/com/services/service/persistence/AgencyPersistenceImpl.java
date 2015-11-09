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

import com.services.NoSuchAgencyException;

import com.services.model.Agency;
import com.services.model.impl.AgencyImpl;
import com.services.model.impl.AgencyModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the agency service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see AgencyPersistence
 * @see AgencyUtil
 * @generated
 */
public class AgencyPersistenceImpl extends BasePersistenceImpl<Agency>
	implements AgencyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AgencyUtil} to access the agency persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AgencyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, AgencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, AgencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OWNER = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, AgencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOwner",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNER = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, AgencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOwner",
			new String[] { String.class.getName() },
			AgencyModelImpl.OWNER_COLUMN_BITMASK |
			AgencyModelImpl.AGENCYNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OWNER = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOwner",
			new String[] { String.class.getName() });

	/**
	 * Returns all the agencies where owner = &#63;.
	 *
	 * @param owner the owner
	 * @return the matching agencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Agency> findByOwner(String owner) throws SystemException {
		return findByOwner(owner, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Agency> findByOwner(String owner, int start, int end)
		throws SystemException {
		return findByOwner(owner, start, end, null);
	}

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
	@Override
	public List<Agency> findByOwner(String owner, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNER;
			finderArgs = new Object[] { owner };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OWNER;
			finderArgs = new Object[] { owner, start, end, orderByComparator };
		}

		List<Agency> list = (List<Agency>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Agency agency : list) {
				if (!Validator.equals(owner, agency.getOwner())) {
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

			query.append(_SQL_SELECT_AGENCY_WHERE);

			boolean bindOwner = false;

			if (owner == null) {
				query.append(_FINDER_COLUMN_OWNER_OWNER_1);
			}
			else if (owner.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OWNER_OWNER_3);
			}
			else {
				bindOwner = true;

				query.append(_FINDER_COLUMN_OWNER_OWNER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AgencyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOwner) {
					qPos.add(owner);
				}

				if (!pagination) {
					list = (List<Agency>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Agency>(list);
				}
				else {
					list = (List<Agency>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first agency in the ordered set where owner = &#63;.
	 *
	 * @param owner the owner
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agency
	 * @throws com.services.NoSuchAgencyException if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency findByOwner_First(String owner,
		OrderByComparator orderByComparator)
		throws NoSuchAgencyException, SystemException {
		Agency agency = fetchByOwner_First(owner, orderByComparator);

		if (agency != null) {
			return agency;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("owner=");
		msg.append(owner);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAgencyException(msg.toString());
	}

	/**
	 * Returns the first agency in the ordered set where owner = &#63;.
	 *
	 * @param owner the owner
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agency, or <code>null</code> if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency fetchByOwner_First(String owner,
		OrderByComparator orderByComparator) throws SystemException {
		List<Agency> list = findByOwner(owner, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agency in the ordered set where owner = &#63;.
	 *
	 * @param owner the owner
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agency
	 * @throws com.services.NoSuchAgencyException if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency findByOwner_Last(String owner,
		OrderByComparator orderByComparator)
		throws NoSuchAgencyException, SystemException {
		Agency agency = fetchByOwner_Last(owner, orderByComparator);

		if (agency != null) {
			return agency;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("owner=");
		msg.append(owner);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAgencyException(msg.toString());
	}

	/**
	 * Returns the last agency in the ordered set where owner = &#63;.
	 *
	 * @param owner the owner
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agency, or <code>null</code> if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency fetchByOwner_Last(String owner,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOwner(owner);

		if (count == 0) {
			return null;
		}

		List<Agency> list = findByOwner(owner, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Agency[] findByOwner_PrevAndNext(long agencyId, String owner,
		OrderByComparator orderByComparator)
		throws NoSuchAgencyException, SystemException {
		Agency agency = findByPrimaryKey(agencyId);

		Session session = null;

		try {
			session = openSession();

			Agency[] array = new AgencyImpl[3];

			array[0] = getByOwner_PrevAndNext(session, agency, owner,
					orderByComparator, true);

			array[1] = agency;

			array[2] = getByOwner_PrevAndNext(session, agency, owner,
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

	protected Agency getByOwner_PrevAndNext(Session session, Agency agency,
		String owner, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AGENCY_WHERE);

		boolean bindOwner = false;

		if (owner == null) {
			query.append(_FINDER_COLUMN_OWNER_OWNER_1);
		}
		else if (owner.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_OWNER_OWNER_3);
		}
		else {
			bindOwner = true;

			query.append(_FINDER_COLUMN_OWNER_OWNER_2);
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
			query.append(AgencyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindOwner) {
			qPos.add(owner);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(agency);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Agency> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agencies where owner = &#63; from the database.
	 *
	 * @param owner the owner
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOwner(String owner) throws SystemException {
		for (Agency agency : findByOwner(owner, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(agency);
		}
	}

	/**
	 * Returns the number of agencies where owner = &#63;.
	 *
	 * @param owner the owner
	 * @return the number of matching agencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOwner(String owner) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OWNER;

		Object[] finderArgs = new Object[] { owner };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AGENCY_WHERE);

			boolean bindOwner = false;

			if (owner == null) {
				query.append(_FINDER_COLUMN_OWNER_OWNER_1);
			}
			else if (owner.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OWNER_OWNER_3);
			}
			else {
				bindOwner = true;

				query.append(_FINDER_COLUMN_OWNER_OWNER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOwner) {
					qPos.add(owner);
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

	private static final String _FINDER_COLUMN_OWNER_OWNER_1 = "agency.owner IS NULL";
	private static final String _FINDER_COLUMN_OWNER_OWNER_2 = "agency.owner = ?";
	private static final String _FINDER_COLUMN_OWNER_OWNER_3 = "(agency.owner IS NULL OR agency.owner = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVE = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, AgencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActive",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE =
		new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, AgencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActive",
			new String[] { Boolean.class.getName() },
			AgencyModelImpl.ACTIVE_COLUMN_BITMASK |
			AgencyModelImpl.AGENCYNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActive",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the agencies where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching agencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Agency> findByActive(boolean active) throws SystemException {
		return findByActive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Agency> findByActive(boolean active, int start, int end)
		throws SystemException {
		return findByActive(active, start, end, null);
	}

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
	@Override
	public List<Agency> findByActive(boolean active, int start, int end,
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

		List<Agency> list = (List<Agency>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Agency agency : list) {
				if ((active != agency.getActive())) {
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

			query.append(_SQL_SELECT_AGENCY_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AgencyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				if (!pagination) {
					list = (List<Agency>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Agency>(list);
				}
				else {
					list = (List<Agency>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first agency in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agency
	 * @throws com.services.NoSuchAgencyException if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency findByActive_First(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchAgencyException, SystemException {
		Agency agency = fetchByActive_First(active, orderByComparator);

		if (agency != null) {
			return agency;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAgencyException(msg.toString());
	}

	/**
	 * Returns the first agency in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agency, or <code>null</code> if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency fetchByActive_First(boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		List<Agency> list = findByActive(active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agency in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agency
	 * @throws com.services.NoSuchAgencyException if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency findByActive_Last(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchAgencyException, SystemException {
		Agency agency = fetchByActive_Last(active, orderByComparator);

		if (agency != null) {
			return agency;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAgencyException(msg.toString());
	}

	/**
	 * Returns the last agency in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agency, or <code>null</code> if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency fetchByActive_Last(boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByActive(active);

		if (count == 0) {
			return null;
		}

		List<Agency> list = findByActive(active, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Agency[] findByActive_PrevAndNext(long agencyId, boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchAgencyException, SystemException {
		Agency agency = findByPrimaryKey(agencyId);

		Session session = null;

		try {
			session = openSession();

			Agency[] array = new AgencyImpl[3];

			array[0] = getByActive_PrevAndNext(session, agency, active,
					orderByComparator, true);

			array[1] = agency;

			array[2] = getByActive_PrevAndNext(session, agency, active,
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

	protected Agency getByActive_PrevAndNext(Session session, Agency agency,
		boolean active, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AGENCY_WHERE);

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
			query.append(AgencyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(agency);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Agency> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agencies where active = &#63; from the database.
	 *
	 * @param active the active
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByActive(boolean active) throws SystemException {
		for (Agency agency : findByActive(active, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(agency);
		}
	}

	/**
	 * Returns the number of agencies where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching agencies
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

			query.append(_SQL_COUNT_AGENCY_WHERE);

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

	private static final String _FINDER_COLUMN_ACTIVE_ACTIVE_2 = "agency.active = ?";

	public AgencyPersistenceImpl() {
		setModelClass(Agency.class);
	}

	/**
	 * Caches the agency in the entity cache if it is enabled.
	 *
	 * @param agency the agency
	 */
	@Override
	public void cacheResult(Agency agency) {
		EntityCacheUtil.putResult(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyImpl.class, agency.getPrimaryKey(), agency);

		agency.resetOriginalValues();
	}

	/**
	 * Caches the agencies in the entity cache if it is enabled.
	 *
	 * @param agencies the agencies
	 */
	@Override
	public void cacheResult(List<Agency> agencies) {
		for (Agency agency : agencies) {
			if (EntityCacheUtil.getResult(
						AgencyModelImpl.ENTITY_CACHE_ENABLED, AgencyImpl.class,
						agency.getPrimaryKey()) == null) {
				cacheResult(agency);
			}
			else {
				agency.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all agencies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AgencyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AgencyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the agency.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Agency agency) {
		EntityCacheUtil.removeResult(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyImpl.class, agency.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Agency> agencies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Agency agency : agencies) {
			EntityCacheUtil.removeResult(AgencyModelImpl.ENTITY_CACHE_ENABLED,
				AgencyImpl.class, agency.getPrimaryKey());
		}
	}

	/**
	 * Creates a new agency with the primary key. Does not add the agency to the database.
	 *
	 * @param agencyId the primary key for the new agency
	 * @return the new agency
	 */
	@Override
	public Agency create(long agencyId) {
		Agency agency = new AgencyImpl();

		agency.setNew(true);
		agency.setPrimaryKey(agencyId);

		return agency;
	}

	/**
	 * Removes the agency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agencyId the primary key of the agency
	 * @return the agency that was removed
	 * @throws com.services.NoSuchAgencyException if a agency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency remove(long agencyId)
		throws NoSuchAgencyException, SystemException {
		return remove((Serializable)agencyId);
	}

	/**
	 * Removes the agency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the agency
	 * @return the agency that was removed
	 * @throws com.services.NoSuchAgencyException if a agency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency remove(Serializable primaryKey)
		throws NoSuchAgencyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Agency agency = (Agency)session.get(AgencyImpl.class, primaryKey);

			if (agency == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAgencyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(agency);
		}
		catch (NoSuchAgencyException nsee) {
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
	protected Agency removeImpl(Agency agency) throws SystemException {
		agency = toUnwrappedModel(agency);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(agency)) {
				agency = (Agency)session.get(AgencyImpl.class,
						agency.getPrimaryKeyObj());
			}

			if (agency != null) {
				session.delete(agency);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (agency != null) {
			clearCache(agency);
		}

		return agency;
	}

	@Override
	public Agency updateImpl(com.services.model.Agency agency)
		throws SystemException {
		agency = toUnwrappedModel(agency);

		boolean isNew = agency.isNew();

		AgencyModelImpl agencyModelImpl = (AgencyModelImpl)agency;

		Session session = null;

		try {
			session = openSession();

			if (agency.isNew()) {
				session.save(agency);

				agency.setNew(false);
			}
			else {
				session.merge(agency);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AgencyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((agencyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { agencyModelImpl.getOriginalOwner() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OWNER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNER,
					args);

				args = new Object[] { agencyModelImpl.getOwner() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OWNER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNER,
					args);
			}

			if ((agencyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { agencyModelImpl.getOriginalActive() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);

				args = new Object[] { agencyModelImpl.getActive() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);
			}
		}

		EntityCacheUtil.putResult(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyImpl.class, agency.getPrimaryKey(), agency);

		return agency;
	}

	protected Agency toUnwrappedModel(Agency agency) {
		if (agency instanceof AgencyImpl) {
			return agency;
		}

		AgencyImpl agencyImpl = new AgencyImpl();

		agencyImpl.setNew(agency.isNew());
		agencyImpl.setPrimaryKey(agency.getPrimaryKey());

		agencyImpl.setAgencyId(agency.getAgencyId());
		agencyImpl.setAgencyName(agency.getAgencyName());
		agencyImpl.setOwner(agency.getOwner());
		agencyImpl.setContactNumber(agency.getContactNumber());
		agencyImpl.setEmail(agency.getEmail());
		agencyImpl.setActive(agency.isActive());
		agencyImpl.setCreateDate(agency.getCreateDate());
		agencyImpl.setModifiedDate(agency.getModifiedDate());

		return agencyImpl;
	}

	/**
	 * Returns the agency with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the agency
	 * @return the agency
	 * @throws com.services.NoSuchAgencyException if a agency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAgencyException, SystemException {
		Agency agency = fetchByPrimaryKey(primaryKey);

		if (agency == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAgencyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return agency;
	}

	/**
	 * Returns the agency with the primary key or throws a {@link com.services.NoSuchAgencyException} if it could not be found.
	 *
	 * @param agencyId the primary key of the agency
	 * @return the agency
	 * @throws com.services.NoSuchAgencyException if a agency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency findByPrimaryKey(long agencyId)
		throws NoSuchAgencyException, SystemException {
		return findByPrimaryKey((Serializable)agencyId);
	}

	/**
	 * Returns the agency with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the agency
	 * @return the agency, or <code>null</code> if a agency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Agency agency = (Agency)EntityCacheUtil.getResult(AgencyModelImpl.ENTITY_CACHE_ENABLED,
				AgencyImpl.class, primaryKey);

		if (agency == _nullAgency) {
			return null;
		}

		if (agency == null) {
			Session session = null;

			try {
				session = openSession();

				agency = (Agency)session.get(AgencyImpl.class, primaryKey);

				if (agency != null) {
					cacheResult(agency);
				}
				else {
					EntityCacheUtil.putResult(AgencyModelImpl.ENTITY_CACHE_ENABLED,
						AgencyImpl.class, primaryKey, _nullAgency);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AgencyModelImpl.ENTITY_CACHE_ENABLED,
					AgencyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return agency;
	}

	/**
	 * Returns the agency with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agencyId the primary key of the agency
	 * @return the agency, or <code>null</code> if a agency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency fetchByPrimaryKey(long agencyId) throws SystemException {
		return fetchByPrimaryKey((Serializable)agencyId);
	}

	/**
	 * Returns all the agencies.
	 *
	 * @return the agencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Agency> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Agency> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Agency> findAll(int start, int end,
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

		List<Agency> list = (List<Agency>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_AGENCY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AGENCY;

				if (pagination) {
					sql = sql.concat(AgencyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Agency>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Agency>(list);
				}
				else {
					list = (List<Agency>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the agencies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Agency agency : findAll()) {
			remove(agency);
		}
	}

	/**
	 * Returns the number of agencies.
	 *
	 * @return the number of agencies
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

				Query q = session.createQuery(_SQL_COUNT_AGENCY);

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
	 * Initializes the agency persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.services.model.Agency")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Agency>> listenersList = new ArrayList<ModelListener<Agency>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Agency>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AgencyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_AGENCY = "SELECT agency FROM Agency agency";
	private static final String _SQL_SELECT_AGENCY_WHERE = "SELECT agency FROM Agency agency WHERE ";
	private static final String _SQL_COUNT_AGENCY = "SELECT COUNT(agency) FROM Agency agency";
	private static final String _SQL_COUNT_AGENCY_WHERE = "SELECT COUNT(agency) FROM Agency agency WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "agency.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Agency exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Agency exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AgencyPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static Agency _nullAgency = new AgencyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Agency> toCacheModel() {
				return _nullAgencyCacheModel;
			}
		};

	private static CacheModel<Agency> _nullAgencyCacheModel = new CacheModel<Agency>() {
			@Override
			public Agency toEntityModel() {
				return _nullAgency;
			}
		};
}