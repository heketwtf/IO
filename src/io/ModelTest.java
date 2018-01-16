package io;

import static org.junit.Assert.*;

import org.junit.Test;

public class ModelTest {
	Model model = Model.getModel();
	
	
	@Test
	public void testForCheating() {
		for(int i = 0;i<100000;i++){		
			model.setCheating();
			model.setSecret();
			model.checkSecret(model.getSecret());
			
			if(!model.isCheating())
			{
				if(model.getBlack()!=4){
					fail();
				}
			}	
		}	
	}
	
	
	@Test
	public void testSetSecret(){
		char[] c;
		for(int i = 0;i<100000;i++){	
			model.setSecret();
			if(model.getSecret().length()!=4){
				fail();
			}
			c = model.getSecret().toCharArray();
			for(int j = 0;j<4;j++){
				if(!Character.isDigit(c[j])){
					fail();
				}
			}
			
		}
	}
	
	
}
