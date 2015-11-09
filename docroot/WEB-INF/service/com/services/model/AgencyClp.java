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

import com.services.service.AgencyLocalServiceUtil;
import com.services.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ankur Srivastava
 */
public class AgencyClp extends BaseModelImpl<Agency> implements Agency {
	public AgencyClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Agency.class;
	}

	@Override
	public String getModelClassName() {
		return Agency.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _agencyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAgencyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _agencyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("agencyId", getAgencyId());
		attributes.put("agencyName", getAgencyName());
		attributes.put("owner", getOwner());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("email", getEmail());
		attributes.put("active", getActive());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long agencyId = (Long)attributes.get("agencyId");

		if (agencyId != null) {
			setAgencyId(agencyId);
		}

		String agencyName = (String)attributes.get("agencyName");

		if (agencyName != null) {
			setAgencyName(agencyName);
		}

		String owner = (String)attributes.get("owner");

		if (owner != null) {
			setOwner(owner);
		}

		String contactNumber = (String)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
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
	public long getAgencyId() {
		return _agencyId;
	}

	@Override
	public void setAgencyId(long agencyId) {
		_agencyId = agencyId;

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setAgencyId", long.class);

				method.invoke(_agencyRemoteModel, agencyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAgencyName() {
		return _agencyName;
	}

	@Override
	public void setAgencyName(String agencyName) {
		_agencyName = agencyName;

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setAgencyName", String.class);

				method.invoke(_agencyRemoteModel, agencyName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOwner() {
		return _owner;
	}

	@Override
	public void setOwner(String owner) {
		_owner = owner;

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setOwner", String.class);

				method.invoke(_agencyRemoteModel, owner);
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

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setContactNumber", String.class);

				method.invoke(_agencyRemoteModel, contactNumber);
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

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_agencyRemoteModel, email);
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

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_agencyRemoteModel, active);
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

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_agencyRemoteModel, createDate);
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

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_agencyRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAgencyRemoteModel() {
		return _agencyRemoteModel;
	}

	public void setAgencyRemoteModel(BaseModel<?> agencyRemoteModel) {
		_agencyRemoteModel = agencyRemoteModel;
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

		Class<?> remoteModelClass = _agencyRemoteModel.getClass();

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

		Object returnValue = method.invoke(_agencyRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AgencyLocalServiceUtil.addAgency(this);
		}
		else {
			AgencyLocalServiceUtil.updateAgency(this);
		}
	}

	@Override
	public Agency toEscapedModel() {
		return (Agency)ProxyUtil.newProxyInstance(Agency.class.getClassLoader(),
			new Class[] { Agency.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AgencyClp clone = new AgencyClp();

		clone.setAgencyId(getAgencyId());
		clone.setAgencyName(getAgencyName());
		clone.setOwner(getOwner());
		clone.setContactNumber(getContactNumber());
		clone.setEmail(getEmail());
		clone.setActive(getActive());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(Agency agency) {
		int value = 0;

		value = getAgencyName().compareTo(agency.getAgencyName());

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

		if (!(obj instanceof AgencyClp)) {
			return false;
		}

		AgencyClp agency = (AgencyClp)obj;

		long primaryKey = agency.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{agencyId=");
		sb.append(getAgencyId());
		sb.append(", agencyName=");
		sb.append(getAgencyName());
		sb.append(", owner=");
		sb.append(getOwner());
		sb.append(", contactNumber=");
		sb.append(getContactNumber());
		sb.append(", email=");
		sb.append(getEmail());
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
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.services.model.Agency");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>agencyId</column-name><column-value><![CDATA[");
		sb.append(getAgencyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>agencyName</column-name><column-value><![CDATA[");
		sb.append(getAgencyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>owner</column-name><column-value><![CDATA[");
		sb.append(getOwner());
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

	private long _agencyId;
	private String _agencyName;
	private String _owner;
	private String _contactNumber;
	private String _email;
	private boolean _active;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _agencyRemoteModel;
	private Class<?> _clpSerializerClass = com.services.service.ClpSerializer.class;
}