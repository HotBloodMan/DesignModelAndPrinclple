package com.ljt.designprinclple.simpleduty;

import android.graphics.Bitmap;
import android.util.LruCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ${JT.L} on 2018/1/17.
 */

public class ImageCache {
    LruCache<String,Bitmap> mImageCache;

    public ImageCache(){
        initImageCache();
    }

    private void  initImageCache(){
        //计算可用最大内存
        final int maxMemory= (int) (Runtime.getRuntime().maxMemory()/1024);

        final int caCheSize = maxMemory / 4;
        mImageCache=new LruCache<String,Bitmap>(caCheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes()*value.getHeight()/1024;
            }
        };
    }

}
