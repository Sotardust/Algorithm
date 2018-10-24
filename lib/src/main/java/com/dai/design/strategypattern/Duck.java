package com.dai.design.strategypattern;

/**
 * 策略模式(strategy pattern)： 定义了算法族，分别封装起来，让他们之间可以互换，此模式让算法的 变化独立于使用算法的客户
 * <p>
 * Created by Administrator on 2018/7/25 0025.
 */
public abstract class Duck {

    FlyBehavior flyBehavior;

    QuackBehavior quackBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public abstract void display();

    public void swim() {
        System.out.println("Duck.swim");
    }
}
