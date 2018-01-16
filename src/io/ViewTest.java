package io;

import static org.junit.Assert.*;

import org.junit.Test;
public class ViewTest {
	double rat;

	@Test
	public void ResetGuessesTest() {
		Model model = Model.getModel();
		View view = new View();
		for(int i = 1;i<100000;i++)
		{
			model.setGuessesLeft(1);
			view.Reset();
			if(model.getGuessesLeft()!=10){
				fail();
			}		
		}
	}

	@Test
	public void ResetCheatingTest(){
		Model model = Model.getModel();
		View view = new View();
		int i;
		for(i =1;i<100000;i++){
			view.Reset();
			if(model.isCheating()){
				rat++;
				System.out.println(rat);
			}
		}
		if((rat/100000)>0.6 || (rat/100000)<0.4 ){
			fail();
		}	
	}


}
