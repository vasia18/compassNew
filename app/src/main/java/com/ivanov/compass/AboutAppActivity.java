package com.ivanov.compass;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AboutAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);


        getSupportActionBar().setTitle("О приложении"); // Прописываем название в ToolBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Прописываем стрелку назад
    }
}
