package com.example.animationrecyclerview.activity;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animationrecyclerview.R;
import com.example.animationrecyclerview.adapter.ContactAdapter;
import com.example.animationrecyclerview.model.Contact;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.AccountPicker;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final int ANY_CODE = 1001;
    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final int REQUEST_CODE = 1001;
    ArrayList<Contact> contacts = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getting phone id
//        String android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
//        Log.d("android_id", "onCreate: " + android_id);

        initViews();
    }

    void initViews() {
        recyclerView = findViewById(R.id.rv_contacts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        fillContactList();

        refreshAdapter();
    }

    void refreshAdapter() {
        ContactAdapter contactAdapter = new ContactAdapter(this, contacts);
        recyclerView.setAdapter(contactAdapter);
    }

    public void openDetailPage(int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("contact", contacts.get(position));
        startActivity(intent);
    }

    void fillContactList() {
        for (int i = 1; i <= 30; i++) {
            contacts.add(new Contact("Contact_name" + i, "+(998)93-247-97-78"));
        }
    }
}
