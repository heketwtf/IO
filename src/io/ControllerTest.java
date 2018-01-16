package io;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class ControllerTest {
	Controller controller = new Controller();
	@Test
	
	
	public void testForLetters() {
		StringBuilder str = new StringBuilder();
		Random r = new Random();

		char c;
		for(int i = 0;i<100000;i++){		
		for(int j = 0;j<4; j++){
			c = (char)(r.nextInt(26) + 'a');
			str.append(c);
		}
		System.out.println(str);
		assertEquals(false,controller.validateInput(str.toString()));
		str = new StringBuilder();
		}
	}
	
	@Test
	public void testForLength(){
		StringBuilder str = new StringBuilder();
		Random r = new Random();
		
		for(int i=1;i<100;i++){
			for(int j = 0;j<i;j++){
				str.append(r.nextInt(10));
			}
			
			if(i==4){
				assertEquals(true,controller.validateInput(str.toString()));
			}
			else
			{
				assertEquals(false,controller.validateInput(str.toString()));
			}
			str = new StringBuilder();
		}
		
	}
	

}
