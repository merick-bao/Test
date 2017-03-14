package com.example.pc.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by pc on 2016/12/3.
 */
public class registerActivity extends AppCompatActivity{

    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        //为下一步按钮添加事件监听器，让其跳转到获取验证码界面
        next= (Button)findViewById(R.id.register_next_button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setClass(registerActivity.this,register_verifyActivity.class);
                startActivity(it);
                finish();
            }
        });
    }
}
