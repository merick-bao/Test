package com.example.pc.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2016/12/20.
 */

public class Main_2_Activity extends Activity{

    private EditText main2_search;
    private RecyclerView main2_recyclerView;
    private List<Get_Help_Item> help_list = new ArrayList<>();
    private Get_Help_Item_Adapter adapter = new Get_Help_Item_Adapter(help_list);
    //帮同学界面
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main2);

        init_help_list();
        InitMain2();
    }

    private void init_help_list() {
        Get_Help_Item item1 = new Get_Help_Item("问题描述：想找个女朋友","报酬：可爱的我","剩余时间：100分钟");
        help_list.add(item1);

        Get_Help_Item item2 = new Get_Help_Item("问题描述：想找个男朋友","报酬：可爱的我","剩余时间：50分钟");
        help_list.add(item2);

        Get_Help_Item item3 = new Get_Help_Item("问题描述：想找个朋友","报酬：可爱的我","剩余时间：100分钟");
        help_list.add(item3);
    }

    //初始化mian2帮同学界面功能
    public void InitMain2(){

        main2_search = (EditText) findViewById(R.id.main2_search);
        main2_recyclerView = (RecyclerView) findViewById(R.id.main2_recylerview);

        main2_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_2_Activity.this,Search.class);
                startActivity(intent);
            }
        });

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        main2_recyclerView.setLayoutManager(manager);
        main2_recyclerView.setItemAnimator(new DefaultItemAnimator());

        main2_recyclerView.setAdapter(adapter);

        //为标题栏添加按钮添加事件
        TextView AddHelp = (TextView) findViewById(R.id.main2_add_help);
        AddHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Main_2_Activity.this,GetHelp_friend.class);
                startActivity(intent);
            }
        });

        //查看定位按钮-->将来实现前往地图功能
        TextView LookLocation = (TextView) findViewById(R.id.main2_use_location_describe);
        LookLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //新建一个在MainActivity界面显示的对话框
                AlertDialog.Builder builder = new AlertDialog.Builder(Main_2_Activity.this);
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

        //帮同学界面查看详情按钮
        Button LookDetails = (Button) findViewById(R.id.main2_buton_lookdetails);
        LookDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //新建一个在MainActivity界面显示的对话框
                AlertDialog.Builder builder = new AlertDialog.Builder(Main_2_Activity.this);
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

        //帮同学界面去帮他按钮
        Button TakeHelp = (Button) findViewById(R.id.main2_buton_takehelp);
        TakeHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //新建一个在MainActivity界面显示的对话框
                AlertDialog.Builder builder = new AlertDialog.Builder(Main_2_Activity.this);
                builder.setTitle("提示")     //设置对话框的标题
                        .setMessage("确认去帮助该同学")   //设置对话框的内容
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

        //帮同学界面分享按钮
        Button Share = (Button) findViewById(R.id.main2_buton_share);
        Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //新建一个在MainActivity界面显示的对话框
                AlertDialog.Builder builder = new AlertDialog.Builder(Main_2_Activity.this);
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

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        switch (requestCode){
            case 1:
                Get_Help_Item item = new Get_Help_Item("ppp","ppp","ppp");
                adapter.addItem(help_list.size(),item);
                break;
            default:
                break;
        }
    }
}
