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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Bus}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see Bus
 * @generated
 */
public class BusWrapper implements Bus, ModelWrapper<Bus> {
	public BusWrapper(Bus bus) {
		_bus = bus;
	}

	@Override
	public Class<?> getModelClass() {
		return Bus.class;
	}

	@Override
	public String getModelClassName() {
		return Bus.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("busId", getBusId());
		attributes.put("busName", getBusName());
		attributes.put("agency", getAgency());
		attributes.put("driver", getDriver());
		attributes.put("conductor", getConductor());
		attributes.put("helper", getHelper());
		attributes.put("plateNumber", getPlateNumber());
		attributes.put("color", getColor());
		attributes.put("make", getMake());
		attributes.put("model", getModel());
		attributes.put("year", getYear());
		attributes.put("active", getActive());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long busId = (Long)attributes.get("busId");

		if (busId != null) {
			setBusId(busId);
		}

		String busName = (String)attributes.get("busName");

		if (busName != null) {
			setBusName(busName);
		}

		Long agency = (Long)attributes.get("agency");

		if (agency != null) {
			setAgency(agency);
		}

		Long driver = (Long)attributes.get("driver");

		if (driver != null) {
			setDriver(driver);
		}

		Long conductor = (Long)attributes.get("conductor");

		if (conductor != null) {
			setConductor(conductor);
		}

		Long helper = (Long)attributes.get("helper");

		if (helper != null) {
			setHelper(helper);
		}

		String plateNumber = (String)attributes.get("plateNumber");

		if (plateNumber != null) {
			setPlateNumber(plateNumber);
		}

		String color = (String)attributes.get("color");

		if (color != null) {
			setColor(color);
		}

		String make = (String)attributes.get("make");

		if (make != null) {
			setMake(make);
		}

		String model = (String)attributes.get("model");

		if (model != null) {
			setModel(model);
		}

		String year = (String)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this bus.
	*
	* @return the primary key of this bus
	*/
	@Override
	public long getPrimaryKey() {
		return _bus.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bus.
	*
	* @param primaryKey the primary key of this bus
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_bus.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the bus ID of this bus.
	*
	* @return the bus ID of this bus
	*/
	@Override
	public long getBusId() {
		return _bus.getBusId();
	}

	/**
	* Sets the bus ID of this bus.
	*
	* @param busId the bus ID of this bus
	*/
	@Override
	public void setBusId(long busId) {
		_bus.setBusId(busId);
	}

	/**
	* Returns the bus name of this bus.
	*
	* @return the bus name of this bus
	*/
	@Override
	public java.lang.String getBusName() {
		return _bus.getBusName();
	}

	/**
	* Sets the bus name of this bus.
	*
	* @param busName the bus name of this bus
	*/
	@Override
	public void setBusName(java.lang.String busName) {
		_bus.setBusName(busName);
	}

	/**
	* Returns the agency of this bus.
	*
	* @return the agency of this bus
	*/
	@Override
	public long getAgency() {
		return _bus.getAgency();
	}

	/**
	* Sets the agency of this bus.
	*
	* @param agency the agency of this bus
	*/
	@Override
	public void setAgency(long agency) {
		_bus.setAgency(agency);
	}

	/**
	* Returns the driver of this bus.
	*
	* @return the driver of this bus
	*/
	@Override
	public long getDriver() {
		return _bus.getDriver();
	}

	/**
	* Sets the driver of this bus.
	*
	* @param driver the driver of this bus
	*/
	@Override
	public void setDriver(long driver) {
		_bus.setDriver(driver);
	}

	/**
	* Returns the conductor of this bus.
	*
	* @return the conductor of this bus
	*/
	@Override
	public long getConductor() {
		return _bus.getConductor();
	}

	/**
	* Sets the conductor of this bus.
	*
	* @param conductor the conductor of this bus
	*/
	@Override
	public void setConductor(long conductor) {
		_bus.setConductor(conductor);
	}

	/**
	* Returns the helper of this bus.
	*
	* @return the helper of this bus
	*/
	@Override
	public long getHelper() {
		return _bus.getHelper();
	}

	/**
	* Sets the helper of this bus.
	*
	* @param helper the helper of this bus
	*/
	@Override
	public void setHelper(long helper) {
		_bus.setHelper(helper);
	}

	/**
	* Returns the plate number of this bus.
	*
	* @return the plate number of this bus
	*/
	@Override
	public java.lang.String getPlateNumber() {
		return _bus.getPlateNumber();
	}

	/**
	* Sets the plate number of this bus.
	*
	* @param plateNumber the plate number of this bus
	*/
	@Override
	public void setPlateNumber(java.lang.String plateNumber) {
		_bus.setPlateNumber(plateNumber);
	}

	/**
	* Returns the color of this bus.
	*
	* @return the color of this bus
	*/
	@Override
	public java.lang.String getColor() {
		return _bus.getColor();
	}

	/**
	* Sets the color of this bus.
	*
	* @param color the color of this bus
	*/
	@Override
	public void setColor(java.lang.String color) {
		_bus.setColor(color);
	}

	/**
	* Returns the make of this bus.
	*
	* @return the make of this bus
	*/
	@Override
	public java.lang.String getMake() {
		return _bus.getMake();
	}

	/**
	* Sets the make of this bus.
	*
	* @param make the make of this bus
	*/
	@Override
	public void setMake(java.lang.String make) {
		_bus.setMake(make);
	}

	/**
	* Returns the model of this bus.
	*
	* @return the model of this bus
	*/
	@Override
	public java.lang.String getModel() {
		return _bus.getModel();
	}

	/**
	* Sets the model of this bus.
	*
	* @param model the model of this bus
	*/
	@Override
	public void setModel(java.lang.String model) {
		_bus.setModel(model);
	}

	/**
	* Returns the year of this bus.
	*
	* @return the year of this bus
	*/
	@Override
	public java.lang.String getYear() {
		return _bus.getYear();
	}

	/**
	* Sets the year of this bus.
	*
	* @param year the year of this bus
	*/
	@Override
	public void setYear(java.lang.String year) {
		_bus.setYear(year);
	}

	/**
	* Returns the active of this bus.
	*
	* @return the active of this bus
	*/
	@Override
	public boolean getActive() {
		return _bus.getActive();
	}

	/**
	* Returns <code>true</code> if this bus is active.
	*
	* @return <code>true</code> if this bus is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _bus.isActive();
	}

	/**
	* Sets whether this bus is active.
	*
	* @param active the active of this bus
	*/
	@Override
	public void setActive(boolean active) {
		_bus.setActive(active);
	}

	/**
	* Returns the create date of this bus.
	*
	* @return the create date of this bus
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _bus.getCreateDate();
	}

	/**
	* Sets the create date of this bus.
	*
	* @param createDate the create date of this bus
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_bus.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this bus.
	*
	* @return the modified date of this bus
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _bus.getModifiedDate();
	}

	/**
	* Sets the modified date of this bus.
	*
	* @param modifiedDate the modified date of this bus
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_bus.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _bus.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_bus.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _bus.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bus.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _bus.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _bus.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bus.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bus.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_bus.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_bus.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bus.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BusWrapper((Bus)_bus.clone());
	}

	@Override
	public int compareTo(com.services.model.Bus bus) {
		return _bus.compareTo(bus);
	}

	@Override
	public int hashCode() {
		return _bus.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.services.model.Bus> toCacheModel() {
		return _bus.toCacheModel();
	}

	@Override
	public com.services.model.Bus toEscapedModel() {
		return new BusWrapper(_bus.toEscapedModel());
	}

	@Override
	public com.services.model.Bus toUnescapedModel() {
		return new BusWrapper(_bus.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bus.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _bus.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bus.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BusWrapper)) {
			return false;
		}

		BusWrapper busWrapper = (BusWrapper)obj;

		if (Validator.equals(_bus, busWrapper._bus)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Bus getWrappedBus() {
		return _bus;
	}

	@Override
	public Bus getWrappedModel() {
		return _bus;
	}

	@Override
	public void resetOriginalValues() {
		_bus.resetOriginalValues();
	}

	private Bus _bus;
}