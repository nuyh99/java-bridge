package bridge.domain;

import bridge.exception.InputException;

import java.util.Arrays;

public enum Command {
    UP(1, "U"),
    DOWN(0, "D"),
    RESTART(3, "R"),
    QUIT(4, "Q"),
    ;

    private final int command;
    private final String message;

    Command(int command, String message) {
        this.command = command;
        this.message = message;
    }

    public static Command getMove(String input) {
        return Arrays.stream(Command.values())
                .filter(o->o.equals(UP) || o.equals(DOWN))
                .filter(o -> o.message.equals(input))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException(InputException.INVALID_MOVE.getMessage()));
    }

    public static Command getRestart(String input) {
        return Arrays.stream(Command.values())
                .filter(o->o.equals(RESTART) || o.equals(QUIT))
                .filter(o -> o.message.equals(input))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException(InputException.INVALID_RESTART.getMessage()));
    }

    public int getCommand() {
        return command;
    }
}
