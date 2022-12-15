package bridge.configuration;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.BridgeController;
import bridge.domain.Bridge;
import bridge.domain.User;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class AppConfig {

    public static BridgeController init() {
        BridgeController bridgeController = new BridgeController(
                new InputView(),
                new OutputView(),
                bridgeGame()
        );

        bridgeController.makeBridge();
        return bridgeController;
    }

    private static BridgeGame bridgeGame() {
        return new BridgeGame(
                new BridgeMaker(new BridgeRandomNumberGenerator()),
                new Bridge(),
                new User()
        );
    }
}
