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
public class BusReservationSoap implements Serializable {
	public static BusReservationSoap toSoapModel(BusReservation model) {
		BusReservationSoap soapModel = new BusReservationSoap();

		soapModel.setBrId(model.getBrId());
		soapModel.setBaId(model.getBaId());
		soapModel.setUserId(model.getUserId());
		soapModel.setPaymentReceived(model.getPaymentReceived());
		soapModel.setBookingDate(model.getBookingDate());

		return soapModel;
	}

	public static BusReservationSoap[] toSoapModels(BusReservation[] models) {
		BusReservationSoap[] soapModels = new BusReservationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BusReservationSoap[][] toSoapModels(BusReservation[][] models) {
		BusReservationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BusReservationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BusReservationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BusReservationSoap[] toSoapModels(List<BusReservation> models) {
		List<BusReservationSoap> soapModels = new ArrayList<BusReservationSoap>(models.size());

		for (BusReservation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BusReservationSoap[soapModels.size()]);
	}

	public BusReservationSoap() {
	}

	public long getPrimaryKey() {
		return _brId;
	}

	public void setPrimaryKey(long pk) {
		setBrId(pk);
	}

	public long getBrId() {
		return _brId;
	}

	public void setBrId(long brId) {
		_brId = brId;
	}

	public long getBaId() {
		return _baId;
	}

	public void setBaId(long baId) {
		_baId = baId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public boolean getPaymentReceived() {
		return _paymentReceived;
	}

	public boolean isPaymentReceived() {
		return _paymentReceived;
	}

	public void setPaymentReceived(boolean paymentReceived) {
		_paymentReceived = paymentReceived;
	}

	public Date getBookingDate() {
		return _bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		_bookingDate = bookingDate;
	}

	private long _brId;
	private long _baId;
	private long _userId;
	private boolean _paymentReceived;
	private Date _bookingDate;
}