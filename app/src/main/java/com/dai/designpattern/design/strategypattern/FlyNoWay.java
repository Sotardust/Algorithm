package com.dai.designpattern.design.strategypattern;

/**
 * Created by Administrator on 2018/7/25 0025.
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't flying");
    }
}
