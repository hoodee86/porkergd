package tech.hoodee.porkergd;

import java.util.List;

public class Rule {
    // 掼蛋的规则
    // 1. 牌型：单张、对子、三张、顺子、连对、飞机、炸弹
    // 2. 牌的大小：从小到大为：3,4,5,6,7,8,9,10,J,Q,K,A,2,黑桃Joker,红桃Joker
    // 3. 牌的花色：黑桃、红桃、梅花、方块
    // 4. 牌的数量：54张
    // 5. 牌的发放：每人17张，剩余3张底牌

    public static boolean check(Card[] cards) {
        return true;
    }

    public static CardType getCardType(List<Card> cards) {
        // 1. 单张
        // 2. 对子
        // 3. 三张
        // 4. 顺子
        // 5. 连对
        // 6. 飞机
        //}
        return CardType.SINGLE;
    }

}
