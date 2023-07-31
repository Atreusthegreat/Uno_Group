package Uno;

import java.io.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;

import uno.GameplayGui;

/*
 * A family-friendly game for all ages
 * 
 * @author Brayden Jones
 * @author Bryson Lott
 * @author Trenton Stratton
 */
@SuppressWarnings("serial")
public class Game implements Serializable {
	
	ArrayList<String> names = new ArrayList<>();
	Deck unoDeck = new Deck();
	ArrayList<Player> players = new ArrayList<>();
	EnumSet<Colors> mainColors = EnumSet.of(Colors.RED, Colors.YELLOW, Colors.GREEN, Colors.BLUE);
	
	//NEW STUFF
	Player currentPlayer; // current player turn
	public int cPI;
	boolean currentturn; // if the turn is still going
	Player selectedPlayer; // player selection for calling UNO on them
	boolean isGameWon; // if there is a winner or not
	boolean isUnoHand; // if a hand has one card
	private ColorMenuGUI colorMenu;
	
	

	// GAME SETUP METHODS
	public Game(ArrayList<String> names) {
		
		  for (String name : names) {
	            joinPlayer(name);
	        }
		unoDeck = new Deck();
		currentPlayer = players.get(0);
		GameplayGui gameplayGui = new Uno.GameplayGui();
		
		gameplayGui.setVisible(true);
		
	} // end of constructor
	
	/*
	 * Adds a player to the game and deals them a hand
	 */
	public void joinPlayer(String name) {
		Player player = new Player(name);
		players.add(player);
		for (int j = 0; j < 7; j++) {
			player.addCard(unoDeck.drawCard());
		}
		//dealPlayerIn(player, unoDeck);
	} // end of joinPlayer()
	
//	/*
//	 * Deals a new player a hand
//	 */
//	private void dealPlayerIn(Player p, Deck d) {
//		for (int j = 0; j < 7; j++) {
//			p.addCard(d.drawCard());
//		}
//	} // end of dealPlayerIn()

	
	





	
	public void StartGame() {
		cPI = 0;
		
		//Add more setup logic if needed
		
		//starts first player's turn
		currentPlayer = players.get(cPI);
		GameplayGui.updatePlayerHand(currentPlayer);
		
		//preform turn 
		while(!checkForWinner()) {
			playersTurn();
			
			cPI = (cPI + 1) % players.size();
			
			currentPlayer = players.get(cPI);
		}
	}
	
	
	
	//Player turn 
	
	public void playersTurn() {
		//get players hand 
		
		//get top card in public Card topOfDiscardPile() to show
		
		//get player
		
		//get players card chose 
		
		//have them play card make sure it is playable 
		
		//have the card discard to top of discard pile and show top card on discard pile 
		
		//have the player turn itrate
		
		//move to next player turn 
		
	}
	
	//GAME PLAY METHODS
	
	public void checkPlayedCard() {
	    Card topCard = unoDeck.topOfDiscardPile();
	    if (topCard instanceof ActionCard) {
	        Actions action = ((ActionCard) topCard).getAction();
	        switch (action) {
	            case SKIP:
	                skip();
	                
	                break;
	            case REVERSE:
	                reverse();
	                
	                break;
	            case DRAWTWO:
	                Player nextPlayer = players.get((cPI + 1) % players.size());
	                for (int i = 0; i < 2; i++) {
	                    nextPlayer.addCard(unoDeck.drawCard());
	                }
	                
	                break;
	            case WILD:
	            	colorChange();
	            	
	                break;
	            case WILDDRAWFOUR:
	            	colorChange();
	            	Player nextPlayer1 = players.get((cPI + 1) % players.size());
	                for (int i = 0; i < 4; i++) {
	                    nextPlayer1.addCard(unoDeck.drawCard());
	                }
	                
	                break;
	            default:
	          
	                break;
	        }
	    }
	}
	
	/*
		
	public void checkPlayedCard() {
		if (((ActionCard) unoDeck.topOfDiscardPile()).getAction() == Actions.SKIP) {
			skip();
		} else if (((ActionCard) unoDeck.topOfDiscardPile()).getAction() == Actions.REVERSE) {
			reverse();
		} else if (((ActionCard) unoDeck.topOfDiscardPile()).getAction() == Actions.DRAWTWO) {
			// next player in players<>.playerHand.add(unoDeck.drawCard());
			// 2x
			
		} else if (((ActionCard) unoDeck.topOfDiscardPile()).getAction() == Actions.WILD) {
			// colorChange()
		} else if (((ActionCard) unoDeck.topOfDiscardPile()).getAction() == Actions.WILDDRAWFOUR) {
			// next player in players<>.playerHand.add(unoDeck.drawCard());
			// 4x
			// colorChange()
		} else {
			// just a numberCard
			// load it into a variable so you can check it against what the next player wants to play?
		}
	}
	*/
	
	
	
	//checks for winner
	private boolean checkForWinner() {
		if(currentPlayer.getPlayerHand().isEmpty()) {
			return true;
		}else 
		return false;
	}
	
	//if current player has less then one card
	public boolean isUnoHand() {
		if(currentPlayer.getPlayerHand().size() == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public void setUnoHandTrue() {
		if(currentPlayer.getPlayerHand().size() == 1) {
			boolean isUnoHand = true;
		}
		boolean isUnoHand = false;
	}
	
	public void setUnoHandFalse() {
		boolean isUnoHand = false;
	}
	
	//checks for empty hand of any player 
	public boolean isGameWon() {
		if(currentPlayer.getPlayerHand().size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//gets next player 
	public void nextTurn() {
		if (currentturn) {
			cPI = (cPI + 1) % players.size();
			if(cPI == -1) {
				cPI = 0;
			}
			
			currentPlayer = players.get(cPI);
		}
	}
	
	//gets the players hand 
	public ArrayList<Card> getHand(Object object) {
		return currentPlayer.getPlayerHand();
	}
	
	
	//gets the card info from player or card??
	public void getCardInfo(int i) {
		currentPlayer.showCard(i);
	}	
	//plays card player places??
	public void discard(int cardIndex) {
		currentPlayer.removeCard(cardIndex);
		unoDeck.discardCard(currentPlayer.removeCard(cardIndex));
	}
	
	
	
	
	//skips next players turn if skipped
//	public void skip() {
//
//		if (currentPlayer.getCard().getAction() == Actions.SKIP) {
//			currentPlayer = players.get((players.indexOf(currentPlayer) + players.size() + 2) % players.size());
//		}
//	}
	
	
	private void skip() {	
		
		// skip over next player in players<>
			cPI = (cPI + 1) % players.size();
			if(cPI == -1) {
				cPI = 0;
			currentPlayer = players.get(cPI);
		}
	}
	
	//reverse directions of players 
	private void reverse() {
		
		Collections.reverse(players);
		
	}
	
	//for wild cards to change to players wanted color
	private void colorChange() {
		if(colorMenu == null) {
			colorMenu = new ColorMenuGUI();
		}
		
		colorMenu.setVisible(true);
		Colors chosenColor = colorMenu.getSelectedColor();
		mainColors = EnumSet.of(chosenColor);
		
		colorMenu.setVisible(false);
	}
	
	

	
	
	// TEST METHODS FOR TESTING THE THINGS THAT NEED TO BE TESTED
	public void printDeck() {
		int count = 0;
		System.out.println("\nDraw Pile: ");
		for (Card c : unoDeck.drawPile) {
			System.out.println(c);
			count++;
		}
		System.out.println(count);
		System.out.println();
		count = 0;
		System.out.println("\nDiscard Pile: ");
		for (Card c : unoDeck.discardPile) {
			System.out.println(c);
			count++;
		}
		System.out.println(count);
	} // end of printDeck()
	
	public void printPlayers() {
		for (Player p : players) {
			System.out.println(p.getPlayerName());
		}
	} // end of printPlayers()
	
	public void printPlayersHands() {
		for (Player p : players) {
			System.out.println(p.getPlayerName() + "'s hand:");
			for (Card c : p.getPlayerHand()) {
				System.out.println(c);
			}
			System.out.println();
		}
	} // end of printPlayersHands

	public Object getCurrentPlayer() {
		return currentPlayer;
	}
	

} // end of Game
