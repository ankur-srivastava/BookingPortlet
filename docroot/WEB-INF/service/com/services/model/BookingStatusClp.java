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

package com.services.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.services.service.BookingStatusLocalServiceUtil;
import com.services.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ankur Srivastava
 */
public class BookingStatusClp extends BaseModelImpl<BookingStatus>
	implements BookingStatus {
	public BookingStatusClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BookingStatus.class;
	}

	@Override
	public String getModelClassName() {
		return BookingStatus.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _bsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bsId", getBsId());
		attributes.put("userId", getUserId());
		attributes.put("brtId", getBrtId());
		attributes.put("status", getStatus());
		attributes.put("tripStatus", getTripStatus());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bsId = (Long)attributes.get("bsId");

		if (bsId != null) {
			setBsId(bsId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long brtId = (Long)attributes.get("brtId");

		if (brtId != null) {
			setBrtId(brtId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String tripStatus = (String)attributes.get("tripStatus");

		if (tripStatus != null) {
			setTripStatus(tripStatus);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public long getBsId() {
		return _bsId;
	}

	@Override
	public void setBsId(long bsId) {
		_bsId = bsId;

		if (_bookingStatusRemoteModel != null) {
			try {
				Class<?> clazz = _bookingStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setBsId", long.class);

				method.invoke(_bookingStatusRemoteModel, bsId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_bookingStatusRemoteModel != null) {
			try {
				Class<?> clazz = _bookingStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_bookingStatusRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public long getBrtId() {
		return _brtId;
	}

	@Override
	public void setBrtId(long brtId) {
		_brtId = brtId;

		if (_bookingStatusRemoteModel != null) {
			try {
				Class<?> clazz = _bookingStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setBrtId", long.class);

				method.invoke(_bookingStatusRemoteModel, brtId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_bookingStatusRemoteModel != null) {
			try {
				Class<?> clazz = _bookingStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_bookingStatusRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTripStatus() {
		return _tripStatus;
	}

	@Override
	public void setTripStatus(String tripStatus) {
		_tripStatus = tripStatus;

		if (_bookingStatusRemoteModel != null) {
			try {
				Class<?> clazz = _bookingStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setTripStatus", String.class);

				method.invoke(_bookingStatusRemoteModel, tripStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_bookingStatusRemoteModel != null) {
			try {
				Class<?> clazz = _bookingStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_bookingStatusRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBookingStatusRemoteModel() {
		return _bookingStatusRemoteModel;
	}

	public void setBookingStatusRemoteModel(
		BaseModel<?> bookingStatusRemoteModel) {
		_bookingStatusRemoteModel = bookingStatusRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _bookingStatusRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_bookingStatusRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BookingStatusLocalServiceUtil.addBookingStatus(this);
		}
		else {
			BookingStatusLocalServiceUtil.updateBookingStatus(this);
		}
	}

	@Override
	public BookingStatus toEscapedModel() {
		return (BookingStatus)ProxyUtil.newProxyInstance(BookingStatus.class.getClassLoader(),
			new Class[] { BookingStatus.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BookingStatusClp clone = new BookingStatusClp();

		clone.setBsId(getBsId());
		clone.setUserId(getUserId());
		clone.setBrtId(getBrtId());
		clone.setStatus(getStatus());
		clone.setTripStatus(getTripStatus());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(BookingStatus bookingStatus) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				bookingStatus.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BookingStatusClp)) {
			return false;
		}

		BookingStatusClp bookingStatus = (BookingStatusClp)obj;

		long primaryKey = bookingStatus.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{bsId=");
		sb.append(getBsId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", brtId=");
		sb.append(getBrtId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", tripStatus=");
		sb.append(getTripStatus());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.services.model.BookingStatus");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>bsId</column-name><column-value><![CDATA[");
		sb.append(getBsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>brtId</column-name><column-value><![CDATA[");
		sb.append(getBrtId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tripStatus</column-name><column-value><![CDATA[");
		sb.append(getTripStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _bsId;
	private long _userId;
	private String _userUuid;
	private long _brtId;
	private String _status;
	private String _tripStatus;
	private Date _createDate;
	private BaseModel<?> _bookingStatusRemoteModel;
	private Class<?> _clpSerializerClass = com.services.service.ClpSerializer.class;
}