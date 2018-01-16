package com.ljt.designprinclple.ocp;

import android.graphics.Bitmap;
//OCP:开闭原则，对扩展开放，对修改关闭
public interface ImageCache {
   public Bitmap get(String url);
   public void put(String url,Bitmap bmp);

}