package com.dai.designpattern.design.strategypattern;

/**
 * Created by Administrator on 2018/7/25 0025.
 */
public class MallardDuck extends Duck {
    @Override
    public void display() {
        System.out.println("MallardDuck.display");
    }

    @Override
    public void swim() {
        super.swim();
        System.out.println("MallardDuck.swim");
    }
}
