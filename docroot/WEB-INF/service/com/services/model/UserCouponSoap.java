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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ankur Srivastava
 * @generated
 */
public class UserCouponSoap implements Serializable {
	public static UserCouponSoap toSoapModel(UserCoupon model) {
		UserCouponSoap soapModel = new UserCouponSoap();

		soapModel.setUcId(model.getUcId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCouponId(model.getCouponId());
		soapModel.setClaimed(model.getClaimed());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static UserCouponSoap[] toSoapModels(UserCoupon[] models) {
		UserCouponSoap[] soapModels = new UserCouponSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserCouponSoap[][] toSoapModels(UserCoupon[][] models) {
		UserCouponSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserCouponSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserCouponSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserCouponSoap[] toSoapModels(List<UserCoupon> models) {
		List<UserCouponSoap> soapModels = new ArrayList<UserCouponSoap>(models.size());

		for (UserCoupon model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserCouponSoap[soapModels.size()]);
	}

	public UserCouponSoap() {
	}

	public long getPrimaryKey() {
		return _ucId;
	}

	public void setPrimaryKey(long pk) {
		setUcId(pk);
	}

	public long getUcId() {
		return _ucId;
	}

	public void setUcId(long ucId) {
		_ucId = ucId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getCouponId() {
		return _couponId;
	}

	public void setCouponId(long couponId) {
		_couponId = couponId;
	}

	public boolean getClaimed() {
		return _claimed;
	}

	public boolean isClaimed() {
		return _claimed;
	}

	public void setClaimed(boolean claimed) {
		_claimed = claimed;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	private long _ucId;
	private long _userId;
	private long _couponId;
	private boolean _claimed;
	private Date _createDate;
}