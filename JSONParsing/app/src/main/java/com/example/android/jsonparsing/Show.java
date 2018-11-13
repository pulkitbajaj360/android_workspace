package com.example.android.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Show extends AppCompatActivity {
    private String path = "http://byte100.com/nidhi/showUsers.php";
    private UserCustomAdaptor adaptor;
    private RecyclerView rv;
    private List<User> list;
    private ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        bar = new ProgressBar(this);


        StringRequest request = new StringRequest(Request.Method.GET, path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);

                    JSONArray arr = obj.getJSONArray("users");

                    for (int i = 0; i < arr.length(); i++) {
                        //getting the json object of the particular index inside the array
                        JSONObject user = arr.getJSONObject(i);

                        //creating a hero object and giving them the values from json object
                        User u = new User();
                        u.setImgUrl("http://byte100.com/nidhi/"+user.getString("user_image"));
                        u.setName(user.getString("name"));
                        u.setEmail(user.getString("email"));
                        u.setServiceType(user.getString("service_title"));
                        u.setServiceDetail(user.getString("service_detail"));
                        list.add(u);
                    }
                    Toast.makeText(Show.this, "Total Users: "+list.size(), Toast.LENGTH_SHORT).show();
                    adaptor = new UserCustomAdaptor(list,Show.this);
                    rv.setAdapter(adaptor);

                }catch (Exception e){
                    Log.i("Exception:  ",""+e);
                    Toast.makeText(Show.this, ""+e, Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Show.this, "VolleyError "+error, Toast.LENGTH_SHORT).show();
            }
        } )
        ;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);



    }



}

