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

    @Test
    public void 스트레이트면서_플러시면서_가장_낮으면_백스트레이트플러시다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2,Suit.CLUBS),
                new Card(3,Suit.CLUBS),
                new Card(4,Suit.CLUBS),
                new Card(5,Suit.CLUBS),
                new Card(1,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList).getPriority();
        assertThat(result, is(12));
    }


    @Test
    public void 플레쉬이면서_마운틴이면_로얄스트레이트플러쉬다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(10,Suit.SPADES),
                new Card(11,Suit.SPADES),
                new Card(12,Suit.SPADES),
                new Card(13,Suit.SPADES),
                new Card(1,Suit.SPADES)
        );
        int result = evaluator.evaluate(cardList).getPriority();
        assertThat(result, is(13));
    }
}