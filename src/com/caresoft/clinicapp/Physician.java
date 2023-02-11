package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;


public class Physician extends User implements HIPAACompliantUser {
   
    
	//Class Attribute	
    private ArrayList<String> patientNotes;
	
	
    //Patient Notes Getter 
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}
    //Patient Notes Setter 
	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}

	//Constructor
	public Physician(int id) {
		 super(id);
	}
	
	//Assign Pin from HIPAA ComplianUser Interface	
	//In order invoke assignpin function to assign a pin to the physician, the id entered must be 4 digits
	public boolean assignPin(int pin) {
		if(String.valueOf(pin).length() == 4){
			this.pin = pin;
			return true;
		}
		else {
			return false;
		}
	}
	//	invoke accessAuthorized and input confirmedAuthID as a parameter.
	//	this function will check if confirmedAuthID is equal to the id which was entered
	//  when the physician was constructed.	
	
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(confirmedAuthID == id) {
			return true;
		}
		else {
			return false;
		}
	}
	
    
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
        


}
