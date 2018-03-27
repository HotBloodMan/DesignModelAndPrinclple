package com.ljt.designprinclple.singleinstance;

/**
 * Created by ${JT.L} on 2018/3/27.
 */

public class Singleton01 {
    private static Singleton01 singleton01;
    private Singleton01(){}
/*
* 虽然做到了线程安全，并且解决了多实例的问题，但是它并不高效。
* 因为在任何时候只能有一个线程调用 getInstance() 方法。
* 但是同步操作只需要在第一次调用时才被需要，即第一次创建单例实例对象时。
* 这就引出了双重检验锁。
* */
    public static  synchronized  Singleton01 getSingleton01(){
        if(singleton01==null){
            singleton01=new Singleton01();
        }
       return singleton01;
    }
}
