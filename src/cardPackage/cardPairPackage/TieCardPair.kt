package cardPackage.cardPairPackage

import cardPackage.Card

class TieCardPair(card1: Card, card2: Card) : CardPair(card1, card2) {

    override fun compareTo(other: CardPair): Int {
        return if (listOf(score, other.score).containsAll(listOf(Jokbo.광땡, Jokbo.장땡)))
            -score!!.compareTo(other.score!!)
        else
            score!!.compareTo(other.score!!)
    }

}
