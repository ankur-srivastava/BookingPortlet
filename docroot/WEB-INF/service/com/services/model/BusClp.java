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

import com.services.service.BusLocalServiceUtil;
import com.services.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ankur Srivastava
 */
public class BusClp extends BaseModelImpl<Bus> implements Bus {
	public BusClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Bus.class;
	}

	@Override
	public String getModelClassName() {
		return Bus.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _busId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBusId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _busId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("busId", getBusId());
		attributes.put("busName", getBusName());
		attributes.put("agency", getAgency());
		attributes.put("driver", getDriver());
		attributes.put("conductor", getConductor());
		attributes.put("helper", getHelper());
		attributes.put("plateNumber", getPlateNumber());
		attributes.put("color", getColor());
		attributes.put("make", getMake());
		attributes.put("model", getModel());
		attributes.put("year", getYear());
		attributes.put("active", getActive());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long busId = (Long)attributes.get("busId");

		if (busId != null) {
			setBusId(busId);
		}

		String busName = (String)attributes.get("busName");

		if (busName != null) {
			setBusName(busName);
		}

		Long agency = (Long)attributes.get("agency");

		if (agency != null) {
			setAgency(agency);
		}

		Long driver = (Long)attributes.get("driver");

		if (driver != null) {
			setDriver(driver);
		}

		Long conductor = (Long)attributes.get("conductor");

		if (conductor != null) {
			setConductor(conductor);
		}

		Long helper = (Long)attributes.get("helper");

		if (helper != null) {
			setHelper(helper);
		}

		String plateNumber = (String)attributes.get("plateNumber");

		if (plateNumber != null) {
			setPlateNumber(plateNumber);
		}

		String color = (String)attributes.get("color");

		if (color != null) {
			setColor(color);
		}

		String make = (String)attributes.get("make");

		if (make != null) {
			setMake(make);
		}

		String model = (String)attributes.get("model");

		if (model != null) {
			setModel(model);
		}

		String year = (String)attributes.get("year");

		if (year != null) {
			setYear(year);
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
	public long getBusId() {
		return _busId;
	}

	@Override
	public void setBusId(long busId) {
		_busId = busId;

		if (_busRemoteModel != null) {
			try {
				Class<?> clazz = _busRemoteModel.getClass();

				Method method = clazz.getMethod("setBusId", long.class);

				method.invoke(_busRemoteModel, busId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBusName() {
		return _busName;
	}

	@Override
	public void setBusName(String busName) {
		_busName = busName;

		if (_busRemoteModel != null) {
			try {
				Class<?> clazz = _busRemoteModel.getClass();

				Method method = clazz.getMethod("setBusName", String.class);

				method.invoke(_busRemoteModel, busName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAgency() {
		return _agency;
	}

	@Override
	public void setAgency(long agency) {
		_agency = agency;

		if (_busRemoteModel != null) {
			try {
				Class<?> clazz = _busRemoteModel.getClass();

				Method method = clazz.getMethod("setAgency", long.class);

				method.invoke(_busRemoteModel, agency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDriver() {
		return _driver;
	}

	@Override
	public void setDriver(long driver) {
		_driver = driver;

		if (_busRemoteModel != null) {
			try {
				Class<?> clazz = _busRemoteModel.getClass();

				Method method = clazz.getMethod("setDriver", long.class);

				method.invoke(_busRemoteModel, driver);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getConductor() {
		return _conductor;
	}

	@Override
	public void setConductor(long conductor) {
		_conductor = conductor;

		if (_busRemoteModel != null) {
			try {
				Class<?> clazz = _busRemoteModel.getClass();

				Method method = clazz.getMethod("setConductor", long.class);

				method.invoke(_busRemoteModel, conductor);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getHelper() {
		return _helper;
	}

	@Override
	public void setHelper(long helper) {
		_helper = helper;

		if (_busRemoteModel != null) {
			try {
				Class<?> clazz = _busRemoteModel.getClass();

				Method method = clazz.getMethod("setHelper", long.class);

				method.invoke(_busRemoteModel, helper);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPlateNumber() {
		return _plateNumber;
	}

	@Override
	public void setPlateNumber(String plateNumber) {
		_plateNumber = plateNumber;

		if (_busRemoteModel != null) {
			try {
				Class<?> clazz = _busRemoteModel.getClass();

				Method method = clazz.getMethod("setPlateNumber", String.class);

				method.invoke(_busRemoteModel, plateNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColor() {
		return _color;
	}

	@Override
	public void setColor(String color) {
		_color = color;

		if (_busRemoteModel != null) {
			try {
				Class<?> clazz = _busRemoteModel.getClass();

				Method method = clazz.getMethod("setColor", String.class);

				method.invoke(_busRemoteModel, color);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMake() {
		return _make;
	}

	@Override
	public void setMake(String make) {
		_make = make;

		if (_busRemoteModel != null) {
			try {
				Class<?> clazz = _busRemoteModel.getClass();

				Method method = clazz.getMethod("setMake", String.class);

				method.invoke(_busRemoteModel, make);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModel() {
		return _model;
	}

	@Override
	public void setModel(String model) {
		_model = model;

		if (_busRemoteModel != null) {
			try {
				Class<?> clazz = _busRemoteModel.getClass();

				Method method = clazz.getMethod("setModel", String.class);

				method.invoke(_busRemoteModel, model);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYear() {
		return _year;
	}

	@Override
	public void setYear(String year) {
		_year = year;

		if (_busRemoteModel != null) {
			try {
				Class<?> clazz = _busRemoteModel.getClass();

				Method method = clazz.getMethod("setYear", String.class);

				method.invoke(_busRemoteModel, year);
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

		if (_busRemoteModel != null) {
			try {
				Class<?> clazz = _busRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_busRemoteModel, active);
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

		if (_busRemoteModel != null) {
			try {
				Class<?> clazz = _busRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_busRemoteModel, createDate);
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

		if (_busRemoteModel != null) {
			try {
				Class<?> clazz = _busRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_busRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBusRemoteModel() {
		return _busRemoteModel;
	}

	public void setBusRemoteModel(BaseModel<?> busRemoteModel) {
		_busRemoteModel = busRemoteModel;
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

		Class<?> remoteModelClass = _busRemoteModel.getClass();

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

		Object returnValue = method.invoke(_busRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BusLocalServiceUtil.addBus(this);
		}
		else {
			BusLocalServiceUtil.updateBus(this);
		}
	}

	@Override
	public Bus toEscapedModel() {
		return (Bus)ProxyUtil.newProxyInstance(Bus.class.getClassLoader(),
			new Class[] { Bus.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BusClp clone = new BusClp();

		clone.setBusId(getBusId());
		clone.setBusName(getBusName());
		clone.setAgency(getAgency());
		clone.setDriver(getDriver());
		clone.setConductor(getConductor());
		clone.setHelper(getHelper());
		clone.setPlateNumber(getPlateNumber());
		clone.setColor(getColor());
		clone.setMake(getMake());
		clone.setModel(getModel());
		clone.setYear(getYear());
		clone.setActive(getActive());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(Bus bus) {
		int value = 0;

		value = getBusName().compareTo(bus.getBusName());

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

		if (!(obj instanceof BusClp)) {
			return false;
		}

		BusClp bus = (BusClp)obj;

		long primaryKey = bus.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{busId=");
		sb.append(getBusId());
		sb.append(", busName=");
		sb.append(getBusName());
		sb.append(", agency=");
		sb.append(getAgency());
		sb.append(", driver=");
		sb.append(getDriver());
		sb.append(", conductor=");
		sb.append(getConductor());
		sb.append(", helper=");
		sb.append(getHelper());
		sb.append(", plateNumber=");
		sb.append(getPlateNumber());
		sb.append(", color=");
		sb.append(getColor());
		sb.append(", make=");
		sb.append(getMake());
		sb.append(", model=");
		sb.append(getModel());
		sb.append(", year=");
		sb.append(getYear());
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
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.services.model.Bus");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>busId</column-name><column-value><![CDATA[");
		sb.append(getBusId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>busName</column-name><column-value><![CDATA[");
		sb.append(getBusName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>agency</column-name><column-value><![CDATA[");
		sb.append(getAgency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>driver</column-name><column-value><![CDATA[");
		sb.append(getDriver());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>conductor</column-name><column-value><![CDATA[");
		sb.append(getConductor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>helper</column-name><column-value><![CDATA[");
		sb.append(getHelper());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>plateNumber</column-name><column-value><![CDATA[");
		sb.append(getPlateNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>color</column-name><column-value><![CDATA[");
		sb.append(getColor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>make</column-name><column-value><![CDATA[");
		sb.append(getMake());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>model</column-name><column-value><![CDATA[");
		sb.append(getModel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
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

	private long _busId;
	private String _busName;
	private long _agency;
	private long _driver;
	private long _conductor;
	private long _helper;
	private String _plateNumber;
	private String _color;
	private String _make;
	private String _model;
	private String _year;
	private boolean _active;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _busRemoteModel;
	private Class<?> _clpSerializerClass = com.services.service.ClpSerializer.class;
}