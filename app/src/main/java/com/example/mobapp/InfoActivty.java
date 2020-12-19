package com.example.mobapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoActivty extends AppCompatActivity {

    private Button privacyPolicyButton;
    private Button termsOfServiceButton;
    private Button backButton;

    private static String privacyPolicy = "https://policies.google.com/privacy?hl=en-US";
    private static String termsOfService = "https://en.wikipedia.org/wiki/Terms_of_service#:~:text=Terms%20of%20service%20(also%20known,to%20use%20the%20offered%20service";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);

        privacyPolicyButton = (Button) findViewById(R.id.privacyButton);
        termsOfServiceButton = (Button) findViewById(R.id.termsButton);
        backButton = (Button) findViewById(R.id.backButton);

        privacyPolicyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(privacyPolicy);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        termsOfServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(termsOfService);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNextActivity();
            }
        });
    }

    private void openNextActivity()
    {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }
}