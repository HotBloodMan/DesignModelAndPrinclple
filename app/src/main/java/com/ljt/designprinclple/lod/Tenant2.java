package com.ljt.designprinclple.lod;
//租户
public class Tenant2 {
	public float roomArea;
	public float roomPrice;
	public static final float diffPrice=100.0001f;
	public static final float diffArea=0.00001f;
	public void rentRoom(Mediator2 mediator){
		System.out.println("租到房子啦 "+mediator.rentOut(roomArea, roomPrice));
	}
}
