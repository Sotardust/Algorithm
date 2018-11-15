package com.dai.designpattern.design.adapterpattern;

/**
 * created by Administrator on 2018/11/15 16:46
 */
public class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
