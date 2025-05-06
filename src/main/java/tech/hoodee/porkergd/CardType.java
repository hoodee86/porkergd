package tech.hoodee.porkergd;

public enum CardType {
    SINGLE(1, "单张"),
    PAIR(2, "对子"),
    THREE(3, "三张"),
    FOUR(4, "四张"),
    STRAIGHT(5, "顺子"),
    STRAIGHT_FLUSH(6, "同花顺"),
    FULL_HOUSE(7, "三带二"),
    TRIPLE_PAIR(8, "三连对"),
    DOUBLE_TRIPLE(9, "双三连"),
    FOUR_OF_A_KIND(10, "四条"),
    FIVE_OF_A_KIND(11, "五条"),
    SIX_OF_A_KIND(12, "六条"),
    SEVEN_OF_A_KIND(13, "七条"),
    EIGHT_OF_A_KIND(14, "八条"),
    ROYAL_BOMB(15, "王炸"),
    NONE(99, "无牌");

    private final int value;
    private final String description;

    CardType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
