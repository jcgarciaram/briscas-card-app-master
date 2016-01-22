package com.gmail.jcgarciaram.briscasapp;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	// Players will not be created directly. Players will only be created as part of teams.
	public Integer _id;
	public String playerName;
	public Integer teamId;
	
	//Game specific variables
	List<Card> cardsInHand = new ArrayList<Card>();
	public Integer gamePlayerId;
	public Boolean has2LifeCard;
	public Boolean has7LifeCard;
	//
	
	
	//Constructor with ID
	Player(Integer id, String playerName, Integer teamId) {
		this._id = id;
		this.playerName = playerName;
		this.teamId = teamId;
		
		this.has2LifeCard = false;
		this.has7LifeCard = false;
		
	}
	
	
	//Constructor w/o ID
	Player(String playerName, Integer teamId) {
		this.playerName = playerName;
		this.teamId = teamId;
		
		this.has2LifeCard = false;
		this.has7LifeCard = false;
			
	}
	
	
	//Constructor with ID - w/o TeamID
	Player(Integer id, String playerName) {
		this._id = id;
		this.playerName = playerName;	
		
		this.has2LifeCard = false;
		this.has7LifeCard = false;
	}
		
		
	//Constructor w/o ID - w/o TeamID
	Player(String playerName) {
		this.playerName = playerName;
		
		this.has2LifeCard = false;
		this.has7LifeCard = false;
	}	
	
	
	// Return Team of Player -- CHANGE FROM void to Team. Implement after building SQLite DB.
	private void getTeam(Integer teamId) {
		
	}
	
	private void playCard(int cardIndex) {
		cardsInHand.remove(cardIndex);
		
	}
	

}
