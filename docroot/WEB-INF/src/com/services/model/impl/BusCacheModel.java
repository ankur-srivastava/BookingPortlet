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

import com.services.model.Bus;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Bus in entity cache.
 *
 * @author Ankur Srivastava
 * @see Bus
 * @generated
 */
public class BusCacheModel implements CacheModel<Bus>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{busId=");
		sb.append(busId);
		sb.append(", busName=");
		sb.append(busName);
		sb.append(", agency=");
		sb.append(agency);
		sb.append(", driver=");
		sb.append(driver);
		sb.append(", conductor=");
		sb.append(conductor);
		sb.append(", helper=");
		sb.append(helper);
		sb.append(", plateNumber=");
		sb.append(plateNumber);
		sb.append(", color=");
		sb.append(color);
		sb.append(", make=");
		sb.append(make);
		sb.append(", model=");
		sb.append(model);
		sb.append(", year=");
		sb.append(year);
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
	public Bus toEntityModel() {
		BusImpl busImpl = new BusImpl();

		busImpl.setBusId(busId);

		if (busName == null) {
			busImpl.setBusName(StringPool.BLANK);
		}
		else {
			busImpl.setBusName(busName);
		}

		busImpl.setAgency(agency);
		busImpl.setDriver(driver);
		busImpl.setConductor(conductor);
		busImpl.setHelper(helper);

		if (plateNumber == null) {
			busImpl.setPlateNumber(StringPool.BLANK);
		}
		else {
			busImpl.setPlateNumber(plateNumber);
		}

		if (color == null) {
			busImpl.setColor(StringPool.BLANK);
		}
		else {
			busImpl.setColor(color);
		}

		if (make == null) {
			busImpl.setMake(StringPool.BLANK);
		}
		else {
			busImpl.setMake(make);
		}

		if (model == null) {
			busImpl.setModel(StringPool.BLANK);
		}
		else {
			busImpl.setModel(model);
		}

		if (year == null) {
			busImpl.setYear(StringPool.BLANK);
		}
		else {
			busImpl.setYear(year);
		}

		busImpl.setActive(active);

		if (createDate == Long.MIN_VALUE) {
			busImpl.setCreateDate(null);
		}
		else {
			busImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			busImpl.setModifiedDate(null);
		}
		else {
			busImpl.setModifiedDate(new Date(modifiedDate));
		}

		busImpl.resetOriginalValues();

		return busImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		busId = objectInput.readLong();
		busName = objectInput.readUTF();
		agency = objectInput.readLong();
		driver = objectInput.readLong();
		conductor = objectInput.readLong();
		helper = objectInput.readLong();
		plateNumber = objectInput.readUTF();
		color = objectInput.readUTF();
		make = objectInput.readUTF();
		model = objectInput.readUTF();
		year = objectInput.readUTF();
		active = objectInput.readBoolean();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(busId);

		if (busName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(busName);
		}

		objectOutput.writeLong(agency);
		objectOutput.writeLong(driver);
		objectOutput.writeLong(conductor);
		objectOutput.writeLong(helper);

		if (plateNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(plateNumber);
		}

		if (color == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(color);
		}

		if (make == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(make);
		}

		if (model == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(model);
		}

		if (year == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(year);
		}

		objectOutput.writeBoolean(active);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long busId;
	public String busName;
	public long agency;
	public long driver;
	public long conductor;
	public long helper;
	public String plateNumber;
	public String color;
	public String make;
	public String model;
	public String year;
	public boolean active;
	public long createDate;
	public long modifiedDate;
}