package pizzaorderingsystemnetbeans;

import java.awt.*;
import java.util.ArrayList;

/**
 * Class to manage the pizza order.
 *
 * @author 825573
 */
public class OrderingSystem {

    private Canvas canvas;
    private PizzaInputs pizzaInputs = new PizzaInputs();
    protected ArrayList<Pizza> pizzas = new ArrayList();

    /**
     * Constructor for the ordering system.
     */
    public OrderingSystem() {
        canvas = new Canvas("Pizza Ordering", 900, 650);

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
        
//        pizzas.add(new Pizza(canvas, "medium", "deep pan", true, new String[]{"mushroom", "tuna"}));
//        pizzas.add(new Pizza(canvas, "large", "deep pan", true, new String[]{"tuna", null}));
//        pizzas.add(new Pizza(canvas, "large", "stuffed crust", false, new String[]{"tuna", "tuna"}));
//        pizzas.add(new Pizza(canvas, "medium", "deep pan", true, new String[]{"mushroom", "tuna"}));
//        pizzas.add(new Pizza(canvas, "small", "thin crust", false, new String[]{"tuna", "mushroom"}));
//        pizzas.add(new Pizza(canvas, "small", "thin crust", false, new String[]{"mushroom", "mushroom"}));
//        
//        System.out.println(calculatePrice(0));

        do{
            pizzas.add(choosePizza());
            System.out.println(pizzas.size());
        }while(pizzas.size()<6&&pizzaInputs.Continue());
////        

//
        for (Pizza p : pizzas) {
//            p.displayPizza(0, 0);
            p.printAll();
            System.out.println(p.getPrice());
        }

        displayPizzas(0);
        updatePrice();

    

        try {
            Thread.sleep(10000);
            System.exit(0);
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }

    public void displayPizzas(int currentIndex) {
        for (int i = 0; i <= 600 && currentIndex < pizzas.size(); i += 300) {
            for (int j = 0; j <= 600 && currentIndex < pizzas.size(); j += 300, currentIndex++) {
                pizzas.get(currentIndex).displayPizza(j, i);
            }
        }
    }

    public Pizza choosePizza() {
        String size = pizzaInputs.enterSize();
        String crust = pizzaInputs.enterCrust();
        boolean changeSauce = pizzaInputs.changeSauce();
        String[] toppings = pizzaInputs.enterToppings();
        Pizza chosenPizza = new Pizza(canvas, size, crust, changeSauce, toppings);
        return chosenPizza;
    }
    
//    public Pizza choosePizzaGen() {
//        String[] toppings1 = {"tuna", "mushroom"};
//        String size = pizzaInputs.getInput(new String[]{"small","medd","largo"},"Size");
//        String crust = pizzaInputs.getInput(new String[]{"deep pan","thin crust","stuffed crust"},"Crust");
//        boolean changeSauce = pizzaInputs.getInput(new String[]{"tomato","bbq",},"Size");
//        String[] toppings = pizzaInputs.enterToppings();
//        Pizza chosenPizza = new Pizza(canvas, size, crust, changeSauce, toppings);
//        return chosenPizza;
//    }
    
    private double calculatePrice(int index){
        double totPrice=0;
        
        for (int i = index; i <= index+6 && index+i < pizzas.size(); i++) {
            totPrice += pizzas.get(i).getPrice();
        }
        
        return totPrice;
    }
    
    private void updatePrice(){
        canvas.setForegroundColor(Color.BLACK);
        canvas.setFontSize(25);
        canvas.eraseString("Total Price of the Order: £"+calculatePrice(0), 10, 640);
        canvas.drawString("Total Price of the Order: £"+calculatePrice(0), 10, 640);
    }

}
