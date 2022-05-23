package com.manuni.smssending;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondWaySMS extends AppCompatActivity {
    private Button sendSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_way_sms);

        sendSms = findViewById(R.id.sendSMS);

        sendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendThisSms();
            }
        });
    }
    @SuppressLint("IntentReset")
    private void sendThisSms(){

        Log.i("Send sms","");
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse("smsto:"));
        sendIntent.setType("vnd.android-dir/mms-sms");
        sendIntent.putExtra("address",new String("01774362950;01757928878"));
        sendIntent.putExtra("sms_body","Hello this is me.");
        try {
            startActivity(sendIntent);
            finish();
            Log.i("Finished sending SMS...","");
        } catch (Exception e) {
            Toast.makeText(this, "Failed sending sms", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}