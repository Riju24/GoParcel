package com.spring.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.bo.CourierBO;
import com.spring.exception.InvalidParcelWeightException;
import com.spring.model.Courier;

public class CourierService {
	
	private CourierBO cBoObj;

	public CourierBO getcBoObj() {
		return cBoObj;
	}

	public void setcBoObj(CourierBO cBoObj) {
		this.cBoObj = cBoObj;
	}
	
	public double calculateCourierCharge(int courierId,int weight,String city) throws InvalidParcelWeightException{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Courier courier = (Courier) context.getBean("courier");
		courier.setCourierId(courierId);
		courier.setWeight(weight);
		courier.setChargePerKg((float) 20.0);;
		double courierCharge=0.0;
		
		if(weight<0 || weight>1000)
		{
			throw new InvalidParcelWeightException("Invalid Parcel Weight");
		}
	
		courierCharge = cBoObj.calculateCourierCharge(courier, city);
			
		
		
		return courierCharge;
	}

}
