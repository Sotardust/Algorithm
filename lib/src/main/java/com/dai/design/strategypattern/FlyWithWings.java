package com.dai.design.strategypattern;

/**
 * Created by Administrator on 2018/7/25 0025.
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I,m flying");
    }
}
