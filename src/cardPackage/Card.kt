package cardPackage

class Card(val num: Int , val gwang: Boolean) {

    fun getCardInfo() = if (gwang)
        "Card: No. $num (Gwang) "
    else
        "Card: No. $num "
}