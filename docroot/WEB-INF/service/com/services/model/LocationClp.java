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

import com.services.service.ClpSerializer;
import com.services.service.LocationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ankur Srivastava
 */
public class LocationClp extends BaseModelImpl<Location> implements Location {
	public LocationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Location.class;
	}

	@Override
	public String getModelClassName() {
		return Location.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _locationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLocationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _locationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("locationId", getLocationId());
		attributes.put("locationName", getLocationName());
		attributes.put("streetAddress1", getStreetAddress1());
		attributes.put("streetAddress2", getStreetAddress2());
		attributes.put("locationZip", getLocationZip());
		attributes.put("locationCityName", getLocationCityName());
		attributes.put("locationStateName", getLocationStateName());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("comments", getComments());
		attributes.put("active", getActive());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		String locationName = (String)attributes.get("locationName");

		if (locationName != null) {
			setLocationName(locationName);
		}

		String streetAddress1 = (String)attributes.get("streetAddress1");

		if (streetAddress1 != null) {
			setStreetAddress1(streetAddress1);
		}

		String streetAddress2 = (String)attributes.get("streetAddress2");

		if (streetAddress2 != null) {
			setStreetAddress2(streetAddress2);
		}

		String locationZip = (String)attributes.get("locationZip");

		if (locationZip != null) {
			setLocationZip(locationZip);
		}

		String locationCityName = (String)attributes.get("locationCityName");

		if (locationCityName != null) {
			setLocationCityName(locationCityName);
		}

		String locationStateName = (String)attributes.get("locationStateName");

		if (locationStateName != null) {
			setLocationStateName(locationStateName);
		}

		String latitude = (String)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		String longitude = (String)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
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
	public long getLocationId() {
		return _locationId;
	}

	@Override
	public void setLocationId(long locationId) {
		_locationId = locationId;

		if (_locationRemoteModel != null) {
			try {
				Class<?> clazz = _locationRemoteModel.getClass();

				Method method = clazz.getMethod("setLocationId", long.class);

				method.invoke(_locationRemoteModel, locationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocationName() {
		return _locationName;
	}

	@Override
	public void setLocationName(String locationName) {
		_locationName = locationName;

		if (_locationRemoteModel != null) {
			try {
				Class<?> clazz = _locationRemoteModel.getClass();

				Method method = clazz.getMethod("setLocationName", String.class);

				method.invoke(_locationRemoteModel, locationName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStreetAddress1() {
		return _streetAddress1;
	}

	@Override
	public void setStreetAddress1(String streetAddress1) {
		_streetAddress1 = streetAddress1;

		if (_locationRemoteModel != null) {
			try {
				Class<?> clazz = _locationRemoteModel.getClass();

				Method method = clazz.getMethod("setStreetAddress1",
						String.class);

				method.invoke(_locationRemoteModel, streetAddress1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStreetAddress2() {
		return _streetAddress2;
	}

	@Override
	public void setStreetAddress2(String streetAddress2) {
		_streetAddress2 = streetAddress2;

		if (_locationRemoteModel != null) {
			try {
				Class<?> clazz = _locationRemoteModel.getClass();

				Method method = clazz.getMethod("setStreetAddress2",
						String.class);

				method.invoke(_locationRemoteModel, streetAddress2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocationZip() {
		return _locationZip;
	}

	@Override
	public void setLocationZip(String locationZip) {
		_locationZip = locationZip;

		if (_locationRemoteModel != null) {
			try {
				Class<?> clazz = _locationRemoteModel.getClass();

				Method method = clazz.getMethod("setLocationZip", String.class);

				method.invoke(_locationRemoteModel, locationZip);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocationCityName() {
		return _locationCityName;
	}

	@Override
	public void setLocationCityName(String locationCityName) {
		_locationCityName = locationCityName;

		if (_locationRemoteModel != null) {
			try {
				Class<?> clazz = _locationRemoteModel.getClass();

				Method method = clazz.getMethod("setLocationCityName",
						String.class);

				method.invoke(_locationRemoteModel, locationCityName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocationStateName() {
		return _locationStateName;
	}

	@Override
	public void setLocationStateName(String locationStateName) {
		_locationStateName = locationStateName;

		if (_locationRemoteModel != null) {
			try {
				Class<?> clazz = _locationRemoteModel.getClass();

				Method method = clazz.getMethod("setLocationStateName",
						String.class);

				method.invoke(_locationRemoteModel, locationStateName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLatitude() {
		return _latitude;
	}

	@Override
	public void setLatitude(String latitude) {
		_latitude = latitude;

		if (_locationRemoteModel != null) {
			try {
				Class<?> clazz = _locationRemoteModel.getClass();

				Method method = clazz.getMethod("setLatitude", String.class);

				method.invoke(_locationRemoteModel, latitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLongitude() {
		return _longitude;
	}

	@Override
	public void setLongitude(String longitude) {
		_longitude = longitude;

		if (_locationRemoteModel != null) {
			try {
				Class<?> clazz = _locationRemoteModel.getClass();

				Method method = clazz.getMethod("setLongitude", String.class);

				method.invoke(_locationRemoteModel, longitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComments() {
		return _comments;
	}

	@Override
	public void setComments(String comments) {
		_comments = comments;

		if (_locationRemoteModel != null) {
			try {
				Class<?> clazz = _locationRemoteModel.getClass();

				Method method = clazz.getMethod("setComments", String.class);

				method.invoke(_locationRemoteModel, comments);
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

		if (_locationRemoteModel != null) {
			try {
				Class<?> clazz = _locationRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_locationRemoteModel, active);
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

		if (_locationRemoteModel != null) {
			try {
				Class<?> clazz = _locationRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_locationRemoteModel, createDate);
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

		if (_locationRemoteModel != null) {
			try {
				Class<?> clazz = _locationRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_locationRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLocationRemoteModel() {
		return _locationRemoteModel;
	}

	public void setLocationRemoteModel(BaseModel<?> locationRemoteModel) {
		_locationRemoteModel = locationRemoteModel;
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

		Class<?> remoteModelClass = _locationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_locationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LocationLocalServiceUtil.addLocation(this);
		}
		else {
			LocationLocalServiceUtil.updateLocation(this);
		}
	}

	@Override
	public Location toEscapedModel() {
		return (Location)ProxyUtil.newProxyInstance(Location.class.getClassLoader(),
			new Class[] { Location.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LocationClp clone = new LocationClp();

		clone.setLocationId(getLocationId());
		clone.setLocationName(getLocationName());
		clone.setStreetAddress1(getStreetAddress1());
		clone.setStreetAddress2(getStreetAddress2());
		clone.setLocationZip(getLocationZip());
		clone.setLocationCityName(getLocationCityName());
		clone.setLocationStateName(getLocationStateName());
		clone.setLatitude(getLatitude());
		clone.setLongitude(getLongitude());
		clone.setComments(getComments());
		clone.setActive(getActive());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(Location location) {
		int value = 0;

		value = getLocationName().compareTo(location.getLocationName());

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

		if (!(obj instanceof LocationClp)) {
			return false;
		}

		LocationClp location = (LocationClp)obj;

		long primaryKey = location.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{locationId=");
		sb.append(getLocationId());
		sb.append(", locationName=");
		sb.append(getLocationName());
		sb.append(", streetAddress1=");
		sb.append(getStreetAddress1());
		sb.append(", streetAddress2=");
		sb.append(getStreetAddress2());
		sb.append(", locationZip=");
		sb.append(getLocationZip());
		sb.append(", locationCityName=");
		sb.append(getLocationCityName());
		sb.append(", locationStateName=");
		sb.append(getLocationStateName());
		sb.append(", latitude=");
		sb.append(getLatitude());
		sb.append(", longitude=");
		sb.append(getLongitude());
		sb.append(", comments=");
		sb.append(getComments());
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
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.services.model.Location");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>locationId</column-name><column-value><![CDATA[");
		sb.append(getLocationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locationName</column-name><column-value><![CDATA[");
		sb.append(getLocationName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>streetAddress1</column-name><column-value><![CDATA[");
		sb.append(getStreetAddress1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>streetAddress2</column-name><column-value><![CDATA[");
		sb.append(getStreetAddress2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locationZip</column-name><column-value><![CDATA[");
		sb.append(getLocationZip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locationCityName</column-name><column-value><![CDATA[");
		sb.append(getLocationCityName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locationStateName</column-name><column-value><![CDATA[");
		sb.append(getLocationStateName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latitude</column-name><column-value><![CDATA[");
		sb.append(getLatitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longitude</column-name><column-value><![CDATA[");
		sb.append(getLongitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
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

	private long _locationId;
	private String _locationName;
	private String _streetAddress1;
	private String _streetAddress2;
	private String _locationZip;
	private String _locationCityName;
	private String _locationStateName;
	private String _latitude;
	private String _longitude;
	private String _comments;
	private boolean _active;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _locationRemoteModel;
	private Class<?> _clpSerializerClass = com.services.service.ClpSerializer.class;
}