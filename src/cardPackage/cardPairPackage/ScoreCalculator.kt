package cardPackage.cardPairPackage

internal object ScoreCalculator {

    private var cardPair: CardPair? = null

    private fun isGwang() = cardPair!!.firstCard.gwang && cardPair!!.secondCard.gwang
    private fun isJang() = cardPair!!.firstCard.num == 10 && cardPair!!.secondCard.num == 10
    private fun isDdeng() = cardPair!!.firstCard.num == cardPair!!.secondCard.num

    fun setCardScore(cardPair: CardPair) {
        this.cardPair = cardPair
        cardPair.score = when {
            isGwang() -> // 광땡일때
                Jokbo.values()[20]
            isJang() -> // 장땡일때
                Jokbo.values()[19]
            isDdeng() -> // 땡 일때
                Jokbo.values()[calculateDdeng(cardPair.firstCard.num)]
            else -> //끗일때
                Jokbo.values()[(cardPair.firstCard.num + cardPair.secondCard.num) % 10]
        }
    }

    private fun calculateDdeng(cardNumber: Int) = cardNumber + 9
}
