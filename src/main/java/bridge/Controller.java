package bridge;

import bridge.domains.BridgeGame;
import bridge.domains.BridgeMaker;
import bridge.domains.BridgeMap;
import bridge.views.InputView;
import bridge.views.OutputView;

final public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMap bridgeMap;

    public Controller() {
        inputView = new InputView();
        outputView = new OutputView();
        this.bridgeMap = createBridge();
        startGame();
    }

    private BridgeMap createBridge() {
        BridgeMap bridgeMap = null;
        try {
            int readSize = inputView.readBridgeSize();
            bridgeMap = new BridgeMap(new BridgeMaker(), readSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createBridge();
        }
        return bridgeMap;
    }

    private void startGame() {
        BridgeGame bridgeGame = new BridgeGame(bridgeMap);
    }
}
