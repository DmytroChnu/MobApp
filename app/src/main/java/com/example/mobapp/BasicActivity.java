package com.example.mobapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BasicActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private Button aboutButton;
    private TextView aboutTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_activity);

        trueButton = (Button) findViewById(R.id.trueButton);
        falseButton = (Button) findViewById(R.id.falseButton);
        aboutButton = (Button) findViewById(R.id.aboutButton);
        aboutTextView = (TextView) findViewById(R.id.aboutTextView);

        aboutTextView.setEnabled(false);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowAboutTextView(!aboutTextView.isEnabled());
            }
        });
    }

    private void ShowAboutTextView(Boolean show)
    {
        aboutTextView.setEnabled(show);
    }
}