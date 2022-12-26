package com.sohagh.tagvpn.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sohagh.tagvpn.R;

public class LoginActivity extends AppCompatActivity {
private TextView createNow,forgotText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        createNow=findViewById(R.id.createNow);
        forgotText=findViewById(R.id.fotgotText);

        createNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });
        forgotText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this,ForgotPassActivity.class));
            }
        });
    }
}