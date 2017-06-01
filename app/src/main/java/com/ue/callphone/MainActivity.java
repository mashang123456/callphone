package com.ue.callphone;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etNum = (EditText) findViewById(R.id.et_number);
        Button btCallPhone = (Button) findViewById(R.id.bt_callphone);

        btCallPhone.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 String number = etNum.getText().toString().trim();
                 Intent itCall = new Intent();
                 itCall.setAction(Intent.ACTION_CALL);
                 itCall.setData(Uri.parse("tel:" + number));
                 startActivity(itCall);
/*
                 Intent intent = new Intent();
				 intent.setAction(Intent.ACTION_VIEW);
				 intent.setData(Uri.parse("http://www.baidu.com"));
				 startActivity(intent);
*/
             }
        });
    }
}
