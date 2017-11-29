package mainPackage

import playerPackage.Player

internal class Round {

    lateinit var winner: Winner
        private set

    init {
        roundNum++
    }

    fun setWinner(players: List<Player>) {
        val comparison = players[0].cardPair.compareTo(players[1].cardPair)
        winner = when {
            comparison > 0 -> Winner.PlayerA
            comparison < 0 -> Winner.PlayerB
            else -> Winner.None
        }
    }

    fun printRound(players: List<Player>) {
        println("************************* " + roundNum + "번째 게임입니다 *************************")
        println("배팅액 : ${Dealer.bettingMoney}")  // 이번 라운드에 배팅한 금액의 총액을 출력한다.
        println("player A: ${playerInfo(players[0])}")  // 이번 라운드에서 player A가 받은 두 카드와 라운드 진행 후 남은 금액을 출력한다.
        println("player B: ${playerInfo(players[1])}")  // 이번 라운드에서 player B가 받은 두 카드와 라운드 진행 후 남은 금액을 출력한다.
        println("Winner: $winner")   // 이번 라운드의 승자를 출력한다.(PlayerA, PlayerB, 또는 None(무승부))
    }

    private fun playerInfo(player: Player) = "${player.getPlayerCardInfo()} / 남은금액 : ${player.money}" // 해당 플레이어가 받은 두 카드와 남은 금액 정보를 출력한다.

    companion object {
        private var roundNum = 0
    }
}