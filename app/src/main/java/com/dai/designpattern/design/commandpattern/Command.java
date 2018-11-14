package com.dai.designpattern.design.commandpattern;

/**
 * 命令模式：命令模式将“请求”封装成对象，以便使用不同的请求、队列或者日志来参数化其他对象。
 * 命令模式也支持撤销操作。
 * <p>
 * created by Administrator on 2018/11/14 16:33
 */
public interface Command {

    public void execute();
}
