package com.spring.bo;

import com.spring.model.Courier;
import java.util.*;
import java.util.Map.Entry;
public class CourierBO  {
	
	public double calculateCourierCharge(Courier cObj,String city) {
	   
		
		double courierCharge=0.0;
		//fill the code
		int flag=0;
		float value= (float) 0.0;
		courierCharge = cObj.getWeight()*cObj.getChargePerKg();
		
		Map<String, Float> v1 = cObj.getServiceCharge().getLocationServiceCharge();
		
		for (Entry<String, Float> entry : v1.entrySet())  
		{
			if(entry.getKey().contentEquals(city))
			{
				flag = 1;
				value = entry.getValue();
				courierCharge = courierCharge + value;
			}
			
		}  
		
	    return courierCharge;
	}

}
