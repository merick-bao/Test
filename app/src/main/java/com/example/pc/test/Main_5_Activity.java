package com.example.pc.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by pc on 2016/12/20.
 */

public class Main_5_Activity extends Activity{

    //我的界面
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main5);

        InitMain5();
    }

    //初始化main5个人中心界面功能
    public void InitMain5(){

        //修改个人资料按钮
        Button ChangeUseData = (Button) findViewById(R.id.main5_change_usedata);
        ChangeUseData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Main_5_Activity.this,Change_use_data.class);
                startActivity(intent);
            }
        });

        //个人中心9个item————>待开发

        //item1我的帮助
        TextView item1 = (TextView) findViewById(R.id.main5_item1_describe);
        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main_5_Activity.this)
                        .setTitle("提示")
                        .setMessage("正在建设中")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //实现具体功能
                            }
                        });
                builder.create().show();
            }
        });

        //item2我帮助过谁
        TextView item2 = (TextView) findViewById(R.id.main5_item2_describe);
        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main_5_Activity.this)
                        .setTitle("提示")
                        .setMessage("正在建设中")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //实现具体功能
                            }
                        });
                builder.create().show();
            }
        });

        //item3我的关注
        TextView item3 = (TextView) findViewById(R.id.main5_item3_describe);
        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main_5_Activity.this)
                        .setTitle("提示")
                        .setMessage("正在建设中")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //实现具体功能
                            }
                        });
                builder.create().show();
            }
        });

        //item4我的帮圈子
        TextView item4 = (TextView) findViewById(R.id.main5_item4_describe);
        item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main_5_Activity.this)
                        .setTitle("提示")
                        .setMessage("正在建设中")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //实现具体功能
                            }
                        });
                builder.create().show();
            }
        });

        //item5我的钱包
        TextView item5 = (TextView) findViewById(R.id.main5_item5_describe);
        item5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main_5_Activity.this)
                        .setTitle("提示")
                        .setMessage("正在建设中")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //实现具体功能
                            }
                        });
                builder.create().show();
            }
        });

        //item6个性设置
        TextView item6 = (TextView) findViewById(R.id.main5_item6_describe);
        item6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main_5_Activity.this)
                        .setTitle("提示")
                        .setMessage("谢谢支持n(*≧▽≦*)n")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //实现具体功能
                            }
                        });
                builder.create().show();
            }
        });

        //item7版本更新
        TextView item7 = (TextView) findViewById(R.id.main5_item7_describe);
        item7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main_5_Activity.this)
                        .setTitle("提示")
                        .setMessage("已是最新版本")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //实现具体功能
                            }
                        });
                builder.create().show();
            }
        });

        //item8意见反馈
        TextView item8 = (TextView) findViewById(R.id.main5_item8_describe);
        item8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main_5_Activity.this)
                        .setTitle("提示")
                        .setMessage("请加QQ1247602405进行反馈")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //实现具体功能
                            }
                        });
                builder.create().show();
            }
        });

        //item9退出登录
        TextView item9 = (TextView) findViewById(R.id.main5_item9_describe);
        item9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main_5_Activity.this)
                        .setTitle("提示")
                        .setMessage("将会返回到登录界面")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent();
                                intent.setClass(Main_5_Activity.this,Login.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //取消操作
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
