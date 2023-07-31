package bridge;

import bridge.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;

public final class Application {

    public static void main(String[] args) {
        new Controller(new InputView(), new OutputView(), new BridgeService());
    }
}
