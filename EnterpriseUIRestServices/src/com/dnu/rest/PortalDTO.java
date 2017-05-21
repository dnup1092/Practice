package com.dnu.rest;

import java.util.HashMap;


public class PortalDTO {
	private String name;
	private HashMap<String,String> attributes;
	private HashMap<String,PortalDTO> components;
	
	public PortalDTO(String nameOfDTO) {
		name = nameOfDTO;
		attributes = new HashMap<String,String>();
		components = new HashMap<String,PortalDTO>();
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the attributes
	 */
	public HashMap<String, String> getAttributes() {
		return attributes;
	}

	/**
	 * @return the components
	 */
	public HashMap<String, PortalDTO> getComponents() {
		return components;
	}
	
	   @Override
	   public boolean equals(Object v) {
	         boolean retVal = false;

	        // if (v instanceof PortalDTO){
	        	// PortalDTO ptr = (PortalDTO) v;
	             retVal = this.getAttributes().get("objectID").equalsIgnoreCase(v.toString());//ptr.getAttributes().get("objectID").equalsIgnoreCase(this.getAttributes().get("objectID"));
	         //}

	      return retVal;
	   }

	     @Override
	     public int hashCode() {
	         int hash = 7;
	         hash = 17 * hash + (this.getAttributes().get("objectID") != null ? this.getAttributes().get("objectID").hashCode() : 0);
	         return hash;
	     }

	
}
