package com.dai.designpattern.design.strategypattern;

/**
 * Created by Administrator on 2018/7/25 0025.
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {

        System.out.println("吱吱叫");
    }
}
