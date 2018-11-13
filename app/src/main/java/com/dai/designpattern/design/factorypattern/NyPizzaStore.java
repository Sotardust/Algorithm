package com.dai.designpattern.design.factorypattern;

/**
 * created by Administrator on 2018/11/12 13:46
 */
public class NyPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if ("cheese".equals(type)){
            return new NYStyleCheesePizza();
        }else if ("veggie".equals(type)){
            return new NYStyleCheesePizza();
        }else if ("clam".equals(type)){
            return new NYStyleCheesePizza();
        }else if ("pepperoni".equals(type)){
            return new NYStyleCheesePizza();
        }
        return null;
    }
}
