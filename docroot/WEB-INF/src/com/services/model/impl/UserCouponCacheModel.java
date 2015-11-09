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

import com.services.model.UserCoupon;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserCoupon in entity cache.
 *
 * @author Ankur Srivastava
 * @see UserCoupon
 * @generated
 */
public class UserCouponCacheModel implements CacheModel<UserCoupon>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{ucId=");
		sb.append(ucId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", couponId=");
		sb.append(couponId);
		sb.append(", claimed=");
		sb.append(claimed);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserCoupon toEntityModel() {
		UserCouponImpl userCouponImpl = new UserCouponImpl();

		userCouponImpl.setUcId(ucId);
		userCouponImpl.setUserId(userId);
		userCouponImpl.setCouponId(couponId);
		userCouponImpl.setClaimed(claimed);

		if (createDate == Long.MIN_VALUE) {
			userCouponImpl.setCreateDate(null);
		}
		else {
			userCouponImpl.setCreateDate(new Date(createDate));
		}

		userCouponImpl.resetOriginalValues();

		return userCouponImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ucId = objectInput.readLong();
		userId = objectInput.readLong();
		couponId = objectInput.readLong();
		claimed = objectInput.readBoolean();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ucId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(couponId);
		objectOutput.writeBoolean(claimed);
		objectOutput.writeLong(createDate);
	}

	public long ucId;
	public long userId;
	public long couponId;
	public boolean claimed;
	public long createDate;
}