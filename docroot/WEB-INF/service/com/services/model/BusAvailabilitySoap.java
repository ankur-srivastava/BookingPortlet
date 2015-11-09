/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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
public class BusAvailabilitySoap implements Serializable {
	public static BusAvailabilitySoap toSoapModel(BusAvailability model) {
		BusAvailabilitySoap soapModel = new BusAvailabilitySoap();

		soapModel.setBaId(model.getBaId());
		soapModel.setBrtId(model.getBrtId());
		soapModel.setTotal(model.getTotal());
		soapModel.setAvailable(model.getAvailable());
		soapModel.setPrice(model.getPrice());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static BusAvailabilitySoap[] toSoapModels(BusAvailability[] models) {
		BusAvailabilitySoap[] soapModels = new BusAvailabilitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BusAvailabilitySoap[][] toSoapModels(
		BusAvailability[][] models) {
		BusAvailabilitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BusAvailabilitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new BusAvailabilitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BusAvailabilitySoap[] toSoapModels(
		List<BusAvailability> models) {
		List<BusAvailabilitySoap> soapModels = new ArrayList<BusAvailabilitySoap>(models.size());

		for (BusAvailability model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BusAvailabilitySoap[soapModels.size()]);
	}

	public BusAvailabilitySoap() {
	}

	public long getPrimaryKey() {
		return _baId;
	}

	public void setPrimaryKey(long pk) {
		setBaId(pk);
	}

	public long getBaId() {
		return _baId;
	}

	public void setBaId(long baId) {
		_baId = baId;
	}

	public long getBrtId() {
		return _brtId;
	}

	public void setBrtId(long brtId) {
		_brtId = brtId;
	}

	public long getTotal() {
		return _total;
	}

	public void setTotal(long total) {
		_total = total;
	}

	public long getAvailable() {
		return _available;
	}

	public void setAvailable(long available) {
		_available = available;
	}

	public long getPrice() {
		return _price;
	}

	public void setPrice(long price) {
		_price = price;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	private long _baId;
	private long _brtId;
	private long _total;
	private long _available;
	private long _price;
	private Date _createDate;
}