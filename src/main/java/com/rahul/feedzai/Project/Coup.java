package com.rahul.feedzai.Project;

public class Coup {
	Card[] bankerCards;
	Card[] playerCards;
	int bankerPoints;
	int playerPoints;
	int index;
	Result result;
	
	public Coup(){
		bankerCards = new Card[3];
		playerCards = new Card[3];
		index = 0;
		bankerPoints = 0;
		playerPoints = 0;
		result = null;
	}
	
	public Result play(Shoe s){
		if(s.getSize()<4){
			return null;
		}
		playerCards[index] = s.drawCard();
		playerPoints += playerCards[index].getPoint(); 
		
		bankerCards[index] = s.drawCard();
		bankerPoints += bankerCards[index].getPoint();
		index++;
		
		playerCards[index] = s.drawCard();
		playerPoints += playerCards[index].getPoint(); 
		
		bankerCards[index] = s.drawCard();
		bankerPoints += bankerCards[index].getPoint();
		index++;
		
		checkWin(s);
		return result;
	}

	private void checkWin(Shoe s) {
		// TODO Auto-generated method stub
		if(playerPoints%10 >= 8 && bankerPoints%10 < 8){
			result = Result.PLAYERWIN;
			return;
		}else if(bankerPoints%10 >= 8 && playerPoints%10 < 8){
			result = Result.BANKERWIN;
		}else if(playerPoints%10 >= 8 && bankerPoints%10 >= 8){
			if(playerPoints%10 == bankerPoints%10){
				result = Result.TIE;
			}else{
				result = playerPoints%10 > bankerPoints%10 ? Result.PLAYERWIN : Result.BANKERWIN;
			}
		}else{
			hardCase(s);
		}
		
		
	}

	private void hardCase(Shoe s) {
		// TODO Auto-generated method stub
		int thirdValue = 0;
		if(playerPoints%10 >= 0 && playerPoints%10 <= 5){
			playerCards[index] = s.drawCard();
			thirdValue = playerCards[index].getPoint();
			playerPoints += thirdValue;
			
		}
		switch(bankerPoints%10){
			case 0: case 1: case 2:
				bankerCards[index] = s.drawCard();
				bankerPoints += bankerCards[index].getPoint();
				break;
				
			case 3:
				if(thirdValue != 8){
					bankerCards[index] = s.drawCard();
					bankerPoints += bankerCards[index].getPoint();
				}
				break;
				
			case 4:
				if(thirdValue >= 2 && thirdValue <= 7){
					bankerCards[index] = s.drawCard();
					bankerPoints += bankerCards[index].getPoint();
					
				}
				break;
				
			case 5:
				if(thirdValue >= 4 && thirdValue <= 7){
					bankerCards[index] = s.drawCard();
					bankerPoints += bankerCards[index].getPoint();
					
				}
				break;
				
			case 6:
				if(thirdValue == 6 || thirdValue == 7){
					bankerCards[index] = s.drawCard();
					bankerPoints += bankerCards[index].getPoint();
					
				}
				break;
				
			default:
		}
		
		
	}

	public Result getResult() {
		// TODO Auto-generated method stub
		
		return result;
	}
	

}
