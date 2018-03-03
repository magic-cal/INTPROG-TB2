/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorderingsystemnetbeans;

import java.util.Arrays;


/**
 *
 * @author 825573
 */
public class PizzaInputs {
    
    private KeyboardInput inputs;
    
    public PizzaInputs(){
        inputs = new KeyboardInput();
    }
    
    public String enterSize(){
        String enteredSize;
        String[] sizes = {"small","medium","large"};
        do{
        System.out.println("Valid sizes are: ");
        for(String size: sizes){
            System.out.println(size);
        }
        System.out.println("Please enter a valid Size: ");
        enteredSize = inputs.getInputString();
        }while(!(Arrays.asList(sizes).contains(enteredSize)));
            return enteredSize;
        
    }
    
    public String enterCrust(){
        String enteredCrust;
        String[] crusts = {"deep pan", "thin crust", "stuffed crust"};
        do{
        System.out.println("Valid crusts are: ");
        for(String crust: crusts){
            System.out.println(crust);
        }
        System.out.println("Please enter a valid crust: ");
        enteredCrust = inputs.getInputString();
        }while(!(Arrays.asList(crusts).contains(enteredCrust)));
            return enteredCrust;
        
    }
    public boolean changeBase(){
        String enteredValue;
        do{
        System.out.println("Please enter either : \"y\" to change base to BBQ or : \"n\" to keep tomato");
        
        enteredValue = inputs.getInputString();
            System.out.println(enteredValue);
        }while(!((enteredValue.equals("y"))||((enteredValue.equals("n")))));
        if (enteredValue.equals("y")){
            return true;
        }else{
            return false;
       
        }
    }
    
    
     public int enterTopping(){
        int enteredTopping;
        int[] toppings = {0,1,2};
        do{
        System.out.println("Valid toppings numbers are: ");
        for(int topping: toppings){
            System.out.println(topping);
        }
        System.out.println("Please enter a valid topping: ");
        enteredTopping = inputs.getInputInteger();
        }while(!(Arrays.asList(toppings).contains(enteredTopping)));
            return enteredTopping;
        
    }
    
}
