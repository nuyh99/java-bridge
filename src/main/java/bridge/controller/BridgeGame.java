package bridge.controller;

import bridge.BridgeMaker;
import bridge.domain.Bridge;
import bridge.domain.GameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int currentStage = -1;
    private int attempts = 1;

    private Bridge bridge;
    private Bridge user;

    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGame(BridgeMaker bridgeMaker, InputView inputView, OutputView outputView) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void readBridgeSize() {
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);

        this.bridge = new Bridge(bridge, size);
        this.user = new Bridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        user.moveNext(inputView.readMoving());
        currentStage++;

        System.out.println(getPrintMap());
    }

    public GameStatus currentStatus() {
        if (!user.isCorrectLastElement(this.bridge, currentStage))
            return GameStatus.OVER;

        if (currentStage + 1 == bridge.getSize())
            return over(GameStatus.WIN);

        return GameStatus.CONTINUE;
    }

    private GameStatus over(GameStatus gameStatus) {
        outputView.printResult(attempts, getPrintMap(), gameStatus);

        return gameStatus;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameStatus retry() {
        if (inputView.readGameCommand().equals("Q"))
            return over(GameStatus.OVER);

        currentStage = -1;
        attempts++;
        user = new Bridge(bridge.getSize());

        return GameStatus.CONTINUE;
    }

    private String getPrintMap() {
        return outputView.printMap(
                bridge.matchAnswer(user, currentStage),
                user.getBridge());
    }
}
