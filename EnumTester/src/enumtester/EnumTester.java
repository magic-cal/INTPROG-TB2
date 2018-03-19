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
//        PizzaInput pi = new PizzaInput();
        PizzaOptions[] sauce = {PizzaOptions.BBQ,PizzaOptions.TOMATO};
        PizzaOptions[] base = {PizzaOptions.DEEPPAN,PizzaOptions.THINCRUST,PizzaOptions.STUFFEDCRUST};
        PizzaOptions[] size = {PizzaOptions.SMALL,PizzaOptions.MEDIUM,PizzaOptions.LARGE};
        System.out.println(PizzaOptions.BBQ);
        String in = "BBQ";
        for(PizzaOptions option: PizzaOptions.values()){
            System.out.println(option);
//            System.out.println(option.getDesc());
            
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~####~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
//        pi.getInput(sauce,"Sauce");
        
        // TODO code application logic here
    }
    
    
    
}
