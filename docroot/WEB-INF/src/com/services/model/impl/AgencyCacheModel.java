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

import com.services.model.Agency;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Agency in entity cache.
 *
 * @author Ankur Srivastava
 * @see Agency
 * @generated
 */
public class AgencyCacheModel implements CacheModel<Agency>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{agencyId=");
		sb.append(agencyId);
		sb.append(", agencyName=");
		sb.append(agencyName);
		sb.append(", owner=");
		sb.append(owner);
		sb.append(", contactNumber=");
		sb.append(contactNumber);
		sb.append(", email=");
		sb.append(email);
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
	public Agency toEntityModel() {
		AgencyImpl agencyImpl = new AgencyImpl();

		agencyImpl.setAgencyId(agencyId);

		if (agencyName == null) {
			agencyImpl.setAgencyName(StringPool.BLANK);
		}
		else {
			agencyImpl.setAgencyName(agencyName);
		}

		if (owner == null) {
			agencyImpl.setOwner(StringPool.BLANK);
		}
		else {
			agencyImpl.setOwner(owner);
		}

		if (contactNumber == null) {
			agencyImpl.setContactNumber(StringPool.BLANK);
		}
		else {
			agencyImpl.setContactNumber(contactNumber);
		}

		if (email == null) {
			agencyImpl.setEmail(StringPool.BLANK);
		}
		else {
			agencyImpl.setEmail(email);
		}

		agencyImpl.setActive(active);

		if (createDate == Long.MIN_VALUE) {
			agencyImpl.setCreateDate(null);
		}
		else {
			agencyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			agencyImpl.setModifiedDate(null);
		}
		else {
			agencyImpl.setModifiedDate(new Date(modifiedDate));
		}

		agencyImpl.resetOriginalValues();

		return agencyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		agencyId = objectInput.readLong();
		agencyName = objectInput.readUTF();
		owner = objectInput.readUTF();
		contactNumber = objectInput.readUTF();
		email = objectInput.readUTF();
		active = objectInput.readBoolean();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(agencyId);

		if (agencyName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(agencyName);
		}

		if (owner == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(owner);
		}

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

		objectOutput.writeBoolean(active);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long agencyId;
	public String agencyName;
	public String owner;
	public String contactNumber;
	public String email;
	public boolean active;
	public long createDate;
	public long modifiedDate;
}