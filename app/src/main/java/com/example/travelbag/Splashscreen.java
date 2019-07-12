package com.example.travelbag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        boolean firstRun = pref.getBoolean("firstRun", true);

        if(firstRun){
            editor.putBoolean("firstRun",false);
            editor.commit();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(Splashscreen.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            }, 1200);
        }else{
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(Splashscreen.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }, 1200);
        }

        getSupportActionBar().hide();
    }
}
