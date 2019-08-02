package com.visa.prj.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.visa.prj.entity.RTODb;
import com.visa.prj.entity.Vehicle;

public class VehicleClient {

	public static void main(String args[])
	{
		List<Vehicle> areas = new ArrayList();
		Scanner sc = new Scanner(System.in); 
			
		
		areas.add(new Vehicle("KA-55-AB-4555"));
		areas.add(new Vehicle("KA-01-EF-4444"));
		areas.add(new Vehicle("KA-04-AB-9000"));
		areas.add(new Vehicle("KA-56-200"));
		areas.add(new Vehicle("KA-50-T-3111"));
		areas.add(new Vehicle("KA-02-AG-9243"));
		
		//System.out.println(areas.get(0).getRegno().substring(0, 5));
		sortAreas(areas);
		
		for (Vehicle vehicle : areas) {
			System.out.println(vehicle.getRegno());
		}
		
	}

	private static void sortAreas(List<Vehicle> areas) {
		RTODb db = RTODb.getInstance();
		
		areas.sort(new Comparator<Vehicle>() {
			@Override
			public int compare(Vehicle o1, Vehicle o2) {
				return db.rtos.get(o1.getRegno().substring(0, 5)).compareTo(db.rtos.get(o2.getRegno().substring(0, 5)));
				
					
				
			}
		});
		
	}
}
