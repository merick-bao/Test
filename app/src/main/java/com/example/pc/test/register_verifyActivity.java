package com.example.pc.test;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by pc on 2016/12/3.
 */
public class register_verifyActivity extends AppCompatActivity {

    private Button finish_regist;
    private TextView verify_back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_verify);


        //完成注册，返回登录界面
        finish_regist = (Button)findViewById(R.id.verify_finish_button);
        finish_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(register_verifyActivity.this)
                        .setTitle("提示")
                        .setMessage("注册成功").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                Intent it = new Intent();
                                it.setClass(register_verifyActivity.this,Login.class);
                                startActivity(it);
                                finish();
                            }
                        });
                //builder.setCanceledOnTouchOutside(true);
                builder.create().show();
            }
        });


        //返回按钮
        verify_back = (TextView) findViewById(R.id.verify_back);
        verify_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回输入个人信息界面
                Intent intent = new Intent();
                intent.setClass(register_verifyActivity.this,registerActivity.class);
                startActivity(intent);
            }
        });
    }


}
