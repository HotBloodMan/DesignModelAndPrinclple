package com.ljt.designprinclple.dutychains;
public class GroupLeader extends Leader{
	@Override
	public int limit() {
		return 100;
	}
	@Override
	public void handle(int money) {
		System.out.println("组长批复报销"+money+"元");
	}
}
