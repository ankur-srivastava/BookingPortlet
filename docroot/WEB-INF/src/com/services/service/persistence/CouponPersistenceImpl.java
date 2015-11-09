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

import com.services.NoSuchCouponException;

import com.services.model.Coupon;
import com.services.model.impl.CouponImpl;
import com.services.model.impl.CouponModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the coupon service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see CouponPersistence
 * @see CouponUtil
 * @generated
 */
public class CouponPersistenceImpl extends BasePersistenceImpl<Coupon>
	implements CouponPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CouponUtil} to access the coupon persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CouponImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CouponModelImpl.ENTITY_CACHE_ENABLED,
			CouponModelImpl.FINDER_CACHE_ENABLED, CouponImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CouponModelImpl.ENTITY_CACHE_ENABLED,
			CouponModelImpl.FINDER_CACHE_ENABLED, CouponImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CouponModelImpl.ENTITY_CACHE_ENABLED,
			CouponModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUPONNAME =
		new FinderPath(CouponModelImpl.ENTITY_CACHE_ENABLED,
			CouponModelImpl.FINDER_CACHE_ENABLED, CouponImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCouponName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUPONNAME =
		new FinderPath(CouponModelImpl.ENTITY_CACHE_ENABLED,
			CouponModelImpl.FINDER_CACHE_ENABLED, CouponImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCouponName",
			new String[] { String.class.getName() },
			CouponModelImpl.COUPONNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUPONNAME = new FinderPath(CouponModelImpl.ENTITY_CACHE_ENABLED,
			CouponModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCouponName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the coupons where couponName = &#63;.
	 *
	 * @param couponName the coupon name
	 * @return the matching coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Coupon> findByCouponName(String couponName)
		throws SystemException {
		return findByCouponName(couponName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the coupons where couponName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.CouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param couponName the coupon name
	 * @param start the lower bound of the range of coupons
	 * @param end the upper bound of the range of coupons (not inclusive)
	 * @return the range of matching coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Coupon> findByCouponName(String couponName, int start, int end)
		throws SystemException {
		return findByCouponName(couponName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the coupons where couponName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.CouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param couponName the coupon name
	 * @param start the lower bound of the range of coupons
	 * @param end the upper bound of the range of coupons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Coupon> findByCouponName(String couponName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUPONNAME;
			finderArgs = new Object[] { couponName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COUPONNAME;
			finderArgs = new Object[] { couponName, start, end, orderByComparator };
		}

		List<Coupon> list = (List<Coupon>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Coupon coupon : list) {
				if (!Validator.equals(couponName, coupon.getCouponName())) {
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

			query.append(_SQL_SELECT_COUPON_WHERE);

			boolean bindCouponName = false;

			if (couponName == null) {
				query.append(_FINDER_COLUMN_COUPONNAME_COUPONNAME_1);
			}
			else if (couponName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUPONNAME_COUPONNAME_3);
			}
			else {
				bindCouponName = true;

				query.append(_FINDER_COLUMN_COUPONNAME_COUPONNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CouponModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCouponName) {
					qPos.add(couponName);
				}

				if (!pagination) {
					list = (List<Coupon>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Coupon>(list);
				}
				else {
					list = (List<Coupon>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first coupon in the ordered set where couponName = &#63;.
	 *
	 * @param couponName the coupon name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coupon
	 * @throws com.services.NoSuchCouponException if a matching coupon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coupon findByCouponName_First(String couponName,
		OrderByComparator orderByComparator)
		throws NoSuchCouponException, SystemException {
		Coupon coupon = fetchByCouponName_First(couponName, orderByComparator);

		if (coupon != null) {
			return coupon;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("couponName=");
		msg.append(couponName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCouponException(msg.toString());
	}

	/**
	 * Returns the first coupon in the ordered set where couponName = &#63;.
	 *
	 * @param couponName the coupon name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coupon, or <code>null</code> if a matching coupon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coupon fetchByCouponName_First(String couponName,
		OrderByComparator orderByComparator) throws SystemException {
		List<Coupon> list = findByCouponName(couponName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last coupon in the ordered set where couponName = &#63;.
	 *
	 * @param couponName the coupon name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coupon
	 * @throws com.services.NoSuchCouponException if a matching coupon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coupon findByCouponName_Last(String couponName,
		OrderByComparator orderByComparator)
		throws NoSuchCouponException, SystemException {
		Coupon coupon = fetchByCouponName_Last(couponName, orderByComparator);

		if (coupon != null) {
			return coupon;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("couponName=");
		msg.append(couponName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCouponException(msg.toString());
	}

	/**
	 * Returns the last coupon in the ordered set where couponName = &#63;.
	 *
	 * @param couponName the coupon name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coupon, or <code>null</code> if a matching coupon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coupon fetchByCouponName_Last(String couponName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCouponName(couponName);

		if (count == 0) {
			return null;
		}

		List<Coupon> list = findByCouponName(couponName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the coupons before and after the current coupon in the ordered set where couponName = &#63;.
	 *
	 * @param couponId the primary key of the current coupon
	 * @param couponName the coupon name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coupon
	 * @throws com.services.NoSuchCouponException if a coupon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coupon[] findByCouponName_PrevAndNext(long couponId,
		String couponName, OrderByComparator orderByComparator)
		throws NoSuchCouponException, SystemException {
		Coupon coupon = findByPrimaryKey(couponId);

		Session session = null;

		try {
			session = openSession();

			Coupon[] array = new CouponImpl[3];

			array[0] = getByCouponName_PrevAndNext(session, coupon, couponName,
					orderByComparator, true);

			array[1] = coupon;

			array[2] = getByCouponName_PrevAndNext(session, coupon, couponName,
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

	protected Coupon getByCouponName_PrevAndNext(Session session,
		Coupon coupon, String couponName, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COUPON_WHERE);

		boolean bindCouponName = false;

		if (couponName == null) {
			query.append(_FINDER_COLUMN_COUPONNAME_COUPONNAME_1);
		}
		else if (couponName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COUPONNAME_COUPONNAME_3);
		}
		else {
			bindCouponName = true;

			query.append(_FINDER_COLUMN_COUPONNAME_COUPONNAME_2);
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
			query.append(CouponModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCouponName) {
			qPos.add(couponName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(coupon);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Coupon> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the coupons where couponName = &#63; from the database.
	 *
	 * @param couponName the coupon name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCouponName(String couponName) throws SystemException {
		for (Coupon coupon : findByCouponName(couponName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(coupon);
		}
	}

	/**
	 * Returns the number of coupons where couponName = &#63;.
	 *
	 * @param couponName the coupon name
	 * @return the number of matching coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCouponName(String couponName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUPONNAME;

		Object[] finderArgs = new Object[] { couponName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COUPON_WHERE);

			boolean bindCouponName = false;

			if (couponName == null) {
				query.append(_FINDER_COLUMN_COUPONNAME_COUPONNAME_1);
			}
			else if (couponName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUPONNAME_COUPONNAME_3);
			}
			else {
				bindCouponName = true;

				query.append(_FINDER_COLUMN_COUPONNAME_COUPONNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCouponName) {
					qPos.add(couponName);
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

	private static final String _FINDER_COLUMN_COUPONNAME_COUPONNAME_1 = "coupon.couponName IS NULL";
	private static final String _FINDER_COLUMN_COUPONNAME_COUPONNAME_2 = "coupon.couponName = ?";
	private static final String _FINDER_COLUMN_COUPONNAME_COUPONNAME_3 = "(coupon.couponName IS NULL OR coupon.couponName = '')";

	public CouponPersistenceImpl() {
		setModelClass(Coupon.class);
	}

	/**
	 * Caches the coupon in the entity cache if it is enabled.
	 *
	 * @param coupon the coupon
	 */
	@Override
	public void cacheResult(Coupon coupon) {
		EntityCacheUtil.putResult(CouponModelImpl.ENTITY_CACHE_ENABLED,
			CouponImpl.class, coupon.getPrimaryKey(), coupon);

		coupon.resetOriginalValues();
	}

	/**
	 * Caches the coupons in the entity cache if it is enabled.
	 *
	 * @param coupons the coupons
	 */
	@Override
	public void cacheResult(List<Coupon> coupons) {
		for (Coupon coupon : coupons) {
			if (EntityCacheUtil.getResult(
						CouponModelImpl.ENTITY_CACHE_ENABLED, CouponImpl.class,
						coupon.getPrimaryKey()) == null) {
				cacheResult(coupon);
			}
			else {
				coupon.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all coupons.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CouponImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CouponImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the coupon.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Coupon coupon) {
		EntityCacheUtil.removeResult(CouponModelImpl.ENTITY_CACHE_ENABLED,
			CouponImpl.class, coupon.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Coupon> coupons) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Coupon coupon : coupons) {
			EntityCacheUtil.removeResult(CouponModelImpl.ENTITY_CACHE_ENABLED,
				CouponImpl.class, coupon.getPrimaryKey());
		}
	}

	/**
	 * Creates a new coupon with the primary key. Does not add the coupon to the database.
	 *
	 * @param couponId the primary key for the new coupon
	 * @return the new coupon
	 */
	@Override
	public Coupon create(long couponId) {
		Coupon coupon = new CouponImpl();

		coupon.setNew(true);
		coupon.setPrimaryKey(couponId);

		return coupon;
	}

	/**
	 * Removes the coupon with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param couponId the primary key of the coupon
	 * @return the coupon that was removed
	 * @throws com.services.NoSuchCouponException if a coupon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coupon remove(long couponId)
		throws NoSuchCouponException, SystemException {
		return remove((Serializable)couponId);
	}

	/**
	 * Removes the coupon with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the coupon
	 * @return the coupon that was removed
	 * @throws com.services.NoSuchCouponException if a coupon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coupon remove(Serializable primaryKey)
		throws NoSuchCouponException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Coupon coupon = (Coupon)session.get(CouponImpl.class, primaryKey);

			if (coupon == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCouponException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(coupon);
		}
		catch (NoSuchCouponException nsee) {
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
	protected Coupon removeImpl(Coupon coupon) throws SystemException {
		coupon = toUnwrappedModel(coupon);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(coupon)) {
				coupon = (Coupon)session.get(CouponImpl.class,
						coupon.getPrimaryKeyObj());
			}

			if (coupon != null) {
				session.delete(coupon);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (coupon != null) {
			clearCache(coupon);
		}

		return coupon;
	}

	@Override
	public Coupon updateImpl(com.services.model.Coupon coupon)
		throws SystemException {
		coupon = toUnwrappedModel(coupon);

		boolean isNew = coupon.isNew();

		CouponModelImpl couponModelImpl = (CouponModelImpl)coupon;

		Session session = null;

		try {
			session = openSession();

			if (coupon.isNew()) {
				session.save(coupon);

				coupon.setNew(false);
			}
			else {
				session.merge(coupon);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CouponModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((couponModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUPONNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						couponModelImpl.getOriginalCouponName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUPONNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUPONNAME,
					args);

				args = new Object[] { couponModelImpl.getCouponName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUPONNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUPONNAME,
					args);
			}
		}

		EntityCacheUtil.putResult(CouponModelImpl.ENTITY_CACHE_ENABLED,
			CouponImpl.class, coupon.getPrimaryKey(), coupon);

		return coupon;
	}

	protected Coupon toUnwrappedModel(Coupon coupon) {
		if (coupon instanceof CouponImpl) {
			return coupon;
		}

		CouponImpl couponImpl = new CouponImpl();

		couponImpl.setNew(coupon.isNew());
		couponImpl.setPrimaryKey(coupon.getPrimaryKey());

		couponImpl.setCouponId(coupon.getCouponId());
		couponImpl.setCouponName(coupon.getCouponName());
		couponImpl.setPrice(coupon.getPrice());
		couponImpl.setValidTill(coupon.getValidTill());
		couponImpl.setAudience(coupon.isAudience());
		couponImpl.setCreateDate(coupon.getCreateDate());

		return couponImpl;
	}

	/**
	 * Returns the coupon with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the coupon
	 * @return the coupon
	 * @throws com.services.NoSuchCouponException if a coupon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coupon findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCouponException, SystemException {
		Coupon coupon = fetchByPrimaryKey(primaryKey);

		if (coupon == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCouponException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return coupon;
	}

	/**
	 * Returns the coupon with the primary key or throws a {@link com.services.NoSuchCouponException} if it could not be found.
	 *
	 * @param couponId the primary key of the coupon
	 * @return the coupon
	 * @throws com.services.NoSuchCouponException if a coupon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coupon findByPrimaryKey(long couponId)
		throws NoSuchCouponException, SystemException {
		return findByPrimaryKey((Serializable)couponId);
	}

	/**
	 * Returns the coupon with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the coupon
	 * @return the coupon, or <code>null</code> if a coupon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coupon fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Coupon coupon = (Coupon)EntityCacheUtil.getResult(CouponModelImpl.ENTITY_CACHE_ENABLED,
				CouponImpl.class, primaryKey);

		if (coupon == _nullCoupon) {
			return null;
		}

		if (coupon == null) {
			Session session = null;

			try {
				session = openSession();

				coupon = (Coupon)session.get(CouponImpl.class, primaryKey);

				if (coupon != null) {
					cacheResult(coupon);
				}
				else {
					EntityCacheUtil.putResult(CouponModelImpl.ENTITY_CACHE_ENABLED,
						CouponImpl.class, primaryKey, _nullCoupon);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CouponModelImpl.ENTITY_CACHE_ENABLED,
					CouponImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return coupon;
	}

	/**
	 * Returns the coupon with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param couponId the primary key of the coupon
	 * @return the coupon, or <code>null</code> if a coupon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coupon fetchByPrimaryKey(long couponId) throws SystemException {
		return fetchByPrimaryKey((Serializable)couponId);
	}

	/**
	 * Returns all the coupons.
	 *
	 * @return the coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Coupon> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the coupons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.CouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of coupons
	 * @param end the upper bound of the range of coupons (not inclusive)
	 * @return the range of coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Coupon> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the coupons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.CouponModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of coupons
	 * @param end the upper bound of the range of coupons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of coupons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Coupon> findAll(int start, int end,
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

		List<Coupon> list = (List<Coupon>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COUPON);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COUPON;

				if (pagination) {
					sql = sql.concat(CouponModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Coupon>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Coupon>(list);
				}
				else {
					list = (List<Coupon>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the coupons from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Coupon coupon : findAll()) {
			remove(coupon);
		}
	}

	/**
	 * Returns the number of coupons.
	 *
	 * @return the number of coupons
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

				Query q = session.createQuery(_SQL_COUNT_COUPON);

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
	 * Initializes the coupon persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.services.model.Coupon")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Coupon>> listenersList = new ArrayList<ModelListener<Coupon>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Coupon>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CouponImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COUPON = "SELECT coupon FROM Coupon coupon";
	private static final String _SQL_SELECT_COUPON_WHERE = "SELECT coupon FROM Coupon coupon WHERE ";
	private static final String _SQL_COUNT_COUPON = "SELECT COUNT(coupon) FROM Coupon coupon";
	private static final String _SQL_COUNT_COUPON_WHERE = "SELECT COUNT(coupon) FROM Coupon coupon WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "coupon.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Coupon exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Coupon exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CouponPersistenceImpl.class);
	private static Coupon _nullCoupon = new CouponImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Coupon> toCacheModel() {
				return _nullCouponCacheModel;
			}
		};

	private static CacheModel<Coupon> _nullCouponCacheModel = new CacheModel<Coupon>() {
			@Override
			public Coupon toEntityModel() {
				return _nullCoupon;
			}
		};
}