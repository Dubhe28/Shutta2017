package cardPackage

class Card(val num: Int , val gwang: Boolean) {

    fun getCardInfo() : String{
            var cardInfo = "Card: No. " + num
            if (gwang)
                cardInfo += " (Gwang) "
            return cardInfo
        }
}