package com.ljt.designprinclple.strategy;

public class TranficCalculator {
public static void main(String[] args) {
	TranficCalculator calculator = new TranficCalculator();
	//设置计算策略
	calculator.setmStrategy(new BusStrategy());
	//计算价格
	System.out.println("公交车乘15公里的价格："+calculator.calculatePrice(15));
}
//这一部分代码可以单独放在一个类中
CalculateStrategy mStrategy;
//使用set方法注入依赖
public void setmStrategy(CalculateStrategy mStrategy) {
	this.mStrategy = mStrategy;
}
public int calculatePrice(int km){
	return mStrategy.calculatePrice(km);
}
}
