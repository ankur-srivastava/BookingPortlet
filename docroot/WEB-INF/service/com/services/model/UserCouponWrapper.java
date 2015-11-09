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
 * This class is a wrapper for {@link UserCoupon}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see UserCoupon
 * @generated
 */
public class UserCouponWrapper implements UserCoupon, ModelWrapper<UserCoupon> {
	public UserCouponWrapper(UserCoupon userCoupon) {
		_userCoupon = userCoupon;
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

	/**
	* Returns the primary key of this user coupon.
	*
	* @return the primary key of this user coupon
	*/
	@Override
	public long getPrimaryKey() {
		return _userCoupon.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user coupon.
	*
	* @param primaryKey the primary key of this user coupon
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userCoupon.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uc ID of this user coupon.
	*
	* @return the uc ID of this user coupon
	*/
	@Override
	public long getUcId() {
		return _userCoupon.getUcId();
	}

	/**
	* Sets the uc ID of this user coupon.
	*
	* @param ucId the uc ID of this user coupon
	*/
	@Override
	public void setUcId(long ucId) {
		_userCoupon.setUcId(ucId);
	}

	/**
	* Returns the user ID of this user coupon.
	*
	* @return the user ID of this user coupon
	*/
	@Override
	public long getUserId() {
		return _userCoupon.getUserId();
	}

	/**
	* Sets the user ID of this user coupon.
	*
	* @param userId the user ID of this user coupon
	*/
	@Override
	public void setUserId(long userId) {
		_userCoupon.setUserId(userId);
	}

	/**
	* Returns the user uuid of this user coupon.
	*
	* @return the user uuid of this user coupon
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userCoupon.getUserUuid();
	}

	/**
	* Sets the user uuid of this user coupon.
	*
	* @param userUuid the user uuid of this user coupon
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userCoupon.setUserUuid(userUuid);
	}

	/**
	* Returns the coupon ID of this user coupon.
	*
	* @return the coupon ID of this user coupon
	*/
	@Override
	public long getCouponId() {
		return _userCoupon.getCouponId();
	}

	/**
	* Sets the coupon ID of this user coupon.
	*
	* @param couponId the coupon ID of this user coupon
	*/
	@Override
	public void setCouponId(long couponId) {
		_userCoupon.setCouponId(couponId);
	}

	/**
	* Returns the claimed of this user coupon.
	*
	* @return the claimed of this user coupon
	*/
	@Override
	public boolean getClaimed() {
		return _userCoupon.getClaimed();
	}

	/**
	* Returns <code>true</code> if this user coupon is claimed.
	*
	* @return <code>true</code> if this user coupon is claimed; <code>false</code> otherwise
	*/
	@Override
	public boolean isClaimed() {
		return _userCoupon.isClaimed();
	}

	/**
	* Sets whether this user coupon is claimed.
	*
	* @param claimed the claimed of this user coupon
	*/
	@Override
	public void setClaimed(boolean claimed) {
		_userCoupon.setClaimed(claimed);
	}

	/**
	* Returns the create date of this user coupon.
	*
	* @return the create date of this user coupon
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _userCoupon.getCreateDate();
	}

	/**
	* Sets the create date of this user coupon.
	*
	* @param createDate the create date of this user coupon
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_userCoupon.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _userCoupon.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_userCoupon.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _userCoupon.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userCoupon.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _userCoupon.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _userCoupon.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userCoupon.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userCoupon.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_userCoupon.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_userCoupon.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userCoupon.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserCouponWrapper((UserCoupon)_userCoupon.clone());
	}

	@Override
	public int compareTo(com.services.model.UserCoupon userCoupon) {
		return _userCoupon.compareTo(userCoupon);
	}

	@Override
	public int hashCode() {
		return _userCoupon.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.services.model.UserCoupon> toCacheModel() {
		return _userCoupon.toCacheModel();
	}

	@Override
	public com.services.model.UserCoupon toEscapedModel() {
		return new UserCouponWrapper(_userCoupon.toEscapedModel());
	}

	@Override
	public com.services.model.UserCoupon toUnescapedModel() {
		return new UserCouponWrapper(_userCoupon.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userCoupon.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userCoupon.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userCoupon.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserCouponWrapper)) {
			return false;
		}

		UserCouponWrapper userCouponWrapper = (UserCouponWrapper)obj;

		if (Validator.equals(_userCoupon, userCouponWrapper._userCoupon)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UserCoupon getWrappedUserCoupon() {
		return _userCoupon;
	}

	@Override
	public UserCoupon getWrappedModel() {
		return _userCoupon;
	}

	@Override
	public void resetOriginalValues() {
		_userCoupon.resetOriginalValues();
	}

	private UserCoupon _userCoupon;
}