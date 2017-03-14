package com.example.pc.test;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by pc on 2017/3/1.
 */

public class Recycler_Main1_Push_Adapter extends RecyclerView.Adapter<Recycler_Main1_Push_Adapter.ViewHolder>{

    //用于存放item
    private List<Recycler_Main1_Push> mList ;

    //构造函数
    public Recycler_Main1_Push_Adapter(List<Recycler_Main1_Push> mList) {
        this.mList = mList;
    }

    //用于获取item中的控件id
    static class ViewHolder extends RecyclerView.ViewHolder{


        View myView;
        ImageView pushImage;

        public ViewHolder(View itemView) {
            super(itemView);

            //实例化单个item
            myView = itemView;
            pushImage = (ImageView) itemView.findViewById(R.id.main1_recycler_push_img);
        }
    }

    //获取item布局
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main1_push_recycler,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        //最外层点击事件，如果某个item没有设置点击事件，则会触发该点击事件
        holder.myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"哇哦~你很厉害哦",Toast.LENGTH_SHORT).show();
            }
        });

        //为推送图片添加点击事件
        holder.pushImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"首页推送",Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    //为item设置资源
    @Override
    public void onBindViewHolder(Recycler_Main1_Push_Adapter.ViewHolder holder, int position) {
        Recycler_Main1_Push push = mList.get(position);
        holder.pushImage.setImageResource(push.getPushImg_ID());
    }

    //获取item的个数
    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addData(int position){
        mList.add(position,new Recycler_Main1_Push(R.drawable.push_01));
        notifyItemInserted(position);
    }

    public void removeData(int position){
        mList.remove(position);
        notifyItemRemoved(position);
    }
}
