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
public class BusEmployeeSoap implements Serializable {
	public static BusEmployeeSoap toSoapModel(BusEmployee model) {
		BusEmployeeSoap soapModel = new BusEmployeeSoap();

		soapModel.setBeId(model.getBeId());
		soapModel.setBeName(model.getBeName());
		soapModel.setAgency(model.getAgency());
		soapModel.setContactNumber(model.getContactNumber());
		soapModel.setEmail(model.getEmail());
		soapModel.setLicenseNumber(model.getLicenseNumber());
		soapModel.setAlternateIdNumber(model.getAlternateIdNumber());
		soapModel.setActive(model.getActive());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static BusEmployeeSoap[] toSoapModels(BusEmployee[] models) {
		BusEmployeeSoap[] soapModels = new BusEmployeeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BusEmployeeSoap[][] toSoapModels(BusEmployee[][] models) {
		BusEmployeeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BusEmployeeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BusEmployeeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BusEmployeeSoap[] toSoapModels(List<BusEmployee> models) {
		List<BusEmployeeSoap> soapModels = new ArrayList<BusEmployeeSoap>(models.size());

		for (BusEmployee model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BusEmployeeSoap[soapModels.size()]);
	}

	public BusEmployeeSoap() {
	}

	public long getPrimaryKey() {
		return _beId;
	}

	public void setPrimaryKey(long pk) {
		setBeId(pk);
	}

	public long getBeId() {
		return _beId;
	}

	public void setBeId(long beId) {
		_beId = beId;
	}

	public String getBeName() {
		return _beName;
	}

	public void setBeName(String beName) {
		_beName = beName;
	}

	public long getAgency() {
		return _agency;
	}

	public void setAgency(long agency) {
		_agency = agency;
	}

	public String getContactNumber() {
		return _contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		_contactNumber = contactNumber;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getLicenseNumber() {
		return _licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		_licenseNumber = licenseNumber;
	}

	public String getAlternateIdNumber() {
		return _alternateIdNumber;
	}

	public void setAlternateIdNumber(String alternateIdNumber) {
		_alternateIdNumber = alternateIdNumber;
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

	private long _beId;
	private String _beName;
	private long _agency;
	private String _contactNumber;
	private String _email;
	private String _licenseNumber;
	private String _alternateIdNumber;
	private boolean _active;
	private Date _createDate;
	private Date _modifiedDate;
}