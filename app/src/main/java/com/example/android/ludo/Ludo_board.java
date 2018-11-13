package com.example.android.ludo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Ludo_board extends AppCompatActivity {
   static Handler handler;
    Random random;
    ImageView img1,img2,img3,img4,img5;
    ImageView img6,img7,img8,img9,img10;
    ImageView img11,img12,img13,img14,img15;
    ImageView img16,img17,img18,img19,img20;
    ImageView img21,img22,img23,img24,img25;
    ImageView img26,img27,img28,img29,img30;
    ImageView img31,img32,img33,img34,img35,img36;
    ImageView img37,img38,img39,img40,img41,img42,img43,img44,img45,img46,img47,img48,img49,img50,img51,img52;
   static ImageView greenHomeImage,yellowHomeImage,redHomeImage,blueHomeImage;
    int num=0;
    UpdateDiceThread updateDiceThread;
    UpdateTextThread updateTextThread;
    UpdateHomesThread updateHomesThread;
    CheckWinAndCompleteThread checkWinAndCompleteThread;

  static   ImageButton blueButton,yellowButton,redButton,greenButton;
    ImageView red1,red2,red3,red4,red5,yellow1,yellow2,yellow3,yellow4,yellow5,green1,green2,green3,green4,green5,blue1,blue2,blue3,blue4,blue5;
    int i,j,k;
    int w;
    public static int tokenMatrix[][]=new int[4][4];
   static TextView greenWins,greenComplete,yellowWins,yellowComplete,redWins,redComplete,blueWins,blueComplete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ludo_board);
        initialiseFields();
        initialisePlayers();//Strictly after initialising the fields
        handler=new Handler(getApplicationContext().getMainLooper());

        nextTurn();// next turn called in the starting of the game

        for (i=0;i<4;i++){
            for (j=0;j<4;j++){
                tokenMatrix[i][j]=0;
            }
        }

        updateDiceThread=new UpdateDiceThread();
        new Thread(updateDiceThread).start();


        updateTextThread=new UpdateTextThread();
        new Thread(updateTextThread).start();

        updateHomesThread=new UpdateHomesThread();
        new Thread(updateHomesThread).start();


        checkWinAndCompleteThread=new CheckWinAndCompleteThread();
        new Thread(checkWinAndCompleteThread).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    for (w=0;w<4;w++){
                        if (CheckWinAndCompleteThread.complete[w]==4){
                            switch ((w+1)){
                                case 1:
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(Ludo_board.this, Player1.getName()+" Won", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                    break;
                                case 2:
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(Ludo_board.this, Player2.getName()+" Won", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                    break;
                                case 3:
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(Ludo_board.this, Player3.getName()+" Won", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                    break;
                                case 4:
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(Ludo_board.this, Player4.getName()+" Won", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                    break;
                            }
                        }
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {//Thread for checking token update
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (tokenMatrix[0][0]!=Player1.getToken1()){
                        tokenMatrix[0][0]=Player1.getToken1();
                        Mapper.setTokenMatrix(tokenMatrix);
                        affectOnMove(1,1);
                        tokenChangeListner();
                    }
                    else if (tokenMatrix[0][1]!=Player1.getToken2()){
                        tokenMatrix[0][1]=Player1.getToken2();
                        Mapper.setTokenMatrix(tokenMatrix);
                        affectOnMove(1,2);
                        tokenChangeListner();
                    }
                    else if (tokenMatrix[0][2]!=Player1.getToken3()){
                        tokenMatrix[0][2]=Player1.getToken3();
                        Mapper.setTokenMatrix(tokenMatrix);
                        affectOnMove(1,3);
                        tokenChangeListner();
                    }
                    else if (tokenMatrix[0][3]!=Player1.getToken4()){
                        tokenMatrix[0][3]=Player1.getToken4();
                        Mapper.setTokenMatrix(tokenMatrix);
                        affectOnMove(1,4);
                        tokenChangeListner();
                    }
                    else if (tokenMatrix[1][0]!=Player2.getToken1()){
                        tokenMatrix[1][0]=Player2.getToken1();
                        Mapper.setTokenMatrix(tokenMatrix);
                        affectOnMove(2,1);
                        tokenChangeListner();
                    }
                    else if (tokenMatrix[1][1]!=Player2.getToken2()){
                        tokenMatrix[1][1]=Player2.getToken2();
                        Mapper.setTokenMatrix(tokenMatrix);
                        affectOnMove(2,2);
                        tokenChangeListner();
                    }
                    else if (tokenMatrix[1][2]!=Player2.getToken3()){
                        tokenMatrix[1][2]=Player2.getToken3();
                        Mapper.setTokenMatrix(tokenMatrix);
                        affectOnMove(2,3);
                        tokenChangeListner();
                    }
                    else if (tokenMatrix[1][3]!=Player2.getToken4()){
                        tokenMatrix[1][3]=Player2.getToken4();
                        Mapper.setTokenMatrix(tokenMatrix);
                        affectOnMove(2,4);
                        tokenChangeListner();
                    }
                    else if (tokenMatrix[2][0]!=Player3.getToken1()){
                        tokenMatrix[2][0]=Player3.getToken1();
                        Mapper.setTokenMatrix(tokenMatrix);
                        affectOnMove(3,1);
                        tokenChangeListner();
                    }
                    else if (tokenMatrix[2][1]!=Player3.getToken2()){
                        tokenMatrix[2][1]=Player3.getToken2();
                        Mapper.setTokenMatrix(tokenMatrix);
                        affectOnMove(3,2);
                        tokenChangeListner();
                    }
                    else if (tokenMatrix[2][2]!=Player3.getToken3()){
                        tokenMatrix[2][2]=Player3.getToken3();
                        Mapper.setTokenMatrix(tokenMatrix);
                        affectOnMove(3,3);
                        tokenChangeListner();
                    }
                    else if (tokenMatrix[2][3]!=Player3.getToken4()){
                        tokenMatrix[2][3]=Player3.getToken4();
                        Mapper.setTokenMatrix(tokenMatrix);
                        affectOnMove(3,4);
                        tokenChangeListner();
                    }
                    else if (tokenMatrix[3][0]!=Player4.getToken1()){
                        tokenMatrix[3][0]=Player4.getToken1();
                        Mapper.setTokenMatrix(tokenMatrix);
                        affectOnMove(4,1);
                        tokenChangeListner();
                    }
                    else if (tokenMatrix[3][1]!=Player4.getToken2()){
                        tokenMatrix[3][1]=Player4.getToken2();
                        Mapper.setTokenMatrix(tokenMatrix);
                        affectOnMove(4,2);
                        tokenChangeListner();
                    }
                    else if (tokenMatrix[3][2]!=Player4.getToken3()){
                        tokenMatrix[3][2]=Player4.getToken3();
                        Mapper.setTokenMatrix(tokenMatrix);
                        affectOnMove(4,3);
                        tokenChangeListner();
                    }
                    else if (tokenMatrix[3][3]!=Player4.getToken4()){
                        tokenMatrix[3][3]=Player4.getToken4();
                        Mapper.setTokenMatrix(tokenMatrix);
                        affectOnMove(4,4);
                        tokenChangeListner();
                    }
                }


            }
        }).start();


        //Debugging Thread
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                num=0;
                for (num=0;num<=57;num++){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Player1.setToken1(num);
                    Player2.setToken1(num);
                    Player3.setToken1(num);
                    Player4.setToken1(num);
                }
                for (num=0;num<=57;num++){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Player1.setToken2(num);
                    Player2.setToken2(num);
                    Player3.setToken2(num);
                    Player4.setToken2(num);
                }
                for (num=0;num<=57;num++){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Player1.setToken3(num);
                    Player2.setToken3(num);
                    Player3.setToken3(num);
                    Player4.setToken3(num);
                }
                for (num=0;num<=57;num++){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Player1.setToken4(num);
                    Player2.setToken4(num);
                    Player3.setToken4(num);
                    Player4.setToken4(num);
                }

            }
        }).start();*/



        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(1);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(2);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(3);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(4);
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(5);
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(6);
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(7);
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(8);
            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(9);
            }
        });
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(10);
            }
        });
        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(11);
            }
        });
        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(12);
            }
        });
        img13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(13);
            }
        });
        img14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(14);
            }
        });
        img15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(15);
            }
        });
        img16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(16);
            }
        });
        img17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(17);
            }
        });
        img18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(18);
            }
        });
        img19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(19);
            }
        });
        img20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(20);
            }
        });
        img21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(21);
            }
        });
        img22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(22);
            }
        });
        img23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(23);
            }
        });
        img24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(24);
            }
        });
        img25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(25);
            }
        });
        img26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(26);
            }
        });
        img27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(27);
            }
        });
        img28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(28);
            }
        });
        img29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(29);
            }
        });
        img30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(30);
            }
        });
        img31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(31);
            }
        });
        img32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(32);
            }
        });
        img33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(33);
            }
        });
        img34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(34);
            }
        });
        img35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(35);
            }
        });
        img36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(36);
            }
        });
        img37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(37);
            }
        });
        img38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(38);
            }
        });
        img39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(39);
            }
        });
        img40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(40);
            }
        });
        img41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(41);
            }
        });
        img42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(42);
            }
        });
        img43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(43);
            }
        });
        img44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(44);
            }
        });
        img45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(45);
            }
        });
        img46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(46);
            }
        });
        img47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(47);
            }
        });
        img48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(48);
            }
        });
        img49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(49);
            }
        });
        img50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(50);
            }
        });
        img51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(51);
            }
        });
        img52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageClickListner(52);
            }
        });

        green1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                greenImageClickListener(-1);
            }
        });
        green2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                greenImageClickListener(-2);
            }
        });
        green3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                greenImageClickListener(-3);
            }
        });
        green4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                greenImageClickListener(-4);
            }
        });
        green5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                greenImageClickListener(-5);
            }
        });

        yellow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yellowImageClickListener(-1);
            }
        });
        yellow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yellowImageClickListener(-2);
            }
        });
        yellow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yellowImageClickListener(-3);
            }
        });
        yellow4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yellowImageClickListener(-4);
            }
        });
        yellow5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yellowImageClickListener(-5);
            }
        });
        blue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blueImageClickListener(-1);
            }
        });
        blue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blueImageClickListener(-2);
            }
        });
        blue3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blueImageClickListener(-3);
            }
        });
        blue4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blueImageClickListener(-4);
            }
        });
        blue5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blueImageClickListener(-5);
            }
        });
        red1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redImageClickListener(-1);
            }
        });
        red2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redImageClickListener(-2);
            }
        });
        red3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redImageClickListener(-3);
            }
        });
        red4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redImageClickListener(-4);
            }
        });
        red5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redImageClickListener(-5);
            }
        });


        random= new Random();

        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Player3.setMoves(random.nextInt(6)+1);
                blueButton.setClickable(false);
                if (hasNoOption(3)){
                    nextTurn();
                }
                else {
                    Toast.makeText(Ludo_board.this, Player3.getName()+" has "+Player3.getMoves()+" moves", Toast.LENGTH_SHORT).show();
                }
                }
        });

        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Player1.setMoves(random.nextInt(6)+1);
                greenButton.setClickable(false);
                if (hasNoOption(1)){
                    nextTurn();
                }
                else {
                    Toast.makeText(Ludo_board.this, Player1.getName()+" has "+Player1.getMoves()+" moves", Toast.LENGTH_SHORT).show();
                }
            }
        });

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Player4.setMoves(random.nextInt(6)+1);
                redButton.setClickable(false);
                if (hasNoOption(4)){
                    nextTurn();
                }
                else {
                    Toast.makeText(Ludo_board.this, Player4.getName()+" has "+Player4.getMoves()+" moves", Toast.LENGTH_SHORT).show();
                }
            }
        });

        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Player2.setMoves(random.nextInt(6)+1);
                yellowButton.setClickable(false);
                if (hasNoOption(2)){
                    nextTurn();
                }
                else {
                    Toast.makeText(Ludo_board.this, Player2.getName()+" has "+Player2.getMoves()+" moves", Toast.LENGTH_SHORT).show();
                }

            }
        });

        greenHomeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Player1.getMoves()==6&&Player1.getHome()>0){
                    if(Player1.getToken1()==0){
                        Player1.setToken1(1);
                    }
                    else if(Player1.getToken2()==0){
                        Player1.setToken2(1);
                    }
                    else if(Player1.getToken3()==0){
                        Player1.setToken3(1);
                    }
                    else if(Player1.getToken4()==0){
                        Player1.setToken4(1);
                    }
                    nextTurn();
                }
            }
        });

        //Inside onCreate method
        //Inside MainActivity class

        yellowHomeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Player2.getMoves()==6&&Player2.getHome()>0){
                    if(Player2.getToken1()==0){
                        Player2.setToken1(1);
                    }
                    else if(Player2.getToken2()==0){
                        Player2.setToken2(1);
                    }
                    else if(Player2.getToken3()==0){
                        Player2.setToken3(1);
                    }
                    else if(Player2.getToken4()==0){
                        Player2.setToken4(1);
                    }
                    nextTurn();
                }

            }
        });

        //Inside onCreate method
        //Inside MainActivity class

        blueHomeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Player3.getMoves()==6&&Player3.getHome()>0){
                    if(Player3.getToken1()==0){
                        Player3.setToken1(1);
                    }
                    else if(Player3.getToken2()==0){
                        Player3.setToken2(1);
                    }
                    else if(Player3.getToken3()==0){
                        Player3.setToken3(1);
                    }
                    else if(Player3.getToken4()==0){
                        Player3.setToken4(1);
                    }
                    nextTurn();
                }

            }
        });

        //Inside onCreate method
        //Inside MainActivity class

        redHomeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Player4.getMoves()==6&&Player4.getHome()>0){
                    if(Player4.getToken1()==0){
                        Player4.setToken1(1);
                    }
                    else if(Player4.getToken2()==0){
                        Player4.setToken2(1);
                    }
                    else if(Player4.getToken3()==0){
                        Player4.setToken3(1);
                    }
                    else if(Player4.getToken4()==0){
                        Player4.setToken4(1);
                    }
                    nextTurn();
                }

            }
        });

    }

    public static void setHomes(){
        switch (Player1.getHome()){
            case 0:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        greenHomeImage.setBackgroundResource(R.drawable.greenhome);
                    }
                });

                break;
            case 1:
                handler.post(new Runnable() {
                @Override
                public void run() {
                    greenHomeImage.setBackgroundResource(R.drawable.greenhome1);
                }
            });

            break;

            case 2:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        greenHomeImage.setBackgroundResource(R.drawable.greenhome2);
                    }
                });
            break;

            case 3:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        greenHomeImage.setBackgroundResource(R.drawable.greenhome3);
                    }
                });
            break;

            case 4:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        greenHomeImage.setBackgroundResource(R.drawable.greenhome4);
                    }
                });
            break;
        }

        switch (Player2.getHome()){
            case 0:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        yellowHomeImage.setBackgroundResource(R.drawable.yellowhome);
                    }
                });
                break;
            case 1:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        yellowHomeImage.setBackgroundResource(R.drawable.yellowhome1);
                    }
                });
                break;

            case 2:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        yellowHomeImage.setBackgroundResource(R.drawable.yellowhome2);
                    }
                });
                break;

            case 3:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        yellowHomeImage.setBackgroundResource(R.drawable.yellowhome3);
                    }
                });
                break;

            case 4:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        yellowHomeImage.setBackgroundResource(R.drawable.yellowhome4);
                    }
                });
                break;
        }

        switch (Player4.getHome()){
            case 0:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        redHomeImage.setBackgroundResource(R.drawable.redhome);
                    }
                });
                break;
            case 1:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        redHomeImage.setBackgroundResource(R.drawable.redhome1);
                    }
                });
                break;

            case 2:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        redHomeImage.setBackgroundResource(R.drawable.redhome2);
                    }
                });
                break;

            case 3:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        redHomeImage.setBackgroundResource(R.drawable.redhome3);
                    }
                });
                break;

            case 4:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        redHomeImage.setBackgroundResource(R.drawable.redhome4);
                    }
                });
                break;
        }

        switch (Player3.getHome()){
            case 0:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        blueHomeImage.setBackgroundResource(R.drawable.bluehome);
                    }
                });
                break;
            case 1:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        blueHomeImage.setBackgroundResource(R.drawable.bluehome1);
                    }
                });
                break;

            case 2:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        blueHomeImage.setBackgroundResource(R.drawable.bluehome2);
                    }
                });
                break;

            case 3:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        blueHomeImage.setBackgroundResource(R.drawable.bluehome3);
                    }
                });
                break;

            case 4:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        blueHomeImage.setBackgroundResource(R.drawable.bluehome4);
                    }
                });
                break;
        }
    }




    int turncount=0;
    public void nextTurn(){
        Player1.setMoves(0);
        Player2.setMoves(0);
        Player3.setMoves(0);
        Player4.setMoves(0);

        if(Player1.getPlayers()>turncount){
            turncount++;
            switch (turncount){
                case 1:
                    Player1.setTurn(true);
                    greenButton.setClickable(true);
                    Player2.setTurn(false);
                    Player3.setTurn(false);
                    Player4.setTurn(false);
                    break;
                case 2:
                    Player1.setTurn(false);
                    Player2.setTurn(true);
                    yellowButton.setClickable(true);
                    Player3.setTurn(false);
                    Player4.setTurn(false);
                    break;
                case 3:
                    Player1.setTurn(false);
                    Player2.setTurn(false);
                    Player3.setTurn(true);
                    blueButton.setClickable(true);
                    Player4.setTurn(false);
                    break;
                case 4:
                    Player1.setTurn(false);
                    Player2.setTurn(false);
                    Player3.setTurn(false);
                    Player4.setTurn(true);
                    redButton.setClickable(true);
                    break;
            }
        }
        else if(Player1.getPlayers()==1){
           // counputerTurn();
            turncount=0;
            nextTurn();
        }
        else {
            turncount=0;
            nextTurn();
        }
    }

    public static void visible(int player){
        switch (player){
            case 1:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        greenButton.setVisibility(View.VISIBLE);
                        yellowButton.setVisibility(View.INVISIBLE);
                        redButton.setVisibility(View.INVISIBLE);
                        blueButton.setVisibility(View.INVISIBLE);
                    }
                });

                break;
            case 2:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        greenButton.setVisibility(View.INVISIBLE);
                        yellowButton.setVisibility(View.VISIBLE);
                        redButton.setVisibility(View.INVISIBLE);
                        blueButton.setVisibility(View.INVISIBLE);
                    }
                });

                break;
            case 3:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        greenButton.setVisibility(View.INVISIBLE);
                        yellowButton.setVisibility(View.INVISIBLE);
                        redButton.setVisibility(View.INVISIBLE);
                        blueButton.setVisibility(View.VISIBLE);
                    }
                });

                break;
            case 4:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        greenButton.setVisibility(View.INVISIBLE);
                        yellowButton.setVisibility(View.INVISIBLE);
                        redButton.setVisibility(View.VISIBLE);
                        blueButton.setVisibility(View.INVISIBLE);
                    }
                });
                break;
        }
    }

    public void initialisePlayers(){
        if (Player1.getPlayers()==2){
            Player1.setFlag(true);
            Player2.setFlag(true);
            redWins.setVisibility(View.INVISIBLE);
            redComplete.setVisibility(View.INVISIBLE);
            blueWins.setVisibility(View.INVISIBLE);
            blueComplete.setVisibility(View.INVISIBLE);
        }
        else if(Player1.getPlayers()==3){
            Player1.setFlag(true);
            Player2.setFlag(true);
            Player3.setFlag(true);
            redWins.setVisibility(View.INVISIBLE);
            redComplete.setVisibility(View.INVISIBLE);
        }
        else if(Player1.getPlayers()==4){
            Player1.setFlag(true);
            Player2.setFlag(true);
            Player3.setFlag(true);
            Player4.setFlag(true);
        }

    }

    public void initialiseFields(){
        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);
        img4=findViewById(R.id.img4);
        img5=findViewById(R.id.img5);
        img6=findViewById(R.id.img6);
        img7=findViewById(R.id.img7);
        img8=findViewById(R.id.img8);
        img9=findViewById(R.id.img9);
        img10=findViewById(R.id.img10);
        img11=findViewById(R.id.img11);
        img12=findViewById(R.id.img12);
        img13=findViewById(R.id.img13);
        img14=findViewById(R.id.img14);
        img15=findViewById(R.id.img15);
        img16=findViewById(R.id.img16);
        img17=findViewById(R.id.img17);
        img18=findViewById(R.id.img18);
        img19=findViewById(R.id.img19);
        img20=findViewById(R.id.img20);
        img21=findViewById(R.id.img21);
        img22=findViewById(R.id.img22);
        img23=findViewById(R.id.img23);
        img24=findViewById(R.id.img24);
        img25=findViewById(R.id.img25);
        img26=findViewById(R.id.img26);
        img27=findViewById(R.id.img27);
        img28=findViewById(R.id.img28);
        img29=findViewById(R.id.img29);
        img30=findViewById(R.id.img30);
        img31=findViewById(R.id.img31);
        img32=findViewById(R.id.img32);
        img33=findViewById(R.id.img33);
        img34=findViewById(R.id.img34);
        img35=findViewById(R.id.img35);
        img36=findViewById(R.id.img36);
        img37=findViewById(R.id.img37);
        img38=findViewById(R.id.img38);
        img39=findViewById(R.id.img39);
        img40=findViewById(R.id.img40);
        img41=findViewById(R.id.img41);
        img42=findViewById(R.id.img42);
        img43=findViewById(R.id.img43);
        img44=findViewById(R.id.img44);
        img45=findViewById(R.id.img45);
        img46=findViewById(R.id.img46);
        img47=findViewById(R.id.img47);
        img48=findViewById(R.id.img48);
        img49=findViewById(R.id.img49);
        img50=findViewById(R.id.img50);
        img51=findViewById(R.id.img51);
        img52=findViewById(R.id.img52);

        greenHomeImage=findViewById(R.id.greenHome);
        yellowHomeImage=findViewById(R.id.yellowHome);
        redHomeImage=findViewById(R.id.redHome);
        blueHomeImage=findViewById(R.id.blueHome);

        greenButton=findViewById(R.id.greenButton);
        yellowButton=findViewById(R.id.yellowButton);
        redButton=findViewById(R.id.redButton);
        blueButton=findViewById(R.id.blueButton);

        greenWins=findViewById(R.id.greenWins);
        greenComplete=findViewById(R.id.greenComplete);

        yellowWins=findViewById(R.id.yellowWins);
        yellowComplete=findViewById(R.id.yellowComplete);

        redWins=findViewById(R.id.redWins);
        redComplete=findViewById(R.id.redComplete);

        blueWins=findViewById(R.id.blueWins);
        blueComplete=findViewById(R.id.blueComplete);

        green1=findViewById(R.id.green1);
        green2=findViewById(R.id.green2);
        green3=findViewById(R.id.green3);
        green4=findViewById(R.id.green4);
        green5=findViewById(R.id.green5);

        yellow1=findViewById(R.id.yellow1);
        yellow2=findViewById(R.id.yellow2);
        yellow3=findViewById(R.id.yellow3);
        yellow4=findViewById(R.id.yellow4);
        yellow5=findViewById(R.id.yellow5);

        red1=findViewById(R.id.red1);
        red2=findViewById(R.id.red2);
        red3=findViewById(R.id.red3);
        red4=findViewById(R.id.red4);
        red5=findViewById(R.id.red5);

        blue1=findViewById(R.id.blue1);
        blue2=findViewById(R.id.blue2);
        blue3=findViewById(R.id.blue3);
        blue4=findViewById(R.id.blue4);
        blue5=findViewById(R.id.blue5);

    }

    public  void setcolor(int position,int color,int numberOftokens){
        switch (position){
            case -1:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 0:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green1.setBackgroundResource(R.drawable.fgreen);
                                }
                            });
                            break;
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green1.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green1.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green1.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green1.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 0:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow1.setBackgroundResource(R.drawable.fyellow);
                                }
                            });
                            break;
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow1.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow1.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow1.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow1.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 0:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red1.setBackgroundResource(R.drawable.fred);
                                }
                            });
                            break;
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red1.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red1.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red1.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red1.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 0:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue1.setBackgroundResource(R.drawable.fblue);
                                }
                            });
                            break;
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue1.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue1.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue1.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue1.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
            }
                break;
            case -2:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 0:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green2.setBackgroundResource(R.drawable.fgreen);
                                }
                            });
                            break;
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green2.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green2.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green2.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green2.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 0:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow2.setBackgroundResource(R.drawable.fyellow);
                                }
                            });
                            break;
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow2.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow2.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow2.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow2.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 0:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red2.setBackgroundResource(R.drawable.fred);
                                }
                            });
                            break;
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red2.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red2.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red2.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red2.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 0:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue2.setBackgroundResource(R.drawable.fblue);
                                }
                            });
                            break;
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue2.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue2.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue2.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue2.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
            }
                break;
            case -3:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 0:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green3.setBackgroundResource(R.drawable.fgreen);
                                }
                            });
                            break;
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green3.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green3.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green3.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green3.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 0:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow3.setBackgroundResource(R.drawable.fyellow);
                                }
                            });
                            break;
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow3.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow3.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow3.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow3.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 0:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red3.setBackgroundResource(R.drawable.fred);
                                }
                            });
                            break;
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red3.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red3.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red3.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red3.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 0:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue3.setBackgroundResource(R.drawable.fblue);
                                }
                            });
                            break;
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue3.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue3.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue3.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue3.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
            }
                break;
            case -4:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 0:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green4.setBackgroundResource(R.drawable.fgreen);
                                }
                            });
                            break;
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green4.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green4.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green4.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green4.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 0:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow4.setBackgroundResource(R.drawable.fyellow);
                                }
                            });
                            break;
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow4.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow4.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow4.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow4.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 0:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red4.setBackgroundResource(R.drawable.fred);
                                }
                            });
                            break;
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red4.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red4.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red4.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red4.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 0:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue4.setBackgroundResource(R.drawable.fblue);
                                }
                            });
                            break;
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue4.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue4.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue4.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue4.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
            }
                break;

            case -5:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 0:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green5.setBackgroundResource(R.drawable.fgreen);
                                }
                            });
                            break;
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green5.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green5.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green5.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    green5.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 0:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow5.setBackgroundResource(R.drawable.fyellow);
                                }
                            });
                            break;
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow5.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow5.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow5.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yellow5.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 0:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red5.setBackgroundResource(R.drawable.fred);
                                }
                            });
                            break;
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red5.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red5.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red5.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    red5.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 0:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue5.setBackgroundResource(R.drawable.fblue);
                                }
                            });
                            break;
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue5.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue5.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue5.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    blue5.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
            }
            break;
            case 0:break;
            case 1:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img1.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img1.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img1.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img1.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img1.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img1.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img1.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img1.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img1.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img1.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img1.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img1.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img1.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img1.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img1.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img1.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img1.setBackgroundResource(R.drawable.fwhite);                        }
                    });
                    break;
            }
                break;
            case 2:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img2.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img2.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img2.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img2.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img2.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img2.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img2.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img2.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img2.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img2.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img2.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img2.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img2.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img2.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img2.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img2.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img2.setBackgroundResource(R.drawable.fwhite);                        }
                    });
                    break;
            }
                break;
            case 3:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img3.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img3.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img3.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img3.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img3.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img3.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img3.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img3.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img3.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img3.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img3.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img3.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img3.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img3.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img3.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img3.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img3.setBackgroundResource(R.drawable.fwhite);                        }
                    });
                    break;
            }
                break;
            case 4:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img4.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img4.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img4.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img4.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img4.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img4.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img4.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img4.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img4.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img4.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img4.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img4.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img4.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img4.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img4.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img4.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img4.setBackgroundResource(R.drawable.fwhite);                        }
                    });
                    break;

            }
                break;
            case 5:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img5.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img5.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img5.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img5.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img5.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img5.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img5.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img5.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img5.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img5.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img5.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img5.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img5.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img5.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img5.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img5.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img5.setBackgroundResource(R.drawable.fwhite);                        }
                    });
                    break;
            }
                break;
            case 6:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img6.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img6.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img6.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img6.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img6.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img6.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img6.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img6.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img6.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img6.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img6.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img6.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img6.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img6.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img6.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img6.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img6.setBackgroundResource(R.drawable.fwhite);                        }
                    });
                    break;
            }
                break;
            case 7:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img7.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img7.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img7.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img7.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img7.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img7.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img7.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img7.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img7.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img7.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img7.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img7.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img7.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img7.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {

                                }
                            });
                            img7.setBackgroundResource(R.drawable.blue3);
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img7.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img7.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 8:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img8.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img8.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img8.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img8.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img8.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img8.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img8.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img8.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img8.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img8.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img8.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img8.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img8.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img8.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img8.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img8.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img8.setBackgroundResource(R.drawable.fwhite);                        }
                    });
                    break;
            }
                break;
            case 9:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img9.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img9.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img9.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img9.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img9.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img9.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img9.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img9.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img9.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img9.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img9.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img9.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img9.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img9.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img9.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img9.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img9.setBackgroundResource(R.drawable.fyellow);                        }
                    });
                    break;
            }
                break;
            case 10:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img10.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img10.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img10.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img10.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img10.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img10.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img10.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img10.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img10.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img10.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img10.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img10.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img10.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img10.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img10.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img10.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img10.setBackgroundResource(R.drawable.fwhite);                        }
                    });
                    break;
            }
                break;
            case 11:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img11.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img11.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img11.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img11.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img11.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img11.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img11.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img11.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img11.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img11.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img11.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img11.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img11.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img11.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img11.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img11.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img11.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 12:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img12.setBackgroundResource(R.drawable.green);
                                }
                            });

                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img12.setBackgroundResource(R.drawable.green2);
                                }
                            });

                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img12.setBackgroundResource(R.drawable.green3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img12.setBackgroundResource(R.drawable.green4);
                                }
                            });

                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img12.setBackgroundResource(R.drawable.yellow);
                                }
                            });

                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img12.setBackgroundResource(R.drawable.yellow2);
                                }
                            });

                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img12.setBackgroundResource(R.drawable.yellow3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img12.setBackgroundResource(R.drawable.yellow4);
                                }
                            });

                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img12.setBackgroundResource(R.drawable.red);
                                }
                            });

                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img12.setBackgroundResource(R.drawable.red2);
                                }
                            });

                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img12.setBackgroundResource(R.drawable.red3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img12.setBackgroundResource(R.drawable.red4);
                                }
                            });

                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img12.setBackgroundResource(R.drawable.blue);
                                }
                            });

                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img12.setBackgroundResource(R.drawable.blue2);
                                }
                            });

                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img12.setBackgroundResource(R.drawable.blue3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img12.setBackgroundResource(R.drawable.blue4);
                                }
                            });

                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img12.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 13:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img13.setBackgroundResource(R.drawable.green);
                                }
                            });

                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img13.setBackgroundResource(R.drawable.green2);
                                }
                            });

                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img13.setBackgroundResource(R.drawable.green3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img13.setBackgroundResource(R.drawable.green4);
                                }
                            });

                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img13.setBackgroundResource(R.drawable.yellow);
                                }
                            });

                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img13.setBackgroundResource(R.drawable.yellow2);
                                }
                            });

                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img13.setBackgroundResource(R.drawable.yellow3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img13.setBackgroundResource(R.drawable.yellow4);
                                }
                            });

                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img13.setBackgroundResource(R.drawable.red);
                                }
                            });

                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img13.setBackgroundResource(R.drawable.red2);
                                }
                            });

                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img13.setBackgroundResource(R.drawable.red3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img13.setBackgroundResource(R.drawable.red4);
                                }
                            });

                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img13.setBackgroundResource(R.drawable.blue);
                                }
                            });

                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img13.setBackgroundResource(R.drawable.blue2);
                                }
                            });

                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img13.setBackgroundResource(R.drawable.blue3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img13.setBackgroundResource(R.drawable.blue4);
                                }
                            });

                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img13.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 14:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img14.setBackgroundResource(R.drawable.green);
                                }
                            });

                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img14.setBackgroundResource(R.drawable.green2);
                                }
                            });

                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img14.setBackgroundResource(R.drawable.green3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img14.setBackgroundResource(R.drawable.green4);
                                }
                            });

                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img14.setBackgroundResource(R.drawable.yellow);
                                }
                            });

                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img14.setBackgroundResource(R.drawable.yellow2);
                                }
                            });

                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img14.setBackgroundResource(R.drawable.yellow3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img14.setBackgroundResource(R.drawable.yellow4);
                                }
                            });

                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img14.setBackgroundResource(R.drawable.red);
                                }
                            });

                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img14.setBackgroundResource(R.drawable.red2);
                                }
                            });

                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img14.setBackgroundResource(R.drawable.red3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img14.setBackgroundResource(R.drawable.red4);
                                }
                            });

                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img14.setBackgroundResource(R.drawable.blue);
                                }
                            });

                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img14.setBackgroundResource(R.drawable.blue2);
                                }
                            });

                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img14.setBackgroundResource(R.drawable.blue3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img14.setBackgroundResource(R.drawable.blue4);
                                }
                            });

                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img14.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 15:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img15.setBackgroundResource(R.drawable.green);
                                }
                            });

                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img15.setBackgroundResource(R.drawable.green2);
                                }
                            });

                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img15.setBackgroundResource(R.drawable.green3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img15.setBackgroundResource(R.drawable.green4);
                                }
                            });

                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img15.setBackgroundResource(R.drawable.yellow);
                                }
                            });

                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img15.setBackgroundResource(R.drawable.yellow2);
                                }
                            });

                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img15.setBackgroundResource(R.drawable.yellow3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img15.setBackgroundResource(R.drawable.yellow4);
                                }
                            });

                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img15.setBackgroundResource(R.drawable.red);
                                }
                            });

                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img15.setBackgroundResource(R.drawable.red2);
                                }
                            });

                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img15.setBackgroundResource(R.drawable.red3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img15.setBackgroundResource(R.drawable.red4);
                                }
                            });

                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img15.setBackgroundResource(R.drawable.blue);
                                }
                            });

                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img15.setBackgroundResource(R.drawable.blue2);
                                }
                            });

                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img15.setBackgroundResource(R.drawable.blue3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img15.setBackgroundResource(R.drawable.blue4);
                                }
                            });

                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img15.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 16:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img16.setBackgroundResource(R.drawable.green);
                                }
                            });

                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img16.setBackgroundResource(R.drawable.green2);
                                }
                            });

                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img16.setBackgroundResource(R.drawable.green3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img16.setBackgroundResource(R.drawable.green4);
                                }
                            });

                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img16.setBackgroundResource(R.drawable.yellow);
                                }
                            });

                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img16.setBackgroundResource(R.drawable.yellow2);
                                }
                            });

                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {

                                }
                            });
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img16.setBackgroundResource(R.drawable.yellow3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img16.setBackgroundResource(R.drawable.yellow4);
                                }
                            });

                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img16.setBackgroundResource(R.drawable.red);
                                }
                            });

                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img16.setBackgroundResource(R.drawable.red2);
                                }
                            });

                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img16.setBackgroundResource(R.drawable.red3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img16.setBackgroundResource(R.drawable.red4);
                                }
                            });

                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img16.setBackgroundResource(R.drawable.blue);
                                }
                            });

                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img16.setBackgroundResource(R.drawable.blue2);
                                }
                            });

                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img16.setBackgroundResource(R.drawable.blue3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img16.setBackgroundResource(R.drawable.blue4);
                                }
                            });

                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img16.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 17:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img17.setBackgroundResource(R.drawable.green);
                                }
                            });

                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img17.setBackgroundResource(R.drawable.green2);
                                }
                            });

                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img17.setBackgroundResource(R.drawable.green3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img17.setBackgroundResource(R.drawable.green4);
                                }
                            });

                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img17.setBackgroundResource(R.drawable.yellow);
                                }
                            });

                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img17.setBackgroundResource(R.drawable.yellow2);
                                }
                            });

                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img17.setBackgroundResource(R.drawable.yellow3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img17.setBackgroundResource(R.drawable.yellow4);
                                }
                            });

                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img17.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img17.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img17.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img17.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img17.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img17.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img17.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img17.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img17.setBackgroundResource(R.drawable.fwhite);                        }
                    });
                    break;
            }
                break;
            case 18:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img18.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img18.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img18.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img18.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img18.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img18.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img18.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img18.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img18.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img18.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img18.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img18.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img18.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img18.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img18.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img18.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img18.setBackgroundResource(R.drawable.fwhite);                        }
                    });
                    break;
            }
                break;
            case 19:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img19.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img19.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img19.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img19.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img19.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img19.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img19.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img19.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img19.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img19.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img19.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img19.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img19.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img19.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img19.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img19.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img19.setBackgroundResource(R.drawable.fwhite);                        }
                    });
                    break;
            }
                break;
            case 20:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img20.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img20.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img20.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img20.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img20.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img20.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img20.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img20.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img20.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img20.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img20.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img20.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img20.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img20.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img20.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img20.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img20.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 21:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img21.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img21.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img21.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img21.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img21.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img21.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img21.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img21.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img21.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img21.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img21.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img21.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img21.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img21.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img21.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img21.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img21.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 22:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img22.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img22.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img22.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img22.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img22.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img22.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img22.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img22.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img22.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img22.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img22.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img22.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img22.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img22.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img22.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img22.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img22.setBackgroundResource(R.drawable.fblue);                        }
                    });
                    break;
            }
                break;
            case 23:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img23.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img23.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img23.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img23.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img23.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img23.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img23.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img23.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img23.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img23.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img23.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img23.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img23.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img23.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img23.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img23.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img23.setBackgroundResource(R.drawable.fwhite);                        }
                    });
                    break;
            }
                break;
            case 24:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img24.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img24.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img24.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img24.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img24.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img24.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img24.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img24.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img24.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img24.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img24.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img24.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img24.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img24.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img24.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img24.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img24.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 25:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img25.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img25.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img25.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img25.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img25.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img25.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img25.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img25.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img25.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img25.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img25.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img25.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img25.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img25.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img25.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img25.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img25.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 26:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img26.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img26.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img26.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img26.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img26.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img26.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img26.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img26.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img26.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img26.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img26.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img26.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img26.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img26.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img26.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img26.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img26.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 27:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img27.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img27.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img27.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img27.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img27.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img27.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img27.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img27.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img27.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img27.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img27.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img27.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img27.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img27.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img27.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img27.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img27.setBackgroundResource(R.drawable.fwhite);                        }
                    });
                    break;
            }
                break;
            case 28:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img28.setBackgroundResource(R.drawable.green);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img28.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img28.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img28.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img28.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img28.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img28.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img28.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img28.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img28.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img28.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img28.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img28.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img28.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img28.setBackgroundResource(R.drawable.blue3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img28.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img28.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 29:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img29.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img29.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img29.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img29.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img29.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img29.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img29.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img29.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img29.setBackgroundResource(R.drawable.red);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img29.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img29.setBackgroundResource(R.drawable.red3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img29.setBackgroundResource(R.drawable.red4);

                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img29.setBackgroundResource(R.drawable.blue);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img29.setBackgroundResource(R.drawable.blue2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img29.setBackgroundResource(R.drawable.blue3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img29.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img29.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 30:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img30.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img30.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img30.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img30.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img30.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img30.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img30.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img30.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img30.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img30.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img30.setBackgroundResource(R.drawable.red3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img30.setBackgroundResource(R.drawable.red4);

                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img30.setBackgroundResource(R.drawable.blue);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img30.setBackgroundResource(R.drawable.blue2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img30.setBackgroundResource(R.drawable.blue3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img30.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img30.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 31:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img31.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img31.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img31.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img31.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img31.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img31.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img31.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img31.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img31.setBackgroundResource(R.drawable.red);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img31.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img31.setBackgroundResource(R.drawable.red3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img31.setBackgroundResource(R.drawable.red4);

                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img31.setBackgroundResource(R.drawable.blue);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img31.setBackgroundResource(R.drawable.blue2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img31.setBackgroundResource(R.drawable.blue3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img31.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img31.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 32:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img32.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img32.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img32.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img32.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img32.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img32.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img32.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img32.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img32.setBackgroundResource(R.drawable.red);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img32.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img32.setBackgroundResource(R.drawable.red3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img32.setBackgroundResource(R.drawable.red4);

                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img32.setBackgroundResource(R.drawable.blue);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img32.setBackgroundResource(R.drawable.blue2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img32.setBackgroundResource(R.drawable.blue3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img32.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img32.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 33:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img33.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img33.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img33.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img33.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img33.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img33.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img33.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img33.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img33.setBackgroundResource(R.drawable.red);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img33.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img33.setBackgroundResource(R.drawable.red3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img33.setBackgroundResource(R.drawable.red4);

                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img33.setBackgroundResource(R.drawable.blue);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img33.setBackgroundResource(R.drawable.blue2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img33.setBackgroundResource(R.drawable.blue3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img33.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img33.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 34:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img34.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img34.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img34.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img34.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img34.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img34.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img34.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img34.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img34.setBackgroundResource(R.drawable.red);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img34.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img34.setBackgroundResource(R.drawable.red3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img34.setBackgroundResource(R.drawable.red4);

                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img34.setBackgroundResource(R.drawable.blue);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img34.setBackgroundResource(R.drawable.blue2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img34.setBackgroundResource(R.drawable.blue3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img34.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img34.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 35:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img35.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img35.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img35.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img35.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img35.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img35.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img35.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img35.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img35.setBackgroundResource(R.drawable.red);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img35.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img35.setBackgroundResource(R.drawable.red3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img35.setBackgroundResource(R.drawable.red4);

                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img35.setBackgroundResource(R.drawable.blue);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img35.setBackgroundResource(R.drawable.blue2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img35.setBackgroundResource(R.drawable.blue3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img35.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img35.setBackgroundResource(R.drawable.fred);
                        }
                    });
                    break;
            }
                break;
            case 36:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img36.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img36.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img36.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img36.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img36.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img36.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img36.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img36.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img36.setBackgroundResource(R.drawable.red);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img36.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img36.setBackgroundResource(R.drawable.red3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img36.setBackgroundResource(R.drawable.red4);

                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img36.setBackgroundResource(R.drawable.blue);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img36.setBackgroundResource(R.drawable.blue2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img36.setBackgroundResource(R.drawable.blue3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img36.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img36.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 37:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img37.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img37.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img37.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img37.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img37.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img37.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img37.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img37.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img37.setBackgroundResource(R.drawable.red);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img37.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img37.setBackgroundResource(R.drawable.red3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img37.setBackgroundResource(R.drawable.red4);

                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img37.setBackgroundResource(R.drawable.blue);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img37.setBackgroundResource(R.drawable.blue2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img37.setBackgroundResource(R.drawable.blue3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img37.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img37.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 38:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img38.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img38.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img38.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img38.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img38.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img38.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img38.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img38.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img38.setBackgroundResource(R.drawable.red);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img38.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img38.setBackgroundResource(R.drawable.red3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img38.setBackgroundResource(R.drawable.red4);

                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img38.setBackgroundResource(R.drawable.blue);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img38.setBackgroundResource(R.drawable.blue2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img38.setBackgroundResource(R.drawable.blue3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img38.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img38.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 39:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img39.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img39.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img39.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img39.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img39.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img39.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img39.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img39.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img39.setBackgroundResource(R.drawable.red);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img39.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img39.setBackgroundResource(R.drawable.red3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img39.setBackgroundResource(R.drawable.red4);

                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img39.setBackgroundResource(R.drawable.blue);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img39.setBackgroundResource(R.drawable.blue2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img39.setBackgroundResource(R.drawable.blue3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img39.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img39.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 40:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img40.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img40.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img40.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img40.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img40.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img40.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img40.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img40.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img40.setBackgroundResource(R.drawable.red);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img40.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img40.setBackgroundResource(R.drawable.red3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img40.setBackgroundResource(R.drawable.red4);

                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img40.setBackgroundResource(R.drawable.blue);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img40.setBackgroundResource(R.drawable.blue2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img40.setBackgroundResource(R.drawable.blue3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img40.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img40.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 41:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img41.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img41.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img41.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img41.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img41.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img41.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img41.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img41.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img41.setBackgroundResource(R.drawable.red);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img41.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img41.setBackgroundResource(R.drawable.red3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img41.setBackgroundResource(R.drawable.red4);

                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img41.setBackgroundResource(R.drawable.blue);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img41.setBackgroundResource(R.drawable.blue2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img41.setBackgroundResource(R.drawable.blue3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img41.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img41.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 42:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img42.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img42.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img42.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img42.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img42.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img42.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img42.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img42.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img42.setBackgroundResource(R.drawable.red);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img42.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img42.setBackgroundResource(R.drawable.red3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img42.setBackgroundResource(R.drawable.red4);

                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img42.setBackgroundResource(R.drawable.blue);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img42.setBackgroundResource(R.drawable.blue2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img42.setBackgroundResource(R.drawable.blue3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img42.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img42.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 43:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img43.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img43.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img43.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img43.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img43.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img43.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img43.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img43.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img43.setBackgroundResource(R.drawable.red);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img43.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img43.setBackgroundResource(R.drawable.red3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img43.setBackgroundResource(R.drawable.red4);

                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img43.setBackgroundResource(R.drawable.blue);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img43.setBackgroundResource(R.drawable.blue2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img43.setBackgroundResource(R.drawable.blue3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img43.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img43.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 44:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img44.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img44.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img44.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img44.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img44.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img44.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img44.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img44.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img44.setBackgroundResource(R.drawable.red);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img44.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img44.setBackgroundResource(R.drawable.red3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img44.setBackgroundResource(R.drawable.red4);

                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img44.setBackgroundResource(R.drawable.blue);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img44.setBackgroundResource(R.drawable.blue2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img44.setBackgroundResource(R.drawable.blue3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img44.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img44.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 45:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img45.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img45.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img45.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img45.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img45.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img45.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img45.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img45.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img45.setBackgroundResource(R.drawable.red);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img45.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img45.setBackgroundResource(R.drawable.red3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img45.setBackgroundResource(R.drawable.red4);

                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img45.setBackgroundResource(R.drawable.blue);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img45.setBackgroundResource(R.drawable.blue2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img45.setBackgroundResource(R.drawable.blue3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img45.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img45.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 46:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img46.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img46.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img46.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img46.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img46.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img46.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img46.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img46.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img46.setBackgroundResource(R.drawable.red);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img46.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img46.setBackgroundResource(R.drawable.red3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img46.setBackgroundResource(R.drawable.red4);

                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img46.setBackgroundResource(R.drawable.blue);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img46.setBackgroundResource(R.drawable.blue2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img46.setBackgroundResource(R.drawable.blue3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img46.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img46.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 47:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img47.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img47.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img47.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img47.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img47.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img47.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img47.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img47.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img47.setBackgroundResource(R.drawable.red);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img47.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img47.setBackgroundResource(R.drawable.red3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img47.setBackgroundResource(R.drawable.red4);

                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img47.setBackgroundResource(R.drawable.blue);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img47.setBackgroundResource(R.drawable.blue2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img47.setBackgroundResource(R.drawable.blue3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img47.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img47.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 48:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img48.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img48.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img48.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img48.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img48.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img48.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img48.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img48.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img48.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img48.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img48.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img48.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img48.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img48.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img48.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img48.setBackgroundResource(R.drawable.blue4);
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img48.setBackgroundResource(R.drawable.fgreen);
                        }
                    });
                    break;
            }
                break;
            case 49:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img49.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img49.setBackgroundResource(R.drawable.green2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img49.setBackgroundResource(R.drawable.green3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img49.setBackgroundResource(R.drawable.green4);
                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img49.setBackgroundResource(R.drawable.yellow);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img49.setBackgroundResource(R.drawable.yellow2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img49.setBackgroundResource(R.drawable.yellow3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img49.setBackgroundResource(R.drawable.yellow4);
                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img49.setBackgroundResource(R.drawable.red);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img49.setBackgroundResource(R.drawable.red2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img49.setBackgroundResource(R.drawable.red3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img49.setBackgroundResource(R.drawable.red4);
                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img49.setBackgroundResource(R.drawable.blue);
                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img49.setBackgroundResource(R.drawable.blue2);
                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img49.setBackgroundResource(R.drawable.blue3);
                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img49.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img49.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 50:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img50.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img50.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img50.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img50.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img50.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img50.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img50.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img50.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img50.setBackgroundResource(R.drawable.red);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img50.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img50.setBackgroundResource(R.drawable.red3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img50.setBackgroundResource(R.drawable.red4);

                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img50.setBackgroundResource(R.drawable.blue);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img50.setBackgroundResource(R.drawable.blue2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img50.setBackgroundResource(R.drawable.blue3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img50.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img50.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 51:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img51.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img51.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img51.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img51.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img51.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img51.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img51.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img51.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img51.setBackgroundResource(R.drawable.red);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img51.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img51.setBackgroundResource(R.drawable.red3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img51.setBackgroundResource(R.drawable.red4);

                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img51.setBackgroundResource(R.drawable.blue);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img51.setBackgroundResource(R.drawable.blue2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img51.setBackgroundResource(R.drawable.blue3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img51.setBackgroundResource(R.drawable.blue4);

                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img51.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
            case 52:switch (color){
                case 1:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img52.setBackgroundResource(R.drawable.green);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img52.setBackgroundResource(R.drawable.green2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img52.setBackgroundResource(R.drawable.green3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img52.setBackgroundResource(R.drawable.green4);

                                }
                            });
                            break;
                    }
                    break;
                case 2:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img52.setBackgroundResource(R.drawable.yellow);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img52.setBackgroundResource(R.drawable.yellow2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img52.setBackgroundResource(R.drawable.yellow3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img52.setBackgroundResource(R.drawable.yellow4);

                                }
                            });
                            break;
                    }
                    break;
                case 3:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img52.setBackgroundResource(R.drawable.red);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img52.setBackgroundResource(R.drawable.red2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img52.setBackgroundResource(R.drawable.red3);

                                }
                            });
                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img52.setBackgroundResource(R.drawable.red4);

                                }
                            });
                            break;
                    }
                    break;
                case 4:
                    switch (numberOftokens){
                        case 1:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img52.setBackgroundResource(R.drawable.blue);

                                }
                            });
                            break;
                        case 2:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img52.setBackgroundResource(R.drawable.blue2);

                                }
                            });
                            break;
                        case 3:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img52.setBackgroundResource(R.drawable.blue3);
                                }
                            });

                            break;
                        case 4:
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    img52.setBackgroundResource(R.drawable.blue4);
                                }
                            });

                            break;
                    }
                    break;
                case 5:
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img52.setBackgroundResource(R.drawable.fwhite);
                        }
                    });
                    break;
            }
                break;
        }

    }

    int tokenCounter=0;
    int l,x,y,z;
    public void tokenChangeListner(){
        Player1.setMoves(0);
        Player2.setMoves(0);
        Player3.setMoves(0);
        Player4.setMoves(0);
        for(i=1;i<=52;i++){
            setcolor(i,5,1);
            for (x=0;x<4;x++){
                for (y=0;y<4;y++){
                    tokenCounter=0;
                    if (Mapper.tokenMatrix[x][y]==i){
                        for (l=0;l<4;l++){
                            if (Mapper.tokenMatrix[x][y]==Mapper.tokenMatrix[x][l]){
                                tokenCounter++;
                            }
                        }
                        if ((x+1)==3){
                            setcolor(i,4,tokenCounter);
                        }
                        else  if ((x+1)==4){
                            setcolor(i,3,tokenCounter);
                        }
                        else {
                            setcolor(i,x+1,tokenCounter);
                        }

                    }
                }
            }
        }
        for(i=-5;i<0;i++){
            for (x=0;x<4;x++){
                if ((x+1)==3){
                    setcolor(i,4,0);
                }
                else  if ((x+1)==4){
                    setcolor(i,3,0);
                }
                else {
                    setcolor(i,x+1,0);
                }

                for (y=0;y<4;y++){
                    tokenCounter=0;
                    if (Mapper.tokenMatrix[x][y]==i){
                        for (l=0;l<4;l++){
                            if (Mapper.tokenMatrix[x][y]==Mapper.tokenMatrix[x][l]){
                                tokenCounter++;
                            }
                        }
                        if ((x+1)==3){
                            setcolor(i,4,tokenCounter);
                        }
                        else  if ((x+1)==4){
                            setcolor(i,3,tokenCounter);
                        }
                        else {
                            setcolor(i,x+1,tokenCounter);
                        }
                    }
                }
            }
        }
    }

    public void imageClickListner(int position){
        int i,j;
        for (i=0;i<4;i++){
            for (j=0;j<4;j++){
                if (position==Mapper.tokenMatrix[i][j]){

                    if (Player1.isTurn()&&i==0){
                        if (tokenMatrix[i][j]+Player1.getMoves()<=57){
                            switch ((j+1)){
                                case 1:
                                    Player1.setToken1(Player1.getToken1()+Player1.getMoves());
                                    nextTurn();
                                    break;
                                case 2:
                                    Player1.setToken2(Player1.getToken2()+Player1.getMoves());
                                    nextTurn();
                                    break;
                                case 3:
                                    Player1.setToken3(Player1.getToken3()+Player1.getMoves());
                                    nextTurn();
                                    break;
                                case 4:
                                    Player1.setToken4(Player1.getToken4()+Player1.getMoves());
                                    nextTurn();
                                    break;
                            }
                        }
                        else {
                            nextTurn();
                        }
                    }

                    else if (Player2.isTurn()&&i==1){
                        if (tokenMatrix[i][j]+Player2.getMoves()<=57){
                            switch ((j+1)){
                                case 1:
                                    Player2.setToken1(Player2.getToken1()+Player2.getMoves());
                                    nextTurn();
                                    break;
                                case 2:
                                    Player2.setToken2(Player2.getToken2()+Player2.getMoves());
                                    nextTurn();
                                    break;
                                case 3:
                                    Player2.setToken3(Player2.getToken3()+Player2.getMoves());
                                    nextTurn();
                                    break;
                                case 4:
                                    Player2.setToken4(Player2.getToken4()+Player2.getMoves());
                                    nextTurn();
                                    break;
                            }
                        }
                        else {
                            nextTurn();
                        }
                    }

                    else if (Player3.isTurn()&&i==2){
                        if (tokenMatrix[i][j]+Player3.getMoves()<=57){
                            switch ((j+1)){
                                case 1:
                                    Player3.setToken1(Player3.getToken1()+Player3.getMoves());
                                    nextTurn();
                                    break;
                                case 2:
                                    Player3.setToken2(Player3.getToken2()+Player3.getMoves());
                                    nextTurn();
                                    break;
                                case 3:
                                    Player3.setToken3(Player3.getToken3()+Player3.getMoves());
                                    nextTurn();
                                    break;
                                case 4:
                                    Player3.setToken4(Player3.getToken4()+Player3.getMoves());
                                    nextTurn();
                                    break;
                            }
                        }
                        else {
                            nextTurn();
                        }
                    }

                    else if (Player4.isTurn()&&i==3){
                        if (tokenMatrix[i][j]+Player4.getMoves()<=57){
                            switch ((j+1)){
                                case 1:
                                    Player4.setToken1(Player4.getToken1()+Player4.getMoves());
                                    nextTurn();
                                    break;
                                case 2:
                                    Player4.setToken2(Player4.getToken2()+Player4.getMoves());
                                    nextTurn();
                                    break;
                                case 3:
                                    Player4.setToken3(Player4.getToken3()+Player4.getMoves());
                                    nextTurn();
                                    break;
                                case 4:
                                    Player4.setToken4(Player4.getToken4()+Player4.getMoves());
                                    nextTurn();
                                    break;
                            }
                        }
                        else {
                            nextTurn();
                        }
                    }

                }
            }
        }
    }
    public boolean hasNoOption(int player){
        switch (player){
            case 1:
                if (Player1.getMoves()>0){
                    if (Player1.getToken1()>0&&Player1.getToken1()+Player1.getMoves()<=57){
                        return false;
                    }
                   else if (Player1.getToken2()>0&&Player1.getToken2()+Player1.getMoves()<=57){
                        return false;
                    }
                   else if (Player1.getToken3()>0&&Player1.getToken3()+Player1.getMoves()<=57){
                        return false;
                    }
                    else if (Player1.getToken4()>0&&Player1.getToken4()+Player1.getMoves()<=57){
                        return false;
                    }
                    else if (Player1.getHome()>0&&Player1.getMoves()==6){
                        return false;
                    }
                }
                break;
            case 2:
                if (Player2.getMoves()>0){
                    if (Player2.getToken1()>0&&Player2.getToken1()+Player2.getMoves()<=57){
                        return false;
                    }
                    else if (Player2.getToken2()>0&&Player2.getToken2()+Player2.getMoves()<=57){
                        return false;
                    }
                    else if (Player2.getToken3()>0&&Player2.getToken3()+Player2.getMoves()<=57){
                        return false;
                    }
                    else if (Player2.getToken4()>0&&Player2.getToken4()+Player2.getMoves()<=57){
                        return false;
                    }
                    else if (Player2.getHome()>0&&Player2.getMoves()==6){
                        return false;
                    }
                }
                break;
            case 3:
                if (Player3.getMoves()>0){
                    if (Player3.getToken1()>0&&Player3.getToken1()+Player3.getMoves()<=57){
                        return false;
                    }
                    else if (Player3.getToken2()>0&&Player3.getToken2()+Player3.getMoves()<=57){
                        return false;
                    }
                    else if (Player3.getToken3()>0&&Player3.getToken3()+Player3.getMoves()<=57){
                        return false;
                    }
                    else if (Player3.getToken4()>0&&Player3.getToken4()+Player3.getMoves()<=57){
                        return false;
                    }
                    else if (Player3.getHome()>0&&Player3.getMoves()==6){
                        return false;
                    }
                }
                break;
            case 4:
                if (Player4.getMoves()>0){
                    if (Player4.getToken1()>0&&Player4.getToken1()+Player4.getMoves()<=57){
                        return false;
                    }
                    else if (Player4.getToken2()>0&&Player4.getToken2()+Player4.getMoves()<=57){
                        return false;
                    }
                    else if (Player4.getToken3()>0&&Player4.getToken3()+Player4.getMoves()<=57){
                        return false;
                    }
                    else if (Player4.getToken4()>0&&Player4.getToken4()+Player4.getMoves()<=57){
                        return false;
                    }
                    else if (Player4.getHome()>0&&Player4.getMoves()==6){
                        return false;
                    }
                }
                break;
        }
        return true;
    }

    public void affectOnMove(int player,int tokenNumber){
        int position=findPositionOnBoard(player,tokenNumber);
        int i,j;
        if (tokenMatrix[(player-1)][(tokenNumber-1)]>=1){
            for (i=0;i<4;i++){
                if (player==(i+1)){
                    continue;
                }
                for (j=0;j<4;j++){
                    if (Mapper.tokenMatrix[i][j]==position){
                        setZero((i+1),(j+1));
                        switch (player){
                            case 1:
                                switch ((i+1)){
                                    case 2:
                                        handler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(Ludo_board.this, Player1.getName()+" Smashed "+Player2.getName(), Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        break;
                                    case 3:
                                        handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(Ludo_board.this, Player1.getName()+" Smashed "+Player3.getName(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                        break;
                                    case 4:
                                        handler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(Ludo_board.this, Player1.getName()+" Smashed "+Player4.getName(), Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        break;
                                }
                                break;
                            case 2:
                                switch ((i+1)){
                                    case 1:
                                        handler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(Ludo_board.this, Player2.getName()+" Smashed "+Player1.getName(), Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        break;
                                    case 3:
                                        handler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(Ludo_board.this, Player2.getName()+" Smashed "+Player3.getName(), Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        break;
                                    case 4:
                                        handler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(Ludo_board.this, Player2.getName()+" Smashed "+Player4.getName(), Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        break;
                                }
                                break;
                            case 3:
                                switch ((i+1)){
                                    case 1:
                                        handler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(Ludo_board.this, Player3.getName()+" Smashed "+Player1.getName(), Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        break;
                                    case 2:
                                        handler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(Ludo_board.this, Player3.getName()+" Smashed "+Player2.getName(), Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        break;
                                    case 4:
                                        handler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(Ludo_board.this, Player3.getName()+" Smashed "+Player4.getName(), Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        break;
                                }
                                break;
                            case 4:
                                switch ((i+1)){
                                    case 1:
                                        handler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(Ludo_board.this, Player4.getName()+" Smashed "+Player1.getName(), Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        break;
                                    case 2:
                                        handler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(Ludo_board.this, Player4.getName()+" Smashed "+Player2.getName(), Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        break;
                                    case 3:
                                        handler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(Ludo_board.this, Player4.getName()+" Smashed "+Player3.getName(), Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        break;
                                }
                                break;
                        }

                    }
                }
            }
        }

    }

    public int findPositionOnBoard(int player,int tokenNumber){
        int position=0;
        switch (player){
            case 1:
                switch (tokenNumber){
                    case 1:
                        position=Mapper.tokenMatrix[0][0];
                        break;
                    case 2:
                        position=Mapper.tokenMatrix[0][1];
                        break;
                    case 3:
                        position=Mapper.tokenMatrix[0][2];
                        break;
                    case 4:
                        position=Mapper.tokenMatrix[0][3];
                        break;
                }
                break;
            case 2:
                switch (tokenNumber){
                    case 1:
                        position=Mapper.tokenMatrix[1][0];
                        break;
                    case 2:
                        position=Mapper.tokenMatrix[1][1];
                        break;
                    case 3:
                        position=Mapper.tokenMatrix[1][2];
                        break;
                    case 4:
                        position=Mapper.tokenMatrix[1][3];
                        break;
                }
                break;
            case 3:
                switch (tokenNumber){
                    case 1:
                        position=Mapper.tokenMatrix[2][0];
                        break;
                    case 2:
                        position=Mapper.tokenMatrix[2][1];
                        break;
                    case 3:
                        position=Mapper.tokenMatrix[2][2];
                        break;
                    case 4:
                        position=Mapper.tokenMatrix[2][3];
                        break;
                }
                break;
            case 4:
                switch (tokenNumber){
                    case 1:
                        position=Mapper.tokenMatrix[3][0];
                        break;
                    case 2:
                        position=Mapper.tokenMatrix[3][1];
                        break;
                    case 3:
                        position=Mapper.tokenMatrix[3][2];
                        break;
                    case 4:
                        position=Mapper.tokenMatrix[3][3];
                        break;
                }
                break;
        }
        return position;
    }

    public void setZero(int player,int tokenNumber){
        switch (player){
            case 1:
                switch (tokenNumber){
                    case 1:
                        Player1.setToken1(0);
                        break;
                    case 2:
                        Player1.setToken2(0);
                        break;
                    case 3:
                        Player1.setToken3(0);
                        break;
                    case 4:
                        Player1.setToken4(0);
                        break;
                }
                break;
            case 2:
                switch (tokenNumber){
                    case 1:
                        Player2.setToken1(0);
                        break;
                    case 2:
                        Player2.setToken2(0);
                        break;
                    case 3:
                        Player2.setToken3(0);
                        break;
                    case 4:
                        Player2.setToken4(0);
                        break;
                }
                break;
            case 3:
                switch (tokenNumber){
                    case 1:
                        Player3.setToken1(0);
                        break;
                    case 2:
                        Player3.setToken2(0);
                        break;
                    case 3:
                        Player3.setToken3(0);
                        break;
                    case 4:
                        Player3.setToken4(0);
                        break;
                }
                break;
            case 4:
                switch (tokenNumber){
                    case 1:
                        Player4.setToken1(0);
                        break;
                    case 2:
                        Player4.setToken2(0);
                        break;
                    case 3:
                        Player4.setToken3(0);
                        break;
                    case 4:
                        Player4.setToken4(0);
                        break;
                }
                break;
        }
    }

    public void greenImageClickListener(int position){
        colorImageClickListener(1,position);
    }
    public void yellowImageClickListener(int position){
        colorImageClickListener(2,position);
    }
    public void blueImageClickListener(int position){
        colorImageClickListener(3,position);
    }
    public void redImageClickListener(int position){
        colorImageClickListener(4,position);
    }
    public void colorImageClickListener(int player,int position){
        int i;
        switch (player){
            case 1:
                for (i=0;i<4;i++){
                    if (position==Mapper.tokenMatrix[0][i]&&Player1.getMoves()>0){
                        if (tokenMatrix[0][i]+Player1.getMoves()<=57){
                            switch ((i+1)){
                                case 1:
                                    Player1.setToken1(Player1.getToken1()+Player1.getMoves());
                                    break;
                                case 2:
                                    Player1.setToken2(Player1.getToken2()+Player1.getMoves());
                                    break;
                                case 3:
                                    Player1.setToken3(Player1.getToken3()+Player1.getMoves());
                                    break;
                                case 4:
                                    Player1.setToken4(Player1.getToken4()+Player1.getMoves());
                                    break;
                            }
                            nextTurn();
                        }
                    }
                }
                break;
            case 2:
                for (i=0;i<4;i++){
                    if (position==Mapper.tokenMatrix[1][i]&&Player2.getMoves()>0){
                        if (tokenMatrix[1][i]+Player2.getMoves()<=57){
                            switch ((i+1)){
                                case 1:
                                    Player2.setToken1(Player2.getToken1()+Player2.getMoves());
                                    break;
                                case 2:
                                    Player2.setToken2(Player2.getToken2()+Player2.getMoves());
                                    break;
                                case 3:
                                    Player2.setToken3(Player2.getToken3()+Player2.getMoves());
                                    break;
                                case 4:
                                    Player2.setToken4(Player2.getToken4()+Player2.getMoves());
                                    break;
                            }
                            nextTurn();
                        }
                    }
                }
                break;
            case 3:
                for (i=0;i<4;i++){
                    if (position==Mapper.tokenMatrix[2][i]&&Player3.getMoves()>0){
                        if (tokenMatrix[2][i]+Player3.getMoves()<=57){
                            switch ((i+1)){
                                case 1:
                                    Player3.setToken1(Player3.getToken1()+Player3.getMoves());
                                    break;
                                case 2:
                                    Player3.setToken2(Player3.getToken2()+Player3.getMoves());
                                    break;
                                case 3:
                                    Player3.setToken3(Player3.getToken3()+Player3.getMoves());
                                    break;
                                case 4:
                                    Player3.setToken4(Player3.getToken4()+Player3.getMoves());
                                    break;
                            }
                            nextTurn();
                        }
                    }
                }
                break;
            case 4:
                for (i=0;i<4;i++){
                    if (position==Mapper.tokenMatrix[3][i]&&Player4.getMoves()>0){
                        if (tokenMatrix[3][i]+Player4.getMoves()<=57){
                            switch ((i+1)){
                                case 1:
                                    Player4.setToken1(Player4.getToken1()+Player4.getMoves());
                                    break;
                                case 2:
                                    Player4.setToken2(Player4.getToken2()+Player4.getMoves());
                                    break;
                                case 3:
                                    Player4.setToken3(Player4.getToken3()+Player4.getMoves());
                                    break;
                                case 4:
                                    Player4.setToken4(Player4.getToken4()+Player4.getMoves());
                                    break;
                            }
                            nextTurn();
                        }
                    }
                }
                break;
        }
    }


}
