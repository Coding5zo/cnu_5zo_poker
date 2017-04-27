package com.edu.cnu.poker;

/**
 * Created by leeheungrok on 2017. 4. 27.
 */
public enum Genealogy {
    ROYAL_STRAIGHT_FLUSH(13),
    BACK_STRAIGHT_FLUSH(12),
    STRAIGHT_FLUSH(11),
    FOUR_CARD(10),
    FULL_HOUSE(9),
    FLUSH(8),
    MOUNTAIN(7),
    BACK_STRAIGHT(6),
    STRAIGHT(5),
    TRIPLE(4),
    TWO_PAIR(3),
    ONE_PAIR(2),
    NOTHING(1);

    private int priority;


    Genealogy(int priority){
        this.priority = priority;
    }

    public int getPriority(){
        return this.priority;
    }
}
