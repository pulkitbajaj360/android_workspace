package com.example.android.ludo;

public class UpdateHomesThread implements Runnable {
    boolean tokenMatrix[][]=new boolean[4][4];
    int i=0,j=0;
    int count=0;
    @Override
    public void run() {
        for (i=0;i<4;i++){
            for (j=0;j<4;j++){
                tokenMatrix[i][j]=true;
            }
        }
        while (true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (tokenMatrix[0][0]!=(Player1.getToken1()==0)){
                tokenMatrix[0][0]=(Player1.getToken1()==0);
                changeListner();
            }
            else if (tokenMatrix[0][1]!=(Player1.getToken2()==0)){
                tokenMatrix[0][1]=(Player1.getToken2()==0);
                changeListner();

            }
            else if (tokenMatrix[0][2]!=(Player1.getToken3()==0)){
                tokenMatrix[0][2]=(Player1.getToken3()==0);
                changeListner();

            }
            else if (tokenMatrix[0][3]!=(Player1.getToken4()==0)){
                tokenMatrix[0][3]=(Player1.getToken4()==0);
                changeListner();

            }
            else if (tokenMatrix[1][0]!=(Player2.getToken1()==0)){
                tokenMatrix[1][0]=(Player2.getToken1()==0);
                changeListner();

            }
            else if (tokenMatrix[1][1]!=(Player2.getToken2()==0)){
                tokenMatrix[1][1]=(Player2.getToken2()==0);
                changeListner();

            }
            else if (tokenMatrix[1][2]!=(Player2.getToken3()==0)){
                tokenMatrix[1][2]=(Player2.getToken3()==0);
                changeListner();

            }
            else if (tokenMatrix[1][3]!=(Player2.getToken4()==0)){
                tokenMatrix[1][3]=(Player2.getToken4()==0);
                changeListner();

            }
            else if (tokenMatrix[2][0]!=(Player3.getToken1()==0)){
                tokenMatrix[2][0]=(Player3.getToken1()==0);
                changeListner();

            }
            else if (tokenMatrix[2][1]!=(Player3.getToken2()==0)){
                tokenMatrix[2][1]=(Player3.getToken2()==0);
                changeListner();

            }
            else if (tokenMatrix[2][2]!=(Player3.getToken3()==0)){
                tokenMatrix[2][2]=(Player3.getToken3()==0);
                changeListner();

            }
            else if (tokenMatrix[2][3]!=(Player3.getToken4()==0)){
                tokenMatrix[2][3]=(Player3.getToken4()==0);
                changeListner();

            }
            else if (tokenMatrix[3][0]!=(Player4.getToken1()==0)){
                tokenMatrix[3][0]=(Player4.getToken1()==0);
                changeListner();

            }
            else if (tokenMatrix[3][1]!=(Player4.getToken2()==0)){
                tokenMatrix[3][1]=(Player4.getToken2()==0);
                changeListner();

            }
            else if (tokenMatrix[3][2]!=(Player4.getToken3()==0)){
                tokenMatrix[3][2]=(Player4.getToken3()==0);
                changeListner();

            }
            else if (tokenMatrix[3][3]!=(Player4.getToken4()==0)){
                tokenMatrix[3][3]=(Player4.getToken4()==0);
                changeListner();

            }

        }
    }
    public void changeListner(){
        for (i=0;i<4;i++){
            count=0;
            for (j=0;j<4;j++){
                if (tokenMatrix[i][j]){
                    count++;
                }
            }
            setHome(i+1,count);
        }
        Ludo_board.setHomes();

    }
    public void setHome(int player,int homes){
        switch (player){
            case 1:
                Player1.setHome(homes);
                break;
            case 2:
                Player2.setHome(homes);
                break;
            case 3:
                Player3.setHome(homes);
                break;
            case 4:
                Player4.setHome(homes);
        }
    }
}
