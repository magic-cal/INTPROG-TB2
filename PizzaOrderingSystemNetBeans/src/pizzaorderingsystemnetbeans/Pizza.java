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
    private PizzaOption size;
    private PizzaOption crust;
    private PizzaOption sauce;
    private Topping[] toppings;
    private double area;
    private Tuna tuna;
    private Mushroom mushroom;

    /**
     * Constructor for pizza.
     *
     * @param win the window to draw the pizza on
     */
    public Pizza(Canvas win, PizzaOption pizzaSize, PizzaOption pizzaCrust, PizzaOption pizzaSauce, Topping[] pizzaToppings) {
        canvas = win;
        size = pizzaSize;
        crust = pizzaCrust;
        sauce = pizzaSauce;
        toppings = pizzaToppings;

        tuna = new Tuna();
        mushroom = new Mushroom();

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
     */
    private void drawTopLine() {
        String topLine = "Pizza (" + size.getName() + ")";

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

//    private void drawTopping(String topping, double x, double y) {
//        if (topping != null) {
//            if (topping.equalsIgnoreCase("tuna")) {
//                tuna.drawTuna(x, y);
//            } else if (topping.equalsIgnoreCase("mushroom")) {
//                mushroom.drawMushroom(x, y);
//            } else {
//                System.out.println("Error: invalid topping");
//            }
//        }
//    }
    public double getPrice() {
        double price = 0;
        System.out.println("size" + size.getSize());
        System.out.println("crust " + crust.getPrice());
        price += crust.getPrice() * size.getSize();
        price += sauce.getPrice();
        for (int i = 0; i < toppings.length; i++) {
            if (toppings[i] != null) {
                price += (5 - i) * toppings[i].getPrice();
            }
        }
        return Math.round(price * 100d) / 100d;
    }

    public void setSize(PizzaOption newSize) {
        size = newSize;
    }

    public void setCrust(PizzaOption newCrust) {
        crust = newCrust;
    }

    public void setBbq(PizzaOption newSauce) {
        sauce = newSauce;
    }

    public void setTopping(Topping[] newToppings) {
        toppings = newToppings;
    }

}
