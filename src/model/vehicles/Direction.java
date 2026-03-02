package src.model.vehicles;

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

    public Direction opposite() {
        return values()[(this.ordinal() + 2) % values().length];
    }
}
