/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorderingsystemnetbeans;

import java.awt.Color;

/**
 *
 * @author up825573
 */
public class Mushroom extends Topping {

//    Canvas canvas;
    public Mushroom() {
        super(0.05, Color.GRAY, Color.LIGHT_GRAY);
    }

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
