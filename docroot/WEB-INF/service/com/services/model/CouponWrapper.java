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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Coupon}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see Coupon
 * @generated
 */
public class CouponWrapper implements Coupon, ModelWrapper<Coupon> {
	public CouponWrapper(Coupon coupon) {
		_coupon = coupon;
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

	/**
	* Returns the primary key of this coupon.
	*
	* @return the primary key of this coupon
	*/
	@Override
	public long getPrimaryKey() {
		return _coupon.getPrimaryKey();
	}

	/**
	* Sets the primary key of this coupon.
	*
	* @param primaryKey the primary key of this coupon
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_coupon.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the coupon ID of this coupon.
	*
	* @return the coupon ID of this coupon
	*/
	@Override
	public long getCouponId() {
		return _coupon.getCouponId();
	}

	/**
	* Sets the coupon ID of this coupon.
	*
	* @param couponId the coupon ID of this coupon
	*/
	@Override
	public void setCouponId(long couponId) {
		_coupon.setCouponId(couponId);
	}

	/**
	* Returns the coupon name of this coupon.
	*
	* @return the coupon name of this coupon
	*/
	@Override
	public java.lang.String getCouponName() {
		return _coupon.getCouponName();
	}

	/**
	* Sets the coupon name of this coupon.
	*
	* @param couponName the coupon name of this coupon
	*/
	@Override
	public void setCouponName(java.lang.String couponName) {
		_coupon.setCouponName(couponName);
	}

	/**
	* Returns the price of this coupon.
	*
	* @return the price of this coupon
	*/
	@Override
	public long getPrice() {
		return _coupon.getPrice();
	}

	/**
	* Sets the price of this coupon.
	*
	* @param price the price of this coupon
	*/
	@Override
	public void setPrice(long price) {
		_coupon.setPrice(price);
	}

	/**
	* Returns the valid till of this coupon.
	*
	* @return the valid till of this coupon
	*/
	@Override
	public java.util.Date getValidTill() {
		return _coupon.getValidTill();
	}

	/**
	* Sets the valid till of this coupon.
	*
	* @param validTill the valid till of this coupon
	*/
	@Override
	public void setValidTill(java.util.Date validTill) {
		_coupon.setValidTill(validTill);
	}

	/**
	* Returns the audience of this coupon.
	*
	* @return the audience of this coupon
	*/
	@Override
	public boolean getAudience() {
		return _coupon.getAudience();
	}

	/**
	* Returns <code>true</code> if this coupon is audience.
	*
	* @return <code>true</code> if this coupon is audience; <code>false</code> otherwise
	*/
	@Override
	public boolean isAudience() {
		return _coupon.isAudience();
	}

	/**
	* Sets whether this coupon is audience.
	*
	* @param audience the audience of this coupon
	*/
	@Override
	public void setAudience(boolean audience) {
		_coupon.setAudience(audience);
	}

	/**
	* Returns the create date of this coupon.
	*
	* @return the create date of this coupon
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _coupon.getCreateDate();
	}

	/**
	* Sets the create date of this coupon.
	*
	* @param createDate the create date of this coupon
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_coupon.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _coupon.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_coupon.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _coupon.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_coupon.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _coupon.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _coupon.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_coupon.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _coupon.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_coupon.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_coupon.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_coupon.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CouponWrapper((Coupon)_coupon.clone());
	}

	@Override
	public int compareTo(com.services.model.Coupon coupon) {
		return _coupon.compareTo(coupon);
	}

	@Override
	public int hashCode() {
		return _coupon.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.services.model.Coupon> toCacheModel() {
		return _coupon.toCacheModel();
	}

	@Override
	public com.services.model.Coupon toEscapedModel() {
		return new CouponWrapper(_coupon.toEscapedModel());
	}

	@Override
	public com.services.model.Coupon toUnescapedModel() {
		return new CouponWrapper(_coupon.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _coupon.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _coupon.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_coupon.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CouponWrapper)) {
			return false;
		}

		CouponWrapper couponWrapper = (CouponWrapper)obj;

		if (Validator.equals(_coupon, couponWrapper._coupon)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Coupon getWrappedCoupon() {
		return _coupon;
	}

	@Override
	public Coupon getWrappedModel() {
		return _coupon;
	}

	@Override
	public void resetOriginalValues() {
		_coupon.resetOriginalValues();
	}

	private Coupon _coupon;
}