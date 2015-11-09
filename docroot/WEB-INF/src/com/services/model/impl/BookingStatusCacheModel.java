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

import com.services.model.BookingStatus;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BookingStatus in entity cache.
 *
 * @author Ankur Srivastava
 * @see BookingStatus
 * @generated
 */
public class BookingStatusCacheModel implements CacheModel<BookingStatus>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{bsId=");
		sb.append(bsId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", brtId=");
		sb.append(brtId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", tripStatus=");
		sb.append(tripStatus);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BookingStatus toEntityModel() {
		BookingStatusImpl bookingStatusImpl = new BookingStatusImpl();

		bookingStatusImpl.setBsId(bsId);
		bookingStatusImpl.setUserId(userId);
		bookingStatusImpl.setBrtId(brtId);

		if (status == null) {
			bookingStatusImpl.setStatus(StringPool.BLANK);
		}
		else {
			bookingStatusImpl.setStatus(status);
		}

		if (tripStatus == null) {
			bookingStatusImpl.setTripStatus(StringPool.BLANK);
		}
		else {
			bookingStatusImpl.setTripStatus(tripStatus);
		}

		if (createDate == Long.MIN_VALUE) {
			bookingStatusImpl.setCreateDate(null);
		}
		else {
			bookingStatusImpl.setCreateDate(new Date(createDate));
		}

		bookingStatusImpl.resetOriginalValues();

		return bookingStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bsId = objectInput.readLong();
		userId = objectInput.readLong();
		brtId = objectInput.readLong();
		status = objectInput.readUTF();
		tripStatus = objectInput.readUTF();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(bsId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(brtId);

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (tripStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tripStatus);
		}

		objectOutput.writeLong(createDate);
	}

	public long bsId;
	public long userId;
	public long brtId;
	public String status;
	public String tripStatus;
	public long createDate;
}