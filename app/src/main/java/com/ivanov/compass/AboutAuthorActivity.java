package com.ivanov.compass;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class AboutAuthorActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_author);

		getSupportActionBar().setTitle("O авторе");  // Прописываем название в ToolBar
	}
}
