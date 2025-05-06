package tech.hoodee.porkergd;

public enum Position {
    EAST(0),
    NORTH(1),
    WEST(2),
    SOUTH(3);

    private final int value;
    Position(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
