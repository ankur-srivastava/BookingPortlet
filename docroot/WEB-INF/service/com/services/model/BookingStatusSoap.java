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
 * This class is used by SOAP remote services, specifically {@link com.services.service.http.BookingStatusServiceSoap}.
 *
 * @author Ankur Srivastava
 * @see com.services.service.http.BookingStatusServiceSoap
 * @generated
 */
public class BookingStatusSoap implements Serializable {
	public static BookingStatusSoap toSoapModel(BookingStatus model) {
		BookingStatusSoap soapModel = new BookingStatusSoap();

		soapModel.setBsId(model.getBsId());
		soapModel.setUserId(model.getUserId());
		soapModel.setBrtId(model.getBrtId());
		soapModel.setStatus(model.getStatus());
		soapModel.setTripStatus(model.getTripStatus());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static BookingStatusSoap[] toSoapModels(BookingStatus[] models) {
		BookingStatusSoap[] soapModels = new BookingStatusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BookingStatusSoap[][] toSoapModels(BookingStatus[][] models) {
		BookingStatusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BookingStatusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BookingStatusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BookingStatusSoap[] toSoapModels(List<BookingStatus> models) {
		List<BookingStatusSoap> soapModels = new ArrayList<BookingStatusSoap>(models.size());

		for (BookingStatus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BookingStatusSoap[soapModels.size()]);
	}

	public BookingStatusSoap() {
	}

	public long getPrimaryKey() {
		return _bsId;
	}

	public void setPrimaryKey(long pk) {
		setBsId(pk);
	}

	public long getBsId() {
		return _bsId;
	}

	public void setBsId(long bsId) {
		_bsId = bsId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getBrtId() {
		return _brtId;
	}

	public void setBrtId(long brtId) {
		_brtId = brtId;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getTripStatus() {
		return _tripStatus;
	}

	public void setTripStatus(String tripStatus) {
		_tripStatus = tripStatus;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	private long _bsId;
	private long _userId;
	private long _brtId;
	private String _status;
	private String _tripStatus;
	private Date _createDate;
}