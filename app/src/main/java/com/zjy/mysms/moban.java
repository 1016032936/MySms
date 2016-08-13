package com.zjy.mysms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by 极速蜗牛 on 2016/8/13 0013.
 */
public class moban extends Activity {
    private ListView listView;
    private String[] obj = {"ada", "asda", "adsad", "4564g5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_moban);
        listView = (ListView) findViewById(R.id.list_moban);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,obj);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("moban",obj[position]);
                setResult(20,intent);
                finish();
            }
        });
    }
}
