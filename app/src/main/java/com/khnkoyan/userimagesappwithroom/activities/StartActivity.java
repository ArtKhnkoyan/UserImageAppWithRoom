package com.khnkoyan.userimagesappwithroom.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.khnkoyan.userimagesappwithroom.R;
import com.khnkoyan.userimagesappwithroom.databases.AppDatabase;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        final boolean isLoggedIn = AppDatabase
                .getInstance(this)
                .getDao()
                .isLoggedIn();

        final String selectLoginedUser =  AppDatabase
                .getInstance(this)
                .getDao()
                .selectLoginedUser();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (isLoggedIn) {
                    Intent intent = new Intent(StartActivity.this, ProfileActivity.class);
                    intent.putExtra("email", selectLoginedUser);
                    startActivity(intent);
                    finish();
                } else {
                    startActivity(new Intent(StartActivity.this, LoginActivity.class));
                    finish();
                }
            }
        }, 3000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppDatabase.destroyInstance();
    }
}
