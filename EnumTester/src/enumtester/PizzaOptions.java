/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumtester;

/**
 *
 * @author up825573
 */
public enum PizzaOptions {

    BBQ("BBQ",0.50),
    TOMATO("Tomato",0.00),
    SMALL("Small",78.54),
    MEDIUM("Medium",113.10),
    LARGE("Large",153.94),
    DEEPPAN("Deep pan",0.11),
    THINCRUST("Thin crust",0.08),
    STUFFEDCRUST("Stuffed crust",0.14);
    
    
    private String desc;
    private double price;
    
    PizzaOptions (String pDesc, double pPrice){
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
