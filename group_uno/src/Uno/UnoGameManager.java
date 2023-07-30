package uno;

import java.io.*;
import java.util.Scanner;

import javax.swing.JPanel;

/*
 * Manages an Uno game.
 * Creates, saves, and loads the game.
 * 
 * @author Brayden Jones
 * @author Bryson Lott
 * @author Trenton Stratton
 */
@SuppressWarnings("serial")
public class UnoGameManager implements Serializable {

	static Scanner input = new Scanner(System.in);
	static Game game;
	static String choice = "";
	
	public static void main(String[] args) {


		
		
		while (!choice.equals("y")) {
			System.out.println("Start a new game? (y or n)");
			choice = input.next();
			if (choice.equals("y")) {
				newGame();
				
				saveGame(game);
				
				System.out.println("NEW GAME STATE"); //FOR TESTING
				gameTester(game); //FOR TESTING
				
			} else {
				System.out.println("Load a saved game? (y or n)");
				choice = input.next();
				if (choice.equals("y")) {
					loadGame();
					
					System.out.println("LOADED GAME STATE"); //FOR TESTING
					gameTester(game); //FOR TESTING
				}
			}
		}
		
		


		
		// BRAYDENS STUFF
//		public static void main(String[] args) {
		//
//				Deck deck = new Deck();
//				
//				do {
//					System.out.println("Enter the number of players (2-4): ");
//					playerCount = scnr.nextInt();
//				} while(playerCount < 2 || playerCount > 4);
//				
//				System.out.println("Number of players: " + playerCount);
//				
//				for (int i = 1; i <= playerCount; i++) {
//			        System.out.println("Enter name for Player " + i + ": ");
//			        String name = scnr.next();
//			        Player p = new Player(name);
		//
//			        // Give each player 7 cards from the deck
//			        for (int j = 0; j < 7; j++) {
//			            Card drawnCard = deck.drawCard();
//			            if (drawnCard != null) {
//			                p.getPlayerHand().add(drawnCard);
//			            } else {
//			                System.out.println("The deck is empty. No more cards to deal.");
//			                break;
//			            }
//			        }
		//
//			        players.add(p);
//			    }
//				
//				for (Player p : players) {
//					System.out.println("Player Name: " + p.getPlayerName());
//					System.out.println("Player Hand: ");
//					for(Card card: p.getPlayerHand()) {
//						System.out.println(card + " ");
//					}
//					System.out.println();
//				}
		
	

		
		
		input.close();

	} // end of main()
	
	
	// TEST METHOD
	public static void gameTester(Game game) {
		System.out.println();
		game.printDeck();
		System.out.println();
		game.printPlayers();
		System.out.println();
		game.printPlayersHands();
	}
	
	
	/*
	 * Creates a new game
	 * 
	 * @return game
	 */
	public static Game newGame() {
		game = new Game();
		
		System.out.print("How many people are playing?  ");
		int numPlaying = input.nextInt();
		for (int i = 0; i < numPlaying; i++) {
			System.out.println("\nEnter player " + (i+1) + "'s name:  ");
			game.joinPlayer(input.next());
		}
		JPanel enterplayers = new JPanel() {
			
		}
		
		System.out.println("New game started.");
		
		return game;
	} // end of newGame()

	
	/*
	 * Loads a previously saved game from a file.
	 * Reads from a file and deserializes the game object
	 * 
	 * @return game
	 */
	public static Game loadGame() {
		game = null;
		
		try ( FileInputStream fis = new FileInputStream("savedGame.ser");
				ObjectInputStream ois = new ObjectInputStream(fis) ) {
	
			game = (Game) ois.readObject();
			ois.close();
			fis.close();
			
			System.out.println("Game is loaded");
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Serialization Error! Can't load data.");
		}
		
		return game;
	} // end of loadGame()

	
	/*
	 * Saves the current game state to a file.
	 * Serializes the game object and writes it to a file, overwriting that file
	 */
	public static void saveGame(Game g) {	
		try ( FileOutputStream fos = new FileOutputStream("savedGame.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			
			oos.writeObject(g);
			oos.close();
			fos.close();
			
			System.out.println("Game is saved");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Serialization Error! Can't save data.");
		}
	} // end of saveGame()
	

} // end of GameManager
