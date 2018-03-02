package com.dai.design.singlepattern;

/**
 * 单例模式  饿汉模式 静态常量
 * Created by dai on 2018/3/2.
 */
public class Singleton {

    private final static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

}


