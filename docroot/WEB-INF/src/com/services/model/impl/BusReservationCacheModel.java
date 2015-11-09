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

import com.services.model.BusReservation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BusReservation in entity cache.
 *
 * @author Ankur Srivastava
 * @see BusReservation
 * @generated
 */
public class BusReservationCacheModel implements CacheModel<BusReservation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{brId=");
		sb.append(brId);
		sb.append(", baId=");
		sb.append(baId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", paymentReceived=");
		sb.append(paymentReceived);
		sb.append(", bookingDate=");
		sb.append(bookingDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BusReservation toEntityModel() {
		BusReservationImpl busReservationImpl = new BusReservationImpl();

		busReservationImpl.setBrId(brId);
		busReservationImpl.setBaId(baId);
		busReservationImpl.setUserId(userId);
		busReservationImpl.setPaymentReceived(paymentReceived);

		if (bookingDate == Long.MIN_VALUE) {
			busReservationImpl.setBookingDate(null);
		}
		else {
			busReservationImpl.setBookingDate(new Date(bookingDate));
		}

		busReservationImpl.resetOriginalValues();

		return busReservationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		brId = objectInput.readLong();
		baId = objectInput.readLong();
		userId = objectInput.readLong();
		paymentReceived = objectInput.readBoolean();
		bookingDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(brId);
		objectOutput.writeLong(baId);
		objectOutput.writeLong(userId);
		objectOutput.writeBoolean(paymentReceived);
		objectOutput.writeLong(bookingDate);
	}

	public long brId;
	public long baId;
	public long userId;
	public boolean paymentReceived;
	public long bookingDate;
}