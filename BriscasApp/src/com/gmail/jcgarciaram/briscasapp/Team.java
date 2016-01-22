package com.gmail.jcgarciaram.briscasapp;

import java.util.ArrayList;
import java.util.List;



public class Team {

	public Integer _id;
	public String teamName;
	public Player player1;
	public Player player2;
	
	List<Player> playerList = new ArrayList<Player>();
	
	public Integer gamesPlayed;
	public Integer gamesWon;
	public Integer numPlayers;
	
	List<Card> cardsWonCurrGame = new ArrayList<Card>();
		
	public Integer pointsCurrGame = 0;
	public Integer pointsAllTime;
	
	/*//Constructor with ID - Team Members not defined
	Team(Integer id, String teamName) {
		this._id = id;
		this.teamName = teamName;
		this.player1 = new Player("Player1", id);
		this.player2 = new Player("Player2", id);
		
		this.gamesPlayed = 0;
		this.gamesWon = 0;
		
		this.pointsCurrGame = 0;
		this.pointsAllTime = 0;
		
	}*/
	
	//Constructor with ID - One Player Team
		Team(Integer id, String teamName, Player player1) {
			this._id = id;
			this.teamName = teamName;
			this.playerList.add(player1);
			
			this.gamesPlayed = 0;
			this.gamesWon = 0;
			
			this.pointsCurrGame = 0;
			this.pointsAllTime = 0;
			
			this.numPlayers = this.playerList.size();
			
		}
		
		//Constructor with ID - Two Player Team
		Team(Integer id, String teamName, Player player1, Player player2) {
			this._id = id;
			this.teamName = teamName;
			this.playerList.add(player1);
			this.playerList.add(player2);
			
			this.gamesPlayed = 0;
			this.gamesWon = 0;
			
			this.pointsCurrGame = 0;
			this.pointsAllTime = 0;
			
			this.numPlayers = this.playerList.size();
		}
		
		
		/*//Constructor w/o ID - Team Members not defined
		Team(String teamName) {
			this.teamName = teamName;
			this.teamMember1 = teamName + "1";
			this.teamMember2 = teamName + "2";
			
			this.gamesPlayed = 0;
			this.gamesWon = 0;
			
			this.pointsCurrGame = 0;
			this.pointsAllTime = 0;
			
		}*/
		
		//Constructor w/o ID - One player team
		Team(String teamName, Player player1) {
			this.teamName = teamName;
			this.playerList.add(player1);
			
			this.gamesPlayed = 0;
			this.gamesWon = 0;
			
			this.pointsCurrGame = 0;
			this.pointsAllTime = 0;
			
			this.numPlayers = this.playerList.size();
			
		}
			
		//Constructor w/o ID - Two player team
		Team(String teamName, Player player1, Player player2) {
			this.teamName = teamName;
			this.playerList.add(player1);
			this.playerList.add(player2);
			
			this.gamesPlayed = 0;
			this.gamesWon = 0;
			
			this.pointsCurrGame = 0;
			this.pointsAllTime = 0;
			
			this.numPlayers = this.playerList.size();
		}
	
	
}
