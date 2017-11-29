package playerPackage

import cardPackage.cardPairPackage.CardPair

class Player {

    lateinit var cardPair: CardPair

    var money = 1000

    fun getPlayerCardInfo() = cardPair.getCardsInfo()

}
