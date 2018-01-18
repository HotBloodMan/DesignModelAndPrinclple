package com.ljt.designprinclple.interfacesegregation;

import android.graphics.Bitmap;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by ${JT.L} on 2018/1/18.
 */

public class DiskCache2 {

    String cacheDir="";
    public void put(String url,Bitmap bitmap) {
        FileOutputStream fileOut = null;

        try {
            fileOut = new FileOutputStream(cacheDir + url);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
           CloseUtils.closeQuietly(fileOut);
        }
    }
}
