/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorderingsystemnetbeans;

import java.awt.Color;

/**
 * Class Tuna Inherits from Toppings and stores all data about a Tuna object
 *
 * @author up825573
 */
public class Mushroom extends Topping {

    /**
     * Constructor for a Mushroom subclass of Topping
     */
    public Mushroom() {
        super(0.05, Color.GRAY, Color.LIGHT_GRAY);
    }

    /**
     * Method to draw one Mushroom at the center point of X and Y
     *
     * @param x X coordinate of the center point of the topping to draw.
     * @param y Y coordinate of the center point of the topping to draw.
     * @param canvas Canvas to which the topping is to be drawn.
     */
    @Override
    public void draw(double x, double y, Canvas canvas) {
        canvas.setForegroundColor(secondaryColour);
        canvas.fillRectangle(x - 4, y, 8, 15);
        canvas.fillSemiCircle(x - 13, y - 13, 26, 27, false, true);
        canvas.setForegroundColor(primaryColour);
        canvas.fillRectangle(x - 2, y, 4, 13);
        canvas.fillSemiCircle(x - 10, y - 10, 20, 20, false, true);
    }

}
