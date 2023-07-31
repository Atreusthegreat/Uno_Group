package Uno;

import java.io.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Scanner;

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
	private Scanner scanner;
	
	

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
		
		//have the player turn itrate using nextTurn
		
		//check for winner using checkForWinner() and return public boolean isGameWon()
		
		//then check for uno if isUnoHand() then have it set setUnoHandTrue()
		
		
		//move to next player turn 
		currentturn = true;
	    GameplayGui.updatePlayerHand(currentPlayer); // Update the GUI with the current player's hand

	    // Display the top card on the discard pile in the GUI
	    Card topCard = unoDeck.topOfDiscardPile();
	    GameplayGui.updateDiscardPileLabel(topCard);

	    // Check if the current player has only one card and set the UnoHand flag
	    if (Player.getPlayerHand().size() == 1) {
	        isUnoHand = true;
	    } else {
	        isUnoHand = false;
	    }

	    // Keep asking for the player's move until the turn is finished
	    while (currentturn) {
	        // Ask the player for their move (you need to implement this part)
	        // You can show a dialog or use console input to get the player's move
	        // Here, let's assume the player's move is an index of the card they want to play
	        int move = askForMove();

	        // Check if the move is valid, if not, ask again until a valid move is entered
	        while (!isValidMove(move, topCard)) {
	            move = askForMove();
	        }

	        // Play the card and update the discard pile in the GUI
	        Card playedCard = currentPlayer.removeCard(move);
	        unoDeck.discardCard(playedCard);
	        GameplayGui.updateDiscardPileLabel(playedCard);

	        // Check if the player has won
	        if (Player.getPlayerHand().isEmpty()) {
	            isGameWon = true;
	            currentturn = false; // End the turn
	            return;
	        }

	        // Check for special actions on the card played and handle them
	        handleCardActions(playedCard);

	        // Check if the player has called Uno and set the flag accordingly
	        if (isUnoHand && Player.getPlayerHand().size() > 1) {
	            isUnoHand = false;
	        }

	        // Check if the player has called Uno incorrectly and penalize them
	        if (!isUnoHand && Player.getPlayerHand().size() == 1) {
	            drawTwoCards(currentPlayer);
	            drawTwoCards(currentPlayer);
	        }

	        // If the player played a Skip or Reverse card, end the turn
	        if (playedCard instanceof ActionCard) {
	            Actions action = ((ActionCard) playedCard).getAction();
	            if (action == Actions.SKIP || action == Actions.REVERSE) {
	                currentturn = false;
	            }
	        }

	        // If the player played a Draw Two card, make the next player draw two cards
	        if (playedCard instanceof ActionCard && ((ActionCard) playedCard).getAction() == Actions.DRAWTWO) {
	            Player nextPlayer = players.get((cPI + 1) % players.size());
	            drawTwoCards(nextPlayer);
	            drawTwoCards(nextPlayer);
	        }
	    }
	}
	
	private int askForMove() {
		 scanner = new Scanner(System.in);
		    System.out.print("Enter the index of the card you want to play: ");
		    int move = scanner.nextInt();
		    return move;
	}

	private boolean isValidMove(int move, Card topCard) {
		 // Check if the move is within the bounds of the player's hand
	    if (move < 0 || move >= Player.getPlayerHand().size()) {
	        System.out.println("Invalid move. Please enter a valid index.");
	        return false;
	    }

	    // Check if the selected card matches the color or number of the top card on the discard pile
	    Card selectedCard = Player.getPlayerHand().get(move);
	    if (selectedCard instanceof NumberCard && topCard instanceof NumberCard) {
	        return ((NumberCard) selectedCard).getColor() == ((NumberCard) topCard).getColor()
	                || ((NumberCard) selectedCard).getNumber() == ((NumberCard) topCard).getNumber();
	    } else if (selectedCard instanceof ActionCard && topCard instanceof ActionCard) {
	        return ((ActionCard) selectedCard).getColor() == ((ActionCard) topCard).getColor()
	                || ((ActionCard) selectedCard).getAction() == ((ActionCard) topCard).getAction();
	    } else if (selectedCard instanceof ActionCard && topCard instanceof NumberCard) {
	        return ((ActionCard) selectedCard).getColor() == ((NumberCard) topCard).getColor();
	    } else if (selectedCard instanceof NumberCard && topCard instanceof ActionCard) {
	        return ((NumberCard) selectedCard).getColor() == ((ActionCard) topCard).getColor();
	    } else {
	        return false;
	    }
	}

	private void handleCardActions(Card playedCard) {
		if (playedCard instanceof ActionCard) {
	        Actions action = ((ActionCard) playedCard).getAction();
	        switch (action) {
	            case SKIP:
	                skip();
	                break;
	            case REVERSE:
	                reverse();
	                break;
	            case DRAWTWO:
	                Player nextPlayer = players.get((cPI + 1) % players.size());
	                drawTwoCards(nextPlayer);
	                drawTwoCards(nextPlayer);
	                break;
	            case WILD:
	                colorChange();
	                break;
	            case WILDDRAWFOUR:
	                colorChange();
	                Player nextPlayer1 = players.get((cPI + 1) % players.size());
	                drawTwoCards(nextPlayer1);
	                drawTwoCards(nextPlayer1);
	                drawTwoCards(nextPlayer1);
	                drawTwoCards(nextPlayer1);
	                break;
	            default:
	                break;
	        }
	    }
		
	}

	private void drawTwoCards(Player nextPlayer) {
		  for (int i = 0; i < 2; i++) {
		        nextPlayer.addCard(unoDeck.drawCard());
		    }
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
