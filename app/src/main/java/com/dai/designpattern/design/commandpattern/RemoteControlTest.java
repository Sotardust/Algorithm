package com.dai.designpattern.design.commandpattern;

/**
 * created by Administrator on 2018/11/14 16:39
 */
public class RemoteControlTest {

    public static void main(String[] args) {
        SimpleRemoteControl control = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);

        control.setCommand(lightOnCommand);

        control.buttonWasPressed();
    }
}
