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
 * This class is a wrapper for {@link BusReservation}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusReservation
 * @generated
 */
public class BusReservationWrapper implements BusReservation,
	ModelWrapper<BusReservation> {
	public BusReservationWrapper(BusReservation busReservation) {
		_busReservation = busReservation;
	}

	@Override
	public Class<?> getModelClass() {
		return BusReservation.class;
	}

	@Override
	public String getModelClassName() {
		return BusReservation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("brId", getBrId());
		attributes.put("baId", getBaId());
		attributes.put("userId", getUserId());
		attributes.put("paymentReceived", getPaymentReceived());
		attributes.put("bookingDate", getBookingDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long brId = (Long)attributes.get("brId");

		if (brId != null) {
			setBrId(brId);
		}

		Long baId = (Long)attributes.get("baId");

		if (baId != null) {
			setBaId(baId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Boolean paymentReceived = (Boolean)attributes.get("paymentReceived");

		if (paymentReceived != null) {
			setPaymentReceived(paymentReceived);
		}

		Date bookingDate = (Date)attributes.get("bookingDate");

		if (bookingDate != null) {
			setBookingDate(bookingDate);
		}
	}

	/**
	* Returns the primary key of this bus reservation.
	*
	* @return the primary key of this bus reservation
	*/
	@Override
	public long getPrimaryKey() {
		return _busReservation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bus reservation.
	*
	* @param primaryKey the primary key of this bus reservation
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_busReservation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the br ID of this bus reservation.
	*
	* @return the br ID of this bus reservation
	*/
	@Override
	public long getBrId() {
		return _busReservation.getBrId();
	}

	/**
	* Sets the br ID of this bus reservation.
	*
	* @param brId the br ID of this bus reservation
	*/
	@Override
	public void setBrId(long brId) {
		_busReservation.setBrId(brId);
	}

	/**
	* Returns the ba ID of this bus reservation.
	*
	* @return the ba ID of this bus reservation
	*/
	@Override
	public long getBaId() {
		return _busReservation.getBaId();
	}

	/**
	* Sets the ba ID of this bus reservation.
	*
	* @param baId the ba ID of this bus reservation
	*/
	@Override
	public void setBaId(long baId) {
		_busReservation.setBaId(baId);
	}

	/**
	* Returns the user ID of this bus reservation.
	*
	* @return the user ID of this bus reservation
	*/
	@Override
	public long getUserId() {
		return _busReservation.getUserId();
	}

	/**
	* Sets the user ID of this bus reservation.
	*
	* @param userId the user ID of this bus reservation
	*/
	@Override
	public void setUserId(long userId) {
		_busReservation.setUserId(userId);
	}

	/**
	* Returns the user uuid of this bus reservation.
	*
	* @return the user uuid of this bus reservation
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _busReservation.getUserUuid();
	}

	/**
	* Sets the user uuid of this bus reservation.
	*
	* @param userUuid the user uuid of this bus reservation
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_busReservation.setUserUuid(userUuid);
	}

	/**
	* Returns the payment received of this bus reservation.
	*
	* @return the payment received of this bus reservation
	*/
	@Override
	public boolean getPaymentReceived() {
		return _busReservation.getPaymentReceived();
	}

	/**
	* Returns <code>true</code> if this bus reservation is payment received.
	*
	* @return <code>true</code> if this bus reservation is payment received; <code>false</code> otherwise
	*/
	@Override
	public boolean isPaymentReceived() {
		return _busReservation.isPaymentReceived();
	}

	/**
	* Sets whether this bus reservation is payment received.
	*
	* @param paymentReceived the payment received of this bus reservation
	*/
	@Override
	public void setPaymentReceived(boolean paymentReceived) {
		_busReservation.setPaymentReceived(paymentReceived);
	}

	/**
	* Returns the booking date of this bus reservation.
	*
	* @return the booking date of this bus reservation
	*/
	@Override
	public java.util.Date getBookingDate() {
		return _busReservation.getBookingDate();
	}

	/**
	* Sets the booking date of this bus reservation.
	*
	* @param bookingDate the booking date of this bus reservation
	*/
	@Override
	public void setBookingDate(java.util.Date bookingDate) {
		_busReservation.setBookingDate(bookingDate);
	}

	@Override
	public boolean isNew() {
		return _busReservation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_busReservation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _busReservation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_busReservation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _busReservation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _busReservation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_busReservation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _busReservation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_busReservation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_busReservation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_busReservation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BusReservationWrapper((BusReservation)_busReservation.clone());
	}

	@Override
	public int compareTo(com.services.model.BusReservation busReservation) {
		return _busReservation.compareTo(busReservation);
	}

	@Override
	public int hashCode() {
		return _busReservation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.services.model.BusReservation> toCacheModel() {
		return _busReservation.toCacheModel();
	}

	@Override
	public com.services.model.BusReservation toEscapedModel() {
		return new BusReservationWrapper(_busReservation.toEscapedModel());
	}

	@Override
	public com.services.model.BusReservation toUnescapedModel() {
		return new BusReservationWrapper(_busReservation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _busReservation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _busReservation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_busReservation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BusReservationWrapper)) {
			return false;
		}

		BusReservationWrapper busReservationWrapper = (BusReservationWrapper)obj;

		if (Validator.equals(_busReservation,
					busReservationWrapper._busReservation)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BusReservation getWrappedBusReservation() {
		return _busReservation;
	}

	@Override
	public BusReservation getWrappedModel() {
		return _busReservation;
	}

	@Override
	public void resetOriginalValues() {
		_busReservation.resetOriginalValues();
	}

	private BusReservation _busReservation;
}