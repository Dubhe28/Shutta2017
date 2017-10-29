package mainPackage;

import playerPackage.Player;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Player> players = Arrays.asList(new Player(), new Player());

        boolean isTied = false; //게임시작 전 무승부 여부의 초기값 설정

        while(isRunning(players)) {
            Round round = new Round(isTied);
            //배팅액 받기
            Dealer.getInstance().set(isTied);
            Dealer.getInstance().betMoney(players);
            Dealer.getInstance().pickCardPairs(players);

            round.setWinner(players);

            //배팅액분배
            Dealer.getInstance().attributeMoney(players, round.getWinner());

            isTied = judgeTie(round); // 해당 게임이 무승부인지 판별
            Game.getInstance().addGameRecord(round); // mainPackage.Game 클레스에 현재 round 결과 저장

            round.printRound(players); //해당 round 결과 출력

            Dealer.getInstance().returnCardPairsToDeck(players);
        }

        Game.getInstance().printGameRecord(); // 게임의 최종 결과와 각 플레이어의 승률 정보를 출력
    }
    // 전 판이 무승부인 경우
    private static boolean judgeTie(Round round){
        return round.getWinner() == Winner.None;
    }
    //파산자가 있는지 판별
    private static boolean isRunning(List<Player> players){
        return players.stream().allMatch(player -> player.getMoney() > 0);
    }
}
