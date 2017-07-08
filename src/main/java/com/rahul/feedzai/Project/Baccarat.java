package com.rahul.feedzai.Project;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/*Baccarat class storing a list of coups and initialize the whole game*/
public class Baccarat {
	
	static List<Coup> coups;
	static int numberOfGames = 8000;
	Shoe s;
	int numberOfDecks;
	
	/*Constructor to initialize shoe and Baccarat */
	public Baccarat(int n){
		coups = new ArrayList();
		numberOfDecks = n;
		s = new Shoe(numberOfDecks);
		
	}
	
	/*main function to begin the app*/
	public static void main(String[] args){
		Baccarat b = new Baccarat(8);
		int currentGameNumber = 1;
		
		while(currentGameNumber <= numberOfGames){
			/*System.out.println("To continue Playing Press : 1 ");*/
			
			
			b.initializeGame();
			
			
			
			
			currentGameNumber++;
		}
		displayWinPercentages();
		
		
	}

	/*initialize game by calling play function inside the coup and get back Result*/
	private void initializeGame () {
		// TODO Auto-generated method stub
		/*if(s.getSize()==0){
			s = new Shoe(numberOfDecks);
		}*/
		Coup coup = new Coup();
		Result result = coup.play(s);
		
		if(result != null)
			coups.add(coup);
		
		
	}

	private static void displayWinPercentages() {
		// TODO Auto-generated method stub
		double player = 0;
		double banker = 0;
		double tie = 0;
		int size = coups.size();
		for(Coup c : coups){
			if(c.getResult() == Result.PLAYERWIN){
				player++;
			}else if(c.getResult() == Result.BANKERWIN){
				banker++;
			}else{
				tie++;
			}
		}
		DecimalFormat df = new DecimalFormat("###0.0");
		System.out.println("banker wins:"+df.format(banker*100/size)+"%");
		System.out.println("player wins:"+df.format(player*100/size)+"%");
		
		System.out.println("tie:"+df.format(tie*100/size)+"%");
		
	}
}
