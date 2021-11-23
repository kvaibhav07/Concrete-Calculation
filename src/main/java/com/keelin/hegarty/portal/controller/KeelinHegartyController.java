package com.keelin.hegarty.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.keelin.hegarty.portal.business.CalculateConcreateBusiness;
import com.keelin.hegarty.portal.model.CalculateConcreate;

@RestController
@RequestMapping("/webservice")
public class KeelinHegartyController {
	
	@Autowired
	private CalculateConcreateBusiness calculateConcreateBusiness;

	@GetMapping("/health")
    public String health() {
        return "Successfully running application";
    }
	
	@GetMapping("/concreateestimation")
	public String calculateConcreateEstimate(@RequestParam(required = false, defaultValue = "") String height, 
			@RequestParam(required = false, defaultValue = "") String length, @RequestParam(required = false, defaultValue = "") String thickness) {
		String response = "";
		//if(height > 0 && length > 0 && thickness > 0) {
			CalculateConcreate calculateConcreate = new CalculateConcreate();
			calculateConcreate.setHeight(Double.valueOf(height));
			calculateConcreate.setLength(Double.valueOf(length));
			calculateConcreate.setThickness(Double.valueOf(thickness));
			
			response = new Gson().toJson(calculateConcreateBusiness.calculateCubicYardInches(calculateConcreate));
		//}
		return response;
	}
}
