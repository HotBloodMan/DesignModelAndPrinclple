package com.ljt.designprinclple.bridge;

public abstract class Coffee {
	protected CoffeeAdditives impl;
	public Coffee(CoffeeAdditives impl){
		this.impl=impl;
	}
	//咖啡具体是什么样的由子类决定
	public abstract void makeCoffee();
}
