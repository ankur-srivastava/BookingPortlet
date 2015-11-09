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
public class CouponSoap implements Serializable {
	public static CouponSoap toSoapModel(Coupon model) {
		CouponSoap soapModel = new CouponSoap();

		soapModel.setCouponId(model.getCouponId());
		soapModel.setCouponName(model.getCouponName());
		soapModel.setPrice(model.getPrice());
		soapModel.setValidTill(model.getValidTill());
		soapModel.setAudience(model.getAudience());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static CouponSoap[] toSoapModels(Coupon[] models) {
		CouponSoap[] soapModels = new CouponSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CouponSoap[][] toSoapModels(Coupon[][] models) {
		CouponSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CouponSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CouponSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CouponSoap[] toSoapModels(List<Coupon> models) {
		List<CouponSoap> soapModels = new ArrayList<CouponSoap>(models.size());

		for (Coupon model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CouponSoap[soapModels.size()]);
	}

	public CouponSoap() {
	}

	public long getPrimaryKey() {
		return _couponId;
	}

	public void setPrimaryKey(long pk) {
		setCouponId(pk);
	}

	public long getCouponId() {
		return _couponId;
	}

	public void setCouponId(long couponId) {
		_couponId = couponId;
	}

	public String getCouponName() {
		return _couponName;
	}

	public void setCouponName(String couponName) {
		_couponName = couponName;
	}

	public long getPrice() {
		return _price;
	}

	public void setPrice(long price) {
		_price = price;
	}

	public Date getValidTill() {
		return _validTill;
	}

	public void setValidTill(Date validTill) {
		_validTill = validTill;
	}

	public boolean getAudience() {
		return _audience;
	}

	public boolean isAudience() {
		return _audience;
	}

	public void setAudience(boolean audience) {
		_audience = audience;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	private long _couponId;
	private String _couponName;
	private long _price;
	private Date _validTill;
	private boolean _audience;
	private Date _createDate;
}