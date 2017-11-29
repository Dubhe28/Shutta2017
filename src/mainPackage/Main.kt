package mainPackage

import playerPackage.Player

object Main {
    @JvmStatic
    fun main(args: Array<String>) {

        val players = listOf(Player(), Player())

        var isTied = false //게임시작 전 무승부 여부의 초기값 설정

        while (isRunning(players)) {
            val round = Round()

            Dealer.isTied = isTied
            Dealer.betMoney(players)
            Dealer.pickCardPairs(players)

            round.setWinner(players)
            Dealer.attributeMoney(players, round.winner)

            round.printRound(players)
            Game.addGameRecord(round)

            Dealer.returnCardPairsToDeck(players)
            isTied = judgeTie(round)
        }

        Game.printGameRecord()
    }

    private fun judgeTie(round: Round) = round.winner == Winner.None

    private fun isRunning(players: List<Player>) = players.all { player -> player.money > 0 }

}
