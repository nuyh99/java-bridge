package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public final class InputView {

    static final String UP_COMMAND = "U";
    static final String DOWN_COMMAND = "D";
    public static final String QUIT_COMMAND = "Q";
    public static final String RESTART_COMMAND = "R";

    private final OutputView outputView;

    public InputView() {
        outputView = new OutputView();
    }

    public int readBridgeSize() {
        outputView.printInputBridgeSizeText();
        String readBridgeSize = Console.readLine();

        try {
            InputChecker.validateNumeric(readBridgeSize);
            return Integer.parseInt(readBridgeSize);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return readBridgeSize();
        }
    }

    public String readMoving() {
        outputView.printInputMoveDirection();
        String readDirection = Console.readLine();

        try {
            InputChecker.validateCommand(List.of(UP_COMMAND, DOWN_COMMAND), readDirection);
            return readDirection;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return readMoving();
        }
    }

    public String readGameCommand() {
        outputView.printRestartQuestion();
        String readCommand = Console.readLine();

        try {
            InputChecker.validateCommand(List.of(QUIT_COMMAND, RESTART_COMMAND), readCommand);
            return readCommand;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return readGameCommand();
        }

    }
}
