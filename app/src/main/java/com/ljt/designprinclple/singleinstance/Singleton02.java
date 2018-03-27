package com.ljt.designprinclple.singleinstance;

/**
 * Created by ${JT.L} on 2018/3/27.
 */

public class Singleton02 {
    private static Singleton02 singleton02;
    private Singleton02(){}
/*
* 程序员称其为双重检查锁，因为会有两次检查 instance == null，
* 一次是在同步块外，一次是在同步块内。为什么在同步块内还要再检验一次？
* 因为可能会有多个线程一起进入同步块外的 if，
* 如果在同步块内不进行二次检验的话就会生成多个实例了。
*
* 这段代码看起来很完美，很可惜，它是有问题。主要在于instance = new Singleton()这句，这并非是一个原子操作，事实上在 JVM 中这句话大概做了下面 3 件事情。

给 instance 分配内存
调用 Singleton 的构造函数来初始化成员变量
将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）
但是在 JVM 的即时编译器中存在指令重排序的优化。
也就是说上面的第二步和第三步的顺序是不能保证的，最终的执行顺序可能是 1-2-3 也可能是 1-3-2。如果是后者，
则在 3 执行完毕、2 未执行之前，被线程二抢占了，这时 instance 已经是非 null 了（但却没有初始化）
，所以线程二会直接返回 instance，然后使用，然后顺理成章地报错。
* */
    public static Singleton02 getSingleton02(){
        if(singleton02==null){
          synchronized (Singleton02.class){
              if(singleton02==null){
                  singleton02=new Singleton02();
              }
          }
        }
        return singleton02;
    }

}
