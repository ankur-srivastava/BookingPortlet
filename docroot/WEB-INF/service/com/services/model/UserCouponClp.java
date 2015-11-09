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

import com.services.service.ClpSerializer;
import com.services.service.UserCouponLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ankur Srivastava
 */
public class UserCouponClp extends BaseModelImpl<UserCoupon>
	implements UserCoupon {
	public UserCouponClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UserCoupon.class;
	}

	@Override
	public String getModelClassName() {
		return UserCoupon.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _ucId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUcId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ucId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ucId", getUcId());
		attributes.put("userId", getUserId());
		attributes.put("couponId", getCouponId());
		attributes.put("claimed", getClaimed());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ucId = (Long)attributes.get("ucId");

		if (ucId != null) {
			setUcId(ucId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long couponId = (Long)attributes.get("couponId");

		if (couponId != null) {
			setCouponId(couponId);
		}

		Boolean claimed = (Boolean)attributes.get("claimed");

		if (claimed != null) {
			setClaimed(claimed);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public long getUcId() {
		return _ucId;
	}

	@Override
	public void setUcId(long ucId) {
		_ucId = ucId;

		if (_userCouponRemoteModel != null) {
			try {
				Class<?> clazz = _userCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setUcId", long.class);

				method.invoke(_userCouponRemoteModel, ucId);
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

		if (_userCouponRemoteModel != null) {
			try {
				Class<?> clazz = _userCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_userCouponRemoteModel, userId);
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
	public long getCouponId() {
		return _couponId;
	}

	@Override
	public void setCouponId(long couponId) {
		_couponId = couponId;

		if (_userCouponRemoteModel != null) {
			try {
				Class<?> clazz = _userCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setCouponId", long.class);

				method.invoke(_userCouponRemoteModel, couponId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getClaimed() {
		return _claimed;
	}

	@Override
	public boolean isClaimed() {
		return _claimed;
	}

	@Override
	public void setClaimed(boolean claimed) {
		_claimed = claimed;

		if (_userCouponRemoteModel != null) {
			try {
				Class<?> clazz = _userCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setClaimed", boolean.class);

				method.invoke(_userCouponRemoteModel, claimed);
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

		if (_userCouponRemoteModel != null) {
			try {
				Class<?> clazz = _userCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_userCouponRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUserCouponRemoteModel() {
		return _userCouponRemoteModel;
	}

	public void setUserCouponRemoteModel(BaseModel<?> userCouponRemoteModel) {
		_userCouponRemoteModel = userCouponRemoteModel;
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

		Class<?> remoteModelClass = _userCouponRemoteModel.getClass();

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

		Object returnValue = method.invoke(_userCouponRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UserCouponLocalServiceUtil.addUserCoupon(this);
		}
		else {
			UserCouponLocalServiceUtil.updateUserCoupon(this);
		}
	}

	@Override
	public UserCoupon toEscapedModel() {
		return (UserCoupon)ProxyUtil.newProxyInstance(UserCoupon.class.getClassLoader(),
			new Class[] { UserCoupon.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserCouponClp clone = new UserCouponClp();

		clone.setUcId(getUcId());
		clone.setUserId(getUserId());
		clone.setCouponId(getCouponId());
		clone.setClaimed(getClaimed());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(UserCoupon userCoupon) {
		long primaryKey = userCoupon.getPrimaryKey();

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

		if (!(obj instanceof UserCouponClp)) {
			return false;
		}

		UserCouponClp userCoupon = (UserCouponClp)obj;

		long primaryKey = userCoupon.getPrimaryKey();

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

		sb.append("{ucId=");
		sb.append(getUcId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", couponId=");
		sb.append(getCouponId());
		sb.append(", claimed=");
		sb.append(getClaimed());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.services.model.UserCoupon");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ucId</column-name><column-value><![CDATA[");
		sb.append(getUcId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>couponId</column-name><column-value><![CDATA[");
		sb.append(getCouponId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>claimed</column-name><column-value><![CDATA[");
		sb.append(getClaimed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ucId;
	private long _userId;
	private String _userUuid;
	private long _couponId;
	private boolean _claimed;
	private Date _createDate;
	private BaseModel<?> _userCouponRemoteModel;
	private Class<?> _clpSerializerClass = com.services.service.ClpSerializer.class;
}