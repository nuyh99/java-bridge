package bridge.domain;

import bridge.exception.InputException;

import java.util.Arrays;

public enum Command {
    UP(1, "U"),
    DOWN(0, "D"),
    ;

    private final int command;
    private final String message;

    Command(int command, String message) {
        this.command = command;
        this.message = message;
    }

    public static Command validateInput(String input) {
        return Arrays.stream(Command.values())
                .filter(o -> input.equals(UP.message) || input.equals(DOWN.message))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException(InputException.INVALID_MOVE.getMessage()));
    }

    public int getCommand() {
        return command;
    }
}
