package com.manuni.smssending;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText phoneET, messageET;
    private Button sendMessageBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneET = findViewById(R.id.editTextPhoneNo);
        messageET = findViewById(R.id.editTextSMS);
        sendMessageBtn = findViewById(R.id.btnSendSMS);

        sendMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = phoneET.getText().toString();
                String messages = messageET.getText().toString();

                SmsManager manager = SmsManager.getDefault();
                try {
                    manager.sendTextMessage(phoneNumber,null,messages,null,null);
                    Toast.makeText(MainActivity.this, "Message send.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Message failed.", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });
    }
}