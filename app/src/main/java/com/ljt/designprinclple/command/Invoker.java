package com.ljt.designprinclple.command;
//调用命令对象执行具体的请求，相关方法称之为“行动方法”
public class Invoker {
	 /**
     * 持有命令对象
     */
	private Command command=null;
	/**
     * 构造方法
     */
	public Invoker(Command command){
		this.command=command;
	}
	 /**
     * 行动方法
     */
	public void action(){
		command.execute();
	}

}
