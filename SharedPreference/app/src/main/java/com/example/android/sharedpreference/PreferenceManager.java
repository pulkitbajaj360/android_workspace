package com.example.android.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class PreferenceManager {

    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;



    PreferenceManager(Context context){
        preferences = context.getSharedPreferences("user",Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.apply();
    }


    protected boolean isExistingUser(){

        return preferences.getBoolean("user",false);
    }


    public static boolean register(String username,String email,String password, String mobile)  {

        editor.putBoolean("user",true);
        editor.putString("name",username);
        editor.putString("email",email);
        editor.putString("pass",password);
        editor.putString("mobile",mobile);


        return editor.commit();
    }

    public static boolean validateUser(String email,String pass) {
        String id = preferences.getString("email",null);
        String ps = preferences.getString("pass",null);

        if(id.equals(email) && pass.equals(ps)){
            return true;
        }else
            return false;

    }


    public static List<String> getRecord(){
        List<String> list = new ArrayList<>();
        list.add(preferences.getString("name",null));
        list.add(preferences.getString("email",null));
        list.add(preferences.getString("pass",null));
        list.add(preferences.getString("mobile",null));
        return list;
    }
}
