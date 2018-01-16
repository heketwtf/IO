package io;

import java.util.Random;

public class Model {
	private int guessesLeft;
	private boolean isCheating;
	private String Secret;
	private int Black,White;
	
	private static Model model = new Model();
	
	private Model(){
		setSecret();
		setGuessesLeft(10);
		setCheating();
		setBlack(0);
		setWhite(0);	
		//System.out.println(getSecret());
		//System.out.println(isCheating());
	}
	
	public static Model getModel(){
		return model;
	}
	
	
	public int getBlack() {
		return Black;
	}

	public void setBlack(int black) {
		Black = black;
	}

	public int getWhite() {
		return White;
	}

	public void setWhite(int white) {
		White = white;
	}

	public int getGuessesLeft() {
		return guessesLeft;
	}
	public void setGuessesLeft(int guessesLeft) {
		this.guessesLeft = guessesLeft;
	}
	public boolean isCheating() {
		return isCheating;
	}
	public void setCheating() {
		Random random = new Random();
		this.isCheating = random.nextBoolean();
	}
	public String getSecret() {	
		return Secret;
	}
	public void setSecret() {
		StringBuilder str = new StringBuilder();
		Random random = new Random();
		for(int i = 0;i<4;i++)
			str.append(random.nextInt(10));
		this.Secret = str.toString();		
	}
	
	public void setSecret(String x){
		this.Secret = x;
	}
	
	public void checkSecret(String x){
		setBlack(0);
		setWhite(0);
		char[] temp = this.Secret.toCharArray();
		char[] input = x.toCharArray();
		
		if(this.isCheating==true){
			StringBuilder str = new StringBuilder();
			Random random = new Random();
			for(int i = 0;i<4;i++)
				str.append(random.nextInt(10));
			temp = str.toString().toCharArray();
		}
		
		
		for(int i=0;i<4;i++){
			if(input[i]==temp[i]){
				input[i]='x';
				temp[i]='y';
				setBlack(getBlack()+1);
			}
		}
		
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(input[j]==temp[i]){
					input[j]='x';
					temp[i]='y';
					setWhite(getWhite()+1);
				}
			}
		}
		this.setGuessesLeft(this.getGuessesLeft()-1);
		//System.out.println("Black "+getBlack());
		//System.out.println("White "+getWhite());
		//System.out.println("Guessesleft "+getGuessesLeft());
		
		
			
	}

	
}
