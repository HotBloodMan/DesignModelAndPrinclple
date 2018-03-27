package com.ljt.designprinclple.singleinstance;

/**
 * Created by ${JT.L} on 2018/3/27.
 *
 * 静态内部类 static nested class
 *
 * 这种写法仍然使用JVM本身机制保证了线程安全问题；由于 SingletonHolder 是私有的，
 * 除了 getInstance() 之外没有办法访问它，因此它是懒汉式的；
 * 同时读取实例的时候不会进行同步，没有性能缺陷；也不依赖 JDK 版本。
 */

public class Singleton05 {
    private static class SingletonHolder{
        private static final  Singleton05 singleton05=new Singleton05();
    }
    private Singleton05(){}
    public static final Singleton05 getInstance(){
        return SingletonHolder.singleton05;
    }
}
