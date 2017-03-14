package com.example.pc.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pc on 2016/12/20.
 */

public class Main_4_Activity extends Activity{

    //帮圈子界面
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main4);

        InitMain4();
    }

    //初始化main4帮圈子界面功能
    public void InitMain4(){

        //标题栏刷新按钮
        TextView Refresh = (TextView) findViewById(R.id.main4_refresh);
        Refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main_4_Activity.this)
                        .setTitle("提示")
                        .setMessage("页面已刷新")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //获取最新动态
                            }
                        });
                builder.create().show();
            }
        });

        //标题栏发动态按钮
        TextView AddDynamic = (TextView) findViewById(R.id.main4_add_dynamic);
        AddDynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_4_Activity.this,Release_Dynamic.class);
                startActivity(intent);
            }
        });

        //帮圈子界面关注按钮
        final Button AddFollow = (Button) findViewById(R.id.main4_add_follow);
        AddFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AddFollow.getText().equals("+关注")) {
                    AddFollow.setText("已关注");
                }else{
                    AddFollow.setText("+关注");
                }

            }
        });

        //帮圈子界面点赞按钮
        final ImageView AddLove = (ImageView) findViewById(R.id.main4_add_love);
        AddLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView LoveCount = (TextView) findViewById(R.id.main4_add_love_count);
                if(LoveCount.getText().equals("32")){
                    AddLove.setImageResource(R.drawable.add_love_checked);
                    LoveCount.setText("33");
                }else {
                    LoveCount.setText("32");
                    AddLove.setImageResource(R.drawable.add_love);
                }

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
