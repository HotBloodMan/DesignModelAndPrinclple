package com.ljt.designprinclple.simpleduty;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ${JT.L} on 2018/1/18.
 */

public class ImageLoader2 {

    ImageCache mImageCache=new ImageCache();
    //线程的数量为CPU的数量
    ExecutorService mExecutorService= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


    public void displayImage(final String url,final ImageView iv){
        Bitmap bitmap = mImageCache.get(url);
        if(bitmap!=null){
            iv.setImageBitmap(bitmap);
            return;
        }
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
