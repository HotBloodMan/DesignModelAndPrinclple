package com.ljt.designprinclple.command;

//具体命令角色
public class ConcreteCommand implements Command{
	//持有相应的接受者
	private Receiver receiver=null;


	 public ConcreteCommand(Receiver receiver) {
		 this.receiver=receiver;
	}	
	@Override
	public void execute() {
		//通常会转调接受者对象的相应方法，让接收者来真正执行功能
		receiver.action();
	}
}
