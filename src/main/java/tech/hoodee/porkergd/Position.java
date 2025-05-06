package tech.hoodee.porkergd;

public enum Position {
    SOUTH(0),
    EAST(1),
    NORTH(2),
    WEST(3);

    private final int value;
    Position(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
