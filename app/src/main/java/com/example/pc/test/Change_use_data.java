package com.example.pc.test;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by pc on 2016/12/7.
 */

public class Change_use_data extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_use_data);

        //实现单选框
        this.CheckGroup();

        //完成注册按钮
        Button FinishChange = (Button) findViewById(R.id.use_finish_change);
        FinishChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Change_use_data.this)
                        .setTitle("提示")
                        .setMessage("信息修改成功")
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                builder.create().show();
            }
        });

        //获取验证码按钮
        Button getCheckCode = (Button) findViewById(R.id.use_data_getcheckcode);
        getCheckCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Change_use_data.this)
                        .setTitle("提示")
                        .setMessage("验证码已发送，请到手机或者邮箱查看")
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //确认收到验证码
                            }
                        });
                builder.create().show();
            }
        });

        //状态栏返回按钮
        TextView BackPre = (TextView) findViewById(R.id.change_use_data_back_button);
        BackPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //实现有两个选项的单选框
    public void CheckGroup(){
        final CheckBox checkBox1 = (CheckBox) findViewById(R.id.use_choose_to_student);
        final CheckBox checkBox2 = (CheckBox) findViewById(R.id.use_choose_to_business);

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox2.setChecked(false);
                AlertDialog.Builder builder = new AlertDialog.Builder(Change_use_data.this)
                        .setTitle("提示")
                        .setMessage("认证过程还在建设中")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.create().show();
            }
        });

        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox1.setChecked(false);
                AlertDialog.Builder builder = new AlertDialog.Builder(Change_use_data.this)
                        .setTitle("提示")
                        .setMessage("认证过程还在建设中")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.create().show();
            }
        });
    }
}
