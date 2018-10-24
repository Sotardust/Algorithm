package com.dai.design.observerpattern;

/**
 * 主题即 被观察者
 * <p>
 * Created by Administrator on 2018/7/25 0025.
 */
public interface Subject {

    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}
