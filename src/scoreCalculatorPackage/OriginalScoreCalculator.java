package scoreCalculatorPackage;
import cardPackage.Suit;

public class OriginalScoreCalculator implements IScoreCalculator {

    private Suit _suit;

    public void calculateScore(Suit suit){

        _suit = suit;

        if(isGwang()){ // 광땡일때
            suit.setScore(21);
        }else if(isJang()){ // 장땡일때
            suit.setScore(20);
        }else if(isDdeng()){ // 땡 일때
            suit.setScore(calculateDdeng(_suit.getFirstCard().getNum()));
        }else{ //끗일때
            suit.setScore((_suit.getFirstCard().getNum()+_suit.getSecondCard().getNum())%10);
        }
    }
    private boolean isGwang(){ // 광땡일 때 true return
        return _suit.getFirstCard().getGwang() && _suit.getSecondCard().getGwang();
    }
    private boolean isJang(){ // 장땡일때 true return
        return _suit.getFirstCard().getNum() == 10 && _suit.getSecondCard().getNum() == 10;
    }
    private boolean isDdeng(){ // 땡일때 true return
        return _suit.getFirstCard().getNum() == _suit.getSecondCard().getNum();
    }
    private int calculateDdeng(int cardNumber1){ //땡일 때 점수 계산
        return cardNumber1+9;
    }
}
