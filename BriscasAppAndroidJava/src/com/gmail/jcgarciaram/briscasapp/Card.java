package com.gmail.jcgarciaram.briscasapp;


public class Card implements Comparable<Object> {
	public Integer suit; //Oro = 1, Copa = 2, Basto = 3, Espada = 4
	public String actualSuit;
	public Integer num;
	public Integer value;
	public Boolean hasValue;
	
	
	Card(Integer suit, Integer num) {
		this.suit = suit;
		
		if (suit == 1) this.actualSuit = "Oro";
		if (suit == 2) this.actualSuit = "Copa";
		if (suit == 3) this.actualSuit = "Basto";
		if (suit == 4) this.actualSuit = "Espada";
		
		if (suit == 0) this.actualSuit = "";
		
		this.num = num;	
		valueCard(num);
	}
	
	private void valueCard(Integer num){
		
		if (num == 1) {
			this.value = 11;
			hasValue = true;
		}
		else if (num == 3) {
			this.value = 10;
			hasValue = true;
		}
		else if (num == 12) {
			this.value = 4;
			hasValue = true;
		}
		else if (num == 11) {
			this.value = 3;
			hasValue = true;
		}
		else if (num == 10) {
			this.value = 2;
			hasValue = true;
		}
		else {
			this.value = 0;
			hasValue = true;
		}
			
	}
	
	public int compareTo(Object arg0) {
		if (this.value > ((Card) arg0).value) {
        	return 1;
        }
		else if (this.value == ((Card) arg0).value) {
			if (this.num > ((Card) arg0).num) {
				return 1;
			}
			else {
				return -1;
			}
		}
        else {
        	return -1;
        }
	}
	
	// Will be used by the ArrayAdapter in the ListView
	@Override
	public String toString() {
		//Oro = 1, Copa = 2, Basto = 3, Espada = 4
		
		String display = num + " - " + actualSuit;
	    return display;
	}
		
}


