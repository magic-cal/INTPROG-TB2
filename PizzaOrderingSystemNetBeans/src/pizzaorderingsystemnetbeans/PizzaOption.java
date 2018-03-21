/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorderingsystemnetbeans;

/**
 * Stored enumeration values for possible Pizza Options
 * @author UP825573
 */
public enum PizzaOption {

    BBQ("BBQ Sauce", 0.50, 0.00),
    TOMATO("Tomato Sauce", 0.00, 0),
    SMALL("Small", 0, 78.54),
    MEDIUM("Medium", 0, 113.10),
    LARGE("Large", 0, 153.94),
    DEEPPAN("Deep pan", 0.11, 0),
    THINCRUST("Thin crust", 0.08, 0),
    STUFFEDCRUST("Stuffed crust", 0.14, 0);

    private String name;
    private double price;
    private double area;

    /**
     * Constructor for PizzaOptions
     * @param pName The name of the Pizza Option
     * @param pPrice The price of the Pizza Option
     * @param pArea The size of the Pizza Option
     */
    PizzaOption(String pName, double pPrice, double pArea) {
        name = pName;
        price = pPrice;
        area = pArea;
    }

    /**
     * Accessor Method for PizzaOptions enum name
     * @return Name of the PizzaOption
     */
    public String getName() {
        return name;
    }

    /**
     * Accessor Method for PizzaOptions enum price
     * @return price of the PizzaOption
     */
    public double getPrice() {
        return price;
    }

    /**
     * Accessor Method for PizzaOptions enum area
     * @return area of the PizzaOption
     */
    public double getArea() {
        return area;
    }
}
