package com.ivanov.compass;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class LogoActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logo);

		// Прописываем переход от заставки logoActivity к CompassActivity
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent i = new Intent(LogoActivity.this, CompassActivityOne.class);
				startActivity(i);
				finish();
			}
		}, 2*1000);


	}
}
