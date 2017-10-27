package mainPackage;

import playerPackage.Player;

class Round {
    private static int _roundNum = 0; // _roundNum는 현재 라운드가 몇 번째 게임인지 나타내는 정적 변수.

    //region mainPackage.Winner _winner
    private Winner _winner; // _winner 변수는 이번 라운드에서 누가 이겼는지를 열거타입으로 저장한다.

    Winner getWinner() {
        return _winner;
    }   // getter

    void setWinner(Player p1, Player p2) {   //setter, 두 플레이어를 인자로 받아 _winner 변수에 승패를 저장한다.
        if (p1.getSuit().getScore()>p2.getSuit().getScore())    // 만약 첫 번째 플레이어가 두 번째 플레이어보다 높은 점수이면
            _winner = Winner.PlayerA;       // 첫 번째 플레이어가 승자이다.
        else if (p1.getSuit().getScore()<p2.getSuit().getScore())   // 만약 두 번째 플레이어가 첫 번째 플레이어보다 높은 점수이면
            _winner = Winner.PlayerB;       // 두 번째 플레이어가 승자이다.
        else                                // 만약 두 플레이어가 동점이면
            _winner = Winner.None;          // 승자가 없으므로 무승부이다.
        _roundNum ++;   // 승자가 결정되면 정적 변수 _roundNum 값을 하나 증가시킨다.

    }

    //endregion
    void printRound(Player p1, Player p2) {
        System.out.println("************************* " + _roundNum + "번째 게임입니다 *************************");
        System.out.println("배팅액 : " + Dealer.getInstance().getBettingMoney());  // 이번 라운드에 배팅한 금액의 총액을 출력한다.
        System.out.println("player A: " + playerInfo(p1));  // 이번 라운드에서 playerPackage A가 받은 두 카드와 라운드 진행 후 남은 금액을 출력한다.
        System.out.println("player B: " + playerInfo(p2));  // 이번 라운드에서 playerPackage B가 받은 두 카드와 라운드 진행 후 남은 금액을 출력한다.
        System.out.println("Winner: " + _winner);   // 이번 라운드의 승자를 출력한다.(PlayerA, PlayerB, 또는 None(무승부))
    }

    private String playerInfo(Player player)
    {
        return player.getPlayerCardInfo() + " / 남은금액 : " + player.getMoney(); // 해당 플레이어가 받은 두 카드와 남은 금액 정보를 출력한다.
    }
}
