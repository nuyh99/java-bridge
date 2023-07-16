package bridge;

import bridge.domains.BridgeGame;
import bridge.domains.BridgeMaker;
import bridge.domains.BridgeMap;
import bridge.domains.BridgeRandomNumberGenerator;
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
        play();
    }

    private BridgeMap createBridge() {
        try {
            int readSize = inputView.readBridgeSize();
            return new BridgeMap(new BridgeMaker(new BridgeRandomNumberGenerator()), readSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createBridge();
        }
        return null;
    }

    private void play() {
        BridgeGame bridgeGame = new BridgeGame(bridgeMap);
    }
}
