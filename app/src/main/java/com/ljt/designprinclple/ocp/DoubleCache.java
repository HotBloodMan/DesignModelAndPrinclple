package com.ljt.designprinclple.ocp;

import android.graphics.Bitmap;

/**
 * Created by ${JT.L} on 2018/1/16.
 */

public class DoubleCache implements  ImageCache {

    ImageCache mMemory=new MemoryCache();
    ImageCache mDiskCache=new DiskCache();

    //先从内存缓存中获取图片，如果没有，再从SD卡中获取
    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = mMemory.get(url);
        if(bitmap==null){
            bitmap=mDiskCache.get(url);
        }
        return bitmap;
    }
    //将图片缓存到内存和SD卡中
    @Override
    public void put(String url, Bitmap bmp) {
      mMemory.put(url,bmp);
      mDiskCache.put(url,bmp);
    }
}
