package com.example.animationrecyclerview.activity;

import android.os.Bundle;
import android.provider.Settings;
import android.provider.Settings.Secure;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.animationrecyclerview.R;

public class DetailActivity extends AppCompatActivity {

    TextView contact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initViews();
    }

    void initViews() {
        contact = findViewById(R.id.tv_name);
        contact.setText(getIntent().getSerializableExtra("contact").toString());
    }
}