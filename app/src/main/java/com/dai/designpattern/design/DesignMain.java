package com.dai.designpattern.design;

import com.dai.designpattern.design.factorypattern.ChicagoPizzaStore;
import com.dai.designpattern.design.factorypattern.NyPizzaStore;
import com.dai.designpattern.design.factorypattern.Pizza;
import com.dai.designpattern.design.factorypattern.PizzaStore;

/**
 * created by Administrator on 2018/11/12 13:35
 */
public class DesignMain {

    public static void main(String[] arg) {
        System.out.println("main 132456");

        PizzaStore nyStore = new NyPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }

    public void test(){

    }
}
