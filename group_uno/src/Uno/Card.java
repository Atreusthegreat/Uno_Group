package Uno;

import java.io.Serializable;

/*
 * Abstract class for creating Uno cards
 * 
 * @author Brayden Jones
 * @author Bryson Lott
 * @author Trenton Stratton
 */
@SuppressWarnings("serial")
public abstract class Card implements Serializable {
	
    private Colors color;
//    private Types type;
    
    
    /*
     * Class constructor
     * 
     * @param c		a color
     */
    public Card(Colors c) {
        color = c;
    } // end of constructor
    
//    public Card(Types type) {
//        this.type = type;
//    }
    
    /*
     * Getter for a card's action
     * 
     * @return color		the color
     */
    public Colors getColor() {
        return color;
    } // end of getColor()

//    public Types getType() {
//        return type;
//    }
    
    @Override
    public String toString() {
    	return this.getClass().getSimpleName() + ": " + color;
    } // end of toString()
    
    
} // end of Card