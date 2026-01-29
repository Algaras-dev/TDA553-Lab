package src;
public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction rotateRight() {
        return values()[(this.ordinal() + 1) % values().length];
    }

    public Direction rotateLeft() {
        // Adds a full rotation to avoid negative indices
        return values()[(this.ordinal() - 1 + values().length) % values().length];
    }
}
