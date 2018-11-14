package com.dai.designpattern.design.commandpattern.undo;

public interface Command {
	public void execute();
	public void undo();
}
