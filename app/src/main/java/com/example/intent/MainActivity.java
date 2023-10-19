package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etSubject;
    private EditText etMessage;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {
        etEmail = findViewById(R.id.email_et);
        etSubject = findViewById(R.id.subject_et);
        etMessage = findViewById(R.id.message_et);
        btnSend = findViewById(R.id.btn_send);
    }
    private void initListener() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject = etSubject.getText().toString();
                String email = etEmail.getText().toString();
                String message = etMessage.getText().toString();

                if (subject.equals("") || email.equals("") || message.equals("")){
                    Toast.makeText(MainActivity.this,"Заполните поля",Toast.LENGTH_SHORT);
                }else {
                    goToEmail(subject,email,message);
                }
            }
        });
    }

    private void goToEmail(String subject,String email,String message) {
        Intent intentGmail  = new Intent(Intent.ACTION_SEND);
        intentGmail.putExtra(Intent.EXTRA_EMAIL,new String[]{email});
        intentGmail.putExtra(Intent.EXTRA_SUBJECT,subject);
        intentGmail.putExtra(Intent.EXTRA_TEXT,message);
        intentGmail.setType("message/rfc822");
        startActivity(Intent.createChooser(intentGmail,"ololo"));

    }
}