package bridge.domain;

public enum Command {
    UP(1, "U"),
    DOWN(0, "D"),;

    private final int command;
    private final String message;

    Command(int command, String message) {
        this.command = command;
        this.message = message;
    }
}
