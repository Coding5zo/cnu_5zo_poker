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
    public void 아무런_족보가_없다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(4, Suit.DIAMONDS),
                new Card(8, Suit.CLUBS),
                new Card(13, Suit.CLUBS),
                new Card(2, Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList).getPriority();
        assertThat(result, is(1));
    }
    @Test
    public void RANK가_동일한_카드가_2장씩_1쌍이면_원패어다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(1,Suit.DIAMONDS),
                new Card(8,Suit.CLUBS),
                new Card(13,Suit.CLUBS),
                new Card(2,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList).getPriority();
        assertThat(result, is(2));
    }
    @Test
    public void RANK가_동일한_카드가_2장씩_2쌍이면_투패어다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(1,Suit.DIAMONDS),
                new Card(8,Suit.CLUBS),
                new Card(8,Suit.DIAMONDS),
                new Card(2,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList).getPriority();
        assertThat(result, is(3));
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
    public void RANK가_5개연속이면서_가장_낮으면_백스트레이트다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2,Suit.CLUBS),
                new Card(5,Suit.CLUBS),
                new Card(1,Suit.CLUBS),
                new Card(3,Suit.CLUBS),
                new Card(4,Suit.SPADES)
        );
        int result = evaluator.evaluate(cardList).getPriority();
        assertThat(result, is(6));
    }
    @Test
    public void RANK가_5개연속이면서_가장_높으면_마운틴이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(13,Suit.CLUBS),
                new Card(12,Suit.CLUBS),
                new Card(10,Suit.CLUBS),
                new Card(11,Suit.SPADES)
        );
        int result = evaluator.evaluate(cardList).getPriority();
        assertThat(result, is(7));
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
    public void TRIPLE하나와_ONE_PAIR하나면_풀하우스다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(1, Suit.DIAMONDS),
                new Card(1, Suit.HEARTS),
                new Card(2, Suit.HEARTS),
                new Card(2, Suit.DIAMONDS)
        );
        int result = evaluator.evaluate(cardList).getPriority();
        assertThat(result,is(9));
    }

    @Test
    public void RANK가_동일한_카드가_4장씩_1쌍이면_포카드다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(1,Suit.HEARTS),
                new Card(1,Suit.DIAMONDS),
                new Card(1,Suit.SPADES),
                new Card(2,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList).getPriority();
        assertThat(result, is(10));
    }

    @Test
    public void 스트레이트면서_플러시면_스트레이트플러시다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2,Suit.CLUBS),
                new Card(3,Suit.CLUBS),
                new Card(4,Suit.CLUBS),
                new Card(5,Suit.CLUBS),
                new Card(6,Suit.CLUBS)
        );
        int result = evaluator.evaluate(cardList).getPriority();
        assertThat(result, is(11));
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