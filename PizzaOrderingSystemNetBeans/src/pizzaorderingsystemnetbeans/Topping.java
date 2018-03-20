
package pizzaorderingsystemnetbeans;

import java.awt.Color;

/**
 *Class Topping is a generalized class to allow inheritance to other sub-toppings
 * @author 825573
 */
public class Topping {

    private double price;
    protected Color primaryColour;
    protected Color secondaryColour;

    /**
     * Constructor for a generalised Topping
     * @param pPrice Price per piece of topping.
     * @param pPrimaryColour The main colour of the topping.
     * @param pSecondaryColour The accent colour of the topping.
     */
    public Topping(double pPrice, Color pPrimaryColour, Color pSecondaryColour) {

        price = pPrice;
        primaryColour = pPrimaryColour;
        secondaryColour = pSecondaryColour;
    }

    /**
     * generalised method to get the price of one piece of the topping
     * @return returns the price of a specific topping
     */             
    public double getPrice() {
        return price;
    }

    /**
     * generalised method to draw a topping 
     * @param x X coordinate of the centre point of the topping to draw.
     * @param y Y coordinate of the centre point of the topping to draw.
     * @param canvas Canvas to which the topping is to be drawn.
     */
    public void draw(double x, double y, Canvas canvas) {
        System.out.println("Error, Nothing to draw");
    }

}
