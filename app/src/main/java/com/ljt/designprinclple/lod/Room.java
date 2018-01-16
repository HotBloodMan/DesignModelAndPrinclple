package com.ljt.designprinclple.lod;


//迪米特原则：一个对象应该对其他对象有最少的了解。类的内部如何实现与调用者或者依赖者没有关系
//,调用者或者依赖者只需要知道它需要的方法即可。
public class Room {
	public float area;
	public float price;
	public Room(float area, float price) {
		super();
		this.area = area;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Room [area=" + area + ", price=" + price + "]";
	}
	
}
