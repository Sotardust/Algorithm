package com.dai.designpattern.design.decoratorpattern;

/**
 * 装饰者模式动态地将责任附加到对象上若要扩展功能，装饰者提供了比继承更有弹性的替代方案
 * <p>
 * Created by Administrator on 2018/7/26 0026.
 */
public abstract class Beverage {

    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
