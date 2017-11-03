package cardPackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck {

    private static Deck instance = new Deck();

    private Deck() {
        _deck = new Stack<>();
        for (int index=0; index<20 ;index++)
            _deck.add(convertIntToCard(index));
    }

    public static Deck getInstance() {
        return instance;
    }

    private Stack<Card> _deck;

    public Card getCardFromDeck()
    {
        return _deck.pop();
    }

    private Card convertIntToCard(int index) {    // 0~19까지의 숫자를 카드로 반환하는 메소드이다.
        return new Card(getCardNum(index), getIsCardGwang(index));                           // 카드를 반환한다.
    }

    private int getCardNum(int index) // 0~19의 숫자를 인자로 받아서 1~10의 숫자로 반환하는 메소드이다.
    {
        return index%10+1;    // 0~9까지는 1을 더해 1~10으로 반환되고, 10~19는 1~10으로 반환된다.
    }

    private boolean getIsCardGwang(int index)    // 0~19의 숫자를 인자로 받아서 해당 카드가 광인지 아닌지 여부를 반환한다.
    {
        List<Integer> list = Arrays.asList(1, 3, 8); // 카드번호가 1, 3, 8인 카드 하나씩만 광을 가지고 있다.
        return list.stream().anyMatch(integer -> integer == index + 1);
    }

    public void shuffleCards()
    {
        Collections.shuffle(_deck);
    }

    public void recoverCard(Card card) {
        _deck.push(card);
    }
}