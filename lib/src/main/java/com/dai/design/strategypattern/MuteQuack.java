package com.dai.design.strategypattern;

/**
 * Created by Administrator on 2018/7/25 0025.
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("沉默");
    }
}
