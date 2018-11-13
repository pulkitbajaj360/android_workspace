package com.example.android.jsonparsing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
EditText email,pass;
DataBaseManager dataBaseManager;
Button loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        loginbtn=findViewById(R.id.login);
        dataBaseManager=new DataBaseManager();


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailid=email.getText().toString();
                String password=pass.getText().toString();
                if(dataBaseManager.validateUser(emailid,password)){
                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), Welcome.class);
                    startActivity(i);
                }

                else{
                    Toast.makeText(Login.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
