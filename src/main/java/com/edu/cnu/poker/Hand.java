package com.edu.cnu.poker;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leeheungrok on 2017. 4. 17..
 */
public class Hand {

    private Deck deck;
    private PokerType pokerType;
    private List<Card> cardList;

    public Hand(Deck deck, PokerType pokerType){
        this.deck = deck;
        this.pokerType = pokerType;
        this.cardList = new ArrayList<Card>();
        cardList = new ArrayList<Card>();
    }

    public boolean drawACard(){
        if(this.cardList.add((this.deck.drawCard())))
            return true;
        return false;
    }


    public int getTotalCard(){
        return cardList.size();
    }
}