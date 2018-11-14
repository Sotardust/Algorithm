package com.dai.designpattern.design.factorypattern;

import java.util.ArrayList;

/**
 * 工厂模式：工厂方法模式定义了一个创建对象的接口，但由子类决定要实例化的类是哪一个，
 * 工厂方法让类把实例化推迟到子类。
 *
 * 抽象工厂模式：提供一个接口，用于创建相关或依赖对象的家族，而不需要明确指定具体类。
 *
 * <p>
 * created by Administrator on 2018/11/5 10:55
 */
public abstract class Pizza {

    private static final String TAG = "Pizza";
    String name;
    String dough;
    String sauce;

    ArrayList<String> toppings = new ArrayList<>();

    void prepare() {
        System.out.println("Preparing  = " + name);
        System.out.println("Tossing dough  = " + dough);
        System.out.println("Adding sauce ...");
        System.out.println("Adding toppings :");

        for (int i = 0; i < toppings.size(); i++) {
            System.out.println(" " + toppings.get(i));

        }
    }

    void bake() {
        System.out.println("Bake for 25 minutes at 350 ");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }
}
