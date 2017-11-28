package mainPackage

import playerPackage.Player

import java.util.Arrays

object Main {
    @JvmStatic
    fun main(args: Array<String>) {

        val players = Arrays.asList(Player(), Player())

        var isTied = false //게임시작 전 무승부 여부의 초기값 설정

        while (isRunning(players)) {
            val round = Round()
            //배팅액 받기
            Dealer.set(isTied)
            Dealer.betMoney(players)
            Dealer.pickCardPairs(players)

            round.setWinner(players)

            //배팅액분배
            Dealer.attributeMoney(players, round.winner!!)

            isTied = judgeTie(round) // 해당 게임이 무승부인지 판별
            Game.addGameRecord(round) // mainPackage.Game 클레스에 현재 round 결과 저장

            round.printRound(players) //해당 round 결과 출력

            Dealer.returnCardPairsToDeck(players)
        }

        Game.printGameRecord() // 게임의 최종 결과와 각 플레이어의 승률 정보를 출력
    }

    // 전 판이 무승부인 경우
    private fun judgeTie(round: Round): Boolean {
        return round.winner == Winner.None
    }

    //파산자가 있는지 판별
    private fun isRunning(players: List<Player>): Boolean {
        return players.stream().allMatch { player -> player.money > 0 }
    }
}
