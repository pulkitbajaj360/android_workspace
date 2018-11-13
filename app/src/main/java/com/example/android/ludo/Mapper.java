package com.example.android.ludo;

public class Mapper {
   static int tokenMatrix[][] = new int[4][4];

    public static int[][] getTokenMatrix() {
        return tokenMatrix;
    }

    public static void setTokenMatrix(int[][] tokenMatrix) {
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                if (i==0){
                    if (tokenMatrix[i][j]==0){
                        Mapper.tokenMatrix[i][j]=0;
                    }
                    else if (tokenMatrix[i][j]>0&&tokenMatrix[i][j]<=5){
                        Mapper.tokenMatrix[i][j]=tokenMatrix[i][j]+47;
                    }
                    else if (tokenMatrix[i][j]>5&&tokenMatrix[i][j]<=51){
                        Mapper.tokenMatrix[i][j]=tokenMatrix[i][j]-5;
                    }
                    else if (tokenMatrix[i][j]>51&&tokenMatrix[i][j]<=56){
                        Mapper.tokenMatrix[i][j]=51-tokenMatrix[i][j];
                    }
                    else if (tokenMatrix[i][j]==57){
                        Mapper.tokenMatrix[i][j]=57;
                    }
                }
                else if (i==1){
                    if (tokenMatrix[i][j]==0){
                        Mapper.tokenMatrix[i][j]=0;
                    }
                    else if (tokenMatrix[i][j]>0&&tokenMatrix[i][j]<=44){
                        Mapper.tokenMatrix[i][j]=tokenMatrix[i][j]+8;
                    }
                    else if (tokenMatrix[i][j]>44&&tokenMatrix[i][j]<=51){
                        Mapper.tokenMatrix[i][j]=tokenMatrix[i][j]-44;
                    }
                    else if (tokenMatrix[i][j]>51&&tokenMatrix[i][j]<=56){
                        Mapper.tokenMatrix[i][j]=51-tokenMatrix[i][j];
                    }
                    else if (tokenMatrix[i][j]==57){
                        Mapper.tokenMatrix[i][j]=57;
                    }
                }
                else if (i==2){
                    if (tokenMatrix[i][j]==0){
                        Mapper.tokenMatrix[i][j]=0;
                    }
                    else if (tokenMatrix[i][j]>0&&tokenMatrix[i][j]<=31){
                        Mapper.tokenMatrix[i][j]=tokenMatrix[i][j]+21;
                    }
                    else if (tokenMatrix[i][j]>31&&tokenMatrix[i][j]<=51){
                        Mapper.tokenMatrix[i][j]=tokenMatrix[i][j]-31;
                    }
                    else if (tokenMatrix[i][j]>51&&tokenMatrix[i][j]<=56){
                        Mapper.tokenMatrix[i][j]=51-tokenMatrix[i][j];
                    }
                    else if (tokenMatrix[i][j]==57){
                        Mapper.tokenMatrix[i][j]=57;
                    }
                }
                else if (i==3){
                    if (tokenMatrix[i][j]==0){
                        Mapper.tokenMatrix[i][j]=0;
                    }
                    else if (tokenMatrix[i][j]>0&&tokenMatrix[i][j]<=18){
                        Mapper.tokenMatrix[i][j]=tokenMatrix[i][j]+34;
                    }
                    else if (tokenMatrix[i][j]>18&&tokenMatrix[i][j]<=51){
                        Mapper.tokenMatrix[i][j]=tokenMatrix[i][j]-18;
                    }
                    else if (tokenMatrix[i][j]>51&&tokenMatrix[i][j]<=56){
                        Mapper.tokenMatrix[i][j]=51-tokenMatrix[i][j];
                    }
                    else if (tokenMatrix[i][j]==57){
                        Mapper.tokenMatrix[i][j]=57;
                    }
                }

            }
        }
    }
}
