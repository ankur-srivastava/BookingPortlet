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

import com.services.model.BusReservation;
import com.services.model.BusReservationModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the BusReservation service. Represents a row in the &quot;JPB_BusReservation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.services.model.BusReservationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BusReservationImpl}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusReservationImpl
 * @see com.services.model.BusReservation
 * @see com.services.model.BusReservationModel
 * @generated
 */
public class BusReservationModelImpl extends BaseModelImpl<BusReservation>
	implements BusReservationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a bus reservation model instance should use the {@link com.services.model.BusReservation} interface instead.
	 */
	public static final String TABLE_NAME = "JPB_BusReservation";
	public static final Object[][] TABLE_COLUMNS = {
			{ "brId", Types.BIGINT },
			{ "baId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "paymentReceived", Types.BOOLEAN },
			{ "bookingDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table JPB_BusReservation (brId LONG not null primary key,baId LONG,userId LONG,paymentReceived BOOLEAN,bookingDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table JPB_BusReservation";
	public static final String ORDER_BY_JPQL = " ORDER BY busReservation.brId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY JPB_BusReservation.brId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.services.model.BusReservation"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.services.model.BusReservation"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.services.model.BusReservation"),
			true);
	public static long BAID_COLUMN_BITMASK = 1L;
	public static long USERID_COLUMN_BITMASK = 2L;
	public static long BRID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.services.model.BusReservation"));

	public BusReservationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _brId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBrId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _brId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return BusReservation.class;
	}

	@Override
	public String getModelClassName() {
		return BusReservation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("brId", getBrId());
		attributes.put("baId", getBaId());
		attributes.put("userId", getUserId());
		attributes.put("paymentReceived", getPaymentReceived());
		attributes.put("bookingDate", getBookingDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long brId = (Long)attributes.get("brId");

		if (brId != null) {
			setBrId(brId);
		}

		Long baId = (Long)attributes.get("baId");

		if (baId != null) {
			setBaId(baId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Boolean paymentReceived = (Boolean)attributes.get("paymentReceived");

		if (paymentReceived != null) {
			setPaymentReceived(paymentReceived);
		}

		Date bookingDate = (Date)attributes.get("bookingDate");

		if (bookingDate != null) {
			setBookingDate(bookingDate);
		}
	}

	@Override
	public long getBrId() {
		return _brId;
	}

	@Override
	public void setBrId(long brId) {
		_brId = brId;
	}

	@Override
	public long getBaId() {
		return _baId;
	}

	@Override
	public void setBaId(long baId) {
		_columnBitmask |= BAID_COLUMN_BITMASK;

		if (!_setOriginalBaId) {
			_setOriginalBaId = true;

			_originalBaId = _baId;
		}

		_baId = baId;
	}

	public long getOriginalBaId() {
		return _originalBaId;
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
	public boolean getPaymentReceived() {
		return _paymentReceived;
	}

	@Override
	public boolean isPaymentReceived() {
		return _paymentReceived;
	}

	@Override
	public void setPaymentReceived(boolean paymentReceived) {
		_paymentReceived = paymentReceived;
	}

	@Override
	public Date getBookingDate() {
		return _bookingDate;
	}

	@Override
	public void setBookingDate(Date bookingDate) {
		_bookingDate = bookingDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			BusReservation.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BusReservation toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (BusReservation)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BusReservationImpl busReservationImpl = new BusReservationImpl();

		busReservationImpl.setBrId(getBrId());
		busReservationImpl.setBaId(getBaId());
		busReservationImpl.setUserId(getUserId());
		busReservationImpl.setPaymentReceived(getPaymentReceived());
		busReservationImpl.setBookingDate(getBookingDate());

		busReservationImpl.resetOriginalValues();

		return busReservationImpl;
	}

	@Override
	public int compareTo(BusReservation busReservation) {
		long primaryKey = busReservation.getPrimaryKey();

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

		if (!(obj instanceof BusReservation)) {
			return false;
		}

		BusReservation busReservation = (BusReservation)obj;

		long primaryKey = busReservation.getPrimaryKey();

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
		BusReservationModelImpl busReservationModelImpl = this;

		busReservationModelImpl._originalBaId = busReservationModelImpl._baId;

		busReservationModelImpl._setOriginalBaId = false;

		busReservationModelImpl._originalUserId = busReservationModelImpl._userId;

		busReservationModelImpl._setOriginalUserId = false;

		busReservationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<BusReservation> toCacheModel() {
		BusReservationCacheModel busReservationCacheModel = new BusReservationCacheModel();

		busReservationCacheModel.brId = getBrId();

		busReservationCacheModel.baId = getBaId();

		busReservationCacheModel.userId = getUserId();

		busReservationCacheModel.paymentReceived = getPaymentReceived();

		Date bookingDate = getBookingDate();

		if (bookingDate != null) {
			busReservationCacheModel.bookingDate = bookingDate.getTime();
		}
		else {
			busReservationCacheModel.bookingDate = Long.MIN_VALUE;
		}

		return busReservationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{brId=");
		sb.append(getBrId());
		sb.append(", baId=");
		sb.append(getBaId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", paymentReceived=");
		sb.append(getPaymentReceived());
		sb.append(", bookingDate=");
		sb.append(getBookingDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.services.model.BusReservation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>brId</column-name><column-value><![CDATA[");
		sb.append(getBrId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>baId</column-name><column-value><![CDATA[");
		sb.append(getBaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentReceived</column-name><column-value><![CDATA[");
		sb.append(getPaymentReceived());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookingDate</column-name><column-value><![CDATA[");
		sb.append(getBookingDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = BusReservation.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			BusReservation.class
		};
	private long _brId;
	private long _baId;
	private long _originalBaId;
	private boolean _setOriginalBaId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private boolean _paymentReceived;
	private Date _bookingDate;
	private long _columnBitmask;
	private BusReservation _escapedModel;
}