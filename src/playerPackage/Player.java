package playerPackage;

import cardPackage.CardPair;

public class Player{

    //region CardPair cardPair
    private CardPair cardPair;

    public CardPair getCardPair() {
        return cardPair;
    }

    public void setCardPair(CardPair cardPair) {
        this.cardPair = cardPair;
    }
    //endregion

    //region int _money, 플레이어의 현재 잔고
    private int _money = 1000;
    public int getMoney() {
        return _money;
    }
    public void setMoney(int money) {
        _money = money;
    }
    //endregion

    public String getPlayerCardInfo() // 플레이어의 카드 정보를 문자열로 반환하는 메소드.
    {
        return cardPair.getCardsInfo();
    }

}
