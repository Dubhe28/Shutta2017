package cardPackage;

import jokboPackage.TieJokbo;

public class TieCardPair extends CardPair{

    public TieCardPair(Card card1, Card card2) {
        super(card1, card2);
        setCardScore();
    }

    private TieJokbo _score;

    private void setScore(TieJokbo score) {
        _score = score;
    }

    private void setCardScore(){

        if(super.isGwang()){ // 광땡일때
            setScore(TieJokbo.values()[19]);
        }else if(super.isJang()){ // 장땡일때
            setScore(TieJokbo.values()[20]);
        }else if(super.isDdeng()){ // 땡 일때
            setScore(TieJokbo.values()[(calculateDdeng(getFirstCard().getNum()))]);
        }else{ //끗일때
            setScore(TieJokbo.values()[((getFirstCard().getNum()+getSecondCard().getNum())%10)]);
        }
    }

    public int compareTo(CardPair o) {
        TieCardPair tc = (TieCardPair)o;
        return _score.compareTo(tc._score);
    }

    public String getCardsInfo() {
        return getFirstCard().getCardInfo() + " / " + getSecondCard().getCardInfo() + " / " + _score;
    }
}
