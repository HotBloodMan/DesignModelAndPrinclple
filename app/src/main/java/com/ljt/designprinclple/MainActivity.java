package com.ljt.designprinclple;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ljt.designprinclple.ocp.DiskCache;
import com.ljt.designprinclple.ocp.DoubleCache;
import com.ljt.designprinclple.ocp.ImageCache;
import com.ljt.designprinclple.ocp.ImageLoader;
import com.ljt.designprinclple.ocp.MemoryCache;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageLoader loader=new ImageLoader();
        loader.setImageCache(new MemoryCache());
        loader.setImageCache(new DiskCache());
        loader.setImageCache(new DoubleCache());
        loader.setImageCache(new ImageCache() {
            @Override
            public Bitmap get(String url) {
                return null;
            }
            @Override
            public void put(String url, Bitmap bmp) {
            }
        });
    }
}
