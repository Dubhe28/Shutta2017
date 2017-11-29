package mainPackage

import java.util.ArrayList

internal object Game {

    private val roundList = ArrayList<Round>()

    private val finalWinner: Winner
        get() = roundList[roundList.size - 1].winner

    fun addGameRecord(round: Round) {
        roundList.add(round)
    }

    fun printGameRecord()
    {
        println("--------------------------------------------------------------------------------------")
        println(getStringInfo())    // getStringInfo() 함수로 최종 정보를 문자열 입력받아 출력한다.
        println("--------------------------------------------------------------------------------------")
    }

    private fun getStringInfo() : String{
        val count1 = doStatistics(roundList.count{round -> round.winner == Winner.PlayerA})
        val count2 = doStatistics(roundList.count{round -> round.winner == Winner.PlayerB})
        val tiedStat = 100 - count1 - count2
        return (" [ Winner: $finalWinner ] (total ${roundList.size} games) player A : $count1%, player B : $count2%, Tied : $tiedStat%")
    }

    private fun doStatistics(count: Int): Int {
        val total = roundList.size.toDouble()
        return (count / total * 100).toInt()
    }
}