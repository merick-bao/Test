package com.example.pc.test;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by pc on 2017/3/8.
 */

public class Get_Help_Item_Adapter extends RecyclerView.Adapter<Get_Help_Item_Adapter.ViewHolder>{

    private List<Get_Help_Item> mList;

    public Get_Help_Item_Adapter(List<Get_Help_Item> mList) {
        this.mList = mList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        View myView;
        TextView get_help_describe;
        TextView get_help_reward;
        TextView getGet_help_time;

        public ViewHolder(View itemView) {
            super(itemView);
            //获取当前实例
            myView = itemView;
            get_help_describe = (TextView) myView.findViewById(R.id.get_help_item_question_describe);
            get_help_reward = (TextView) myView.findViewById(R.id.get_help_item_pay_describe);
            getGet_help_time = (TextView) myView.findViewById(R.id.get_help_item_time_describe);

        }

    }

    //获取item布局
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.get_help_item,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"你好棒棒哦",Toast.LENGTH_SHORT).show();
            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Get_Help_Item item = mList.get(position);
        holder.get_help_describe.setText(item.getGet_help_describe());
        holder.get_help_reward.setText(item.getGetGet_help_reward());
        holder.getGet_help_time.setText(item.getGet_help_time());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    //添加item
    public void addItem(int position ,Get_Help_Item item){
        mList.add(position,item);
        notifyItemInserted(position);
    }

    //删除item
    public void removeItem(int position){
        mList.remove(position);
        notifyItemRemoved(position);
    }

}
