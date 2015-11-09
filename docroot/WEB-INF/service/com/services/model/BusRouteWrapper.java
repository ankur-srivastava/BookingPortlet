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
 * This class is a wrapper for {@link BusRoute}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusRoute
 * @generated
 */
public class BusRouteWrapper implements BusRoute, ModelWrapper<BusRoute> {
	public BusRouteWrapper(BusRoute busRoute) {
		_busRoute = busRoute;
	}

	@Override
	public Class<?> getModelClass() {
		return BusRoute.class;
	}

	@Override
	public String getModelClassName() {
		return BusRoute.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("brId", getBrId());
		attributes.put("busId", getBusId());
		attributes.put("startLocation", getStartLocation());
		attributes.put("endLocation", getEndLocation());
		attributes.put("midLocation1", getMidLocation1());
		attributes.put("midLocation2", getMidLocation2());
		attributes.put("active", getActive());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long brId = (Long)attributes.get("brId");

		if (brId != null) {
			setBrId(brId);
		}

		Long busId = (Long)attributes.get("busId");

		if (busId != null) {
			setBusId(busId);
		}

		Long startLocation = (Long)attributes.get("startLocation");

		if (startLocation != null) {
			setStartLocation(startLocation);
		}

		Long endLocation = (Long)attributes.get("endLocation");

		if (endLocation != null) {
			setEndLocation(endLocation);
		}

		Long midLocation1 = (Long)attributes.get("midLocation1");

		if (midLocation1 != null) {
			setMidLocation1(midLocation1);
		}

		Long midLocation2 = (Long)attributes.get("midLocation2");

		if (midLocation2 != null) {
			setMidLocation2(midLocation2);
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
	* Returns the primary key of this bus route.
	*
	* @return the primary key of this bus route
	*/
	@Override
	public long getPrimaryKey() {
		return _busRoute.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bus route.
	*
	* @param primaryKey the primary key of this bus route
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_busRoute.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the br ID of this bus route.
	*
	* @return the br ID of this bus route
	*/
	@Override
	public long getBrId() {
		return _busRoute.getBrId();
	}

	/**
	* Sets the br ID of this bus route.
	*
	* @param brId the br ID of this bus route
	*/
	@Override
	public void setBrId(long brId) {
		_busRoute.setBrId(brId);
	}

	/**
	* Returns the bus ID of this bus route.
	*
	* @return the bus ID of this bus route
	*/
	@Override
	public long getBusId() {
		return _busRoute.getBusId();
	}

	/**
	* Sets the bus ID of this bus route.
	*
	* @param busId the bus ID of this bus route
	*/
	@Override
	public void setBusId(long busId) {
		_busRoute.setBusId(busId);
	}

	/**
	* Returns the start location of this bus route.
	*
	* @return the start location of this bus route
	*/
	@Override
	public long getStartLocation() {
		return _busRoute.getStartLocation();
	}

	/**
	* Sets the start location of this bus route.
	*
	* @param startLocation the start location of this bus route
	*/
	@Override
	public void setStartLocation(long startLocation) {
		_busRoute.setStartLocation(startLocation);
	}

	/**
	* Returns the end location of this bus route.
	*
	* @return the end location of this bus route
	*/
	@Override
	public long getEndLocation() {
		return _busRoute.getEndLocation();
	}

	/**
	* Sets the end location of this bus route.
	*
	* @param endLocation the end location of this bus route
	*/
	@Override
	public void setEndLocation(long endLocation) {
		_busRoute.setEndLocation(endLocation);
	}

	/**
	* Returns the mid location1 of this bus route.
	*
	* @return the mid location1 of this bus route
	*/
	@Override
	public long getMidLocation1() {
		return _busRoute.getMidLocation1();
	}

	/**
	* Sets the mid location1 of this bus route.
	*
	* @param midLocation1 the mid location1 of this bus route
	*/
	@Override
	public void setMidLocation1(long midLocation1) {
		_busRoute.setMidLocation1(midLocation1);
	}

	/**
	* Returns the mid location2 of this bus route.
	*
	* @return the mid location2 of this bus route
	*/
	@Override
	public long getMidLocation2() {
		return _busRoute.getMidLocation2();
	}

	/**
	* Sets the mid location2 of this bus route.
	*
	* @param midLocation2 the mid location2 of this bus route
	*/
	@Override
	public void setMidLocation2(long midLocation2) {
		_busRoute.setMidLocation2(midLocation2);
	}

	/**
	* Returns the active of this bus route.
	*
	* @return the active of this bus route
	*/
	@Override
	public boolean getActive() {
		return _busRoute.getActive();
	}

	/**
	* Returns <code>true</code> if this bus route is active.
	*
	* @return <code>true</code> if this bus route is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _busRoute.isActive();
	}

	/**
	* Sets whether this bus route is active.
	*
	* @param active the active of this bus route
	*/
	@Override
	public void setActive(boolean active) {
		_busRoute.setActive(active);
	}

	/**
	* Returns the create date of this bus route.
	*
	* @return the create date of this bus route
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _busRoute.getCreateDate();
	}

	/**
	* Sets the create date of this bus route.
	*
	* @param createDate the create date of this bus route
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_busRoute.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this bus route.
	*
	* @return the modified date of this bus route
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _busRoute.getModifiedDate();
	}

	/**
	* Sets the modified date of this bus route.
	*
	* @param modifiedDate the modified date of this bus route
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_busRoute.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _busRoute.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_busRoute.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _busRoute.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_busRoute.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _busRoute.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _busRoute.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_busRoute.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _busRoute.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_busRoute.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_busRoute.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_busRoute.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BusRouteWrapper((BusRoute)_busRoute.clone());
	}

	@Override
	public int compareTo(com.services.model.BusRoute busRoute) {
		return _busRoute.compareTo(busRoute);
	}

	@Override
	public int hashCode() {
		return _busRoute.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.services.model.BusRoute> toCacheModel() {
		return _busRoute.toCacheModel();
	}

	@Override
	public com.services.model.BusRoute toEscapedModel() {
		return new BusRouteWrapper(_busRoute.toEscapedModel());
	}

	@Override
	public com.services.model.BusRoute toUnescapedModel() {
		return new BusRouteWrapper(_busRoute.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _busRoute.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _busRoute.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_busRoute.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BusRouteWrapper)) {
			return false;
		}

		BusRouteWrapper busRouteWrapper = (BusRouteWrapper)obj;

		if (Validator.equals(_busRoute, busRouteWrapper._busRoute)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BusRoute getWrappedBusRoute() {
		return _busRoute;
	}

	@Override
	public BusRoute getWrappedModel() {
		return _busRoute;
	}

	@Override
	public void resetOriginalValues() {
		_busRoute.resetOriginalValues();
	}

	private BusRoute _busRoute;
}