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
public class BusRouteSoap implements Serializable {
	public static BusRouteSoap toSoapModel(BusRoute model) {
		BusRouteSoap soapModel = new BusRouteSoap();

		soapModel.setBrId(model.getBrId());
		soapModel.setBusId(model.getBusId());
		soapModel.setStartLocation(model.getStartLocation());
		soapModel.setEndLocation(model.getEndLocation());
		soapModel.setMidLocation1(model.getMidLocation1());
		soapModel.setMidLocation2(model.getMidLocation2());
		soapModel.setActive(model.getActive());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static BusRouteSoap[] toSoapModels(BusRoute[] models) {
		BusRouteSoap[] soapModels = new BusRouteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BusRouteSoap[][] toSoapModels(BusRoute[][] models) {
		BusRouteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BusRouteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BusRouteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BusRouteSoap[] toSoapModels(List<BusRoute> models) {
		List<BusRouteSoap> soapModels = new ArrayList<BusRouteSoap>(models.size());

		for (BusRoute model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BusRouteSoap[soapModels.size()]);
	}

	public BusRouteSoap() {
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

	public long getBusId() {
		return _busId;
	}

	public void setBusId(long busId) {
		_busId = busId;
	}

	public long getStartLocation() {
		return _startLocation;
	}

	public void setStartLocation(long startLocation) {
		_startLocation = startLocation;
	}

	public long getEndLocation() {
		return _endLocation;
	}

	public void setEndLocation(long endLocation) {
		_endLocation = endLocation;
	}

	public long getMidLocation1() {
		return _midLocation1;
	}

	public void setMidLocation1(long midLocation1) {
		_midLocation1 = midLocation1;
	}

	public long getMidLocation2() {
		return _midLocation2;
	}

	public void setMidLocation2(long midLocation2) {
		_midLocation2 = midLocation2;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _brId;
	private long _busId;
	private long _startLocation;
	private long _endLocation;
	private long _midLocation1;
	private long _midLocation2;
	private boolean _active;
	private Date _createDate;
	private Date _modifiedDate;
}