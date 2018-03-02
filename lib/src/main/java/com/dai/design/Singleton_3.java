package com.dai.design;

/**
 * 单例模式  静态内部类
 * Created by dai on 2018/3/2.
 */
public class Singleton_3 {


    private Singleton_3() {
    }

    private static class SingletonInstance {

        private static final Singleton_3 instance = new Singleton_3();
    }

    public static Singleton_3 getInstance() {

        return SingletonInstance.instance;
    }

}


