/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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
 * This class is a wrapper for {@link BusAvailability}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusAvailability
 * @generated
 */
public class BusAvailabilityWrapper implements BusAvailability,
	ModelWrapper<BusAvailability> {
	public BusAvailabilityWrapper(BusAvailability busAvailability) {
		_busAvailability = busAvailability;
	}

	@Override
	public Class<?> getModelClass() {
		return BusAvailability.class;
	}

	@Override
	public String getModelClassName() {
		return BusAvailability.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("baId", getBaId());
		attributes.put("brtId", getBrtId());
		attributes.put("total", getTotal());
		attributes.put("available", getAvailable());
		attributes.put("price", getPrice());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long baId = (Long)attributes.get("baId");

		if (baId != null) {
			setBaId(baId);
		}

		Long brtId = (Long)attributes.get("brtId");

		if (brtId != null) {
			setBrtId(brtId);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	/**
	* Returns the primary key of this bus availability.
	*
	* @return the primary key of this bus availability
	*/
	@Override
	public long getPrimaryKey() {
		return _busAvailability.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bus availability.
	*
	* @param primaryKey the primary key of this bus availability
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_busAvailability.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ba ID of this bus availability.
	*
	* @return the ba ID of this bus availability
	*/
	@Override
	public long getBaId() {
		return _busAvailability.getBaId();
	}

	/**
	* Sets the ba ID of this bus availability.
	*
	* @param baId the ba ID of this bus availability
	*/
	@Override
	public void setBaId(long baId) {
		_busAvailability.setBaId(baId);
	}

	/**
	* Returns the brt ID of this bus availability.
	*
	* @return the brt ID of this bus availability
	*/
	@Override
	public long getBrtId() {
		return _busAvailability.getBrtId();
	}

	/**
	* Sets the brt ID of this bus availability.
	*
	* @param brtId the brt ID of this bus availability
	*/
	@Override
	public void setBrtId(long brtId) {
		_busAvailability.setBrtId(brtId);
	}

	/**
	* Returns the total of this bus availability.
	*
	* @return the total of this bus availability
	*/
	@Override
	public long getTotal() {
		return _busAvailability.getTotal();
	}

	/**
	* Sets the total of this bus availability.
	*
	* @param total the total of this bus availability
	*/
	@Override
	public void setTotal(long total) {
		_busAvailability.setTotal(total);
	}

	/**
	* Returns the available of this bus availability.
	*
	* @return the available of this bus availability
	*/
	@Override
	public long getAvailable() {
		return _busAvailability.getAvailable();
	}

	/**
	* Sets the available of this bus availability.
	*
	* @param available the available of this bus availability
	*/
	@Override
	public void setAvailable(long available) {
		_busAvailability.setAvailable(available);
	}

	/**
	* Returns the price of this bus availability.
	*
	* @return the price of this bus availability
	*/
	@Override
	public long getPrice() {
		return _busAvailability.getPrice();
	}

	/**
	* Sets the price of this bus availability.
	*
	* @param price the price of this bus availability
	*/
	@Override
	public void setPrice(long price) {
		_busAvailability.setPrice(price);
	}

	/**
	* Returns the create date of this bus availability.
	*
	* @return the create date of this bus availability
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _busAvailability.getCreateDate();
	}

	/**
	* Sets the create date of this bus availability.
	*
	* @param createDate the create date of this bus availability
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_busAvailability.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _busAvailability.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_busAvailability.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _busAvailability.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_busAvailability.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _busAvailability.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _busAvailability.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_busAvailability.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _busAvailability.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_busAvailability.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_busAvailability.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_busAvailability.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BusAvailabilityWrapper((BusAvailability)_busAvailability.clone());
	}

	@Override
	public int compareTo(com.services.model.BusAvailability busAvailability) {
		return _busAvailability.compareTo(busAvailability);
	}

	@Override
	public int hashCode() {
		return _busAvailability.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.services.model.BusAvailability> toCacheModel() {
		return _busAvailability.toCacheModel();
	}

	@Override
	public com.services.model.BusAvailability toEscapedModel() {
		return new BusAvailabilityWrapper(_busAvailability.toEscapedModel());
	}

	@Override
	public com.services.model.BusAvailability toUnescapedModel() {
		return new BusAvailabilityWrapper(_busAvailability.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _busAvailability.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _busAvailability.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_busAvailability.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BusAvailabilityWrapper)) {
			return false;
		}

		BusAvailabilityWrapper busAvailabilityWrapper = (BusAvailabilityWrapper)obj;

		if (Validator.equals(_busAvailability,
					busAvailabilityWrapper._busAvailability)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BusAvailability getWrappedBusAvailability() {
		return _busAvailability;
	}

	@Override
	public BusAvailability getWrappedModel() {
		return _busAvailability;
	}

	@Override
	public void resetOriginalValues() {
		_busAvailability.resetOriginalValues();
	}

	private BusAvailability _busAvailability;
}