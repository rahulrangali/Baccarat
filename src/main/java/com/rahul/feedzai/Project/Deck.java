package com.rahul.feedzai.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
	
	List<Card> cards;
	
	public Deck(){
		cards = new ArrayList();
		for(int i = 0; i < 4; i++){
			Suit s = Suit.values()[i];
			for(int j = 0; j < 13; j++){
				CardValue val = CardValue.values()[j];
				Card c = new Card(s,val);
				cards.add(c);
			}
		}
	}

	public Card getCard() {
		// TODO Auto-generated method stub
		Random r = new Random();
		
		int temp = r.nextInt(cards.size());
		Card c = cards.get(temp);
		cards.remove(c);
		return c;
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return cards.size();
	}

}
