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
 * This class is a wrapper for {@link BookingStatus}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see BookingStatus
 * @generated
 */
public class BookingStatusWrapper implements BookingStatus,
	ModelWrapper<BookingStatus> {
	public BookingStatusWrapper(BookingStatus bookingStatus) {
		_bookingStatus = bookingStatus;
	}

	@Override
	public Class<?> getModelClass() {
		return BookingStatus.class;
	}

	@Override
	public String getModelClassName() {
		return BookingStatus.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bsId", getBsId());
		attributes.put("userId", getUserId());
		attributes.put("brtId", getBrtId());
		attributes.put("status", getStatus());
		attributes.put("tripStatus", getTripStatus());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bsId = (Long)attributes.get("bsId");

		if (bsId != null) {
			setBsId(bsId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long brtId = (Long)attributes.get("brtId");

		if (brtId != null) {
			setBrtId(brtId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String tripStatus = (String)attributes.get("tripStatus");

		if (tripStatus != null) {
			setTripStatus(tripStatus);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	/**
	* Returns the primary key of this booking status.
	*
	* @return the primary key of this booking status
	*/
	@Override
	public long getPrimaryKey() {
		return _bookingStatus.getPrimaryKey();
	}

	/**
	* Sets the primary key of this booking status.
	*
	* @param primaryKey the primary key of this booking status
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_bookingStatus.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the bs ID of this booking status.
	*
	* @return the bs ID of this booking status
	*/
	@Override
	public long getBsId() {
		return _bookingStatus.getBsId();
	}

	/**
	* Sets the bs ID of this booking status.
	*
	* @param bsId the bs ID of this booking status
	*/
	@Override
	public void setBsId(long bsId) {
		_bookingStatus.setBsId(bsId);
	}

	/**
	* Returns the user ID of this booking status.
	*
	* @return the user ID of this booking status
	*/
	@Override
	public long getUserId() {
		return _bookingStatus.getUserId();
	}

	/**
	* Sets the user ID of this booking status.
	*
	* @param userId the user ID of this booking status
	*/
	@Override
	public void setUserId(long userId) {
		_bookingStatus.setUserId(userId);
	}

	/**
	* Returns the user uuid of this booking status.
	*
	* @return the user uuid of this booking status
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookingStatus.getUserUuid();
	}

	/**
	* Sets the user uuid of this booking status.
	*
	* @param userUuid the user uuid of this booking status
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_bookingStatus.setUserUuid(userUuid);
	}

	/**
	* Returns the brt ID of this booking status.
	*
	* @return the brt ID of this booking status
	*/
	@Override
	public long getBrtId() {
		return _bookingStatus.getBrtId();
	}

	/**
	* Sets the brt ID of this booking status.
	*
	* @param brtId the brt ID of this booking status
	*/
	@Override
	public void setBrtId(long brtId) {
		_bookingStatus.setBrtId(brtId);
	}

	/**
	* Returns the status of this booking status.
	*
	* @return the status of this booking status
	*/
	@Override
	public java.lang.String getStatus() {
		return _bookingStatus.getStatus();
	}

	/**
	* Sets the status of this booking status.
	*
	* @param status the status of this booking status
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_bookingStatus.setStatus(status);
	}

	/**
	* Returns the trip status of this booking status.
	*
	* @return the trip status of this booking status
	*/
	@Override
	public java.lang.String getTripStatus() {
		return _bookingStatus.getTripStatus();
	}

	/**
	* Sets the trip status of this booking status.
	*
	* @param tripStatus the trip status of this booking status
	*/
	@Override
	public void setTripStatus(java.lang.String tripStatus) {
		_bookingStatus.setTripStatus(tripStatus);
	}

	/**
	* Returns the create date of this booking status.
	*
	* @return the create date of this booking status
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _bookingStatus.getCreateDate();
	}

	/**
	* Sets the create date of this booking status.
	*
	* @param createDate the create date of this booking status
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_bookingStatus.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _bookingStatus.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_bookingStatus.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _bookingStatus.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bookingStatus.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _bookingStatus.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _bookingStatus.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bookingStatus.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bookingStatus.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_bookingStatus.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_bookingStatus.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bookingStatus.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BookingStatusWrapper((BookingStatus)_bookingStatus.clone());
	}

	@Override
	public int compareTo(com.services.model.BookingStatus bookingStatus) {
		return _bookingStatus.compareTo(bookingStatus);
	}

	@Override
	public int hashCode() {
		return _bookingStatus.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.services.model.BookingStatus> toCacheModel() {
		return _bookingStatus.toCacheModel();
	}

	@Override
	public com.services.model.BookingStatus toEscapedModel() {
		return new BookingStatusWrapper(_bookingStatus.toEscapedModel());
	}

	@Override
	public com.services.model.BookingStatus toUnescapedModel() {
		return new BookingStatusWrapper(_bookingStatus.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bookingStatus.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _bookingStatus.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bookingStatus.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BookingStatusWrapper)) {
			return false;
		}

		BookingStatusWrapper bookingStatusWrapper = (BookingStatusWrapper)obj;

		if (Validator.equals(_bookingStatus, bookingStatusWrapper._bookingStatus)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BookingStatus getWrappedBookingStatus() {
		return _bookingStatus;
	}

	@Override
	public BookingStatus getWrappedModel() {
		return _bookingStatus;
	}

	@Override
	public void resetOriginalValues() {
		_bookingStatus.resetOriginalValues();
	}

	private BookingStatus _bookingStatus;
}