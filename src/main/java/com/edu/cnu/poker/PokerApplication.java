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

                for(int i = 0; i < 5; i++){ //complete draw
                    if(i < 3){
                        you.getHand().drawACard();
                    }
                    com.getHand().drawACard();
                }

                System.out.println("######## Your Hand ########");
                you.getHand().showAllCard();
                System.out.println("######## FIRST CARD of COM ########");
                com.getHand().showACard(0);
                System.out.println("######## SECOND CARD of COM ########");
                com.getHand().showACard(1);

                System.out.println("BET? (B) or DIE? (D) or CHECK? (C)");
                while(true) {
                    choice = myScanner.next();
                    if (choice.equals("B") || choice.equals("D") || choice.equals("C")) {
                        break;
                    }
                    else
                        System.out.println("######## Wrong Input! ########");
                }
                if(choice.equals("B")) {
                    System.out.println("######## Your money : " + you.getFund() + " ########");
                    System.out.println("######## COM money : " + com.getFund() + " ########");
                    System.out.println("How much will you bet? : ");
                    bet_money = myScanner.nextInt();
                    while(true) {
                        if(bet_money > you.getFund())
                            System.out.println("######## Not Enough money ########");
                        else if(bet_money > com.getFund())
                            System.out.println("######## Computer has not enough money ########");
                        else
                            break;
                    }
                    you.setFund(you.getFund()-bet_money);
                    com.setFund(com.getFund()-bet_money);
                    reward += 2 * bet_money;
                    System.out.println("Betted Money : " + reward);
                }
                else if(choice.equals("D")) {
                    System.out.println("######## You Lose. Play next game. ########");
                    com.setFund(com.getFund()+reward);
                    continue;
                }
                else {
                    System.out.println("######## You chose CHECK. Play game. ########");
                    playGame(you, com, reward);
                }
            }
    }
    public static void playGame(Player you, Player com, int reward) {
        Evaluator evaluator = new Evaluator();
        you.getHand().drawACard();
        you.getHand().drawACard();

        System.out.println("YOU HAVE : " + evaluator.evaluate(you.getHand().getCardList()) + "\nCOMPUTER HAVE : " + evaluator.evaluate(com.getHand().getCardList()));
        if(evaluator.evaluate(you.getHand().getCardList()).getPriority() < evaluator.evaluate(com.getHand().getCardList()).getPriority()){
            System.out.println("YOU LOSE!!!");
            com.setFund(com.getFund() + reward);
        }
        else if(evaluator.evaluate(you.getHand().getCardList()).getPriority() > evaluator.evaluate(com.getHand().getCardList()).getPriority()){
            System.out.println("YOU WIN!!!");
            you.setFund(you.getFund() + reward);
        }
        else{
            System.out.println("DRAW...MONEY ROLLBACK");
            you.setFund(you.getFund() + reward/2);
            com.setFund(com.getFund() + reward/2);
        }
        System.out.println("YOUR MONEY : " + you.getFund());
        System.out.println("COMPUTER'S MONEY : " + com.getFund());
    }

}