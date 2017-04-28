package com.edu.cnu.poker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leeheungrok on 2017. 4. 17..
 */
public class Evaluator {

    public Genealogy evaluate(List<Card> cardList) {
        Map<Suit, Integer> suitMap = new HashMap<Suit, Integer>();
        Map<Integer, Integer> integerMap = new HashMap<Integer, Integer>();

        for (Card card : cardList) {
            if (suitMap.containsKey(card.getSuit())) {
                Integer count = suitMap.get(card.getSuit());
                count = count + 1;
                suitMap.put(card.getSuit(), count);
            } else {
                suitMap.put(card.getSuit(), 1);
            }

            if (integerMap.containsKey(card.getRank())) {
                Integer count = integerMap.get(card.getRank());
                count = count + 1;
                integerMap.put(card.getRank(), count);
            } else {
                integerMap.put(card.getRank(), 1);
            }
        }

        if(getRoyalStraightFlush(suitMap, integerMap)) return Genealogy.ROYAL_STRAIGHT_FLUSH;
        if(getBackStraightFlush(suitMap, integerMap)) return Genealogy.BACK_STRAIGHT_FLUSH;
        if(getStraightFlush(suitMap, integerMap)) return Genealogy.STRAIGHT_FLUSH;
        if(getFourCard(integerMap)) return Genealogy.FOUR_CARD;
        if(getFullHouse(integerMap)) return Genealogy.FULL_HOUSE;
        if(getFlush(suitMap)) return Genealogy.FLUSH;
        if(getMountain(integerMap)) return Genealogy.MOUNTAIN;
        if(getBackStraight(integerMap)) return Genealogy.BACK_STRAIGHT;
        if(getStraight(integerMap)) return Genealogy.STRAIGHT;
        if(getTriple(integerMap)) return Genealogy.TRIPLE;
        if(getTwoPair(integerMap)) return Genealogy.TWO_PAIR;
        if(getOnePair(integerMap)) return Genealogy.ONE_PAIR;


        return Genealogy.NOTHING;
    }

    private boolean getRoyalStraightFlush(Map<Suit, Integer> suitMap, Map<Integer, Integer> integerMap){
        return getFlush(suitMap) && getMountain(integerMap);
    }

    private boolean getBackStraightFlush(Map<Suit, Integer> suitMap, Map<Integer, Integer> integerMap){
        return getFlush(suitMap) && getBackStraight(integerMap);
    }

    private boolean getStraightFlush(Map<Suit, Integer> suitMap, Map<Integer, Integer> integerMap){
        return getStraight(integerMap) && getFlush(suitMap);
    }

    private boolean getFourCard(Map<Integer, Integer> integerMap) {
        for(Integer key : integerMap.keySet()){
            if(integerMap.get(key) == 4)
                return true;
        }
        return false;
    }

    private boolean getFullHouse(Map<Integer, Integer> integerMap) {
        int triple = 0;
        int pair = 0;
        for(int key : integerMap.keySet()){
            if(integerMap.get(key) == 3){
                triple = key;
            }
            if(integerMap.get(key) == 2){
                pair = key;
            }
        }
        return triple != 0 && pair != 0;
    }

    private boolean getBackStraight(Map<Integer, Integer> integerMap){
        return integerMap.containsKey(1) && integerMap.containsKey(2) && integerMap.containsKey(3) && integerMap.containsKey(4) && integerMap.containsKey(5);
    }

    private boolean getMountain(Map<Integer, Integer> integerMap){
        return integerMap.containsKey(10) && integerMap.containsKey(11) &&integerMap.containsKey(12) && integerMap.containsKey(13) && integerMap.containsKey(1);
    }

    private boolean getFlush(Map<Suit, Integer> suitMap) {
        for(Suit key : suitMap.keySet()){
            return suitMap.get(key) == 5;
        }
        return false;
    }
  
    private boolean getStraight(Map<Integer, Integer> integerMap){
        int min = 14;
        int max = 0;

        for(int key : integerMap.keySet()){
            if(integerMap.get(key) >= 2){
                return false;
            }
            if(integerMap.get(key) == 1){
                min = min < key? min : key;
                max = max > key? max : key;
            }
        }
        return max - min == 4;
    }

    private boolean getTriple(Map<Integer, Integer> integerMap) {
        for(Integer key : integerMap.keySet()){
            return integerMap.get(key) == 3;
        }
        return false;
    }

    private boolean getTwoPair(Map<Integer, Integer> integerMap) {
        int count = 0;
        for(Integer key : integerMap.keySet()){
            if(integerMap.get(key) == 2){
                count++;
            }
        }
        return count == 2;
    }
  
    private boolean getOnePair(Map<Integer, Integer> integerMap) {
        for(Integer key : integerMap.keySet()){
            return integerMap.get(key) == 2;
        }
        return false;
    }
}
