package bridge;

import bridge.configuration.AppConfig;
import bridge.controller.BridgeController;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = AppConfig.init();

        while(true){
            bridgeController.move();
            if(bridgeController.isWin())
                break;
            if(bridgeController.isGameOver() && !bridgeController.retry())
                break;
        }
        bridgeController.result();
    }
}
