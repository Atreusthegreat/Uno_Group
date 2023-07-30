package uno;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;

/*
 * Manages an Uno deck, using two ArrayLists-- 
 * one for a draw pile and another for a discard pile.
 * 
 * @author Brayden Jones
 * @author Bryson Lott
 * @author Trenton Stratton
 */
@SuppressWarnings("serial")
public class Deck implements Serializable {
	
	ArrayList<Card> drawPile = new ArrayList<>();
	ArrayList<Card> discardPile;
	
	private EnumSet<Colors> mainColors = EnumSet.of(Colors.RED, Colors.YELLOW, Colors.GREEN, Colors.BLUE);
	private EnumSet<Actions> coloredActions = EnumSet.of(Actions.SKIP, Actions.REVERSE, Actions.DRAWTWO);
	private EnumSet<Actions> blackActions = EnumSet.of(Actions.WILD, Actions.WILDDRAWFOUR);
	
	/*
	 * Class constructor
	 * 
	 * 19  Red numbered cards – 0 (one of each), 1 to 9 (two of each)
	 * 19  Blue numbered cards – 0 (one of each), 1 to 9 (two of each)
	 * 19  Green numbered cards – 0 (one of each), 1 to 9 (two of each)
	 * 19  Yellow numbered cards – 0 (one of each), 1 to 9 (two of each)
	 * 8   Skip cards – two cards of each main color
	 * 8   Reverse cards – two cards of each main color
	 * 8   Draw 2 cards – two cards of each main color
	 * 8   Black cards – four Wild cards and four Wild Draw 4 cards
	 */
	public Deck() {
		
//		drawPile = new ArrayList<>();
		discardPile = new ArrayList<>();
		
		// create numbered cards (main colors - 0 to 9)
		for (Colors c : mainColors) {
			for (int i = 0; i <= 9; i++) {
				if (i == 0) {
					drawPile.add(new NumberCard(c, i));
				} else {
					drawPile.add(new NumberCard(c, i));
					drawPile.add(new NumberCard(c, i));
				}
			}
		}
			
		// create skip, reverse, and draw action cards (two of each action in each main color)
		for (Colors c : mainColors) {
			for (Actions a : coloredActions) {
				drawPile.add(new ActionCard(c, a));
				drawPile.add(new ActionCard(c, a));
			}
		}
		
		// create wild and wild draw four action cards (four of each action)
		for (Actions a : blackActions) {
			drawPile.add(new ActionCard(Colors.BLACK, a));
			drawPile.add(new ActionCard(Colors.BLACK, a));
			drawPile.add(new ActionCard(Colors.BLACK, a));
			drawPile.add(new ActionCard(Colors.BLACK, a));
		}
		
		Collections.shuffle(drawPile);
		firstDiscard();
	} // end of constructor
	
	
	/* 
	 * Sets up the discard pile for the first player to play onto.
	 * Continues drawing and discarding until a non-action card is drawn.
	 */
	private void firstDiscard() {
		if(drawPile.get(0) instanceof ActionCard) {
			while (drawPile.get(0) instanceof ActionCard) {
				discardPile.add(drawPile.remove(0));
			}
		}
		discardPile.add(drawPile.remove(0));
	} // end of firstDiscard()
	
	/* 
	 * Shows the last card played
	 * 
	 * @return 		the card on the top of discard pile
	 */
	public Card topOfDiscardPile() {
		return discardPile.get(discardPile.size() - 1);
	} // end of topOfDiscardPile()
	
	/* 
	 * Removes the top card from the deck and gives that card.
	 * Checks prior and if there are zero cards left, pulls all 
	 * but the last played from the discard pile, adds to the
	 * draw pile, and shuffles.
	 * 
	 * @return		the card on the top of the draw deck
	 */
	public Card drawCard() {
		if (drawPile.size() == 0) {
			while (discardPile.size() > 1) {
				drawPile.add(discardPile.get(0));
				discardPile.remove(0);
			}
			Collections.shuffle(drawPile);
		}
		return drawPile.remove(0);
	} // end of drawCard()
	
	/* 
	 * Receives a card and adds it to the discard pile
	 * 
	 * @param c		the card to discard
	 */
	public void discardCard(Card c) {
		discardPile.add(c); // add logic in GameManager that prevents discard unless color or type matches
	} // end of discardCard()
	
	
} // end of Deck


