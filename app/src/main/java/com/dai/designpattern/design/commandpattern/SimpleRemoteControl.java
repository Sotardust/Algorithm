package com.dai.designpattern.design.commandpattern;

/**
 * created by Administrator on 2018/11/14 16:37
 */
public class SimpleRemoteControl {
    Command command;

    public SimpleRemoteControl() {
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void buttonWasPressed() {
        command.execute();
    }
}
