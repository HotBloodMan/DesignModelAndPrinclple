package com.ljt.designprinclple.strategy;

public class BusStrategy implements CalculateStrategy {
	//公交车计费，十公里之内一元钱，之外每加一元钱可以乘5公里
	@Override
	public int calculatePrice(int km) {
		//超过10公里的总距离
		int extraTotal=km-10;
		//超过的距离是5的公里倍数
		int extraFactor=extraTotal /5;
		//超过的距离对5公里取余
		int fraction=extraTotal % 5;
		//价格计算
		int price=1+extraFactor*1;
		return fraction>0?++price:price;
	}
}
