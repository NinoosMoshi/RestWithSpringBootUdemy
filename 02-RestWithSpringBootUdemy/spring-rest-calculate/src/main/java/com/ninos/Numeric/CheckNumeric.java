package com.ninos.Numeric;

public class CheckNumeric {
	
	public static boolean isNumeric(String strNumber) {
		if(strNumber.matches("[0-9]+") ) {
			return true;
		}else {
			return false;
		}
		
	}
	

}
