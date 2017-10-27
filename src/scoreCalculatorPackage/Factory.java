package scoreCalculatorPackage;

import cardPackage.Suit;

public class Factory {

    private static Factory instance = new Factory();

    private Factory() {
    }

    public static Factory getInstance() {
        return instance;
    }
    // 게임의 점수 계산 방법을 두 가지 방법으로 구현하기 위해 Strategy 디자인 패턴을 사용하였다.
    private IScoreCalculator _scoreCalculator;

    public void setStrategy(IScoreCalculator value)
    {
        _scoreCalculator = value;
    }

    public void calculate(Suit suit)
    {
        _scoreCalculator.calculateScore(suit);
    }

}
