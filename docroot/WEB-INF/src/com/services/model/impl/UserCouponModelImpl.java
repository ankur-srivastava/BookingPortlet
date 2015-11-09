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

package com.services.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.services.model.UserCoupon;
import com.services.model.UserCouponModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the UserCoupon service. Represents a row in the &quot;JPB_UserCoupon&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.services.model.UserCouponModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserCouponImpl}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see UserCouponImpl
 * @see com.services.model.UserCoupon
 * @see com.services.model.UserCouponModel
 * @generated
 */
public class UserCouponModelImpl extends BaseModelImpl<UserCoupon>
	implements UserCouponModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user coupon model instance should use the {@link com.services.model.UserCoupon} interface instead.
	 */
	public static final String TABLE_NAME = "JPB_UserCoupon";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ucId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "couponId", Types.BIGINT },
			{ "claimed", Types.BOOLEAN },
			{ "createDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table JPB_UserCoupon (ucId LONG not null primary key,userId LONG,couponId LONG,claimed BOOLEAN,createDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table JPB_UserCoupon";
	public static final String ORDER_BY_JPQL = " ORDER BY userCoupon.ucId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY JPB_UserCoupon.ucId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.services.model.UserCoupon"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.services.model.UserCoupon"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.services.model.UserCoupon"),
			true);
	public static long CLAIMED_COLUMN_BITMASK = 1L;
	public static long COUPONID_COLUMN_BITMASK = 2L;
	public static long USERID_COLUMN_BITMASK = 4L;
	public static long UCID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.services.model.UserCoupon"));

	public UserCouponModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ucId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUcId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ucId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return UserCoupon.class;
	}

	@Override
	public String getModelClassName() {
		return UserCoupon.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ucId", getUcId());
		attributes.put("userId", getUserId());
		attributes.put("couponId", getCouponId());
		attributes.put("claimed", getClaimed());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ucId = (Long)attributes.get("ucId");

		if (ucId != null) {
			setUcId(ucId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long couponId = (Long)attributes.get("couponId");

		if (couponId != null) {
			setCouponId(couponId);
		}

		Boolean claimed = (Boolean)attributes.get("claimed");

		if (claimed != null) {
			setClaimed(claimed);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public long getUcId() {
		return _ucId;
	}

	@Override
	public void setUcId(long ucId) {
		_ucId = ucId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public long getCouponId() {
		return _couponId;
	}

	@Override
	public void setCouponId(long couponId) {
		_columnBitmask |= COUPONID_COLUMN_BITMASK;

		if (!_setOriginalCouponId) {
			_setOriginalCouponId = true;

			_originalCouponId = _couponId;
		}

		_couponId = couponId;
	}

	public long getOriginalCouponId() {
		return _originalCouponId;
	}

	@Override
	public boolean getClaimed() {
		return _claimed;
	}

	@Override
	public boolean isClaimed() {
		return _claimed;
	}

	@Override
	public void setClaimed(boolean claimed) {
		_columnBitmask |= CLAIMED_COLUMN_BITMASK;

		if (!_setOriginalClaimed) {
			_setOriginalClaimed = true;

			_originalClaimed = _claimed;
		}

		_claimed = claimed;
	}

	public boolean getOriginalClaimed() {
		return _originalClaimed;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			UserCoupon.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public UserCoupon toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (UserCoupon)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		UserCouponImpl userCouponImpl = new UserCouponImpl();

		userCouponImpl.setUcId(getUcId());
		userCouponImpl.setUserId(getUserId());
		userCouponImpl.setCouponId(getCouponId());
		userCouponImpl.setClaimed(getClaimed());
		userCouponImpl.setCreateDate(getCreateDate());

		userCouponImpl.resetOriginalValues();

		return userCouponImpl;
	}

	@Override
	public int compareTo(UserCoupon userCoupon) {
		long primaryKey = userCoupon.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserCoupon)) {
			return false;
		}

		UserCoupon userCoupon = (UserCoupon)obj;

		long primaryKey = userCoupon.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		UserCouponModelImpl userCouponModelImpl = this;

		userCouponModelImpl._originalUserId = userCouponModelImpl._userId;

		userCouponModelImpl._setOriginalUserId = false;

		userCouponModelImpl._originalCouponId = userCouponModelImpl._couponId;

		userCouponModelImpl._setOriginalCouponId = false;

		userCouponModelImpl._originalClaimed = userCouponModelImpl._claimed;

		userCouponModelImpl._setOriginalClaimed = false;

		userCouponModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<UserCoupon> toCacheModel() {
		UserCouponCacheModel userCouponCacheModel = new UserCouponCacheModel();

		userCouponCacheModel.ucId = getUcId();

		userCouponCacheModel.userId = getUserId();

		userCouponCacheModel.couponId = getCouponId();

		userCouponCacheModel.claimed = getClaimed();

		Date createDate = getCreateDate();

		if (createDate != null) {
			userCouponCacheModel.createDate = createDate.getTime();
		}
		else {
			userCouponCacheModel.createDate = Long.MIN_VALUE;
		}

		return userCouponCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{ucId=");
		sb.append(getUcId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", couponId=");
		sb.append(getCouponId());
		sb.append(", claimed=");
		sb.append(getClaimed());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.services.model.UserCoupon");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ucId</column-name><column-value><![CDATA[");
		sb.append(getUcId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>couponId</column-name><column-value><![CDATA[");
		sb.append(getCouponId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>claimed</column-name><column-value><![CDATA[");
		sb.append(getClaimed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = UserCoupon.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			UserCoupon.class
		};
	private long _ucId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private long _couponId;
	private long _originalCouponId;
	private boolean _setOriginalCouponId;
	private boolean _claimed;
	private boolean _originalClaimed;
	private boolean _setOriginalClaimed;
	private Date _createDate;
	private long _columnBitmask;
	private UserCoupon _escapedModel;
}