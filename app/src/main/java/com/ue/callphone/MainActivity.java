package com.ue.callphone;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉窗口的title
        //去掉标题栏注意这句一定要写在setContentView()方法的前面，不然会报错的
        setContentView(R.layout.activity_main);

        final EditText etNum = (EditText) findViewById(R.id.et_number);
        //第一种按键：匿名内部类
        Button btCallPhone = (Button) findViewById(R.id.bt_callphone);
        btCallPhone.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 String number = etNum.getText().toString().trim();
                 Intent itCall = new Intent();
                 itCall.setAction(Intent.ACTION_CALL);
                 itCall.setData(Uri.parse("tel:" + number));
                 startActivity(itCall);
                 //第二种按键:将功能单独封装成一个函数
                 //callWeb();
             }
        });

        //第二种按键:将功能单独封装成一个函数
        Button bt2 = (Button) findViewById(R.id.bt2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callWeb();
            }
        });

        //第三种按键:内部类
        Button bt3 = (Button) findViewById(R.id.bt3);
        bt3.setOnClickListener(new MyOnClickListener());


    }

    //第二种按键:将功能单独封装成一个函数
    private void callWeb() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.baidu.com"));
        startActivity(intent);
    }

    //第三种按键:内部类
    class MyOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            Toast.makeText(MainActivity.this, "Toast提示", Toast.LENGTH_SHORT).show();
        }
    }






}
