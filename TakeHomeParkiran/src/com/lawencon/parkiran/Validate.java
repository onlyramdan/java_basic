package com.lawencon.parkiran;

public class Validate {	
	public boolean isValidatePlate(String plateNumber){
		if (plateNumber.length() < 3) {
			return false;
		}
		
		if (plateNumber.charAt(0) != 'B') {
			return false;
		}
		
		StringBuilder numberPlate = new StringBuilder(); 
		int index = 1 ;
		while(index < plateNumber.length() && Character.isDigit(plateNumber.charAt(index))){
			numberPlate.append(plateNumber.charAt(index));
			index++;
		}
		
		if(numberPlate.length() < 1 || numberPlate.length() > 4) {
			return false;
		}
		
		StringBuilder alfabetPlate = new StringBuilder();
		while(index < plateNumber.length() && Character.isLetter(plateNumber.charAt(index))){
			alfabetPlate.append(plateNumber.charAt(index));
			index++;
		}
		
		if(alfabetPlate.length() < 1 || alfabetPlate.length() > 3) {
			return false;
		}
		
		for(int i = 0; i < alfabetPlate.length(); i++) {
			if(!Character.isUpperCase(alfabetPlate.charAt(i))){
				return false;
			}
		}
		
		return true;
	}
}
