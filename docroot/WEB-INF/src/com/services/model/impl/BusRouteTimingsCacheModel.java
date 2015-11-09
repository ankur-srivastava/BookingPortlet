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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.services.model.BusRouteTimings;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BusRouteTimings in entity cache.
 *
 * @author Ankur Srivastava
 * @see BusRouteTimings
 * @generated
 */
public class BusRouteTimingsCacheModel implements CacheModel<BusRouteTimings>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{brtId=");
		sb.append(brtId);
		sb.append(", brId=");
		sb.append(brId);
		sb.append(", busDetails=");
		sb.append(busDetails);
		sb.append(", travelDate=");
		sb.append(travelDate);
		sb.append(", travelTime=");
		sb.append(travelTime);
		sb.append(", total=");
		sb.append(total);
		sb.append(", available=");
		sb.append(available);
		sb.append(", price=");
		sb.append(price);
		sb.append(", active=");
		sb.append(active);
		sb.append(", completed=");
		sb.append(completed);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BusRouteTimings toEntityModel() {
		BusRouteTimingsImpl busRouteTimingsImpl = new BusRouteTimingsImpl();

		busRouteTimingsImpl.setBrtId(brtId);
		busRouteTimingsImpl.setBrId(brId);

		if (busDetails == null) {
			busRouteTimingsImpl.setBusDetails(StringPool.BLANK);
		}
		else {
			busRouteTimingsImpl.setBusDetails(busDetails);
		}

		if (travelDate == null) {
			busRouteTimingsImpl.setTravelDate(StringPool.BLANK);
		}
		else {
			busRouteTimingsImpl.setTravelDate(travelDate);
		}

		if (travelTime == null) {
			busRouteTimingsImpl.setTravelTime(StringPool.BLANK);
		}
		else {
			busRouteTimingsImpl.setTravelTime(travelTime);
		}

		busRouteTimingsImpl.setTotal(total);
		busRouteTimingsImpl.setAvailable(available);
		busRouteTimingsImpl.setPrice(price);
		busRouteTimingsImpl.setActive(active);

		if (completed == null) {
			busRouteTimingsImpl.setCompleted(StringPool.BLANK);
		}
		else {
			busRouteTimingsImpl.setCompleted(completed);
		}

		if (createDate == Long.MIN_VALUE) {
			busRouteTimingsImpl.setCreateDate(null);
		}
		else {
			busRouteTimingsImpl.setCreateDate(new Date(createDate));
		}

		busRouteTimingsImpl.resetOriginalValues();

		return busRouteTimingsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		brtId = objectInput.readLong();
		brId = objectInput.readLong();
		busDetails = objectInput.readUTF();
		travelDate = objectInput.readUTF();
		travelTime = objectInput.readUTF();
		total = objectInput.readLong();
		available = objectInput.readLong();
		price = objectInput.readLong();
		active = objectInput.readBoolean();
		completed = objectInput.readUTF();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(brtId);
		objectOutput.writeLong(brId);

		if (busDetails == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(busDetails);
		}

		if (travelDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(travelDate);
		}

		if (travelTime == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(travelTime);
		}

		objectOutput.writeLong(total);
		objectOutput.writeLong(available);
		objectOutput.writeLong(price);
		objectOutput.writeBoolean(active);

		if (completed == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(completed);
		}

		objectOutput.writeLong(createDate);
	}

	public long brtId;
	public long brId;
	public String busDetails;
	public String travelDate;
	public String travelTime;
	public long total;
	public long available;
	public long price;
	public boolean active;
	public String completed;
	public long createDate;
}