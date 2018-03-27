package com.ljt.designprinclple.singleinstance;

/**
 * Created by ${JT.L} on 2018/3/27.
 */

public class Singleton03 {
    /*
    * 有些人认为使用 volatile 的原因是可见性，
    * 也就是可以保证线程在本地不会存有 instance 的副本，
    * 每次都是去主内存中读取。但其实是不对的。
    * 使用 volatile 的主要原因是其另一个特性：禁止指令重排序优化。
    * 也就是说，在 volatile 变量的赋值操作后面会有一个内存屏障（生成的汇编代码上）
    * ，读操作不会被重排序到内存屏障之前。比如上面的例子，
    * 取操作必须在执行完 1-2-3 之后或者 1-3-2 之后，
    * 不存在执行到 1-3 然后取到值的情况。
    * 从「先行发生原则」的角度理解的话，就是对于一个 volatile 变量的写操
    * 作都先行发生于后面对这个变量的读操作（这里的“后面”是时间上的先后顺序）
    *
    *
    * */
    private volatile static Singleton03 instance; //声明成 volatile
    private Singleton03 (){}

    public static Singleton03 getSingleton() {
        if (instance == null) {
            synchronized (Singleton03.class) {
                if (instance == null) {
                    instance = new Singleton03();
                }
            }
        }
        return instance;
    }
}
