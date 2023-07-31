package Uno;

/*
 * One of two types of Uno card.
 * 
 * @author Brayden Jones
 * @author Bryson Lott
 * @author Trenton Stratton
 */
@SuppressWarnings("serial")
public class ActionCard extends Card {

	private Actions action;

	/*
	 * Class constructor
	 * 
	 * @param c		a color
	 * @param a		an action
	 */
    public ActionCard(Colors c, Actions a) {
        super (c);
    	action = a;
    } // end of constructor
    
    /*
     * Getter for a card's action
     * 
     * @return action		the action type
     */
    public Actions getAction() {
        return action;
    } // end of getAction()

    @Override
    public String toString() {
    	return super.toString() + " " + action;
    } // end of toString()
    
    
} // end of ActionCard