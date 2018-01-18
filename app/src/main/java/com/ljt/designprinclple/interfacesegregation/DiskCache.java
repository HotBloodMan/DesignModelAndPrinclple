package com.ljt.designprinclple.interfacesegregation;

import android.graphics.Bitmap;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ${JT.L} on 2018/1/18.
 * 接口隔离：ISP(interface segregation principles) 客户端不应该依赖它不需要的接口，另一种定义：
 * 类间的依赖关系应该建立在最小的接口上。
 * 目的：系统松开耦合，从而容易重构，更改和重新部署。
 */

public class DiskCache {
    String cacheDir="";
    public void put(String url,Bitmap bitmap){
        FileOutputStream fileOut=null;

        try {
            fileOut=new FileOutputStream(cacheDir+url);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            //这个地方可读性很差
            if(fileOut!=null){
                    try {
                        fileOut.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }  //end if
            }//end if finally
        }
}
