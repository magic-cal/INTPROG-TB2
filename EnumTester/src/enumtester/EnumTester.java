/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumtester;

import java.util.Arrays;

/**
 *
 * @author up825573
 */
public class EnumTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PizzaOptions[] sauce = {PizzaOptions.BBQ,PizzaOptions.TOMATO};
        PizzaOptions[] base = {PizzaOptions.DEEPPAN,PizzaOptions.THINCRUST,PizzaOptions.STUFFEDCRUST};
        PizzaOptions[] size = {PizzaOptions.SMALL,PizzaOptions.MEDIUM,PizzaOptions.LARGE};
        System.out.println(PizzaOptions.BBQ);
        String in = "BBQ";
        for(PizzaOptions option: PizzaOptions.values()){
            System.out.println(option);
            System.out.println(option.getDesc());
            
        }
        if ("BBQ".equals(PizzaOptions.BBQ.toString())) {
            System.out.println("hui");
        }
        
//        getInput(PizzaOptions.Sauce.values(),"Sauce");
        
        // TODO code application logic here
    }
    
    public String getInput(PizzaOptions[] toppings, String itemToChoose){
        String enteredTopping;
       do {
            System.out.println("Please valid "+itemToChoose+"s are:");
            for (PizzaOptions topping : toppings) {
                System.out.println(topping.toString());
            }
            System.out.println("Please valid "+itemToChoose+"s are:");
            enteredTopping = "BBQ";
            System.out.println("input");
        } while (!(Arrays.asList(toppings).contains(enteredTopping)));
        return enteredTopping;
    }
    
}
