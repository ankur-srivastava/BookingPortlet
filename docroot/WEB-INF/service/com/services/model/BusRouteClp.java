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

import com.services.service.BusRouteLocalServiceUtil;
import com.services.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ankur Srivastava
 */
public class BusRouteClp extends BaseModelImpl<BusRoute> implements BusRoute {
	public BusRouteClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BusRoute.class;
	}

	@Override
	public String getModelClassName() {
		return BusRoute.class.getName();
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
		attributes.put("busId", getBusId());
		attributes.put("startLocation", getStartLocation());
		attributes.put("endLocation", getEndLocation());
		attributes.put("midLocation1", getMidLocation1());
		attributes.put("midLocation2", getMidLocation2());
		attributes.put("active", getActive());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long brId = (Long)attributes.get("brId");

		if (brId != null) {
			setBrId(brId);
		}

		Long busId = (Long)attributes.get("busId");

		if (busId != null) {
			setBusId(busId);
		}

		Long startLocation = (Long)attributes.get("startLocation");

		if (startLocation != null) {
			setStartLocation(startLocation);
		}

		Long endLocation = (Long)attributes.get("endLocation");

		if (endLocation != null) {
			setEndLocation(endLocation);
		}

		Long midLocation1 = (Long)attributes.get("midLocation1");

		if (midLocation1 != null) {
			setMidLocation1(midLocation1);
		}

		Long midLocation2 = (Long)attributes.get("midLocation2");

		if (midLocation2 != null) {
			setMidLocation2(midLocation2);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public long getBrId() {
		return _brId;
	}

	@Override
	public void setBrId(long brId) {
		_brId = brId;

		if (_busRouteRemoteModel != null) {
			try {
				Class<?> clazz = _busRouteRemoteModel.getClass();

				Method method = clazz.getMethod("setBrId", long.class);

				method.invoke(_busRouteRemoteModel, brId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBusId() {
		return _busId;
	}

	@Override
	public void setBusId(long busId) {
		_busId = busId;

		if (_busRouteRemoteModel != null) {
			try {
				Class<?> clazz = _busRouteRemoteModel.getClass();

				Method method = clazz.getMethod("setBusId", long.class);

				method.invoke(_busRouteRemoteModel, busId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStartLocation() {
		return _startLocation;
	}

	@Override
	public void setStartLocation(long startLocation) {
		_startLocation = startLocation;

		if (_busRouteRemoteModel != null) {
			try {
				Class<?> clazz = _busRouteRemoteModel.getClass();

				Method method = clazz.getMethod("setStartLocation", long.class);

				method.invoke(_busRouteRemoteModel, startLocation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEndLocation() {
		return _endLocation;
	}

	@Override
	public void setEndLocation(long endLocation) {
		_endLocation = endLocation;

		if (_busRouteRemoteModel != null) {
			try {
				Class<?> clazz = _busRouteRemoteModel.getClass();

				Method method = clazz.getMethod("setEndLocation", long.class);

				method.invoke(_busRouteRemoteModel, endLocation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMidLocation1() {
		return _midLocation1;
	}

	@Override
	public void setMidLocation1(long midLocation1) {
		_midLocation1 = midLocation1;

		if (_busRouteRemoteModel != null) {
			try {
				Class<?> clazz = _busRouteRemoteModel.getClass();

				Method method = clazz.getMethod("setMidLocation1", long.class);

				method.invoke(_busRouteRemoteModel, midLocation1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMidLocation2() {
		return _midLocation2;
	}

	@Override
	public void setMidLocation2(long midLocation2) {
		_midLocation2 = midLocation2;

		if (_busRouteRemoteModel != null) {
			try {
				Class<?> clazz = _busRouteRemoteModel.getClass();

				Method method = clazz.getMethod("setMidLocation2", long.class);

				method.invoke(_busRouteRemoteModel, midLocation2);
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

		if (_busRouteRemoteModel != null) {
			try {
				Class<?> clazz = _busRouteRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_busRouteRemoteModel, active);
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

		if (_busRouteRemoteModel != null) {
			try {
				Class<?> clazz = _busRouteRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_busRouteRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_busRouteRemoteModel != null) {
			try {
				Class<?> clazz = _busRouteRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_busRouteRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBusRouteRemoteModel() {
		return _busRouteRemoteModel;
	}

	public void setBusRouteRemoteModel(BaseModel<?> busRouteRemoteModel) {
		_busRouteRemoteModel = busRouteRemoteModel;
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

		Class<?> remoteModelClass = _busRouteRemoteModel.getClass();

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

		Object returnValue = method.invoke(_busRouteRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BusRouteLocalServiceUtil.addBusRoute(this);
		}
		else {
			BusRouteLocalServiceUtil.updateBusRoute(this);
		}
	}

	@Override
	public BusRoute toEscapedModel() {
		return (BusRoute)ProxyUtil.newProxyInstance(BusRoute.class.getClassLoader(),
			new Class[] { BusRoute.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BusRouteClp clone = new BusRouteClp();

		clone.setBrId(getBrId());
		clone.setBusId(getBusId());
		clone.setStartLocation(getStartLocation());
		clone.setEndLocation(getEndLocation());
		clone.setMidLocation1(getMidLocation1());
		clone.setMidLocation2(getMidLocation2());
		clone.setActive(getActive());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(BusRoute busRoute) {
		int value = 0;

		if (getBusId() < busRoute.getBusId()) {
			value = -1;
		}
		else if (getBusId() > busRoute.getBusId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof BusRouteClp)) {
			return false;
		}

		BusRouteClp busRoute = (BusRouteClp)obj;

		long primaryKey = busRoute.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{brId=");
		sb.append(getBrId());
		sb.append(", busId=");
		sb.append(getBusId());
		sb.append(", startLocation=");
		sb.append(getStartLocation());
		sb.append(", endLocation=");
		sb.append(getEndLocation());
		sb.append(", midLocation1=");
		sb.append(getMidLocation1());
		sb.append(", midLocation2=");
		sb.append(getMidLocation2());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.services.model.BusRoute");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>brId</column-name><column-value><![CDATA[");
		sb.append(getBrId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>busId</column-name><column-value><![CDATA[");
		sb.append(getBusId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startLocation</column-name><column-value><![CDATA[");
		sb.append(getStartLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endLocation</column-name><column-value><![CDATA[");
		sb.append(getEndLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>midLocation1</column-name><column-value><![CDATA[");
		sb.append(getMidLocation1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>midLocation2</column-name><column-value><![CDATA[");
		sb.append(getMidLocation2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _brId;
	private long _busId;
	private long _startLocation;
	private long _endLocation;
	private long _midLocation1;
	private long _midLocation2;
	private boolean _active;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _busRouteRemoteModel;
	private Class<?> _clpSerializerClass = com.services.service.ClpSerializer.class;
}