package com.sohagh.tagvpn.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.sohagh.tagvpn.R;

public class SettingsActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ConstraintLayout autoLay,share,rate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        toolbar = findViewById(R.id.toolBarSetting);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Settings");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        autoLay=findViewById(R.id.auto_settings_id);
        share=findViewById(R.id.share_settings_id);
        rate=findViewById(R.id.rate_settings_id);

        autoLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingsActivity.this , AutoProjectActivity.class));
            }
        });


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "TAG VPN \n Application Download Link: ";
                String downloadText="ApplicationDownload Link";
                String shareUrl= "https://play.google.com/store/apps/details?id=";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareBody);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);

                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareUrl + getPackageName());
                startActivity(Intent.createChooser(sharingIntent, "Sharevia"));

            }
        });

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                            Uri uri = Uri.parse("market://details?id=" +getPackageName());
                            Intent in = new Intent(Intent.ACTION_VIEW,uri);
                            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(in);
                        } catch (ActivityNotFoundException e){
                            Uri uri =Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName());
                            Intent in =new Intent(Intent.ACTION_VIEW,uri);
                            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(in);
                        }
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}