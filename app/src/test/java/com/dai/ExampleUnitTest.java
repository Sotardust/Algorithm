package com.dai;


import com.dai.designpattern.design.factorypattern.ChicagoPizzaStore;
import com.dai.designpattern.design.factorypattern.NyPizzaStore;
import com.dai.designpattern.design.factorypattern.Pizza;
import com.dai.designpattern.design.factorypattern.PizzaStore;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void addTest() {
        System.out.println("addTest");
    }


    /**
     * 工厂模式：工厂方法模式定义了一个创建对象的接口，但由子类决定要实例化的类是哪一个，
     * 工厂方法让类把实例化推迟到子类。
     */
    @Test
    public void simplyFactory() {

        PizzaStore nyStore = new NyPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
}