package cardPackage;

import jokboPackage.IJokbo;

import java.util.Stack;

public class CardPair implements Comparable<CardPair>{

    private Stack<Card> _cards;

    CardPair(Card card1, Card card2) {
        _cards = new Stack<>();
        _cards.add(card1);
        _cards.add(card2);
    }
    private IJokbo _score;

    public IJokbo getScore() {
        return _score;
    }

    Card getFirstCard()
    {
        return _cards.get(0);
    }
    Card getSecondCard() { return _cards.get(1); }

    boolean isGwang(){ // 광땡일 때 true return
        return getFirstCard().getGwang() && getSecondCard().getGwang();
    }
    boolean isJang(){ // 장땡일때 true return
        return getFirstCard().getNum() == 10 && getSecondCard().getNum() == 10;
    }
    boolean isDdeng(){ // 땡일때 true return
        return getFirstCard().getNum() == getSecondCard().getNum();
    }
    int calculateDdeng(int cardNumber){ //땡일 때 점수 계산
        return cardNumber+9;
    }

    public Card returnCard()
    {
        return _cards.pop();
    }

    public String getCardsInfo() {
        return null;
    }

    @Override
    public int compareTo(CardPair o) {
        return 0;
    }
}
