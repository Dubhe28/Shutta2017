package cardPackage;

import jokboPackage.OriginalJokbo;

public class OriginalCardPair extends CardPair{

    public OriginalCardPair(Card card1, Card card2) {
        super(card1, card2);
        setCardScore();
    }

    private OriginalJokbo _score;
    
    private void setCardScore(){

        if(super.isGwang()){ // 광땡일때
            _score = OriginalJokbo.values()[20];
        }else if(super.isJang()){ // 장땡일때
            _score = OriginalJokbo.values()[19];
        }else if(super.isDdeng()){ // 땡 일때
            _score = OriginalJokbo.values()[(calculateDdeng(getFirstCard().getNum()))];
        }else{ //끗일때
            _score = OriginalJokbo.values()[((getFirstCard().getNum()+getSecondCard().getNum())%10)];
        }
    }

    public int compareTo(CardPair o) {
        OriginalCardPair oc = (OriginalCardPair)o;
        return _score.compareTo(oc._score);
    }

    public String getCardsInfo() {
        return getFirstCard().getCardInfo() + " / " + getSecondCard().getCardInfo() + " / " + _score;
    }
}
