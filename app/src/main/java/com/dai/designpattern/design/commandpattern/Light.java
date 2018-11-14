package com.dai.designpattern.design.commandpattern;

import android.util.Log;

/**
 * created by Administrator on 2018/11/14 16:36
 */
public class Light {

    private static final String TAG = "Light";

    public void on() {
        System.out.println(TAG  + " = Light is on ");
    }

    public void off() {
        System.out.println(TAG  + " = Light is off ");
    }
}

