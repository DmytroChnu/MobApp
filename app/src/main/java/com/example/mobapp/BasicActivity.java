package com.example.mobapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import timber.log.Timber;

public class BasicActivity extends AppCompatActivity {

    Handler handler = new Handler();
    Runnable runnable;
    int delay = 1000; // in milliseconds

    private Button infoButton;
    private Button settingsButton;
    private Button shareButton;

    private long startTimeInSeconds;
    private long currentActiveTimeInSeconds = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_activity);

        startTimeInSeconds = GetCurrentTimeInSeconds();

        infoButton = (Button) findViewById(R.id.info_button);
        settingsButton = (Button) findViewById(R.id.settings_button);
        shareButton = (Button) findViewById(R.id.share_button);

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowInfoFragment();
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowSettingsFragment();
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Share();
            }
        });
    }

    private void ShowInfoFragment()
    {
        InfoFragment fragment= new InfoFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activity, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        Timber.d("Opened info fragment");
    }

    private void ShowSettingsFragment()
    {
        SettingsFragment fragment= new SettingsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activity, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        Timber.d("Opened settings fragment");
    }

    private void Share()
    {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Download this app: https://github.com/DmytroChnu/MobApp");
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);

        Timber.d("Share");
    }

    @Override
    protected void onPause() {
        handler.removeCallbacks(runnable);
        super.onPause();
    }

    @Override
    protected void onResume()
    {
        handler.postDelayed(runnable = new Runnable() {
            public void run() {
                handler.postDelayed(runnable, delay);
                Timber.d("Current focus time = " + currentActiveTimeInSeconds);
                currentActiveTimeInSeconds++;
            }
        }, delay);

        super.onResume();
    }

    @Override
    public void onDestroy()
    {
        long currentTime = GetCurrentTimeInSeconds();
        Timber.d("App total use time = " + Math.abs(currentTime - startTimeInSeconds));
        Timber.d("Total focus time = " + currentActiveTimeInSeconds);

        super.onDestroy();
    }

    private long GetCurrentTimeInSeconds() {
        return System.currentTimeMillis() / 1000;
    }
}