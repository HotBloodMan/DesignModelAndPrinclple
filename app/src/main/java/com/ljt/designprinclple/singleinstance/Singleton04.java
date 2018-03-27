package com.ljt.designprinclple.singleinstance;

/**
 * Created by ${JT.L} on 2018/3/27.
 *
 * 缺点是它不是一种懒加载模式（lazy initialization），
 * 单例会在加载类后一开始就被初始化，即使客户端没有调用 getInstance()方法。
 * 饿汉式的创建方式在一些场景中将无法使用：譬如 Singleton 实例的创建
 * 是依赖参数或者配置文件的，在 getInstance() 之前必须调用某个方法
 * 设置参数给它，那样这种单例写法就无法使用了。
 */

public class Singleton04 {
    //类加载时就初始化
    private static final Singleton04 instance = new Singleton04();

    private Singleton04(){}

    public static Singleton04 getInstance(){
        return instance;
    }
}
