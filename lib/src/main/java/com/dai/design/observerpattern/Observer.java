package com.dai.design.observerpattern;

/**
 * Created by Administrator on 2018/7/25 0025.
 */
public interface Observer {
    public void update(float temp, float humidity, float pressure);
}
