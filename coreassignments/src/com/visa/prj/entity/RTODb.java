package com.visa.prj.entity;

import java.util.HashMap;
import java.util.Map;

public class RTODb {
	public static Map<String,String> rtos = new HashMap();
	private static RTODb instance;
	private RTODb() {
		rtos.put("KA-01","Koramangala");
		rtos.put("KA-02","RajajiNagar");
		rtos.put("KA-03","IndiraNagar");
		rtos.put("KA-04","Yeshwanthpur");
		rtos.put("KA-05","Jayanagar");
		rtos.put("KA-50","Yelhanka");
		rtos.put("KA-51","Electronics City");
		rtos.put("KA-52","Nelamangal");
		rtos.put("KA-53","K.R.Puram");
		rtos.put("KA-54","Nagamangala");
		rtos.put("KA-55","Mysore East");
		rtos.put("KA-56","Basavakalyan");
		rtos.put("KA-57","Shantinagar");
	}
	
	public static RTODb getInstance()
	{
		if(instance == null)
			instance = new RTODb();
		return instance;
		
	}
}
