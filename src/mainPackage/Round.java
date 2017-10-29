package mainPackage;

import playerPackage.Player;

import java.util.List;

class Round {
    private static int _roundNum = 0; // _roundNum는 현재 라운드가 몇 번째 게임인지 나타내는 정적 변수.

    private boolean _isTied;

    //region mainPackage.Winner _winner
    private Winner _winner; // _winner 변수는 이번 라운드에서 누가 이겼는지를 열거타입으로 저장한다.

    Round(boolean isTied) {
        _isTied = isTied;
        _roundNum++;
    }

    void setWinner(List<Player> players) {
        int comparison = players.get(0).getCardPair().compareTo(players.get(1).getCardPair());
        if(comparison > 0)
            _winner = Winner.PlayerA;
        else if(comparison < 0)
            _winner = Winner.PlayerB;
        else
            _winner = Winner.None;
    }

    Winner getWinner() {
        return _winner;
    }   // getter

    //endregion
    void printRound(List<Player> players) {
        System.out.println("************************* " + _roundNum + "번째 게임입니다 *************************");
        System.out.println("배팅액 : " + Dealer.getInstance().getBettingMoney());  // 이번 라운드에 배팅한 금액의 총액을 출력한다.
        System.out.println("player A: " + playerInfo(players.get(0)));  // 이번 라운드에서 playerPackage A가 받은 두 카드와 라운드 진행 후 남은 금액을 출력한다.
        System.out.println("player B: " + playerInfo(players.get(1)));  // 이번 라운드에서 playerPackage B가 받은 두 카드와 라운드 진행 후 남은 금액을 출력한다.
        System.out.println("Winner: " + _winner);   // 이번 라운드의 승자를 출력한다.(PlayerA, PlayerB, 또는 None(무승부))
    }

    private String playerInfo(Player player)
    {
        return player.getPlayerCardInfo() + " / 남은금액 : " + player.getMoney(); // 해당 플레이어가 받은 두 카드와 남은 금액 정보를 출력한다.
    }
}
