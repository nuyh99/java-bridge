package bridge.views;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */


final public class InputView {

    private static final String UP_COMMAND = "U";
    private static final String DOWN_COMMAND = "D";
    private static final String QUIT_COMMAND = "Q";
    private static final String RESTART_COMMAND = "R";

    private final OutputView outputView;

    public InputView() {
        outputView = new OutputView();
    }

    public int readBridgeSize() {
        outputView.printInputBridgeSizeText();

        String readBridgeSize = Console.readLine();
        InputChecker.validateNumeric(this, readBridgeSize);

        return Integer.parseInt(readBridgeSize);
    }

    public String readMoving() {
        outputView.printInputMoveDirection();
        String readDirection = Console.readLine();
        InputChecker.validateKeyword(List.of(UP_COMMAND, DOWN_COMMAND), readDirection);
        return readDirection;
    }

    public String readGameCommand() {
        outputView.printRestartQuestion();
        String readCommand = Console.readLine();
        InputChecker.validateKeyword(List.of(QUIT_COMMAND, RESTART_COMMAND), readCommand);
        return readCommand;
    }
}
