package com.keelin.hegarty.portal.business;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.keelin.hegarty.portal.constant.BagSizePacket;
import com.keelin.hegarty.portal.model.BagPacketPrice;
import com.keelin.hegarty.portal.model.CalculateConcreate;

@Component
public class CalculateConcreateBusinessImpl implements CalculateConcreateBusiness{
	
	private static final double INCH_CONVERT_VALUE = 12d;
	private static final double CUBIC_YARD_CONVERT_VALUE = .037;
	
	List<BagPacketPrice> list = new CopyOnWriteArrayList<BagPacketPrice>();

	@Override
	public List<BagPacketPrice> calculateCubicYardInches(CalculateConcreate calculateConcreate) {
		List<BagPacketPrice> list = new CopyOnWriteArrayList<BagPacketPrice>();
		if(calculateConcreate != null) {
			double heightLengthSquareFeet = calculateConcreate.getHeight() * calculateConcreate.getLength() ;
			double thicknessInFeet = calculateConcreate.getThickness() / INCH_CONVERT_VALUE;
			double cubicFeetValue = heightLengthSquareFeet * thicknessInFeet;
			System.out.println("Cube Feet Result : "+cubicFeetValue);
			double cubeYardValue = convertInchesToYard(cubicFeetValue);
			list.add(calculateBagCountAndPriceForFiftyLBS(cubeYardValue));
			list.add(calculateBagCountAndPriceForSixtyLBS(cubeYardValue));
			list.add(calculateBagCountAndPriceForEightyLBS(cubeYardValue));
		}
		return list;
	}

	@Override
	public double convertInchesToYard(double cubicFeetValue) {
		double cubicYardValue = 0;
		if(cubicFeetValue > 0) {
			cubicYardValue = cubicFeetValue * CUBIC_YARD_CONVERT_VALUE;
			System.out.println("Cube Yard Result : "+cubicYardValue);
		}
		return cubicYardValue;
	}
	
	@Override
	public BagPacketPrice calculateBagCountAndPriceForFiftyLBS(double cubeYardValue) {
		BagPacketPrice bagPacketPrice = null;
		if(cubeYardValue > 0) {
			bagPacketPrice = new BagPacketPrice();
			double fiftyYardPacketCount = cubeYardValue / BagSizePacket.FIFTY_LBS_PACKET_YARDS;
			double fiftyPacketPrice = fiftyYardPacketCount * BagSizePacket.FIFTY_LBS_PACKET_PRICE;
			bagPacketPrice.setBagPacketName(BagSizePacket.BAG_PACKET_FIFTY_LBS_NAME);
			bagPacketPrice.setBagPacketCount(Math.round(fiftyYardPacketCount));
			bagPacketPrice.setBagPacketPrice(Math.round(fiftyPacketPrice));
		}
		return bagPacketPrice;
	}
	
	@Override
	public BagPacketPrice calculateBagCountAndPriceForSixtyLBS(double cubeYardValue) {
		BagPacketPrice bagPacketPrice = null;
		if(cubeYardValue > 0) {
			bagPacketPrice = new BagPacketPrice();
			double sixtyYardPacketCount = cubeYardValue / BagSizePacket.SIXTY_LBS_PACKET_YARDS;
			double sixtyPacketPrice = sixtyYardPacketCount * BagSizePacket.SIXTY_LBS_PACKET_PRICE;
			bagPacketPrice.setBagPacketName(BagSizePacket.BAG_PACKET_SIXTY_LBS_NAME);
			bagPacketPrice.setBagPacketCount(Math.round(sixtyYardPacketCount));
			bagPacketPrice.setBagPacketPrice(Math.round(sixtyPacketPrice));
		}
		return bagPacketPrice;
	}

	@Override
	public BagPacketPrice calculateBagCountAndPriceForEightyLBS(double cubeYardValue) {
		BagPacketPrice bagPacketPrice = null;
		if(cubeYardValue > 0) {
			bagPacketPrice = new BagPacketPrice();
			double eightyYardPacketCount = cubeYardValue / BagSizePacket.EIGHTY_LBS_PACKET_YARDS;
			double eightyPacketPrice = eightyYardPacketCount * BagSizePacket.EIGHTY_LBS_PACKET_PRICE;
			bagPacketPrice.setBagPacketName(BagSizePacket.BAG_PACKET_EIGHTY_LBS_NAME);
			bagPacketPrice.setBagPacketCount(Math.round(eightyYardPacketCount));
			bagPacketPrice.setBagPacketPrice(Math.round(eightyPacketPrice));
		}
		return bagPacketPrice;
	}
	
	public static void main(String[] args) {
		CalculateConcreate calculateConcreate = new CalculateConcreate();
		calculateConcreate.setHeight(10);
		calculateConcreate.setLength(10);
		calculateConcreate.setThickness(4);
		CalculateConcreateBusinessImpl cal = new CalculateConcreateBusinessImpl();
		List<BagPacketPrice> lists = cal.calculateCubicYardInches(calculateConcreate);
		System.out.println(new Gson().toJson(lists));
	}
}
