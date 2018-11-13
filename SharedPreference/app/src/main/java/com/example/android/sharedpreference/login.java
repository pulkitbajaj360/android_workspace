package com.example.android.sharedpreference;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class login extends AppCompatActivity {

    TextInputEditText email,password;
    PreferenceManager pm;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        btn=findViewById(R.id.button);

       pm=new PreferenceManager(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(  pm.validateUser(email.getText().toString(),password.getText().toString())) {
                    Intent i = new Intent(getApplicationContext(), welcome.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(login.this, "Wrong password", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), login.class);
                    startActivity(i);
                }
            }
        });

    }
}
