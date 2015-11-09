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

import com.services.NoSuchUserCouponException;

import com.services.model.UserCoupon;
import com.services.model.impl.UserCouponImpl;
import com.services.model.impl.UserCouponModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the user coupon service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see UserCouponPersistence
 * @see UserCouponUtil
 * @generated
 */
public class UserCouponPersistenceImpl extends BasePersistenceImpl<UserCoupon>
	implements UserCouponPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserCouponUtil} to access the user coupon persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserCouponImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserCouponModelImpl.ENTITY_CACHE_ENABLED,
			UserCouponModelImpl.FINDER_CACHE_ENABLED, UserCouponImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserCouponModelImpl.ENTITY_CACHE_ENABLED,
			UserCouponModelImpl.FINDER_CACHE_ENABLED, UserCouponImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserCouponModelImpl.ENTITY_CACHE_ENABLED,
			UserCouponModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(UserCouponModelImpl.ENTITY_CACHE_ENABLED,
			UserCouponModelImpl.FINDER_CACHE_ENABLED, UserCouponImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(UserCouponModelImpl.ENTITY_CACHE_ENABLED,
			UserCouponModelImpl.FINDER_CACHE_ENABLED, UserCouponImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			UserCouponModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(UserCouponModelImpl.ENTITY_CACHE_ENABLED,
			UserCouponModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the user coupons where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserCoupon> findByUserId(long userId) throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user coupons where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.UserCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user coupons
	 * @param end the upper bound of the range of user coupons (not inclusive)
	 * @return the range of matching user coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserCoupon> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user coupons where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.UserCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user coupons
	 * @param end the upper bound of the range of user coupons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserCoupon> findByUserId(long userId, int start, int end,
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

		List<UserCoupon> list = (List<UserCoupon>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserCoupon userCoupon : list) {
				if ((userId != userCoupon.getUserId())) {
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

			query.append(_SQL_SELECT_USERCOUPON_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserCouponModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<UserCoupon>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserCoupon>(list);
				}
				else {
					list = (List<UserCoupon>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user coupon in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user coupon
	 * @throws com.services.NoSuchUserCouponException if a matching user coupon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserCouponException, SystemException {
		UserCoupon userCoupon = fetchByUserId_First(userId, orderByComparator);

		if (userCoupon != null) {
			return userCoupon;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserCouponException(msg.toString());
	}

	/**
	 * Returns the first user coupon in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user coupon, or <code>null</code> if a matching user coupon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserCoupon> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user coupon in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user coupon
	 * @throws com.services.NoSuchUserCouponException if a matching user coupon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserCouponException, SystemException {
		UserCoupon userCoupon = fetchByUserId_Last(userId, orderByComparator);

		if (userCoupon != null) {
			return userCoupon;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserCouponException(msg.toString());
	}

	/**
	 * Returns the last user coupon in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user coupon, or <code>null</code> if a matching user coupon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<UserCoupon> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user coupons before and after the current user coupon in the ordered set where userId = &#63;.
	 *
	 * @param ucId the primary key of the current user coupon
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user coupon
	 * @throws com.services.NoSuchUserCouponException if a user coupon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon[] findByUserId_PrevAndNext(long ucId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserCouponException, SystemException {
		UserCoupon userCoupon = findByPrimaryKey(ucId);

		Session session = null;

		try {
			session = openSession();

			UserCoupon[] array = new UserCouponImpl[3];

			array[0] = getByUserId_PrevAndNext(session, userCoupon, userId,
					orderByComparator, true);

			array[1] = userCoupon;

			array[2] = getByUserId_PrevAndNext(session, userCoupon, userId,
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

	protected UserCoupon getByUserId_PrevAndNext(Session session,
		UserCoupon userCoupon, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERCOUPON_WHERE);

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
			query.append(UserCouponModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userCoupon);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserCoupon> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user coupons where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (UserCoupon userCoupon : findByUserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(userCoupon);
		}
	}

	/**
	 * Returns the number of user coupons where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user coupons
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

			query.append(_SQL_COUNT_USERCOUPON_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "userCoupon.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERCOUPONID =
		new FinderPath(UserCouponModelImpl.ENTITY_CACHE_ENABLED,
			UserCouponModelImpl.FINDER_CACHE_ENABLED, UserCouponImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserCouponId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERCOUPONID =
		new FinderPath(UserCouponModelImpl.ENTITY_CACHE_ENABLED,
			UserCouponModelImpl.FINDER_CACHE_ENABLED, UserCouponImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserCouponId",
			new String[] { Long.class.getName(), Long.class.getName() },
			UserCouponModelImpl.USERID_COLUMN_BITMASK |
			UserCouponModelImpl.COUPONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERCOUPONID = new FinderPath(UserCouponModelImpl.ENTITY_CACHE_ENABLED,
			UserCouponModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserCouponId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the user coupons where userId = &#63; and couponId = &#63;.
	 *
	 * @param userId the user ID
	 * @param couponId the coupon ID
	 * @return the matching user coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserCoupon> findByUserCouponId(long userId, long couponId)
		throws SystemException {
		return findByUserCouponId(userId, couponId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user coupons where userId = &#63; and couponId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.UserCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param couponId the coupon ID
	 * @param start the lower bound of the range of user coupons
	 * @param end the upper bound of the range of user coupons (not inclusive)
	 * @return the range of matching user coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserCoupon> findByUserCouponId(long userId, long couponId,
		int start, int end) throws SystemException {
		return findByUserCouponId(userId, couponId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user coupons where userId = &#63; and couponId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.UserCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param couponId the coupon ID
	 * @param start the lower bound of the range of user coupons
	 * @param end the upper bound of the range of user coupons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserCoupon> findByUserCouponId(long userId, long couponId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERCOUPONID;
			finderArgs = new Object[] { userId, couponId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERCOUPONID;
			finderArgs = new Object[] {
					userId, couponId,
					
					start, end, orderByComparator
				};
		}

		List<UserCoupon> list = (List<UserCoupon>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserCoupon userCoupon : list) {
				if ((userId != userCoupon.getUserId()) ||
						(couponId != userCoupon.getCouponId())) {
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

			query.append(_SQL_SELECT_USERCOUPON_WHERE);

			query.append(_FINDER_COLUMN_USERCOUPONID_USERID_2);

			query.append(_FINDER_COLUMN_USERCOUPONID_COUPONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserCouponModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(couponId);

				if (!pagination) {
					list = (List<UserCoupon>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserCoupon>(list);
				}
				else {
					list = (List<UserCoupon>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user coupon in the ordered set where userId = &#63; and couponId = &#63;.
	 *
	 * @param userId the user ID
	 * @param couponId the coupon ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user coupon
	 * @throws com.services.NoSuchUserCouponException if a matching user coupon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon findByUserCouponId_First(long userId, long couponId,
		OrderByComparator orderByComparator)
		throws NoSuchUserCouponException, SystemException {
		UserCoupon userCoupon = fetchByUserCouponId_First(userId, couponId,
				orderByComparator);

		if (userCoupon != null) {
			return userCoupon;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", couponId=");
		msg.append(couponId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserCouponException(msg.toString());
	}

	/**
	 * Returns the first user coupon in the ordered set where userId = &#63; and couponId = &#63;.
	 *
	 * @param userId the user ID
	 * @param couponId the coupon ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user coupon, or <code>null</code> if a matching user coupon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon fetchByUserCouponId_First(long userId, long couponId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserCoupon> list = findByUserCouponId(userId, couponId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user coupon in the ordered set where userId = &#63; and couponId = &#63;.
	 *
	 * @param userId the user ID
	 * @param couponId the coupon ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user coupon
	 * @throws com.services.NoSuchUserCouponException if a matching user coupon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon findByUserCouponId_Last(long userId, long couponId,
		OrderByComparator orderByComparator)
		throws NoSuchUserCouponException, SystemException {
		UserCoupon userCoupon = fetchByUserCouponId_Last(userId, couponId,
				orderByComparator);

		if (userCoupon != null) {
			return userCoupon;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", couponId=");
		msg.append(couponId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserCouponException(msg.toString());
	}

	/**
	 * Returns the last user coupon in the ordered set where userId = &#63; and couponId = &#63;.
	 *
	 * @param userId the user ID
	 * @param couponId the coupon ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user coupon, or <code>null</code> if a matching user coupon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon fetchByUserCouponId_Last(long userId, long couponId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserCouponId(userId, couponId);

		if (count == 0) {
			return null;
		}

		List<UserCoupon> list = findByUserCouponId(userId, couponId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user coupons before and after the current user coupon in the ordered set where userId = &#63; and couponId = &#63;.
	 *
	 * @param ucId the primary key of the current user coupon
	 * @param userId the user ID
	 * @param couponId the coupon ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user coupon
	 * @throws com.services.NoSuchUserCouponException if a user coupon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon[] findByUserCouponId_PrevAndNext(long ucId, long userId,
		long couponId, OrderByComparator orderByComparator)
		throws NoSuchUserCouponException, SystemException {
		UserCoupon userCoupon = findByPrimaryKey(ucId);

		Session session = null;

		try {
			session = openSession();

			UserCoupon[] array = new UserCouponImpl[3];

			array[0] = getByUserCouponId_PrevAndNext(session, userCoupon,
					userId, couponId, orderByComparator, true);

			array[1] = userCoupon;

			array[2] = getByUserCouponId_PrevAndNext(session, userCoupon,
					userId, couponId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserCoupon getByUserCouponId_PrevAndNext(Session session,
		UserCoupon userCoupon, long userId, long couponId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERCOUPON_WHERE);

		query.append(_FINDER_COLUMN_USERCOUPONID_USERID_2);

		query.append(_FINDER_COLUMN_USERCOUPONID_COUPONID_2);

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
			query.append(UserCouponModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(couponId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userCoupon);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserCoupon> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user coupons where userId = &#63; and couponId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param couponId the coupon ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserCouponId(long userId, long couponId)
		throws SystemException {
		for (UserCoupon userCoupon : findByUserCouponId(userId, couponId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userCoupon);
		}
	}

	/**
	 * Returns the number of user coupons where userId = &#63; and couponId = &#63;.
	 *
	 * @param userId the user ID
	 * @param couponId the coupon ID
	 * @return the number of matching user coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserCouponId(long userId, long couponId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERCOUPONID;

		Object[] finderArgs = new Object[] { userId, couponId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERCOUPON_WHERE);

			query.append(_FINDER_COLUMN_USERCOUPONID_USERID_2);

			query.append(_FINDER_COLUMN_USERCOUPONID_COUPONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(couponId);

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

	private static final String _FINDER_COLUMN_USERCOUPONID_USERID_2 = "userCoupon.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERCOUPONID_COUPONID_2 = "userCoupon.couponId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUPONID = new FinderPath(UserCouponModelImpl.ENTITY_CACHE_ENABLED,
			UserCouponModelImpl.FINDER_CACHE_ENABLED, UserCouponImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCouponId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUPONID =
		new FinderPath(UserCouponModelImpl.ENTITY_CACHE_ENABLED,
			UserCouponModelImpl.FINDER_CACHE_ENABLED, UserCouponImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCouponId",
			new String[] { Long.class.getName() },
			UserCouponModelImpl.COUPONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUPONID = new FinderPath(UserCouponModelImpl.ENTITY_CACHE_ENABLED,
			UserCouponModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCouponId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the user coupons where couponId = &#63;.
	 *
	 * @param couponId the coupon ID
	 * @return the matching user coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserCoupon> findByCouponId(long couponId)
		throws SystemException {
		return findByCouponId(couponId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the user coupons where couponId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.UserCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param couponId the coupon ID
	 * @param start the lower bound of the range of user coupons
	 * @param end the upper bound of the range of user coupons (not inclusive)
	 * @return the range of matching user coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserCoupon> findByCouponId(long couponId, int start, int end)
		throws SystemException {
		return findByCouponId(couponId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user coupons where couponId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.UserCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param couponId the coupon ID
	 * @param start the lower bound of the range of user coupons
	 * @param end the upper bound of the range of user coupons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserCoupon> findByCouponId(long couponId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUPONID;
			finderArgs = new Object[] { couponId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COUPONID;
			finderArgs = new Object[] { couponId, start, end, orderByComparator };
		}

		List<UserCoupon> list = (List<UserCoupon>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserCoupon userCoupon : list) {
				if ((couponId != userCoupon.getCouponId())) {
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

			query.append(_SQL_SELECT_USERCOUPON_WHERE);

			query.append(_FINDER_COLUMN_COUPONID_COUPONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserCouponModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(couponId);

				if (!pagination) {
					list = (List<UserCoupon>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserCoupon>(list);
				}
				else {
					list = (List<UserCoupon>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user coupon in the ordered set where couponId = &#63;.
	 *
	 * @param couponId the coupon ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user coupon
	 * @throws com.services.NoSuchUserCouponException if a matching user coupon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon findByCouponId_First(long couponId,
		OrderByComparator orderByComparator)
		throws NoSuchUserCouponException, SystemException {
		UserCoupon userCoupon = fetchByCouponId_First(couponId,
				orderByComparator);

		if (userCoupon != null) {
			return userCoupon;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("couponId=");
		msg.append(couponId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserCouponException(msg.toString());
	}

	/**
	 * Returns the first user coupon in the ordered set where couponId = &#63;.
	 *
	 * @param couponId the coupon ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user coupon, or <code>null</code> if a matching user coupon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon fetchByCouponId_First(long couponId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserCoupon> list = findByCouponId(couponId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user coupon in the ordered set where couponId = &#63;.
	 *
	 * @param couponId the coupon ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user coupon
	 * @throws com.services.NoSuchUserCouponException if a matching user coupon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon findByCouponId_Last(long couponId,
		OrderByComparator orderByComparator)
		throws NoSuchUserCouponException, SystemException {
		UserCoupon userCoupon = fetchByCouponId_Last(couponId, orderByComparator);

		if (userCoupon != null) {
			return userCoupon;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("couponId=");
		msg.append(couponId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserCouponException(msg.toString());
	}

	/**
	 * Returns the last user coupon in the ordered set where couponId = &#63;.
	 *
	 * @param couponId the coupon ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user coupon, or <code>null</code> if a matching user coupon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon fetchByCouponId_Last(long couponId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCouponId(couponId);

		if (count == 0) {
			return null;
		}

		List<UserCoupon> list = findByCouponId(couponId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user coupons before and after the current user coupon in the ordered set where couponId = &#63;.
	 *
	 * @param ucId the primary key of the current user coupon
	 * @param couponId the coupon ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user coupon
	 * @throws com.services.NoSuchUserCouponException if a user coupon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon[] findByCouponId_PrevAndNext(long ucId, long couponId,
		OrderByComparator orderByComparator)
		throws NoSuchUserCouponException, SystemException {
		UserCoupon userCoupon = findByPrimaryKey(ucId);

		Session session = null;

		try {
			session = openSession();

			UserCoupon[] array = new UserCouponImpl[3];

			array[0] = getByCouponId_PrevAndNext(session, userCoupon, couponId,
					orderByComparator, true);

			array[1] = userCoupon;

			array[2] = getByCouponId_PrevAndNext(session, userCoupon, couponId,
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

	protected UserCoupon getByCouponId_PrevAndNext(Session session,
		UserCoupon userCoupon, long couponId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERCOUPON_WHERE);

		query.append(_FINDER_COLUMN_COUPONID_COUPONID_2);

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
			query.append(UserCouponModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(couponId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userCoupon);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserCoupon> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user coupons where couponId = &#63; from the database.
	 *
	 * @param couponId the coupon ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCouponId(long couponId) throws SystemException {
		for (UserCoupon userCoupon : findByCouponId(couponId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userCoupon);
		}
	}

	/**
	 * Returns the number of user coupons where couponId = &#63;.
	 *
	 * @param couponId the coupon ID
	 * @return the number of matching user coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCouponId(long couponId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUPONID;

		Object[] finderArgs = new Object[] { couponId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERCOUPON_WHERE);

			query.append(_FINDER_COLUMN_COUPONID_COUPONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(couponId);

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

	private static final String _FINDER_COLUMN_COUPONID_COUPONID_2 = "userCoupon.couponId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLAIMEDCOUPONS =
		new FinderPath(UserCouponModelImpl.ENTITY_CACHE_ENABLED,
			UserCouponModelImpl.FINDER_CACHE_ENABLED, UserCouponImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClaimedCoupons",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLAIMEDCOUPONS =
		new FinderPath(UserCouponModelImpl.ENTITY_CACHE_ENABLED,
			UserCouponModelImpl.FINDER_CACHE_ENABLED, UserCouponImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByClaimedCoupons",
			new String[] { Boolean.class.getName() },
			UserCouponModelImpl.CLAIMED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLAIMEDCOUPONS = new FinderPath(UserCouponModelImpl.ENTITY_CACHE_ENABLED,
			UserCouponModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClaimedCoupons",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the user coupons where claimed = &#63;.
	 *
	 * @param claimed the claimed
	 * @return the matching user coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserCoupon> findByClaimedCoupons(boolean claimed)
		throws SystemException {
		return findByClaimedCoupons(claimed, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user coupons where claimed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.UserCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param claimed the claimed
	 * @param start the lower bound of the range of user coupons
	 * @param end the upper bound of the range of user coupons (not inclusive)
	 * @return the range of matching user coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserCoupon> findByClaimedCoupons(boolean claimed, int start,
		int end) throws SystemException {
		return findByClaimedCoupons(claimed, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user coupons where claimed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.UserCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param claimed the claimed
	 * @param start the lower bound of the range of user coupons
	 * @param end the upper bound of the range of user coupons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserCoupon> findByClaimedCoupons(boolean claimed, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLAIMEDCOUPONS;
			finderArgs = new Object[] { claimed };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLAIMEDCOUPONS;
			finderArgs = new Object[] { claimed, start, end, orderByComparator };
		}

		List<UserCoupon> list = (List<UserCoupon>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserCoupon userCoupon : list) {
				if ((claimed != userCoupon.getClaimed())) {
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

			query.append(_SQL_SELECT_USERCOUPON_WHERE);

			query.append(_FINDER_COLUMN_CLAIMEDCOUPONS_CLAIMED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserCouponModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(claimed);

				if (!pagination) {
					list = (List<UserCoupon>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserCoupon>(list);
				}
				else {
					list = (List<UserCoupon>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user coupon in the ordered set where claimed = &#63;.
	 *
	 * @param claimed the claimed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user coupon
	 * @throws com.services.NoSuchUserCouponException if a matching user coupon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon findByClaimedCoupons_First(boolean claimed,
		OrderByComparator orderByComparator)
		throws NoSuchUserCouponException, SystemException {
		UserCoupon userCoupon = fetchByClaimedCoupons_First(claimed,
				orderByComparator);

		if (userCoupon != null) {
			return userCoupon;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("claimed=");
		msg.append(claimed);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserCouponException(msg.toString());
	}

	/**
	 * Returns the first user coupon in the ordered set where claimed = &#63;.
	 *
	 * @param claimed the claimed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user coupon, or <code>null</code> if a matching user coupon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon fetchByClaimedCoupons_First(boolean claimed,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserCoupon> list = findByClaimedCoupons(claimed, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user coupon in the ordered set where claimed = &#63;.
	 *
	 * @param claimed the claimed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user coupon
	 * @throws com.services.NoSuchUserCouponException if a matching user coupon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon findByClaimedCoupons_Last(boolean claimed,
		OrderByComparator orderByComparator)
		throws NoSuchUserCouponException, SystemException {
		UserCoupon userCoupon = fetchByClaimedCoupons_Last(claimed,
				orderByComparator);

		if (userCoupon != null) {
			return userCoupon;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("claimed=");
		msg.append(claimed);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserCouponException(msg.toString());
	}

	/**
	 * Returns the last user coupon in the ordered set where claimed = &#63;.
	 *
	 * @param claimed the claimed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user coupon, or <code>null</code> if a matching user coupon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon fetchByClaimedCoupons_Last(boolean claimed,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByClaimedCoupons(claimed);

		if (count == 0) {
			return null;
		}

		List<UserCoupon> list = findByClaimedCoupons(claimed, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user coupons before and after the current user coupon in the ordered set where claimed = &#63;.
	 *
	 * @param ucId the primary key of the current user coupon
	 * @param claimed the claimed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user coupon
	 * @throws com.services.NoSuchUserCouponException if a user coupon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon[] findByClaimedCoupons_PrevAndNext(long ucId,
		boolean claimed, OrderByComparator orderByComparator)
		throws NoSuchUserCouponException, SystemException {
		UserCoupon userCoupon = findByPrimaryKey(ucId);

		Session session = null;

		try {
			session = openSession();

			UserCoupon[] array = new UserCouponImpl[3];

			array[0] = getByClaimedCoupons_PrevAndNext(session, userCoupon,
					claimed, orderByComparator, true);

			array[1] = userCoupon;

			array[2] = getByClaimedCoupons_PrevAndNext(session, userCoupon,
					claimed, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserCoupon getByClaimedCoupons_PrevAndNext(Session session,
		UserCoupon userCoupon, boolean claimed,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERCOUPON_WHERE);

		query.append(_FINDER_COLUMN_CLAIMEDCOUPONS_CLAIMED_2);

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
			query.append(UserCouponModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(claimed);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userCoupon);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserCoupon> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user coupons where claimed = &#63; from the database.
	 *
	 * @param claimed the claimed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByClaimedCoupons(boolean claimed)
		throws SystemException {
		for (UserCoupon userCoupon : findByClaimedCoupons(claimed,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userCoupon);
		}
	}

	/**
	 * Returns the number of user coupons where claimed = &#63;.
	 *
	 * @param claimed the claimed
	 * @return the number of matching user coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByClaimedCoupons(boolean claimed) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLAIMEDCOUPONS;

		Object[] finderArgs = new Object[] { claimed };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERCOUPON_WHERE);

			query.append(_FINDER_COLUMN_CLAIMEDCOUPONS_CLAIMED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(claimed);

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

	private static final String _FINDER_COLUMN_CLAIMEDCOUPONS_CLAIMED_2 = "userCoupon.claimed = ?";

	public UserCouponPersistenceImpl() {
		setModelClass(UserCoupon.class);
	}

	/**
	 * Caches the user coupon in the entity cache if it is enabled.
	 *
	 * @param userCoupon the user coupon
	 */
	@Override
	public void cacheResult(UserCoupon userCoupon) {
		EntityCacheUtil.putResult(UserCouponModelImpl.ENTITY_CACHE_ENABLED,
			UserCouponImpl.class, userCoupon.getPrimaryKey(), userCoupon);

		userCoupon.resetOriginalValues();
	}

	/**
	 * Caches the user coupons in the entity cache if it is enabled.
	 *
	 * @param userCoupons the user coupons
	 */
	@Override
	public void cacheResult(List<UserCoupon> userCoupons) {
		for (UserCoupon userCoupon : userCoupons) {
			if (EntityCacheUtil.getResult(
						UserCouponModelImpl.ENTITY_CACHE_ENABLED,
						UserCouponImpl.class, userCoupon.getPrimaryKey()) == null) {
				cacheResult(userCoupon);
			}
			else {
				userCoupon.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user coupons.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserCouponImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserCouponImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user coupon.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserCoupon userCoupon) {
		EntityCacheUtil.removeResult(UserCouponModelImpl.ENTITY_CACHE_ENABLED,
			UserCouponImpl.class, userCoupon.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UserCoupon> userCoupons) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserCoupon userCoupon : userCoupons) {
			EntityCacheUtil.removeResult(UserCouponModelImpl.ENTITY_CACHE_ENABLED,
				UserCouponImpl.class, userCoupon.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user coupon with the primary key. Does not add the user coupon to the database.
	 *
	 * @param ucId the primary key for the new user coupon
	 * @return the new user coupon
	 */
	@Override
	public UserCoupon create(long ucId) {
		UserCoupon userCoupon = new UserCouponImpl();

		userCoupon.setNew(true);
		userCoupon.setPrimaryKey(ucId);

		return userCoupon;
	}

	/**
	 * Removes the user coupon with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ucId the primary key of the user coupon
	 * @return the user coupon that was removed
	 * @throws com.services.NoSuchUserCouponException if a user coupon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon remove(long ucId)
		throws NoSuchUserCouponException, SystemException {
		return remove((Serializable)ucId);
	}

	/**
	 * Removes the user coupon with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user coupon
	 * @return the user coupon that was removed
	 * @throws com.services.NoSuchUserCouponException if a user coupon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon remove(Serializable primaryKey)
		throws NoSuchUserCouponException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserCoupon userCoupon = (UserCoupon)session.get(UserCouponImpl.class,
					primaryKey);

			if (userCoupon == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserCouponException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userCoupon);
		}
		catch (NoSuchUserCouponException nsee) {
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
	protected UserCoupon removeImpl(UserCoupon userCoupon)
		throws SystemException {
		userCoupon = toUnwrappedModel(userCoupon);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userCoupon)) {
				userCoupon = (UserCoupon)session.get(UserCouponImpl.class,
						userCoupon.getPrimaryKeyObj());
			}

			if (userCoupon != null) {
				session.delete(userCoupon);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userCoupon != null) {
			clearCache(userCoupon);
		}

		return userCoupon;
	}

	@Override
	public UserCoupon updateImpl(com.services.model.UserCoupon userCoupon)
		throws SystemException {
		userCoupon = toUnwrappedModel(userCoupon);

		boolean isNew = userCoupon.isNew();

		UserCouponModelImpl userCouponModelImpl = (UserCouponModelImpl)userCoupon;

		Session session = null;

		try {
			session = openSession();

			if (userCoupon.isNew()) {
				session.save(userCoupon);

				userCoupon.setNew(false);
			}
			else {
				session.merge(userCoupon);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserCouponModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((userCouponModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userCouponModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { userCouponModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((userCouponModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERCOUPONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userCouponModelImpl.getOriginalUserId(),
						userCouponModelImpl.getOriginalCouponId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERCOUPONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERCOUPONID,
					args);

				args = new Object[] {
						userCouponModelImpl.getUserId(),
						userCouponModelImpl.getCouponId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERCOUPONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERCOUPONID,
					args);
			}

			if ((userCouponModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUPONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userCouponModelImpl.getOriginalCouponId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUPONID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUPONID,
					args);

				args = new Object[] { userCouponModelImpl.getCouponId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUPONID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUPONID,
					args);
			}

			if ((userCouponModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLAIMEDCOUPONS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userCouponModelImpl.getOriginalClaimed()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLAIMEDCOUPONS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLAIMEDCOUPONS,
					args);

				args = new Object[] { userCouponModelImpl.getClaimed() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLAIMEDCOUPONS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLAIMEDCOUPONS,
					args);
			}
		}

		EntityCacheUtil.putResult(UserCouponModelImpl.ENTITY_CACHE_ENABLED,
			UserCouponImpl.class, userCoupon.getPrimaryKey(), userCoupon);

		return userCoupon;
	}

	protected UserCoupon toUnwrappedModel(UserCoupon userCoupon) {
		if (userCoupon instanceof UserCouponImpl) {
			return userCoupon;
		}

		UserCouponImpl userCouponImpl = new UserCouponImpl();

		userCouponImpl.setNew(userCoupon.isNew());
		userCouponImpl.setPrimaryKey(userCoupon.getPrimaryKey());

		userCouponImpl.setUcId(userCoupon.getUcId());
		userCouponImpl.setUserId(userCoupon.getUserId());
		userCouponImpl.setCouponId(userCoupon.getCouponId());
		userCouponImpl.setClaimed(userCoupon.isClaimed());
		userCouponImpl.setCreateDate(userCoupon.getCreateDate());

		return userCouponImpl;
	}

	/**
	 * Returns the user coupon with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user coupon
	 * @return the user coupon
	 * @throws com.services.NoSuchUserCouponException if a user coupon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserCouponException, SystemException {
		UserCoupon userCoupon = fetchByPrimaryKey(primaryKey);

		if (userCoupon == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserCouponException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userCoupon;
	}

	/**
	 * Returns the user coupon with the primary key or throws a {@link com.services.NoSuchUserCouponException} if it could not be found.
	 *
	 * @param ucId the primary key of the user coupon
	 * @return the user coupon
	 * @throws com.services.NoSuchUserCouponException if a user coupon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon findByPrimaryKey(long ucId)
		throws NoSuchUserCouponException, SystemException {
		return findByPrimaryKey((Serializable)ucId);
	}

	/**
	 * Returns the user coupon with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user coupon
	 * @return the user coupon, or <code>null</code> if a user coupon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UserCoupon userCoupon = (UserCoupon)EntityCacheUtil.getResult(UserCouponModelImpl.ENTITY_CACHE_ENABLED,
				UserCouponImpl.class, primaryKey);

		if (userCoupon == _nullUserCoupon) {
			return null;
		}

		if (userCoupon == null) {
			Session session = null;

			try {
				session = openSession();

				userCoupon = (UserCoupon)session.get(UserCouponImpl.class,
						primaryKey);

				if (userCoupon != null) {
					cacheResult(userCoupon);
				}
				else {
					EntityCacheUtil.putResult(UserCouponModelImpl.ENTITY_CACHE_ENABLED,
						UserCouponImpl.class, primaryKey, _nullUserCoupon);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UserCouponModelImpl.ENTITY_CACHE_ENABLED,
					UserCouponImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userCoupon;
	}

	/**
	 * Returns the user coupon with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ucId the primary key of the user coupon
	 * @return the user coupon, or <code>null</code> if a user coupon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserCoupon fetchByPrimaryKey(long ucId) throws SystemException {
		return fetchByPrimaryKey((Serializable)ucId);
	}

	/**
	 * Returns all the user coupons.
	 *
	 * @return the user coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserCoupon> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user coupons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.UserCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user coupons
	 * @param end the upper bound of the range of user coupons (not inclusive)
	 * @return the range of user coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserCoupon> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user coupons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.UserCouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user coupons
	 * @param end the upper bound of the range of user coupons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserCoupon> findAll(int start, int end,
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

		List<UserCoupon> list = (List<UserCoupon>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERCOUPON);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERCOUPON;

				if (pagination) {
					sql = sql.concat(UserCouponModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserCoupon>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserCoupon>(list);
				}
				else {
					list = (List<UserCoupon>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the user coupons from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UserCoupon userCoupon : findAll()) {
			remove(userCoupon);
		}
	}

	/**
	 * Returns the number of user coupons.
	 *
	 * @return the number of user coupons
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

				Query q = session.createQuery(_SQL_COUNT_USERCOUPON);

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
	 * Initializes the user coupon persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.services.model.UserCoupon")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserCoupon>> listenersList = new ArrayList<ModelListener<UserCoupon>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserCoupon>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserCouponImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_USERCOUPON = "SELECT userCoupon FROM UserCoupon userCoupon";
	private static final String _SQL_SELECT_USERCOUPON_WHERE = "SELECT userCoupon FROM UserCoupon userCoupon WHERE ";
	private static final String _SQL_COUNT_USERCOUPON = "SELECT COUNT(userCoupon) FROM UserCoupon userCoupon";
	private static final String _SQL_COUNT_USERCOUPON_WHERE = "SELECT COUNT(userCoupon) FROM UserCoupon userCoupon WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userCoupon.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserCoupon exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserCoupon exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserCouponPersistenceImpl.class);
	private static UserCoupon _nullUserCoupon = new UserCouponImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserCoupon> toCacheModel() {
				return _nullUserCouponCacheModel;
			}
		};

	private static CacheModel<UserCoupon> _nullUserCouponCacheModel = new CacheModel<UserCoupon>() {
			@Override
			public UserCoupon toEntityModel() {
				return _nullUserCoupon;
			}
		};
}