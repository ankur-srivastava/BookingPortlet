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
 * This class is a wrapper for {@link BusRouteTimings}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusRouteTimings
 * @generated
 */
public class BusRouteTimingsWrapper implements BusRouteTimings,
	ModelWrapper<BusRouteTimings> {
	public BusRouteTimingsWrapper(BusRouteTimings busRouteTimings) {
		_busRouteTimings = busRouteTimings;
	}

	@Override
	public Class<?> getModelClass() {
		return BusRouteTimings.class;
	}

	@Override
	public String getModelClassName() {
		return BusRouteTimings.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("brtId", getBrtId());
		attributes.put("brId", getBrId());
		attributes.put("busDetails", getBusDetails());
		attributes.put("travelDate", getTravelDate());
		attributes.put("travelTime", getTravelTime());
		attributes.put("total", getTotal());
		attributes.put("available", getAvailable());
		attributes.put("price", getPrice());
		attributes.put("active", getActive());
		attributes.put("completed", getCompleted());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long brtId = (Long)attributes.get("brtId");

		if (brtId != null) {
			setBrtId(brtId);
		}

		Long brId = (Long)attributes.get("brId");

		if (brId != null) {
			setBrId(brId);
		}

		String busDetails = (String)attributes.get("busDetails");

		if (busDetails != null) {
			setBusDetails(busDetails);
		}

		String travelDate = (String)attributes.get("travelDate");

		if (travelDate != null) {
			setTravelDate(travelDate);
		}

		String travelTime = (String)attributes.get("travelTime");

		if (travelTime != null) {
			setTravelTime(travelTime);
		}

		Long total = (Long)attributes.get("total");

		if (total != null) {
			setTotal(total);
		}

		Long available = (Long)attributes.get("available");

		if (available != null) {
			setAvailable(available);
		}

		Long price = (Long)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		String completed = (String)attributes.get("completed");

		if (completed != null) {
			setCompleted(completed);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	/**
	* Returns the primary key of this bus route timings.
	*
	* @return the primary key of this bus route timings
	*/
	@Override
	public long getPrimaryKey() {
		return _busRouteTimings.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bus route timings.
	*
	* @param primaryKey the primary key of this bus route timings
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_busRouteTimings.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the brt ID of this bus route timings.
	*
	* @return the brt ID of this bus route timings
	*/
	@Override
	public long getBrtId() {
		return _busRouteTimings.getBrtId();
	}

	/**
	* Sets the brt ID of this bus route timings.
	*
	* @param brtId the brt ID of this bus route timings
	*/
	@Override
	public void setBrtId(long brtId) {
		_busRouteTimings.setBrtId(brtId);
	}

	/**
	* Returns the br ID of this bus route timings.
	*
	* @return the br ID of this bus route timings
	*/
	@Override
	public long getBrId() {
		return _busRouteTimings.getBrId();
	}

	/**
	* Sets the br ID of this bus route timings.
	*
	* @param brId the br ID of this bus route timings
	*/
	@Override
	public void setBrId(long brId) {
		_busRouteTimings.setBrId(brId);
	}

	/**
	* Returns the bus details of this bus route timings.
	*
	* @return the bus details of this bus route timings
	*/
	@Override
	public java.lang.String getBusDetails() {
		return _busRouteTimings.getBusDetails();
	}

	/**
	* Sets the bus details of this bus route timings.
	*
	* @param busDetails the bus details of this bus route timings
	*/
	@Override
	public void setBusDetails(java.lang.String busDetails) {
		_busRouteTimings.setBusDetails(busDetails);
	}

	/**
	* Returns the travel date of this bus route timings.
	*
	* @return the travel date of this bus route timings
	*/
	@Override
	public java.lang.String getTravelDate() {
		return _busRouteTimings.getTravelDate();
	}

	/**
	* Sets the travel date of this bus route timings.
	*
	* @param travelDate the travel date of this bus route timings
	*/
	@Override
	public void setTravelDate(java.lang.String travelDate) {
		_busRouteTimings.setTravelDate(travelDate);
	}

	/**
	* Returns the travel time of this bus route timings.
	*
	* @return the travel time of this bus route timings
	*/
	@Override
	public java.lang.String getTravelTime() {
		return _busRouteTimings.getTravelTime();
	}

	/**
	* Sets the travel time of this bus route timings.
	*
	* @param travelTime the travel time of this bus route timings
	*/
	@Override
	public void setTravelTime(java.lang.String travelTime) {
		_busRouteTimings.setTravelTime(travelTime);
	}

	/**
	* Returns the total of this bus route timings.
	*
	* @return the total of this bus route timings
	*/
	@Override
	public long getTotal() {
		return _busRouteTimings.getTotal();
	}

	/**
	* Sets the total of this bus route timings.
	*
	* @param total the total of this bus route timings
	*/
	@Override
	public void setTotal(long total) {
		_busRouteTimings.setTotal(total);
	}

	/**
	* Returns the available of this bus route timings.
	*
	* @return the available of this bus route timings
	*/
	@Override
	public long getAvailable() {
		return _busRouteTimings.getAvailable();
	}

	/**
	* Sets the available of this bus route timings.
	*
	* @param available the available of this bus route timings
	*/
	@Override
	public void setAvailable(long available) {
		_busRouteTimings.setAvailable(available);
	}

	/**
	* Returns the price of this bus route timings.
	*
	* @return the price of this bus route timings
	*/
	@Override
	public long getPrice() {
		return _busRouteTimings.getPrice();
	}

	/**
	* Sets the price of this bus route timings.
	*
	* @param price the price of this bus route timings
	*/
	@Override
	public void setPrice(long price) {
		_busRouteTimings.setPrice(price);
	}

	/**
	* Returns the active of this bus route timings.
	*
	* @return the active of this bus route timings
	*/
	@Override
	public boolean getActive() {
		return _busRouteTimings.getActive();
	}

	/**
	* Returns <code>true</code> if this bus route timings is active.
	*
	* @return <code>true</code> if this bus route timings is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _busRouteTimings.isActive();
	}

	/**
	* Sets whether this bus route timings is active.
	*
	* @param active the active of this bus route timings
	*/
	@Override
	public void setActive(boolean active) {
		_busRouteTimings.setActive(active);
	}

	/**
	* Returns the completed of this bus route timings.
	*
	* @return the completed of this bus route timings
	*/
	@Override
	public java.lang.String getCompleted() {
		return _busRouteTimings.getCompleted();
	}

	/**
	* Sets the completed of this bus route timings.
	*
	* @param completed the completed of this bus route timings
	*/
	@Override
	public void setCompleted(java.lang.String completed) {
		_busRouteTimings.setCompleted(completed);
	}

	/**
	* Returns the create date of this bus route timings.
	*
	* @return the create date of this bus route timings
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _busRouteTimings.getCreateDate();
	}

	/**
	* Sets the create date of this bus route timings.
	*
	* @param createDate the create date of this bus route timings
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_busRouteTimings.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _busRouteTimings.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_busRouteTimings.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _busRouteTimings.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_busRouteTimings.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _busRouteTimings.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _busRouteTimings.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_busRouteTimings.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _busRouteTimings.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_busRouteTimings.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_busRouteTimings.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_busRouteTimings.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BusRouteTimingsWrapper((BusRouteTimings)_busRouteTimings.clone());
	}

	@Override
	public int compareTo(com.services.model.BusRouteTimings busRouteTimings) {
		return _busRouteTimings.compareTo(busRouteTimings);
	}

	@Override
	public int hashCode() {
		return _busRouteTimings.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.services.model.BusRouteTimings> toCacheModel() {
		return _busRouteTimings.toCacheModel();
	}

	@Override
	public com.services.model.BusRouteTimings toEscapedModel() {
		return new BusRouteTimingsWrapper(_busRouteTimings.toEscapedModel());
	}

	@Override
	public com.services.model.BusRouteTimings toUnescapedModel() {
		return new BusRouteTimingsWrapper(_busRouteTimings.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _busRouteTimings.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _busRouteTimings.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_busRouteTimings.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BusRouteTimingsWrapper)) {
			return false;
		}

		BusRouteTimingsWrapper busRouteTimingsWrapper = (BusRouteTimingsWrapper)obj;

		if (Validator.equals(_busRouteTimings,
					busRouteTimingsWrapper._busRouteTimings)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BusRouteTimings getWrappedBusRouteTimings() {
		return _busRouteTimings;
	}

	@Override
	public BusRouteTimings getWrappedModel() {
		return _busRouteTimings;
	}

	@Override
	public void resetOriginalValues() {
		_busRouteTimings.resetOriginalValues();
	}

	private BusRouteTimings _busRouteTimings;
}