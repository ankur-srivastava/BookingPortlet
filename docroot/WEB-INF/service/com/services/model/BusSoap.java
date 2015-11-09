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
public class BusSoap implements Serializable {
	public static BusSoap toSoapModel(Bus model) {
		BusSoap soapModel = new BusSoap();

		soapModel.setBusId(model.getBusId());
		soapModel.setBusName(model.getBusName());
		soapModel.setAgency(model.getAgency());
		soapModel.setDriver(model.getDriver());
		soapModel.setConductor(model.getConductor());
		soapModel.setHelper(model.getHelper());
		soapModel.setPlateNumber(model.getPlateNumber());
		soapModel.setColor(model.getColor());
		soapModel.setMake(model.getMake());
		soapModel.setModel(model.getModel());
		soapModel.setYear(model.getYear());
		soapModel.setActive(model.getActive());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static BusSoap[] toSoapModels(Bus[] models) {
		BusSoap[] soapModels = new BusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BusSoap[][] toSoapModels(Bus[][] models) {
		BusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BusSoap[] toSoapModels(List<Bus> models) {
		List<BusSoap> soapModels = new ArrayList<BusSoap>(models.size());

		for (Bus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BusSoap[soapModels.size()]);
	}

	public BusSoap() {
	}

	public long getPrimaryKey() {
		return _busId;
	}

	public void setPrimaryKey(long pk) {
		setBusId(pk);
	}

	public long getBusId() {
		return _busId;
	}

	public void setBusId(long busId) {
		_busId = busId;
	}

	public String getBusName() {
		return _busName;
	}

	public void setBusName(String busName) {
		_busName = busName;
	}

	public long getAgency() {
		return _agency;
	}

	public void setAgency(long agency) {
		_agency = agency;
	}

	public long getDriver() {
		return _driver;
	}

	public void setDriver(long driver) {
		_driver = driver;
	}

	public long getConductor() {
		return _conductor;
	}

	public void setConductor(long conductor) {
		_conductor = conductor;
	}

	public long getHelper() {
		return _helper;
	}

	public void setHelper(long helper) {
		_helper = helper;
	}

	public String getPlateNumber() {
		return _plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		_plateNumber = plateNumber;
	}

	public String getColor() {
		return _color;
	}

	public void setColor(String color) {
		_color = color;
	}

	public String getMake() {
		return _make;
	}

	public void setMake(String make) {
		_make = make;
	}

	public String getModel() {
		return _model;
	}

	public void setModel(String model) {
		_model = model;
	}

	public String getYear() {
		return _year;
	}

	public void setYear(String year) {
		_year = year;
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

	private long _busId;
	private String _busName;
	private long _agency;
	private long _driver;
	private long _conductor;
	private long _helper;
	private String _plateNumber;
	private String _color;
	private String _make;
	private String _model;
	private String _year;
	private boolean _active;
	private Date _createDate;
	private Date _modifiedDate;
}