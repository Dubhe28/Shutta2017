package mainPackage;

import java.util.ArrayList;

class Game {
    // region class mainPackage.Game declared as a Singleton
    private static Game instance = new Game();
    private Game() {
    }
    static Game getInstance() {
        return instance;
    }
    // endregion

    private ArrayList<Round> _rounds = new ArrayList<>();   // 각 라운드의 정보를 저장하는 ArrayList<>를 하나 생성한다.

    void addGameRecord(Round round) {
        _rounds.add(round);
    }   // Round 변수를 인자로 받아서 ArrayList<>에 저장하는 메소드이다.


    void printGameRecord()  // 최종 승자가 정해지고 게임이 완전히 끝나면 각 플레이어의 승률과 총 게임수, 최종 승자를 출력한다.
    {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println(getStringInfo());    // getStringInfo() 함수로 최종 정보를 문자열 입력받아 출력한다.
        System.out.println("--------------------------------------------------------------------------------------");
    }

    private int doStatistics(long count) { // 승수로부터 퍼센트 승률을 계산하여 반환하는 메소드이다.
        double total = _rounds.size();
        return (int)(count/total*100);
    }

    private String getStringInfo()
    {
        int count1 = doStatistics(_rounds.stream().filter(this::isWinnerA).count());
        int count2 = doStatistics(_rounds.stream().filter(this::isWinnerB).count());
        int tiedStat = 100-count1-count2; // 전체 게임 중에서 무승부였던 확률을 퍼센트로 저장한다.
        return " [ Winner: "+getFinalWinner()+" ] (total " + _rounds.size()     // 정보를 담고 있는 문자열을 반환한다.
                + " games) player A : "+ count1 + "%, player B : "+ count2
                +"%, Tied : " + tiedStat+"%";
    }

    private Winner getFinalWinner()
    {
        return _rounds.get(_rounds.size()-1).getWinner();
    }   // 최종 승자를 마지막 게임의 승자로부터 알아낸다.

    private boolean isWinnerA(Round round)
    {
        return round.getWinner() == Winner.PlayerA;
    }   // 해당 라운드에서 플레이어 A가 승리했다면 참을 반환한다.

    private boolean isWinnerB(Round round)
    {
        return round.getWinner() == Winner.PlayerB;
    }   // 해당 라운드에서 플레이어 B가 승리했다면 참을 반환한다.

}
