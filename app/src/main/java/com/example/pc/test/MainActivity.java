//package com.example.pc.test;
//
//import android.app.AlertDialog;
//import android.app.TabActivity;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.TabHost;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
///**
// * Created by pc on 2016/12/5.
// *
// * Failed attempt
// */
//
//public class MainActivity extends TabActivity{
//
//    //储存用户之星
//    private List<Use_Star> use_stars = new ArrayList<>();
//    private List list = new ArrayList();
//    private List<Fruit> fruitList = new ArrayList<>();
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main_activity);
//
////        //初始化用户之星
////        init_Use_Star();
////        Use_Star_Adapter adapter = new Use_Star_Adapter(MainActivity.this,R.layout.use_star_list_item,use_stars);
////        ListView listView = (ListView) findViewById(R.id.use_star_list);
////        listView.setAdapter(adapter);
//
////        init();
////        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,list);
////        ListView listView = (ListView) findViewById(R.id.use_star_list);
////        listView.setAdapter(adapter);
//
//        initFruit();
//        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit,fruitList);
//        ListView listView = (ListView) findViewById(R.id.use_star_list);
//        listView.setAdapter(adapter);
//
//
//        //初始化选项卡
//        this.InitTab();
//
//        //添加帮同学界面的功能
//        this.InitMain2();
//
//        //添加帮商家界面的功能
//        this.InitMain3();
//
//        //添加帮圈子界面的功能
//        this.InitMain4();
//
//        //添加个人中心界面功能
//        this.InitMain5();
//    }
//
//    public void initFruit(){
//        for(int i= 0;i<5;i++){
//            Fruit fruit = new Fruit("橘子",R.drawable.time_table);
//            fruitList.add(fruit);
//        }
//    }
//
//    //重写返回按钮
//    @Override
//    public void onBackPressed() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
//                .setTitle("提示")
//                .setMessage("你确定要退出吗？")
//                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        System.exit(0);
//                    }
//                })
//                .setNegativeButton("再看看", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//        builder.create().show();
//    }
//
//    //初始化选项卡
//    public void InitTab(){
//
//        //获取该Activity里边的TabHost组件
//        TabHost tabHost = this.getTabHost();
//
//        //创建第一个Tab界面
//        TabHost.TabSpec tab01 = tabHost.newTabSpec("tab01")
//                .setIndicator("帮首页")   //设置标题
//                .setContent(R.id.tab01);  //设置内容
//        //添加第一个选项卡
//        tabHost.addTab(tab01);
//
//        TabHost.TabSpec tab02 = tabHost.newTabSpec("tab02")
//                .setIndicator("帮同学")
//                .setContent(R.id.tab02);
//        tabHost.addTab(tab02);
//
//        TabHost.TabSpec tab03 = tabHost.newTabSpec("tab03")
//                .setIndicator("帮商家")
//                .setContent(R.id.tab03);
//        tabHost.addTab(tab03);
//
//        TabHost.TabSpec tab04 = tabHost.newTabSpec("tab04")
//                .setIndicator("帮圈子")
//                .setContent(R.id.tab04);
//        tabHost.addTab(tab04);
//
//        TabHost.TabSpec tab05 = tabHost.newTabSpec("tab05")
//                .setIndicator("我")
//                .setContent(R.id.tab05);
//        tabHost.addTab(tab05);
//    }
//
//    //初始化mian2帮同学界面功能
//    public void InitMain2(){
//
//        //为标题栏添加按钮添加事件
//        TextView AddHelp = (TextView) findViewById(R.id.main2_add_help);
//        AddHelp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("提示")
//                        .setMessage("开始发布需要的帮助").setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //为对话框确定按钮添加事件
//                            }
//                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //为对话框取消按钮添加事件
//                            }
//                        });
//                builder.create().show();
//            }
//        });
//
//        //查看定位按钮-->将来实现前往地图功能
//        TextView LookLocation = (TextView) findViewById(R.id.main2_use_location_describe);
//        LookLocation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //新建一个在MainActivity界面显示的对话框
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle("提示")     //设置对话框的标题
//                .setMessage("将会前往查看地图界面")   //设置对话框的内容
//                        //为对话框添加确定按钮
//                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        //为确定按钮添加点击事件，前往地图界面
//                    }
//                })
//                        //为对话框添加取消按钮
//                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        //取消按钮事件
//                    }
//                });
//                builder.create().show();
//            }
//        });
//
//        //帮同学界面查看详情按钮
//        Button LookDetails = (Button) findViewById(R.id.main2_buton_lookdetails);
//        LookDetails.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //新建一个在MainActivity界面显示的对话框
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle("提示")     //设置对话框的标题
//                        .setMessage("将会前往详情界面")   //设置对话框的内容
//                        //为对话框添加确定按钮
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //为确定按钮添加点击事件
//                            }
//                        });
//                builder.create().show();
//            }
//        });
//
//        //帮同学界面去帮他按钮
//        Button TakeHelp = (Button) findViewById(R.id.main2_buton_takehelp);
//        TakeHelp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //新建一个在MainActivity界面显示的对话框
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle("提示")     //设置对话框的标题
//                        .setMessage("确认去帮助该同学")   //设置对话框的内容
//                        //为对话框添加确定按钮
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //为确定按钮添加点击事件
//                            }
//                        })
//                        //为对话框添加取消按钮
//                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //取消按钮事件
//                            }
//                        });
//                builder.create().show();
//            }
//        });
//
//        //帮同学界面分享按钮
//        Button Share = (Button) findViewById(R.id.main2_buton_share);
//        Share.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //新建一个在MainActivity界面显示的对话框
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle("提示")     //设置对话框的标题
//                        .setMessage("分享到社交网络，让更多人来帮他")   //设置对话框的内容
//                        //为对话框添加确定按钮
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //为确定按钮添加点击事件
//                            }
//                        })
//                        //为对话框添加取消按钮
//                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //取消按钮事件
//                            }
//                        });
//                builder.create().show();
//            }
//        });
//
//    }
//
//    //初始化main3帮商家界面功能
//    public void InitMain3(){
//        //为标题栏添加按钮添加事件
//        TextView AddHelp = (TextView) findViewById(R.id.main3_add_help);
//        AddHelp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("提示")
//                        .setMessage("开始发布需要的帮助").setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //为对话框确定按钮添加事件
//                            }
//                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //为对话框取消按钮添加事件
//                            }
//                        });
//                builder.create().show();
//            }
//        });
//
//        //查看定位按钮-->将来实现前往地图功能
//        TextView LookLocation = (TextView) findViewById(R.id.main3_business_location_describe);
//        LookLocation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //新建一个在MainActivity界面显示的对话框
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle("提示")     //设置对话框的标题
//                        .setMessage("将会前往查看地图界面")   //设置对话框的内容
//                        //为对话框添加确定按钮
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //为确定按钮添加点击事件，前往地图界面
//                            }
//                        })
//                        //为对话框添加取消按钮
//                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //取消按钮事件
//                            }
//                        });
//                builder.create().show();
//            }
//        });
//
//        //标题栏查看详情按钮
//        Button LookDetails = (Button) findViewById(R.id.main3_buton_lookdetails);
//        LookDetails.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //新建一个在MainActivity界面显示的对话框
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle("提示")     //设置对话框的标题
//                        .setMessage("将会前往详情界面")   //设置对话框的内容
//                        //为对话框添加确定按钮
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //为确定按钮添加点击事件
//                            }
//                        });
//                builder.create().show();
//            }
//        });
//
//        //帮商家界面去帮他按钮
//        Button TakeHelp = (Button) findViewById(R.id.main3_buton_takehelp);
//        TakeHelp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //新建一个在MainActivity界面显示的对话框
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle("提示")     //设置对话框的标题
//                        .setMessage("确认去帮助该商家")   //设置对话框的内容
//                        //为对话框添加确定按钮
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //为确定按钮添加点击事件
//                            }
//                        })
//                        //为对话框添加取消按钮
//                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //取消按钮事件
//                            }
//                        });
//                builder.create().show();
//            }
//        });
//
//        //帮商家界面分享按钮
//        Button Share = (Button) findViewById(R.id.main3_buton_share);
//        Share.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //新建一个在MainActivity界面显示的对话框
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle("提示")     //设置对话框的标题
//                        .setMessage("分享到社交网络，让更多人来帮他")   //设置对话框的内容
//                        //为对话框添加确定按钮
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //为确定按钮添加点击事件
//                            }
//                        })
//                        //为对话框添加取消按钮
//                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //取消按钮事件
//                            }
//                        });
//                builder.create().show();
//            }
//        });
//    }
//
//    //初始化main4帮圈子界面功能
//    public void InitMain4(){
//
//        //标题栏刷新按钮
//        TextView Refresh = (TextView) findViewById(R.id.main4_refresh);
//        Refresh.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("提示")
//                        .setMessage("刷新页面")
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //获取最新动态
//                            }
//                        });
//                builder.create().show();
//            }
//        });
//
//        //标题栏发动态按钮
//        TextView AddDynamic = (TextView) findViewById(R.id.main4_add_dynamic);
//        AddDynamic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("提示")
//                        .setMessage("发布你的最新动态")
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //前往编辑个人动态界面
//                            }
//                        })
//                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //取消
//                            }
//                        });
//                builder.create().show();
//            }
//        });
//
//        //帮圈子界面关注按钮
//        final Button AddFollow = (Button) findViewById(R.id.main4_add_follow);
//        AddFollow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(AddFollow.getText().equals("+关注")) {
//                    AddFollow.setText("已关注");
//                }else{
//                    AddFollow.setText("+关注");
//                }
//
//            }
//        });
//
//        //帮圈子界面点赞按钮
//        final ImageView AddLove = (ImageView) findViewById(R.id.main4_add_love);
//        AddLove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TextView LoveCount = (TextView) findViewById(R.id.main4_add_love_count);
//                if(LoveCount.getText().equals("32")){
//                    LoveCount.setText("33");
//                }else {
//                    LoveCount.setText("32");
//                }
//
//            }
//        });
//
//    }
//
//    //初始化main5个人中心界面功能
//    public void InitMain5(){
//
//        //修改个人资料按钮
//        Button ChangeUseData = (Button) findViewById(R.id.main5_change_usedata);
//        ChangeUseData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this,Change_use_data.class);
//                startActivity(intent);
//            }
//        });
//
//        //个人中心9个item————>待开发
//
//        //item1我的帮助
//        TextView item1 = (TextView) findViewById(R.id.main5_item1_describe);
//        item1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("提示")
//                        .setMessage("正在建设中")
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //实现具体功能
//                            }
//                        });
//                builder.create().show();
//            }
//        });
//
//        //item2我帮助过谁
//        TextView item2 = (TextView) findViewById(R.id.main5_item2_describe);
//        item2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("提示")
//                        .setMessage("正在建设中")
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //实现具体功能
//                            }
//                        });
//                builder.create().show();
//            }
//        });
//
//        //item3我的关注
//        TextView item3 = (TextView) findViewById(R.id.main5_item3_describe);
//        item3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("提示")
//                        .setMessage("正在建设中")
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //实现具体功能
//                            }
//                        });
//                builder.create().show();
//            }
//        });
//
//        //item4我的帮圈子
//        TextView item4 = (TextView) findViewById(R.id.main5_item4_describe);
//        item4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("提示")
//                        .setMessage("正在建设中")
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //实现具体功能
//                            }
//                        });
//                builder.create().show();
//            }
//        });
//
//        //item5我的钱包
//        TextView item5 = (TextView) findViewById(R.id.main5_item5_describe);
//        item5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("提示")
//                        .setMessage("正在建设中")
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //实现具体功能
//                            }
//                        });
//                builder.create().show();
//            }
//        });
//
//        //item6有奖推广
//        TextView item6 = (TextView) findViewById(R.id.main5_item6_describe);
//        item6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("提示")
//                        .setMessage("谢谢支持n(*≧▽≦*)n")
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //实现具体功能
//                            }
//                        });
//                builder.create().show();
//            }
//        });
//
//        //item7版本更新
//        TextView item7 = (TextView) findViewById(R.id.main5_item7_describe);
//        item7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("提示")
//                        .setMessage("已是最新版本")
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //实现具体功能
//                            }
//                        });
//                builder.create().show();
//            }
//        });
//
//        //item8意见反馈
//        TextView item8 = (TextView) findViewById(R.id.main5_item8_describe);
//        item8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("提示")
//                        .setMessage("请加QQ1247602405进行反馈")
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //实现具体功能
//                            }
//                        });
//                builder.create().show();
//            }
//        });
//
//        //item9退出登录
//        TextView item9 = (TextView) findViewById(R.id.main5_item9_describe);
//        item9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("提示")
//                        .setMessage("将会返回到登录界面")
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Intent intent = new Intent();
//                                intent.setClass(MainActivity.this,LoginActivity.class);
//                                startActivity(intent);
//                                finish();
//                            }
//                        })
//                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //取消操作
//                            }
//                        });
//                builder.create().show();
//            }
//        });
//    }
//
//    //初始化用户之星列表
//    public void init_Use_Star(){
//
//        //以后要从数据库中获取数据
//        String use_star_name[] = {"张同学","陈同学","李同学"};
//        String use_star_introduce[] = {"与大家一起互帮互助！！！","与大家一起互帮互助！！！","与大家一起互帮互助！！！"};
//        for (int i = 0;i<use_star_name.length;i++){
//            if (i %2 ==0){
//                Use_Star use_star = new Use_Star(use_star_name[i],use_star_name[i].charAt(0),use_star_introduce[i],R.drawable.ico_sex_male);
//                use_stars.add(use_star);
//            }else {
//                Use_Star use_star = new Use_Star(use_star_name[i], use_star_name[i].charAt(0), use_star_introduce[i], R.drawable.ico_sex_fmale);
//                use_stars.add(use_star);
//            }
//        }
////        for (int i= 0;i<3;i++){
////            Use_Star use_star = new Use_Star("张上",'6',"dadads",R.drawable.ico_sex_fmale);
////
////        }
//    }
//}
