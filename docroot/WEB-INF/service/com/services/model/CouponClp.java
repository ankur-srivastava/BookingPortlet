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
import com.services.service.CouponLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ankur Srivastava
 */
public class CouponClp extends BaseModelImpl<Coupon> implements Coupon {
	public CouponClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Coupon.class;
	}

	@Override
	public String getModelClassName() {
		return Coupon.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _couponId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCouponId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _couponId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("couponId", getCouponId());
		attributes.put("couponName", getCouponName());
		attributes.put("price", getPrice());
		attributes.put("validTill", getValidTill());
		attributes.put("audience", getAudience());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long couponId = (Long)attributes.get("couponId");

		if (couponId != null) {
			setCouponId(couponId);
		}

		String couponName = (String)attributes.get("couponName");

		if (couponName != null) {
			setCouponName(couponName);
		}

		Long price = (Long)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Date validTill = (Date)attributes.get("validTill");

		if (validTill != null) {
			setValidTill(validTill);
		}

		Boolean audience = (Boolean)attributes.get("audience");

		if (audience != null) {
			setAudience(audience);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public long getCouponId() {
		return _couponId;
	}

	@Override
	public void setCouponId(long couponId) {
		_couponId = couponId;

		if (_couponRemoteModel != null) {
			try {
				Class<?> clazz = _couponRemoteModel.getClass();

				Method method = clazz.getMethod("setCouponId", long.class);

				method.invoke(_couponRemoteModel, couponId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCouponName() {
		return _couponName;
	}

	@Override
	public void setCouponName(String couponName) {
		_couponName = couponName;

		if (_couponRemoteModel != null) {
			try {
				Class<?> clazz = _couponRemoteModel.getClass();

				Method method = clazz.getMethod("setCouponName", String.class);

				method.invoke(_couponRemoteModel, couponName);
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

		if (_couponRemoteModel != null) {
			try {
				Class<?> clazz = _couponRemoteModel.getClass();

				Method method = clazz.getMethod("setPrice", long.class);

				method.invoke(_couponRemoteModel, price);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getValidTill() {
		return _validTill;
	}

	@Override
	public void setValidTill(Date validTill) {
		_validTill = validTill;

		if (_couponRemoteModel != null) {
			try {
				Class<?> clazz = _couponRemoteModel.getClass();

				Method method = clazz.getMethod("setValidTill", Date.class);

				method.invoke(_couponRemoteModel, validTill);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAudience() {
		return _audience;
	}

	@Override
	public boolean isAudience() {
		return _audience;
	}

	@Override
	public void setAudience(boolean audience) {
		_audience = audience;

		if (_couponRemoteModel != null) {
			try {
				Class<?> clazz = _couponRemoteModel.getClass();

				Method method = clazz.getMethod("setAudience", boolean.class);

				method.invoke(_couponRemoteModel, audience);
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

		if (_couponRemoteModel != null) {
			try {
				Class<?> clazz = _couponRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_couponRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCouponRemoteModel() {
		return _couponRemoteModel;
	}

	public void setCouponRemoteModel(BaseModel<?> couponRemoteModel) {
		_couponRemoteModel = couponRemoteModel;
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

		Class<?> remoteModelClass = _couponRemoteModel.getClass();

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

		Object returnValue = method.invoke(_couponRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CouponLocalServiceUtil.addCoupon(this);
		}
		else {
			CouponLocalServiceUtil.updateCoupon(this);
		}
	}

	@Override
	public Coupon toEscapedModel() {
		return (Coupon)ProxyUtil.newProxyInstance(Coupon.class.getClassLoader(),
			new Class[] { Coupon.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CouponClp clone = new CouponClp();

		clone.setCouponId(getCouponId());
		clone.setCouponName(getCouponName());
		clone.setPrice(getPrice());
		clone.setValidTill(getValidTill());
		clone.setAudience(getAudience());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(Coupon coupon) {
		long primaryKey = coupon.getPrimaryKey();

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

		if (!(obj instanceof CouponClp)) {
			return false;
		}

		CouponClp coupon = (CouponClp)obj;

		long primaryKey = coupon.getPrimaryKey();

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

		sb.append("{couponId=");
		sb.append(getCouponId());
		sb.append(", couponName=");
		sb.append(getCouponName());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", validTill=");
		sb.append(getValidTill());
		sb.append(", audience=");
		sb.append(getAudience());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.services.model.Coupon");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>couponId</column-name><column-value><![CDATA[");
		sb.append(getCouponId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>couponName</column-name><column-value><![CDATA[");
		sb.append(getCouponName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>validTill</column-name><column-value><![CDATA[");
		sb.append(getValidTill());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>audience</column-name><column-value><![CDATA[");
		sb.append(getAudience());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _couponId;
	private String _couponName;
	private long _price;
	private Date _validTill;
	private boolean _audience;
	private Date _createDate;
	private BaseModel<?> _couponRemoteModel;
	private Class<?> _clpSerializerClass = com.services.service.ClpSerializer.class;
}