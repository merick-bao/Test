package com.example.pc.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pc on 2016/12/18.
 */

//用户之星适列表配器
public class Use_Star_Adapter extends ArrayAdapter<Use_Star>{

    private int resourcesId;

    public Use_Star_Adapter(Context context, int resource, List<Use_Star> objects) {
        super(context, resource, objects);
        resourcesId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //获取当前的UseStar实例
        Use_Star use_star = getItem(position);
        //root对象
        View view = LayoutInflater.from(getContext()).inflate(resourcesId,null);

        //获取布局
        TextView use_star_name = (TextView) view.findViewById(R.id.use_star_list_name);
        TextView use_star_head = (TextView) view.findViewById(R.id.use_star_list_head);
        TextView use_star_introduce = (TextView) view.findViewById(R.id.use_star_list_introduce);
        ImageView use_star_sex = (ImageView) view.findViewById(R.id.use_star_list_sex);
        TextView use_star_score = (TextView) view.findViewById(R.id.use_star_score);

        //为布局添加内容
        use_star_name.setText(use_star.getUse_star_name());
        use_star_head.setText(use_star.getUse_star_head());
        use_star_introduce.setText(use_star.getUse_star_introduce());
        use_star_sex.setImageResource(use_star.getUse_star_sexid());
        use_star_score.setText(use_star.getUse_star_score());

        return view;
    }
}
