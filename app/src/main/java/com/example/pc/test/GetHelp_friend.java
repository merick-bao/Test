package com.example.pc.test;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * Created by pc on 2017/2/21.
 */

public class GetHelp_friend extends AppCompatActivity {

    private TextView gethelp_back;
    private TextView gethelp_put;
    private TextView gethelp_location;

    public static final int SHOW_LOCATION = 1;
    private LocationManager locationManager;
    private String provider;


    private Handler handler = new Handler(){
        public void handleMessage(Message message){
            switch (message.what){
                case SHOW_LOCATION:
                    String currentLocation = (String) message.obj;
                    gethelp_location.setText(currentLocation);
                    break;
                default:
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_help);

        gethelp_back = (TextView) findViewById(R.id.get_help_title_back);
        gethelp_put = (TextView) findViewById(R.id.get_help_title_put);
        gethelp_location = (TextView) findViewById(R.id.get_help_location_get);

        init();

    }

    public void init() {
        //获取帮助界面返回按钮
        gethelp_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //获取帮助界面发布按钮
        gethelp_put.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GetHelp_friend.this)
                        .setTitle("提示")
                        .setMessage("发布成功")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(GetHelp_friend.this,FinalMainActivity.class);
                                setResult(1,intent);
                                //startActivity(intent);
                                finish();
                            }
                        });
                builder.create().show();
            }
        });

        //获取帮助界面获取位置信息
        gethelp_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                //获取所有可用的位置提供器
                List<String> providerList = locationManager.getProviders(true);
                if (providerList.contains(LocationManager.GPS_PROVIDER)) {
                    provider = LocationManager.GPS_PROVIDER;
                } else if (providerList.contains(LocationManager.NETWORK_PROVIDER)) {
                    provider = LocationManager.NETWORK_PROVIDER;
                } else {
                    //当没有可用的位置提供器是，弹出Toast提示用户
                    Toast.makeText(GetHelp_friend.this, "No Location provider to use", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (ActivityCompat.checkSelfPermission(GetHelp_friend.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(GetHelp_friend.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                Location location = locationManager.getLastKnownLocation(provider);
                if (location != null) {
                    //显示当前设备的位置信息
                    showLocation(location);
                }
                locationManager.requestLocationUpdates(provider, 5000, 1, locationListener);
            }
        });
    }

    //重写系统销毁方法
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (locationManager != null) {
            //关闭程序时将监听器移除
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.removeUpdates(locationListener);
        }
    }

    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            showLocation(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    private void showLocation(final Location location){

        String currentPosition = location.getLatitude() + " "+ location.getLongitude();
        Message msg = new Message();
        msg.what = SHOW_LOCATION;
        msg.obj = currentPosition;
        handler.sendMessage(msg);
    }


}
