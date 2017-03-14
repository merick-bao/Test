package com.example.pc.test;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

/**
 * Created by pc on 2017/2/22.
 */

public class Release_Dynamic extends Activity{

    private TextView dynamic_back;
    private TextView dynamic_put;
    private TextView dynamic_add_picture;
    private ImageView dynamic_picture;
    private Uri imageUri;
    private final int TAKE_PHOTO = 1;
    private final int CHOOSE_PHOTO = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.release_dynamic);

        init();
    }

    private void init() {

        dynamic_back = (TextView) findViewById(R.id.release_dynamic_title_back);
        dynamic_put = (TextView) findViewById(R.id.release_dynamic_title_put);
        dynamic_add_picture = (TextView) findViewById(R.id.release_dynamic_add_picture);
        dynamic_picture = (ImageView) findViewById(R.id.release_dynamic_picture);

        dynamic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        dynamic_put.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Release_Dynamic.this)
                        .setTitle("提示")
                        .setMessage("发布成功")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                builder.create().show();
            }
        });

        dynamic_add_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Release_Dynamic.this)
                        .setTitle("提示")
                        .setMessage("请选择照片获取途径")
                        .setPositiveButton("拍照", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        //创建File对象，用于储存拍照后的图片
                                        File outputImage = new File(getExternalCacheDir(),"output_image.jpg");
                                        try {
                                            if (outputImage.exists()){
                                                outputImage.delete();
                                            }
                                            outputImage.createNewFile();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }

                                        if (Build.VERSION.SDK_INT>=24){
                                            imageUri = FileProvider.getUriForFile(Release_Dynamic.this,"com.example.pc.test",outputImage);
                                        }else{
                                            imageUri = Uri.fromFile(outputImage);
                                        }

                                        //启动相机程序
                                        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                                        intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                                        startActivityForResult(intent,TAKE_PHOTO);
                                    }
                                }).start();

                            }
                        }).setNegativeButton("相册", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (ContextCompat.checkSelfPermission(Release_Dynamic.this, WRITE_EXTERNAL_STORAGE)!=
                                        PackageManager.PERMISSION_GRANTED){
                                    ActivityCompat.requestPermissions(Release_Dynamic.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                                }else {
                                    openAlbum();
                                }
                            }
                        });
                builder.create().show();
            }
        });
    }

    private void openAlbum() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent,CHOOSE_PHOTO);//打开相册
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    openAlbum();
                }else {
                    Toast.makeText(this,"without permission",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK){
                    //将拍摄的照片显示出来
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        dynamic_picture.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case CHOOSE_PHOTO:
                if (resultCode == RESULT_OK){
                    //判断手机系统版本号
                    if (Build.VERSION.SDK_INT>=19){
                        //4.4系统及以上使用该方法处理图片
                        handleImageOnKitKat(data);
                    }else {
                        //4.4系统以下使用该方法处理图片
                        handleImageBeforeKitKat(data);
                    }
                }
            default:
                break;
        }
    }

    private void handleImageBeforeKitKat(Intent data) {
        Uri uri = data.getData();
        String imagePath = getImagePath(uri,null);
        displayImage(imagePath);
    }

    private void displayImage(String imagePath) {
        if (imagePath != null){
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            dynamic_picture.setImageBitmap(bitmap);
        }else {
            Toast.makeText(this,"获取失败",Toast.LENGTH_SHORT).show();
        }
    }

    private String getImagePath(Uri uri, String selection) {
        String path = null;
        //通过Uri和selection来获取图片的真是路径
        Cursor cursor = getContentResolver().query(uri,null,selection,null,null);
        if (cursor!=null){
            if (cursor.moveToFirst()){
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void handleImageOnKitKat(Intent data) {

        String imagePath = null;
        Uri uri = data.getData();
        if (DocumentsContract.isDocumentUri(this,uri)){
            //如果是document类型的Uri，通过document id 处理
            String  docId = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())){
                String id = docId.split(":")[1]; //解析出数字格式的ID
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,selection);
            }else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())){
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"),Long.valueOf(docId));
                imagePath = getImagePath(contentUri,null);
            }
        }else if ("content".equalsIgnoreCase(uri.getScheme())){
            //如果是content类型的uri，用普通方法处理
            imagePath = getImagePath(uri,null);
        }else if ("file".equalsIgnoreCase(uri.getScheme())){
            //如果是file类型的uri，直接获取图片路径即可
            imagePath = uri.getPath();
        }
        displayImage(imagePath); //根据图片路径显示图片
    }


}
