package mainPackage;
import cardPackage.Suit;
import cardPackage.Deck;
import playerPackage.Player;
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
    int getBettingMoney() {
        return _bettingMoney;
    }
    //endregion

    // 각각의 플레이어의 소지금에서 배팅 금액 빼기
    void betMoney(Player p1 , Player p2, boolean tie){
        judgeBettingMoney(tie);
        p1.setMoney(p1.getMoney() - _bettingMoney /2);
        p2.setMoney(p2.getMoney() - _bettingMoney /2);
    }
    // 전 판이 무승부인 경우
    private void judgeBettingMoney(boolean tie){
        if(tie)
            _bettingMoney = _bettingMoney * 2;
        else
            _bettingMoney = 200;
    }

    //  게임이 끝난 후 이긴 플레이어에게 배팅액 분배
    void attributeMoney(Player p1, Player p2, Winner winner){
        if(winner == Winner.PlayerA)
            p1.setMoney(p1.getMoney() + _bettingMoney);
        else if (winner == Winner.PlayerB)
            p2.setMoney(p2.getMoney() + _bettingMoney);
        else{
            p1.setMoney(p1.getMoney()+_bettingMoney/2);
            p2.setMoney(p2.getMoney()+_bettingMoney/2);
        }
    }

    void pickCardPairs(Player p1, Player p2)   // 딜러가 플레이어 두 명에게 각각 카드를 두 장씩 나누어준다.
    {
        Deck.getInstance().shuffleCards();
        // 새로 추가된 숫자에 해당하는 카드 두 개를 덱에서 가져와 저장한다.
        setPlayerCards(p1);
        setPlayerCards(p2);
    }

    private void setPlayerCards(Player player) // 플레이어 내부에 카드 두 장을 저장하는 메소드이다.
    {
        player.setSuit(getRandCardPair());
    }

    private Suit getRandCardPair()
    {
        return new Suit(Deck.getInstance().getCardFromDeck(), Deck.getInstance().getCardFromDeck());
    }

    public void returnCardPairsToDeck(Player p1, Player p2) {
        returnCardPair(p1);
        returnCardPair(p2);
    }

    public void returnCardPair(Player player)
    {
        Deck.getInstance().recoverCard(player.getSuit().returnCard());
        Deck.getInstance().recoverCard(player.getSuit().returnCard());
    }
}
