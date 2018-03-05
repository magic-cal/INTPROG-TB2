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
    /*
    
    todo Change type. 
     */
//    TODO
    String size;
    String crust;
    boolean bbqSauce;
    String[] toppings;
    double area = 0;

    /**
     * Constructor for pizza.
     *
     * @param win the window to draw the pizza on
     */
    public Pizza(Canvas win, String pizzaSize, String pizzaCrust, boolean pizzaSauce, String[] pizzaToppings) {
        canvas = win;
        size = pizzaSize;
        crust = pizzaCrust;
        bbqSauce = pizzaSauce;
        toppings = pizzaToppings;
        int radius = 0;
        if (size.equals("small")) {
            radius = 5;
        } else if (size.equals("medium")) {
            radius = 6;
        } else if (size.equals("large")) {
            radius = 7;
        } else {
            System.out.println("Pizza Size Error");
        }
        area = Math.round(Math.PI * Math.pow(radius, 2) * 100d) / 100d;

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
    public void displayPizza(double startX, double startY) {

        topLeftX = startX;
        topLeftY = startY;
        drawPizza();
        drawBottomLine();
        drawTopLine();
        drawToppings();

    }

    /**
     * Method to display the pizza on the screen.
     */
    private void drawPizza() {
        canvas.setForegroundColor(Color.YELLOW);
        canvas.fillCircle(topLeftX + 150, topLeftY + 150, 200);
        if (bbqSauce) {
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
     */
    private void drawTopLine() {
        String topLine = "Pizza (" + size + ")";

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
     * crust and sauce ordered (once completed)
     */
    private void drawBottomLine() {

        String sauce = "Tomato Sauce";
        if (bbqSauce) {
            sauce = "BBQ Sauce";
        }

        String bottomLine = "Crust: " + crust + ", " + sauce;

        double stringX = topLeftX + 10;
        double stringY = topLeftY + 290;

        canvas.setForegroundColor(Color.BLACK);
        canvas.setFontSize(15);
        canvas.drawString(bottomLine, stringX, stringY);
    }

    private void drawMushroom(double x, double y) {
        canvas.setForegroundColor(Color.lightGray);
        canvas.fillRectangle(x - 4, y, 8, 15);
        canvas.fillSemiCircle(x - 13, y - 13, 26, 27, false, true);
        canvas.setForegroundColor(Color.GRAY);
        canvas.fillRectangle(x - 2, y, 4, 13);
        canvas.fillSemiCircle(x - 10, y - 10, 20, 20, false, true);
    }

    private void drawTuna(double x, double y) {

        for (int i = 0; i <= 30; i += 6) {
            if (i % 12 != 0) {
                canvas.setForegroundColor(Color.PINK);
            } else {
                canvas.setForegroundColor(Color.RED);
            }
            canvas.fillTriangle(x + 15 - i / 2, y + 15 - i, x - 15 + i / 2, y + 15 - i, x, y - 15);
        }
    }

    private void drawToppings() {
        double x = topLeftX + 110;
        double y = topLeftY + 105;
        for (int i = 0; i < 120; i += 40) {
            for (int j = 0; j < 120; j += 40) {
                if ((i + j) % 80 == 0) {
                    drawTopping(toppings[0], x + j, y + i);
                } else {
                    drawTopping(toppings[1], x + j, y + i);
                }

            }
        }

    }

    private void drawTopping(String topping, double x, double y) {
        if (topping != null) {
            if (topping.equals("tuna")) {
                drawTuna(x, y);
            } else if (topping.equals("mushroom")) {
                drawMushroom(x, y);
            } else {
                System.out.println("Error: invalid topping");
            }
        }

    }

    public double getPrice() {
        double price = 0;
        double basePrice = 0;
//           What crust is the pizza
        if (crust.equals("deep pan")) {
            basePrice = 0.11;
        } else if (crust.equals("thin crust")) {
            basePrice = 0.08;
        } else if (crust.equals("stuffed crust")) {
            basePrice = 0.14;
        } else {
            System.out.println("base Pricing error");
        }
//           what sauce is the pizza
        if (bbqSauce) {
            price += 0.50;
        }
        for (int i = 0; i <= 1; i++) {
            if (toppings[i] != null && toppings[i].equals("tuna")) {
                price += 0.02 * (5 - i);
            } else if (toppings[i] != null) {
                price += 0.05 * (5 - i);
            }
        }
        price += basePrice * area;

        return Math.round(price * 100d) / 100d;
    }

    public void printAll() {
        System.out.println(size + crust + bbqSauce + toppings.toString());

    }
}
