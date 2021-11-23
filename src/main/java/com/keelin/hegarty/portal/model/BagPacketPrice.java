package com.keelin.hegarty.portal.model;

import java.io.Serializable;

public class BagPacketPrice implements Serializable{

	private static final long serialVersionUID = 1L;

	private String bagPacketName;
	private double bagPacketCount;
	private double bagPacketPrice;
	
	public String getBagPacketName() {
		return bagPacketName;
	}
	public void setBagPacketName(String bagPacketName) {
		this.bagPacketName = bagPacketName;
	}
	public double getBagPacketCount() {
		return bagPacketCount;
	}
	public void setBagPacketCount(double bagPacketCount) {
		this.bagPacketCount = bagPacketCount;
	}
	public double getBagPacketPrice() {
		return bagPacketPrice;
	}
	public void setBagPacketPrice(double bagPacketPrice) {
		this.bagPacketPrice = bagPacketPrice;
	}
}
