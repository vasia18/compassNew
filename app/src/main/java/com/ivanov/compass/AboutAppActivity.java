package com.ivanov.compass;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class AboutAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);


        getSupportActionBar().setTitle("О при"); // Прописываем название в ToolBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Прописываем стрелку назад
        getSupportActionBar().setHomeButtonEnabled(true);

    }
}
