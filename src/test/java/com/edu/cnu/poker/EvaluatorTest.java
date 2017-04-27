package com.edu.cnu.poker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by leeheungrok on 2017. 4. 17..
 */
public class EvaluatorTest {
    @Test
    public void 아무런_족보가_없다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(4,Suit.DIAMONDS),
                new Card(8,Suit.CLUBS),
                new Card(13,Suit.CLUBS),
                new Card(2,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList).getPriority();
        assertThat(result, is(1));
    }

    @Test
    public void RANK가_동일한_카드가_3장씩_1쌍이면_트리플이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(1,Suit.HEARTS),
                new Card(1,Suit.DIAMONDS),
                new Card(13,Suit.CLUBS),
                new Card(2,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList).getPriority();
        assertThat(result, is(4));
    }

    @Test
    public void RANK가_5개연속이면_스트레이트다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2,Suit.CLUBS),
                new Card(3,Suit.CLUBS),
                new Card(4,Suit.CLUBS),
                new Card(5,Suit.CLUBS),
                new Card(6,Suit.SPADES)
        );
        int result = evaluator.evaluate(cardList).getPriority();
        assertThat(result, is(5));
    }

    @Test
    public void SUIT가_5개가동일하면_플러쉬다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(4,Suit.CLUBS),
                new Card(8,Suit.CLUBS),
                new Card(13,Suit.CLUBS),
                new Card(2,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList).getPriority();
        assertThat(result, is(8));
    }
}