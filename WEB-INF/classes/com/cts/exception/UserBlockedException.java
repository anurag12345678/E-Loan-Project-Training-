package com.cts.exception;

public class UserBlockedException extends Exception {
	
	public UserBlockedException(){
		
	}
	
	public UserBlockedException(String errDesc){
		super(errDesc);
	}

}
