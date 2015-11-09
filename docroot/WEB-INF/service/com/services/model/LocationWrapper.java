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
 * This class is a wrapper for {@link Location}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see Location
 * @generated
 */
public class LocationWrapper implements Location, ModelWrapper<Location> {
	public LocationWrapper(Location location) {
		_location = location;
	}

	@Override
	public Class<?> getModelClass() {
		return Location.class;
	}

	@Override
	public String getModelClassName() {
		return Location.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("locationId", getLocationId());
		attributes.put("locationName", getLocationName());
		attributes.put("streetAddress1", getStreetAddress1());
		attributes.put("streetAddress2", getStreetAddress2());
		attributes.put("locationZip", getLocationZip());
		attributes.put("locationCityName", getLocationCityName());
		attributes.put("locationStateName", getLocationStateName());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("comments", getComments());
		attributes.put("active", getActive());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		String locationName = (String)attributes.get("locationName");

		if (locationName != null) {
			setLocationName(locationName);
		}

		String streetAddress1 = (String)attributes.get("streetAddress1");

		if (streetAddress1 != null) {
			setStreetAddress1(streetAddress1);
		}

		String streetAddress2 = (String)attributes.get("streetAddress2");

		if (streetAddress2 != null) {
			setStreetAddress2(streetAddress2);
		}

		String locationZip = (String)attributes.get("locationZip");

		if (locationZip != null) {
			setLocationZip(locationZip);
		}

		String locationCityName = (String)attributes.get("locationCityName");

		if (locationCityName != null) {
			setLocationCityName(locationCityName);
		}

		String locationStateName = (String)attributes.get("locationStateName");

		if (locationStateName != null) {
			setLocationStateName(locationStateName);
		}

		String latitude = (String)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		String longitude = (String)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
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
	* Returns the primary key of this location.
	*
	* @return the primary key of this location
	*/
	@Override
	public long getPrimaryKey() {
		return _location.getPrimaryKey();
	}

	/**
	* Sets the primary key of this location.
	*
	* @param primaryKey the primary key of this location
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_location.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the location ID of this location.
	*
	* @return the location ID of this location
	*/
	@Override
	public long getLocationId() {
		return _location.getLocationId();
	}

	/**
	* Sets the location ID of this location.
	*
	* @param locationId the location ID of this location
	*/
	@Override
	public void setLocationId(long locationId) {
		_location.setLocationId(locationId);
	}

	/**
	* Returns the location name of this location.
	*
	* @return the location name of this location
	*/
	@Override
	public java.lang.String getLocationName() {
		return _location.getLocationName();
	}

	/**
	* Sets the location name of this location.
	*
	* @param locationName the location name of this location
	*/
	@Override
	public void setLocationName(java.lang.String locationName) {
		_location.setLocationName(locationName);
	}

	/**
	* Returns the street address1 of this location.
	*
	* @return the street address1 of this location
	*/
	@Override
	public java.lang.String getStreetAddress1() {
		return _location.getStreetAddress1();
	}

	/**
	* Sets the street address1 of this location.
	*
	* @param streetAddress1 the street address1 of this location
	*/
	@Override
	public void setStreetAddress1(java.lang.String streetAddress1) {
		_location.setStreetAddress1(streetAddress1);
	}

	/**
	* Returns the street address2 of this location.
	*
	* @return the street address2 of this location
	*/
	@Override
	public java.lang.String getStreetAddress2() {
		return _location.getStreetAddress2();
	}

	/**
	* Sets the street address2 of this location.
	*
	* @param streetAddress2 the street address2 of this location
	*/
	@Override
	public void setStreetAddress2(java.lang.String streetAddress2) {
		_location.setStreetAddress2(streetAddress2);
	}

	/**
	* Returns the location zip of this location.
	*
	* @return the location zip of this location
	*/
	@Override
	public java.lang.String getLocationZip() {
		return _location.getLocationZip();
	}

	/**
	* Sets the location zip of this location.
	*
	* @param locationZip the location zip of this location
	*/
	@Override
	public void setLocationZip(java.lang.String locationZip) {
		_location.setLocationZip(locationZip);
	}

	/**
	* Returns the location city name of this location.
	*
	* @return the location city name of this location
	*/
	@Override
	public java.lang.String getLocationCityName() {
		return _location.getLocationCityName();
	}

	/**
	* Sets the location city name of this location.
	*
	* @param locationCityName the location city name of this location
	*/
	@Override
	public void setLocationCityName(java.lang.String locationCityName) {
		_location.setLocationCityName(locationCityName);
	}

	/**
	* Returns the location state name of this location.
	*
	* @return the location state name of this location
	*/
	@Override
	public java.lang.String getLocationStateName() {
		return _location.getLocationStateName();
	}

	/**
	* Sets the location state name of this location.
	*
	* @param locationStateName the location state name of this location
	*/
	@Override
	public void setLocationStateName(java.lang.String locationStateName) {
		_location.setLocationStateName(locationStateName);
	}

	/**
	* Returns the latitude of this location.
	*
	* @return the latitude of this location
	*/
	@Override
	public java.lang.String getLatitude() {
		return _location.getLatitude();
	}

	/**
	* Sets the latitude of this location.
	*
	* @param latitude the latitude of this location
	*/
	@Override
	public void setLatitude(java.lang.String latitude) {
		_location.setLatitude(latitude);
	}

	/**
	* Returns the longitude of this location.
	*
	* @return the longitude of this location
	*/
	@Override
	public java.lang.String getLongitude() {
		return _location.getLongitude();
	}

	/**
	* Sets the longitude of this location.
	*
	* @param longitude the longitude of this location
	*/
	@Override
	public void setLongitude(java.lang.String longitude) {
		_location.setLongitude(longitude);
	}

	/**
	* Returns the comments of this location.
	*
	* @return the comments of this location
	*/
	@Override
	public java.lang.String getComments() {
		return _location.getComments();
	}

	/**
	* Sets the comments of this location.
	*
	* @param comments the comments of this location
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_location.setComments(comments);
	}

	/**
	* Returns the active of this location.
	*
	* @return the active of this location
	*/
	@Override
	public boolean getActive() {
		return _location.getActive();
	}

	/**
	* Returns <code>true</code> if this location is active.
	*
	* @return <code>true</code> if this location is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _location.isActive();
	}

	/**
	* Sets whether this location is active.
	*
	* @param active the active of this location
	*/
	@Override
	public void setActive(boolean active) {
		_location.setActive(active);
	}

	/**
	* Returns the create date of this location.
	*
	* @return the create date of this location
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _location.getCreateDate();
	}

	/**
	* Sets the create date of this location.
	*
	* @param createDate the create date of this location
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_location.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this location.
	*
	* @return the modified date of this location
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _location.getModifiedDate();
	}

	/**
	* Sets the modified date of this location.
	*
	* @param modifiedDate the modified date of this location
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_location.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _location.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_location.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _location.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_location.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _location.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _location.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_location.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _location.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_location.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_location.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_location.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LocationWrapper((Location)_location.clone());
	}

	@Override
	public int compareTo(com.services.model.Location location) {
		return _location.compareTo(location);
	}

	@Override
	public int hashCode() {
		return _location.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.services.model.Location> toCacheModel() {
		return _location.toCacheModel();
	}

	@Override
	public com.services.model.Location toEscapedModel() {
		return new LocationWrapper(_location.toEscapedModel());
	}

	@Override
	public com.services.model.Location toUnescapedModel() {
		return new LocationWrapper(_location.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _location.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _location.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_location.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LocationWrapper)) {
			return false;
		}

		LocationWrapper locationWrapper = (LocationWrapper)obj;

		if (Validator.equals(_location, locationWrapper._location)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Location getWrappedLocation() {
		return _location;
	}

	@Override
	public Location getWrappedModel() {
		return _location;
	}

	@Override
	public void resetOriginalValues() {
		_location.resetOriginalValues();
	}

	private Location _location;
}