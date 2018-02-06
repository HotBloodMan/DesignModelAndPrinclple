package com.ljt.designprinclple.strategy;

public class SubwayStrategy implements CalculateStrategy{
	//地铁计费  6公里内 3元  6<=km<=12公里 4元 12<=km<=22公里 5元  22<=km<=32公里 6元 
	@Override
	public int calculatePrice(int km) {
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
}
