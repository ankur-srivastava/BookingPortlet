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

import com.services.model.BusEmployee;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BusEmployee in entity cache.
 *
 * @author Ankur Srivastava
 * @see BusEmployee
 * @generated
 */
public class BusEmployeeCacheModel implements CacheModel<BusEmployee>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{beId=");
		sb.append(beId);
		sb.append(", beName=");
		sb.append(beName);
		sb.append(", agency=");
		sb.append(agency);
		sb.append(", contactNumber=");
		sb.append(contactNumber);
		sb.append(", email=");
		sb.append(email);
		sb.append(", licenseNumber=");
		sb.append(licenseNumber);
		sb.append(", alternateIdNumber=");
		sb.append(alternateIdNumber);
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
	public BusEmployee toEntityModel() {
		BusEmployeeImpl busEmployeeImpl = new BusEmployeeImpl();

		busEmployeeImpl.setBeId(beId);

		if (beName == null) {
			busEmployeeImpl.setBeName(StringPool.BLANK);
		}
		else {
			busEmployeeImpl.setBeName(beName);
		}

		busEmployeeImpl.setAgency(agency);

		if (contactNumber == null) {
			busEmployeeImpl.setContactNumber(StringPool.BLANK);
		}
		else {
			busEmployeeImpl.setContactNumber(contactNumber);
		}

		if (email == null) {
			busEmployeeImpl.setEmail(StringPool.BLANK);
		}
		else {
			busEmployeeImpl.setEmail(email);
		}

		if (licenseNumber == null) {
			busEmployeeImpl.setLicenseNumber(StringPool.BLANK);
		}
		else {
			busEmployeeImpl.setLicenseNumber(licenseNumber);
		}

		if (alternateIdNumber == null) {
			busEmployeeImpl.setAlternateIdNumber(StringPool.BLANK);
		}
		else {
			busEmployeeImpl.setAlternateIdNumber(alternateIdNumber);
		}

		busEmployeeImpl.setActive(active);

		if (createDate == Long.MIN_VALUE) {
			busEmployeeImpl.setCreateDate(null);
		}
		else {
			busEmployeeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			busEmployeeImpl.setModifiedDate(null);
		}
		else {
			busEmployeeImpl.setModifiedDate(new Date(modifiedDate));
		}

		busEmployeeImpl.resetOriginalValues();

		return busEmployeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		beId = objectInput.readLong();
		beName = objectInput.readUTF();
		agency = objectInput.readLong();
		contactNumber = objectInput.readUTF();
		email = objectInput.readUTF();
		licenseNumber = objectInput.readUTF();
		alternateIdNumber = objectInput.readUTF();
		active = objectInput.readBoolean();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(beId);

		if (beName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(beName);
		}

		objectOutput.writeLong(agency);

		if (contactNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactNumber);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (licenseNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(licenseNumber);
		}

		if (alternateIdNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(alternateIdNumber);
		}

		objectOutput.writeBoolean(active);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long beId;
	public String beName;
	public long agency;
	public String contactNumber;
	public String email;
	public String licenseNumber;
	public String alternateIdNumber;
	public boolean active;
	public long createDate;
	public long modifiedDate;
}