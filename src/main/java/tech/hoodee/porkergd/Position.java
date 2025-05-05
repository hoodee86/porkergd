package tech.hoodee.porkergd;

public enum Position {
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    private final int position;
    Position(int position) {
        this.position = position;
    }
    public int getPosition() {
        return position;
    }
}
