package com.edu.cnu.poker;

import java.util.Scanner;

/**
 * Created by leeheungrok on 2017. 4. 17..
 */
public class PokerApplication {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String choice;
        int bet_money;
        System.out.println("Hello Poker");
        Player you = new Player();
        you.setFund(100);
        Player com = new Player();
        com.setFund(100);
        int gameCount = 0;
    }
}