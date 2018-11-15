package com.dai.designpattern.design.adapterpattern;

/**
 * created by Administrator on 2018/11/15 16:47
 */
public class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
