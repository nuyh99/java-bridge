package bridge.views;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */


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
            InputChecker.validateNumeric(this, readBridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readBridgeSize = String.valueOf(readBridgeSize());
        }
        return Integer.parseInt(readBridgeSize);
    }

    public String readMoving() {
        outputView.printInputMoveDirection();
        String readDirection = Console.readLine();

        try {
            InputChecker.validateCommand(List.of(UP_COMMAND, DOWN_COMMAND), readDirection);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readDirection = readMoving();
        }
        return readDirection;
    }

    public String readGameCommand() {
        outputView.printRestartQuestion();
        String readCommand = Console.readLine();

        try {
            InputChecker.validateCommand(List.of(QUIT_COMMAND, RESTART_COMMAND), readCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readCommand = readGameCommand();
        }
        return readCommand;
    }
}
