package com.sohagh.tagvpn.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.snackbar.Snackbar;
import com.sohagh.tagvpn.MainActivity;
import com.sohagh.tagvpn.R;

import java.util.ArrayList;
import java.util.List;

public class SkipActivity extends AppCompatActivity {


   private LinearLayout googleBtn,fbBtn,skipBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip);

        googleBtn=findViewById(R.id.googleLay);
        fbBtn=findViewById(R.id.fbLay);
        skipBtn=findViewById(R.id.skipLay);

        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), R.string.continue_with_google, Snackbar.LENGTH_LONG);
                snackbar.show();

            }
        });
        fbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), R.string.continue_with_fb, Snackbar.LENGTH_LONG);
                snackbar.show();

            }
        });

        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SkipActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });










        ///image slider start
        ImageSlider imgSlider = findViewById(R.id.image_slider);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.sk1, ScaleTypes.CENTER_INSIDE));
        slideModels.add(new SlideModel(R.drawable.sk2, ScaleTypes.CENTER_INSIDE));
        slideModels.add(new SlideModel(R.drawable.sk3, ScaleTypes.CENTER_INSIDE));
      //  slideModels.add(new SlideModel("https://picsum.photos/id/237/200/300", ScaleTypes.FIT));
       // slideModels.add(new SlideModel("https://picsum.photos/seed/picsum/200/300", ScaleTypes.FIT));
        imgSlider.setImageList(slideModels);

        ///image slider end



    }
}