package com.sohagh.tagvpn.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import com.sohagh.tagvpn.MainActivity;
import com.sohagh.tagvpn.R;

public class PolicyActivity extends AppCompatActivity {

    private Button acceptTram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);
        acceptTram=findViewById(R.id.tram_acceptBtn);

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean agreed = sharedPreferences.getBoolean("agreed",false);
//        if (!agreed) {
//            new AlertDialog.Builder(PolicyActivity.this)
//                    .setTitle("License agreement")
//                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            SharedPreferences.Editor editor = sharedPreferences.edit();
//                            editor.putBoolean("agreed", true);
//                            editor.commit();
//                            Intent a = new Intent(PolicyActivity.this, MainActivity.class);
//                            startActivity(a);
//                        }
//                    })
//                    .setNegativeButton("No", null)
//                    .setMessage("tram and condition")
//                    .show();
//        }else {
//            if (agreed){
//                Intent a = new Intent(PolicyActivity.this, MainActivity.class);
//                startActivity(a);
//            }
//        }

        if (!agreed){
            acceptTram.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("agreed", true);
                            editor.commit();
                    Intent a = new Intent(PolicyActivity.this, SkipActivity.class);
                    startActivity(a);
                    finish();

                }
            });
        } else {

            Intent a = new Intent(PolicyActivity.this, SkipActivity.class);
            startActivity(a);
            finish();
        }


    }
}