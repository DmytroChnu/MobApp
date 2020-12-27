package com.example.mobapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    private Button backButton;

    public SettingsFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        backButton = (Button) view.findViewById(R.id.back_button2);
        backButton.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            CloseFragment();
        }
    });

        return view;
    }

    public void CloseFragment()
    {
        getActivity().onBackPressed();
    }
}