package com.ljt.designprinclple.bridge;

public class Test {
 public static void main(String[] args) {
	 //原味
	 Ordinary ordinaryImp = new Ordinary();
	 //加糖
	 Sugar sugarImp = new Sugar();
	 //大杯原味
	 LargeCoffee largeCoffeeOrd = new LargeCoffee(ordinaryImp);
	 largeCoffeeOrd.makeCoffee();
	//小杯原味
	 SmallCoffee smallCoffeeOrd = new SmallCoffee(ordinaryImp);
	 smallCoffeeOrd.makeCoffee();
	//大杯 加糖
	 LargeCoffee largeCoffeeSugar = new LargeCoffee(sugarImp);
	 largeCoffeeSugar.makeCoffee();
	//小杯 加糖
	 SmallCoffee smallCoffeeSugar = new SmallCoffee(sugarImp);
	 smallCoffeeSugar.makeCoffee();
}
}
