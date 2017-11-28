package cardPackage

import java.util.Arrays
import java.util.Collections
import java.util.Stack

object Deck {

    private val deck: Stack<Card> = Stack()

    init {
        (0..19).mapTo(deck) { convertIntToCard(it) }
    }

    private fun convertIntToCard(index: Int): Card {    // 0~19까지의 숫자를 카드로 반환하는 메소드이다.
        return Card(getCardNum(index), getIsCardGwang(index))                           // 카드를 반환한다.
    }

    private fun getCardNum(index: Int) // 0~19의 숫자를 인자로 받아서 1~10의 숫자로 반환하는 메소드이다.
            : Int {
        return index % 10 + 1    // 0~9까지는 1을 더해 1~10으로 반환되고, 10~19는 1~10으로 반환된다.
    }

    private fun getIsCardGwang(index: Int)    // 0~19의 숫자를 인자로 받아서 해당 카드가 광인지 아닌지 여부를 반환한다.
            : Boolean {
        val list = Arrays.asList(1, 3, 8) // 카드번호가 1, 3, 8인 카드 하나씩만 광을 가지고 있다.
        return list.stream().anyMatch { integer -> integer == index + 1 }
    }

    fun getCardFromDeck() = deck.pop()!!

    fun shuffleCards() {
        Collections.shuffle(deck)
    }

    fun recoverCard(card: Card) {
        deck.push(card)
    }
}