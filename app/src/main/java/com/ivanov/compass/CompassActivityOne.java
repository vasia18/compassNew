package com.ivanov.compass;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;


public class CompassActivityOne extends AppCompatActivity {

	private static final String TAG = "CompassActivity";

	private Compass compass;
	private ImageView arrowView;
	private TextView sotwLabel;  // SOTW is for "side of the world"

	private float currentAzimuth;
	private SOTWFormatter sotwFormatter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compass);

		sotwFormatter = new SOTWFormatter(this);

		arrowView = findViewById(R.id.main_image_hands);
		sotwLabel = findViewById(R.id.sotw_label);
		setupCompass();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_compass, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();

		switch (id) {
			case R.id.menu_about_app:
				Intent intent = new Intent(this, AboutAppActivity.class);
				startActivity(intent);
				break;
			case R.id.menu_about_author:
				Intent intent1 = new Intent(this, AboutAuthorActivity.class);
				startActivity(intent1);
				break;
			case R.id.menu_action_settings:
				Intent intent2 = new Intent(this, ActionSettingsActivity.class);
				startActivity(intent2);
				break;
			case R.id.menu_theme_activity:
				Intent intent3 = new Intent(this, ThemeActivity.class);
				startActivity(intent3);
				break;
			case R.id.share:
				ApplicationInfo api = getApplicationContext().getApplicationInfo();
				String apkpath = api.sourceDir;
				Intent intent4 = new Intent(Intent.ACTION_SEND);
				intent4.setType("Application/vnd.android.package-archive");
				intent4.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(apkpath)));
				startActivity(Intent.createChooser(intent4, "ShareVia"));
				break;
			default:


		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "start compass");
		compass.start();
	}

	@Override
	protected void onPause() {
		super.onPause();
		compass.stop();
	}

	@Override
	protected void onResume() {
		super.onResume();
		compass.start();
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d(TAG, "stop compass");
		compass.stop();
	}

	private void setupCompass() {
		compass = new Compass(this);
		Compass.CompassListener cl = getCompassListener();
		compass.setListener(cl);
	}

	private void adjustArrow(float azimuth) {
		Log.d(TAG, "установить вращение от " + currentAzimuth + " до "
				+ azimuth);

		Animation an = new RotateAnimation(-currentAzimuth, -azimuth,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		currentAzimuth = azimuth;

		an.setDuration(500);
		an.setRepeatCount(0);
		an.setFillAfter(true);

		arrowView.startAnimation(an);
	}

	private void adjustSotwLabel(float azimuth) {
		sotwLabel.setText(sotwFormatter.format(azimuth));
	}

	private Compass.CompassListener getCompassListener() {
		return new Compass.CompassListener() {
			@Override
			public void onNewAzimuth(final float azimuth) {
				// UI updates only in UI thread
				// https://stackoverflow.com/q/11140285/444966
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						adjustArrow(azimuth);
						adjustSotwLabel(azimuth);
					}
				});
			}
		};
	}
}
