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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.services.NoSuchBusReservationException;

import com.services.model.BusReservation;
import com.services.model.impl.BusReservationImpl;
import com.services.model.impl.BusReservationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the bus reservation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusReservationPersistence
 * @see BusReservationUtil
 * @generated
 */
public class BusReservationPersistenceImpl extends BasePersistenceImpl<BusReservation>
	implements BusReservationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BusReservationUtil} to access the bus reservation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BusReservationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BusReservationModelImpl.ENTITY_CACHE_ENABLED,
			BusReservationModelImpl.FINDER_CACHE_ENABLED,
			BusReservationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BusReservationModelImpl.ENTITY_CACHE_ENABLED,
			BusReservationModelImpl.FINDER_CACHE_ENABLED,
			BusReservationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BusReservationModelImpl.ENTITY_CACHE_ENABLED,
			BusReservationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(BusReservationModelImpl.ENTITY_CACHE_ENABLED,
			BusReservationModelImpl.FINDER_CACHE_ENABLED,
			BusReservationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(BusReservationModelImpl.ENTITY_CACHE_ENABLED,
			BusReservationModelImpl.FINDER_CACHE_ENABLED,
			BusReservationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			BusReservationModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(BusReservationModelImpl.ENTITY_CACHE_ENABLED,
			BusReservationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the bus reservations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching bus reservations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusReservation> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bus reservations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusReservationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of bus reservations
	 * @param end the upper bound of the range of bus reservations (not inclusive)
	 * @return the range of matching bus reservations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusReservation> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bus reservations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusReservationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of bus reservations
	 * @param end the upper bound of the range of bus reservations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bus reservations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusReservation> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<BusReservation> list = (List<BusReservation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusReservation busReservation : list) {
				if ((userId != busReservation.getUserId())) {
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

			query.append(_SQL_SELECT_BUSRESERVATION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusReservationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<BusReservation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusReservation>(list);
				}
				else {
					list = (List<BusReservation>)QueryUtil.list(q,
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
	 * Returns the first bus reservation in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus reservation
	 * @throws com.services.NoSuchBusReservationException if a matching bus reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusReservation findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchBusReservationException, SystemException {
		BusReservation busReservation = fetchByUserId_First(userId,
				orderByComparator);

		if (busReservation != null) {
			return busReservation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusReservationException(msg.toString());
	}

	/**
	 * Returns the first bus reservation in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus reservation, or <code>null</code> if a matching bus reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusReservation fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BusReservation> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bus reservation in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus reservation
	 * @throws com.services.NoSuchBusReservationException if a matching bus reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusReservation findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchBusReservationException, SystemException {
		BusReservation busReservation = fetchByUserId_Last(userId,
				orderByComparator);

		if (busReservation != null) {
			return busReservation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusReservationException(msg.toString());
	}

	/**
	 * Returns the last bus reservation in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus reservation, or <code>null</code> if a matching bus reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusReservation fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<BusReservation> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bus reservations before and after the current bus reservation in the ordered set where userId = &#63;.
	 *
	 * @param brId the primary key of the current bus reservation
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus reservation
	 * @throws com.services.NoSuchBusReservationException if a bus reservation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusReservation[] findByUserId_PrevAndNext(long brId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchBusReservationException, SystemException {
		BusReservation busReservation = findByPrimaryKey(brId);

		Session session = null;

		try {
			session = openSession();

			BusReservation[] array = new BusReservationImpl[3];

			array[0] = getByUserId_PrevAndNext(session, busReservation, userId,
					orderByComparator, true);

			array[1] = busReservation;

			array[2] = getByUserId_PrevAndNext(session, busReservation, userId,
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

	protected BusReservation getByUserId_PrevAndNext(Session session,
		BusReservation busReservation, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUSRESERVATION_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(BusReservationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(busReservation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BusReservation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bus reservations where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (BusReservation busReservation : findByUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(busReservation);
		}
	}

	/**
	 * Returns the number of bus reservations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching bus reservations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BUSRESERVATION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "busReservation.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BAID = new FinderPath(BusReservationModelImpl.ENTITY_CACHE_ENABLED,
			BusReservationModelImpl.FINDER_CACHE_ENABLED,
			BusReservationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByBaId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BAID = new FinderPath(BusReservationModelImpl.ENTITY_CACHE_ENABLED,
			BusReservationModelImpl.FINDER_CACHE_ENABLED,
			BusReservationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBaId",
			new String[] { Long.class.getName() },
			BusReservationModelImpl.BAID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BAID = new FinderPath(BusReservationModelImpl.ENTITY_CACHE_ENABLED,
			BusReservationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBaId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the bus reservations where baId = &#63;.
	 *
	 * @param baId the ba ID
	 * @return the matching bus reservations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusReservation> findByBaId(long baId) throws SystemException {
		return findByBaId(baId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bus reservations where baId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusReservationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param baId the ba ID
	 * @param start the lower bound of the range of bus reservations
	 * @param end the upper bound of the range of bus reservations (not inclusive)
	 * @return the range of matching bus reservations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusReservation> findByBaId(long baId, int start, int end)
		throws SystemException {
		return findByBaId(baId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bus reservations where baId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusReservationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param baId the ba ID
	 * @param start the lower bound of the range of bus reservations
	 * @param end the upper bound of the range of bus reservations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bus reservations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusReservation> findByBaId(long baId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BAID;
			finderArgs = new Object[] { baId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BAID;
			finderArgs = new Object[] { baId, start, end, orderByComparator };
		}

		List<BusReservation> list = (List<BusReservation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusReservation busReservation : list) {
				if ((baId != busReservation.getBaId())) {
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

			query.append(_SQL_SELECT_BUSRESERVATION_WHERE);

			query.append(_FINDER_COLUMN_BAID_BAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusReservationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(baId);

				if (!pagination) {
					list = (List<BusReservation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusReservation>(list);
				}
				else {
					list = (List<BusReservation>)QueryUtil.list(q,
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
	 * Returns the first bus reservation in the ordered set where baId = &#63;.
	 *
	 * @param baId the ba ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus reservation
	 * @throws com.services.NoSuchBusReservationException if a matching bus reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusReservation findByBaId_First(long baId,
		OrderByComparator orderByComparator)
		throws NoSuchBusReservationException, SystemException {
		BusReservation busReservation = fetchByBaId_First(baId,
				orderByComparator);

		if (busReservation != null) {
			return busReservation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("baId=");
		msg.append(baId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusReservationException(msg.toString());
	}

	/**
	 * Returns the first bus reservation in the ordered set where baId = &#63;.
	 *
	 * @param baId the ba ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus reservation, or <code>null</code> if a matching bus reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusReservation fetchByBaId_First(long baId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BusReservation> list = findByBaId(baId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bus reservation in the ordered set where baId = &#63;.
	 *
	 * @param baId the ba ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus reservation
	 * @throws com.services.NoSuchBusReservationException if a matching bus reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusReservation findByBaId_Last(long baId,
		OrderByComparator orderByComparator)
		throws NoSuchBusReservationException, SystemException {
		BusReservation busReservation = fetchByBaId_Last(baId, orderByComparator);

		if (busReservation != null) {
			return busReservation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("baId=");
		msg.append(baId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusReservationException(msg.toString());
	}

	/**
	 * Returns the last bus reservation in the ordered set where baId = &#63;.
	 *
	 * @param baId the ba ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus reservation, or <code>null</code> if a matching bus reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusReservation fetchByBaId_Last(long baId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBaId(baId);

		if (count == 0) {
			return null;
		}

		List<BusReservation> list = findByBaId(baId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bus reservations before and after the current bus reservation in the ordered set where baId = &#63;.
	 *
	 * @param brId the primary key of the current bus reservation
	 * @param baId the ba ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus reservation
	 * @throws com.services.NoSuchBusReservationException if a bus reservation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusReservation[] findByBaId_PrevAndNext(long brId, long baId,
		OrderByComparator orderByComparator)
		throws NoSuchBusReservationException, SystemException {
		BusReservation busReservation = findByPrimaryKey(brId);

		Session session = null;

		try {
			session = openSession();

			BusReservation[] array = new BusReservationImpl[3];

			array[0] = getByBaId_PrevAndNext(session, busReservation, baId,
					orderByComparator, true);

			array[1] = busReservation;

			array[2] = getByBaId_PrevAndNext(session, busReservation, baId,
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

	protected BusReservation getByBaId_PrevAndNext(Session session,
		BusReservation busReservation, long baId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUSRESERVATION_WHERE);

		query.append(_FINDER_COLUMN_BAID_BAID_2);

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
			query.append(BusReservationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(baId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(busReservation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BusReservation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bus reservations where baId = &#63; from the database.
	 *
	 * @param baId the ba ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBaId(long baId) throws SystemException {
		for (BusReservation busReservation : findByBaId(baId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(busReservation);
		}
	}

	/**
	 * Returns the number of bus reservations where baId = &#63;.
	 *
	 * @param baId the ba ID
	 * @return the number of matching bus reservations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBaId(long baId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BAID;

		Object[] finderArgs = new Object[] { baId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BUSRESERVATION_WHERE);

			query.append(_FINDER_COLUMN_BAID_BAID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(baId);

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

	private static final String _FINDER_COLUMN_BAID_BAID_2 = "busReservation.baId = ?";

	public BusReservationPersistenceImpl() {
		setModelClass(BusReservation.class);
	}

	/**
	 * Caches the bus reservation in the entity cache if it is enabled.
	 *
	 * @param busReservation the bus reservation
	 */
	@Override
	public void cacheResult(BusReservation busReservation) {
		EntityCacheUtil.putResult(BusReservationModelImpl.ENTITY_CACHE_ENABLED,
			BusReservationImpl.class, busReservation.getPrimaryKey(),
			busReservation);

		busReservation.resetOriginalValues();
	}

	/**
	 * Caches the bus reservations in the entity cache if it is enabled.
	 *
	 * @param busReservations the bus reservations
	 */
	@Override
	public void cacheResult(List<BusReservation> busReservations) {
		for (BusReservation busReservation : busReservations) {
			if (EntityCacheUtil.getResult(
						BusReservationModelImpl.ENTITY_CACHE_ENABLED,
						BusReservationImpl.class, busReservation.getPrimaryKey()) == null) {
				cacheResult(busReservation);
			}
			else {
				busReservation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bus reservations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BusReservationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BusReservationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bus reservation.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BusReservation busReservation) {
		EntityCacheUtil.removeResult(BusReservationModelImpl.ENTITY_CACHE_ENABLED,
			BusReservationImpl.class, busReservation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BusReservation> busReservations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BusReservation busReservation : busReservations) {
			EntityCacheUtil.removeResult(BusReservationModelImpl.ENTITY_CACHE_ENABLED,
				BusReservationImpl.class, busReservation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bus reservation with the primary key. Does not add the bus reservation to the database.
	 *
	 * @param brId the primary key for the new bus reservation
	 * @return the new bus reservation
	 */
	@Override
	public BusReservation create(long brId) {
		BusReservation busReservation = new BusReservationImpl();

		busReservation.setNew(true);
		busReservation.setPrimaryKey(brId);

		return busReservation;
	}

	/**
	 * Removes the bus reservation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param brId the primary key of the bus reservation
	 * @return the bus reservation that was removed
	 * @throws com.services.NoSuchBusReservationException if a bus reservation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusReservation remove(long brId)
		throws NoSuchBusReservationException, SystemException {
		return remove((Serializable)brId);
	}

	/**
	 * Removes the bus reservation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bus reservation
	 * @return the bus reservation that was removed
	 * @throws com.services.NoSuchBusReservationException if a bus reservation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusReservation remove(Serializable primaryKey)
		throws NoSuchBusReservationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BusReservation busReservation = (BusReservation)session.get(BusReservationImpl.class,
					primaryKey);

			if (busReservation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBusReservationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(busReservation);
		}
		catch (NoSuchBusReservationException nsee) {
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
	protected BusReservation removeImpl(BusReservation busReservation)
		throws SystemException {
		busReservation = toUnwrappedModel(busReservation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(busReservation)) {
				busReservation = (BusReservation)session.get(BusReservationImpl.class,
						busReservation.getPrimaryKeyObj());
			}

			if (busReservation != null) {
				session.delete(busReservation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (busReservation != null) {
			clearCache(busReservation);
		}

		return busReservation;
	}

	@Override
	public BusReservation updateImpl(
		com.services.model.BusReservation busReservation)
		throws SystemException {
		busReservation = toUnwrappedModel(busReservation);

		boolean isNew = busReservation.isNew();

		BusReservationModelImpl busReservationModelImpl = (BusReservationModelImpl)busReservation;

		Session session = null;

		try {
			session = openSession();

			if (busReservation.isNew()) {
				session.save(busReservation);

				busReservation.setNew(false);
			}
			else {
				session.merge(busReservation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BusReservationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((busReservationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						busReservationModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { busReservationModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((busReservationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BAID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						busReservationModelImpl.getOriginalBaId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BAID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BAID,
					args);

				args = new Object[] { busReservationModelImpl.getBaId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BAID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BAID,
					args);
			}
		}

		EntityCacheUtil.putResult(BusReservationModelImpl.ENTITY_CACHE_ENABLED,
			BusReservationImpl.class, busReservation.getPrimaryKey(),
			busReservation);

		return busReservation;
	}

	protected BusReservation toUnwrappedModel(BusReservation busReservation) {
		if (busReservation instanceof BusReservationImpl) {
			return busReservation;
		}

		BusReservationImpl busReservationImpl = new BusReservationImpl();

		busReservationImpl.setNew(busReservation.isNew());
		busReservationImpl.setPrimaryKey(busReservation.getPrimaryKey());

		busReservationImpl.setBrId(busReservation.getBrId());
		busReservationImpl.setBaId(busReservation.getBaId());
		busReservationImpl.setUserId(busReservation.getUserId());
		busReservationImpl.setPaymentReceived(busReservation.isPaymentReceived());
		busReservationImpl.setBookingDate(busReservation.getBookingDate());

		return busReservationImpl;
	}

	/**
	 * Returns the bus reservation with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bus reservation
	 * @return the bus reservation
	 * @throws com.services.NoSuchBusReservationException if a bus reservation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusReservation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBusReservationException, SystemException {
		BusReservation busReservation = fetchByPrimaryKey(primaryKey);

		if (busReservation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBusReservationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return busReservation;
	}

	/**
	 * Returns the bus reservation with the primary key or throws a {@link com.services.NoSuchBusReservationException} if it could not be found.
	 *
	 * @param brId the primary key of the bus reservation
	 * @return the bus reservation
	 * @throws com.services.NoSuchBusReservationException if a bus reservation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusReservation findByPrimaryKey(long brId)
		throws NoSuchBusReservationException, SystemException {
		return findByPrimaryKey((Serializable)brId);
	}

	/**
	 * Returns the bus reservation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bus reservation
	 * @return the bus reservation, or <code>null</code> if a bus reservation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusReservation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BusReservation busReservation = (BusReservation)EntityCacheUtil.getResult(BusReservationModelImpl.ENTITY_CACHE_ENABLED,
				BusReservationImpl.class, primaryKey);

		if (busReservation == _nullBusReservation) {
			return null;
		}

		if (busReservation == null) {
			Session session = null;

			try {
				session = openSession();

				busReservation = (BusReservation)session.get(BusReservationImpl.class,
						primaryKey);

				if (busReservation != null) {
					cacheResult(busReservation);
				}
				else {
					EntityCacheUtil.putResult(BusReservationModelImpl.ENTITY_CACHE_ENABLED,
						BusReservationImpl.class, primaryKey,
						_nullBusReservation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BusReservationModelImpl.ENTITY_CACHE_ENABLED,
					BusReservationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return busReservation;
	}

	/**
	 * Returns the bus reservation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param brId the primary key of the bus reservation
	 * @return the bus reservation, or <code>null</code> if a bus reservation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusReservation fetchByPrimaryKey(long brId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)brId);
	}

	/**
	 * Returns all the bus reservations.
	 *
	 * @return the bus reservations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusReservation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bus reservations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusReservationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bus reservations
	 * @param end the upper bound of the range of bus reservations (not inclusive)
	 * @return the range of bus reservations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusReservation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bus reservations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BusReservationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bus reservations
	 * @param end the upper bound of the range of bus reservations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bus reservations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusReservation> findAll(int start, int end,
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

		List<BusReservation> list = (List<BusReservation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BUSRESERVATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BUSRESERVATION;

				if (pagination) {
					sql = sql.concat(BusReservationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BusReservation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusReservation>(list);
				}
				else {
					list = (List<BusReservation>)QueryUtil.list(q,
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
	 * Removes all the bus reservations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BusReservation busReservation : findAll()) {
			remove(busReservation);
		}
	}

	/**
	 * Returns the number of bus reservations.
	 *
	 * @return the number of bus reservations
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

				Query q = session.createQuery(_SQL_COUNT_BUSRESERVATION);

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
	 * Initializes the bus reservation persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.services.model.BusReservation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BusReservation>> listenersList = new ArrayList<ModelListener<BusReservation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BusReservation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BusReservationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BUSRESERVATION = "SELECT busReservation FROM BusReservation busReservation";
	private static final String _SQL_SELECT_BUSRESERVATION_WHERE = "SELECT busReservation FROM BusReservation busReservation WHERE ";
	private static final String _SQL_COUNT_BUSRESERVATION = "SELECT COUNT(busReservation) FROM BusReservation busReservation";
	private static final String _SQL_COUNT_BUSRESERVATION_WHERE = "SELECT COUNT(busReservation) FROM BusReservation busReservation WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "busReservation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BusReservation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BusReservation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BusReservationPersistenceImpl.class);
	private static BusReservation _nullBusReservation = new BusReservationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BusReservation> toCacheModel() {
				return _nullBusReservationCacheModel;
			}
		};

	private static CacheModel<BusReservation> _nullBusReservationCacheModel = new CacheModel<BusReservation>() {
			@Override
			public BusReservation toEntityModel() {
				return _nullBusReservation;
			}
		};
}