/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorderingsystemnetbeans;

import java.awt.Color;

/**
 *Class Tuna Inherits from Toppings and stores all data about a Tuna object 
 * @author up825573
 */
public class Tuna extends Topping {

//        Color primaryColour= Color.PINK;
//        Color secondaryColour= Color.RED;

    /**
     *Constructor for a Tuna subclass of Topping
     */
    public Tuna() {
        super(0.08, Color.RED, Color.PINK);

    }

    @Override
    /**
     * Method to draw one Tuna at the center point of X and Y 
     * @param x X coordinate of the center point of the topping to draw.
     * @param y Y coordinate of the center point of the topping to draw.
     * @param canvas Canvas to which the topping is to be drawn.
     */
    public void draw(double x, double y, Canvas canvas) {
        for (int i = 0; i <= 30; i += 6) {
            if (i % 12 != 0) {
                canvas.setForegroundColor(secondaryColour);
            } else {
                canvas.setForegroundColor(primaryColour);
            }
            canvas.fillTriangle(x + 15 - i / 2, y + 15 - i, x - 15 + i / 2, y + 15 - i, x, y - 15);
        }
    }
}
