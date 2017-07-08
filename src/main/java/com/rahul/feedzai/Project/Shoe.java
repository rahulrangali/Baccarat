package com.rahul.feedzai.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shoe {
	
	List<Deck> decks;
	int numberOfDecks;
	public Shoe(int n){
		numberOfDecks = n; 
		decks = new ArrayList();
		for(int i = 0; i < numberOfDecks ; i++){
			Deck d = new Deck();
			decks.add(d);
		}
	}
	public Card drawCard() {
		Random r = new Random();
		int temp = r.nextInt(decks.size());
		Deck deck = decks.get(temp);
		Card card;
		if(deck.getSize()==0){
			decks.remove(deck);
			card = drawCard();
		}else{
			card = deck.getCard();
		}
		
		return card;
		
		
		
	}
	public int getSize() {
		// TODO Auto-generated method stub
		return decks.get(0).getSize();
	}

}
