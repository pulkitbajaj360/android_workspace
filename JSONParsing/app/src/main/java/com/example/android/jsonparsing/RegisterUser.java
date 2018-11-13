package com.example.android.jsonparsing;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.util.HashMap;
import java.util.Map;

public class RegisterUser extends AppCompatActivity {
Button submit;
EditText name,email,title,detail;
DataBaseManager dataBaseManager;

private String path = "http://10.0.0.13:8080/android/addprocess.jsp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        submit=findViewById(R.id.submit);

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        title=findViewById(R.id.title);
        detail=findViewById(R.id.detail);

        dataBaseManager=new DataBaseManager();



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                StringRequest request = new StringRequest(Request.Method.POST, path, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(RegisterUser.this, ""+response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegisterUser.this, "VolleyError "+error, Toast.LENGTH_SHORT).show();
                    }
                } ){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> hm = new HashMap<>();
                        hm.put("image","images/amit.jpg");
                        hm.put("name",name.getText().toString());
                        hm.put("email",email.getText().toString());
                        hm.put("title",title.getText().toString());
                        hm.put("detail","Pizza");
                        return hm;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(RegisterUser.this);
                requestQueue.add(request);








               /* if(dataBaseManager.addUser(name.getText().toString(),email.getText().toString(),password.getText().toString(),mobile.getText().toString())){
                    Toast.makeText(RegisterUser.this, "Registration Succesful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), Login.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(RegisterUser.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), RegisterUser.class);
                    startActivity(i);
                }*/

            }
        });
    }
}
