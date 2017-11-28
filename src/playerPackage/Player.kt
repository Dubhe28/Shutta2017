package playerPackage

import cardPackage.cardPairPackage.CardPair

class Player {

    var cardPair: CardPair? = null

    var money = 1000

    fun getPlayerCardInfo() = cardPair!!.getCardsInfo()

}
