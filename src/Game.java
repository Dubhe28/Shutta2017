import playerPackage.Player;
import scoreCalculatorPackage.IScoreCalculator;

import java.util.ArrayList;

class Game {
    // region class Game declared as a Singleton
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
    }   // ROUND 변수를 인자로 받아서 ArrayList<>에 저장하는 메소드이다.

    // 게임의 점수 계산 방법을 두 가지 방법으로 구현하기 위해 Strategy 디자인 패턴을 사용하였다.
    private IScoreCalculator _scoreCalculator;

    void setStrategy(IScoreCalculator value)
    {
        _scoreCalculator = value;
    }

    void calculate(Player p)
    {
        _scoreCalculator.calculateScore(p);
    }


    void printGameRecord()  // 최종 승자가 정해지고 게임이 완전히 끝나면 각 플레이어의 승률과 총 게임수, 최종 승자를 출력한다.
    {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println(getStringInfo());    // getStringInfo() 함수로 최종 정보를 문자열 입력받아 출력한다.
        System.out.println("--------------------------------------------------------------------------------------");
    }

    private String getStringInfo()
    {
        int[] statistics = doStatistics(); // scoresInfo 배열에 각 플레이어의 승률을 퍼센트로 저장한다.
        int tiedStat = 100-statistics[0]-statistics[1]; // 전체 게임 중에서 무승부였던 확률을 퍼센트로 저장한다.
        return " [ Winner: "+getFinalWinner()+" ] (total " + getRoundsSize()                // 정보를 담고 있는 문자열 반환한다.
                + " games) playerPackage A : "+ statistics[0] + "%, playerPackage B : "+ statistics[1]
                +"%, Tied : " + tiedStat+"%";
    }

    private Winner getFinalWinner()
    {
        return _rounds.get(_rounds.size()-1).getWinner();
    }   // 최종 승자를 마지막 게임의 승자로부터 알아낸다.

    private int getRoundsSize()
    {
        return _rounds.size();
    } // 총 게임수를 반환하는 메소드이다.

    private int[] doStatistics()
    {
        int[] scoresInfoArray = createScoresInfoArray();    // scoresInfo 배열에 각 플레이어의 승리 횟수를 저장한다.
        doStatistics(scoresInfoArray);  // 각 플레이어의 승리 횟수를 퍼센트 승률로 저장한다.
        return scoresInfoArray; // 각 플레이어의 승률을 반환한다.
    }

    private int[] createScoresInfoArray() {
        int[] scoresInfo = new int[]{0,0};  // 모든 원소를 0으로 초기화한 int 배열을 하나 생성한다.
        for (Round round : _rounds) {   // 모든 라운드 정보를 순회하면서
            if(isWinnerA(round))    // 만약 해당 라운드에서 플레이어 A가 승리했다면
                scoresInfo[0]++;    // 배열의 첫 번째 원소에 1을 더한다.
            else if(isWinnerB(round))   // 만약 해당 라운드에서 플레이어 B가 승리했다면
                scoresInfo[1]++;    // 배열의 두 번째 원소에 1을 더한다.
        }
        return scoresInfo;  // 각 플레이어의 승리 횟수를 저장한 배열을 반환한다.
    }

    private boolean isWinnerA(Round round)
    {
        return round.getWinner() == Winner.PlayerA;
    }   // 해당 라운드에서 플레이어 A가 승리했다면 참을 반환한다.

    private boolean isWinnerB(Round round)
    {
        return round.getWinner() == Winner.PlayerB;
    }   // 해당 라운드에서 플레이어 B가 승리했다면 참을 반환한다.

    private void doStatistics(int[] statistics) {
        double total = getRoundsSize(); // 전체 게임 수를 실수형 변수에 저장한다.
        statistics[0] = (int)(statistics[0]/total*100); // 플레이어 A의 승률을 퍼센트로 저장한다.
        statistics[1] = (int)(statistics[1]/total*100); // 플레이어 B의 승률을 퍼센트로 저장한다.
    }
}
