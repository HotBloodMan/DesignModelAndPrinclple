package com.ljt.designprinclple.command;

//接收者角色,执行具体逻辑的角色
public class Receiver {
	//真正的执行者
	public void action(){
		System.out.println("------>>>执行操作");
	}

}
