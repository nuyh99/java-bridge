package bridge.views;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
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

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.printInputMoveDirection();
        String readDirection = Console.readLine();
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
