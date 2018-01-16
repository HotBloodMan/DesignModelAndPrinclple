package com.ljt.designprinclple.ocp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ${JT.L} on 2018/1/16.
 */

public class ImageLoader {
    ImageCache imageCache=new MemoryCache();

    //线程池，线程数量为CPU的数量
    ExecutorService mExecu= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    //注入缓存实现
    public void setImageCache(ImageCache cache){
        imageCache=cache;
    }
    public void  displayImage(String url, ImageView iv){
        Bitmap bitmap = imageCache.get(url);
        if(bitmap!=null){
            iv.setImageBitmap(bitmap);
            return;
        }
        submitLoadRequest(url,iv);
    }

    private void submitLoadRequest(final String url,final  ImageView ivs){
        ivs.setTag(url);
        mExecu.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(url);
                if(bitmap==null){
                    return;
                }
                if(ivs.getTag().equals(url)){
                    ivs.setImageBitmap(bitmap);
                }
                imageCache.put(url,bitmap);
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
