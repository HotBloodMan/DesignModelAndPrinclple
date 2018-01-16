package com.ljt.designprinclple.ocp;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by ${JT.L} on 2018/1/16.
 */

public class MemoryCache implements  ImageCache {

    private LruCache<String,Bitmap> mMemoryCache;

    public MemoryCache() {
        int max= (int) (Runtime.getRuntime().maxMemory()/8);
        this.mMemoryCache = new LruCache<String,Bitmap>(max){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();
            }
        };
    }
    @Override
    public Bitmap get(String url) {
        return mMemoryCache.get(url);
    }
    @Override
    public void put(String url, Bitmap bmp) {
        mMemoryCache.put(url,bmp);
    }
}
