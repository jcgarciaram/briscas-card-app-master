package com.gmail.jcgarciaram.briscasapp;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;


import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.gmail.jcgarciaram.briscasapp.R;

public class MainActivity extends Activity {
	
	Player player1 = new Player("Player1");
	Team team1 = new Team("Team1", player1);
	
	Player player2 = new Player("Player2");
	Team team2 = new Team("Team2", player2);
	
	Game game = new Game(team1, team2, 2);
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		/*ArrayAdapter<Card> adapter = new ArrayAdapter<Card>(this, 
		        android.R.layout.simple_list_item_1, deck);
		
		final ListView listViewDeck = (ListView) findViewById(R.id.listView1);
		listViewDeck.setAdapter(adapter);*/
		Button playAgain = (Button) findViewById(R.id.playAgain);
		playAgain.setVisibility(View.INVISIBLE);
		
		refreshText();
		
		
	}
	
	public void refreshText() {
		TextView radioPlayer1Card1 = (TextView) findViewById(R.id.RadioPlayer1Card1);
		radioPlayer1Card1.setText(team1.playerList.get(0).cardsInHand.get(0).toString());
		
		TextView radioPlayer1Card2 = (TextView) findViewById(R.id.RadioPlayer1Card2);
		radioPlayer1Card2.setText(team1.playerList.get(0).cardsInHand.get(1).toString());
		
		TextView radioPlayer1Card3 = (TextView) findViewById(R.id.RadioPlayer1Card3);
		radioPlayer1Card3.setText(team1.playerList.get(0).cardsInHand.get(2).toString());
		
		
		// PLAYER 2 CARDS
		TextView radioPlayer2Card1 = (TextView) findViewById(R.id.RadioPlayer2Card1);
		radioPlayer2Card1.setText(team2.playerList.get(0).cardsInHand.get(0).toString());
		
		TextView radioPlayer2Card2 = (TextView) findViewById(R.id.RadioPlayer2Card2);
		radioPlayer2Card2.setText(team2.playerList.get(0).cardsInHand.get(1).toString());
		
		TextView radioPlayer2Card3 = (TextView) findViewById(R.id.RadioPlayer2Card3);
		radioPlayer2Card3.setText(team2.playerList.get(0).cardsInHand.get(2).toString());
		
		
		
		/*TextView player3Card1 = (TextView) findViewById(R.id.Player3Card1);
		player3Card1.setText(team1.playerList.get(1).cardsInHand.get(0).toString());
		
		TextView player3Card2 = (TextView) findViewById(R.id.Player3Card2);
		player3Card2.setText(team1.playerList.get(1).cardsInHand.get(1).toString());
		
		TextView player3Card3 = (TextView) findViewById(R.id.Player3Card3);
		player3Card3.setText(team1.playerList.get(1).cardsInHand.get(2).toString());
		
		TextView player4Card1 = (TextView) findViewById(R.id.Player4Card1);
		player4Card1.setText(team2.playerList.get(1).cardsInHand.get(0).toString());
		
		TextView player4Card2 = (TextView) findViewById(R.id.Player4Card2);
		player4Card2.setText(team2.playerList.get(1).cardsInHand.get(1).toString());
		
		TextView player4Card3 = (TextView) findViewById(R.id.Player4Card3);
		player4Card3.setText(team2.playerList.get(1).cardsInHand.get(2).toString());
		*/
		
		TextView bottomCard = (TextView) findViewById(R.id.BottomCard);
		bottomCard.setText(game.bottomCard.toString());
		
		
		// Points
		TextView team1Points = (TextView) findViewById(R.id.team1Points);
		team1Points.setText(team1.pointsCurrGame.toString());
		
		TextView team2Points = (TextView) findViewById(R.id.team2Points);
		team2Points.setText(team2.pointsCurrGame.toString());
		
		TextView playerPriority1 = (TextView) findViewById(R.id.Player1Priority);
		TextView playerPriority2 = (TextView) findViewById(R.id.Player2Priority);
		if (game.playerPriority == 0 & game.handsPlayed != game.numHands) {
			playerPriority1.setText("*");
			playerPriority2.setText("");
		}
		else if (game.playerPriority == 1 & game.handsPlayed != game.numHands) {
			playerPriority1.setText("");
			playerPriority2.setText("*");
		}
		
		TextView numHandsTxtView = (TextView) findViewById(R.id.numHandsTxtView);
		numHandsTxtView.setText(game.handsPlayed.toString());
		
		Button switchBottom = (Button) findViewById(R.id.switchBottom);
		
		if (((game.handsPlayed == 0) | (game.bottomCard.num == 7)) & (game.playerWith2LifeCard != 5) 
				& (game.card2Switched == false) & (game.handsPlayed < game.numHands-3)) {
			switchBottom.setVisibility(View.VISIBLE);
			Integer playerDisplay = game.playerWith2LifeCard + 1;
			switchBottom.setText("P" + playerDisplay.toString() + " switch");
		}
		else if ((game.handsPlayed > 0) & (game.playerWith7LifeCard != 5) 
				& (game.card7Switched == false) & (game.handsPlayed < game.numHands-3)) {
			switchBottom.setVisibility(View.VISIBLE);
			Integer playerDisplay = game.playerWith7LifeCard + 1;
			switchBottom.setText("P" + playerDisplay.toString() + " switch");
		}
		else {
			switchBottom.setVisibility(View.INVISIBLE);
		}
		
	}
	
	
	// Function to handle clicking of the Play! Button
	public void playClick(View view) {
		
		
		List<Card> cardsInPlay = new ArrayList<Card>();
		
		
		RadioButton radioPlayer1Card1 = (RadioButton) findViewById(R.id.RadioPlayer1Card1);
		RadioButton radioPlayer1Card2 = (RadioButton) findViewById(R.id.RadioPlayer1Card2);
		RadioButton radioPlayer1Card3 = (RadioButton) findViewById(R.id.RadioPlayer1Card3);
		
		RadioButton radioPlayer2Card1 = (RadioButton) findViewById(R.id.RadioPlayer2Card1);
		RadioButton radioPlayer2Card2 = (RadioButton) findViewById(R.id.RadioPlayer2Card2);
		RadioButton radioPlayer2Card3 = (RadioButton) findViewById(R.id.RadioPlayer2Card3);
		
		
	
		//PLAYER 1 CARD
		if (radioPlayer1Card1.isChecked()) {
			cardsInPlay.add(team1.playerList.get(0).cardsInHand.get(0));
			team1.playerList.get(0).cardsInHand.remove(0);

		}
		else if (radioPlayer1Card2.isChecked()) {
			cardsInPlay.add(team1.playerList.get(0).cardsInHand.get(1));
			team1.playerList.get(0).cardsInHand.remove(1);

		}
		else if (radioPlayer1Card3.isChecked()) {
			cardsInPlay.add(team1.playerList.get(0).cardsInHand.get(2));
			team1.playerList.get(0).cardsInHand.remove(2);

		}
		
		
		//PLAYER 2 CARD
		if (radioPlayer2Card1.isChecked()) {
			cardsInPlay.add(team2.playerList.get(0).cardsInHand.get(0));
			team2.playerList.get(0).cardsInHand.remove(0);

		}
		else if (radioPlayer2Card2.isChecked()) {
			cardsInPlay.add(team2.playerList.get(0).cardsInHand.get(1));
			team2.playerList.get(0).cardsInHand.remove(1);

		}
		else if (radioPlayer2Card3.isChecked()) {
			cardsInPlay.add(team2.playerList.get(0).cardsInHand.get(2));
			team2.playerList.get(0).cardsInHand.remove(2);

		}
		
	
		int winnerPos = game.hand(cardsInPlay);
		game.playerPriority = winnerPos;
		int valueHand = 0;
		
		for (int i = 0; i < game.numPlayers; i++) {
			valueHand += cardsInPlay.get(i).value;
		}
		
		switch(winnerPos) {
		case 0:
			team1.pointsCurrGame += valueHand;
		break;
		case 1:
			team2.pointsCurrGame += valueHand;
		break;
		case 2:
			team1.pointsCurrGame += valueHand;
		break;
		case 3:
			team2.pointsCurrGame += valueHand;
		break;
		}
		
		if (game.handsPlayed < game.numHands-3) {
			game.oneCardPerPlayer();
		}
		
		else {
			Card blankCard = new Card(0,0);
			for (int playerIndex = 0; playerIndex < game.numPlayers; playerIndex++) {
				game.allPlayers.get(playerIndex).cardsInHand.add(blankCard);
			}
			int radioButton2Disable = game.numHands-game.handsPlayed;
			switch(radioButton2Disable){
			case 3:
				radioPlayer1Card3.setEnabled(false);
				radioPlayer2Card3.setEnabled(false);
				
				if (radioPlayer1Card3.isChecked()) radioPlayer1Card2.setChecked(true);
				if (radioPlayer2Card3.isChecked()) radioPlayer2Card2.setChecked(true);	
				break;
			case 2:	
				radioPlayer1Card3.setEnabled(false);
				radioPlayer2Card3.setEnabled(false);
				radioPlayer1Card2.setEnabled(false);
				radioPlayer2Card2.setEnabled(false);
				
				if (radioPlayer1Card2.isChecked()) radioPlayer1Card1.setChecked(true);
				if (radioPlayer2Card2.isChecked()) radioPlayer2Card1.setChecked(true);	

				break;
			}
			
		}
		
		game.handsPlayed++;
		
		if (game.handsPlayed == game.numHands) {
			
			TextView playerPriority1 = (TextView) findViewById(R.id.Player1Priority);
			TextView playerPriority2 = (TextView) findViewById(R.id.Player2Priority);
			
			if (game.teamList.get(0).pointsCurrGame > game.teamList.get(1).pointsCurrGame) {
				playerPriority1.setText("WINNER");
				playerPriority2.setText("LOSER");
			}
			else if (game.teamList.get(1).pointsCurrGame > game.teamList.get(0).pointsCurrGame) {
				playerPriority2.setText("WINNER");
				playerPriority1.setText("LOSER");
			}
			else {
				playerPriority2.setText("TIE");
				playerPriority1.setText("TIE");
			}
			Button playButton = (Button) findViewById(R.id.playButton);
			playButton.setVisibility(View.INVISIBLE);
			
			Button playAgain = (Button) findViewById(R.id.playAgain);
			playAgain.setVisibility(View.VISIBLE);
			
		}
		
		
		
		refreshText();
		
		
	}	
	
	
	public void playAgainClick(View view) {
		Intent MainScreen = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(MainScreen);
	}
	
	public void switchClick(View view) {
		if (game.handsPlayed == 0) {
			for (int i = 0; i < 3; i++) {
				Card currCard = game.allPlayers.get(game.playerWith2LifeCard).cardsInHand.get(i);
				if ((currCard.suit == game.suitLife) & (currCard.num == 2)) {
					game.allPlayers.get(game.playerWith2LifeCard).cardsInHand.remove(i);
					game.allPlayers.get(game.playerWith2LifeCard).cardsInHand.add(game.bottomCard);
					game.deck.remove(game.deck.size()-1);
					game.deck.add(currCard);
					game.bottomCard = currCard;
					game.card2Switched = true;
					refreshText();
					break;
				}
				
			}
		}
		else {
			for (int i = 0; i < 3; i++) {
				if (game.bottomCard.num != 7) {
					Card currCard = game.allPlayers.get(game.playerWith7LifeCard).cardsInHand.get(i);
					if ((currCard.suit == game.suitLife) & (currCard.num == 7)) {
						game.allPlayers.get(game.playerWith7LifeCard).cardsInHand.remove(i);
						game.allPlayers.get(game.playerWith7LifeCard).cardsInHand.add(game.bottomCard);
						game.deck.remove(game.deck.size()-1);
						game.deck.add(currCard);
						game.bottomCard = currCard;
						game.card7Switched = true;
						refreshText();
						break;
					}
				}
				else {
					Card currCard = game.allPlayers.get(game.playerWith2LifeCard).cardsInHand.get(i);
					if ((currCard.suit == game.suitLife) & (currCard.num == 2)) {
						game.allPlayers.get(game.playerWith2LifeCard).cardsInHand.remove(i);
						game.allPlayers.get(game.playerWith2LifeCard).cardsInHand.add(game.bottomCard);
						game.deck.remove(game.deck.size()-1);
						game.deck.add(currCard);
						game.bottomCard = currCard;
						game.card2Switched = true;
						refreshText();
						break;
					}
					
				}
				
			}
		}
		
	}
	
}
