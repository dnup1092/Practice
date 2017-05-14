package com.dnu.rest;

import java.io.Serializable;


public class ShipmentDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String trackingNumber;
	private int shipmentCode;
	/**
	 * @return the trackingNumber
	 */
	public String getTrackingNumber() {
		return trackingNumber;
	}
	/**
	 * @param trackingNumber the trackingNumber to set
	 */
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	/**
	 * @return the shipmentCode
	 */
	public int getShipmentCode() {
		return shipmentCode;
	}
	/**
	 * @param shipmentCode the shipmentCode to set
	 */
	public void setShipmentCode(int shipmentCode) {
		this.shipmentCode = shipmentCode;
	}
}
