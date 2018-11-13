package com.example.android.sharedpreference;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    private Button bt;
    private TextInputEditText name,email,password,mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.etName);
        email=findViewById(R.id.etEmail);
        password=findViewById(R.id.etPassword);
        mobile=findViewById(R.id.etMobile);
        bt=findViewById(R.id.regButton);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                boolean status = PreferenceManager.register(name.getText().toString(),email.getText().toString(),password.getText().toString(),mobile.getText().toString());
                if (status ){
                    Intent i = new Intent(getApplicationContext(), login.class);
                    startActivity(i);
                }else{
                    Toast.makeText(register.this, "Registrations failed", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), register.class);
                    startActivity(i);
                }
            }
        });
    }
}
