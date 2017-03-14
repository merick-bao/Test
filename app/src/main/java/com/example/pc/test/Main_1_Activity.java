package com.example.pc.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2016/12/20.
 */

public class Main_1_Activity extends Activity{

    private List<Use_Star> use_starList = new ArrayList<>();
    private List<Recycler_Main1_Push> pushList = new ArrayList<>();
    private TextView add_push;

    //帮首页界面
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_main1);

        initPushImg();
        initUseStar();

        //RecyclerView横向推送
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main1_push_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        final Recycler_Main1_Push_Adapter recycler_adapter = new Recycler_Main1_Push_Adapter(pushList);

        recyclerView.setAdapter(recycler_adapter);

        Use_Star_Adapter adapter = new Use_Star_Adapter(Main_1_Activity.this,R.layout.use_star_list_item,use_starList);
        ListView listView = (ListView) findViewById(R.id.use_star_list);
        //为listView添加点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Use_Star use_star = use_starList.get(position);

                Toast.makeText(Main_1_Activity.this,"正在实现中...",Toast.LENGTH_SHORT).show();
            }
        });
        listView.setAdapter(adapter);

        add_push = (TextView) findViewById(R.id.main1_text_use_star);
        add_push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recycler_adapter.addData(pushList.size() );
                Toast.makeText(Main_1_Activity.this,"done",Toast.LENGTH_SHORT).show();
            }
        });
    }

    //初始化推送图片
    public void initPushImg(){
        Recycler_Main1_Push push1 = new Recycler_Main1_Push(R.drawable.push_01);
        pushList.add(push1);
        Recycler_Main1_Push push2 = new Recycler_Main1_Push(R.drawable.push_02);
        pushList.add(push2);
        Recycler_Main1_Push push3 = new Recycler_Main1_Push(R.drawable.push_03);
        pushList.add(push3);
    }

    //初始化用户之星，以后会从数据库获取数据
    public void initUseStar(){

        final String score[]={"1003","999","909","787","666","662","520","540","500","499"};
        final String name[]={"李小芳","刘小雷","张小玫","王太利","程晓娇","张杰","蔡小花","潘翔","王月","李华"};

        for (int i=0;i<10;i++){
            if (i%2==0){
                Use_Star use_star = new Use_Star(name[i],"头像","漂亮的女孩子",R.drawable.ico_sex_fmale,score[i]);
                use_starList.add(use_star);
            }else {
                Use_Star use_star = new Use_Star(name[i],"头像","乐于助人的男孩子",R.drawable.ico_sex_male,score[i]);
                use_starList.add(use_star);
            }
        }
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
