package com.example.pc.test;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by pc on 2016/12/20.
 */

public class FinalMainActivity extends TabActivity{

    //主界面tab
    private TabHost tabHost;
    private TextView button_color;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_main);


        //初始化tab
        tabHost=this.getTabHost();
        TabHost.TabSpec spec;
        Intent intent;

        intent=new Intent().setClass(this, Main_1_Activity.class);
        spec=tabHost.newTabSpec("帮首页").setIndicator("帮首页").setContent(intent);
        tabHost.addTab(spec);

        intent=new Intent().setClass(this,Main_2_Activity.class);
        spec=tabHost.newTabSpec("帮同学").setIndicator("帮同学").setContent(intent);
        tabHost.addTab(spec);

        intent=new Intent().setClass(this, Main_3_Activity.class);
        spec=tabHost.newTabSpec("帮商家").setIndicator("帮商家").setContent(intent);
        tabHost.addTab(spec);


        intent=new Intent().setClass(this, Main_4_Activity.class);
        spec=tabHost.newTabSpec("帮圈子").setIndicator("帮圈子").setContent(intent);
        tabHost.addTab(spec);

        intent=new Intent().setClass(this,Main_5_Activity.class);
        spec=tabHost.newTabSpec("我").setIndicator("我").setContent(intent);
        tabHost.addTab(spec);
        tabHost.setCurrentTab(0);


        //底部tab栏
        RadioGroup radioGroup=(RadioGroup) this.findViewById(R.id.main_tab_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.final_main_tab_main1://帮首页界面
                        tabHost.setCurrentTabByTag("帮首页");
                        change_button_text_color(checkedId);
                        break;
                    case R.id.final_main_tab_main2://帮同学界面
                        tabHost.setCurrentTabByTag("帮同学");
                        change_button_text_color(checkedId);
                        break;
                    case R.id.final_main_tab_main3://帮商家界面
                        tabHost.setCurrentTabByTag("帮商家");
                        change_button_text_color(checkedId);
                        break;
                    case R.id.final_main_tab_main4://帮圈子界面
                        tabHost.setCurrentTabByTag("帮圈子");
                        change_button_text_color(checkedId);
                        break;
                    case R.id.final_main_tab_main5:
                        tabHost.setCurrentTabByTag("我");
                        change_button_text_color(checkedId);
                        break;
                    default:
                        //tabHost.setCurrentTabByTag("帮首页");
                        break;
                }
            }
        });


    }

    public void change_button_text_color(int checkedId){
        final int Id[]={R.id.final_main_tab_main1,R.id.final_main_tab_main2,R.id.final_main_tab_main3,
                R.id.final_main_tab_main4,R.id.final_main_tab_main5};
        button_color = (TextView) findViewById(checkedId);
        button_color.setTextColor(getResources().getColor(R.color.origin));
        for(int i=0;i<Id.length;i++){
            if(Id[i]!=checkedId){
                button_color = (TextView) findViewById(Id[i]);
                button_color.setTextColor(getResources().getColor(R.color.black));
            }
        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        switch (requestCode){
            case 1:
                tabHost.setCurrentTab(1);

                break;
            case 2:
                tabHost.setCurrentTab(2);
                break;
            default:
                tabHost.setCurrentTab(0);
                break;
        }
    }

}
