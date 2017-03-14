package com.example.pc.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by pc on 2016/12/20.
 */

public class Main_3_Activity extends Activity{

    private EditText main3_search;

    //帮商家界面
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main3);

        InitMain3();
    }

    //初始化main3帮商家界面功能
    public void InitMain3(){

        main3_search = (EditText) findViewById(R.id.main3_search);
        main3_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_3_Activity.this,Search.class);
                startActivity(intent);
            }
        });

        //为标题栏添加按钮添加事件
        TextView AddHelp = (TextView) findViewById(R.id.main3_add_help);
        AddHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Main_3_Activity.this,GetHelp_business.class);
                startActivity(intent);
            }
        });

        //查看定位按钮-->将来实现前往地图功能
        TextView LookLocation = (TextView) findViewById(R.id.main3_business_location_describe);
        LookLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //新建一个在MainActivity界面显示的对话框
                AlertDialog.Builder builder = new AlertDialog.Builder(Main_3_Activity.this);
                builder.setTitle("提示")     //设置对话框的标题
                        .setMessage("将会前往查看地图界面")   //设置对话框的内容
                        //为对话框添加确定按钮
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //为确定按钮添加点击事件，前往地图界面
                            }
                        })
                        //为对话框添加取消按钮
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //取消按钮事件
                            }
                        });
                builder.create().show();
            }
        });

        //标题栏查看详情按钮
        Button LookDetails = (Button) findViewById(R.id.main3_buton_lookdetails);
        LookDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //新建一个在MainActivity界面显示的对话框
                AlertDialog.Builder builder = new AlertDialog.Builder(Main_3_Activity.this);
                builder.setTitle("提示")     //设置对话框的标题
                        .setMessage("将会前往详情界面")   //设置对话框的内容
                        //为对话框添加确定按钮
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //为确定按钮添加点击事件
                            }
                        });
                builder.create().show();
            }
        });

        //帮商家界面去帮他按钮
        Button TakeHelp = (Button) findViewById(R.id.main3_buton_takehelp);
        TakeHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //新建一个在MainActivity界面显示的对话框
                AlertDialog.Builder builder = new AlertDialog.Builder(Main_3_Activity.this);
                builder.setTitle("提示")     //设置对话框的标题
                        .setMessage("确认去帮助该商家")   //设置对话框的内容
                        //为对话框添加确定按钮
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //为确定按钮添加点击事件
                            }
                        })
                        //为对话框添加取消按钮
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //取消按钮事件
                            }
                        });
                builder.create().show();
            }
        });

        //帮商家界面分享按钮
        Button Share = (Button) findViewById(R.id.main3_buton_share);
        Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //新建一个在MainActivity界面显示的对话框
                AlertDialog.Builder builder = new AlertDialog.Builder(Main_3_Activity.this);
                builder.setTitle("提示")     //设置对话框的标题
                        .setMessage("分享到社交网络，让更多人来帮他")   //设置对话框的内容
                        //为对话框添加确定按钮
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //为确定按钮添加点击事件
                            }
                        })
                        //为对话框添加取消按钮
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //取消按钮事件
                            }
                        });
                builder.create().show();
            }
        });
    }

    //设置按返回键之后返回桌面
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent home = new Intent(Intent.ACTION_MAIN);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            home.addCategory(Intent.CATEGORY_HOME);
            startActivity(home);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
