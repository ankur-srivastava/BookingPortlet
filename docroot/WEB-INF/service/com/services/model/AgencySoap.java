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
public class AgencySoap implements Serializable {
	public static AgencySoap toSoapModel(Agency model) {
		AgencySoap soapModel = new AgencySoap();

		soapModel.setAgencyId(model.getAgencyId());
		soapModel.setAgencyName(model.getAgencyName());
		soapModel.setOwner(model.getOwner());
		soapModel.setContactNumber(model.getContactNumber());
		soapModel.setEmail(model.getEmail());
		soapModel.setActive(model.getActive());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static AgencySoap[] toSoapModels(Agency[] models) {
		AgencySoap[] soapModels = new AgencySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AgencySoap[][] toSoapModels(Agency[][] models) {
		AgencySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AgencySoap[models.length][models[0].length];
		}
		else {
			soapModels = new AgencySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AgencySoap[] toSoapModels(List<Agency> models) {
		List<AgencySoap> soapModels = new ArrayList<AgencySoap>(models.size());

		for (Agency model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AgencySoap[soapModels.size()]);
	}

	public AgencySoap() {
	}

	public long getPrimaryKey() {
		return _agencyId;
	}

	public void setPrimaryKey(long pk) {
		setAgencyId(pk);
	}

	public long getAgencyId() {
		return _agencyId;
	}

	public void setAgencyId(long agencyId) {
		_agencyId = agencyId;
	}

	public String getAgencyName() {
		return _agencyName;
	}

	public void setAgencyName(String agencyName) {
		_agencyName = agencyName;
	}

	public String getOwner() {
		return _owner;
	}

	public void setOwner(String owner) {
		_owner = owner;
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

	private long _agencyId;
	private String _agencyName;
	private String _owner;
	private String _contactNumber;
	private String _email;
	private boolean _active;
	private Date _createDate;
	private Date _modifiedDate;
}