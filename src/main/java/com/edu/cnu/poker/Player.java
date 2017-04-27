package com.edu.cnu.poker;

/**
 * Created by leeheungrok on 2017. 4. 27..
 */
public class Player {
    private int fund;
    private Hand hand;

    public Player() {
        this.fund = 0;
        this.hand = null;
    }

    public void setHand(Hand hand){
        this.hand = hand;
    }

    public void setFund(int fund){
        this.fund = fund;
    }
}
