package com.fhx.propertyuser.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.FileUtils;
import android.provider.MediaStore;
import android.util.Log;

import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.DownloadProgressCallBack;
import com.zhouyou.http.exception.ApiException;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.FileNameMap;
import java.net.URLConnection;

public class UpdatePhotoAlbumUtil {




    /**
     * 下载网络图片
     * url
     * 照片名字
     */
    public static String downLodeImage(String imageUrl,String name){
//        String imageUrl = "http://a3.att.hudong.com/64/52/01300000407527124482522224765.jpg";
       String path = null;
        EasyHttp.downLoad(imageUrl)
                .saveName(name+".png")//不设置默认名字是时间戳生成的
                .execute(new DownloadProgressCallBack<String>() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onError(ApiException e) {

                    }

                    @Override
                    public void update(long bytesRead, long contentLength, boolean done) {

                    }

                    @Override
                    public void onComplete(String path) {
                        //下载完成，path：下载文件保存的完整路径
                        Log.e("downLode",path);
//                        file = new File(path);
                        path =path;
                    }
                });
        return path;
    }




    /**
     * 兼容android 10
     * 更新图库
     * @param mContext
     * @param file
     */
    public static void updatePhotoAlbum(Context mContext, File file) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ContentValues values = new ContentValues();
            values.put(MediaStore.MediaColumns.DISPLAY_NAME, file.getName());
            values.put(MediaStore.MediaColumns.MIME_TYPE, getMimeType(file));
            values.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DCIM);
            ContentResolver contentResolver = mContext.getContentResolver();
            Uri uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            if (uri == null) {
                return;
            }
            try {
                OutputStream out = contentResolver.openOutputStream(uri);
                FileInputStream fis = new FileInputStream(file);
                FileUtils.copy(fis, out);
                fis.close();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            MediaScannerConnection.scanFile(mContext.getApplicationContext(), new String[]{file.getAbsolutePath()}, new String[]{"image/jpeg"}, new MediaScannerConnection.OnScanCompletedListener() {
                @Override
                public void onScanCompleted(String path, Uri uri) {

                }
            });
        }
    }


    public static String getMimeType(File file) {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        String type = fileNameMap.getContentTypeFor(file.getName());
        return type;
    }

}
