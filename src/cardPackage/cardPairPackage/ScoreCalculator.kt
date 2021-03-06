package cardPackage.cardPairPackage

internal object ScoreCalculator {

    private lateinit var cardPair: CardPair

    private fun isGwang() = cardPair.getFirstCard().gwang && cardPair.getSecondCard().gwang
    private fun isJang() = cardPair.getFirstCard().num == 10 && cardPair.getSecondCard().num == 10
    private fun isDdeng() = cardPair.getFirstCard().num == cardPair.getSecondCard().num
    private fun calculateDdeng(cardNumber: Int) = cardNumber + 9

    fun setCardScore(cardPair: CardPair) {
        this.cardPair = cardPair
        cardPair.score = when {
            isGwang() -> Jokbo.values()[20]
            isJang() -> Jokbo.values()[19]
            isDdeng() -> Jokbo.values()[calculateDdeng(cardPair.getFirstCard().num)]
            else -> Jokbo.values()[(cardPair.getFirstCard().num + cardPair.getSecondCard().num) % 10]
        }
    }
}
