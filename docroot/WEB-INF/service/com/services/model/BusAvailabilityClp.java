/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

import com.services.service.BusAvailabilityLocalServiceUtil;
import com.services.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ankur Srivastava
 */
public class BusAvailabilityClp extends BaseModelImpl<BusAvailability>
	implements BusAvailability {
	public BusAvailabilityClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BusAvailability.class;
	}

	@Override
	public String getModelClassName() {
		return BusAvailability.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _baId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBaId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _baId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("baId", getBaId());
		attributes.put("brtId", getBrtId());
		attributes.put("total", getTotal());
		attributes.put("available", getAvailable());
		attributes.put("price", getPrice());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long baId = (Long)attributes.get("baId");

		if (baId != null) {
			setBaId(baId);
		}

		Long brtId = (Long)attributes.get("brtId");

		if (brtId != null) {
			setBrtId(brtId);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public long getBaId() {
		return _baId;
	}

	@Override
	public void setBaId(long baId) {
		_baId = baId;

		if (_busAvailabilityRemoteModel != null) {
			try {
				Class<?> clazz = _busAvailabilityRemoteModel.getClass();

				Method method = clazz.getMethod("setBaId", long.class);

				method.invoke(_busAvailabilityRemoteModel, baId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBrtId() {
		return _brtId;
	}

	@Override
	public void setBrtId(long brtId) {
		_brtId = brtId;

		if (_busAvailabilityRemoteModel != null) {
			try {
				Class<?> clazz = _busAvailabilityRemoteModel.getClass();

				Method method = clazz.getMethod("setBrtId", long.class);

				method.invoke(_busAvailabilityRemoteModel, brtId);
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

		if (_busAvailabilityRemoteModel != null) {
			try {
				Class<?> clazz = _busAvailabilityRemoteModel.getClass();

				Method method = clazz.getMethod("setTotal", long.class);

				method.invoke(_busAvailabilityRemoteModel, total);
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

		if (_busAvailabilityRemoteModel != null) {
			try {
				Class<?> clazz = _busAvailabilityRemoteModel.getClass();

				Method method = clazz.getMethod("setAvailable", long.class);

				method.invoke(_busAvailabilityRemoteModel, available);
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

		if (_busAvailabilityRemoteModel != null) {
			try {
				Class<?> clazz = _busAvailabilityRemoteModel.getClass();

				Method method = clazz.getMethod("setPrice", long.class);

				method.invoke(_busAvailabilityRemoteModel, price);
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

		if (_busAvailabilityRemoteModel != null) {
			try {
				Class<?> clazz = _busAvailabilityRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_busAvailabilityRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBusAvailabilityRemoteModel() {
		return _busAvailabilityRemoteModel;
	}

	public void setBusAvailabilityRemoteModel(
		BaseModel<?> busAvailabilityRemoteModel) {
		_busAvailabilityRemoteModel = busAvailabilityRemoteModel;
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

		Class<?> remoteModelClass = _busAvailabilityRemoteModel.getClass();

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

		Object returnValue = method.invoke(_busAvailabilityRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BusAvailabilityLocalServiceUtil.addBusAvailability(this);
		}
		else {
			BusAvailabilityLocalServiceUtil.updateBusAvailability(this);
		}
	}

	@Override
	public BusAvailability toEscapedModel() {
		return (BusAvailability)ProxyUtil.newProxyInstance(BusAvailability.class.getClassLoader(),
			new Class[] { BusAvailability.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BusAvailabilityClp clone = new BusAvailabilityClp();

		clone.setBaId(getBaId());
		clone.setBrtId(getBrtId());
		clone.setTotal(getTotal());
		clone.setAvailable(getAvailable());
		clone.setPrice(getPrice());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(BusAvailability busAvailability) {
		int value = 0;

		if (getAvailable() < busAvailability.getAvailable()) {
			value = -1;
		}
		else if (getAvailable() > busAvailability.getAvailable()) {
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

		if (!(obj instanceof BusAvailabilityClp)) {
			return false;
		}

		BusAvailabilityClp busAvailability = (BusAvailabilityClp)obj;

		long primaryKey = busAvailability.getPrimaryKey();

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
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{baId=");
		sb.append(getBaId());
		sb.append(", brtId=");
		sb.append(getBrtId());
		sb.append(", total=");
		sb.append(getTotal());
		sb.append(", available=");
		sb.append(getAvailable());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.services.model.BusAvailability");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>baId</column-name><column-value><![CDATA[");
		sb.append(getBaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>brtId</column-name><column-value><![CDATA[");
		sb.append(getBrtId());
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
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _baId;
	private long _brtId;
	private long _total;
	private long _available;
	private long _price;
	private Date _createDate;
	private BaseModel<?> _busAvailabilityRemoteModel;
}