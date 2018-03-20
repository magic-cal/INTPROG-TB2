package pizzaorderingsystemnetbeans;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to represent a single pizza.
 *
 * @author 825573
 */
public class Pizza {

    private Canvas canvas;
    private double topLeftX;
    private double topLeftY;
    private PizzaOption size;
    private PizzaOption crust;
    private PizzaOption sauce;
    private Topping[] toppings;

    /**
     * Constructor for Pizza.
     *
     * @param win the window to draw the pizza on
     * @param pizzaSize Enum of PizzaOption of the Size of the pizza
     * @param pizzaCrust Enum of PizzaOption of the Crust of the pizza
     * @param pizzaSauce Enum of PizzaOption of the Sauce of the pizza
     * @param pizzaToppings An array of Toppings from the Topping Class
     */
    public Pizza(Canvas win, PizzaOption pizzaSize, PizzaOption pizzaCrust, PizzaOption pizzaSauce, Topping[] pizzaToppings) {
        canvas = win;
        size = pizzaSize;
        crust = pizzaCrust;
        sauce = pizzaSauce;
        toppings = pizzaToppings;

    }

    /**
     * Method to display the pizza information on the screen.
     *
     * @param startX the top-left x coordinate for the section of screen to draw
     * pizza on
     * @param startY the top-left y coordinate for the section of screen to draw
     * pizza on
     *
     */
    public void displayPizza(double startX, double startY,int pizzaNo) {
//ADD FUNC NO
        topLeftX = startX;
        topLeftY = startY;
        drawPizza();
        drawBottomLine();
        drawTopLine(pizzaNo);
        drawToppings();

    }

    /**
     * Method to display the pizza on the screen.
     */
    private void drawPizza() {
        canvas.setForegroundColor(Color.YELLOW);
        canvas.fillCircle(topLeftX + 150, topLeftY + 150, 200);
        if (sauce == PizzaOption.BBQ) {
            canvas.setForegroundColor(Color.ORANGE);
        } else {
            canvas.setForegroundColor(Color.RED);
        }
        canvas.fillCircle(topLeftX + 150, topLeftY + 150, 175);

        canvas.setForegroundColor(Color.WHITE);
        canvas.fillCircle(topLeftX + 150, topLeftY + 150, 155);
    }

    /**
     * Method to write the information shown in the bottom line of the
     * individual pizza on the screen. This method will display the pizza number
     * and size at the top of the screen (once completed)
     * @param pizzaNo is the index/reference number of the current pizza
     */
    private void drawTopLine(int pizzaNo) {
        String topLine = "Pizza "+(pizzaNo+1)+" (" + size.getName() + ")";

        double stringX = topLeftX + 10;
        double stringY = topLeftY + 25;
        System.out.println("top " + topLeftY);

        canvas.setForegroundColor(Color.BLACK);
        canvas.setFontSize(15);
        canvas.drawString(topLine, stringX, stringY);
    }

    /**
     * Method to write the information shown in the bottom line of the
     * individual pizza on the screen. This method will display the type of
     * crust and sauce ordered.
     */
    private void drawBottomLine() {
        String bottomLine = "Crust: " + crust.getName() + ", " + sauce.getName();

        double stringX = topLeftX + 10;
        double stringY = topLeftY + 290;

        canvas.setForegroundColor(Color.BLACK);
        canvas.setFontSize(15);
        canvas.drawString(bottomLine, stringX, stringY);
    }

//    private void drawTuna(double x, double y) {
//
//        for (int i = 0; i <= 30; i += 6) {
//            if (i % 12 != 0) {
//                canvas.setForegroundColor(Color.PINK);
//            } else {
//                canvas.setForegroundColor(Color.RED);
//            }
//            canvas.fillTriangle(x + 15 - i / 2, y + 15 - i, x - 15 + i / 2, y + 15 - i, x, y - 15);
//        }
//    }
//    public void drawMushroom(double x, double y) {
//        canvas.setForegroundColor(Color.lightGray);
//        canvas.fillRectangle(x - 4, y, 8, 15);
//        canvas.fillSemiCircle(x - 13, y - 13, 26, 27, false, true);
//        canvas.setForegroundColor(Color.GRAY);
//        canvas.fillRectangle(x - 2, y, 4, 13);
//        canvas.fillSemiCircle(x - 10, y - 10, 20, 20, false, true);
//    }
    /**
     * Chooses where to draw each topping based on the pizzas top left
     * coordinates and then calls the draw of the appropriate topping.
     */
    private void drawToppings() {
        double x = topLeftX + 110;
        double y = topLeftY + 105;
        for (int i = 0; i < 120; i += 40) {
            for (int j = 0; j < 120; j += 40) {
                if ((i + j) % 80 == 0) {
                    if (toppings[0] != null) {
                        toppings[0].draw(x + j, y + i, canvas);
                    }
                } else if (toppings[1] != null) {
                    toppings[1].draw(x + j, y + i, canvas);
                }
            }

        }
    }
    
    /**
     * Calculates the price of the entire pizza and returns it. 
     * @return returns the price calculated by the chosen requirements of the 
     * pizza.
     */
    public double getPrice() {
        double price = 0;
        System.out.println("size" + size.getArea());
        System.out.println("crust " + crust.getPrice());
        price += crust.getPrice() * size.getArea();
        price += sauce.getPrice();
        for (int i = 0; i < toppings.length; i++) {
            if (toppings[i] != null) {
                price += (5 - i) * toppings[i].getPrice();
            }
        }
        return Math.round(price * 100d) / 100d;
    }

}
