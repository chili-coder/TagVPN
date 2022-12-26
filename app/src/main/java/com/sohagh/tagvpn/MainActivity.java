package com.sohagh.tagvpn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.sohagh.tagvpn.view.AutoProjectActivity;
import com.sohagh.tagvpn.view.IpListActivity;
import com.sohagh.tagvpn.view.LoginActivity;
import com.sohagh.tagvpn.view.PrimumActivity;
import com.sohagh.tagvpn.view.SettingsActivity;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private LinearLayout premiumBtn;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    private TextView signNv,timeText;
   private LinearLayout pm;
   private Button connectBTN,discannectBTN,selectLocation;
   private ImageView onImage,offImage;

   private ConstraintLayout selectCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBarMain);
        navigationView = findViewById(R.id.navigationView);
        drawer = findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        timeText=findViewById(R.id.timeText);
       connectBTN=findViewById(R.id.connectBtn);
        discannectBTN=findViewById(R.id.discannectBtn);
        onImage=findViewById(R.id.imageViewON);
        offImage=findViewById(R.id.imageViewOFF);


        premiumBtn=findViewById(R.id.premium_Layout);
        selectCity=findViewById(R.id.itemLayout);
        selectLocation=findViewById(R.id.selectBtn);

     //   signNv=findViewById(R.id.signin_nav);


        connectBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectBTN.setVisibility(View.INVISIBLE);
                selectLocation.setVisibility(View.INVISIBLE);


                discannectBTN.setVisibility(View.VISIBLE);
                timeText.setVisibility(View.VISIBLE);
                onImage.setVisibility(View.VISIBLE);
                selectCity.setVisibility(View.VISIBLE);


            }
        });
        discannectBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                discannectBTN.setVisibility(View.INVISIBLE);
               timeText.setVisibility(View.INVISIBLE);
                onImage.setVisibility(View.INVISIBLE);
                selectCity.setVisibility(View.INVISIBLE);


               connectBTN.setVisibility(View.VISIBLE);
                selectLocation.setVisibility(View.VISIBLE);

            }
        });


        selectLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, IpListActivity.class));
            }
        });




        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        View headerview = navigationView.getHeaderView(0);
        TextView signIn = (TextView) headerview.findViewById(R.id.signin_nav);
        signIn.setText("Sign In");

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this , LoginActivity.class));
                drawer.closeDrawer(GravityCompat.START);
            }
        });




        View headerview2 = navigationView.getHeaderView(0);
        LinearLayout pmmm = (LinearLayout) headerview2.findViewById(R.id.premiumLay);
        pmmm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this ,  PrimumActivity.class));
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        View reView = navigationView.getHeaderView(0);
        LinearLayout reLay=(LinearLayout)reView.findViewById(R.id.layRestore);
        reLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(MainActivity.this , LoginActivity.class));
                drawer.closeDrawer(GravityCompat.START);
            }
        });


        LinearLayout seting=(LinearLayout)reView.findViewById(R.id.laySetting);
        seting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this , SettingsActivity.class));
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        LinearLayout con=(LinearLayout)reView.findViewById(R.id.layContract);
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mailIntent = new Intent(Intent.ACTION_VIEW);
                String emailId = "support@tagvpn.net";
                Uri data = Uri.parse("mailto:?subject=" + "Subject Here"+ "&body=" + "Your Massage Here" + "&to=" + emailId);
                mailIntent.setData(data);
                startActivity(Intent.createChooser(mailIntent, "Send mail..."));
                // startActivity(new Intent(MainActivity.this , LoginActivity.class));
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        LinearLayout faq=(LinearLayout)reView.findViewById(R.id.layFAQ);
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // startActivity(new Intent(MainActivity.this , LoginActivity.class));
                drawer.closeDrawer(GravityCompat.START);
            }
        });




        premiumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PrimumActivity.class);
                startActivity(intent);

            }
        });




        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawer.closeDrawer(GravityCompat.START);
                switch (item.getItemId()) {
                }
                return true;
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.menu_home:
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage(R.string.exit_msg)
                .setCancelable(false)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.super.onBackPressed();
                        finishAffinity();
                    }
                })
                .setNegativeButton(R.string.no, null)
                .show();
    }
}