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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the BusReservation service. Represents a row in the &quot;JPB_BusReservation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.services.model.impl.BusReservationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.services.model.impl.BusReservationImpl}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusReservation
 * @see com.services.model.impl.BusReservationImpl
 * @see com.services.model.impl.BusReservationModelImpl
 * @generated
 */
public interface BusReservationModel extends BaseModel<BusReservation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a bus reservation model instance should use the {@link BusReservation} interface instead.
	 */

	/**
	 * Returns the primary key of this bus reservation.
	 *
	 * @return the primary key of this bus reservation
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this bus reservation.
	 *
	 * @param primaryKey the primary key of this bus reservation
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the br ID of this bus reservation.
	 *
	 * @return the br ID of this bus reservation
	 */
	public long getBrId();

	/**
	 * Sets the br ID of this bus reservation.
	 *
	 * @param brId the br ID of this bus reservation
	 */
	public void setBrId(long brId);

	/**
	 * Returns the ba ID of this bus reservation.
	 *
	 * @return the ba ID of this bus reservation
	 */
	public long getBaId();

	/**
	 * Sets the ba ID of this bus reservation.
	 *
	 * @param baId the ba ID of this bus reservation
	 */
	public void setBaId(long baId);

	/**
	 * Returns the user ID of this bus reservation.
	 *
	 * @return the user ID of this bus reservation
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this bus reservation.
	 *
	 * @param userId the user ID of this bus reservation
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this bus reservation.
	 *
	 * @return the user uuid of this bus reservation
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this bus reservation.
	 *
	 * @param userUuid the user uuid of this bus reservation
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the payment received of this bus reservation.
	 *
	 * @return the payment received of this bus reservation
	 */
	public boolean getPaymentReceived();

	/**
	 * Returns <code>true</code> if this bus reservation is payment received.
	 *
	 * @return <code>true</code> if this bus reservation is payment received; <code>false</code> otherwise
	 */
	public boolean isPaymentReceived();

	/**
	 * Sets whether this bus reservation is payment received.
	 *
	 * @param paymentReceived the payment received of this bus reservation
	 */
	public void setPaymentReceived(boolean paymentReceived);

	/**
	 * Returns the booking date of this bus reservation.
	 *
	 * @return the booking date of this bus reservation
	 */
	public Date getBookingDate();

	/**
	 * Sets the booking date of this bus reservation.
	 *
	 * @param bookingDate the booking date of this bus reservation
	 */
	public void setBookingDate(Date bookingDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.services.model.BusReservation busReservation);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.services.model.BusReservation> toCacheModel();

	@Override
	public com.services.model.BusReservation toEscapedModel();

	@Override
	public com.services.model.BusReservation toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}