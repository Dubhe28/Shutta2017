package mainPackage

import cardPackage.*
import cardPackage.cardPairPackage.*
import playerPackage.Player

internal object Dealer{

    var bettingMoney = 200
        private set
    var isTied: Boolean = false

    // 각각의 플레이어의 소지금에서 배팅 금액 빼기
    fun betMoney(players: List<Player>) {
        judgeBettingMoney(isTied)
        players.forEach { player -> player.money = player.money - bettingMoney / 2 }
    }

    private fun judgeBettingMoney(isTied: Boolean) {
        if (isTied)
            bettingMoney *= 2
        else
            bettingMoney = 200
    }

    //  게임이 끝난 후 이긴 플레이어에게 배팅액 분배
    fun attributeMoney(players: List<Player>, winner: Winner) {
        val p1 = players[0]
        val p2 = players[1]
        when (winner) {
            Winner.PlayerA -> p1.money = p1.money + bettingMoney
            Winner.PlayerB -> p2.money = p2.money + bettingMoney
            else -> {
                p1.money = p1.money + bettingMoney / 2
                p2.money = p2.money + bettingMoney / 2
            }
        }
    }

    fun pickCardPairs(players: List<Player>)   // 딜러가 플레이어 두 명에게 각각 카드를 두 장씩 나누어준다.
    {
        Deck.shuffleCards()
        players.forEach { player: Player -> setPlayerCards(player) }
    }

    private fun setPlayerCards(player: Player) {
        player.cardPair = if (isTied)
            TieCardPair(Deck.getCardFromDeck(), Deck.getCardFromDeck())
        else
            OriginalCardPair(Deck.getCardFromDeck(), Deck.getCardFromDeck())
    }

    fun returnCardPairsToDeck(players: List<Player>) {
        players.forEach{player: Player -> returnCardPair(player) }
    }

    private fun returnCardPair(player: Player) {
        for (i in 0..1) {
            Deck.recoverCard(player.cardPair.returnCard())
        }
    }
}
