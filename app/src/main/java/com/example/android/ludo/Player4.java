package com.example.android.ludo;

public class Player4 {
    private static boolean flag=false,turn=false;
  private   static String name;
    private static int wins=0,complete=0,token1=0,token2=0,token3=0,token4=0,moves=0,home=4;

    public static boolean isFlag() {
        return flag;
    }

    public static void setFlag(boolean flag) {
        Player4.flag = flag;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Player4.name = name;
    }

    public static int getWins() {
        return wins;
    }

    public static void setWins(int wins) {
        Player4.wins = wins;
    }

    public static int getComplete() {
        return complete;
    }

    public static void setComplete(int complete) {
        Player4.complete = complete;
    }

    public static int getToken1() {
        return token1;
    }

    public static void setToken1(int token1) {
        Player4.token1 = token1;
    }

    public static int getToken2() {
        return token2;
    }

    public static void setToken2(int token2) {
        Player4.token2 = token2;
    }

    public static int getToken3() {
        return token3;
    }

    public static void setToken3(int token3) {
        Player4.token3 = token3;
    }

    public static int getToken4() {
        return token4;
    }

    public static void setToken4(int token4) {
        Player4.token4 = token4;
    }

    public static int getMoves() {
        return moves;
    }

    public static void setMoves(int moves) {
        Player4.moves = moves;
    }

    public static int getHome() {
        return home;
    }

    public static void setHome(int home) {
        Player4.home = home;
    }

    public static boolean isTurn() {
        return turn;
    }

    public static void setTurn(boolean turn) {
        Player4.turn = turn;
    }
}
