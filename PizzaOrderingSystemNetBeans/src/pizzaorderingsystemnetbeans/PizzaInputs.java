/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorderingsystemnetbeans;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 825573
 */
public class PizzaInputs {

    private KeyboardInput inputs;

    public PizzaInputs() {
        inputs = new KeyboardInput();
    }

    public String enterSize() {
        String enteredSize;
        String[] sizes = {"small", "medium", "large"};
        do {
            System.out.println("\nValid sizes are: ");
            for (String size : sizes) {
                System.out.println(size);
            }
            System.out.println("Please enter a valid Size: ");
            enteredSize = inputs.getInputString();
        } while (!(Arrays.asList(sizes).contains(enteredSize)));
        return enteredSize;

    }

    public String enterCrust() {
        String enteredCrust;
        String[] crusts = {"deep pan", "thin crust", "stuffed crust"};
        do {
            System.out.println("\nValid crusts are: ");
            for (String crust : crusts) {
                System.out.println(crust);
            }
            System.out.println("Please enter a valid crust: ");
            enteredCrust = inputs.getInputString();
        } while (!(Arrays.asList(crusts).contains(enteredCrust)));
        return enteredCrust;

    }

    public boolean changeSauce() {
        String enteredValue;
        do {
            System.out.println("\nPlease enter either : \"y\" to change base to BBQ or : \"n\" to keep tomato");

            enteredValue = inputs.getInputString();
            System.out.println(enteredValue);
        } while (!((enteredValue.equals("y")) || ((enteredValue.equals("n")))));
        if (enteredValue.equals("y")) {
            return true;
        } else {
            return false;

        }
    }

    public String[] enterToppings() {
        String[] toppings = {null, null};
        int enteredToppingNo;
        Integer[] noToppings = {0, 1, 2};
        do {
            System.out.println("\nValid toppings numbers are: ");
            for (int topping : noToppings) {
                System.out.println(topping);
            }
            System.out.println("Please enter a valid topping number: ");
            enteredToppingNo = inputs.getInputInteger();
        } while (!(Arrays.asList(noToppings).contains(enteredToppingNo)));
        for (int i = 0; i < enteredToppingNo; i++) {
            toppings[i] = enterTopping();

        }
        return toppings;

    }

    private String enterTopping() {
        String enteredTopping;
        String[] toppings = {"tuna", "mushroom"};
        do {
            System.out.println("\nValid toppings are: ");
            for (String topping : toppings) {
                System.out.println(topping);
            }
            System.out.println("Please enter a valid topping: ");
            enteredTopping = inputs.getInputString();
        } while (!(Arrays.asList(toppings).contains(enteredTopping)));
        return enteredTopping;

    }
    
    public boolean Continue() {
        String enteredValue;
        do {
            System.out.println("\nPlease enter \"y\" to enter another pizza or anything else to stop");
            enteredValue = inputs.getInputString();
        } while (!((enteredValue.equals("y")) || ((enteredValue.equals("n")))));
        if (enteredValue.equals("y")) {
            return true;
        } else {
            return false;

        }
    }

}
