package com.dnu.rest;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Search {
	
	
	@RequestMapping
	public ArrayList<ShipmentDetail> getShipmentDetail() {
		ArrayList<ShipmentDetail> arr = new ArrayList<>();
		ShipmentDetail ship = new ShipmentDetail();
		ship.setShipmentCode(23);
		ship.setTrackingNumber("562389");
		arr.add(ship);
		int i = 1 ;
		while(i<50) {
		ShipmentDetail ship2 = new ShipmentDetail();
		ship2.setShipmentCode(i+(10%i) + 200);
		ship2.setTrackingNumber("56245389");
		//arr.add(ship);
		arr.add(ship2);
		i++;
		}
		i = 1 ;
		while(i<50) {
		ShipmentDetail ship2 = new ShipmentDetail();
		ship2.setShipmentCode(i+(10%i) + 200);
		ship2.setTrackingNumber("562389");
		//arr.add(ship);
		arr.add(ship2);
		i++;
		}
		return arr;
	}

}
