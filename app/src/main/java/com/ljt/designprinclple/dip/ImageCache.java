package com.ljt.designprinclple.dip;

import android.graphics.Bitmap;

/**
 * Created by ${JT.L} on 2018/1/18.
 */

public interface ImageCache {
    public Bitmap get(String url);
    public void put(String url,Bitmap bmp);
}
