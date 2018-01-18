package com.ljt.designprinclple.dip;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.ljt.designprinclple.ocp.*;

/**
 * Created by ${JT.L} on 2018/1/18.
 * 依赖倒置原则（DIP）：Dependence Inversion Principle
 * 关键点：1  高层模块不应该依赖低层模块，两者都应该依赖其抽象
 *       2 抽象不应该依赖细节
 *       3 细节应该依赖抽象
 *  Java中表现：模块间的依赖通过抽象发生，实现类之间不发生直接的依赖关系
 *  ，其依赖关系是通过接口或抽象类产生的。
 *
 *
 */

public class ImageLoader {

    //图片缓存类，依赖于抽象，并且有一个默认的实现
    ImageCache mCache=new MemoryCache();

    public void displayImage(String url, ImageView iv){
        Bitmap bitmap = mCache.get(url);
        if(bitmap==null){
            //异步下载图片
        }else{
            iv.setImageBitmap(bitmap);
        }
    }

    public void setImageCache(ImageCache cache){
        mCache=cache;
    }

}
