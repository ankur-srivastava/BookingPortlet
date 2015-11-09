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

package com.services.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.services.model.BusAvailability;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BusAvailability in entity cache.
 *
 * @author Ankur Srivastava
 * @see BusAvailability
 * @generated
 */
public class BusAvailabilityCacheModel implements CacheModel<BusAvailability>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{baId=");
		sb.append(baId);
		sb.append(", brtId=");
		sb.append(brtId);
		sb.append(", total=");
		sb.append(total);
		sb.append(", available=");
		sb.append(available);
		sb.append(", price=");
		sb.append(price);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BusAvailability toEntityModel() {
		BusAvailabilityImpl busAvailabilityImpl = new BusAvailabilityImpl();

		busAvailabilityImpl.setBaId(baId);
		busAvailabilityImpl.setBrtId(brtId);
		busAvailabilityImpl.setTotal(total);
		busAvailabilityImpl.setAvailable(available);
		busAvailabilityImpl.setPrice(price);

		if (createDate == Long.MIN_VALUE) {
			busAvailabilityImpl.setCreateDate(null);
		}
		else {
			busAvailabilityImpl.setCreateDate(new Date(createDate));
		}

		busAvailabilityImpl.resetOriginalValues();

		return busAvailabilityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		baId = objectInput.readLong();
		brtId = objectInput.readLong();
		total = objectInput.readLong();
		available = objectInput.readLong();
		price = objectInput.readLong();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(baId);
		objectOutput.writeLong(brtId);
		objectOutput.writeLong(total);
		objectOutput.writeLong(available);
		objectOutput.writeLong(price);
		objectOutput.writeLong(createDate);
	}

	public long baId;
	public long brtId;
	public long total;
	public long available;
	public long price;
	public long createDate;
}