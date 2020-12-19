package com.example.mobapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    private Button startButton;
    private Button quitButton;
    private Button termsOfUseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

        startButton = (Button) findViewById(R.id.startButton);
        quitButton = (Button) findViewById(R.id.quitButton);
        termsOfUseButton = (Button) findViewById(R.id.termsOfServiceButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNextActivity();
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

        termsOfUseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenInfoActivity();
            }
        });
    }

    private void openNextActivity()
    {
        Intent intent = new Intent(this, BasicActivity.class);
        startActivity(intent);
    }

    private void OpenInfoActivity()
    {
        Intent intent = new Intent(this, InfoActivty.class);
        startActivity(intent);
    }
}