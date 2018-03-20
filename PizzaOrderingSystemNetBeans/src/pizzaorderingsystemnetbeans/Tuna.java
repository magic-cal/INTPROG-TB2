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
public class Tuna extends Topping {

//        Color primaryColour= Color.PINK;
//        Color secondaryColour= Color.RED;
    public Tuna() {
        super(0.08, Color.RED, Color.PINK);

    }

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
