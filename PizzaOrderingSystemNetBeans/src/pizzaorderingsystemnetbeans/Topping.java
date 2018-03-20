/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorderingsystemnetbeans;

/**
 *
 * @author up825573
 */
import java.awt.Color;

public class Topping {

    protected double price;
    protected Color primaryColour;
    protected Color secondaryColour;

    public Topping(double pPrice, Color pPrimaryColour, Color pSecondaryColour) {

        price = pPrice;
        primaryColour = pPrimaryColour;
        secondaryColour = pSecondaryColour;
    }

    public double getPrice() {
        return price;
    }

    public void draw(double x, double y, Canvas canvas) {
        System.out.println("Error, Nothing to draw");
    }

}
