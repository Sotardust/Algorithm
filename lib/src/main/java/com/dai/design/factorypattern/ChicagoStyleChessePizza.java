package com.dai.design.factorypattern;

/**
 * created by Administrator on 2018/11/5 11:05
 */
public class ChicagoStyleChessePizza extends Pizza {

    public ChicagoStyleChessePizza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";
        toppings.add("Shredded Mozzarella Cheese");
    }

    void cut() {
        System.out.println("Cutting the pizza into square slices ");
    }
}
