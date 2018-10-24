package com.dai.design.decoratorpattern;

/**
 * 抽象组件：Beverage
 * 具体组件：DarkRoast
 * 抽象装饰者： CondimentDecorator
 * <p>
 * Created by Administrator on 2018/7/28 0028.
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "DarkRoast";
    }


    @Override
    public double cost() {
        return 2.19;
    }


}
