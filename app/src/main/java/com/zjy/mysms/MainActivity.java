package com.zjy.mysms;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button send;
    private Button monban;
    private Button add;
    private EditText phone_ed;
    private EditText show_ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        send = (Button) findViewById(R.id.send);
        monban= (Button) findViewById(R.id.moban);
        add= (Button) findViewById(R.id.add);
        phone_ed= (EditText) findViewById(R.id.phone_ed);
        show_ed= (EditText) findViewById(R.id.show_ed);

        send.setOnClickListener(this);
        add.setOnClickListener(this);
        monban.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add:
                Intent intent_add = new Intent(this,list_lianxiren.class);
                startActivityForResult(intent_add,1);
                break;
            case R.id.send:
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phone_ed.getText().toString(),null,show_ed.getText().toString(),null,null);
                break;
            case R.id.moban:
                Intent intent_moban = new Intent(this,moban.class);
                startActivityForResult(intent_moban,2);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 10){
            String phone = data.getStringExtra("phone");
            phone_ed.setText(phone);
        }else if (resultCode == 20){
            String moban = data.getStringExtra("moban");
            show_ed.setText(moban);
        }
    }
}
