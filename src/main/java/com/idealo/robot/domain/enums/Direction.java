package com.idealo.robot.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
    NORTH(0),
    EAST(90),
    SOUTH(180),
    WEST(270);

    private int value;

    private static int DEGREE0 = 0;
    private static int DEGREE90 = 90;
    private static int DEGREE180 = 180;
    private static int DEGREE360 = 360;

    private static String DIRECTION_LEFT = "LEFT";

    private static final Map<Integer, Direction> map = new HashMap<>();

    private Direction(int value) {
        this.value = value;
    }

    static {
        for (Direction direction : Direction.values()) {
            map.put(direction.value, direction);
        }
    }

    public int getValue() {
        return value;
    }

    public static Direction rotateDirection(Direction direction, String rotation) {
        int value;

        if (rotation.equals(DIRECTION_LEFT)) {
            setDegree360WhenDegreeIsO(direction);
            value = direction.getValue() - DEGREE90;
        } else {
            value = setDegree0WhenDegreeIs360(direction.getValue() + DEGREE90);
        }

        return getByValue(value);
    }

    private static int setDegree360WhenDegreeIsO(Direction direction) {
        return direction.getValue() == DEGREE0 ? (direction.value = DEGREE360) : direction.getValue();
    }

    private static int setDegree0WhenDegreeIs360(int value) {
        return value == DEGREE360 ? DEGREE0 : value;
    }

    public static Direction rotateTurnAround(Direction direction) {
        int value;
        if (isDirectionNorthOrEast(direction)) {
            value = direction.getValue() + DEGREE180;
        } else {
            value = direction.getValue() - DEGREE180;
        }
        return getByValue(value);
    }

    private static boolean isDirectionNorthOrEast(Direction direction) {
        return direction.getValue() <= DEGREE90;
    }

    public static Direction getByValue(int value) {
        return map.get(value);
    }
}
