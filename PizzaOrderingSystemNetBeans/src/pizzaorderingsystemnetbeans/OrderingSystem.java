package pizzaorderingsystemnetbeans;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

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
    private Topping[] availableToppings = {new Tuna(canvas), new Mushroom(canvas)};

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

        pizzas.add(new Pizza(canvas, "medium", "deep pan", true, new String[]{"mushroom", "tuna"}));
        pizzas.add(new Pizza(canvas, "large", "deep pan", true, new String[]{"tuna", null}));
        pizzas.add(new Pizza(canvas, "large", "stuffed crust", false, new String[]{"tuna", "tuna"}));
        pizzas.add(new Pizza(canvas, "medium", "deep pan", true, new String[]{"mushroom", "tuna"}));
        pizzas.add(new Pizza(canvas, "small", "thin crust", false, new String[]{"tuna", "mushroom"}));
//        pizzas.add(new Pizza(canvas, "small", "thin crust", false, new String[]{"mushroom", "mushroom"}));
//        pizzas.add(new Pizza(canvas, "small", "thin crust", false, new String[]{"mushroom", "mushroom"}));
//        pizzas.add(new Pizza(canvas, "medium", "deep pan", true, new String[]{"mushroom", "tuna"}));

//        System.out.println(calculatePrice(0));
//        do{
//            pizzas.add(choosePizza());
//            System.out.println(pizzas.size());
//        }while(pizzas.size()<6&&pizzaInputs.proceed("Would you like to input another pizza?"));
////        
        updateOrderScreen();
        System.out.println("======================");
        choosePizza1();
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
    public void choosePizza1() {
        PizzaOption[] sizes = {options[2], options[3], options[4]};
        PizzaOption[] crusts = {options[5], options[6], options[7]};

        PizzaOption size = pizzaInputs.getInput2(new String[]{"small", "medium", "large"}, "Size", sizes);
        PizzaOption crust = pizzaInputs.getInput2(new String[]{"deep pan", "thin crust", "stuffed crust"}, "Crust", crusts);
        PizzaOption sauce = pizzaInputs.changeSauce();
        Topping[] toppings = pizzaInputs.enterToppings(new String[]{"tuna", "mushroom"}, availableToppings);
        System.out.println(size.name());
        System.out.println(crust.name());
        System.out.println(sauce.name());
//        Pizza chosenPizza = new Pizza(canvas, size, crust, changeSauce, toppings);
//        return chosenPizza;
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
        canvas.drawString("Total Price of the Order: £" + calculatePrice(currentScreen), 10, 640);
    }

    private void updateOrderScreen() {
        canvas.erase();
        drawOrderScreen();
        displayPizzas(currentIndex);
        updatePrice(currentIndex);

    }

    private void changeOrder() {

    }

    private void changeScreen(int newIndex) {
        if (newIndex % 6 == 0 && pizzas.size() >= newIndex) {
            currentIndex = newIndex;
        } else {
            System.out.println("that was not a valid page");
        }
    }

    private void extendedFunctionality() {
        while (pizzaInputs.proceed("Would you like to use extended functionality?")) {
            while (pizzas.size() > 6 && pizzaInputs.proceed("Would you like to switch screens?")) {

            }
            while (pizzaInputs.proceed("Would you like change and delete pizzas")) {

            }

        }

    }
}
