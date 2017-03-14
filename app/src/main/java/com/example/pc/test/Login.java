package com.example.pc.test;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    //保存密码所用到的控件
    private CheckBox savePassword;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private TextView register;
    private Button login;
    private EditText accountEdit;
    private EditText passwordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //初始化注册
        init();
    }

    public void init(){

        accountEdit = (EditText) findViewById(R.id.login_username_input);
        passwordEdit = (EditText) findViewById(R.id.login_password_input);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        savePassword = (CheckBox) findViewById(R.id.login_checkbox_save_password);

        boolean issaved = preferences.getBoolean("save_password",false);
        if (issaved){
            //如果有保存密码将账号和密码都设置到文本框中
            String account = preferences.getString("account","");
            String password = preferences.getString("password","");
            accountEdit.setText(account);
            passwordEdit.setText(password);
        }

        //注册按钮，进入注册界面
        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent();
                it.setClass(Login.this,registerActivity.class);
                startActivity(it);
            }
        });



        //登录按钮
        login = (Button)findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                //账号正确性判断逻辑，应用数据库
                if (account.equals("123456") && password.equals("123456")){
                    editor = preferences.edit();
                    if (savePassword.isChecked()){//保存密码被选中

                        editor.putBoolean("save_password",true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                    } else {
                        //清除保存的密码和账号信息
                        editor.clear();
                    }
                    editor.apply();

                    Intent it = new Intent();
                    it.setClass(Login.this,FinalMainActivity.class);
                    startActivity(it);
                    finish();
                } else {
                    Toast.makeText(Login.this, "账号或密码输入错误",Toast.LENGTH_SHORT).show();
                    passwordEdit.setText("");
                }
            }
        });


    }


    //重写返回按钮
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Login.this)
                .setTitle("提示").setMessage("你确定要退出吗？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                }).setNegativeButton("再看看", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.create().show();
    }
}
