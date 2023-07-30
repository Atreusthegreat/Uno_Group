package uno;


/*
 * One of two types of Uno card.
 * 
 * @author Brayden Jones
 * @author Bryson Lott
 * @author Trenton Stratton
 */
@SuppressWarnings("serial")
public class NumberCard extends Card {
    
	private int number;
    
	/*
	 * Class constructor
	 * 
	 * @param c		a color
	 * @param n		an int describing card's value
	 */
    public NumberCard(Colors c, int n) {
    	super (c);
        number = n;
    } // end of constructor
    
    /*
     * Getter for a card's value
     * 
     * @return number		the int describing the value
     */
	public int getNumber() {
        return number;
    } // end of getNumber()
	
	@Override
    public String toString() {
    	return super.toString() + " " + number;
    } // end of toString()
	
	
} // end of NumberCard