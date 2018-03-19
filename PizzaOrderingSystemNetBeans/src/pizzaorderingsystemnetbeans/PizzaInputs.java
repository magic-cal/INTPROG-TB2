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

    public PizzaOption changeSauce() {
        String enteredValue;
        do {
            System.out.println("\nPlease enter either : \"y\" to change base to BBQ or : \"n\" to keep tomato");

            enteredValue = inputs.getInputString();
        } while (!((enteredValue.equalsIgnoreCase("y")) || ((enteredValue.equalsIgnoreCase("n")))));
        if (enteredValue.equalsIgnoreCase("y")) {
            return PizzaOption.BBQ;
        } else {
            return PizzaOption.TOMATO;

        }
    }

//    public String[] enterToppings() {
//        String[] toppings = {null, null};
//        int enteredToppingNo;
//        Integer[] noToppings = {0, 1, 2};
//        do {
//            System.out.println("\nValid toppings numbers are: ");
//            for (int topping : noToppings) {
//                System.out.println(topping);
//            }
//            System.out.println("Please enter a valid topping number: ");
//            enteredToppingNo = inputs.getInputInteger();
//        } while (!(Arrays.asList(noToppings).contains(enteredToppingNo)));
//        for (int i = 0; i < enteredToppingNo; i++) {
//            toppings[i] = enterTopping(i + 1);
//
//        }
//        return toppings;
//
//    }
//    public Topping[] enterToppings(String[] validToppings, Topping[] toppings) {
//        Topping[] chosenToppings = {null, null};
//        String enteredTopping = "";
//        int toppingNo = getInput(new Integer[]{0, 1, 2}, "Topping ammount");
//        for (int i = 0; i < toppingNo; i++) {
//            System.out.println("Integer i select " + i);
//            do {
//                System.out.println("\nValid toppings are: ");
//                for (String topping : validToppings) {
//                    System.out.println(topping);
//                }
//                System.out.println("Please enter valid topping no: " + (i + 1));
//                enteredTopping = inputs.getInputString();
//
//                for (int j = 0; j < toppings.length; j++) {
//                    if (enteredTopping != null && enteredTopping.equalsIgnoreCase(validToppings[j])) {
//                        chosenToppings[i] = toppings[j];
//                        System.out.println("chosenToppings" + (i + 1) + " " + chosenToppings[i]);
//                        enteredTopping = null;
//                    } else {
//
//                    }
//
//                }
//
//            } while (enteredTopping != null);
//
//        }
//        return toppings;
//
//    }
    public Topping[] enterToppings(String[] validToppings, Topping[] toppings) {
        Topping[] chosenToppings = {null, null};
        String enteredTopping = "";
        int toppingNo = getInput(new Integer[]{0, 1, 2}, "Topping ammount");
        for (int i = 0; i < toppingNo; i++) {
            do {
                System.out.println("\nValid toppings are: ");
                for (String topping : validToppings) {
                    System.out.println(topping);
                }
                System.out.println("Please enter valid topping no: " + (i + 1));
                enteredTopping = inputs.getInputString();
                for (int j = 0; j <= 1; j++) {
                    System.out.println("j " + j);
                    if (validToppings[j].equalsIgnoreCase(enteredTopping)) {
                        chosenToppings[i] = toppings[j];
                        System.out.println("position " + i + " is = " + toppings[j]);
                        break;
                    }
                }
            } while (chosenToppings[i] == null);
        }
        return chosenToppings;
    }

    public int getInput(Integer[] validNumbers, String toChoose) {
        int chosenInt = 0;
        do {
            System.out.println("Valid " + toChoose + "s are:");
            for (int validNumber : validNumbers) {
                System.out.println(validNumber);
            }
            System.out.println("\nPlease enter a valid " + toChoose);
            chosenInt = inputs.getInputInteger();
        } while (!Arrays.asList(validNumbers).contains(chosenInt));
        System.out.println("Returned Get Input int " + chosenInt);
        return chosenInt;
    }

    public boolean proceed(String task) {
        String enteredValue;
        do {
            System.out.println("\n" + task);
            System.out.println("Please enter \"y\" to continue or : \"n\" to stop\n");
            enteredValue = inputs.getInputString();
        } while (!((enteredValue.equalsIgnoreCase("y")) || ((enteredValue.equalsIgnoreCase("n")))));
        if (enteredValue.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;

        }
    }

    //todo//
//    public String getInput(String[] validOptions, String itemToChoose) {
//        String enteredValue;
//        do {
//            System.out.println("valid " + itemToChoose + "s are:");
//            for (String option : validOptions) {
//                System.out.println(option);
//            }
//            System.out.println("Please enter a valid " + itemToChoose);
//            enteredValue = inputs.getInputString();
//        } while (!(Arrays.asList(validOptions).contains(enteredValue)));
//
//        return enteredValue;
//    }
    public PizzaOption getInput(String[] validOptions, String itemToChoose, PizzaOption[] options) {
        String enteredValue = "";
        while (enteredValue != (null)) {

            System.out.println("\nvalid " + itemToChoose + "s are:");
            for (String validOption : validOptions) {
                System.out.println(validOption);
            }
            System.out.println("Please enter a valid " + itemToChoose);
            enteredValue = inputs.getInputString();
            for (int i = 0; i < validOptions.length; i++) {
                if (enteredValue.equalsIgnoreCase(validOptions[i])) {
                    return options[i];
                }
            }
            System.out.println("\"" + enteredValue + "\" was an invalid input");

        }
        System.out.println("Major error");
        return options[0];
    }

    public int getInput(int lowest, int highest, String toChoose) {
        int chosenInt = 0;
        do {
            System.out.println("\nValid " + toChoose + "s are:");
            for (int i = lowest; i <= highest; i++) {
                System.out.println(i);
            }
            System.out.println("\nPlease enter a valid " + toChoose);
            chosenInt = inputs.getInputInteger();
            
        } while (chosenInt > highest || chosenInt < lowest);
        System.out.println("Returned Get Input int " + chosenInt);
        return chosenInt;
    }

//    public String getInput(PizzaOption[] toppings, String itemToChoose){
//        String enteredTopping;
//       do {
//            System.out.println("Please valid "+itemToChoose+"s are:");
//            for (PizzaOption topping : toppings) {
//                System.out.println(topping.toString());
//            }
//            System.out.println("Please valid "+itemToChoose+"s are:");
//            enteredTopping = inputs.getInputString();
//        } while (!(Arrays.asList(toppings).contains(enteredTopping)));
//        return enteredTopping;
//    }
//            
}
