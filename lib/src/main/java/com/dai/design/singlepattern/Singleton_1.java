package com.dai.design.singlepattern;

/**
 * 单例模式  懒汉式 线程安全 同步代码块
 * Created by dai on 2018/3/2.
 */
public class Singleton_1 {

    private static Singleton_1 instance;

    private Singleton_1() {
    }

    public static Singleton_1 getInstance() {
        if (instance == null) {
            synchronized (Singleton_1.class) {
                instance = new Singleton_1();
            }
        }
        return instance;
    }

}


