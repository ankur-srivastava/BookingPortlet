/**
 * 
 */
package com.ui.model;

/**
 * @author Ankur
 *
 */
public class Booking {
	
	private long brtId;
	private long userId;
	private double basePrice;
	private double totalPrice;
	private double taxPrice;
	private double couponAmount;
	private int quantity;
	
	
	public long getBrtId() {
		return brtId;
	}
	public void setBrtId(long brtId) {
		this.brtId = brtId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getTaxPrice() {
		return taxPrice;
	}
	public void setTaxPrice(double taxPrice) {
		this.taxPrice = taxPrice;
	}
	public double getCouponAmount() {
		return couponAmount;
	}
	public void setCouponAmount(double couponAmount) {
		this.couponAmount = couponAmount;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
