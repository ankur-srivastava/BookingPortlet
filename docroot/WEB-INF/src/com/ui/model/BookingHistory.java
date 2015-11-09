/**
 * 
 */
package com.ui.model;

import java.util.Date;

/**
 * @author SRIVASTAVAA
 *
 */
public class BookingHistory {
	
	private long bsId;
	private long userId;
	private long brtId;
	private String paymentStatus;
	private Date createDate;
	private String route;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public long getBrtId() {
		return brtId;
	}
	public void setBrtId(long brtId) {
		this.brtId = brtId;
	}
	public long getBsId() {
		return bsId;
	}
	public void setBsId(long bsId) {
		this.bsId = bsId;
	}
}
