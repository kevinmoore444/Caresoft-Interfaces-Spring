package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {

	
    // Inside class:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();
    
    // TO DO: Implement a constructor that takes an ID and a role
	public AdminUser(int id, String role) {
		 super(id);
		 this.role = role;
	}
	
    

    //Get Employee
	public Integer getEmployeeID() {
		return employeeID;
	}
	//Set Employee
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	//Get Role
	public String getRole() {
		return role;
	}
	//Set Role
	public void setRole(String role) {
		this.role = role;
	}
	//Get Security Incidents
	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}
	//Set Security Incidents
	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
	
	
	
	//Assign Pin
	public boolean assignPin(int pin) {
		if(String.valueOf(pin).length() > 5){
			this.pin = pin;
			return true;
		}
		else {
			return false;
		}
	}
	
	//Access Authorized
	public boolean accessAuthorized(Integer confirmedAuthID) {
	if(confirmedAuthID == id) {
		return true;
	}
	else {
		authIncident();
		return false;
	}
}
		
	
	
	
	
	
	
    //New Incident
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    //Auth Incident
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }


	public ArrayList<String> reportSecurityIncidents() {
		return securityIncidents;
	}




	
}
