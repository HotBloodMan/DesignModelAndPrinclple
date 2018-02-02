package com.ljt.designprinclple.templemethod;

//抽象模板类
public abstract class HummerModel {
	//开车
	protected abstract void start();
	//停车
	protected abstract void stop();
	//出喇叭声音
	protected abstract void  alarm();
	//发出引擎声
	protected abstract void engineBoom();
	
	final public void run(){
		this.start();
		this.engineBoom();
		if(this.isAlarm()){
			this.alarm();
		}
		this.stop();
	}
	//钩子方法，默认喇叭是会响的
	protected boolean isAlarm(){
		return true;
	}
}