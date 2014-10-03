package com.greenfoxmedia.greenfoxmedia;

import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

public class StartUpScreenActivity extends ActionBarActivity {

	public ProgressBar m_bar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_up_screen);
		
		final String[] files = new String[100];
		files[0] = "Lade Benutzerdaten...";
		files[1] = "Kontaktiere Datenbank...";
		files[2] = "Syncronisiere Inhalte...";
		files[3] = "Initialisiere Schnittstellen...";
		files[4] = "generiere Views...";
		files[5] = "Lade Bilder...";
		files[7] = "";
		files[8] = "";
		files[9] = "";
		files[10] = "";
		files[11] = "";
		
		CountDownTimer timer = new CountDownTimer(3000, 100) {
			Random r = new Random();
			
			@Override
			public void onTick(long millisUntilFinished) {
				int i1 = r.nextInt(12 - 0);
				TextView showText = (TextView) findViewById(R.id.textView1);
				showText.setText(files[i1]);
			}
			
			@Override
			public void onFinish() {
				CountDownTimer startActivity = new CountDownTimer(1500, 100) {
					@Override
					public void onTick(long millisUntilFinished) {
						TextView showText = (TextView) findViewById(R.id.textView1);
						showText.setText("Starte App...");
					}
					
					@Override
					public void onFinish() {
						startActivity(new Intent(getApplicationContext(), LoginScreenActivity.class));
					}
				};
				startActivity.start();
			}
		};
		
		timer.start();
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_up_screen, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
