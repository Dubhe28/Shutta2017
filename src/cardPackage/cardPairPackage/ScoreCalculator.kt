package cardPackage.cardPairPackage

internal object ScoreCalculator {

    private var cardPair: CardPair? = null

    private// 광땡일 때 true return
    val isGwang: Boolean
        get() = cardPair!!.firstCard.gwang && cardPair!!.secondCard.gwang
    private// 장땡일때 true return
    val isJang: Boolean
        get() = cardPair!!.firstCard.num == 10 && cardPair!!.secondCard.num == 10
    private// 땡일때 true return
    val isDdeng: Boolean
        get() = cardPair!!.firstCard.num == cardPair!!.secondCard.num

    fun setCardScore(cardPair: CardPair) {
        this.cardPair = cardPair
        if (isGwang) { // 광땡일때
            cardPair.score =Jokbo.values()[20]
        } else if (isJang) { // 장땡일때
            cardPair.score = Jokbo.values()[19]
        } else if (isDdeng) { // 땡 일때
            cardPair.score = Jokbo.values()[calculateDdeng(cardPair.firstCard.num)]
        } else { //끗일때
            cardPair.score = Jokbo.values()[(cardPair.firstCard.num + cardPair.secondCard.num) % 10]
        }
    }

    private fun calculateDdeng(cardNumber: Int): Int { //땡일 때 점수 계산
        return cardNumber + 9
    }
}
