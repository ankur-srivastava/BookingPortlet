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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.services.NoSuchBookingStatusException;

import com.services.model.BookingStatus;
import com.services.model.impl.BookingStatusImpl;
import com.services.model.impl.BookingStatusModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the booking status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see BookingStatusPersistence
 * @see BookingStatusUtil
 * @generated
 */
public class BookingStatusPersistenceImpl extends BasePersistenceImpl<BookingStatus>
	implements BookingStatusPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BookingStatusUtil} to access the booking status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BookingStatusImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
			BookingStatusModelImpl.FINDER_CACHE_ENABLED,
			BookingStatusImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
			BookingStatusModelImpl.FINDER_CACHE_ENABLED,
			BookingStatusImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
			BookingStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYUSERID = new FinderPath(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
			BookingStatusModelImpl.FINDER_CACHE_ENABLED,
			BookingStatusImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBybyUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID =
		new FinderPath(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
			BookingStatusModelImpl.FINDER_CACHE_ENABLED,
			BookingStatusImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBybyUserId", new String[] { Long.class.getName() },
			BookingStatusModelImpl.USERID_COLUMN_BITMASK |
			BookingStatusModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYUSERID = new FinderPath(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
			BookingStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the booking statuses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BookingStatus> findBybyUserId(long userId)
		throws SystemException {
		return findBybyUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the booking statuses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of booking statuses
	 * @param end the upper bound of the range of booking statuses (not inclusive)
	 * @return the range of matching booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BookingStatus> findBybyUserId(long userId, int start, int end)
		throws SystemException {
		return findBybyUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking statuses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of booking statuses
	 * @param end the upper bound of the range of booking statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BookingStatus> findBybyUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYUSERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<BookingStatus> list = (List<BookingStatus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BookingStatus bookingStatus : list) {
				if ((userId != bookingStatus.getUserId())) {
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

			query.append(_SQL_SELECT_BOOKINGSTATUS_WHERE);

			query.append(_FINDER_COLUMN_BYUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BookingStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<BookingStatus>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BookingStatus>(list);
				}
				else {
					list = (List<BookingStatus>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first booking status in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking status
	 * @throws com.services.NoSuchBookingStatusException if a matching booking status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus findBybyUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchBookingStatusException, SystemException {
		BookingStatus bookingStatus = fetchBybyUserId_First(userId,
				orderByComparator);

		if (bookingStatus != null) {
			return bookingStatus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingStatusException(msg.toString());
	}

	/**
	 * Returns the first booking status in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking status, or <code>null</code> if a matching booking status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus fetchBybyUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BookingStatus> list = findBybyUserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last booking status in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking status
	 * @throws com.services.NoSuchBookingStatusException if a matching booking status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus findBybyUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchBookingStatusException, SystemException {
		BookingStatus bookingStatus = fetchBybyUserId_Last(userId,
				orderByComparator);

		if (bookingStatus != null) {
			return bookingStatus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingStatusException(msg.toString());
	}

	/**
	 * Returns the last booking status in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking status, or <code>null</code> if a matching booking status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus fetchBybyUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybyUserId(userId);

		if (count == 0) {
			return null;
		}

		List<BookingStatus> list = findBybyUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the booking statuses before and after the current booking status in the ordered set where userId = &#63;.
	 *
	 * @param bsId the primary key of the current booking status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking status
	 * @throws com.services.NoSuchBookingStatusException if a booking status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus[] findBybyUserId_PrevAndNext(long bsId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchBookingStatusException, SystemException {
		BookingStatus bookingStatus = findByPrimaryKey(bsId);

		Session session = null;

		try {
			session = openSession();

			BookingStatus[] array = new BookingStatusImpl[3];

			array[0] = getBybyUserId_PrevAndNext(session, bookingStatus,
					userId, orderByComparator, true);

			array[1] = bookingStatus;

			array[2] = getBybyUserId_PrevAndNext(session, bookingStatus,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BookingStatus getBybyUserId_PrevAndNext(Session session,
		BookingStatus bookingStatus, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKINGSTATUS_WHERE);

		query.append(_FINDER_COLUMN_BYUSERID_USERID_2);

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
			query.append(BookingStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bookingStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BookingStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the booking statuses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyUserId(long userId) throws SystemException {
		for (BookingStatus bookingStatus : findBybyUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(bookingStatus);
		}
	}

	/**
	 * Returns the number of booking statuses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYUSERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOKINGSTATUS_WHERE);

			query.append(_FINDER_COLUMN_BYUSERID_USERID_2);

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

	private static final String _FINDER_COLUMN_BYUSERID_USERID_2 = "bookingStatus.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYUSERANDSTATUS =
		new FinderPath(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
			BookingStatusModelImpl.FINDER_CACHE_ENABLED,
			BookingStatusImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBybyUserAndStatus",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERANDSTATUS =
		new FinderPath(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
			BookingStatusModelImpl.FINDER_CACHE_ENABLED,
			BookingStatusImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBybyUserAndStatus",
			new String[] { Long.class.getName(), String.class.getName() },
			BookingStatusModelImpl.USERID_COLUMN_BITMASK |
			BookingStatusModelImpl.STATUS_COLUMN_BITMASK |
			BookingStatusModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYUSERANDSTATUS = new FinderPath(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
			BookingStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBybyUserAndStatus",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the booking statuses where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BookingStatus> findBybyUserAndStatus(long userId, String status)
		throws SystemException {
		return findBybyUserAndStatus(userId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the booking statuses where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of booking statuses
	 * @param end the upper bound of the range of booking statuses (not inclusive)
	 * @return the range of matching booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BookingStatus> findBybyUserAndStatus(long userId,
		String status, int start, int end) throws SystemException {
		return findBybyUserAndStatus(userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking statuses where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of booking statuses
	 * @param end the upper bound of the range of booking statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BookingStatus> findBybyUserAndStatus(long userId,
		String status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERANDSTATUS;
			finderArgs = new Object[] { userId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYUSERANDSTATUS;
			finderArgs = new Object[] {
					userId, status,
					
					start, end, orderByComparator
				};
		}

		List<BookingStatus> list = (List<BookingStatus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BookingStatus bookingStatus : list) {
				if ((userId != bookingStatus.getUserId()) ||
						!Validator.equals(status, bookingStatus.getStatus())) {
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

			query.append(_SQL_SELECT_BOOKINGSTATUS_WHERE);

			query.append(_FINDER_COLUMN_BYUSERANDSTATUS_USERID_2);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_BYUSERANDSTATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYUSERANDSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_BYUSERANDSTATUS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BookingStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindStatus) {
					qPos.add(status);
				}

				if (!pagination) {
					list = (List<BookingStatus>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BookingStatus>(list);
				}
				else {
					list = (List<BookingStatus>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first booking status in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking status
	 * @throws com.services.NoSuchBookingStatusException if a matching booking status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus findBybyUserAndStatus_First(long userId,
		String status, OrderByComparator orderByComparator)
		throws NoSuchBookingStatusException, SystemException {
		BookingStatus bookingStatus = fetchBybyUserAndStatus_First(userId,
				status, orderByComparator);

		if (bookingStatus != null) {
			return bookingStatus;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingStatusException(msg.toString());
	}

	/**
	 * Returns the first booking status in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking status, or <code>null</code> if a matching booking status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus fetchBybyUserAndStatus_First(long userId,
		String status, OrderByComparator orderByComparator)
		throws SystemException {
		List<BookingStatus> list = findBybyUserAndStatus(userId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last booking status in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking status
	 * @throws com.services.NoSuchBookingStatusException if a matching booking status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus findBybyUserAndStatus_Last(long userId, String status,
		OrderByComparator orderByComparator)
		throws NoSuchBookingStatusException, SystemException {
		BookingStatus bookingStatus = fetchBybyUserAndStatus_Last(userId,
				status, orderByComparator);

		if (bookingStatus != null) {
			return bookingStatus;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingStatusException(msg.toString());
	}

	/**
	 * Returns the last booking status in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking status, or <code>null</code> if a matching booking status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus fetchBybyUserAndStatus_Last(long userId,
		String status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBybyUserAndStatus(userId, status);

		if (count == 0) {
			return null;
		}

		List<BookingStatus> list = findBybyUserAndStatus(userId, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the booking statuses before and after the current booking status in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param bsId the primary key of the current booking status
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking status
	 * @throws com.services.NoSuchBookingStatusException if a booking status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus[] findBybyUserAndStatus_PrevAndNext(long bsId,
		long userId, String status, OrderByComparator orderByComparator)
		throws NoSuchBookingStatusException, SystemException {
		BookingStatus bookingStatus = findByPrimaryKey(bsId);

		Session session = null;

		try {
			session = openSession();

			BookingStatus[] array = new BookingStatusImpl[3];

			array[0] = getBybyUserAndStatus_PrevAndNext(session, bookingStatus,
					userId, status, orderByComparator, true);

			array[1] = bookingStatus;

			array[2] = getBybyUserAndStatus_PrevAndNext(session, bookingStatus,
					userId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BookingStatus getBybyUserAndStatus_PrevAndNext(Session session,
		BookingStatus bookingStatus, long userId, String status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKINGSTATUS_WHERE);

		query.append(_FINDER_COLUMN_BYUSERANDSTATUS_USERID_2);

		boolean bindStatus = false;

		if (status == null) {
			query.append(_FINDER_COLUMN_BYUSERANDSTATUS_STATUS_1);
		}
		else if (status.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BYUSERANDSTATUS_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_BYUSERANDSTATUS_STATUS_2);
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
			query.append(BookingStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (bindStatus) {
			qPos.add(status);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bookingStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BookingStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the booking statuses where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyUserAndStatus(long userId, String status)
		throws SystemException {
		for (BookingStatus bookingStatus : findBybyUserAndStatus(userId,
				status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(bookingStatus);
		}
	}

	/**
	 * Returns the number of booking statuses where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyUserAndStatus(long userId, String status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYUSERANDSTATUS;

		Object[] finderArgs = new Object[] { userId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BOOKINGSTATUS_WHERE);

			query.append(_FINDER_COLUMN_BYUSERANDSTATUS_USERID_2);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_BYUSERANDSTATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYUSERANDSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_BYUSERANDSTATUS_STATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindStatus) {
					qPos.add(status);
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

	private static final String _FINDER_COLUMN_BYUSERANDSTATUS_USERID_2 = "bookingStatus.userId = ? AND ";
	private static final String _FINDER_COLUMN_BYUSERANDSTATUS_STATUS_1 = "bookingStatus.status IS NULL";
	private static final String _FINDER_COLUMN_BYUSERANDSTATUS_STATUS_2 = "bookingStatus.status = ?";
	private static final String _FINDER_COLUMN_BYUSERANDSTATUS_STATUS_3 = "(bookingStatus.status IS NULL OR bookingStatus.status = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYBRTID = new FinderPath(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
			BookingStatusModelImpl.FINDER_CACHE_ENABLED,
			BookingStatusImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBybyBrtId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYBRTID =
		new FinderPath(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
			BookingStatusModelImpl.FINDER_CACHE_ENABLED,
			BookingStatusImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBybyBrtId", new String[] { Long.class.getName() },
			BookingStatusModelImpl.BRTID_COLUMN_BITMASK |
			BookingStatusModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYBRTID = new FinderPath(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
			BookingStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyBrtId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the booking statuses where brtId = &#63;.
	 *
	 * @param brtId the brt ID
	 * @return the matching booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BookingStatus> findBybyBrtId(long brtId)
		throws SystemException {
		return findBybyBrtId(brtId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the booking statuses where brtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param brtId the brt ID
	 * @param start the lower bound of the range of booking statuses
	 * @param end the upper bound of the range of booking statuses (not inclusive)
	 * @return the range of matching booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BookingStatus> findBybyBrtId(long brtId, int start, int end)
		throws SystemException {
		return findBybyBrtId(brtId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking statuses where brtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param brtId the brt ID
	 * @param start the lower bound of the range of booking statuses
	 * @param end the upper bound of the range of booking statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BookingStatus> findBybyBrtId(long brtId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYBRTID;
			finderArgs = new Object[] { brtId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYBRTID;
			finderArgs = new Object[] { brtId, start, end, orderByComparator };
		}

		List<BookingStatus> list = (List<BookingStatus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BookingStatus bookingStatus : list) {
				if ((brtId != bookingStatus.getBrtId())) {
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

			query.append(_SQL_SELECT_BOOKINGSTATUS_WHERE);

			query.append(_FINDER_COLUMN_BYBRTID_BRTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BookingStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(brtId);

				if (!pagination) {
					list = (List<BookingStatus>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BookingStatus>(list);
				}
				else {
					list = (List<BookingStatus>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first booking status in the ordered set where brtId = &#63;.
	 *
	 * @param brtId the brt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking status
	 * @throws com.services.NoSuchBookingStatusException if a matching booking status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus findBybyBrtId_First(long brtId,
		OrderByComparator orderByComparator)
		throws NoSuchBookingStatusException, SystemException {
		BookingStatus bookingStatus = fetchBybyBrtId_First(brtId,
				orderByComparator);

		if (bookingStatus != null) {
			return bookingStatus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("brtId=");
		msg.append(brtId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingStatusException(msg.toString());
	}

	/**
	 * Returns the first booking status in the ordered set where brtId = &#63;.
	 *
	 * @param brtId the brt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking status, or <code>null</code> if a matching booking status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus fetchBybyBrtId_First(long brtId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BookingStatus> list = findBybyBrtId(brtId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last booking status in the ordered set where brtId = &#63;.
	 *
	 * @param brtId the brt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking status
	 * @throws com.services.NoSuchBookingStatusException if a matching booking status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus findBybyBrtId_Last(long brtId,
		OrderByComparator orderByComparator)
		throws NoSuchBookingStatusException, SystemException {
		BookingStatus bookingStatus = fetchBybyBrtId_Last(brtId,
				orderByComparator);

		if (bookingStatus != null) {
			return bookingStatus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("brtId=");
		msg.append(brtId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingStatusException(msg.toString());
	}

	/**
	 * Returns the last booking status in the ordered set where brtId = &#63;.
	 *
	 * @param brtId the brt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking status, or <code>null</code> if a matching booking status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus fetchBybyBrtId_Last(long brtId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybyBrtId(brtId);

		if (count == 0) {
			return null;
		}

		List<BookingStatus> list = findBybyBrtId(brtId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the booking statuses before and after the current booking status in the ordered set where brtId = &#63;.
	 *
	 * @param bsId the primary key of the current booking status
	 * @param brtId the brt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking status
	 * @throws com.services.NoSuchBookingStatusException if a booking status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus[] findBybyBrtId_PrevAndNext(long bsId, long brtId,
		OrderByComparator orderByComparator)
		throws NoSuchBookingStatusException, SystemException {
		BookingStatus bookingStatus = findByPrimaryKey(bsId);

		Session session = null;

		try {
			session = openSession();

			BookingStatus[] array = new BookingStatusImpl[3];

			array[0] = getBybyBrtId_PrevAndNext(session, bookingStatus, brtId,
					orderByComparator, true);

			array[1] = bookingStatus;

			array[2] = getBybyBrtId_PrevAndNext(session, bookingStatus, brtId,
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

	protected BookingStatus getBybyBrtId_PrevAndNext(Session session,
		BookingStatus bookingStatus, long brtId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKINGSTATUS_WHERE);

		query.append(_FINDER_COLUMN_BYBRTID_BRTID_2);

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
			query.append(BookingStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(brtId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bookingStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BookingStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the booking statuses where brtId = &#63; from the database.
	 *
	 * @param brtId the brt ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyBrtId(long brtId) throws SystemException {
		for (BookingStatus bookingStatus : findBybyBrtId(brtId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(bookingStatus);
		}
	}

	/**
	 * Returns the number of booking statuses where brtId = &#63;.
	 *
	 * @param brtId the brt ID
	 * @return the number of matching booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyBrtId(long brtId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYBRTID;

		Object[] finderArgs = new Object[] { brtId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOKINGSTATUS_WHERE);

			query.append(_FINDER_COLUMN_BYBRTID_BRTID_2);

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

	private static final String _FINDER_COLUMN_BYBRTID_BRTID_2 = "bookingStatus.brtId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYTRIPSTATUS =
		new FinderPath(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
			BookingStatusModelImpl.FINDER_CACHE_ENABLED,
			BookingStatusImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBybyTripStatus",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYTRIPSTATUS =
		new FinderPath(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
			BookingStatusModelImpl.FINDER_CACHE_ENABLED,
			BookingStatusImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBybyTripStatus", new String[] { String.class.getName() },
			BookingStatusModelImpl.TRIPSTATUS_COLUMN_BITMASK |
			BookingStatusModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYTRIPSTATUS = new FinderPath(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
			BookingStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyTripStatus",
			new String[] { String.class.getName() });

	/**
	 * Returns all the booking statuses where tripStatus = &#63;.
	 *
	 * @param tripStatus the trip status
	 * @return the matching booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BookingStatus> findBybyTripStatus(String tripStatus)
		throws SystemException {
		return findBybyTripStatus(tripStatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the booking statuses where tripStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tripStatus the trip status
	 * @param start the lower bound of the range of booking statuses
	 * @param end the upper bound of the range of booking statuses (not inclusive)
	 * @return the range of matching booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BookingStatus> findBybyTripStatus(String tripStatus, int start,
		int end) throws SystemException {
		return findBybyTripStatus(tripStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking statuses where tripStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tripStatus the trip status
	 * @param start the lower bound of the range of booking statuses
	 * @param end the upper bound of the range of booking statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BookingStatus> findBybyTripStatus(String tripStatus, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYTRIPSTATUS;
			finderArgs = new Object[] { tripStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYTRIPSTATUS;
			finderArgs = new Object[] { tripStatus, start, end, orderByComparator };
		}

		List<BookingStatus> list = (List<BookingStatus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BookingStatus bookingStatus : list) {
				if (!Validator.equals(tripStatus, bookingStatus.getTripStatus())) {
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

			query.append(_SQL_SELECT_BOOKINGSTATUS_WHERE);

			boolean bindTripStatus = false;

			if (tripStatus == null) {
				query.append(_FINDER_COLUMN_BYTRIPSTATUS_TRIPSTATUS_1);
			}
			else if (tripStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYTRIPSTATUS_TRIPSTATUS_3);
			}
			else {
				bindTripStatus = true;

				query.append(_FINDER_COLUMN_BYTRIPSTATUS_TRIPSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BookingStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTripStatus) {
					qPos.add(tripStatus);
				}

				if (!pagination) {
					list = (List<BookingStatus>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BookingStatus>(list);
				}
				else {
					list = (List<BookingStatus>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first booking status in the ordered set where tripStatus = &#63;.
	 *
	 * @param tripStatus the trip status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking status
	 * @throws com.services.NoSuchBookingStatusException if a matching booking status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus findBybyTripStatus_First(String tripStatus,
		OrderByComparator orderByComparator)
		throws NoSuchBookingStatusException, SystemException {
		BookingStatus bookingStatus = fetchBybyTripStatus_First(tripStatus,
				orderByComparator);

		if (bookingStatus != null) {
			return bookingStatus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tripStatus=");
		msg.append(tripStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingStatusException(msg.toString());
	}

	/**
	 * Returns the first booking status in the ordered set where tripStatus = &#63;.
	 *
	 * @param tripStatus the trip status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking status, or <code>null</code> if a matching booking status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus fetchBybyTripStatus_First(String tripStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<BookingStatus> list = findBybyTripStatus(tripStatus, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last booking status in the ordered set where tripStatus = &#63;.
	 *
	 * @param tripStatus the trip status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking status
	 * @throws com.services.NoSuchBookingStatusException if a matching booking status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus findBybyTripStatus_Last(String tripStatus,
		OrderByComparator orderByComparator)
		throws NoSuchBookingStatusException, SystemException {
		BookingStatus bookingStatus = fetchBybyTripStatus_Last(tripStatus,
				orderByComparator);

		if (bookingStatus != null) {
			return bookingStatus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tripStatus=");
		msg.append(tripStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingStatusException(msg.toString());
	}

	/**
	 * Returns the last booking status in the ordered set where tripStatus = &#63;.
	 *
	 * @param tripStatus the trip status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking status, or <code>null</code> if a matching booking status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus fetchBybyTripStatus_Last(String tripStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybyTripStatus(tripStatus);

		if (count == 0) {
			return null;
		}

		List<BookingStatus> list = findBybyTripStatus(tripStatus, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the booking statuses before and after the current booking status in the ordered set where tripStatus = &#63;.
	 *
	 * @param bsId the primary key of the current booking status
	 * @param tripStatus the trip status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking status
	 * @throws com.services.NoSuchBookingStatusException if a booking status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus[] findBybyTripStatus_PrevAndNext(long bsId,
		String tripStatus, OrderByComparator orderByComparator)
		throws NoSuchBookingStatusException, SystemException {
		BookingStatus bookingStatus = findByPrimaryKey(bsId);

		Session session = null;

		try {
			session = openSession();

			BookingStatus[] array = new BookingStatusImpl[3];

			array[0] = getBybyTripStatus_PrevAndNext(session, bookingStatus,
					tripStatus, orderByComparator, true);

			array[1] = bookingStatus;

			array[2] = getBybyTripStatus_PrevAndNext(session, bookingStatus,
					tripStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BookingStatus getBybyTripStatus_PrevAndNext(Session session,
		BookingStatus bookingStatus, String tripStatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKINGSTATUS_WHERE);

		boolean bindTripStatus = false;

		if (tripStatus == null) {
			query.append(_FINDER_COLUMN_BYTRIPSTATUS_TRIPSTATUS_1);
		}
		else if (tripStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BYTRIPSTATUS_TRIPSTATUS_3);
		}
		else {
			bindTripStatus = true;

			query.append(_FINDER_COLUMN_BYTRIPSTATUS_TRIPSTATUS_2);
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
			query.append(BookingStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTripStatus) {
			qPos.add(tripStatus);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bookingStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BookingStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the booking statuses where tripStatus = &#63; from the database.
	 *
	 * @param tripStatus the trip status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyTripStatus(String tripStatus)
		throws SystemException {
		for (BookingStatus bookingStatus : findBybyTripStatus(tripStatus,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(bookingStatus);
		}
	}

	/**
	 * Returns the number of booking statuses where tripStatus = &#63;.
	 *
	 * @param tripStatus the trip status
	 * @return the number of matching booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyTripStatus(String tripStatus) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYTRIPSTATUS;

		Object[] finderArgs = new Object[] { tripStatus };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOKINGSTATUS_WHERE);

			boolean bindTripStatus = false;

			if (tripStatus == null) {
				query.append(_FINDER_COLUMN_BYTRIPSTATUS_TRIPSTATUS_1);
			}
			else if (tripStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYTRIPSTATUS_TRIPSTATUS_3);
			}
			else {
				bindTripStatus = true;

				query.append(_FINDER_COLUMN_BYTRIPSTATUS_TRIPSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTripStatus) {
					qPos.add(tripStatus);
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

	private static final String _FINDER_COLUMN_BYTRIPSTATUS_TRIPSTATUS_1 = "bookingStatus.tripStatus IS NULL";
	private static final String _FINDER_COLUMN_BYTRIPSTATUS_TRIPSTATUS_2 = "bookingStatus.tripStatus = ?";
	private static final String _FINDER_COLUMN_BYTRIPSTATUS_TRIPSTATUS_3 = "(bookingStatus.tripStatus IS NULL OR bookingStatus.tripStatus = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYUSERANDTRIPSTATUS =
		new FinderPath(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
			BookingStatusModelImpl.FINDER_CACHE_ENABLED,
			BookingStatusImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBybyUserAndTripStatus",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERANDTRIPSTATUS =
		new FinderPath(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
			BookingStatusModelImpl.FINDER_CACHE_ENABLED,
			BookingStatusImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBybyUserAndTripStatus",
			new String[] { Long.class.getName(), String.class.getName() },
			BookingStatusModelImpl.USERID_COLUMN_BITMASK |
			BookingStatusModelImpl.TRIPSTATUS_COLUMN_BITMASK |
			BookingStatusModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYUSERANDTRIPSTATUS = new FinderPath(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
			BookingStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBybyUserAndTripStatus",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the booking statuses where userId = &#63; and tripStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param tripStatus the trip status
	 * @return the matching booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BookingStatus> findBybyUserAndTripStatus(long userId,
		String tripStatus) throws SystemException {
		return findBybyUserAndTripStatus(userId, tripStatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the booking statuses where userId = &#63; and tripStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param tripStatus the trip status
	 * @param start the lower bound of the range of booking statuses
	 * @param end the upper bound of the range of booking statuses (not inclusive)
	 * @return the range of matching booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BookingStatus> findBybyUserAndTripStatus(long userId,
		String tripStatus, int start, int end) throws SystemException {
		return findBybyUserAndTripStatus(userId, tripStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking statuses where userId = &#63; and tripStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param tripStatus the trip status
	 * @param start the lower bound of the range of booking statuses
	 * @param end the upper bound of the range of booking statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BookingStatus> findBybyUserAndTripStatus(long userId,
		String tripStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERANDTRIPSTATUS;
			finderArgs = new Object[] { userId, tripStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYUSERANDTRIPSTATUS;
			finderArgs = new Object[] {
					userId, tripStatus,
					
					start, end, orderByComparator
				};
		}

		List<BookingStatus> list = (List<BookingStatus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BookingStatus bookingStatus : list) {
				if ((userId != bookingStatus.getUserId()) ||
						!Validator.equals(tripStatus,
							bookingStatus.getTripStatus())) {
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

			query.append(_SQL_SELECT_BOOKINGSTATUS_WHERE);

			query.append(_FINDER_COLUMN_BYUSERANDTRIPSTATUS_USERID_2);

			boolean bindTripStatus = false;

			if (tripStatus == null) {
				query.append(_FINDER_COLUMN_BYUSERANDTRIPSTATUS_TRIPSTATUS_1);
			}
			else if (tripStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYUSERANDTRIPSTATUS_TRIPSTATUS_3);
			}
			else {
				bindTripStatus = true;

				query.append(_FINDER_COLUMN_BYUSERANDTRIPSTATUS_TRIPSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BookingStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindTripStatus) {
					qPos.add(tripStatus);
				}

				if (!pagination) {
					list = (List<BookingStatus>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BookingStatus>(list);
				}
				else {
					list = (List<BookingStatus>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first booking status in the ordered set where userId = &#63; and tripStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param tripStatus the trip status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking status
	 * @throws com.services.NoSuchBookingStatusException if a matching booking status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus findBybyUserAndTripStatus_First(long userId,
		String tripStatus, OrderByComparator orderByComparator)
		throws NoSuchBookingStatusException, SystemException {
		BookingStatus bookingStatus = fetchBybyUserAndTripStatus_First(userId,
				tripStatus, orderByComparator);

		if (bookingStatus != null) {
			return bookingStatus;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", tripStatus=");
		msg.append(tripStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingStatusException(msg.toString());
	}

	/**
	 * Returns the first booking status in the ordered set where userId = &#63; and tripStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param tripStatus the trip status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking status, or <code>null</code> if a matching booking status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus fetchBybyUserAndTripStatus_First(long userId,
		String tripStatus, OrderByComparator orderByComparator)
		throws SystemException {
		List<BookingStatus> list = findBybyUserAndTripStatus(userId,
				tripStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last booking status in the ordered set where userId = &#63; and tripStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param tripStatus the trip status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking status
	 * @throws com.services.NoSuchBookingStatusException if a matching booking status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus findBybyUserAndTripStatus_Last(long userId,
		String tripStatus, OrderByComparator orderByComparator)
		throws NoSuchBookingStatusException, SystemException {
		BookingStatus bookingStatus = fetchBybyUserAndTripStatus_Last(userId,
				tripStatus, orderByComparator);

		if (bookingStatus != null) {
			return bookingStatus;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", tripStatus=");
		msg.append(tripStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookingStatusException(msg.toString());
	}

	/**
	 * Returns the last booking status in the ordered set where userId = &#63; and tripStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param tripStatus the trip status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking status, or <code>null</code> if a matching booking status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus fetchBybyUserAndTripStatus_Last(long userId,
		String tripStatus, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBybyUserAndTripStatus(userId, tripStatus);

		if (count == 0) {
			return null;
		}

		List<BookingStatus> list = findBybyUserAndTripStatus(userId,
				tripStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the booking statuses before and after the current booking status in the ordered set where userId = &#63; and tripStatus = &#63;.
	 *
	 * @param bsId the primary key of the current booking status
	 * @param userId the user ID
	 * @param tripStatus the trip status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking status
	 * @throws com.services.NoSuchBookingStatusException if a booking status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus[] findBybyUserAndTripStatus_PrevAndNext(long bsId,
		long userId, String tripStatus, OrderByComparator orderByComparator)
		throws NoSuchBookingStatusException, SystemException {
		BookingStatus bookingStatus = findByPrimaryKey(bsId);

		Session session = null;

		try {
			session = openSession();

			BookingStatus[] array = new BookingStatusImpl[3];

			array[0] = getBybyUserAndTripStatus_PrevAndNext(session,
					bookingStatus, userId, tripStatus, orderByComparator, true);

			array[1] = bookingStatus;

			array[2] = getBybyUserAndTripStatus_PrevAndNext(session,
					bookingStatus, userId, tripStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BookingStatus getBybyUserAndTripStatus_PrevAndNext(
		Session session, BookingStatus bookingStatus, long userId,
		String tripStatus, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKINGSTATUS_WHERE);

		query.append(_FINDER_COLUMN_BYUSERANDTRIPSTATUS_USERID_2);

		boolean bindTripStatus = false;

		if (tripStatus == null) {
			query.append(_FINDER_COLUMN_BYUSERANDTRIPSTATUS_TRIPSTATUS_1);
		}
		else if (tripStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BYUSERANDTRIPSTATUS_TRIPSTATUS_3);
		}
		else {
			bindTripStatus = true;

			query.append(_FINDER_COLUMN_BYUSERANDTRIPSTATUS_TRIPSTATUS_2);
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
			query.append(BookingStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (bindTripStatus) {
			qPos.add(tripStatus);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bookingStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BookingStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the booking statuses where userId = &#63; and tripStatus = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param tripStatus the trip status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyUserAndTripStatus(long userId, String tripStatus)
		throws SystemException {
		for (BookingStatus bookingStatus : findBybyUserAndTripStatus(userId,
				tripStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(bookingStatus);
		}
	}

	/**
	 * Returns the number of booking statuses where userId = &#63; and tripStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param tripStatus the trip status
	 * @return the number of matching booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyUserAndTripStatus(long userId, String tripStatus)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYUSERANDTRIPSTATUS;

		Object[] finderArgs = new Object[] { userId, tripStatus };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BOOKINGSTATUS_WHERE);

			query.append(_FINDER_COLUMN_BYUSERANDTRIPSTATUS_USERID_2);

			boolean bindTripStatus = false;

			if (tripStatus == null) {
				query.append(_FINDER_COLUMN_BYUSERANDTRIPSTATUS_TRIPSTATUS_1);
			}
			else if (tripStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYUSERANDTRIPSTATUS_TRIPSTATUS_3);
			}
			else {
				bindTripStatus = true;

				query.append(_FINDER_COLUMN_BYUSERANDTRIPSTATUS_TRIPSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindTripStatus) {
					qPos.add(tripStatus);
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

	private static final String _FINDER_COLUMN_BYUSERANDTRIPSTATUS_USERID_2 = "bookingStatus.userId = ? AND ";
	private static final String _FINDER_COLUMN_BYUSERANDTRIPSTATUS_TRIPSTATUS_1 = "bookingStatus.tripStatus IS NULL";
	private static final String _FINDER_COLUMN_BYUSERANDTRIPSTATUS_TRIPSTATUS_2 = "bookingStatus.tripStatus = ?";
	private static final String _FINDER_COLUMN_BYUSERANDTRIPSTATUS_TRIPSTATUS_3 = "(bookingStatus.tripStatus IS NULL OR bookingStatus.tripStatus = '')";

	public BookingStatusPersistenceImpl() {
		setModelClass(BookingStatus.class);
	}

	/**
	 * Caches the booking status in the entity cache if it is enabled.
	 *
	 * @param bookingStatus the booking status
	 */
	@Override
	public void cacheResult(BookingStatus bookingStatus) {
		EntityCacheUtil.putResult(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
			BookingStatusImpl.class, bookingStatus.getPrimaryKey(),
			bookingStatus);

		bookingStatus.resetOriginalValues();
	}

	/**
	 * Caches the booking statuses in the entity cache if it is enabled.
	 *
	 * @param bookingStatuses the booking statuses
	 */
	@Override
	public void cacheResult(List<BookingStatus> bookingStatuses) {
		for (BookingStatus bookingStatus : bookingStatuses) {
			if (EntityCacheUtil.getResult(
						BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
						BookingStatusImpl.class, bookingStatus.getPrimaryKey()) == null) {
				cacheResult(bookingStatus);
			}
			else {
				bookingStatus.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all booking statuses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BookingStatusImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BookingStatusImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the booking status.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BookingStatus bookingStatus) {
		EntityCacheUtil.removeResult(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
			BookingStatusImpl.class, bookingStatus.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BookingStatus> bookingStatuses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BookingStatus bookingStatus : bookingStatuses) {
			EntityCacheUtil.removeResult(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
				BookingStatusImpl.class, bookingStatus.getPrimaryKey());
		}
	}

	/**
	 * Creates a new booking status with the primary key. Does not add the booking status to the database.
	 *
	 * @param bsId the primary key for the new booking status
	 * @return the new booking status
	 */
	@Override
	public BookingStatus create(long bsId) {
		BookingStatus bookingStatus = new BookingStatusImpl();

		bookingStatus.setNew(true);
		bookingStatus.setPrimaryKey(bsId);

		return bookingStatus;
	}

	/**
	 * Removes the booking status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bsId the primary key of the booking status
	 * @return the booking status that was removed
	 * @throws com.services.NoSuchBookingStatusException if a booking status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus remove(long bsId)
		throws NoSuchBookingStatusException, SystemException {
		return remove((Serializable)bsId);
	}

	/**
	 * Removes the booking status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the booking status
	 * @return the booking status that was removed
	 * @throws com.services.NoSuchBookingStatusException if a booking status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus remove(Serializable primaryKey)
		throws NoSuchBookingStatusException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BookingStatus bookingStatus = (BookingStatus)session.get(BookingStatusImpl.class,
					primaryKey);

			if (bookingStatus == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBookingStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bookingStatus);
		}
		catch (NoSuchBookingStatusException nsee) {
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
	protected BookingStatus removeImpl(BookingStatus bookingStatus)
		throws SystemException {
		bookingStatus = toUnwrappedModel(bookingStatus);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bookingStatus)) {
				bookingStatus = (BookingStatus)session.get(BookingStatusImpl.class,
						bookingStatus.getPrimaryKeyObj());
			}

			if (bookingStatus != null) {
				session.delete(bookingStatus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bookingStatus != null) {
			clearCache(bookingStatus);
		}

		return bookingStatus;
	}

	@Override
	public BookingStatus updateImpl(
		com.services.model.BookingStatus bookingStatus)
		throws SystemException {
		bookingStatus = toUnwrappedModel(bookingStatus);

		boolean isNew = bookingStatus.isNew();

		BookingStatusModelImpl bookingStatusModelImpl = (BookingStatusModelImpl)bookingStatus;

		Session session = null;

		try {
			session = openSession();

			if (bookingStatus.isNew()) {
				session.save(bookingStatus);

				bookingStatus.setNew(false);
			}
			else {
				session.merge(bookingStatus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BookingStatusModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((bookingStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bookingStatusModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYUSERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID,
					args);

				args = new Object[] { bookingStatusModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYUSERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID,
					args);
			}

			if ((bookingStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bookingStatusModelImpl.getOriginalUserId(),
						bookingStatusModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYUSERANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERANDSTATUS,
					args);

				args = new Object[] {
						bookingStatusModelImpl.getUserId(),
						bookingStatusModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYUSERANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERANDSTATUS,
					args);
			}

			if ((bookingStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYBRTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bookingStatusModelImpl.getOriginalBrtId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYBRTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYBRTID,
					args);

				args = new Object[] { bookingStatusModelImpl.getBrtId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYBRTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYBRTID,
					args);
			}

			if ((bookingStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYTRIPSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bookingStatusModelImpl.getOriginalTripStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYTRIPSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYTRIPSTATUS,
					args);

				args = new Object[] { bookingStatusModelImpl.getTripStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYTRIPSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYTRIPSTATUS,
					args);
			}

			if ((bookingStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERANDTRIPSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bookingStatusModelImpl.getOriginalUserId(),
						bookingStatusModelImpl.getOriginalTripStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYUSERANDTRIPSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERANDTRIPSTATUS,
					args);

				args = new Object[] {
						bookingStatusModelImpl.getUserId(),
						bookingStatusModelImpl.getTripStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYUSERANDTRIPSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERANDTRIPSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
			BookingStatusImpl.class, bookingStatus.getPrimaryKey(),
			bookingStatus);

		return bookingStatus;
	}

	protected BookingStatus toUnwrappedModel(BookingStatus bookingStatus) {
		if (bookingStatus instanceof BookingStatusImpl) {
			return bookingStatus;
		}

		BookingStatusImpl bookingStatusImpl = new BookingStatusImpl();

		bookingStatusImpl.setNew(bookingStatus.isNew());
		bookingStatusImpl.setPrimaryKey(bookingStatus.getPrimaryKey());

		bookingStatusImpl.setBsId(bookingStatus.getBsId());
		bookingStatusImpl.setUserId(bookingStatus.getUserId());
		bookingStatusImpl.setBrtId(bookingStatus.getBrtId());
		bookingStatusImpl.setStatus(bookingStatus.getStatus());
		bookingStatusImpl.setTripStatus(bookingStatus.getTripStatus());
		bookingStatusImpl.setCreateDate(bookingStatus.getCreateDate());

		return bookingStatusImpl;
	}

	/**
	 * Returns the booking status with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the booking status
	 * @return the booking status
	 * @throws com.services.NoSuchBookingStatusException if a booking status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBookingStatusException, SystemException {
		BookingStatus bookingStatus = fetchByPrimaryKey(primaryKey);

		if (bookingStatus == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBookingStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bookingStatus;
	}

	/**
	 * Returns the booking status with the primary key or throws a {@link com.services.NoSuchBookingStatusException} if it could not be found.
	 *
	 * @param bsId the primary key of the booking status
	 * @return the booking status
	 * @throws com.services.NoSuchBookingStatusException if a booking status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus findByPrimaryKey(long bsId)
		throws NoSuchBookingStatusException, SystemException {
		return findByPrimaryKey((Serializable)bsId);
	}

	/**
	 * Returns the booking status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the booking status
	 * @return the booking status, or <code>null</code> if a booking status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BookingStatus bookingStatus = (BookingStatus)EntityCacheUtil.getResult(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
				BookingStatusImpl.class, primaryKey);

		if (bookingStatus == _nullBookingStatus) {
			return null;
		}

		if (bookingStatus == null) {
			Session session = null;

			try {
				session = openSession();

				bookingStatus = (BookingStatus)session.get(BookingStatusImpl.class,
						primaryKey);

				if (bookingStatus != null) {
					cacheResult(bookingStatus);
				}
				else {
					EntityCacheUtil.putResult(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
						BookingStatusImpl.class, primaryKey, _nullBookingStatus);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BookingStatusModelImpl.ENTITY_CACHE_ENABLED,
					BookingStatusImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bookingStatus;
	}

	/**
	 * Returns the booking status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bsId the primary key of the booking status
	 * @return the booking status, or <code>null</code> if a booking status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BookingStatus fetchByPrimaryKey(long bsId) throws SystemException {
		return fetchByPrimaryKey((Serializable)bsId);
	}

	/**
	 * Returns all the booking statuses.
	 *
	 * @return the booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BookingStatus> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the booking statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking statuses
	 * @param end the upper bound of the range of booking statuses (not inclusive)
	 * @return the range of booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BookingStatus> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.BookingStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking statuses
	 * @param end the upper bound of the range of booking statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of booking statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BookingStatus> findAll(int start, int end,
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

		List<BookingStatus> list = (List<BookingStatus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BOOKINGSTATUS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BOOKINGSTATUS;

				if (pagination) {
					sql = sql.concat(BookingStatusModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BookingStatus>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BookingStatus>(list);
				}
				else {
					list = (List<BookingStatus>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the booking statuses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BookingStatus bookingStatus : findAll()) {
			remove(bookingStatus);
		}
	}

	/**
	 * Returns the number of booking statuses.
	 *
	 * @return the number of booking statuses
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

				Query q = session.createQuery(_SQL_COUNT_BOOKINGSTATUS);

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
	 * Initializes the booking status persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.services.model.BookingStatus")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BookingStatus>> listenersList = new ArrayList<ModelListener<BookingStatus>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BookingStatus>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BookingStatusImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BOOKINGSTATUS = "SELECT bookingStatus FROM BookingStatus bookingStatus";
	private static final String _SQL_SELECT_BOOKINGSTATUS_WHERE = "SELECT bookingStatus FROM BookingStatus bookingStatus WHERE ";
	private static final String _SQL_COUNT_BOOKINGSTATUS = "SELECT COUNT(bookingStatus) FROM BookingStatus bookingStatus";
	private static final String _SQL_COUNT_BOOKINGSTATUS_WHERE = "SELECT COUNT(bookingStatus) FROM BookingStatus bookingStatus WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bookingStatus.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BookingStatus exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BookingStatus exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BookingStatusPersistenceImpl.class);
	private static BookingStatus _nullBookingStatus = new BookingStatusImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BookingStatus> toCacheModel() {
				return _nullBookingStatusCacheModel;
			}
		};

	private static CacheModel<BookingStatus> _nullBookingStatusCacheModel = new CacheModel<BookingStatus>() {
			@Override
			public BookingStatus toEntityModel() {
				return _nullBookingStatus;
			}
		};
}