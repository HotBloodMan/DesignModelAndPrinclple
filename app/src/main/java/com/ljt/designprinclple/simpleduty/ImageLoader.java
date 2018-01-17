package com.ljt.designprinclple.simpleduty;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ${JT.L} on 2018/1/17.
 * 单一职责原则：一个类应该仅有一个引起它变化的原因。简单来说：一个类应该是一组相关性很高的函数，
 * 数据的封装。
 */

public class ImageLoader {
    LruCache<String,Bitmap>  mImageCache;
    //线程的数量为CPU的数量
    ExecutorService mExecutorService= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public ImageLoader() {
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

    public void displayImage(final String url,final ImageView iv){
        iv.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap=downloadImage(url);
                if(bitmap==null){
                    return;
                }
                if(iv.getTag().equals(url)){
                    iv.setImageBitmap(bitmap);
                }
                mImageCache.put(url,bitmap);
            }
        });
    }


    public Bitmap downloadImage(String imageUrl){
        Bitmap bitmap=null;
        try {
            URL url = new URL(imageUrl);
            final HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            bitmap= BitmapFactory.decodeStream(conn.getInputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }

}
