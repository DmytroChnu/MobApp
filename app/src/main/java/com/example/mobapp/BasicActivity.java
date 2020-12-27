package com.example.mobapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class BasicActivity extends AppCompatActivity {

    private Button infoButton;
    private Button settingsButton;
    private Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_activity);

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
    }

    private void ShowSettingsFragment()
    {
        SettingsFragment fragment= new SettingsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activity, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void Share()
    {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Download this app: https://github.com/DmytroChnu/MobApp");
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
}