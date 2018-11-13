package com.example.android.ludo;

import android.view.View;
import android.widget.Toast;

import java.util.Map;

public class UpdateDiceThread implements Runnable {
    int i=1;
    @Override
    public void run() {
        new Thread(new Runnable() {//Thread for setting Dice
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (Player1.isTurn()){
                        Ludo_board.visible(1);
                        if (Player1.getMoves()==0){
                            if (i<7){
                                setDice(1,i);
                                i++;
                            }
                            else {
                                i=1;
                                setDice(1,i);
                            }
                        }
                        else {
                            setDice(1,Player1.getMoves());
                        }
                    }
                    else if (Player2.isTurn()){
                        Ludo_board.visible(2);

                        if (Player2.getMoves()==0){
                            if (i<7){
                                setDice(2,i);
                                i++;
                            }
                            else {
                                i=1;
                                setDice(2,i);
                            }
                        }
                        else {
                            setDice(2,Player2.getMoves());
                        }
                    }
                    else if (Player3.isTurn()){
                        Ludo_board.visible(3);
                        if (Player3.getMoves()==0){
                            if (i<7){
                                setDice(3,i);
                                i++;
                            }
                            else {
                                i=1;
                                setDice(3,i);
                            }
                        }
                        else {
                            setDice(3,Player3.getMoves());
                        }
                    }
                    else if (Player4.isTurn()){
                        Ludo_board.visible(4);
                        if (Player4.getMoves()==0){
                            if (i<7){
                                setDice(4,i);
                                i++;
                            }
                            else {
                                i=1;
                                setDice(4,i);
                            }
                        }
                        else {
                            setDice(4,Player4.getMoves());
                        }
                    }
                    else {
                    }

                }

            }
        }).start();

    }
    public static void setDice(int player,int number){
        switch (player){
            case 1:switch (number){
                case 1:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.greenButton.setBackgroundResource(R.drawable.diceone);
                        }
                    });
                    break;
                case 2:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.greenButton.setBackgroundResource(R.drawable.dicetwo);
                        }
                    });
                    break;
                case 3:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.greenButton.setBackgroundResource(R.drawable.dicethree);
                        }
                    });
                    break;
                case 4:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.greenButton.setBackgroundResource(R.drawable.dicefour);
                        }
                    });
                    break;
                case 5:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.greenButton.setBackgroundResource(R.drawable.dicefive);
                        }
                    });
                    break;
                case 6:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.greenButton.setBackgroundResource(R.drawable.dicesix);
                        }
                    });
                    break;
            }
                break;
            case 2:switch (number){
                case 1:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.yellowButton.setBackgroundResource(R.drawable.diceone);
                        }
                    });
                    break;
                case 2:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.yellowButton.setBackgroundResource(R.drawable.dicetwo);
                        }
                    });
                    break;
                case 3:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.yellowButton.setBackgroundResource(R.drawable.dicethree);
                        }
                    });
                    break;
                case 4:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.yellowButton.setBackgroundResource(R.drawable.dicefour);
                        }
                    });
                    break;
                case 5:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.yellowButton.setBackgroundResource(R.drawable.dicefive);
                        }
                    });
                    break;
                case 6:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.yellowButton.setBackgroundResource(R.drawable.dicesix);
                        }
                    });
                    break;
            }
                break;

            case 3:switch (number){
                case 1:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.blueButton.setBackgroundResource(R.drawable.diceone);
                        }
                    });
                    break;
                case 2:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.blueButton.setBackgroundResource(R.drawable.dicetwo);
                        }
                    });
                    break;
                case 3:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.blueButton.setBackgroundResource(R.drawable.dicethree);
                        }
                    });
                    break;
                case 4:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.blueButton.setBackgroundResource(R.drawable.dicefour);
                        }
                    });
                    break;
                case 5:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.blueButton.setBackgroundResource(R.drawable.dicefive);
                        }
                    });
                    break;
                case 6:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.blueButton.setBackgroundResource(R.drawable.dicesix);
                        }
                    });
                    break;
            }
                break;
            case 4:switch (number){
                case 1:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.redButton.setBackgroundResource(R.drawable.diceone);
                        }
                    });
                    break;
                case 2:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.redButton.setBackgroundResource(R.drawable.dicetwo);
                        }
                    });
                    break;
                case 3:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.redButton.setBackgroundResource(R.drawable.dicethree);
                        }
                    });
                    break;
                case 4:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.redButton.setBackgroundResource(R.drawable.dicefour);
                        }
                    });
                    break;
                case 5:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.redButton.setBackgroundResource(R.drawable.dicefive);
                        }
                    });
                    break;
                case 6:
                    Ludo_board.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Ludo_board.redButton.setBackgroundResource(R.drawable.dicesix);
                        }
                    });
                    break;
            }
                break;
        }
    }

}
