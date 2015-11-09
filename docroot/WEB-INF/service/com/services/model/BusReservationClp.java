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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.services.service.BusReservationLocalServiceUtil;
import com.services.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ankur Srivastava
 */
public class BusReservationClp extends BaseModelImpl<BusReservation>
	implements BusReservation {
	public BusReservationClp() {
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

		if (_busReservationRemoteModel != null) {
			try {
				Class<?> clazz = _busReservationRemoteModel.getClass();

				Method method = clazz.getMethod("setBrId", long.class);

				method.invoke(_busReservationRemoteModel, brId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBaId() {
		return _baId;
	}

	@Override
	public void setBaId(long baId) {
		_baId = baId;

		if (_busReservationRemoteModel != null) {
			try {
				Class<?> clazz = _busReservationRemoteModel.getClass();

				Method method = clazz.getMethod("setBaId", long.class);

				method.invoke(_busReservationRemoteModel, baId);
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

		if (_busReservationRemoteModel != null) {
			try {
				Class<?> clazz = _busReservationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_busReservationRemoteModel, userId);
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

		if (_busReservationRemoteModel != null) {
			try {
				Class<?> clazz = _busReservationRemoteModel.getClass();

				Method method = clazz.getMethod("setPaymentReceived",
						boolean.class);

				method.invoke(_busReservationRemoteModel, paymentReceived);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getBookingDate() {
		return _bookingDate;
	}

	@Override
	public void setBookingDate(Date bookingDate) {
		_bookingDate = bookingDate;

		if (_busReservationRemoteModel != null) {
			try {
				Class<?> clazz = _busReservationRemoteModel.getClass();

				Method method = clazz.getMethod("setBookingDate", Date.class);

				method.invoke(_busReservationRemoteModel, bookingDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBusReservationRemoteModel() {
		return _busReservationRemoteModel;
	}

	public void setBusReservationRemoteModel(
		BaseModel<?> busReservationRemoteModel) {
		_busReservationRemoteModel = busReservationRemoteModel;
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

		Class<?> remoteModelClass = _busReservationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_busReservationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BusReservationLocalServiceUtil.addBusReservation(this);
		}
		else {
			BusReservationLocalServiceUtil.updateBusReservation(this);
		}
	}

	@Override
	public BusReservation toEscapedModel() {
		return (BusReservation)ProxyUtil.newProxyInstance(BusReservation.class.getClassLoader(),
			new Class[] { BusReservation.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BusReservationClp clone = new BusReservationClp();

		clone.setBrId(getBrId());
		clone.setBaId(getBaId());
		clone.setUserId(getUserId());
		clone.setPaymentReceived(getPaymentReceived());
		clone.setBookingDate(getBookingDate());

		return clone;
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

		if (!(obj instanceof BusReservationClp)) {
			return false;
		}

		BusReservationClp busReservation = (BusReservationClp)obj;

		long primaryKey = busReservation.getPrimaryKey();

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

	private long _brId;
	private long _baId;
	private long _userId;
	private String _userUuid;
	private boolean _paymentReceived;
	private Date _bookingDate;
	private BaseModel<?> _busReservationRemoteModel;
	private Class<?> _clpSerializerClass = com.services.service.ClpSerializer.class;
}