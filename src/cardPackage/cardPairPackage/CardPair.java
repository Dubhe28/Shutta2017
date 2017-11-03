package cardPackage.cardPairPackage;

import cardPackage.Card;

import java.util.Stack;

abstract public class CardPair implements Comparable<CardPair>{

    CardPair(Card card1, Card card2) {
        _cards = new Stack<>();
        _cards.add(card1);
        _cards.add(card2);
        ScoreCalculator.getInstance().setCardScore(this);
    }

    private Stack<Card> _cards;

    // region Jokbo _score
    private Jokbo _score;
    Jokbo getScore() {
        return _score;
    }
    void setScore(Jokbo score) {
        _score = score;
    }
    // endregion

    Card getFirstCard() { return _cards.get(0); }
    Card getSecondCard() { return _cards.get(1); }

    public Card returnCard()
    {
        return _cards.pop();
    }

    @Override
    public int compareTo(CardPair o) {
        return getScore().compareTo(o.getScore());
    }

    public String getCardsInfo() {
        return getFirstCard().getCardInfo() + " / " + getSecondCard().getCardInfo() + " / " + getScore();
    }

}
