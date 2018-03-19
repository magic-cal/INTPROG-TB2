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
    int currentIndex = 0;
    private PizzaOption[] options;
    private Topping[] availableToppings = {new Tuna(), new Mushroom(), null};

//    PizzaOption options  = PizzaOption;
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
     * Method to manage the ordering of the pizzas (once completed).
     */
    public void startOrdering() {

//        System.out.println(pizzaInputs.enterToppings1(new String[]{"tuna", "mushroom"}, availableToppings));
        pizzas.add(new Pizza(canvas, PizzaOption.LARGE, PizzaOption.THINCRUST, PizzaOption.TOMATO, new Topping[]{availableToppings[1], availableToppings[1]}));
        pizzas.add(new Pizza(canvas, PizzaOption.MEDIUM, PizzaOption.DEEPPAN, PizzaOption.BBQ, new Topping[]{availableToppings[1], availableToppings[2]}));
        pizzas.add(new Pizza(canvas, PizzaOption.LARGE, PizzaOption.STUFFEDCRUST, PizzaOption.TOMATO, new Topping[]{availableToppings[1], availableToppings[1]}));
        pizzas.add(new Pizza(canvas, PizzaOption.SMALL, PizzaOption.DEEPPAN, PizzaOption.BBQ, new Topping[]{availableToppings[0], availableToppings[0]}));
        pizzas.add(new Pizza(canvas, PizzaOption.SMALL, PizzaOption.STUFFEDCRUST, PizzaOption.BBQ, new Topping[]{availableToppings[1], availableToppings[0]}));
        pizzas.add(new Pizza(canvas, PizzaOption.MEDIUM, PizzaOption.THINCRUST, PizzaOption.TOMATO, new Topping[]{availableToppings[2], availableToppings[2]}));
//        pizzas.add(new Pizza(canvas, PizzaOption.MEDIUM, PizzaOption.THINCRUST, PizzaOption.TOMATO, new Topping[]{availableToppings[2], availableToppings[2]}));
//        pizzas.add(new Pizza(canvas, PizzaOption.MEDIUM, PizzaOption.THINCRUST, PizzaOption.TOMATO, new Topping[]{availableToppings[2], availableToppings[2]}));
//        do {
//            pizzas.add(choosePizza());
//            System.out.println(pizzas.size());
//        } while (pizzaInputs.proceed("Would you like to input another pizza?"));
////        
        updateOrderScreen();
//        System.out.println("======================");
//        pizzas.add(choosePizza());
//        updateOrderScreen();
        extendedFunctionality();

        try {
            Thread.sleep(5000);
            changeScreen(6);
            updateOrderScreen();
            Thread.sleep(5000);
            System.exit(0);
        } catch (Exception ex) {
            System.out.println("Error");
        }

    }

    public void displayPizzas(int currentScreen) {
        for (int i = 0; i < 600 && currentScreen < pizzas.size(); i += 300) {
            for (int j = 0; j <= 600 && currentScreen < pizzas.size(); j += 300, currentScreen++) {
                pizzas.get(currentScreen).displayPizza(j, i);
            }
        }
    }

//    public Pizza choosePizza() {
//        String size = pizzaInputs.enterSize();
//        String crust = pizzaInputs.enterCrust();
//        boolean changeSauce = pizzaInputs.changeSauce();
//        String[] toppings = pizzaInputs.enterToppings();
//        Pizza chosenPizza = new Pizza(canvas, size, crust, changeSauce, toppings);
//        return chosenPizza;
//    }
    public Pizza choosePizza() {
        PizzaOption[] sizes = {options[2], options[3], options[4]};
        PizzaOption[] crusts = {options[5], options[6], options[7]};

        PizzaOption size = pizzaInputs.getInput(new String[]{"small", "medium", "large"}, "Size", sizes);
        PizzaOption crust = pizzaInputs.getInput(new String[]{"deep pan", "thin crust", "stuffed crust"}, "Crust", crusts);
        PizzaOption sauce = pizzaInputs.changeSauce();
        Topping[] toppings = pizzaInputs.enterToppings(new String[]{"tuna", "mushroom"}, availableToppings);
        Pizza chosenPizza = new Pizza(canvas, size, crust, sauce, toppings);

        return chosenPizza;
    }

    private double calculatePrice(int index) {
        double totPrice = 0;
        for (int i = index; i < index + 6 && index + i < pizzas.size() + index; i++) {
            totPrice += pizzas.get(i).getPrice();
        }
        System.out.println(totPrice + " hgfhf");
        return totPrice;
    }

    private void updatePrice(int currentScreen) {
        canvas.setForegroundColor(Color.BLACK);
        canvas.setFontSize(25);
        canvas.drawString("Total Price of the Order: £" + String.format("%.2f", calculatePrice(currentScreen)), 10, 640);
    }

    private void updateOrderScreen() {
        canvas.erase();
        drawOrderScreen();
        displayPizzas(currentIndex);
        updatePrice(currentIndex);

    }

    private void changeScreen(int newIndex) {
//        if (newIndex % 6 == 0 && pizzas.size() >= newIndex) {
        currentIndex = newIndex * 6;
        updateOrderScreen();

//        } else {
//            System.out.println("that was not a valid page");
//        }
    }

    private void extendedFunctionality() {
        int currentPizza;
        while (pizzaInputs.proceed("Would you like to use extended functionality?")) {
            while (pizzas.size() > 6 && pizzaInputs.proceed("Would you like to switch screens?")) {
                changeScreen(pizzaInputs.getInput(0, (int) (pizzas.size() / 6) + 1, "Screen"));
            }
            while (pizzaInputs.proceed("Would you like change and delete pizzas")) {
                System.out.println("pizzas.size+ "+(pizzas.size()));
                currentPizza = pizzaInputs.getInput(0,(pizzas.size()-1), "Pizza");
                if (pizzaInputs.proceed("Would you like to delete pizza : " + currentPizza)) {
                    pizzas.remove(currentPizza);
                    if(!(pizzas.size()-(currentIndex*6)>0)){
                        changeScreen(currentIndex-1);
                    }
                    updateOrderScreen();
                } else if (pizzaInputs.proceed("Would you like to edit pizza : " + currentPizza)) {
                    pizzas.add(currentIndex, choosePizza());
                    updateOrderScreen();
                }

            }

        }

    }
}
