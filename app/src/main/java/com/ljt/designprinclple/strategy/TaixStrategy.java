package com.ljt.designprinclple.strategy;

public class TaixStrategy implements CalculateStrategy{
	//价格 公里*3
	@Override
	public int calculatePrice(int km) {
		return km*3;
	}
}
