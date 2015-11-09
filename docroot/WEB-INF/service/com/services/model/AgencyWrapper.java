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
 * This class is a wrapper for {@link Agency}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see Agency
 * @generated
 */
public class AgencyWrapper implements Agency, ModelWrapper<Agency> {
	public AgencyWrapper(Agency agency) {
		_agency = agency;
	}

	@Override
	public Class<?> getModelClass() {
		return Agency.class;
	}

	@Override
	public String getModelClassName() {
		return Agency.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("agencyId", getAgencyId());
		attributes.put("agencyName", getAgencyName());
		attributes.put("owner", getOwner());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("email", getEmail());
		attributes.put("active", getActive());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long agencyId = (Long)attributes.get("agencyId");

		if (agencyId != null) {
			setAgencyId(agencyId);
		}

		String agencyName = (String)attributes.get("agencyName");

		if (agencyName != null) {
			setAgencyName(agencyName);
		}

		String owner = (String)attributes.get("owner");

		if (owner != null) {
			setOwner(owner);
		}

		String contactNumber = (String)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
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
	* Returns the primary key of this agency.
	*
	* @return the primary key of this agency
	*/
	@Override
	public long getPrimaryKey() {
		return _agency.getPrimaryKey();
	}

	/**
	* Sets the primary key of this agency.
	*
	* @param primaryKey the primary key of this agency
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_agency.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the agency ID of this agency.
	*
	* @return the agency ID of this agency
	*/
	@Override
	public long getAgencyId() {
		return _agency.getAgencyId();
	}

	/**
	* Sets the agency ID of this agency.
	*
	* @param agencyId the agency ID of this agency
	*/
	@Override
	public void setAgencyId(long agencyId) {
		_agency.setAgencyId(agencyId);
	}

	/**
	* Returns the agency name of this agency.
	*
	* @return the agency name of this agency
	*/
	@Override
	public java.lang.String getAgencyName() {
		return _agency.getAgencyName();
	}

	/**
	* Sets the agency name of this agency.
	*
	* @param agencyName the agency name of this agency
	*/
	@Override
	public void setAgencyName(java.lang.String agencyName) {
		_agency.setAgencyName(agencyName);
	}

	/**
	* Returns the owner of this agency.
	*
	* @return the owner of this agency
	*/
	@Override
	public java.lang.String getOwner() {
		return _agency.getOwner();
	}

	/**
	* Sets the owner of this agency.
	*
	* @param owner the owner of this agency
	*/
	@Override
	public void setOwner(java.lang.String owner) {
		_agency.setOwner(owner);
	}

	/**
	* Returns the contact number of this agency.
	*
	* @return the contact number of this agency
	*/
	@Override
	public java.lang.String getContactNumber() {
		return _agency.getContactNumber();
	}

	/**
	* Sets the contact number of this agency.
	*
	* @param contactNumber the contact number of this agency
	*/
	@Override
	public void setContactNumber(java.lang.String contactNumber) {
		_agency.setContactNumber(contactNumber);
	}

	/**
	* Returns the email of this agency.
	*
	* @return the email of this agency
	*/
	@Override
	public java.lang.String getEmail() {
		return _agency.getEmail();
	}

	/**
	* Sets the email of this agency.
	*
	* @param email the email of this agency
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_agency.setEmail(email);
	}

	/**
	* Returns the active of this agency.
	*
	* @return the active of this agency
	*/
	@Override
	public boolean getActive() {
		return _agency.getActive();
	}

	/**
	* Returns <code>true</code> if this agency is active.
	*
	* @return <code>true</code> if this agency is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _agency.isActive();
	}

	/**
	* Sets whether this agency is active.
	*
	* @param active the active of this agency
	*/
	@Override
	public void setActive(boolean active) {
		_agency.setActive(active);
	}

	/**
	* Returns the create date of this agency.
	*
	* @return the create date of this agency
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _agency.getCreateDate();
	}

	/**
	* Sets the create date of this agency.
	*
	* @param createDate the create date of this agency
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_agency.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this agency.
	*
	* @return the modified date of this agency
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _agency.getModifiedDate();
	}

	/**
	* Sets the modified date of this agency.
	*
	* @param modifiedDate the modified date of this agency
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_agency.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _agency.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_agency.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _agency.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_agency.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _agency.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _agency.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_agency.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _agency.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_agency.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_agency.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_agency.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AgencyWrapper((Agency)_agency.clone());
	}

	@Override
	public int compareTo(com.services.model.Agency agency) {
		return _agency.compareTo(agency);
	}

	@Override
	public int hashCode() {
		return _agency.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.services.model.Agency> toCacheModel() {
		return _agency.toCacheModel();
	}

	@Override
	public com.services.model.Agency toEscapedModel() {
		return new AgencyWrapper(_agency.toEscapedModel());
	}

	@Override
	public com.services.model.Agency toUnescapedModel() {
		return new AgencyWrapper(_agency.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _agency.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _agency.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_agency.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AgencyWrapper)) {
			return false;
		}

		AgencyWrapper agencyWrapper = (AgencyWrapper)obj;

		if (Validator.equals(_agency, agencyWrapper._agency)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Agency getWrappedAgency() {
		return _agency;
	}

	@Override
	public Agency getWrappedModel() {
		return _agency;
	}

	@Override
	public void resetOriginalValues() {
		_agency.resetOriginalValues();
	}

	private Agency _agency;
}