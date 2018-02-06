package com.ljt.designprinclple.strategy;

public class PriceCalculator {
	private static final int BUS=1;
	private static final int SUBWAY=2;
	public static void main(String[] args) {
		PriceCalculator calculator = new PriceCalculator();
		System.out.println("坐15公里的公交车票价为："+calculator.calculatePrice(15,BUS));
		System.out.println("坐15公里的地铁票价为："+calculator.calculatePrice(15,SUBWAY));
	}
	//公交车计费，十公里之内一元钱，之外每加一元钱可以乘5公里
	private int busPrice(int km){
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
	//地铁计费  6公里内 3元  6<=km<=12公里 4元 12<=km<=22公里 5元  22<=km<=32公里 6元 
	private int subwayPrice(int km){
		if(km<=6){
			return 3;
		}else if(km>6 && km<12){
			return 4;
		}else if(km>12 && km <22){
			return 5;
		}else if(km>22 && km<32){
			return 6;
		}
		return 7;
	}
	int  calculatePrice(int km,int type){
		if(type==BUS){
			return busPrice(km);
		}else if(type==SUBWAY){
			return subwayPrice(km);
		}
		return 0;
	}
}
