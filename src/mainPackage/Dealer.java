package mainPackage;
import cardPackage.*;
import playerPackage.Player;

import java.util.List;

class Dealer {

    // region class mainPackage.Dealer declared as a Singleton
    private static Dealer instance = new Dealer();
    private Dealer() {}
    static Dealer getInstance() {
        return instance;
    }
    //endregion

    //region int _bettingMoney
    private int _bettingMoney=200;
    private boolean _isTied;
    int getBettingMoney() {
        return _bettingMoney;
    }
    //endregion

    // 각각의 플레이어의 소지금에서 배팅 금액 빼기
    void betMoney(List<Player> players){
        judgeBettingMoney(_isTied);
        players.forEach(player -> player.setMoney(player.getMoney()-_bettingMoney/2));
    }
    // 전 판이 무승부인 경우
    private void judgeBettingMoney(boolean tie){
        if(tie)
            _bettingMoney = _bettingMoney * 2;
        else
            _bettingMoney = 200;
    }

    //  게임이 끝난 후 이긴 플레이어에게 배팅액 분배
    void attributeMoney(List<Player> players, Winner winner){
        Player p1 = players.get(0);
        Player p2 = players.get(1);
        if(winner == Winner.PlayerA)
            p1.setMoney(p1.getMoney() + _bettingMoney);
        else if (winner == Winner.PlayerB)
            p2.setMoney(p2.getMoney() + _bettingMoney);
        else{
            p1.setMoney(p1.getMoney()+_bettingMoney/2);
            p2.setMoney(p2.getMoney()+_bettingMoney/2);
        }
    }

    void pickCardPairs(List<Player> players)   // 딜러가 플레이어 두 명에게 각각 카드를 두 장씩 나누어준다.
    {
        Deck.getInstance().shuffleCards();
        players.forEach(this::setPlayerCards);
    }

    private void setPlayerCards(Player player)
    {
        player.setCardPair(getRandCardPair());
    }

    private CardPair getRandCardPair()
    {
        if(_isTied)
            return new TieCardPair(Deck.getInstance().getCardFromDeck(), Deck.getInstance().getCardFromDeck());
        else
            return new OriginalCardPair(Deck.getInstance().getCardFromDeck(), Deck.getInstance().getCardFromDeck());
    }

    void returnCardPairsToDeck(List<Player> players) {
        players.forEach(this::returnCardPair);
    }

    private void returnCardPair(Player player)
    {
        for (int i = 0; i < 2; i++) {
            Deck.getInstance().recoverCard(player.getCardPair().returnCard());
        }
    }

    void set(boolean isTied) {
        _isTied = isTied;
    }
}
