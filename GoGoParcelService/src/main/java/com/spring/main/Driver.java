package com.spring.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.exception.InvalidParcelWeightException;
import com.spring.service.CourierService;

public class Driver {

	public static void main(String[] args) throws IOException {
	    
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		CourierService courierService = (CourierService) context.getBean("courierService");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the courier ID");
		int id = Integer.parseInt(br.readLine());
		System.out.println("Enter the weight of parcel");
		int weight = Integer.parseInt(br.readLine());
		System.out.println("Enter the city");
		String city = br.readLine();
		
		try {
		System.out.println("Total Courier Charge :" + courierService.calculateCourierCharge(id,weight,city));
		}
		catch(InvalidParcelWeightException e)
		{
			System.out.println(e);
		}
	}

}
