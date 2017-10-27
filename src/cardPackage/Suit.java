package cardPackage;
import java.util.Stack;

public class Suit {

    private Stack<Card> _cardPair;

    public Suit(Card card1, Card card2) {
        _cardPair = new Stack<>();
        _cardPair.add(card1);
        _cardPair.add(card2);
        setScore();
    }

    //region Jokbo _score
    private Jokbo _score;

    public Jokbo getScore() {
        return _score;
    }
    //endregion

    private Card getFirstCard()
    {
        return _cardPair.get(0);
    }
    private Card getSecondCard() { return _cardPair.get(1); }

    private void setScore(){

        if(isGwang()){ // 광땡일때
            _score = Jokbo.광땡;
        }else if(isJang()){ // 장땡일때
            _score = Jokbo.장땡;
        }else if(isDdeng()){ // 땡 일때
           _score = Jokbo.values()[(calculateDdeng(getFirstCard().getNum()))];
        }else{ //끗일때
            _score = Jokbo.values()[((getFirstCard().getNum()+getSecondCard().getNum())%10)];
        }
    }
    private boolean isGwang(){ // 광땡일 때 true return
        return getFirstCard().getGwang() && getSecondCard().getGwang();
    }
    private boolean isJang(){ // 장땡일때 true return
        return getFirstCard().getNum() == 10 && getSecondCard().getNum() == 10;
    }
    private boolean isDdeng(){ // 땡일때 true return
        return getFirstCard().getNum() == getSecondCard().getNum();
    }
    private int calculateDdeng(int cardNumber1){ //땡일 때 점수 계산
        return cardNumber1+9;
    }

    public Card returnCard()
    {
        return _cardPair.pop();
    }
}
