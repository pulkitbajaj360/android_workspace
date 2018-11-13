package com.example.android.ludo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Intent ludoBoard;
    Spinner spinner;
    int playersSelected;
    EditText et1,et2,et3,et4;
    Button submit;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ludoBoard=new Intent(this,Ludo_board.class);

        spinner=findViewById(R.id.spinner);
        et1=findViewById(R.id.playerNameFirst);
        et2=findViewById(R.id.playerNameSecond);
        et3=findViewById(R.id.playerNameThird);
        et4=findViewById(R.id.playerNameForth);

        et1.setVisibility(View.INVISIBLE);
        et2.setVisibility(View.INVISIBLE);
        et3.setVisibility(View.INVISIBLE);
        et4.setVisibility(View.INVISIBLE);


        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitClickListner();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                playersSelected=position;
                if(playersSelected>0)
                submitClickListner();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                playersSelected=0;
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void submitClickListner(){
        if(playersSelected>0&&playersSelected==count){
            Player1.setName(et1.getText().toString());
            if (playersSelected==1){
                Player2.setName("Computer");
                Player1.setPlayers(playersSelected);
            }
            else {
                Player2.setName(et2.getText().toString());

            }
            Player1.setFlag(true);
            Player2.setFlag(playersSelected>=2);
            Player3.setFlag(playersSelected>=3);
            Player4.setFlag(playersSelected>=4);
            Player1.setPlayers(playersSelected);
            Player3.setName(et3.getText().toString());
            Player4.setName(et4.getText().toString());
            startActivity(ludoBoard);
        }

        if(playersSelected>count){
            switch (count){
                case 0: et1.setVisibility(View.VISIBLE);
                    spinner.setVisibility(View.INVISIBLE);
                    count++;
                    break;
                case 1: et1.setVisibility(View.INVISIBLE);
                    et2.setVisibility(View.VISIBLE);
                    count++;
                    break;
                case 2: et2.setVisibility(View.INVISIBLE);
                    et3.setVisibility(View.VISIBLE);
                    count++;
                    break;
                case 3:et3.setVisibility(View.INVISIBLE);
                    et4.setVisibility(View.VISIBLE);
                    count++;
                    break;
            }
        }
    }
}
