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
 * This class is a wrapper for {@link BusEmployee}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusEmployee
 * @generated
 */
public class BusEmployeeWrapper implements BusEmployee,
	ModelWrapper<BusEmployee> {
	public BusEmployeeWrapper(BusEmployee busEmployee) {
		_busEmployee = busEmployee;
	}

	@Override
	public Class<?> getModelClass() {
		return BusEmployee.class;
	}

	@Override
	public String getModelClassName() {
		return BusEmployee.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("beId", getBeId());
		attributes.put("beName", getBeName());
		attributes.put("agency", getAgency());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("email", getEmail());
		attributes.put("licenseNumber", getLicenseNumber());
		attributes.put("alternateIdNumber", getAlternateIdNumber());
		attributes.put("active", getActive());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long beId = (Long)attributes.get("beId");

		if (beId != null) {
			setBeId(beId);
		}

		String beName = (String)attributes.get("beName");

		if (beName != null) {
			setBeName(beName);
		}

		Long agency = (Long)attributes.get("agency");

		if (agency != null) {
			setAgency(agency);
		}

		String contactNumber = (String)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String licenseNumber = (String)attributes.get("licenseNumber");

		if (licenseNumber != null) {
			setLicenseNumber(licenseNumber);
		}

		String alternateIdNumber = (String)attributes.get("alternateIdNumber");

		if (alternateIdNumber != null) {
			setAlternateIdNumber(alternateIdNumber);
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
	* Returns the primary key of this bus employee.
	*
	* @return the primary key of this bus employee
	*/
	@Override
	public long getPrimaryKey() {
		return _busEmployee.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bus employee.
	*
	* @param primaryKey the primary key of this bus employee
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_busEmployee.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the be ID of this bus employee.
	*
	* @return the be ID of this bus employee
	*/
	@Override
	public long getBeId() {
		return _busEmployee.getBeId();
	}

	/**
	* Sets the be ID of this bus employee.
	*
	* @param beId the be ID of this bus employee
	*/
	@Override
	public void setBeId(long beId) {
		_busEmployee.setBeId(beId);
	}

	/**
	* Returns the be name of this bus employee.
	*
	* @return the be name of this bus employee
	*/
	@Override
	public java.lang.String getBeName() {
		return _busEmployee.getBeName();
	}

	/**
	* Sets the be name of this bus employee.
	*
	* @param beName the be name of this bus employee
	*/
	@Override
	public void setBeName(java.lang.String beName) {
		_busEmployee.setBeName(beName);
	}

	/**
	* Returns the agency of this bus employee.
	*
	* @return the agency of this bus employee
	*/
	@Override
	public long getAgency() {
		return _busEmployee.getAgency();
	}

	/**
	* Sets the agency of this bus employee.
	*
	* @param agency the agency of this bus employee
	*/
	@Override
	public void setAgency(long agency) {
		_busEmployee.setAgency(agency);
	}

	/**
	* Returns the contact number of this bus employee.
	*
	* @return the contact number of this bus employee
	*/
	@Override
	public java.lang.String getContactNumber() {
		return _busEmployee.getContactNumber();
	}

	/**
	* Sets the contact number of this bus employee.
	*
	* @param contactNumber the contact number of this bus employee
	*/
	@Override
	public void setContactNumber(java.lang.String contactNumber) {
		_busEmployee.setContactNumber(contactNumber);
	}

	/**
	* Returns the email of this bus employee.
	*
	* @return the email of this bus employee
	*/
	@Override
	public java.lang.String getEmail() {
		return _busEmployee.getEmail();
	}

	/**
	* Sets the email of this bus employee.
	*
	* @param email the email of this bus employee
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_busEmployee.setEmail(email);
	}

	/**
	* Returns the license number of this bus employee.
	*
	* @return the license number of this bus employee
	*/
	@Override
	public java.lang.String getLicenseNumber() {
		return _busEmployee.getLicenseNumber();
	}

	/**
	* Sets the license number of this bus employee.
	*
	* @param licenseNumber the license number of this bus employee
	*/
	@Override
	public void setLicenseNumber(java.lang.String licenseNumber) {
		_busEmployee.setLicenseNumber(licenseNumber);
	}

	/**
	* Returns the alternate ID number of this bus employee.
	*
	* @return the alternate ID number of this bus employee
	*/
	@Override
	public java.lang.String getAlternateIdNumber() {
		return _busEmployee.getAlternateIdNumber();
	}

	/**
	* Sets the alternate ID number of this bus employee.
	*
	* @param alternateIdNumber the alternate ID number of this bus employee
	*/
	@Override
	public void setAlternateIdNumber(java.lang.String alternateIdNumber) {
		_busEmployee.setAlternateIdNumber(alternateIdNumber);
	}

	/**
	* Returns the active of this bus employee.
	*
	* @return the active of this bus employee
	*/
	@Override
	public boolean getActive() {
		return _busEmployee.getActive();
	}

	/**
	* Returns <code>true</code> if this bus employee is active.
	*
	* @return <code>true</code> if this bus employee is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _busEmployee.isActive();
	}

	/**
	* Sets whether this bus employee is active.
	*
	* @param active the active of this bus employee
	*/
	@Override
	public void setActive(boolean active) {
		_busEmployee.setActive(active);
	}

	/**
	* Returns the create date of this bus employee.
	*
	* @return the create date of this bus employee
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _busEmployee.getCreateDate();
	}

	/**
	* Sets the create date of this bus employee.
	*
	* @param createDate the create date of this bus employee
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_busEmployee.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this bus employee.
	*
	* @return the modified date of this bus employee
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _busEmployee.getModifiedDate();
	}

	/**
	* Sets the modified date of this bus employee.
	*
	* @param modifiedDate the modified date of this bus employee
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_busEmployee.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _busEmployee.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_busEmployee.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _busEmployee.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_busEmployee.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _busEmployee.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _busEmployee.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_busEmployee.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _busEmployee.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_busEmployee.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_busEmployee.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_busEmployee.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BusEmployeeWrapper((BusEmployee)_busEmployee.clone());
	}

	@Override
	public int compareTo(com.services.model.BusEmployee busEmployee) {
		return _busEmployee.compareTo(busEmployee);
	}

	@Override
	public int hashCode() {
		return _busEmployee.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.services.model.BusEmployee> toCacheModel() {
		return _busEmployee.toCacheModel();
	}

	@Override
	public com.services.model.BusEmployee toEscapedModel() {
		return new BusEmployeeWrapper(_busEmployee.toEscapedModel());
	}

	@Override
	public com.services.model.BusEmployee toUnescapedModel() {
		return new BusEmployeeWrapper(_busEmployee.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _busEmployee.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _busEmployee.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_busEmployee.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BusEmployeeWrapper)) {
			return false;
		}

		BusEmployeeWrapper busEmployeeWrapper = (BusEmployeeWrapper)obj;

		if (Validator.equals(_busEmployee, busEmployeeWrapper._busEmployee)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BusEmployee getWrappedBusEmployee() {
		return _busEmployee;
	}

	@Override
	public BusEmployee getWrappedModel() {
		return _busEmployee;
	}

	@Override
	public void resetOriginalValues() {
		_busEmployee.resetOriginalValues();
	}

	private BusEmployee _busEmployee;
}