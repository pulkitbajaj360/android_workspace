package com.example.android.tutorialsandexample;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText editText;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");

        editText=findViewById(R.id.editText);

       button=findViewById(R.id.show);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Time dv=new Time();

               String time=new String();
               time="";
               time=dv.getHourOfDay()+":"+dv.getMinute();
                       editText.setText(time);
           }
       });
    }
}
