package mainPackage

import java.util.ArrayList

internal object Game {

    private val roundList = ArrayList<Round>()   // 각 라운드의 정보를 저장하는 ArrayList<>를 하나 생성한다.

    private val stringInfo: String
        get() {
            val count1 = doStatistics(roundList.stream().filter({ this.isWinnerA(it) }).count())
            val count2 = doStatistics(roundList.stream().filter({ this.isWinnerB(it) }).count())
            val tiedStat = 100 - count1 - count2
            return (" [ Winner: " + finalWinner + " ] (total " + roundList.size
                    + " games) player A : " + count1 + "%, player B : " + count2
                    + "%, Tied : " + tiedStat + "%")
        }

    private val finalWinner: Winner
        get() = roundList[roundList.size - 1].winner!!   // 최종 승자를 마지막 게임의 승자로부터 알아낸다.

    fun addGameRecord(round: Round) {
        roundList.add(round)
    }   // Round 변수를 인자로 받아서 ArrayList<>에 저장하는 메소드이다.


    fun printGameRecord()  // 최종 승자가 정해지고 게임이 완전히 끝나면 각 플레이어의 승률과 총 게임수, 최종 승자를 출력한다.
    {
        println("--------------------------------------------------------------------------------------")
        println(stringInfo)    // getStringInfo() 함수로 최종 정보를 문자열 입력받아 출력한다.
        println("--------------------------------------------------------------------------------------")
    }

    private fun doStatistics(count: Long): Int { // 승수로부터 퍼센트 승률을 계산하여 반환하는 메소드이다.
        val total = roundList.size.toDouble()
        return (count / total * 100).toInt()
    }

    private fun isWinnerA(round: Round): Boolean {
        return round.winner == Winner.PlayerA
    }   // 해당 라운드에서 플레이어 A가 승리했다면 참을 반환한다.

    private fun isWinnerB(round: Round): Boolean {
        return round.winner == Winner.PlayerB
    }   // 해당 라운드에서 플레이어 B가 승리했다면 참을 반환한다.

}
