package cardPackage.cardPairPackage

import cardPackage.Card

import java.util.Stack

abstract class CardPair internal constructor(card1: Card, card2: Card) : Comparable<CardPair> {

    private val _cards: Stack<Card> = Stack()

    internal var score: Jokbo? = null

    internal val firstCard: Card
        get() = _cards[0]
    internal val secondCard: Card
        get() = _cards[1]

    fun getCardsInfo() = firstCard.getCardInfo() + " / " + secondCard.getCardInfo() + " / " + score

    init {
        _cards.add(card1)
        _cards.add(card2)
        ScoreCalculator.setCardScore(this)
    }

    fun returnCard(): Card {
        return _cards.pop()
    }

    override fun compareTo(other: CardPair): Int {
        return score!!.compareTo(other.score!!)
    }

}
