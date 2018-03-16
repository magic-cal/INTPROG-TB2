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
    
    protected Canvas canvas;
    protected double price;
    protected Color primaryColour;
    protected Color secondaryColour;
    
    public Topping(Canvas pCanvas,double pPrice,Color pPrimaryColour,Color pSecondaryColour){
        canvas = pCanvas;
        price = pPrice;
        primaryColour = pPrimaryColour;
        secondaryColour = pSecondaryColour;
    }

    public double getPrice(){
        return price;
    }
    
    
    
}
