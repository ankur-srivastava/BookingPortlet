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

import com.services.service.BusEmployeeLocalServiceUtil;
import com.services.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ankur Srivastava
 */
public class BusEmployeeClp extends BaseModelImpl<BusEmployee>
	implements BusEmployee {
	public BusEmployeeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BusEmployee.class;
	}

	@Override
	public String getModelClassName() {
		return BusEmployee.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _beId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _beId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("beId", getBeId());
		attributes.put("beName", getBeName());
		attributes.put("agency", getAgency());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("email", getEmail());
		attributes.put("licenseNumber", getLicenseNumber());
		attributes.put("alternateIdNumber", getAlternateIdNumber());
		attributes.put("active", getActive());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long beId = (Long)attributes.get("beId");

		if (beId != null) {
			setBeId(beId);
		}

		String beName = (String)attributes.get("beName");

		if (beName != null) {
			setBeName(beName);
		}

		Long agency = (Long)attributes.get("agency");

		if (agency != null) {
			setAgency(agency);
		}

		String contactNumber = (String)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String licenseNumber = (String)attributes.get("licenseNumber");

		if (licenseNumber != null) {
			setLicenseNumber(licenseNumber);
		}

		String alternateIdNumber = (String)attributes.get("alternateIdNumber");

		if (alternateIdNumber != null) {
			setAlternateIdNumber(alternateIdNumber);
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
	public long getBeId() {
		return _beId;
	}

	@Override
	public void setBeId(long beId) {
		_beId = beId;

		if (_busEmployeeRemoteModel != null) {
			try {
				Class<?> clazz = _busEmployeeRemoteModel.getClass();

				Method method = clazz.getMethod("setBeId", long.class);

				method.invoke(_busEmployeeRemoteModel, beId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBeName() {
		return _beName;
	}

	@Override
	public void setBeName(String beName) {
		_beName = beName;

		if (_busEmployeeRemoteModel != null) {
			try {
				Class<?> clazz = _busEmployeeRemoteModel.getClass();

				Method method = clazz.getMethod("setBeName", String.class);

				method.invoke(_busEmployeeRemoteModel, beName);
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

		if (_busEmployeeRemoteModel != null) {
			try {
				Class<?> clazz = _busEmployeeRemoteModel.getClass();

				Method method = clazz.getMethod("setAgency", long.class);

				method.invoke(_busEmployeeRemoteModel, agency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactNumber() {
		return _contactNumber;
	}

	@Override
	public void setContactNumber(String contactNumber) {
		_contactNumber = contactNumber;

		if (_busEmployeeRemoteModel != null) {
			try {
				Class<?> clazz = _busEmployeeRemoteModel.getClass();

				Method method = clazz.getMethod("setContactNumber", String.class);

				method.invoke(_busEmployeeRemoteModel, contactNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_busEmployeeRemoteModel != null) {
			try {
				Class<?> clazz = _busEmployeeRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_busEmployeeRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLicenseNumber() {
		return _licenseNumber;
	}

	@Override
	public void setLicenseNumber(String licenseNumber) {
		_licenseNumber = licenseNumber;

		if (_busEmployeeRemoteModel != null) {
			try {
				Class<?> clazz = _busEmployeeRemoteModel.getClass();

				Method method = clazz.getMethod("setLicenseNumber", String.class);

				method.invoke(_busEmployeeRemoteModel, licenseNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAlternateIdNumber() {
		return _alternateIdNumber;
	}

	@Override
	public void setAlternateIdNumber(String alternateIdNumber) {
		_alternateIdNumber = alternateIdNumber;

		if (_busEmployeeRemoteModel != null) {
			try {
				Class<?> clazz = _busEmployeeRemoteModel.getClass();

				Method method = clazz.getMethod("setAlternateIdNumber",
						String.class);

				method.invoke(_busEmployeeRemoteModel, alternateIdNumber);
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

		if (_busEmployeeRemoteModel != null) {
			try {
				Class<?> clazz = _busEmployeeRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_busEmployeeRemoteModel, active);
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

		if (_busEmployeeRemoteModel != null) {
			try {
				Class<?> clazz = _busEmployeeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_busEmployeeRemoteModel, createDate);
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

		if (_busEmployeeRemoteModel != null) {
			try {
				Class<?> clazz = _busEmployeeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_busEmployeeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBusEmployeeRemoteModel() {
		return _busEmployeeRemoteModel;
	}

	public void setBusEmployeeRemoteModel(BaseModel<?> busEmployeeRemoteModel) {
		_busEmployeeRemoteModel = busEmployeeRemoteModel;
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

		Class<?> remoteModelClass = _busEmployeeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_busEmployeeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BusEmployeeLocalServiceUtil.addBusEmployee(this);
		}
		else {
			BusEmployeeLocalServiceUtil.updateBusEmployee(this);
		}
	}

	@Override
	public BusEmployee toEscapedModel() {
		return (BusEmployee)ProxyUtil.newProxyInstance(BusEmployee.class.getClassLoader(),
			new Class[] { BusEmployee.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BusEmployeeClp clone = new BusEmployeeClp();

		clone.setBeId(getBeId());
		clone.setBeName(getBeName());
		clone.setAgency(getAgency());
		clone.setContactNumber(getContactNumber());
		clone.setEmail(getEmail());
		clone.setLicenseNumber(getLicenseNumber());
		clone.setAlternateIdNumber(getAlternateIdNumber());
		clone.setActive(getActive());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(BusEmployee busEmployee) {
		int value = 0;

		value = getBeName().compareTo(busEmployee.getBeName());

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

		if (!(obj instanceof BusEmployeeClp)) {
			return false;
		}

		BusEmployeeClp busEmployee = (BusEmployeeClp)obj;

		long primaryKey = busEmployee.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{beId=");
		sb.append(getBeId());
		sb.append(", beName=");
		sb.append(getBeName());
		sb.append(", agency=");
		sb.append(getAgency());
		sb.append(", contactNumber=");
		sb.append(getContactNumber());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", licenseNumber=");
		sb.append(getLicenseNumber());
		sb.append(", alternateIdNumber=");
		sb.append(getAlternateIdNumber());
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
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.services.model.BusEmployee");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>beId</column-name><column-value><![CDATA[");
		sb.append(getBeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>beName</column-name><column-value><![CDATA[");
		sb.append(getBeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>agency</column-name><column-value><![CDATA[");
		sb.append(getAgency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactNumber</column-name><column-value><![CDATA[");
		sb.append(getContactNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>licenseNumber</column-name><column-value><![CDATA[");
		sb.append(getLicenseNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>alternateIdNumber</column-name><column-value><![CDATA[");
		sb.append(getAlternateIdNumber());
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

	private long _beId;
	private String _beName;
	private long _agency;
	private String _contactNumber;
	private String _email;
	private String _licenseNumber;
	private String _alternateIdNumber;
	private boolean _active;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _busEmployeeRemoteModel;
	private Class<?> _clpSerializerClass = com.services.service.ClpSerializer.class;
}