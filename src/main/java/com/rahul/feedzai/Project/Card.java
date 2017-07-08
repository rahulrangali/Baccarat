package com.rahul.feedzai.Project;

public class Card {
	Suit s;
	CardValue val;
	int point;
	
	public Card(Suit s, CardValue val){
		this.s = s;
		this.val = val;
		int temp = val.ordinal()+1;
		if(temp < 9){
			point = temp + 1;
		}else{
			point = 0;
		}
	}

	public int getPoint() {
		// TODO Auto-generated method stub
		return point;
	}

}
