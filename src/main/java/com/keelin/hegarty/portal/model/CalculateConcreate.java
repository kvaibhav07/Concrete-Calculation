package com.keelin.hegarty.portal.model;

import java.io.Serializable;

public class CalculateConcreate implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private double height;
	private double length;
	private double thickness;
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getThickness() {
		return thickness;
	}
	public void setThickness(double thickness) {
		this.thickness = thickness;
	}
	@Override
	public String toString() {
		return "CalculateConcreate [height=" + height + ", length=" + length + ", thickness=" + thickness + "]";
	}
}
