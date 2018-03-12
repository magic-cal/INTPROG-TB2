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
    public Mushroom(Canvas pCanvas){
        super(pCanvas,0.04,Color.GRAY,Color.LIGHT_GRAY);
        
//        canvas = pCanvas;
    }
    
    public void drawMushroom(double x, double y) {
        canvas.setForegroundColor(Color.lightGray);
        canvas.fillRectangle(x - 4, y, 8, 15);
        canvas.fillSemiCircle(x - 13, y - 13, 26, 27, false, true);
        canvas.setForegroundColor(Color.GRAY);
        canvas.fillRectangle(x - 2, y, 4, 13);
        canvas.fillSemiCircle(x - 10, y - 10, 20, 20, false, true);
    }
    
    public String outputHi(){     
        System.out.println("HI");
        return "hi";
    }
}
