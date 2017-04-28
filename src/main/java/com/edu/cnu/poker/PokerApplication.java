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

        while(you.getFund() > 0 && com.getFund() > 0) {
            gameCount++;
            System.out.println("######## GAME " + gameCount + " ########");
            Deck deck = new Deck(1);
            int reward = 0;
            Hand yourHand = new Hand(deck, PokerType.FIVE);
            Hand comHand = new Hand(deck, PokerType.FIVE);
            you.setHand(yourHand);
            com.setHand(comHand);
            you.setFund(you.getFund()-10);
            com.setFund(com.getFund()-10);
            reward += 20;
            System.out.println("Betted Money : " + reward);
        }
    }

}