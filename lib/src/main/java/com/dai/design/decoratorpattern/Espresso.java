package com.dai.design.decoratorpattern;

/**
 * Created by Administrator on 2018/7/28 0028.
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }


    @Override
    public double cost() {
        return 1.99;
    }
}
