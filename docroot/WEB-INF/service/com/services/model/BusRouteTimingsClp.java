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

import com.services.service.BusRouteTimingsLocalServiceUtil;
import com.services.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ankur Srivastava
 */
public class BusRouteTimingsClp extends BaseModelImpl<BusRouteTimings>
	implements BusRouteTimings {
	public BusRouteTimingsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BusRouteTimings.class;
	}

	@Override
	public String getModelClassName() {
		return BusRouteTimings.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _brtId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBrtId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _brtId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("brtId", getBrtId());
		attributes.put("brId", getBrId());
		attributes.put("busDetails", getBusDetails());
		attributes.put("travelDate", getTravelDate());
		attributes.put("travelTime", getTravelTime());
		attributes.put("total", getTotal());
		attributes.put("available", getAvailable());
		attributes.put("price", getPrice());
		attributes.put("active", getActive());
		attributes.put("completed", getCompleted());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long brtId = (Long)attributes.get("brtId");

		if (brtId != null) {
			setBrtId(brtId);
		}

		Long brId = (Long)attributes.get("brId");

		if (brId != null) {
			setBrId(brId);
		}

		String busDetails = (String)attributes.get("busDetails");

		if (busDetails != null) {
			setBusDetails(busDetails);
		}

		String travelDate = (String)attributes.get("travelDate");

		if (travelDate != null) {
			setTravelDate(travelDate);
		}

		String travelTime = (String)attributes.get("travelTime");

		if (travelTime != null) {
			setTravelTime(travelTime);
		}

		Long total = (Long)attributes.get("total");

		if (total != null) {
			setTotal(total);
		}

		Long available = (Long)attributes.get("available");

		if (available != null) {
			setAvailable(available);
		}

		Long price = (Long)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		String completed = (String)attributes.get("completed");

		if (completed != null) {
			setCompleted(completed);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public long getBrtId() {
		return _brtId;
	}

	@Override
	public void setBrtId(long brtId) {
		_brtId = brtId;

		if (_busRouteTimingsRemoteModel != null) {
			try {
				Class<?> clazz = _busRouteTimingsRemoteModel.getClass();

				Method method = clazz.getMethod("setBrtId", long.class);

				method.invoke(_busRouteTimingsRemoteModel, brtId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBrId() {
		return _brId;
	}

	@Override
	public void setBrId(long brId) {
		_brId = brId;

		if (_busRouteTimingsRemoteModel != null) {
			try {
				Class<?> clazz = _busRouteTimingsRemoteModel.getClass();

				Method method = clazz.getMethod("setBrId", long.class);

				method.invoke(_busRouteTimingsRemoteModel, brId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBusDetails() {
		return _busDetails;
	}

	@Override
	public void setBusDetails(String busDetails) {
		_busDetails = busDetails;

		if (_busRouteTimingsRemoteModel != null) {
			try {
				Class<?> clazz = _busRouteTimingsRemoteModel.getClass();

				Method method = clazz.getMethod("setBusDetails", String.class);

				method.invoke(_busRouteTimingsRemoteModel, busDetails);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTravelDate() {
		return _travelDate;
	}

	@Override
	public void setTravelDate(String travelDate) {
		_travelDate = travelDate;

		if (_busRouteTimingsRemoteModel != null) {
			try {
				Class<?> clazz = _busRouteTimingsRemoteModel.getClass();

				Method method = clazz.getMethod("setTravelDate", String.class);

				method.invoke(_busRouteTimingsRemoteModel, travelDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTravelTime() {
		return _travelTime;
	}

	@Override
	public void setTravelTime(String travelTime) {
		_travelTime = travelTime;

		if (_busRouteTimingsRemoteModel != null) {
			try {
				Class<?> clazz = _busRouteTimingsRemoteModel.getClass();

				Method method = clazz.getMethod("setTravelTime", String.class);

				method.invoke(_busRouteTimingsRemoteModel, travelTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTotal() {
		return _total;
	}

	@Override
	public void setTotal(long total) {
		_total = total;

		if (_busRouteTimingsRemoteModel != null) {
			try {
				Class<?> clazz = _busRouteTimingsRemoteModel.getClass();

				Method method = clazz.getMethod("setTotal", long.class);

				method.invoke(_busRouteTimingsRemoteModel, total);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAvailable() {
		return _available;
	}

	@Override
	public void setAvailable(long available) {
		_available = available;

		if (_busRouteTimingsRemoteModel != null) {
			try {
				Class<?> clazz = _busRouteTimingsRemoteModel.getClass();

				Method method = clazz.getMethod("setAvailable", long.class);

				method.invoke(_busRouteTimingsRemoteModel, available);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPrice() {
		return _price;
	}

	@Override
	public void setPrice(long price) {
		_price = price;

		if (_busRouteTimingsRemoteModel != null) {
			try {
				Class<?> clazz = _busRouteTimingsRemoteModel.getClass();

				Method method = clazz.getMethod("setPrice", long.class);

				method.invoke(_busRouteTimingsRemoteModel, price);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;

		if (_busRouteTimingsRemoteModel != null) {
			try {
				Class<?> clazz = _busRouteTimingsRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_busRouteTimingsRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompleted() {
		return _completed;
	}

	@Override
	public void setCompleted(String completed) {
		_completed = completed;

		if (_busRouteTimingsRemoteModel != null) {
			try {
				Class<?> clazz = _busRouteTimingsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompleted", String.class);

				method.invoke(_busRouteTimingsRemoteModel, completed);
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

		if (_busRouteTimingsRemoteModel != null) {
			try {
				Class<?> clazz = _busRouteTimingsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_busRouteTimingsRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBusRouteTimingsRemoteModel() {
		return _busRouteTimingsRemoteModel;
	}

	public void setBusRouteTimingsRemoteModel(
		BaseModel<?> busRouteTimingsRemoteModel) {
		_busRouteTimingsRemoteModel = busRouteTimingsRemoteModel;
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

		Class<?> remoteModelClass = _busRouteTimingsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_busRouteTimingsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BusRouteTimingsLocalServiceUtil.addBusRouteTimings(this);
		}
		else {
			BusRouteTimingsLocalServiceUtil.updateBusRouteTimings(this);
		}
	}

	@Override
	public BusRouteTimings toEscapedModel() {
		return (BusRouteTimings)ProxyUtil.newProxyInstance(BusRouteTimings.class.getClassLoader(),
			new Class[] { BusRouteTimings.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BusRouteTimingsClp clone = new BusRouteTimingsClp();

		clone.setBrtId(getBrtId());
		clone.setBrId(getBrId());
		clone.setBusDetails(getBusDetails());
		clone.setTravelDate(getTravelDate());
		clone.setTravelTime(getTravelTime());
		clone.setTotal(getTotal());
		clone.setAvailable(getAvailable());
		clone.setPrice(getPrice());
		clone.setActive(getActive());
		clone.setCompleted(getCompleted());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(BusRouteTimings busRouteTimings) {
		int value = 0;

		value = getTravelDate().compareTo(busRouteTimings.getTravelDate());

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

		if (!(obj instanceof BusRouteTimingsClp)) {
			return false;
		}

		BusRouteTimingsClp busRouteTimings = (BusRouteTimingsClp)obj;

		long primaryKey = busRouteTimings.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{brtId=");
		sb.append(getBrtId());
		sb.append(", brId=");
		sb.append(getBrId());
		sb.append(", busDetails=");
		sb.append(getBusDetails());
		sb.append(", travelDate=");
		sb.append(getTravelDate());
		sb.append(", travelTime=");
		sb.append(getTravelTime());
		sb.append(", total=");
		sb.append(getTotal());
		sb.append(", available=");
		sb.append(getAvailable());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", completed=");
		sb.append(getCompleted());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.services.model.BusRouteTimings");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>brtId</column-name><column-value><![CDATA[");
		sb.append(getBrtId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>brId</column-name><column-value><![CDATA[");
		sb.append(getBrId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>busDetails</column-name><column-value><![CDATA[");
		sb.append(getBusDetails());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>travelDate</column-name><column-value><![CDATA[");
		sb.append(getTravelDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>travelTime</column-name><column-value><![CDATA[");
		sb.append(getTravelTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>total</column-name><column-value><![CDATA[");
		sb.append(getTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>available</column-name><column-value><![CDATA[");
		sb.append(getAvailable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>completed</column-name><column-value><![CDATA[");
		sb.append(getCompleted());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _brtId;
	private long _brId;
	private String _busDetails;
	private String _travelDate;
	private String _travelTime;
	private long _total;
	private long _available;
	private long _price;
	private boolean _active;
	private String _completed;
	private Date _createDate;
	private BaseModel<?> _busRouteTimingsRemoteModel;
	private Class<?> _clpSerializerClass = com.services.service.ClpSerializer.class;
}