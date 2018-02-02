package com.ljt.designprinclple.dutychains;
//抽象领导者
public abstract class Leader {
	//上一级领导处理者
	protected Leader nextHandler;
	//处理报账请求  money:能批复的报账额度
	public final void handleRequest(int money){
		if(money<=limit()){
			handle(money);
		}else{
			if(null!=nextHandler)
				nextHandler.handleRequest(money);;
		}
	}
	//自身能批复的额度权限
	public abstract int limit();
	//处理报账行为
	public abstract  void handle(int money);
}