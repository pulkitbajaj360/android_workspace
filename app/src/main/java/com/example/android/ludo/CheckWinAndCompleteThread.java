package com.example.android.ludo;

import android.widget.Toast;

public class CheckWinAndCompleteThread implements Runnable {
    int i,j;
    static int complete[]=new int[4];
    @Override
    public void run() {
        complete[0]=0;
        complete[1]=0;
        complete[2]=0;
        complete[3]=0;
        int count;
        while (true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (i=0;i<4;i++){
                count=0;
                for (j=0;j<4;j++){
                    if (Ludo_board.tokenMatrix[i][j]==57){
                        count++;

                    }
                }
                switch ((i+1)){
                    case 1:
                        Player1.setComplete(count);
                        break;
                    case 2:
                        Player2.setComplete(count);
                        break;
                    case 3:
                        Player3.setComplete(count);
                        break;
                    case 4:
                        Player4.setComplete(count);
                        break;
                }
            }
        }
    }
}
