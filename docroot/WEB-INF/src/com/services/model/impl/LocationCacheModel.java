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

import com.services.model.Location;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Location in entity cache.
 *
 * @author Ankur Srivastava
 * @see Location
 * @generated
 */
public class LocationCacheModel implements CacheModel<Location>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{locationId=");
		sb.append(locationId);
		sb.append(", locationName=");
		sb.append(locationName);
		sb.append(", streetAddress1=");
		sb.append(streetAddress1);
		sb.append(", streetAddress2=");
		sb.append(streetAddress2);
		sb.append(", locationZip=");
		sb.append(locationZip);
		sb.append(", locationCityName=");
		sb.append(locationCityName);
		sb.append(", locationStateName=");
		sb.append(locationStateName);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", comments=");
		sb.append(comments);
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
	public Location toEntityModel() {
		LocationImpl locationImpl = new LocationImpl();

		locationImpl.setLocationId(locationId);

		if (locationName == null) {
			locationImpl.setLocationName(StringPool.BLANK);
		}
		else {
			locationImpl.setLocationName(locationName);
		}

		if (streetAddress1 == null) {
			locationImpl.setStreetAddress1(StringPool.BLANK);
		}
		else {
			locationImpl.setStreetAddress1(streetAddress1);
		}

		if (streetAddress2 == null) {
			locationImpl.setStreetAddress2(StringPool.BLANK);
		}
		else {
			locationImpl.setStreetAddress2(streetAddress2);
		}

		if (locationZip == null) {
			locationImpl.setLocationZip(StringPool.BLANK);
		}
		else {
			locationImpl.setLocationZip(locationZip);
		}

		if (locationCityName == null) {
			locationImpl.setLocationCityName(StringPool.BLANK);
		}
		else {
			locationImpl.setLocationCityName(locationCityName);
		}

		if (locationStateName == null) {
			locationImpl.setLocationStateName(StringPool.BLANK);
		}
		else {
			locationImpl.setLocationStateName(locationStateName);
		}

		if (latitude == null) {
			locationImpl.setLatitude(StringPool.BLANK);
		}
		else {
			locationImpl.setLatitude(latitude);
		}

		if (longitude == null) {
			locationImpl.setLongitude(StringPool.BLANK);
		}
		else {
			locationImpl.setLongitude(longitude);
		}

		if (comments == null) {
			locationImpl.setComments(StringPool.BLANK);
		}
		else {
			locationImpl.setComments(comments);
		}

		locationImpl.setActive(active);

		if (createDate == Long.MIN_VALUE) {
			locationImpl.setCreateDate(null);
		}
		else {
			locationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			locationImpl.setModifiedDate(null);
		}
		else {
			locationImpl.setModifiedDate(new Date(modifiedDate));
		}

		locationImpl.resetOriginalValues();

		return locationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		locationId = objectInput.readLong();
		locationName = objectInput.readUTF();
		streetAddress1 = objectInput.readUTF();
		streetAddress2 = objectInput.readUTF();
		locationZip = objectInput.readUTF();
		locationCityName = objectInput.readUTF();
		locationStateName = objectInput.readUTF();
		latitude = objectInput.readUTF();
		longitude = objectInput.readUTF();
		comments = objectInput.readUTF();
		active = objectInput.readBoolean();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(locationId);

		if (locationName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(locationName);
		}

		if (streetAddress1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(streetAddress1);
		}

		if (streetAddress2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(streetAddress2);
		}

		if (locationZip == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(locationZip);
		}

		if (locationCityName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(locationCityName);
		}

		if (locationStateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(locationStateName);
		}

		if (latitude == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(latitude);
		}

		if (longitude == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(longitude);
		}

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		objectOutput.writeBoolean(active);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long locationId;
	public String locationName;
	public String streetAddress1;
	public String streetAddress2;
	public String locationZip;
	public String locationCityName;
	public String locationStateName;
	public String latitude;
	public String longitude;
	public String comments;
	public boolean active;
	public long createDate;
	public long modifiedDate;
}