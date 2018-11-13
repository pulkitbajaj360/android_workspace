package com.example.android.sharedpreference;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PreferenceManager pm=new PreferenceManager(this);

        if(pm.isExistingUser()){
            Intent i = new Intent(getApplicationContext(), login.class);
            startActivity(i);
        }
        else {
            Intent i = new Intent(getApplicationContext(), register.class);
            startActivity(i);
        }
    }
}
