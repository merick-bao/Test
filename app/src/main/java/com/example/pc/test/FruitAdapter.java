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
 * Created by pc on 2016/12/19.
 */

public class FruitAdapter extends ArrayAdapter<Fruit>{

    private int resourceId;

    public FruitAdapter(Context context,int textViewResourceId, List<Fruit> objects) {
        super(context,textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Fruit fruit = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);

        ImageView fruitimage = (ImageView) view.findViewById(R.id.fruit_image);
        TextView fruitname = (TextView) view.findViewById(R.id.fruit_name);

        fruitimage.setImageResource(fruit.getImageId());
        fruitname.setText(fruit.getName());

        return view;
    }
}
