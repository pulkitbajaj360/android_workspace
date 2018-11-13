package com.example.android.ludo;

public class UpdateTextThread implements Runnable {
    String greenWins,greenComplete,yellowWins,yellowComplete,blueWins,blueComplete,redWins,redComplete;
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            greenWins=Player1.getName()+" Wins= "+Player1.getWins();
            greenComplete="Complete= "+Player1.getComplete();

            yellowWins=Player2.getName()+" Wins= "+Player2.getWins();
            yellowComplete="Complete= "+Player2.getComplete();

            blueWins=Player3.getName()+" Wins= "+Player3.getWins();
            blueComplete="Complete= "+Player3.getComplete();

            redWins=Player4.getName()+" Wins= "+Player4.getWins();
            redComplete="Complete= "+Player4.getComplete();
            Ludo_board.handler.post(new Runnable() {
                @Override
                public void run() {
                    Ludo_board.greenWins.setText(greenWins);
                    Ludo_board.greenComplete.setText(greenComplete);
                    Ludo_board.yellowWins.setText(yellowWins);
                    Ludo_board.yellowComplete.setText(yellowComplete);

                }
            });
            if(Player3.isFlag()){
                Ludo_board.handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Ludo_board.blueWins.setText(blueWins);
                        Ludo_board.blueComplete.setText(blueComplete);
                    }
                });

            }
            if (Player4.isFlag()){
                Ludo_board.handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Ludo_board.redWins.setText(redWins);
                        Ludo_board.redComplete.setText(redComplete);
                    }
                });

            }
        }
    }
}
