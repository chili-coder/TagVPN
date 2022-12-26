package com.sohagh.tagvpn.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.sohagh.tagvpn.MainActivity;
import com.sohagh.tagvpn.R;

public class PrimumActivity extends AppCompatActivity {
private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primum);
        back=findViewById(R.id.back_id);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrimumActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}