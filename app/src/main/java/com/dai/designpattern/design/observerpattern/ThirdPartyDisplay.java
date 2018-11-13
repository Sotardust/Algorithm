package com.dai.designpattern.design.observerpattern;

/**
 * Created by Administrator on 2018/7/25 0025.
 */
public class ThirdPartyDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherData weatherData;

    public ThirdPartyDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions  temperature：" + temperature + ", pressure: " + pressure);
    }
}
