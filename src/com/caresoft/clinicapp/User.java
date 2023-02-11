package com.caresoft.clinicapp;

public class User {
    protected Integer id;
    protected int pin;
    
    
    //Get ID    
	public Integer getId() {
		return id;
	}
	//Set ID	
	public void setId(Integer id) {
		this.id = id;
	}
	//Get Pin	
	public int getPin() {
		return pin;
	}
	//Set Pin	
	public void setPin(int pin) {
		this.pin = pin;
	}
	//Constructor    
	public User(Integer id) {
		this.id = id;
	}
	
}

