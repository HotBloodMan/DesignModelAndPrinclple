package com.ljt.designprinclple.interfacesegregation;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by ${JT.L} on 2018/1/18.
 * closeQuietly 方法的基本原理就是依赖于Closeable抽象而不是具体实现，并且建立在最小化依赖
 * 原则的基础上，他只需要知道这个对象是可关闭，其他的一概不关心，也就是这里的接口隔离原则。
 */

public final class CloseUtils {
    private  CloseUtils(){}
    public static void closeQuietly(Closeable closeable){
        if(null != closeable){
            try {
                closeable.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
