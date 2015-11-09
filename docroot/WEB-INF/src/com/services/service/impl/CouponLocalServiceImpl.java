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
import com.services.model.Coupon;
import com.services.service.base.CouponLocalServiceBaseImpl;

/**
 * The implementation of the coupon local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.services.service.CouponLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ankur Srivastava
 * @see com.services.service.base.CouponLocalServiceBaseImpl
 * @see com.services.service.CouponLocalServiceUtil
 */
public class CouponLocalServiceImpl extends CouponLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.services.service.CouponLocalServiceUtil} to access the coupon local service.
	 */
	
	public Coupon getCouponByName(String name){
		Coupon coupon = null;
		List<Coupon> couponList = null;
		try {
			couponList = couponPersistence.findByCouponName(name);
		} catch (SystemException e) {
			
		}
		if(couponList != null && couponList.size() > 0){
			coupon = couponList.get(0);
		}
		return coupon;
	}
}