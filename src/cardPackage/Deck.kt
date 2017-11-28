package cardPackage

import java.util.Collections
import java.util.Stack

object Deck {

    private val deck: Stack<Card> = Stack()

    init {
        (0..19).mapTo(deck) { convertIntToCard(it) }
    }

    private fun convertIntToCard(index: Int) = Card(getCardNum(index), getIsCardGwang(index))

    private fun getCardNum(index: Int) = index % 10 + 1

    private fun getIsCardGwang(index: Int)  =  listOf(1, 3, 8) .contains(index + 1)

    fun getCardFromDeck() = deck.pop()!!

    fun shuffleCards() {
        Collections.shuffle(deck)
    }

    fun recoverCard(card: Card) {
        deck.push(card)
    }
}