package cardPackage

class Card(val num: Int , val gwang: Boolean) {

    /**
     * 카드의 정보를 문자열로 반환. 각 라운드에서 카드의 정보를 출력할 때 사용한다.
     */
    fun getCardInfo() : String{
            var cardInfo = "Card: No. " + num
            if (gwang)
                cardInfo += " (Gwang) "
            return cardInfo
        }
}