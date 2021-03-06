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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the BookingStatus service. Represents a row in the &quot;JPB_BookingStatus&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.services.model.impl.BookingStatusModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.services.model.impl.BookingStatusImpl}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see BookingStatus
 * @see com.services.model.impl.BookingStatusImpl
 * @see com.services.model.impl.BookingStatusModelImpl
 * @generated
 */
public interface BookingStatusModel extends BaseModel<BookingStatus> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a booking status model instance should use the {@link BookingStatus} interface instead.
	 */

	/**
	 * Returns the primary key of this booking status.
	 *
	 * @return the primary key of this booking status
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this booking status.
	 *
	 * @param primaryKey the primary key of this booking status
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the bs ID of this booking status.
	 *
	 * @return the bs ID of this booking status
	 */
	public long getBsId();

	/**
	 * Sets the bs ID of this booking status.
	 *
	 * @param bsId the bs ID of this booking status
	 */
	public void setBsId(long bsId);

	/**
	 * Returns the user ID of this booking status.
	 *
	 * @return the user ID of this booking status
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this booking status.
	 *
	 * @param userId the user ID of this booking status
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this booking status.
	 *
	 * @return the user uuid of this booking status
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this booking status.
	 *
	 * @param userUuid the user uuid of this booking status
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the brt ID of this booking status.
	 *
	 * @return the brt ID of this booking status
	 */
	public long getBrtId();

	/**
	 * Sets the brt ID of this booking status.
	 *
	 * @param brtId the brt ID of this booking status
	 */
	public void setBrtId(long brtId);

	/**
	 * Returns the status of this booking status.
	 *
	 * @return the status of this booking status
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this booking status.
	 *
	 * @param status the status of this booking status
	 */
	public void setStatus(String status);

	/**
	 * Returns the trip status of this booking status.
	 *
	 * @return the trip status of this booking status
	 */
	@AutoEscape
	public String getTripStatus();

	/**
	 * Sets the trip status of this booking status.
	 *
	 * @param tripStatus the trip status of this booking status
	 */
	public void setTripStatus(String tripStatus);

	/**
	 * Returns the create date of this booking status.
	 *
	 * @return the create date of this booking status
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this booking status.
	 *
	 * @param createDate the create date of this booking status
	 */
	public void setCreateDate(Date createDate);

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
	public int compareTo(com.services.model.BookingStatus bookingStatus);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.services.model.BookingStatus> toCacheModel();

	@Override
	public com.services.model.BookingStatus toEscapedModel();

	@Override
	public com.services.model.BookingStatus toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}