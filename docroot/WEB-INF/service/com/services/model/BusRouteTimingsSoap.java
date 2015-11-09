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
 * This class is used by SOAP remote services, specifically {@link com.services.service.http.BusRouteTimingsServiceSoap}.
 *
 * @author Ankur Srivastava
 * @see com.services.service.http.BusRouteTimingsServiceSoap
 * @generated
 */
public class BusRouteTimingsSoap implements Serializable {
	public static BusRouteTimingsSoap toSoapModel(BusRouteTimings model) {
		BusRouteTimingsSoap soapModel = new BusRouteTimingsSoap();

		soapModel.setBrtId(model.getBrtId());
		soapModel.setBrId(model.getBrId());
		soapModel.setBusDetails(model.getBusDetails());
		soapModel.setTravelDate(model.getTravelDate());
		soapModel.setTravelTime(model.getTravelTime());
		soapModel.setTotal(model.getTotal());
		soapModel.setAvailable(model.getAvailable());
		soapModel.setPrice(model.getPrice());
		soapModel.setActive(model.getActive());
		soapModel.setCompleted(model.getCompleted());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static BusRouteTimingsSoap[] toSoapModels(BusRouteTimings[] models) {
		BusRouteTimingsSoap[] soapModels = new BusRouteTimingsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BusRouteTimingsSoap[][] toSoapModels(
		BusRouteTimings[][] models) {
		BusRouteTimingsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BusRouteTimingsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BusRouteTimingsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BusRouteTimingsSoap[] toSoapModels(
		List<BusRouteTimings> models) {
		List<BusRouteTimingsSoap> soapModels = new ArrayList<BusRouteTimingsSoap>(models.size());

		for (BusRouteTimings model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BusRouteTimingsSoap[soapModels.size()]);
	}

	public BusRouteTimingsSoap() {
	}

	public long getPrimaryKey() {
		return _brtId;
	}

	public void setPrimaryKey(long pk) {
		setBrtId(pk);
	}

	public long getBrtId() {
		return _brtId;
	}

	public void setBrtId(long brtId) {
		_brtId = brtId;
	}

	public long getBrId() {
		return _brId;
	}

	public void setBrId(long brId) {
		_brId = brId;
	}

	public String getBusDetails() {
		return _busDetails;
	}

	public void setBusDetails(String busDetails) {
		_busDetails = busDetails;
	}

	public String getTravelDate() {
		return _travelDate;
	}

	public void setTravelDate(String travelDate) {
		_travelDate = travelDate;
	}

	public String getTravelTime() {
		return _travelTime;
	}

	public void setTravelTime(String travelTime) {
		_travelTime = travelTime;
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

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public String getCompleted() {
		return _completed;
	}

	public void setCompleted(String completed) {
		_completed = completed;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	private long _brtId;
	private long _brId;
	private String _busDetails;
	private String _travelDate;
	private String _travelTime;
	private long _total;
	private long _available;
	private long _price;
	private boolean _active;
	private String _completed;
	private Date _createDate;
}