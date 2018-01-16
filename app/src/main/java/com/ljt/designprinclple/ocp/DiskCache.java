package com.ljt.designprinclple.ocp;

import android.graphics.Bitmap;

/**
 * Created by ${JT.L} on 2018/1/16.
 */

public class DiskCache implements  ImageCache {

    //从本地文件获取该图片
    @Override
    public Bitmap get(String url) {
        return null;
    }

    //将Bitmap写入文件中
    @Override
    public void put(String url, Bitmap bmp) {

    }
}
