package pizzaorderingsystemnetbeans;

import java.awt.*;

/**
 * Class to represent a single pizza.
 *
 * @author 825573
 */
public class Pizza {

    private Canvas canvas;
    private double topLeftX;
    private double topLeftY;

    /**
     * Constructor for pizza.
     *
     * @param win the window to draw the pizza on
     * @param startX the top-left x coordinate for the section of screen to draw
     * pizza on
     * @param startY the top-left y coordinate for the section of screen to draw
     * pizza on
     */
    public Pizza(Canvas win, double startX, double startY) {
        canvas = win;
        topLeftX = startX;
        topLeftY = startY;
        System.out.println(topLeftX +" "+ topLeftY);

    }

    /**
     * Method to display the pizza information on the screen.
     */
    public void displayPizza() {
        drawPizza();
        drawBottomLine();
        drawTopLine();
        drawToppings();

//        try {
//            Thread.sleep(10000);
//            System.exit(0);
//        } catch (Exception ex) {
//            System.out.println("Error");
//        }

    }

    /**
     * Method to display the pizza on the screen.
     */
    private void drawPizza() {
        canvas.setForegroundColor(Color.YELLOW);
        canvas.fillCircle(topLeftX + 150, topLeftY + 150, 200);
        if(1!=1){
        canvas.setForegroundColor(Color.RED);
        }else{
        canvas.setForegroundColor(Color.ORANGE);
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
        String topLine = "Pizza";

        double stringX = topLeftX + 10;
        double stringY = topLeftY + 25;

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
        String bottomLine = "Crust: ";

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
//                    drawMushroom(x+j,y+i);
                    drawTuna(x + j, y + i);
                } else {
//                    drawTuna(x + j, y + i);
                    drawMushroom(x+j,y+i);
                }

            }
        }

    }

    public double getPrice() {

        return 2.2;
    }

}
