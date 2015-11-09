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

import com.services.model.Coupon;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Coupon in entity cache.
 *
 * @author Ankur Srivastava
 * @see Coupon
 * @generated
 */
public class CouponCacheModel implements CacheModel<Coupon>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{couponId=");
		sb.append(couponId);
		sb.append(", couponName=");
		sb.append(couponName);
		sb.append(", price=");
		sb.append(price);
		sb.append(", validTill=");
		sb.append(validTill);
		sb.append(", audience=");
		sb.append(audience);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Coupon toEntityModel() {
		CouponImpl couponImpl = new CouponImpl();

		couponImpl.setCouponId(couponId);

		if (couponName == null) {
			couponImpl.setCouponName(StringPool.BLANK);
		}
		else {
			couponImpl.setCouponName(couponName);
		}

		couponImpl.setPrice(price);

		if (validTill == Long.MIN_VALUE) {
			couponImpl.setValidTill(null);
		}
		else {
			couponImpl.setValidTill(new Date(validTill));
		}

		couponImpl.setAudience(audience);

		if (createDate == Long.MIN_VALUE) {
			couponImpl.setCreateDate(null);
		}
		else {
			couponImpl.setCreateDate(new Date(createDate));
		}

		couponImpl.resetOriginalValues();

		return couponImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		couponId = objectInput.readLong();
		couponName = objectInput.readUTF();
		price = objectInput.readLong();
		validTill = objectInput.readLong();
		audience = objectInput.readBoolean();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(couponId);

		if (couponName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(couponName);
		}

		objectOutput.writeLong(price);
		objectOutput.writeLong(validTill);
		objectOutput.writeBoolean(audience);
		objectOutput.writeLong(createDate);
	}

	public long couponId;
	public String couponName;
	public long price;
	public long validTill;
	public boolean audience;
	public long createDate;
}