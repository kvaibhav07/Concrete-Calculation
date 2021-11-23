package com.keelin.hegarty.portal.business;

import java.util.List;

import com.keelin.hegarty.portal.model.BagPacketPrice;
import com.keelin.hegarty.portal.model.CalculateConcreate;

public interface CalculateConcreateBusiness {

	public List<BagPacketPrice> calculateCubicYardInches(CalculateConcreate calculateConcreate);
	
	public double convertInchesToYard(double cubicInchesValue);
	
	public BagPacketPrice calculateBagCountAndPriceForFiftyLBS(double cubeYardValue);
	
	public BagPacketPrice calculateBagCountAndPriceForSixtyLBS(double cubeYardValue);
	
	public BagPacketPrice calculateBagCountAndPriceForEightyLBS(double cubeYardValue);
}
