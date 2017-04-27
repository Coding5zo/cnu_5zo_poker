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

        if (getFlush(suitMap)) return Genealogy.FLUSH;
        return Genealogy.NOTHING;
    }

    private boolean getFlush(Map<Suit, Integer> suitMap) {
        for(Suit key : suitMap.keySet()){
            return suitMap.get(key) == 5;
        }
        return false;
    }


}