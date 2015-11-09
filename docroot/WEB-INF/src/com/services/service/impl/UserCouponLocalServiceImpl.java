/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.services.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.services.model.UserCoupon;
import com.services.service.base.UserCouponLocalServiceBaseImpl;

/**
 * The implementation of the user coupon local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.services.service.UserCouponLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ankur Srivastava
 * @see com.services.service.base.UserCouponLocalServiceBaseImpl
 * @see com.services.service.UserCouponLocalServiceUtil
 */
public class UserCouponLocalServiceImpl extends UserCouponLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.services.service.UserCouponLocalServiceUtil} to access the user coupon local service.
	 */
	public UserCoupon getValidUserCoupon(long userId, long couponId){
		UserCoupon userCoupon = null;
		List<UserCoupon> userCouponList = null;
		try {
			userCouponList = userCouponPersistence.findByUserCouponId(userId, couponId);
		} catch (SystemException e) {
			
		}
		if(userCouponList != null && userCouponList.size() > 0){
			userCoupon = userCouponList.get(0);
		}
		return userCoupon;
	}
}