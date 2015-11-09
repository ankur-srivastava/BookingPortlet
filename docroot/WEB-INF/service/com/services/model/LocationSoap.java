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
public class LocationSoap implements Serializable {
	public static LocationSoap toSoapModel(Location model) {
		LocationSoap soapModel = new LocationSoap();

		soapModel.setLocationId(model.getLocationId());
		soapModel.setLocationName(model.getLocationName());
		soapModel.setStreetAddress1(model.getStreetAddress1());
		soapModel.setStreetAddress2(model.getStreetAddress2());
		soapModel.setLocationZip(model.getLocationZip());
		soapModel.setLocationCityName(model.getLocationCityName());
		soapModel.setLocationStateName(model.getLocationStateName());
		soapModel.setLatitude(model.getLatitude());
		soapModel.setLongitude(model.getLongitude());
		soapModel.setComments(model.getComments());
		soapModel.setActive(model.getActive());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static LocationSoap[] toSoapModels(Location[] models) {
		LocationSoap[] soapModels = new LocationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LocationSoap[][] toSoapModels(Location[][] models) {
		LocationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LocationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LocationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LocationSoap[] toSoapModels(List<Location> models) {
		List<LocationSoap> soapModels = new ArrayList<LocationSoap>(models.size());

		for (Location model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LocationSoap[soapModels.size()]);
	}

	public LocationSoap() {
	}

	public long getPrimaryKey() {
		return _locationId;
	}

	public void setPrimaryKey(long pk) {
		setLocationId(pk);
	}

	public long getLocationId() {
		return _locationId;
	}

	public void setLocationId(long locationId) {
		_locationId = locationId;
	}

	public String getLocationName() {
		return _locationName;
	}

	public void setLocationName(String locationName) {
		_locationName = locationName;
	}

	public String getStreetAddress1() {
		return _streetAddress1;
	}

	public void setStreetAddress1(String streetAddress1) {
		_streetAddress1 = streetAddress1;
	}

	public String getStreetAddress2() {
		return _streetAddress2;
	}

	public void setStreetAddress2(String streetAddress2) {
		_streetAddress2 = streetAddress2;
	}

	public String getLocationZip() {
		return _locationZip;
	}

	public void setLocationZip(String locationZip) {
		_locationZip = locationZip;
	}

	public String getLocationCityName() {
		return _locationCityName;
	}

	public void setLocationCityName(String locationCityName) {
		_locationCityName = locationCityName;
	}

	public String getLocationStateName() {
		return _locationStateName;
	}

	public void setLocationStateName(String locationStateName) {
		_locationStateName = locationStateName;
	}

	public String getLatitude() {
		return _latitude;
	}

	public void setLatitude(String latitude) {
		_latitude = latitude;
	}

	public String getLongitude() {
		return _longitude;
	}

	public void setLongitude(String longitude) {
		_longitude = longitude;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
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

	private long _locationId;
	private String _locationName;
	private String _streetAddress1;
	private String _streetAddress2;
	private String _locationZip;
	private String _locationCityName;
	private String _locationStateName;
	private String _latitude;
	private String _longitude;
	private String _comments;
	private boolean _active;
	private Date _createDate;
	private Date _modifiedDate;
}