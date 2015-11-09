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

package com.services.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.services.model.BusRoute;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BusRoute in entity cache.
 *
 * @author Ankur Srivastava
 * @see BusRoute
 * @generated
 */
public class BusRouteCacheModel implements CacheModel<BusRoute>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{brId=");
		sb.append(brId);
		sb.append(", busId=");
		sb.append(busId);
		sb.append(", startLocation=");
		sb.append(startLocation);
		sb.append(", endLocation=");
		sb.append(endLocation);
		sb.append(", midLocation1=");
		sb.append(midLocation1);
		sb.append(", midLocation2=");
		sb.append(midLocation2);
		sb.append(", active=");
		sb.append(active);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BusRoute toEntityModel() {
		BusRouteImpl busRouteImpl = new BusRouteImpl();

		busRouteImpl.setBrId(brId);
		busRouteImpl.setBusId(busId);
		busRouteImpl.setStartLocation(startLocation);
		busRouteImpl.setEndLocation(endLocation);
		busRouteImpl.setMidLocation1(midLocation1);
		busRouteImpl.setMidLocation2(midLocation2);
		busRouteImpl.setActive(active);

		if (createDate == Long.MIN_VALUE) {
			busRouteImpl.setCreateDate(null);
		}
		else {
			busRouteImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			busRouteImpl.setModifiedDate(null);
		}
		else {
			busRouteImpl.setModifiedDate(new Date(modifiedDate));
		}

		busRouteImpl.resetOriginalValues();

		return busRouteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		brId = objectInput.readLong();
		busId = objectInput.readLong();
		startLocation = objectInput.readLong();
		endLocation = objectInput.readLong();
		midLocation1 = objectInput.readLong();
		midLocation2 = objectInput.readLong();
		active = objectInput.readBoolean();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(brId);
		objectOutput.writeLong(busId);
		objectOutput.writeLong(startLocation);
		objectOutput.writeLong(endLocation);
		objectOutput.writeLong(midLocation1);
		objectOutput.writeLong(midLocation2);
		objectOutput.writeBoolean(active);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long brId;
	public long busId;
	public long startLocation;
	public long endLocation;
	public long midLocation1;
	public long midLocation2;
	public boolean active;
	public long createDate;
	public long modifiedDate;
}