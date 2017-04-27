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

        if(getFlush(suitMap)) return Genealogy.FLUSH;
        if(getStraight(integerMap)) return Genealogy.STRAIGHT;
        if(getTriple(integerMap)) return Genealogy.TRIPLE;
        if(getTwoPair(integerMap)) return Genealogy.TWO_PAIR;
        if(getOnePair(integerMap)) return Genealogy.ONE_PAIR;

        return Genealogy.NOTHING;
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
