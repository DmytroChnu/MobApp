package com.example.mobapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class InfoFragment extends Fragment
{
    private String mParam1;
    private String mParam2;

    private Button backButton;
    private Button privacyPolicyButton;
    private Button termsOfServiceButton;

    private static String privacyPolicy = "https://policies.google.com/privacy?hl=en-US";
    private static String termsOfService = "https://en.wikipedia.org/wiki/Terms_of_service#:~:text=Terms%20of%20service%20(also%20known,to%20use%20the%20offered%20service";

    public InfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_info, container, false);

        backButton = (Button) view.findViewById(R.id.back_button);
        privacyPolicyButton = (Button) view.findViewById(R.id.privacyButton);
        termsOfServiceButton = (Button) view.findViewById(R.id.termsButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CloseFragment();
            }
        });

        privacyPolicyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenPrivacyPolicy();
            }
        });

        termsOfServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenTermsOfService();
            }
        });

        return view;
    }

    private void OpenPrivacyPolicy() {
        Uri uri = Uri.parse(privacyPolicy);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void OpenTermsOfService() {
        Uri uri = Uri.parse(termsOfService);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void CloseFragment()
    {
        getActivity().onBackPressed();
    }
}