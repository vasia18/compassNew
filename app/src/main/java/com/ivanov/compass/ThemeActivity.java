package com.ivanov.compass;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class ThemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_activity);

        getSupportActionBar().setTitle("Тема"); // Прописываем название в ToolBar
        getSupportActionBar().setHomeButtonEnabled(true);// Прописываем стрелку назад
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}
