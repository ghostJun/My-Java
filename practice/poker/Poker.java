package poker;

public class Poker {
    private static Integer[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private static String[] color = {"黑心", "红桃", "方块", "黑桃"};
    private Card[] cards;

    public Poker() {
        cards = new Card[52];
        for (int i = 0; i < color.length; i++) {
            for (int j = 0; j < num.length; j++) {
                Integer index = i * 13 + j;
                cards[index] = new Card(num[j], color[i]);
            }
        }
    }

    // 洗牌算法
    public void suffer() {
        for (int i = 0; i < cards.length; i++) {
            int index = (int) (Math.random() * cards.length);
            Card temp = cards[index];
            cards[index] = cards[i];
            cards[i] = temp;
        }
    }
}
