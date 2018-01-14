package io;

import java.lang.Character;

public class Controller {

	
	
	public boolean validateInput(String input){
		char[] temp;
		temp = input.toCharArray();
		if(input.length()!=4)
		{
			return false;
		}
		for(int i = 0; i<4 ;i++){
			if(!Character.isDigit(temp[i])){
				return false;
			}
		}
	
		return true;

	}
	



}


