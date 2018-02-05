package com.ljt.designprinclple.builder;

public class Test {
	public static void main(String[] args) {
		//构建器
		Builder builder=new MacbookBuilder();
		//Director
		Director pcDirector = new Director(builder);
		//封装构建过程，4核，内存2GB,Mac系统
		pcDirector.construct("Intel主板","Retina显示器");
		//构建计算机，输出相关信息
		System.out.println("Computer Info:"+builder.create().toString());
	}
}
