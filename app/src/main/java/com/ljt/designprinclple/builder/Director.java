package com.ljt.designprinclple.builder;

//Director类，负责构造Computer
public class Director {
	Builder mBuilder=null;
	public Director(Builder mBuilder) {
		super();
		this.mBuilder = mBuilder;
	}
	//构建对象
	public void construct(String board,String display){
		mBuilder.buildBoard(board);
		mBuilder.buildDisplay(display);
		mBuilder.buildOS();
	}
}
