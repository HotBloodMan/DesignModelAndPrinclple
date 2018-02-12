package com.ljt.designprinclple;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.support.v7.app.AlertDialog;
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
    private void showDialog(Context context){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        //构建AlertDialog
        AlertDialog dialog=builder.setTitle("标题")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setView(R.layout.activity_main)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .create();
        // 显示AlertDialog
        dialog.show();
    }
}
