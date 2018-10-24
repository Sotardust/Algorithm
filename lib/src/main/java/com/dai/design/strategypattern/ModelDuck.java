package com.dai.design.strategypattern;

/**
 * Created by Administrator on 2018/7/25 0025.
 */
public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("ModelDuck.display");
    }

    public void performFly() {
        //委托给行为类
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }
}
