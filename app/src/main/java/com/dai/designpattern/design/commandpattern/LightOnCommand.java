package com.dai.designpattern.design.commandpattern;

/**
 * created by Administrator on 2018/11/14 16:34
 */
public class LightOnCommand implements Command {

    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
