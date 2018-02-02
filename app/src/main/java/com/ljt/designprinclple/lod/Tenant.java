package com.ljt.designprinclple.lod;

import java.util.List;
//租户
public class Tenant {
	public float roomArea;
	public float roomPrice;
	public static final float diffPrice=100.0001f;
	public static final float diffArea=0.00001f;
	public void rentRoom(Mediator mediator){
		List<Room> rooms = mediator.getAllRooms();
		for(Room room:rooms){
			if(isSuitable(room)){
				System.out.println("租到房间啦！"+room);
				break;
			}
		}
	}
	private boolean isSuitable(Room room){
		return Math.abs(room.price-roomPrice)<diffPrice
				&& Math.abs(room.area-roomArea)<diffArea;
	}
}
//这个方法放在这个类里，耦合较高，找出谁才是真正的盆友，只和我们的朋友通信，这里指Mediator