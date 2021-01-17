package com.example.mobapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import timber.log.Timber;

public class BasicActivity extends AppCompatActivity
{
    Timer timer;

    private Button infoButton;
    private Button settingsButton;
    private Button shareButton;

    private static final String myKey = "myKey";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_activity);

        timer = new Timer();
        timer.RegisterLifecycle(getLifecycle());
        timer.SetStartTime();

        infoButton = (Button) findViewById(R.id.info_button);
        settingsButton = (Button) findViewById(R.id.settings_button);
        shareButton = (Button) findViewById(R.id.share_button);

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowSettingsFragment();
            }
        });
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowInfoFragment();
            }
        });
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Share();
            }
        });

        if(savedInstanceState != null)
        {
            int value = savedInstanceState.getInt(myKey);
            Timber.d("Value " + value + " retrieved");
        }
        else
        {
            Timber.d("savedInstanceState is null");
        }

        Timber.d("onCreate");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id)
        {
            case R.id.main_menu :
                onBackPressed();
                return true;
            case R.id.settings_menu:
                ShowInfoFragment();
                return true;
            case R.id.info_menu:
                ShowSettingsFragment();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Timber.d("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Timber.d("onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Timber.d("onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Timber.d("onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Timber.d("onPause");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState)
    {
        super.onSaveInstanceState(outState);

        outState.putInt(myKey, 42);
        Timber.d("onSaveInstanceState called");
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
}