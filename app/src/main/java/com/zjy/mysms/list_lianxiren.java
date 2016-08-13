package com.zjy.mysms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 极速蜗牛 on 2016/8/13 0013.
 */
public class list_lianxiren extends Activity{
    private ListView list_view;
    public List<obj> list_str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lianxiren);
        list_view = (ListView) findViewById(R.id.list_view);
        list_str = new ArrayList<obj>();

        for (int i=0; i< 50; i++){
            obj obj = new obj();
            obj.setName("zhan"+i);
            obj.setPhone("1523");
            list_str.add(obj);
        }

        myadapter myadapter = new myadapter();
        list_view.setAdapter(myadapter);

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent back_intent = new Intent();
                back_intent.putExtra("phone",list_str.get(position).getPhone());
                setResult(10,back_intent);
                finish();
            }
        });

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    class  myadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list_str.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view;
            if (convertView == null){
                view = View.inflate(getApplicationContext(),R.layout.item_lian,null);
            }else {
                view = convertView;
            }
            TextView name = (TextView) view.findViewById(R.id.name);
            TextView phone = (TextView) view.findViewById(R.id.phone);

            name.setText(list_str.get(position).getName());
            phone.setText(list_str.get(position).getPhone());
            return view;
        }
    }
}
