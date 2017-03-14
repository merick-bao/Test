package com.example.pc.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by pc on 2017/2/23.
 */

public class Search extends Activity{

    private EditText search_edit;
    private TextView search_cancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        init();
    }

    private void init() {

        search_edit = (EditText) findViewById(R.id.search_edit);
        search_cancle = (TextView) findViewById(R.id.search_cancle);

        search_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
