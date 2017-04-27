package com.edu.cnu.poker;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Iterator;
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

    public void showAllCard(){
        if(cardList.size() == 0){
            throw new NoMoreCardException();
        }
        Iterator<Card> iterator = this.cardList.iterator();
        Card aCard ;
        while(iterator.hasNext()){
            aCard = iterator.next();
            System.out.print("SUIT: " +aCard.getSuit()+"RANK: "+aCard.getRank()+" ");
        }
        System.out.println();
    }

    public List<Card> getCardList(){
        return this.cardList;
    }




    public int getTotalCard(){
        return cardList.size();
    }
}