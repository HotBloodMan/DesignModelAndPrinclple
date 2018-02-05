package com.ljt.designprinclple.builder;

//具体的Builder类，MacbookBuilder
public class MacbookBuilder extends Builder{
	private Computer mComputer=new Macbook();
	@Override
	public void buildBoard(String board) {
		mComputer.setBoard(board);
	}
	@Override
	public void buildDisplay(String display) {
		mComputer.setDisplay(display);
	}
	@Override
	public void buildOS() {
		mComputer.setOS();
	}
	@Override
	public Computer create() {
		return mComputer;
	}

}
