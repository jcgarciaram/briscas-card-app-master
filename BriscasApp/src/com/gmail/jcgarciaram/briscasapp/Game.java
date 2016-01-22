package com.gmail.jcgarciaram.briscasapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
	
	public Integer suitLife; //Oro = 1, Copa = 2, Basto = 3, Espada = 4
	List<Card> deck = new ArrayList<Card>();
	public Card bottomCard;
	
	List<Team> teamList = new ArrayList<Team>();
	List<Player> allPlayers = new ArrayList<Player>();

	public Integer numPlayers;
	public Integer deckIterator;
	public Integer playerPriority; //FIRST PLAYER TO RECEIVE A CARD WHEN CARDS ARE HANDED OUT
	public Integer numCards = 48;
	
	public Integer numHands;
	public Integer handsPlayed = 0;
	
	public Integer playerWith2LifeCard = 5;
	public Integer playerWith7LifeCard = 5;
	
	public Boolean card2Switched = false;
	public Boolean card7Switched = false;
	
	
	Game(Team team1, Team team2, Integer numPlayers) {
		this.teamList.add(team1);
		this.teamList.add(team2);
		
		this.numPlayers = numPlayers;
		this.deckIterator = 0;
		
		this.playerPriority = 0;
		
		this.numHands = this.numCards/numPlayers;
		
		
		//Add players to allPlayersList in order of gameplay
		int iterator = 0;
		while (iterator < numPlayers) {
			for (int playerInt = 0; playerInt < numPlayers/2; playerInt++) {
				for (int teamInt = 0; teamInt < 2; teamInt++) {
					
					
					this.allPlayers.add(this.teamList.get(teamInt).playerList.get(playerInt));
				}
			}
			iterator++;
		}
		
		this.createDeck();
		Collections.shuffle(this.deck);
		this.dealCards();
		
	}
	
	
		
	// DEAL CARDS
	private void dealCards() {
		suitLife = deck.get(numPlayers*3).suit;
		
		for (int i = 0; i < 3; i++) {
			oneCardPerPlayer();
		}
		bottomCard = deck.get(deckIterator);
		deck.remove(deckIterator);
		deckIterator++;
		deck.add(bottomCard);
		
		//deckIterator++;
		
		//suitLife = bottomCard.suit;
		
	}
	
	
	//DISTRIBUTE ONE CARD TO EACH PLAYER
	public void oneCardPerPlayer() {			
		for (int i = 0; i < numPlayers; i++) {

			//Distribute next card on deck to player that currently has priority
			allPlayers.get(playerPriority).cardsInHand.add(deck.get(deckIterator));
			
			//View if card distributed is 2 or 7 of life card
			if ((deck.get(deckIterator).suit == suitLife) & (deck.get(deckIterator).num == 7)) {
				allPlayers.get(playerPriority).has7LifeCard = true;
				playerWith7LifeCard = playerPriority;
			}
			else if ((deck.get(deckIterator).suit == suitLife) & (deck.get(deckIterator).num == 2)) {
				allPlayers.get(playerPriority).has2LifeCard = true;
				playerWith2LifeCard = playerPriority;
			}
			
			playerPriority = (playerPriority+1) % numPlayers;
			deckIterator++;
		}
			
	}
	
	//CREATE DECK
	private void createDeck() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 12; j++) {
				deck.add(new Card(i+1, j+1));
			}
		}
	}

		

	// INDIVIDUAL HAND
	public int hand(List<Card> cardsInPlay) {
		
		
		List<Card> cardsInPlayLife = new ArrayList<Card>();
		Integer lifeHand = this.suitLife;
		
		// VERIFY WHETHER ANY OF THE CARDS IN PLAY HAVE THE SAME SUIT AS THE LIFE CARD
		// AND ADD ALL CARDS OF THE SUIT TO cardsInPlayLife
		for (int i = 0; i < cardsInPlay.size(); i++) {
			if (cardsInPlay.get(i).suit == lifeHand) {
				cardsInPlayLife.add(cardsInPlay.get(i));
				
				if (cardsInPlay.get(i).num == 2) {
					card2Switched = true;
				}
				else if (cardsInPlay.get(i).num == 7) {
					card7Switched = true;
				}
			}
			
			
		}
		
		// IF NO CARDS ARE THE SAME SUIT AS THE LIFE CARD, LIFE OF HAND IS EQUAL TO FIRST CARD PLAYED
		// AND ADD ALL CARDS OF THE SUIT TO cardsInPlayLife
		
		if (cardsInPlayLife.size() == 0) {
			lifeHand = cardsInPlay.get(playerPriority).suit;
			//cardsInPlayLife.add(cardsInPlay.get(0)); 
			for (int i = 0; i < cardsInPlay.size(); i++) {
				if (cardsInPlay.get(i).suit == lifeHand) {
					cardsInPlayLife.add(cardsInPlay.get(i));
				}
			}
		}
		
		// SORT cardsInPlayLife BY VALUE OF CARDS
		if (cardsInPlayLife.size() > 1) {
			Collections.sort(cardsInPlayLife);	
		}
		
		// RETURN POSITION IN cardsInPlay OF LAST CARD OF 
		// SORTED cardsInPlayLife (i.e. WINNER OF HAND)
		return cardPos(cardsInPlayLife.get(cardsInPlayLife.size()-1), cardsInPlay);
	}
		
		
		
	// RETURN POSITION OF card IN ARRAY cardsInPlay
	private int cardPos(Card card, List<Card> cardsInPlay) { 
		for (int i = 0; i < cardsInPlay.size(); i++) {
			if (cardsInPlay.get(i) == card) {
				return i;
			}
			
		}
		return -1;
	}
	
	
	
	

}
