package com.sohagh.tagvpn.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sohagh.tagvpn.R;

public class OtpActivity extends AppCompatActivity {
private Button comBtn;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        comBtn=findViewById(R.id.confirmBtn);

        toolbar = findViewById(R.id.toolBarOTP);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Forgot Password");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        comBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OtpActivity.this,ChangePassActivity.class));
            }
        });
    }
}