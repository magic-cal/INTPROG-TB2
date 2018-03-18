/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorderingsystemnetbeans;

/**
 *
 * @author Callum
 */
public class PizzaOption {
    
    public enum Sauce{
    BBQ("Sauce",0.50),
    TOMATO("Sauce",0.00);
    
    private String desc;
    private double price;
    
    Sauce (String pDesc, double pPrice){
        desc = pDesc;
        price = pPrice;
    }
    
    public String getDesc(){
        return desc;
    }
    
    public double getPrice(){
        return price;
    }
}

public enum Base{
    
    Base(){
        
    }
}
}