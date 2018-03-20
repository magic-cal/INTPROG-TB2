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
    private double size;

    PizzaOption(String pName, double pPrice, double pSize) {
        name = pName;
        price = pPrice;
        size = pSize;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getSize() {
        return size;
    }
}
