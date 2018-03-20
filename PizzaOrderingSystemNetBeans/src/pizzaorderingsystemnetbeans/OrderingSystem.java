package pizzaorderingsystemnetbeans;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Class to manage the pizza order.
 *
 * @author 825573
 */
public class OrderingSystem {

    private Canvas canvas;
    private PizzaInputs pizzaInputs = new PizzaInputs();
    private ArrayList<Pizza> pizzas = new ArrayList();
    private int currentIndex = 0;
    private PizzaOption[] options;
    private Topping[] availableToppings = {new Tuna(), new Mushroom(), null};

    /**
     * Constructor for the ordering system.
     */
    public OrderingSystem() {
        canvas = new Canvas("Pizza Ordering", 900, 650);
        options = PizzaOption.values();
    }

    /**
     * Method to draw the outline of the order screen.
     */
    public void drawOrderScreen() {

        canvas.setForegroundColor(Color.BLACK);
        // vertical dividers
        canvas.drawLine(300, 0, 300, 600);
        canvas.drawLine(600, 0, 600, 600);

        // halfway divider
        canvas.drawLine(0, 300, 900, 300);

        // total price line
        canvas.drawLine(0, 600, 900, 600);
        canvas.setFontSize(25);
//        canvas.drawString("Total Price of the Order: £"+calculatePrice(0), 10, 640);

    }

    /**
     * Method to manage the ordering of the pizzas.
     */
    public void startOrdering() {

//        System.out.println(pizzaInputs.enterToppings1(new String[]{"tuna", "mushroom"}, availableToppings));
//        pizzas.add(new Pizza(canvas, PizzaOption.LARGE, PizzaOption.THINCRUST, PizzaOption.TOMATO, new Topping[]{availableToppings[1], availableToppings[1]}));
//        pizzas.add(new Pizza(canvas, PizzaOption.MEDIUM, PizzaOption.DEEPPAN, PizzaOption.BBQ, new Topping[]{availableToppings[1], availableToppings[2]}));
//        pizzas.add(new Pizza(canvas, PizzaOption.LARGE, PizzaOption.STUFFEDCRUST, PizzaOption.TOMATO, new Topping[]{availableToppings[1], availableToppings[1]}));
//        pizzas.add(new Pizza(canvas, PizzaOption.SMALL, PizzaOption.DEEPPAN, PizzaOption.BBQ, new Topping[]{availableToppings[0], availableToppings[0]}));
//        pizzas.add(new Pizza(canvas, PizzaOption.SMALL, PizzaOption.STUFFEDCRUST, PizzaOption.BBQ, new Topping[]{availableToppings[1], availableToppings[0]}));
//        pizzas.add(new Pizza(canvas, PizzaOption.MEDIUM, PizzaOption.THINCRUST, PizzaOption.TOMATO, new Topping[]{availableToppings[2], availableToppings[2]}));
//        pizzas.add(new Pizza(canvas, PizzaOption.LARGE, PizzaOption.THINCRUST, PizzaOption.TOMATO, new Topping[]{availableToppings[1], availableToppings[1]}));
//        pizzas.add(new Pizza(canvas, PizzaOption.LARGE, PizzaOption.THINCRUST, PizzaOption.TOMATO, new Topping[]{availableToppings[1], availableToppings[1]}));
//        pizzas.add(new Pizza(canvas, PizzaOption.MEDIUM, PizzaOption.DEEPPAN, PizzaOption.BBQ, new Topping[]{availableToppings[1], availableToppings[2]}));
//        pizzas.add(new Pizza(canvas, PizzaOption.LARGE, PizzaOption.STUFFEDCRUST, PizzaOption.TOMATO, new Topping[]{availableToppings[1], availableToppings[1]}));
//        pizzas.add(new Pizza(canvas, PizzaOption.SMALL, PizzaOption.DEEPPAN, PizzaOption.BBQ, new Topping[]{availableToppings[0], availableToppings[0]}));
//        pizzas.add(new Pizza(canvas, PizzaOption.SMALL, PizzaOption.STUFFEDCRUST, PizzaOption.BBQ, new Topping[]{availableToppings[1], availableToppings[0]}));
//      
//      pizzas.add(new Pizza(canvas, PizzaOption.MEDIUM, PizzaOption.THINCRUST, PizzaOption.TOMATO, new Topping[]{availableToppings[2], availableToppings[2]}));
//      pizzas.add(new Pizza(canvas, PizzaOption.LARGE, PizzaOption.THINCRUST, PizzaOption.TOMATO, new Topping[]{availableToppings[1], availableToppings[1]}));
//        pizzas.add(new Pizza(canvas, PizzaOption.MEDIUM, PizzaOption.THINCRUST, PizzaOption.TOMATO, new Topping[]{availableToppings[2], availableToppings[2]}));
//        pizzas.add(new Pizza(canvas, PizzaOption.MEDIUM, PizzaOption.THINCRUST, PizzaOption.TOMATO, new Topping[]{availableToppings[2], availableToppings[2]}));
        do {
            pizzas.add(choosePizza());
            updateOrderScreen();
        } while (pizzaInputs.proceed("Would you like to input another pizza?"));

        extendedFunctionality();
    }

    /**
     * This generated the 3x2 grid of Pizzas from the ArrayList of Pizzas and
     * displays them on the Canvas through the DisplayPizza method in Pizza
     *
     * @param currentScreen Is an index of which page the user is on. index 0 =
     * first page.
     */
    public void displayPizzas(int currentScreen) {
        for (int i = 0; i < 600 && currentScreen < pizzas.size(); i += 300) {
            for (int j = 0; j <= 600 && currentScreen < pizzas.size(); j += 300, currentScreen++) {
                pizzas.get(currentScreen).displayPizza(j, i);
            }
        }
    }

    /**
     * Using the PizzaInput class, the user can create a Pizza based on inputs.
     *
     * @return returns the chosen Pizza as created by using the PizzaInputs to
     * return the enum or object appropriate to the input.
     */
    public Pizza choosePizza() {
        PizzaOption[] sizes = {options[2], options[3], options[4]};
        PizzaOption[] crusts = {options[5], options[6], options[7]};

        PizzaOption size = pizzaInputs.getInput(new String[]{"small", "medium", "large"}, "Pizza Size", sizes);
        PizzaOption crust = pizzaInputs.getInput(new String[]{"deep pan", "thin crust", "stuffed crust"}, "Pizza Crust", crusts);
        PizzaOption sauce = pizzaInputs.changeSauce();
        Topping[] toppings = pizzaInputs.enterToppings(new String[]{"tuna", "mushroom"}, availableToppings);
        Pizza chosenPizza = new Pizza(canvas, size, crust, sauce, toppings);

        return chosenPizza;
    }

    /**
     *
     * This gets the price from each Pizza on screen and sums their prices.
     *
     * @return The total price of pizzas on the screen
     * @param index Is an index of which page the user is on. index 0 = first
     * page.
     */
    private double calculatePrice(int index) {
        double totPrice = 0;
        for (int i = index; i < index + 6 && index + i < pizzas.size() + index; i++) {
            totPrice += pizzas.get(i).getPrice();
        }
        System.out.println(totPrice + " hgfhf");
        return totPrice;
    }

    /**
     *
     * Calls DrawString Method from Canvas to add new Price to current canvas 
     * of only the current pizzas shown(max 6)
     * @param index Is an index of which page the user is on. index 0 = first
     */
    private void updatePrice(int currentScreen) {
        canvas.setForegroundColor(Color.BLACK);
        canvas.setFontSize(25);
        canvas.drawString("Total Price of the Order: £" + String.format("%.2f", calculatePrice(currentScreen)), 10, 640);
    }

    /**
     *Refreshes the entire screen by removing and redrawing everything by 
     * calling other methods
     *
     *
     */
    private void updateOrderScreen() {
        canvas.erase();
        drawOrderScreen();
        displayPizzas(currentIndex);
        updatePrice(currentIndex);

    }

    /**
     *Sets the current screen index to the New screen index. This updates the
     * current screent to reflect the change.
     * @param newIndex Is an index of which page the user is wanting to see.
     */
    private void changeScreen(int newIndex) {
        currentIndex = newIndex * 6;
        updateOrderScreen();
    }

    /**
     *
     * This function checks if the user would like to use: 
     * Extended functionality,
     * Change Screen
     * and Change/edit pizzas.
     * 
     */
    private void extendedFunctionality() {
        int currentPizza;
        while (pizzaInputs.proceed("Would you like to use extended functionality?")) {
            while (pizzaInputs.proceed("Would you like to switch screens?")) {
                System.out.println(pizzas.size() / 7);
                changeScreen(pizzaInputs.getInput(0, (int) ((pizzas.size() / 7)), "Screen"));
            }
            while (pizzaInputs.proceed("Would you like change and delete pizzas")) {
                System.out.println("pizzas.size+ " + (pizzas.size()));
                currentPizza = pizzaInputs.getInput(0, (pizzas.size() - 1), "Pizza");
                if (pizzaInputs.proceed("Would you like to delete pizza : " + currentPizza)) {
                    pizzas.remove(currentPizza);
                    updateOrderScreen();
                } else if (pizzaInputs.proceed("Would you like to edit pizza : " + currentPizza)) {
                    pizzas.add(currentIndex, choosePizza());
                    updateOrderScreen();
                }

            }

        }

    }
}