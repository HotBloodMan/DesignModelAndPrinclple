package com.ljt.designprinclple.lod;

import java.util.ArrayList;
import java.util.List;

public class Mediator {

	List<Room> mRooms=new ArrayList<Room>();
	
	public Mediator(){
		for(int i=0;i<5;i++){
			mRooms.add(new Room(14+i,(14+i)*150));
		}
	}
	
	public List<Room> getAllRooms(){
		return mRooms;
	}
	
}
