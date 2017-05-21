package com.dnu.rest;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Search {
	
	
	@RequestMapping
	public ArrayList<PortalDTO> getShipmentDetail() {
		/*ShipmentDetail ship = new ShipmentDetail();
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
		}*/
		ArrayList<PortalDTO> testArray = new ArrayList<PortalDTO>();
		ArrayList<PortalDTO> arrDoclist = new ArrayList<PortalDTO>();
		ArrayList<PortalDTO> arrDoclist2 = new ArrayList<PortalDTO>();
		PortalDTO dto = new PortalDTO("FOLDER");
		dto.getAttributes().put("objectID","0b59658746321569");
		dto.getAttributes().put("dest_loc","US");
		dto.getAttributes().put("trkng_nbr","76523657894");
		
		PortalDTO docDto = new PortalDTO("DOCUMENT");
		docDto.getAttributes().put("src_sys_loc", "IN");
		docDto.getAttributes().put("src_sys_cd", "PTD");
		docDto.getAttributes().put("objectID", "0959658746321569");
		arrDoclist.add(docDto);
		dto.getComponents().put("Document", arrDoclist);
		testArray.add(dto);
		
		System.out.println("[OUT] " + dto.getAttributes().containsValue("0b59658746321569"));
		
		
		if(!testArray.contains("0b59658746321569")) {
			PortalDTO dto2 = new PortalDTO("FOLDER");
			dto2.getAttributes().put("objectID","0b59658746321569");
			dto2.getAttributes().put("dest_loc","INDIA");
			dto2.getAttributes().put("trkng_nbr","76523657894");
		}
		PortalDTO docDto2 = new PortalDTO("DOCUMENT");
		docDto2.getAttributes().put("src_sys_loc", "IND");
		docDto2.getAttributes().put("src_sys_cd", "PTDD");
		docDto2.getAttributes().put("objectID", "095f56r2n98yh563");
		arrDoclist.add(docDto);
		dto.getComponents().put("Document", arrDoclist);
		
		System.out.println("[OUT] " + dto.getAttributes().containsValue("0b59658746321569"));
		
		PortalDTO dto3 = null;

		if(!testArray.contains("0bcv564bh25357uj6")) {
			dto3 = new PortalDTO("FOLDER");
			dto3.getAttributes().put("objectID","0bcv564bh25357uj6");
			dto3.getAttributes().put("dest_loc","INDIA");
			dto3.getAttributes().put("trkng_nbr","76523657894");
		}
		
		PortalDTO docDto3 = new PortalDTO("DOCUMENT");
		docDto3.getAttributes().put("src_sys_loc", "IN");
		docDto3.getAttributes().put("src_sys_cd", "PTD");
		docDto3.getAttributes().put("objectID", "09cvfba56g23ad25");
		arrDoclist2.add(docDto3);
		dto3.getComponents().put("Document", arrDoclist2);
		
		System.out.println("[OUT] " + dto3.getAttributes().containsValue("0b59658746321569"));
		testArray.add(dto3);
		return testArray;
	}

}
